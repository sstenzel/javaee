package pl.sstenzel.ug.javaee.florists.ejbjpa.serviceREST;

import com.fasterxml.jackson.annotation.JsonView;
import pl.sstenzel.ug.javaee.florists.ejbjpa.domain.Person;
import pl.sstenzel.ug.javaee.florists.ejbjpa.service.PersonService;
import pl.sstenzel.ug.javaee.florists.ejbjpa.view.View;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

/*
 *  localhost:8080/florists/api/person/test
 */

@Path("person")
@Stateless
public class PersonRESTService {


    @Inject
    PersonService ps;

    @GET
    @Path("/{personId}")
    @Produces(MediaType.APPLICATION_JSON)
    @JsonView(View.PersonRelations.class)
    public Response getPerson(@PathParam("personId") long id) {
        Person person = ps.getPerson(id);
        if (person != null)
            return Response.status(200).entity(person).build();
        return Response.status(204).entity("Person not found").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @JsonView(View.PersonRelations.class)
    public Response getAllPeople(){
        Collection<Person> people = ps.getAllPeople();
        if (people.size() > 0 && people !=null)
            return Response.status(200).entity(people).build();
        return Response.status(204).entity("Flowers not found").build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPerson(Person person) {
        ps.addPerson(person);
        return Response.status(201).entity("add person").build();
    }

}