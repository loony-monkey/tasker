/**
 * Created on 04.02.2017
 */
package de.loonymonkey.tasker.swingui.model;

import de.loonymonkey.tasker.model.api.TaskListItem;

import javax.swing.tree.TreeNode;
import java.util.Enumeration;
import java.util.Objects;

/**
 * @author Frank Scho&ouml;nheit
 */
public class TaskNode implements TreeNode {
    private final TaskListItem taskItem;

    public TaskNode(final TaskListItem taskItem) {
        this.taskItem = Objects.requireNonNull(taskItem, "|taskItem| must not be null!");
    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        // TODO
        return null;
    }

    @Override
    public int getChildCount() {
        // TODO
        return 0;
    }

    @Override
    public TreeNode getParent() {
        // TODO
        return null;
    }

    @Override
    public int getIndex(TreeNode node) {
        // TODO
        return 0;
    }

    @Override
    public boolean getAllowsChildren() {
        // TODO
        return false;
    }

    @Override
    public boolean isLeaf() {
        return this.taskItem.getSubtasks().isEmpty();
    }

    @Override
    public Enumeration children() {
        // TODO
        return null;
    }

    @Override
    public String toString() {
        return this.taskItem.getTitle();
    }
}
