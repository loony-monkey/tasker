package de.loonymonkey.tasker.ui.javafx;/**
 * @author Frank Scho&ouml;nheit
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class JavaFXApplication extends Application {

    @Override
    public void start(final Stage stage) throws Exception {
        ResourceBundle resources;
        final String bundleName = "bundles.tasker";
        try {
            resources = ResourceBundle.getBundle(bundleName, Locale.getDefault());
        } catch (MissingResourceException e) {
            Locale.setDefault(Locale.ENGLISH);
            resources = ResourceBundle.getBundle(bundleName, Locale.getDefault());
        }

        // Load scene
        stage.setTitle("Tasker");
        stage.setScene(new Scene(FXMLLoader.load(JavaFXApplication.class.getResource("/fxml/tasker.fxml"), resources)));
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
