/**
 * Created on 09.02.2017
 */
package de.loonymonkey.tasker.ui.javafx.components;

import de.loonymonkey.tasker.model.api.Task;
import de.loonymonkey.tasker.ui.javafx.model.FXProjectItem;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

/**
 * @author Frank Scho&ouml;nheit
 */
public class TaskTreeItem extends TreeItem<FXProjectItem> {
    public TaskTreeItem(final FXProjectItem task) {
        super(task);
        transferChildren();
    }

    private void transferChildren() {
        final ObservableList<TreeItem<FXProjectItem>> children = super.getChildren();
        for (final Task child : getValue().getSubtasks()) {
            children.add(new TaskTreeItem(FXProjectItem.from(child)));
        }
    }
}
