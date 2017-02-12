/**
 * Created on 09.02.2017
 */
package de.loonymonkey.tasker.ui.javafx.components;

import de.loonymonkey.tasker.model.api.Task;
import de.loonymonkey.tasker.ui.javafx.model.FXTask;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

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
        for (final Task child : getValue().getSubtasks()) {
            children.add(new TaskTreeItem(FXTask.from(child)));
        }
    }
}
