package sceneBuilder;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class ApplicationScenes {

    /**
     * The hashmap containing scene names to scenes.
     */
    private HashMap<String, Scene> scenes;

    /**
     * The hashmap that tracks the globally applied styles.
     */
    private HashMap<String, String> appliedStylesheets;

    /**
     * The application stage.
     */
    private final Stage stage;

    private static String PATH = "stylesheets/";

    /**
     * Constructor for the ApplicationScenes class. Initializes with the default stylesheet.
     * @param stage the application stage
     * @throws IOException load error
     */
    public ApplicationScenes(Stage stage) throws IOException {
        this.scenes = new HashMap<>();
        this.appliedStylesheets = new HashMap<>();
        this.stage = stage;
        initializeScenes();
    }

    /**
     * Builds scenes and sets the default stylesheet.
     * @throws IOException load error
     */
    private void initializeScenes() throws IOException {
        SceneBuilder sceneBuilder = new SceneBuilder(this);
        sceneBuilder.buildScenes();
        this.applyStylesheet("default", "default.css");
    }

    /**
     * Adds an application scene to the ApplicationScenes map.
     * @param name the fxml file name of the scene?
     * @param scene the scene to add
     */
    protected void addScene(String name, Scene scene) {
        this.scenes.put(name, scene);
    }

    /**
     * Displays a scene from the application.
     * @param name the fxml file name to display
     */
    public void showScene(String name) {
        stage.setScene(scenes.get(name));
        stage.show();
    }

    /**
     * Applies a stylesheet to all frames in the application. If the type of stylesheet has previously been applied, it
     * will be replaced with the new stylesheet
     * @param type the type of stylesheet that is being applied
     * @param stylesheet the css file name of the new stylesheet to apply
     */
    public void applyStylesheet(String type, String stylesheet) {
       if (appliedStylesheets.containsKey(type)) {  // remove old stylesheet
           for (Scene scene : scenes.values()) {
               scene.getStylesheets().remove(PATH + appliedStylesheets.get(type));
               scene.getStylesheets().add(PATH + stylesheet);
           }
           // replace with the new stylesheet
           appliedStylesheets.replace(type, stylesheet);
       } else {
           for (Scene scene : scenes.values()) {
               scene.getStylesheets().add(PATH + stylesheet);
           }
           // add the new stylesheet to the record
           appliedStylesheets.put(type, stylesheet);
       }
    }

    /**
     * Applies a stylesheet to all frames in the application. If the type of stylesheet has previously been applied, it
     * will be replaced with the new stylesheet
     * @param type the type of stylesheet that is being applied
     * @param stylesheet the css file name of the new stylesheet to apply
     */
    public void removeStylesheet(String type, String stylesheet) {
        for (Scene scene : scenes.values()) {
            scene.getStylesheets().remove(PATH + stylesheet);
        }
        // remove from applied
        appliedStylesheets.remove(type, stylesheet);
    }

}
