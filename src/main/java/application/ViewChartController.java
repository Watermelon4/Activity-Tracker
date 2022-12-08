package application;

import builder.ViewBarChart;
import builder.ViewChartFilter;
import builder.ViewChartSort;
import command.frame.*;
import database.CurrentChecklist;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.io.IOException;


public class ViewChartController {

    @FXML
    private Button mainScreen;

    @FXML
    private BorderPane borderPane;

    @FXML
    private BorderPane borderPaneFilter;

    private ClickableFrameInvoker frameInvoker;

    @FXML
    public void initialize() {
        // create receiver
        IClickableFrame frameReceiver = new ClickableFrameReceiver();

        // Pass reference to the frameReceiver instance to each concrete command
        IFrameCommand clickSettingsCommand = new ClickSettingsFrame(frameReceiver);
        IFrameCommand clickCreateCommand = new ClickCreateFrame(frameReceiver);
        IFrameCommand clickChecklistCommand = new ClickChecklistFrame(frameReceiver);
        IFrameCommand clickStartCommand = new ClickStartFrame(frameReceiver);
        IFrameCommand clickChartCommand = new ClickChartFrame(frameReceiver);

        // Pass instances of the Command objects to the invoker
        this.frameInvoker = new ClickableFrameInvoker(clickSettingsCommand, clickCreateCommand, clickChecklistCommand, clickStartCommand, clickChartCommand);
    }

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

