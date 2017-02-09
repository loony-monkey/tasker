/**
 * Created on 09.02.2017
 */
package de.loonymonkey.tasker.ui.javafx.components;

import de.loonymonkey.tasker.model.api.Task;
import de.loonymonkey.tasker.model.api.TaskListItem;
import de.loonymonkey.tasker.ui.javafx.model.FXTask;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

import java.util.List;

/**
 * @author Frank Scho&ouml;nheit
 */
public class TaskTreeItem extends TreeItem<FXTask> {
    public TaskTreeItem(final FXTask task) {
        super(task);
        transferChildren();
    }

    private void transferChildren() {
        final ObservableList<TreeItem<FXTask>> children = super.getChildren();

        final TaskListItem listItem = getValue().getTaskListItem();
        final List<Task> subtasks = listItem.getSubtasks();
        for (final Task task : subtasks) {
            children.add(new TaskTreeItem(new FXTask(task)));
        }
    }
}
