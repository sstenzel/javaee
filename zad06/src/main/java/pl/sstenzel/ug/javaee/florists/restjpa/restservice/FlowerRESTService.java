package pl.sstenzel.ug.javaee.florists.restjpa.restservice;

import pl.sstenzel.ug.javaee.florists.restjpa.domain.Flower;
import pl.sstenzel.ug.javaee.florists.restjpa.service.FlowerService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

        // 400 post
        // 404 source not found
        // 200 ok
        // 202 accepted
        // 204 no content

        //we FLower Service dodajemy @Stateless
        //
        //@Inject
        //private FlowerService flowerService;
        //albo

        @PersistenceContext
        EntityManager flowerService;

        @GET
        @Path("/test")
        @Produces(MediaType.TEXT_PLAIN)
        public String test() {
            return "REST API dziala!";
        }


        @GET
        @Path("/{flowerId}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response get(@PathParam("flowerId") long id) {
            Flower flower = flowerService.find(Flower.class, id);
            if (flower != null)
                return Response.status(200).entity(flower).build();
            return Response.status(204).entity("Flower not found").build();
        }

        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public Response get() {
            Collection<Flower> flowers = flowerService.createNamedQuery("flower.getAll").getResultList();
            if (flowers != null)
                return Response.status(202).entity(" Flower added").build();
            return Response.status(204).entity("Flowers found").build();
        }

        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        public Response add(Flower flower) {
            flowerService.persist(flower);
            return Response.status(400).entity(" Flower added").build();
        }

//        @PUT
//        @Consumes(MediaType.APPLICATION_JSON)
//        @Produces(MediaType.APPLICATION_JSON)
//        public Response update(Flower flower) {
//            Flower flow = flowerService.update(flower);
//            if (flow != null)
//                return Response.status(400).entity(flow).build();
//            return Response.status(204).entity("Flowers found").build();
//        }
//
//
//        @DELETE
//        public Response clear() {
//            flowerService.deleteAll();
//            return Response.status(200).build();
//        }
//
//        @DELETE
//        @Path("/{flowerId}")
//        public Response delete(@PathParam("flowerId") long id) {
//            flowerService.delete(id);
//            return Response.status(200).build();
//        }

    }