package com.oleksiykovtun.cloudlifegame.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.CssColor;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.oleksiykovtun.cloudlifegame.shared.entities.FieldState;
import com.oleksiykovtun.cloudlifegame.shared.entities.SpeciesParameters;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * App client part
 */
public class App implements EntryPoint {

    private static VerticalPanel panel = new VerticalPanel();
    private Timer timer;

    private final List<SpeciesParameters> defaultSpeciesParameters = Arrays.asList(
            new SpeciesParameters("1", "Tree", "-", "3", "-", "No", "No",
                    "-", "-", "-", "-", "-",
                    "30", "100", "30", "100", "0.80",
                    "", "", "", "", "",
                    "", "", "", "", "",
                    "", "", "", "", "",
                    "", "", "", "", "",
                    "", "", "", "", "",
                    "", "", "", "", "",
                    "No", "3", "No",
                    "2", "30", "10"),
            new SpeciesParameters("2", "Cabbage", "-", "5", "-", "No", "No",
                    "-", "-", "Dies", "-", "Dies",
                    "1", "2", "0", "0.5", "0.95",
                    "", "", "0.5", "2", "0.05",
                    "", "", "", "", "",
                    "", "", "", "", "",
                    "", "", "", "", "",
                    "", "", "", "", "",
                    "", "", "", "", "",
                    "No", "25", "No",
                    "100", "30", "10"),
            new SpeciesParameters("3", "Rabbit", "8", "1", "3", "Yes", "Yes",
                    "-", "Kills", "Breeds", "Dies", "Dies",
                    "0", "1", "0", "1", "0.30",
                    "1", "2", "1", "2", "0.15",
                    "2", "3", "2", "3", "0.05",
                    "3", "4", "3", "4", "0",
                    "4", "5", "4", "5", "0",
                    "5", "6", "5", "6", "0.20",
                    "6", "7", "6", "7", "0.30",
                    "Yes", "7", "Yes",
                    "25", "30", "10"),
            new SpeciesParameters("4", "Wolf", "8", "1", "3", "Yes", "Yes",
                    "-", "-", "Kills", "Breeds", "Kills",
                    "1", "2", "0", "5", "0.50",
                    "2", "3", "5", "10", "0.20",
                    "3", "4", "10", "15", "0.30",
                    "4", "5", "", "", "",
                    "5", "6", "", "", "",
                    "6", "7", "", "", "",
                    "7", "8", "", "", "",
                    "Yes", "5", "Yes",
                    "10", "30", "10"),
            new SpeciesParameters("5", "Human", "4", "1", "3", "Yes", "Yes",
                    "-", "Kills", "Kills", "Dies", "Breeds",
                    "20", "40", "0", "40", "0.10",
                    "", "", "40", "50", "0.15",
                    "", "", "50", "60", "0.25",
                    "", "", "60", "70", "0.30",
                    "", "", "70", "80", "0.20",
                    "", "", "", "", "",
                    "", "", "", "", "",
                    "Yes", "2", "No",
                    "40", "30", "10")
    );

    private final ServerServiceAsync service = GWT.create(ServerService.class);
    private boolean waitResults = false;
    private final List<String> colors = Arrays.asList("white", "brown", "green", "blue", "gray", "yellow");

    /**
     * Entry point
     */
    public void onModuleLoad() {
        panel.setWidth("100%");
        panel.setHeight("100%");
        panel.setSpacing(10);
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        RootPanel.get().add(panel);
        showParameters();
    }

    private Map<String, CellTable> getParametersTables() {
        Map<String, CellTable> tables = new LinkedHashMap<String, CellTable>();
        tables.put("General Parameters", TablesBuilder.getGeneralParametersTable(new ArrayList()));
        tables.put("Field Parameters", TablesBuilder.getFieldParametersTable(new ArrayList()));
        tables.put("Interaction Parameters", TablesBuilder.getInteractionParametersTable(new ArrayList()));
        tables.put("Period 1 Parameters", TablesBuilder.getPeriod1ParametersTable(new ArrayList()));
        tables.put("Period 2 Parameters", TablesBuilder.getPeriod2ParametersTable(new ArrayList()));
        tables.put("Period 3 Parameters", TablesBuilder.getPeriod3ParametersTable(new ArrayList()));
        tables.put("Period 4 Parameters", TablesBuilder.getPeriod4ParametersTable(new ArrayList()));
        tables.put("Period 5 Parameters", TablesBuilder.getPeriod5ParametersTable(new ArrayList()));
        tables.put("Period 6 Parameters", TablesBuilder.getPeriod6ParametersTable(new ArrayList()));
        tables.put("Period 7 Parameters", TablesBuilder.getPeriod7ParametersTable(new ArrayList()));
        tables.put("Breeding Parameters", TablesBuilder.getBreedingParametersTable(new ArrayList()));
        return tables;
    }

