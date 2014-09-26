package com.oleksiykovtun.cloudlifegame.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.ObjectifyService;
import com.oleksiykovtun.cloudlifegame.client.ServerService;
import com.oleksiykovtun.cloudlifegame.server.game.Game;
import com.oleksiykovtun.cloudlifegame.shared.entities.FieldState;
import com.oleksiykovtun.cloudlifegame.shared.entities.SpeciesParameters;

import java.util.ArrayList;
import java.util.List;

/**
 * The RPC services implementation on server side
 */
public class ServerServiceImpl extends RemoteServiceServlet implements ServerService {

    static {
        ObjectifyService.register(SpeciesParameters.class);
    }

    public List<FieldState> computeGame(List<SpeciesParameters> speciesParameters) {
        return new Game(speciesParameters).computeGameplay();
    }

    public void deleteData() {
        ObjectifyService.ofy().delete().keys(ObjectifyService.ofy().load().type(SpeciesParameters.class).keys());
    }

    public List<SpeciesParameters> getData() {
        return new ArrayList<SpeciesParameters>(ObjectifyService.ofy().load().type(SpeciesParameters.class).list());
    }

    public void saveData(SpeciesParameters speciesParameters) {
        ObjectifyService.ofy().save().entity(speciesParameters).now();
    }

}
