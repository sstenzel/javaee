package pl.sstenzel.ug.javaee.florists.ejbjpa.serviceREST;


import pl.sstenzel.ug.javaee.florists.ejbjpa.domain.Card;
import pl.sstenzel.ug.javaee.florists.ejbjpa.service.CardService;


import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCard(Card card) {
        cs.addCard(card);
        return Response.status(201).entity("add card").build();
    }

    @GET
    @Path("/{cardId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCard(@PathParam("cardId") long id) {
        Card card = cs.getCard(id);
        return Response.status(200).entity(card).build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCard(Card card) {
        Card card2 = cs.updateCard(card);
        return Response.status(201).entity(card2).build();
    }

    @DELETE
    @Path("/{cardId}")
    public Response deleteCard(@PathParam("cardId") long id) {
        if (cs.removeCard(id))
            return Response.status(200).build();
        return Response.status(409).build();
    }
}


