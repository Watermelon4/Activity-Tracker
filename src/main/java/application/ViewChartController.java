package application;

import builder.ViewBarChart;
import builder.ViewChartFilter;
import builder.ViewChartSort;
import database.CurrentChecklist;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;


public class ViewChartController {
    @FXML
    private Button mainScreen;

    @FXML
    private BorderPane borderPane;

    @FXML
    private BorderPane borderPaneFilter;

    public ViewChartController() {
    }
    @FXML
    private void handleShowBarChart(ActionEvent event){
        CurrentChecklist daily = new CurrentChecklist("test");//name: showed be retrieved from user input
        ViewBarChart visual  = new ViewBarChart(daily, daily.getHabitCounts(),borderPane);
        visual.chartView();
        ViewChartFilter filter = new ViewChartFilter(visual,borderPaneFilter);
        filter.createFilterMap();
        filter.filterChart(visual);
        ViewChartSort sort = new ViewChartSort(visual,borderPaneFilter);
        sort.createSortMap();
        sort.sortChart();

    }

}

