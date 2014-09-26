package com.oleksiykovtun.cloudlifegame.client;

import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.SelectionCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.cell.client.TextInputCell;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.view.client.ProvidesKey;
import com.oleksiykovtun.cloudlifegame.shared.entities.SpeciesParameters;

import java.util.Arrays;
import java.util.List;

/**
 * Created by alx on 16.09.2014.
 */
public class TablesBuilder {

    private static SelectionCell ageSelectionCell = new SelectionCell(Arrays.asList(
            "", "0", "0.5", "1", "2", "3", "4", "5", "6", "7", "8", "10", "15",
            "20", "30", "40", "50", "60", "70", "80", "90", "100"));
    private static SelectionCell probabilitySelectionCell = new SelectionCell(Arrays.asList(
            "", "0", "0.05", "0.10", "0.15", "0.20", "0.25", "0.30", "0.35", "0.40", "0.45", "0.50",
            "0.55", "0.60", "0.65", "0.70", "0.75", "0.80", "0.85", "0.90", "0.95", "1"));
    private static SelectionCell booleanSelectionCell = new SelectionCell(Arrays.asList(
            "Yes", "No"));
    private static SelectionCell interactionSelectionCell = new SelectionCell(Arrays.asList(
            "-", "Kills", "Dies", "Breeds"));
    private static SelectionCell distanceSelectionCell = new SelectionCell(Arrays.asList(
            "-", "1", "2", "3", "5"));
    private static SelectionCell speedSelectionCell = new SelectionCell(Arrays.asList(
            "-", "1", "2", "4", "8"));
    private static SelectionCell quantitySelectionCell = new SelectionCell(Arrays.asList(
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "10", "15", "20", "25", "30", "40", "50",
            "100", "200", "500"));
    private static SelectionCell fieldSizeSelectionCell= new SelectionCell(Arrays.asList(
            "5", "10", "15", "20", "25", "30"));

    public static CellTable getGeneralParametersTable(List inputData) {
        final CellTable table = new CellTable(new ProvidesKey() {
            @Override
            public Object getKey(Object item) {
                return ((SpeciesParameters) item).getNumber();
            }
        });
        addNumberColumn(table, "#");
        addNameColumn(table, "Name");
        addSpeedColumn(table, "Speed");
        addIsMobileColumn(table, "Is Mobile?");
        addBreedingDistanceColumn(table, "Breeding Distance");
        addIsIntelligentColumn(table, "Is Intelligent?");
        addVisionDistanceColumn(table, "Vision Distance");
        table.setWidth("100%", true);
        table.setRowData(inputData);
        return table;
    }

    public static CellTable getInteractionParametersTable(List inputData) {
        final CellTable table = new CellTable(new ProvidesKey() {
            @Override
            public Object getKey(Object item) {
                return ((SpeciesParameters) item).getNumber();
            }
        });
        addNumberColumn(table, "#");
        addInteractionWith1Column(table, "Interaction With #1");
        addInteractionWith2Column(table, "Interaction With #2");
        addInteractionWith3Column(table, "Interaction With #3");
        addInteractionWith4Column(table, "Interaction With #4");
        addInteractionWith5Column(table, "Interaction With #5");
        table.setWidth("100%", true);
        table.setRowData(inputData);
        return table;
    }

    public static CellTable getPeriod1ParametersTable(List inputData) {
        final CellTable table = new CellTable(new ProvidesKey() {
            @Override
            public Object getKey(Object item) {
                return ((SpeciesParameters) item).getNumber();
            }
        });
        addNumberColumn(table, "#");
        addBreedingPeriodStart1Column(table, "Breeding period 1 start");
        addBreedingPeriodEnd1Column(table, "Breeding period 1 end");
        addDeathPeriodStart1Column(table, "Death period 1 start");
        addDeathPeriodEnd1Column(table, "Death period 1 end");
        addDeathPeriodProbability1Column(table, "Death period 1 probability");
        table.setWidth("100%", true);
        table.setRowData(inputData);
        return table;
    }

    public static CellTable getPeriod2ParametersTable(List inputData) {
        final CellTable table = new CellTable(new ProvidesKey() {
            @Override
            public Object getKey(Object item) {
                return ((SpeciesParameters) item).getNumber();
            }
        });
        addNumberColumn(table, "#");
        addBreedingPeriodStart2Column(table, "Breeding period 2 start");
        addBreedingPeriodEnd2Column(table, "Breeding period 2 end");
        addDeathPeriodStart2Column(table, "Death period 2 start");
        addDeathPeriodEnd2Column(table, "Death period 2 end");
        addDeathPeriodProbability2Column(table, "Death period 2 probability");
        table.setWidth("100%", true);
        table.setRowData(inputData);
        return table;
    }