    private void clearPanel() {
        panel.clear();
        panel.add(new Label("CLOUD GAME OF LIFE"));
    }

    private void addParametersTables(Map<String, CellTable> tables) {
        for (Map.Entry<String, CellTable> entry : tables.entrySet()) {
            panel.add(new Label(entry.getKey()));
            panel.add(entry.getValue());
        }
    }

    private void addGameResetButton(final List<SpeciesParameters> speciesParameters,
                                    final Map<String, CellTable> parametersTables) {
        final Button defaultsButton = new Button("Defaults");
        defaultsButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) { // bug, not always updates
                resetParametersToDefaults(speciesParameters, defaultSpeciesParameters, parametersTables);
            }
        });
        panel.add(defaultsButton);
    }

    private void addGameStartButton(final List<SpeciesParameters> speciesParameters) {
        Button startButton = new Button("Run Game");
        startButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                computeGame(speciesParameters);
            }
        });
        panel.add(startButton);
    }

    private void addSaveParametersButton(final List<SpeciesParameters> speciesParameters) {
        Button startButton = new Button("Save");
        startButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                writeParametersToDatabase(speciesParameters);
            }
        });
        panel.add(startButton);
    }

    private void computeGame(List<SpeciesParameters> speciesParameters) {
        showComputingStart();
        Logger.getLogger("").info("SENDING");
        service.computeGame(speciesParameters,
                new AsyncCallback<List<FieldState>>() {
                    public void onFailure(Throwable caught) {
                        Logger.getLogger("").log(Level.SEVERE, "", caught);
                    }

                    public void onSuccess(List<FieldState> fieldChanges) {
                        Logger.getLogger("").info("RECEIVED");
                        if (waitResults) {
                            showComputingResults(fieldChanges);
                        }
                    }
                }
        );
    }

    private void resetParametersToDefaults(List<SpeciesParameters> speciesParameters,
                                           List<SpeciesParameters> defaultSpeciesParameters,
                                           Map<String, CellTable> parametersTables
    ) {
        speciesParameters.clear();
        for (int i = 0; i < defaultSpeciesParameters.size(); ++i) {
            speciesParameters.add(defaultSpeciesParameters.get(i));
        }
        refreshTables(speciesParameters, parametersTables);
    }

    private void showComputingResults(List<FieldState> fieldChanges) {
        clearPanel();
        final Button returnButton = new Button("Return to Parameters");
        panel.add(returnButton);
        returnButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                showParameters();
            }
        });
        addGamePlayer(fieldChanges);
    }

    private void addPlayPanel() {
        final HorizontalPanel playPanel = new HorizontalPanel();
        playPanel.setSpacing(5);
        addPlayButton(playPanel, 1);
        addPlayButton(playPanel, 3);
        addPlayButton(playPanel, 10);
        panel.add(playPanel);
    }

    private void addStopPanel() {
        final HorizontalPanel stopPanel = new HorizontalPanel();
        stopPanel.setSpacing(5);
        addPauseButton(stopPanel);
        addRewindButton(stopPanel);
        panel.add(stopPanel);
    }

    private void addRewindButton(HorizontalPanel stopPanel) {
        final Button rewindButton = new Button("Rewind");
        stopPanel.add(rewindButton);
        rewindButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if (timer != null) {
                    if (timer.isRunning()) {
                        timer.cancel();
                    }
                    timer.schedule(0);
                }
            }
        });
    }

    private void addPauseButton(HorizontalPanel stopPanel) {
        final Button pauseButton = new Button("Pause");
        stopPanel.add(pauseButton);
        pauseButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if (timer != null && timer.isRunning()) {
                    timer.cancel();
                }
            }
        });
    }

    private void addPlayButton(HorizontalPanel playPanel, final int playbackSpeed) {
        final Button playButton = new Button("Play " + playbackSpeed + "x");
        playPanel.add(playButton);
        playButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if (timer != null) {
                    if (timer.isRunning()) {
                        timer.cancel();
                    }
                    timer.scheduleRepeating(1000 / playbackSpeed);
                }
            }
        });
    }

    private void addGamePlayer(final List<FieldState> fieldChanges) {
        final Label timeLabel = new Label("Ready.");
        panel.add(timeLabel);
        final int cellSize = 20;
        Canvas gameCanvas = getGamePlayerCanvas(fieldChanges, cellSize);
        panel.add(gameCanvas);

        addPlayPanel();
        addStopPanel();

        Canvas graphsCanvas = getGameGraphsCanvas();
        panel.add(graphsCanvas);
        final Label graphLabel = new Label("Change of species shares");
        panel.add(graphLabel);

        setTimer(fieldChanges, getGraphsData(fieldChanges), getFieldArea(fieldChanges.get(0)),
                gameCanvas, graphsCanvas, cellSize, timeLabel);
    }

    private int getFieldArea(FieldState fieldState) {
        return fieldState.getCellStates().length * fieldState.getCellStates()[0].length;
    }

    private Canvas getGameGraphsCanvas() {
        int graphsCanvasWidth = 600;
        int graphsCanvasHeight = 300;

        Canvas graphsCanvas = Canvas.createIfSupported();
        graphsCanvas.setWidth(graphsCanvasWidth + Style.Unit.PX.getType());
        graphsCanvas.setCoordinateSpaceWidth(graphsCanvasWidth);
        graphsCanvas.setHeight(graphsCanvasHeight + Style.Unit.PX.getType());
        graphsCanvas.setCoordinateSpaceHeight(graphsCanvasHeight);
        return graphsCanvas;
    }

    private Canvas getGamePlayerCanvas(final List<FieldState> fieldChanges, int cellSize) {
        final int fieldWidth = fieldChanges.get(0).getCellStates().length;
        final int fieldHeight = fieldChanges.get(0).getCellStates()[0].length;
        int gameCanvasWidth = fieldWidth * cellSize;
        int gameCanvasHeight = fieldHeight * cellSize;

        Canvas gameCanvas = Canvas.createIfSupported();
        gameCanvas.setWidth(gameCanvasWidth + Style.Unit.PX.getType());
        gameCanvas.setCoordinateSpaceWidth(gameCanvasWidth);
        gameCanvas.setHeight(gameCanvasHeight + Style.Unit.PX.getType());
        gameCanvas.setCoordinateSpaceHeight(gameCanvasHeight);
        return gameCanvas;
    }

    private void setTimer(final List<FieldState> fieldChanges, final int[][] graphsData,
                          final int fieldArea, final Canvas gameCanvas, final Canvas graphsCanvas,
                          final int cellSize, final Label timeLabel) {
        timer = new Timer() {
            public int counter = 0;

            public void run() {
                if (counter < fieldChanges.size()) {
                    drawGameFrame(gameCanvas, fieldChanges.get(counter),
                            cellSize, timeLabel);
                    drawGraphsFrame(graphsCanvas, graphsData, fieldArea, counter);
                    ++counter;
                } else {
                    timer.cancel();
                }
            }

            public void schedule(int millis) {
                counter = 0;
                super.schedule(millis);
            }
        };
        timer.schedule(0);
    }

    private int[][] getGraphsData(final List<FieldState> fieldChanges) {
        int[][] graphsData = new int[fieldChanges.size()][colors.size() - 1];
        for (int i = 0; i < fieldChanges.size(); ++i) {
            for (int j = 0; j < colors.size() - 1; ++j) {
                graphsData[i][j] = fieldChanges.get(i).getCellsCount(j + 1);
            }
        }
        return graphsData;
    }

    private void drawGraphsFrame(Canvas canvas, final int[][] graphsData, int fieldArea, int counter) {
        Context2d context = canvas.getContext2d();
        int speciesCount = graphsData[0].length;
        double canvasWidth = canvas.getCoordinateSpaceWidth();
        double canvasHeight = canvas.getCoordinateSpaceHeight();
        int displayAmount = 60;
        double periodWidth = canvasWidth / displayAmount;
        int startItem = Math.max(0, counter - displayAmount + 1);
        double yPixelsPerCell = canvasHeight / fieldArea;
        context.clearRect(0, 0, canvasWidth, canvasHeight);
        context.beginPath();
        for (int i = startItem; i <= counter; ++i) {
            double yDrawPos = canvasHeight;
            for (int j = 0; j < speciesCount; ++j) {
                yDrawPos -= graphsData[i][j] * yPixelsPerCell;
                context.setFillStyle(CssColor.make(colors.get(j + 1)));
                context.fillRect(periodWidth * (i - startItem), yDrawPos,
                        periodWidth, graphsData[i][j] * yPixelsPerCell);
            }
        }
        context.closePath();
        context.setStrokeStyle(CssColor.make("gray"));
        context.beginPath();
        context.strokeRect(0, 0, canvasWidth, canvasHeight);
        context.stroke();
        context.closePath();
    }

    private void drawGameFrame(Canvas canvas, final FieldState fieldChanges, int cellSize, Label timeLabel) {
        timeLabel.setText("Time: " + fieldChanges.getTime() + " y.");
        final int fieldWidth = fieldChanges.getCellStates().length;
        final int fieldHeight = fieldChanges.getCellStates()[0].length;
        Context2d context = canvas.getContext2d();
        context.clearRect(0, 0, fieldWidth * cellSize, fieldHeight * cellSize);
        drawCells(canvas, fieldChanges.getCellStates(), cellSize);
        drawFrameGrid(canvas, fieldWidth, fieldHeight, cellSize);
    }

    private void drawCells(Canvas canvas, byte[][] cells, int cellSize) {
        Context2d context = canvas.getContext2d();
        context.beginPath();
        for (int i = 0; i < cells.length; ++i) {
            for (int j = 0; j < cells[0].length; ++j) {
                context.setFillStyle(CssColor.make(colors.get(cells[i][j])));
                context.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);
            }
        }
        context.closePath();
    }

    private void drawFrameGrid(Canvas canvas, int fieldWidth, int fieldHeight, int cellSize) {
        Context2d context = canvas.getContext2d();
        context.setStrokeStyle(CssColor.make("gray"));
        for (int i = 0; i <= fieldWidth; ++i) {
            context.beginPath();
            context.moveTo(i * cellSize, 0);
            context.lineTo(i * cellSize, fieldHeight * cellSize);
            context.stroke();
            context.closePath();
        }
        for (int i = 0; i <= fieldHeight; ++i) {
            context.beginPath();
            context.moveTo(0, i * cellSize);
            context.lineTo(fieldWidth * cellSize, i * cellSize);
            context.stroke();
            context.closePath();
        }
    }

    private void showComputingStart() {
        waitResults = true;
        clearPanel();
        panel.add(new Label("Computing... (max. 20 s)"));
        final Button cancelButton = new Button("Cancel");
        panel.add(cancelButton);
        cancelButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                showParameters();
                waitResults = false;
            }
        });
    }

    private void showParameters() {
        if (timer != null) {
            timer.cancel();
        }
        loadParametersFromDatabase(getParametersTables());
        clearPanel();
        panel.add(new Label("Loading..."));
    }

    private void writeParametersToDatabase(final List<SpeciesParameters> speciesParametersToSave) {
        for (int i = 0; i < speciesParametersToSave.size(); ++i) {
            final SpeciesParameters currentSpeciesParameters = speciesParametersToSave.get(i);
            service.saveData(currentSpeciesParameters,
                    new AsyncCallback<Void>() {
                        public void onFailure(Throwable caught) {
                            Logger.getLogger("").log(Level.SEVERE, "", caught);
                        }

                        public void onSuccess(Void result) {
                            Logger.getLogger("").info(currentSpeciesParameters.getName() + " written.");
                        }
                    }
            );
        }
    }

    private void rewriteParametersToDatabase(final List<SpeciesParameters> speciesParametersToSave) {
        service.deleteData(new AsyncCallback<Void>() {
            public void onFailure(Throwable caught) {
                Logger.getLogger("").log(Level.SEVERE, "Database hasn't been cleared.", caught);
            }

            public void onSuccess(Void result) {
                Logger.getLogger("").info("Database cleared.");
                writeParametersToDatabase(speciesParametersToSave);
            }
        });
    }

    private List<SpeciesParameters> loadParametersFromDatabase(final Map<String, CellTable> parametersTables) {
        final List<SpeciesParameters> speciesParametersToReturn = new ArrayList<SpeciesParameters>();
        service.getData(new AsyncCallback<List<SpeciesParameters>>() {

            public void onFailure(Throwable caught) {
                Logger.getLogger("").log(Level.SEVERE, "Reload Users from Database has failed.", caught);
            }

            public void onSuccess(List<SpeciesParameters> speciesParametersFromDatabase) {
                if (speciesParametersFromDatabase.size() == defaultSpeciesParameters.size()) {
                    for (SpeciesParameters speciesParameter : speciesParametersFromDatabase) {
                        speciesParametersToReturn.add(speciesParameter);
                    }
                    Logger.getLogger("").info("Reload " + speciesParametersFromDatabase.size()
                            + " Parameters Items from Database has succeeded.");
                } else {
                    Logger.getLogger("").info("Database contained " + speciesParametersFromDatabase.size()
                            + " parameters Items and will be reset by defaults now.");
                    rewriteParametersToDatabase(defaultSpeciesParameters);
                    for (SpeciesParameters speciesParameter : defaultSpeciesParameters) {
                        speciesParametersToReturn.add(speciesParameter);
                    }
                }
                clearPanel();
                refreshTables(speciesParametersToReturn, parametersTables);
                addGameStartButton(speciesParametersToReturn);
                addSaveParametersButton(speciesParametersToReturn);
                addParametersTables(parametersTables);
                addGameStartButton(speciesParametersToReturn);
                addSaveParametersButton(speciesParametersToReturn);
                addGameResetButton(speciesParametersToReturn, parametersTables);
            }
        });
        return speciesParametersToReturn;
    }

    private void refreshTables(List<SpeciesParameters> speciesParameters,
                               Map<String, CellTable> parametersTables) {
        for (Map.Entry<String, CellTable> entry : parametersTables.entrySet()) {
            entry.getValue().setRowData(speciesParameters);
        }
    }

}
