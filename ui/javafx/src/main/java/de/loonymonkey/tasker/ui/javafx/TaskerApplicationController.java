/**
 * Created on 09.02.2017
 */
package de.loonymonkey.tasker.ui.javafx;

import de.loonymonkey.tasker.backend.file.HardcodedYamlFileProjectLoader;
import de.loonymonkey.tasker.model.api.Project;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Frank Scho&ouml;nheit
 */
public class TaskerApplicationController implements Initializable {
    private ResourceBundle resources;

    @FXML
    TreeTableView<FXTask> viewTasks;
    @FXML
    private TreeTableColumn<FXTask, String> viewTaskTitle;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resources = resources;
        viewTaskTitle.setCellValueFactory(new TreeItemPropertyValueFactory<FXTask, String>("title"));

        final Project project = new HardcodedYamlFileProjectLoader().getProjectSingleton();
        final FXTask rootTask = new FXTask(project);
        final TreeItem<FXTask> rootItem = new TreeItem<>(rootTask);
        viewTasks.setRoot(rootItem);
    }
}
