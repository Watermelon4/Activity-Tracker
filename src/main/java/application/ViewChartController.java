package application;

import builder.ViewBarChart;
import builder.ViewChartFilter;
import builder.ViewChartSort;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;


public class ViewChartController {
    @FXML
    private BorderPane borderPane;

    @FXML
    private BorderPane borderPaneFilter;


    public ViewChartController() {
    }

    /**
     * Displays the previous frame.
     * @throws IOException buildScene load error
     */
    public void showPrevious() throws IOException {
        frameInvoker.clickPrevious(frameInvoker.popFrameStack());
    }

    @FXML
    private void handleShowBarChart(ActionEvent event){
        HashMap dailyList = FileManager.getInstance().getCurrChecklist();
        ViewBarChart visual  = new ViewBarChart(dailyList,borderPane);
        visual.chartView();
        ViewChartFilter filter = new ViewChartFilter(visual,borderPaneFilter);
        filter.createFilterMap();
        filter.filterChart(visual);
        ViewChartSort sort = new ViewChartSort(visual,borderPaneFilter);
        sort.createSortMap();
        sort.sortChart();

    }

}