    public static CellTable getPeriod3ParametersTable(List inputData) {
        final CellTable table = new CellTable(new ProvidesKey() {
            @Override
            public Object getKey(Object item) {
                return ((SpeciesParameters) item).getNumber();
            }
        });
        addNumberColumn(table, "#");
        addBreedingPeriodStart3Column(table, "Breeding period 3 start");
        addBreedingPeriodEnd3Column(table, "Breeding period 3 end");
        addDeathPeriodStart3Column(table, "Death period 3 start");
        addDeathPeriodEnd3Column(table, "Death period 3 end");
        addDeathPeriodProbability3Column(table, "Death period 3 probability");
        table.setWidth("100%", true);
        table.setRowData(inputData);
        return table;
    }

    public static CellTable getPeriod4ParametersTable(List inputData) {
        final CellTable table = new CellTable(new ProvidesKey() {
            @Override
            public Object getKey(Object item) {
                return ((SpeciesParameters) item).getNumber();
            }
        });
        addNumberColumn(table, "#");
        addBreedingPeriodStart4Column(table, "Breeding period 4 start");
        addBreedingPeriodEnd4Column(table, "Breeding period 4 end");
        addDeathPeriodStart4Column(table, "Death period 4 start");
        addDeathPeriodEnd4Column(table, "Death period 4 end");
        addDeathPeriodProbability4Column(table, "Death period 4 probability");
        table.setWidth("100%", true);
        table.setRowData(inputData);
        return table;
    }

    public static CellTable getPeriod5ParametersTable(List inputData) {
        final CellTable table = new CellTable(new ProvidesKey() {
            @Override
            public Object getKey(Object item) {
                return ((SpeciesParameters) item).getNumber();
            }
        });
        addNumberColumn(table, "#");
        addBreedingPeriodStart5Column(table, "Breeding period 5 start");
        addBreedingPeriodEnd5Column(table, "Breeding period 5 end");
        addDeathPeriodStart5Column(table, "Death period 5 start");
        addDeathPeriodEnd5Column(table, "Death period 5 end");
        addDeathPeriodProbability5Column(table, "Death period 5 probability");
        table.setWidth("100%", true);
        table.setRowData(inputData);
        return table;
    }

    public static CellTable getPeriod6ParametersTable(List inputData) {
        final CellTable table = new CellTable(new ProvidesKey() {
            @Override
            public Object getKey(Object item) {
                return ((SpeciesParameters) item).getNumber();
            }
        });
        addNumberColumn(table, "#");
        addBreedingPeriodStart6Column(table, "Breeding period 6 start");
        addBreedingPeriodEnd6Column(table, "Breeding period 6 end");
        addDeathPeriodStart6Column(table, "Death period 6 start");
        addDeathPeriodEnd6Column(table, "Death period 6 end");
        addDeathPeriodProbability6Column(table, "Death period 6 probability");
        table.setWidth("100%", true);
        table.setRowData(inputData);
        return table;
    }

    public static CellTable getPeriod7ParametersTable(List inputData) {
        final CellTable table = new CellTable(new ProvidesKey() {
            @Override
            public Object getKey(Object item) {
                return ((SpeciesParameters) item).getNumber();
            }
        });
        addNumberColumn(table, "#");
        addBreedingPeriodStart7Column(table, "Breeding period 7 start");
        addBreedingPeriodEnd7Column(table, "Breeding period 7 end");
        addDeathPeriodStart7Column(table, "Death period 7 start");
        addDeathPeriodEnd7Column(table, "Death period 7 end");
        addDeathPeriodProbability7Column(table, "Death period 7 probability");
        table.setWidth("100%", true);
        table.setRowData(inputData);
        return table;
    }

    public static CellTable getBreedingParametersTable(List inputData) {
        final CellTable table = new CellTable(new ProvidesKey() {
            @Override
            public Object getKey(Object item) {
                return ((SpeciesParameters) item).getNumber();
            }
        });
        addNumberColumn(table, "#");
        addIsPairRequiredColumn(table, "Is pair required?");
        addChildrenQuantityColumn(table, "Children per period");
        addIsBreedingSynchronousColumn(table, "Are all children born at once per period?");
        table.setWidth("100%", true);
        table.setRowData(inputData);
        return table;
    }

