package com.oleksiykovtun.cloudlifegame.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.oleksiykovtun.cloudlifegame.shared.entities.FieldState;
import com.oleksiykovtun.cloudlifegame.shared.entities.SpeciesParameters;

import java.util.List;

/**
 * The RPC services interface
 */
@RemoteServiceRelativePath("rpc")
public interface ServerService extends RemoteService {

    public void deleteData();

    public List<SpeciesParameters> getData();

    public void saveData(SpeciesParameters speciesParameters);

    public List<FieldState> computeGame(List<SpeciesParameters> speciesParameters);

}
