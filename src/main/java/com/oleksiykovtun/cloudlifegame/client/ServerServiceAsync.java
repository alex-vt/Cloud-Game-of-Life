package com.oleksiykovtun.cloudlifegame.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.oleksiykovtun.cloudlifegame.shared.entities.FieldState;
import com.oleksiykovtun.cloudlifegame.shared.entities.SpeciesParameters;

import java.util.List;

/**
 * The asynchronous RPC services interface
 */
public interface ServerServiceAsync {

    void deleteData(AsyncCallback<Void> callback);

    void getData(AsyncCallback<List<SpeciesParameters>> callback);

    void saveData(SpeciesParameters speciesParameters, AsyncCallback<Void> callback);

    void computeGame(List<SpeciesParameters> speciesParameters, AsyncCallback<List<FieldState>> callback);

}
