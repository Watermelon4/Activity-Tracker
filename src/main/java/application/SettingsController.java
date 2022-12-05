package application;

import command.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Pane;

public class SettingsController {
    @FXML
    private Label welcomeText;
    @FXML
    private Pane root;

    @FXML
    private SplitPane splitP;

    IToggleable contrast = new ToggleableContrast(false);
    ICommand contrastToggle = new ToggleCommand(contrast);
    ToggleableInvoker contrastCommands = new ToggleableInvoker(contrastToggle);

    IToggleable nightMode = new ToggleableNight(false);
    ICommand nightModeToggle = new ToggleCommand(nightMode);
    ToggleableInvoker nightModeCommands = new ToggleableInvoker(nightModeToggle);


    public void onLightTheme(ActionEvent actionEvent) {
        root.getStylesheets().remove("stylesheets/stylesheet-dark-theme.css");
        root.getStylesheets().add("stylesheets/stylesheet-light-theme.css");
    }

    public void onDarkTheme(ActionEvent actionEvent) {
        // root.getStylesheets().remove("stylesheet-light-theme.css");
        // root.getStylesheets().add("stylesheet-dark-theme.css");
    }

    public void onHighContrast(ActionEvent actionEvent) {
        contrastCommands.toggle();
    }
    public void onNightMode(ActionEvent actionEvent) { nightModeCommands.toggle(); }

    public void onLargeFont(ActionEvent actionEvent) {
        root.getStylesheets().remove("stylesheets/stylesheet-small-font.css");
        root.getStylesheets().add("stylesheets/stylesheet-large-font.css");
    }

    public void onSmallFont(ActionEvent actionEvent) {
        root.getStylesheets().remove("stylesheets/stylesheet-large-font.css");
        root.getStylesheets().add("stylesheets/stylesheet-small-font.css");
    }
}