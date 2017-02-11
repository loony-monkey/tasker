/**
 * Created on 09.02.2017
 */
package de.loonymonkey.tasker.ui.javafx;

import de.loonymonkey.tasker.backend.file.HardcodedYamlFileProjectLoader;
import de.loonymonkey.tasker.model.api.Project;
import de.loonymonkey.tasker.ui.javafx.model.FXTask;
import de.loonymonkey.tasker.ui.javafx.components.TaskTreeItem;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Frank Scho&ouml;nheit
 */
public class JavaFXApplicationController implements Initializable {
    private ResourceBundle resources;

    @FXML
    TreeTableView<FXTask> viewTasks;
    @FXML
    private TreeTableColumn<FXTask, String> viewTaskTitle;
    @FXML
    private TreeTableColumn<FXTask, Boolean> viewTaskCompleted;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resources = resources;

        viewTasks.setShowRoot(false);

        viewTaskTitle.setCellValueFactory(new TreeItemPropertyValueFactory<FXTask, String>("title"));
        viewTaskCompleted.setCellValueFactory(new TreeItemPropertyValueFactory<FXTask, Boolean>("completed"));

        final Project project = new HardcodedYamlFileProjectLoader().getProjectSingleton();
        final FXTask rootTask = new FXTask(project);
        final TaskTreeItem rootItem = new TaskTreeItem(rootTask);
        viewTasks.setRoot(rootItem);
    }
}
