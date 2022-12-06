package builder;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;
import java.util.*;

/**
 *  Product builder class for ViewChart, creates a new filter from
 *  an instance of ViewBarChart.
 */

public class ViewChartSort extends ViewChartFilter {
    /**
     * ViewChartSort class constructor
     *
     * @param visual      a ViewBarChart
     * @param borderPane2 a BorderPane
     */
    private ChoiceBox choicebox;
    private List<Map.Entry<String, Integer>> sorted;

    public ViewChartSort(ViewBarChart visual, BorderPane borderPane2) {
        super(visual, borderPane2);
    }
    /**
     * Creates a new ChoiceBox object
     */
    public void createSortMap() {
        ObservableList<String> filterList = FXCollections.observableArrayList();
        filterList.add("ascending");
        filterList.add("descending");
        choicebox = new ChoiceBox(filterList);
        choicebox.setValue("Sort");
        choicebox.setStyle("-fx-font: 10 arial");
        borderPane2.setBottom(choicebox);
    }

    /**
     * Mutates the HashMap attribute "dataMap" of a ViewBarChart instance into ascending order based
     * on its key values.
     */
    public void ascendingOrderMap(ViewBarChart visual) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(visual.dataMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e1.getValue() - e2.getValue();}});
        visual.dataMap.clear();
        visual.dataMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> a : list) {
            visual.dataMap.put(a.getKey(), a.getValue());}
    }

    /**
     * Mutates the HashMap attribute "dataMap" of a ViewBarChart instance into descending order based
     * on its key values.
     */
    public void descendingOrderMap(ViewBarChart visual) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(visual.dataMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e2.getValue() - e1.getValue();}});
        visual.dataMap.clear();
        visual.dataMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> a : list) {
            visual.dataMap.put(a.getKey(), a.getValue());}
    }
    /**
     * Sorts current BarChart visual.
     */
    public void sortChart() {
        choicebox.getSelectionModel().selectedItemProperty().addListener((v, ov, nv) -> {
            if (nv == "ascending") {
                ascendingOrderMap(visual);
                visual.chartView();
            }
            if (nv == "descending") {
                descendingOrderMap(visual);
                visual.chartView();
            }
        });
    }
}





