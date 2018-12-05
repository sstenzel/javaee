package pl.sstenzel.ug.javaee.florists.rest.restservice;

import pl.sstenzel.ug.javaee.florists.rest.domain.Flower;
import pl.sstenzel.ug.javaee.florists.rest.service.FlowerService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

    @Path("flower")
    @Stateless
    public class FlowerRESTService {

        @Inject
        private FlowerService flowerService;

        @GET
        @Path("/test")
        @Produces(MediaType.TEXT_PLAIN)
        public String test() {
            return "REST API dziala!";
        }


        @GET
        @Path("/{flowerId}")
        @Produces(MediaType.APPLICATION_JSON)
        public Flower get(@PathParam("flowerId") long id) {
            return flowerService.get(id);
        }

        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public List<Flower> get() {
            return flowerService.getAll();
        }

        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        public Response add(Flower flower) {
            flowerService.add(flower);
            return Response.status(201).entity("Flower").build();
        }

        @PUT
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public Flower update(Flower flower) {
            return flowerService.update(flower);
        }


        @DELETE
        public Response clear() {
            flowerService.deleteAll();
            return Response.status(200).build();
        }

        @DELETE
        @Path("/{flowerId}")
        public Response delete(@PathParam("flowerId") long id) {
            flowerService.delete(id);
            return Response.status(200).build();
        }

    }