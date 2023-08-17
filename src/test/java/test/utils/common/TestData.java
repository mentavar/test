package test.utils.common;

import test.utils.Test;
import test.utils.config.EnvDataConfig;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TestData {

    Test test;

    EnvDataConfig envDataConfig;

    public TestData(Test test) {
        this.test = test;
        envDataConfig = new EnvDataConfig();
    }

    public int getColumn(DataTable dTable, String label) {
        int column = 0;
        int k = 0;
        boolean flagNotFound = true;
        List<List<String>> rows = dTable.cells();
        for (List<String> cell : rows) {
            for (int i = 0; i < cell.size(); i++) {
                if (rows.get(k).get(i).equalsIgnoreCase(label)) {
                    column = i;
                    flagNotFound = false;
                    break;
                }
            }
            k++;
        }
        if (flagNotFound)
            column = -1;
        return column;
    }

    /*
     * |Label |Label2|
     * |Value |Value2|
     *
     * returns the value under every label
     */
    public String getValue(DataTable dTable, String label) {
        List<List<String>> rows = dTable.cells();
        int column = getColumn(dTable, label);
        if (column >= 0) {
            return rows.get(1).get(column);
        } else
            return null;
    }

    /*
     * |Label |Value |
     * |Label2|Value2|
     * |Label3|Value3|
     *
     * returns the value to the right of each label.
     */
    public String getValueLeftToRight(DataTable dt, String label) {
        String value = "";
        List<String> dataTable = dt.asList();
        int k = 0;
        for (String s : dataTable) {
            if (s.equalsIgnoreCase(label)) {
                value = dataTable.get(k + 1);
            }
            k++;
        }
        return value;
    }

    /**
     * @param arguments contains a datatable which contains a line per argument with 2 columns (variable, value) e.g.
     * @return
     */
    public String getArguments(DataTable arguments) {
        String argument = "";
        int k = 0;
        List<List<String>> rows = arguments.cells();
        for (List<String> cell : rows) {
            if (k == 0) {
                argument += "?";
            } else if (k > 0) {
                argument += "&";
            }
            argument += rows.get(k).get(0);
            argument += "=";
            argument += rows.get(k).get(1);
            k++;
        }
        return argument;
    }

    public List<String> getDataTable(DataTable dataTable) {
        List<String> dataTableRows = new ArrayList<>();
        int k = 0;
        String row = "";
        List<List<String>> rows = dataTable.cells();
        for (List<String> cell : rows) {
            for (int i = 0; i < cell.size(); i++) {
                row += rows.get(k).get(i);
                if (i < cell.size() - 1) {
                    row += "|";
                }
            }
            k++;
            dataTableRows.add(row);
            row = "";
        }
        return dataTableRows;
    }

    public int getDataTableRows(DataTable dataTable) {
        List<List<String>> rows = dataTable.asLists();
        return rows.size();
    }

    public int getColumnIndexByLabel(By by, String columnLabel) {

        int columnIndex = 0;

        for (int i = 0; i < test.webDriverFactory().getDriver().findElements(by).size(); i++) {
            if (test.webDriverFactory().getDriver().findElements(by).get(i).getText().equals(columnLabel)) {
                columnIndex = i + 1;
                break;
            }
        }
        return columnIndex;
    }

    public String getDateTime(String dateTime) {
        String dateEntry = null;
        if (dateTime != null && !dateTime.isEmpty()) {
            String[] parts = null;
            String dateFormat = null;
            String calCount = null;
            String calData = null;
            parts = dateTime.split(";");
            if (parts.length < 3) {
                dateFormat = parts[0];
                calCount = "0";
                calData = "";
            } else {
                dateFormat = parts[0];
                calCount = parts[1];
                calData = parts[2];
            }
            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
            Calendar today = Calendar.getInstance();
            switch (calData) {
                case "d":
                    today.add(Calendar.DATE, Integer.parseInt(calCount));
                    break;
                case "M":
                    today.add(Calendar.MONTH, Integer.parseInt(calCount));
                    break;
                case "y":
                    today.add(Calendar.YEAR, Integer.parseInt(calCount));
                    break;
                case "H":
                    today.add(Calendar.HOUR_OF_DAY, Integer.parseInt(calCount));
                    break;
                case "m":
                    today.add(Calendar.MINUTE, Integer.parseInt(calCount));
                    break;
                case "s":
                    today.add(Calendar.SECOND, Integer.parseInt(calCount));
                    break;
                default:
                    break;
            }
            dateEntry = sdf.format(today.getTime());
        }
        return dateEntry;
    }

}
