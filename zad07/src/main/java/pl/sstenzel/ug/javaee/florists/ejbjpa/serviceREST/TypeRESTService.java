package pl.sstenzel.ug.javaee.florists.ejbjpa.serviceREST;

import pl.sstenzel.ug.javaee.florists.ejbjpa.domain.Type;
import pl.sstenzel.ug.javaee.florists.ejbjpa.service.TypeService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;


@Path("type")
@Stateless
public class TypeRESTService {

    @Inject
    TypeService ts;

    @GET
    @Path("/{typeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getType(@PathParam("typeId") long id) {
        Type type = ts.getType(id);
        return Response.status(200).entity(type).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllTypes(){
        Collection<Type> types = ts.getAllTypes();
        return Response.status(200).entity(types).build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addType(Type type) {
        ts.addType(type);
        return Response.status(201).entity("add type").build();
    }


    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateType(Type type) {
        Type type2 = ts.updateType(type);
        return Response.status(201).entity(type2).build();
    }

    @DELETE
    @Path("/{typeId}")
    public Response deleteType(@PathParam("typeId") long id) {
        if (ts.deleteType(id))
            return Response.status(200).build();
        return Response.status(409).build();
    }
    
}
