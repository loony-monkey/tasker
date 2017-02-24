/**
 * Created on 09.02.2017
 */
package de.loonymonkey.tasker.ui.javafx;

import de.loonymonkey.tasker.backend.file.HardcodedYamlFileProjectLoader;
import de.loonymonkey.tasker.model.api.Project;
import de.loonymonkey.tasker.ui.javafx.components.TaskTreeItem;
import de.loonymonkey.tasker.ui.javafx.model.FXProjectItem;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.CheckBoxTreeTableCell;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Frank Scho&ouml;nheit
 */
public class JavaFXApplicationController implements Initializable {
    private ResourceBundle resources;

    @FXML
    TreeTableView<FXProjectItem> viewTasks;
    @FXML
    private TreeTableColumn<FXProjectItem, String> viewTaskTitle;
    @FXML
    private TreeTableColumn<FXProjectItem, Boolean> viewTaskCompleted;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resources = resources;

        viewTasks.setShowRoot(false);

        viewTaskTitle.setCellValueFactory(new TreeItemPropertyValueFactory<FXProjectItem, String>("title"));
        viewTaskCompleted.setCellValueFactory(new TreeItemPropertyValueFactory<FXProjectItem, Boolean>("completed"));

        viewTaskCompleted.setCellValueFactory(f -> f.getValue().getValue().completedProperty());
        viewTaskCompleted.setCellFactory(tc -> new CheckBoxTreeTableCell<>());

        final Project project = new HardcodedYamlFileProjectLoader().getProjectSingleton();
        // Build an JavaFX representation of the project. Note there's currently no bi-directional relationship:
        // Changes done to the JavaFX version are not reflected in the original project.
        // TODO: change this...
        final FXProjectItem fxProject = FXProjectItem.from(project);
        final TaskTreeItem rootItem = new TaskTreeItem(fxProject);
        viewTasks.setRoot(rootItem);
    }
}
