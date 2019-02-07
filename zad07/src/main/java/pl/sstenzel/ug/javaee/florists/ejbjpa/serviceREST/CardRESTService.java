package pl.sstenzel.ug.javaee.florists.ejbjpa.serviceREST;

import pl.sstenzel.ug.javaee.florists.ejbjpa.domain.Card;
import pl.sstenzel.ug.javaee.florists.ejbjpa.service.CardService;


import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;


@Path("card")
@Stateless
public class CardRESTService {

    @Inject
    CardService cs;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCards(){
        Collection<Card> cards = cs.getAllCards();
        return Response.status(200).entity(cards).build();
    }
}


