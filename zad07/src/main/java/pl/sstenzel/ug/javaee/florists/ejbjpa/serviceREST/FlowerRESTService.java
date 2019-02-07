package pl.sstenzel.ug.javaee.florists.ejbjpa.serviceREST;

import com.fasterxml.jackson.annotation.JsonView;
import pl.sstenzel.ug.javaee.florists.ejbjpa.domain.Card;
import pl.sstenzel.ug.javaee.florists.ejbjpa.domain.Flower;
import pl.sstenzel.ug.javaee.florists.ejbjpa.domain.Person;
import pl.sstenzel.ug.javaee.florists.ejbjpa.service.FlowerService;
import pl.sstenzel.ug.javaee.florists.ejbjpa.JSONView.View;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.sql.Date;

/*
      localhost:8080/florists/api/flower/test
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

    @Inject
    FlowerService flowerService;


    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "REST API dziala!";
    }


    @GET
    @Path("/{flowerId}")
    @Produces(MediaType.APPLICATION_JSON)
    @JsonView(View.FlowerRealtions.class)
    public Response getFlower(@PathParam("flowerId") long id) {
        Flower flower = flowerService.getFlower(id);
        if (flower != null)
            return Response.status(200).entity(flower).build();
        return Response.status(204).entity("Flower not found").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @JsonView(View.FlowerRealtions.class)
    public Response getAllFlowers() {
        Collection<Flower> flowers = flowerService.getAllFlowers();
        return Response.status(200).entity(flowers).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addFlower(Flower flower) {
        flowerService.addFlower(flower);
        return Response.status(201).entity("add flower").build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateFlower(Flower flower) {
        Flower flow = flowerService.updateFlower(flower);
        return Response.status(201).entity(flow).build();
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
    public Response addWaterman(
            @PathParam("flowerId") long flowerId, Person person) {
        if (!flowerService.addWaterman(flowerId, person))
            return Response.status(204).entity("Flower not found").build();
        return Response.status(200).entity("added waterman to flower").build();
    }

    @PUT
    @Path("/{flowerId}/removewaterman/{personId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeWaterman(@PathParam("flowerId") long flowerId, @PathParam("personId") long personId) {
        if (!flowerService.removeWaterman(flowerId, personId))
            return Response.status(204).entity("Flower/person not found").build();
        return Response.status(200).entity("waterman removed from flower").build();
    }


    @PUT
    @Path("/{flowerId}/setcard")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response setCard(@PathParam("flowerId") long flowerId, Card card) {
        if (!flowerService.setCard(flowerId, card))
            return Response.status(204).entity("Flower/card not found").build();
        return Response.status(200).entity("added care description to flower").build();
    }

    @PUT
    @Path("/{flowerId}/settype/{typeId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response setType(@PathParam("flowerId") long flowerId, @PathParam("typeId") long typeId) {
        if (!flowerService.setType(flowerId, typeId))
            return Response.status(204).entity("Flower/type not found").build();
        return Response.status(200).entity("set type to flower").build();
    }


    @GET
    @Path("/byDate/{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    @JsonView(View.Flower.class)
    public Response findByDateBetween(
            @PathParam("from") Date from, @PathParam("to") Date to)
    {
        Collection<Flower> flowers =
                flowerService.findFlowersByDateBetween(from,to);
            return Response.status(200).entity(flowers).build();
    }

    @GET
    @Path("/byName/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @JsonView(View.Flower.class)
    public Response findFlowersByName(
            @PathParam("name") String name)
    {
        Collection<Flower> flowers =
                flowerService.findFlowersByName(name);
            return Response.status(200).entity(flowers).build();
    }

    @GET
    @Path("/byType/{type}")
    @Produces(MediaType.APPLICATION_JSON)
    @JsonView(View.Flower.class)
    public Response findFlowersByType(
            @PathParam("type") String type)
    {
        Collection<Flower> flowers =
                flowerService.findFlowersByType(type);
            return Response.status(200).entity(flowers).build();
    }

    @GET
    @Path("/byCareDescription/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @JsonView(View.FlowerRealtions.class)
    public Response findByCareDescription(
            @PathParam("name") String name)
    {
        Collection<Flower> flowers =
                flowerService.findByCareDescription(name);
        return Response.status(200).entity(flowers).build();
    }


}