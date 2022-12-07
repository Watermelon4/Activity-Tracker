package builder;

import database.CurrentChecklist;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import java.util.HashMap;

/**
 *  Concrete builder class for ViewChart
 */

//limited number of instances and provide a global point of access to them.

public class ViewBarChart implements IViewChart{

    private final BorderPane borderPane;
    private final CurrentChecklist checklist;
    public  HashMap<String, Integer> dataMap;
    public  HashMap<String, Integer> tempHold;
    /**
     * ViewBarChart class constructor
     * @param borderPane1 a BorderPane
     * @param dataMap a HashMap
     * @param checkList a HashMap

     */

    public ViewBarChart(CurrentChecklist checkList, HashMap<String, Integer> dataMap, BorderPane borderPane1) {
        this.checklist = checkList;
        this.dataMap = checkList.getHabitCounts();
        this.tempHold = new HashMap<String, Integer>();
        this.borderPane = borderPane1;
    }
    /**
     * Creates a new Bar Chart visual
     */
@Override
    public void chartView(){
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Hobbies");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Count");
        BarChart barChart = new BarChart(xAxis,yAxis);
        barChart.getData().clear();
        XYChart.Series data = new XYChart.Series();
        data.setName("Hobby Tracker");
        try {
            for (String k : this.dataMap.keySet()) {
                data.getData().add(new XYChart.Data(k, this.dataMap.get(k)));
            }
            barChart.getData().add(data);
            barChart.setStyle("-fx-font-size: " + 10.7 + "px;");
            barChart.setLegendVisible(false);
            barChart.setTitle("Hobby Tracker");
            barChart.setVerticalGridLinesVisible(false);
            borderPane.setCenter(barChart);
        }catch (NullPointerException exception){
            System.out.println("No Hobbies were added to your list.");
            System.exit(1);
        }
    }
    /**
     *  returns dataMap attribute.
     */
    public HashMap<String, Integer> getDataMap(){
        return this.dataMap;
    }
    /**
     *  returns borderPane attribute.
     */
    public BorderPane getBorderPane(){
        return this.borderPane;
    }

}
