package pl.sstenzel.ug.javaee.florists.ejbjpa.serviceREST;

import com.fasterxml.jackson.annotation.JsonView;
import pl.sstenzel.ug.javaee.florists.ejbjpa.domain.Person;
import pl.sstenzel.ug.javaee.florists.ejbjpa.service.PersonService;
import pl.sstenzel.ug.javaee.florists.ejbjpa.JSONView.View;

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
    PersonService personService;


    @GET
    @Path("/{personId}")
    @Produces(MediaType.APPLICATION_JSON)
    @JsonView(View.PersonRelations.class)
    public Response getPerson(@PathParam("personId") long id) {
        Person person = personService.getPerson(id);
        if (person != null)
            return Response.status(200).entity(person).build();
        return Response.status(204).entity("person not found").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @JsonView(View.PersonRelations.class)
    public Response getAllPeople(){
        Collection<Person> people = personService.getAllPeople();
        return Response.status(200).entity(people).build();
    }


    @GET
    @Path("/byFlowersAmount/{amount}")
    @Produces(MediaType.APPLICATION_JSON)
    @JsonView(View.Person.class)
    public Response findByFlowersAmount(
            @PathParam("amount") long amount)
    {
        Collection<Person> people =
                personService.findByFlowersAmount(amount);
        return Response.status(200).entity(people).build();
    }

    @GET
    @Path("/byToxicFlowers/{dogToxic}/{amount}")
    @Produces(MediaType.APPLICATION_JSON)
    @JsonView(View.Person.class)
    public Response findByToxicFlowers(
            @PathParam("dogToxic") boolean dogToxic,
            @PathParam("amount") long amount)
    {
        Collection<Person> people =
                personService.findByToxicFlowers(dogToxic, amount);
        return Response.status(200).entity(people).build();
    }

}