    public static CellTable getFieldParametersTable(List inputData) {
        final CellTable table = new CellTable(new ProvidesKey() {
            @Override
            public Object getKey(Object item) {
                return ((SpeciesParameters) item).getNumber();
            }
        });
        addNumberColumn(table, "#");
        addInitialQuantityColumn(table, "Initial Quantity");
        addInitialFieldXColumn(table, "Initial Distribution Field X");
        addInitialFieldYColumn(table, "Initial Distribution Field Y");
        table.setWidth("100%", true);
        table.setRowData(inputData);
        return table;
    }

    private static void addNumberColumn(final CellTable table, String screenColumnName) {
        final TextCell cell = new TextCell();
        Column column = new Column(cell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getNumber();
            }
        };
        table.addColumn(column, screenColumnName);
        table.setColumnWidth(column, "40PX");
    }

    private static void addNameColumn(final CellTable table, String screenColumnName) {
        final TextInputCell cell = new TextInputCell();
        Column column = new Column(cell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getName();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setName((String) value);
                table.redraw();
            }
        });
    }

    private static void addBreedingDistanceColumn(final CellTable table, String screenColumnName) {
        Column column = new Column(distanceSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getBreedingDistance();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setBreedingDistance((String) value);
                table.redraw();
            }
        });
    }

    private static void addVisionDistanceColumn(final CellTable table, String screenColumnName) {
        Column column = new Column(distanceSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getVisionDistance();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setVisionDistance((String) value);
                table.redraw();
            }
        });
    }

    private static void addSpeedColumn(final CellTable table, String screenColumnName) {
        Column column = new Column(speedSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getSpeed();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setSpeed((String) value);
                table.redraw();
            }
        });
    }

    private static void addIsIntelligentColumn(final CellTable table, String screenColumnName) {
        Column column = new Column(booleanSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getIsIntelligent();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setIsIntelligent((String) value);
                table.redraw();
            }
        });
    }

    private static void addIsMobileColumn(final CellTable table, String screenColumnName) {
        Column column = new Column(booleanSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getIsMobile();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setIsMobile((String) value);
                table.redraw();
            }
        });
    }

    private static void addInteractionWith1Column(final CellTable table, String screenColumnName) {
        Column column = new Column(interactionSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getInteractionWith1();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setInteractionWith1((String) value);
                table.redraw();
            }
        });
    }

    private static void addInteractionWith2Column(final CellTable table, String screenColumnName) {
        Column column = new Column(interactionSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getInteractionWith2();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setInteractionWith2((String) value);
                table.redraw();
            }
        });
    }

    private static void addInteractionWith3Column(final CellTable table, String screenColumnName) {
        Column column = new Column(interactionSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getInteractionWith3();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setInteractionWith3((String) value);
                table.redraw();
            }
        });
    }

    private static void addInteractionWith4Column(final CellTable table, String screenColumnName) {
        Column column = new Column(interactionSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getInteractionWith4();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setInteractionWith4((String) value);
                table.redraw();
            }
        });
    }

    private static void addInteractionWith5Column(final CellTable table, String screenColumnName) {
        Column column = new Column(interactionSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getInteractionWith5();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setInteractionWith5((String) value);
                table.redraw();
            }
        });
    }

    private static void addBreedingPeriodStart1Column(final CellTable table, String screenColumnName) {
        Column column = new Column(ageSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getBreedingPeriodStart1();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setBreedingPeriodStart1((String) value);
                table.redraw();
            }
        });
    }

    private static void addBreedingPeriodStart2Column(final CellTable table, String screenColumnName) {
        Column column = new Column(ageSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getBreedingPeriodStart2();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setBreedingPeriodStart2((String) value);
                table.redraw();
            }
        });
    }

    private static void addBreedingPeriodStart3Column(final CellTable table, String screenColumnName) {
        Column column = new Column(ageSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getBreedingPeriodStart3();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setBreedingPeriodStart3((String) value);
                table.redraw();
            }
        });
    }

    private static void addBreedingPeriodStart4Column(final CellTable table, String screenColumnName) {
        Column column = new Column(ageSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getBreedingPeriodStart4();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setBreedingPeriodStart4((String) value);
                table.redraw();
            }
        });
    }

    private static void addBreedingPeriodStart5Column(final CellTable table, String screenColumnName) {
        Column column = new Column(ageSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getBreedingPeriodStart5();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setBreedingPeriodStart5((String) value);
                table.redraw();
            }
        });
    }

    private static void addBreedingPeriodStart6Column(final CellTable table, String screenColumnName) {
        Column column = new Column(ageSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getBreedingPeriodStart6();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setBreedingPeriodStart6((String) value);
                table.redraw();
            }
        });
    }

    private static void addBreedingPeriodStart7Column(final CellTable table, String screenColumnName) {
        Column column = new Column(ageSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getBreedingPeriodStart7();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setBreedingPeriodStart7((String) value);
                table.redraw();
            }
        });
    }

    private static void addBreedingPeriodEnd1Column(final CellTable table, String screenColumnName) {
        Column column = new Column(ageSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getBreedingPeriodEnd1();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setBreedingPeriodEnd1((String) value);
                table.redraw();
            }
        });
    }

    private static void addBreedingPeriodEnd2Column(final CellTable table, String screenColumnName) {
        Column column = new Column(ageSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getBreedingPeriodEnd2();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setBreedingPeriodEnd2((String) value);
                table.redraw();
            }
        });
    }

    private static void addBreedingPeriodEnd3Column(final CellTable table, String screenColumnName) {
        Column column = new Column(ageSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getBreedingPeriodEnd3();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setBreedingPeriodEnd3((String) value);
                table.redraw();
            }
        });
    }

    private static void addBreedingPeriodEnd4Column(final CellTable table, String screenColumnName) {
        Column column = new Column(ageSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getBreedingPeriodEnd4();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setBreedingPeriodEnd4((String) value);
                table.redraw();
            }
        });
    }

    private static void addBreedingPeriodEnd5Column(final CellTable table, String screenColumnName) {
        Column column = new Column(ageSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getBreedingPeriodEnd5();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setBreedingPeriodEnd5((String) value);
                table.redraw();
            }
        });
    }

    private static void addBreedingPeriodEnd6Column(final CellTable table, String screenColumnName) {
        Column column = new Column(ageSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getBreedingPeriodEnd6();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setBreedingPeriodEnd6((String) value);
                table.redraw();
            }
        });
    }

    private static void addBreedingPeriodEnd7Column(final CellTable table, String screenColumnName) {
        Column column = new Column(ageSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getBreedingPeriodEnd7();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setBreedingPeriodEnd7((String) value);
                table.redraw();
            }
        });
    }

    private static void addDeathPeriodStart1Column(final CellTable table, String screenColumnName) {
        Column column = new Column(ageSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getDeathPeriodStart1();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setDeathPeriodStart1((String) value);
                table.redraw();
            }
        });
    }

    private static void addDeathPeriodStart2Column(final CellTable table, String screenColumnName) {
        Column column = new Column(ageSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getDeathPeriodStart2();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setDeathPeriodStart2((String) value);
                table.redraw();
            }
        });
    }

    private static void addDeathPeriodStart3Column(final CellTable table, String screenColumnName) {
        Column column = new Column(ageSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getDeathPeriodStart3();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setDeathPeriodStart3((String) value);
                table.redraw();
            }
        });
    }

    private static void addDeathPeriodStart4Column(final CellTable table, String screenColumnName) {
        Column column = new Column(ageSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getDeathPeriodStart4();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setDeathPeriodStart4((String) value);
                table.redraw();
            }
        });
    }

    private static void addDeathPeriodStart5Column(final CellTable table, String screenColumnName) {
        Column column = new Column(ageSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getDeathPeriodStart5();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setDeathPeriodStart5((String) value);
                table.redraw();
            }
        });
    }

    private static void addDeathPeriodStart6Column(final CellTable table, String screenColumnName) {
        Column column = new Column(ageSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getDeathPeriodStart6();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setDeathPeriodStart6((String) value);
                table.redraw();
            }
        });
    }

    private static void addDeathPeriodStart7Column(final CellTable table, String screenColumnName) {
        Column column = new Column(ageSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getDeathPeriodStart7();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setDeathPeriodStart7((String) value);
                table.redraw();
            }
        });
    }

    private static void addDeathPeriodEnd1Column(final CellTable table, String screenColumnName) {
        Column column = new Column(ageSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getDeathPeriodEnd1();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setDeathPeriodEnd1((String) value);
                table.redraw();
            }
        });
    }

    private static void addDeathPeriodEnd2Column(final CellTable table, String screenColumnName) {
        Column column = new Column(ageSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getDeathPeriodEnd2();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setDeathPeriodEnd2((String) value);
                table.redraw();
            }
        });
    }

    private static void addDeathPeriodEnd3Column(final CellTable table, String screenColumnName) {
        Column column = new Column(ageSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getDeathPeriodEnd3();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setDeathPeriodEnd3((String) value);
                table.redraw();
            }
        });
    }

    private static void addDeathPeriodEnd4Column(final CellTable table, String screenColumnName) {
        Column column = new Column(ageSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getDeathPeriodEnd4();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setDeathPeriodEnd4((String) value);
                table.redraw();
            }
        });
    }

    private static void addDeathPeriodEnd5Column(final CellTable table, String screenColumnName) {
        Column column = new Column(ageSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getDeathPeriodEnd5();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setDeathPeriodEnd5((String) value);
                table.redraw();
            }
        });
    }

    private static void addDeathPeriodEnd6Column(final CellTable table, String screenColumnName) {
        Column column = new Column(ageSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getDeathPeriodEnd6();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setDeathPeriodEnd6((String) value);
                table.redraw();
            }
        });
    }

    private static void addDeathPeriodEnd7Column(final CellTable table, String screenColumnName) {
        Column column = new Column(ageSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getDeathPeriodEnd7();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setDeathPeriodEnd7((String) value);
                table.redraw();
            }
        });
    }

    private static void addDeathPeriodProbability1Column(final CellTable table, String screenColumnName) {
        Column column = new Column(probabilitySelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getDeathPeriodProbability1();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setDeathPeriodProbability1((String) value);
                table.redraw();
            }
        });
    }

    private static void addDeathPeriodProbability2Column(final CellTable table, String screenColumnName) {
        Column column = new Column(probabilitySelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getDeathPeriodProbability2();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setDeathPeriodProbability2((String) value);
                table.redraw();
            }
        });
    }

    private static void addDeathPeriodProbability3Column(final CellTable table, String screenColumnName) {
        Column column = new Column(probabilitySelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getDeathPeriodProbability3();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setDeathPeriodProbability3((String) value);
                table.redraw();
            }
        });
    }

    private static void addDeathPeriodProbability4Column(final CellTable table, String screenColumnName) {
        Column column = new Column(probabilitySelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getDeathPeriodProbability4();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setDeathPeriodProbability4((String) value);
                table.redraw();
            }
        });
    }

    private static void addDeathPeriodProbability5Column(final CellTable table, String screenColumnName) {
        Column column = new Column(probabilitySelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getDeathPeriodProbability5();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setDeathPeriodProbability5((String) value);
                table.redraw();
            }
        });
    }

    private static void addDeathPeriodProbability6Column(final CellTable table, String screenColumnName) {
        Column column = new Column(probabilitySelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getDeathPeriodProbability6();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setDeathPeriodProbability6((String) value);
                table.redraw();
            }
        });
    }

    private static void addDeathPeriodProbability7Column(final CellTable table, String screenColumnName) {
        Column column = new Column(probabilitySelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getDeathPeriodProbability7();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setDeathPeriodProbability7((String) value);
                table.redraw();
            }
        });
    }

    private static void addIsPairRequiredColumn(final CellTable table, String screenColumnName) {
        Column column = new Column(booleanSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getIsPairRequired();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setIsPairRequired((String) value);
                table.redraw();
            }
        });
    }

    private static void addChildrenQuantityColumn(final CellTable table, String screenColumnName) {
        Column column = new Column(quantitySelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getChildrenQuantityPerPeriod();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setChildrenQuantityPerPeriod((String) value);
                table.redraw();
            }
        });
    }

    private static void addIsBreedingSynchronousColumn(final CellTable table, String screenColumnName) {
        Column column = new Column(booleanSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getIsBreedingSynchronous();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setIsBreedingSynchronous((String) value);
                table.redraw();
            }
        });
    }

    private static void addInitialQuantityColumn(final CellTable table, String screenColumnName) {
        Column column = new Column(quantitySelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getInitialQuantity();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setInitialQuantity((String) value);
                table.redraw();
            }
        });
    }

    private static void addInitialFieldXColumn(final CellTable table, String screenColumnName) {
        Column column = new Column(fieldSizeSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getInitialFieldX();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setInitialFieldX((String) value);
                table.redraw();
            }
        });
    }

    private static void addInitialFieldYColumn(final CellTable table, String screenColumnName) {
        Column column = new Column(fieldSizeSelectionCell) {
            public String getValue(Object object) {
                return ((SpeciesParameters) object).getInitialFieldY();
            }
        };
        table.addColumn(column, screenColumnName);
        column.setFieldUpdater(new FieldUpdater() {
            public void update(int index, Object object, Object value) {
                ((SpeciesParameters) object).setInitialFieldY((String) value);
                table.redraw();
            }
        });
    }
}
