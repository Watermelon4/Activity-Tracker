package builder;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import org.controlsfx.control.CheckComboBox;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  Product builder class for ViewChart, creates a new filter from
 *  an instance of ViewBarChart.
 */
public class ViewChartFilter {

    private CheckComboBox checkComboBox;
    public ViewBarChart visual;
    public BorderPane borderPane2;
    /**
     * ViewFilterChart class constructor
     * @param visual a ViewBarChart
     * @param borderPane2 a BorderPane
     */

    public ViewChartFilter(ViewBarChart visual,BorderPane borderPane2 ) {
        this.borderPane2 = borderPane2;
        this.visual = visual;
    }

    /**
     * Creates a new CheckComboBox object
     */
    public void createFilterMap(){
        ObservableList<String> filterList = FXCollections.observableArrayList();
        filterList.addAll(this.visual.getDataMap().keySet());
        checkComboBox = new CheckComboBox<>(filterList);
        checkComboBox.setTitle("Filter");
        checkComboBox.setStyle("-fx-font: 10 arial");
        borderPane2.setBottom(checkComboBox);
        }

    /**
     * Filters current BarChart visual.
     */
        public void filterChart(ViewBarChart visual){
            checkComboBox.getCheckModel().getCheckedItems().addListener(new InvalidationListener() {
                @Override
                public void invalidated(Observable observable) {
                    Object h = Collections.<String>emptyList();
                    ArrayList<String> l = new ArrayList<String>();
                    for (Object o: getSelectedItems(checkComboBox)){
                        l.add(o.toString());
                    }
                    for (String s: l){
                        if (visual.getDataMap().containsKey(s)){
                            visual.tempHold.put(s, visual.dataMap.get(s));
                            visual.dataMap.remove(s);
                        }if (visual.tempHold.size() > 0){
                            for (String t: visual.tempHold.keySet()){
                               if (!l.contains(t)){
                                   visual.dataMap.put(t,visual.tempHold.get(t));
                               }
                            }
                        }
                    }
                        if (observable.toString() == "[]"){
                            for (String t: visual.tempHold.keySet()){
                                visual.dataMap.put(t,visual.tempHold.get(t));
                            }
                        }
                        visual.chartView();
                }
            });
    }
    /**
     * Returns list of filtered items.
     */
    public List<String> getSelectedItems(CheckComboBox<String> checkComboBox) {
        return checkComboBox.getCheckModel().getCheckedItems();

    }
}


