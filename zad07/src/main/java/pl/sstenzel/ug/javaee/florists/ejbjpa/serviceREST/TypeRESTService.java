package pl.sstenzel.ug.javaee.florists.ejbjpa.serviceREST;

import com.fasterxml.jackson.annotation.JsonView;
import pl.sstenzel.ug.javaee.florists.ejbjpa.domain.Type;
import pl.sstenzel.ug.javaee.florists.ejbjpa.service.TypeService;
import pl.sstenzel.ug.javaee.florists.ejbjpa.view.View;

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
        if (type != null)
            return Response.status(200).entity(type).build();
        return Response.status(204).entity("Type not found").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPeople(){
        Collection<Type> types = ts.getAllTypes();
        if (types.size() > 0 && types !=null)
            return Response.status(200).entity(types).build();
        return Response.status(204).entity("Types not found").build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addType(Type type) {
        ts.addType(type);
        return Response.status(201).entity("add type").build();
    }
    
}
