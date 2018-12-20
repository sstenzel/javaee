package pl.sstenzel.ug.javaee.florists.ejbjpa.service;

import pl.sstenzel.ug.javaee.florists.ejbjpa.domain.Flower;
import pl.sstenzel.ug.javaee.florists.ejbjpa.domain.Person;
import pl.sstenzel.ug.javaee.florists.ejbjpa.service.FlowerService;
import pl.sstenzel.ug.javaee.florists.ejbjpa.service.PersonService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

/*
 *  localhost:8080/florists/api/flower/test
 */

@Path("flower")
@Stateless
public class FlowerRESTService {

    // 400 bad request
    // 404 source not found

    // 200 ok
    // 201 created
    // 202 accepted
    // 204 no content

    //we Flower Service dodajemy @Stateless

    @Inject
    FlowerService flowerService;
    @Inject
    PersonService ps;

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "REST API dziala!";
    }


    @GET
    @Path("/{flowerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFlower(@PathParam("flowerId") long id) {
        Flower flower = flowerService.getFlower(id);
        if (flower != null)
            return Response.status(200).entity(flower).build();
        return Response.status(204).entity("Flower not found").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllFlowers() {
        Collection<Flower> flowers = flowerService.getAllFlowers();
        if (flowers.size() > 0)
            return Response.status(200).entity(flowers).build();
        return Response.status(204).entity("Flowers not found").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addFlower(Flower flower) {
        // tutaj mozna zmienic wartosci flowera

        flowerService.addFlower(flower);     // <-- zob FlowerSerwice
        // tutaj juz nie, bo kwiat zostal utrwalomy
        return Response.status(201).entity("add flower").build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateFlower(Flower flower) {
        Flower flow = flowerService.updateFlower(flower);
        if (flow != null)
            return Response.status(201).entity(flow).build();
        return Response.status(204).entity("Flowers not found").build();
    }


    @DELETE
    public Response deleteAllFlowers() {
        flowerService.deleteAllFlowers();
        return Response.status(200).build();
    }

    @DELETE
    @Path("/{flowerId}")
    public Response deleteFlower(@PathParam("flowerId") long id) {
        flowerService.deleteFlower(id);
        return Response.status(200).build();
    }


    @PUT
    @Path("/{flowerId}/addwaterman")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addWaterman(@PathParam("flowerId") long id, Person person) {
        Flower flower = flowerService.getFlower(id);
        if (flower == null)
            return Response.status(204).entity("Flower not found").build();

        flower.addWaterman(person);
        person.addFlower(flower);

        ps.addPerson(person);
        flowerService.updateFlower(flower);

        return Response.status(200).entity("add waterman to flower").build();
    }

    @PUT
    @Path("/{flowerId}/addwaterman/{personId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addWaterman(@PathParam("flowerId") long flowerId, @PathParam("personId") long personId) {
        Flower flower = flowerService.getFlower(flowerId);
        Person person = ps.getPerson(personId);

        if (flower == null )
            return Response.status(204).entity("Flower/person not found").build();


        flower.addWaterman(person);
        person.addFlower(flower);

        flowerService.updateFlower(flower);
        ps.updatePerson(person);

        return Response.status(200).entity("added waterman to flower").build();
    }


}