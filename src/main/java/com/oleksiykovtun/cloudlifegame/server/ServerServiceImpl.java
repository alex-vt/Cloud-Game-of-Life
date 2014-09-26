package com.oleksiykovtun.cloudlifegame.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.ObjectifyService;
import com.oleksiykovtun.cloudlifegame.client.ServerService;
import com.oleksiykovtun.cloudlifegame.server.game.Game;
import com.oleksiykovtun.cloudlifegame.shared.entities.FieldState;
import com.oleksiykovtun.cloudlifegame.shared.entities.SpeciesParameters;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * The RPC and REST services implementation on server side
 */
@Path("/")
public class ServerServiceImpl extends RemoteServiceServlet implements ServerService {

    static {
        ObjectifyService.register(SpeciesParameters.class);
    }

    @POST
    @Consumes(MediaType.TEXT_XML)
    @Produces(MediaType.TEXT_XML)
    @Path("/compute")
    public List<FieldState> computeGame(List<SpeciesParameters> speciesParameters) {
        return new Game(speciesParameters).computeGameplay();
    }

    @DELETE
    @Path("/delete")
    public void deleteData() {
        ObjectifyService.ofy().delete().keys(ObjectifyService.ofy().load().type(SpeciesParameters.class).keys());
    }

    @GET
    @Produces(MediaType.TEXT_XML)
    @Path("/get")
    public List<SpeciesParameters> getData() {
        return new ArrayList<SpeciesParameters>(ObjectifyService.ofy().load().type(SpeciesParameters.class).list());
    }

    @PUT
    @Consumes(MediaType.TEXT_XML)
    @Path("/save")
    public void saveData(SpeciesParameters speciesParameters) {
        ObjectifyService.ofy().save().entity(speciesParameters).now();
    }

}
