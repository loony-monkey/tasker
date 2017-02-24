/**
 * Created on 04.02.2017
 */
package de.loonymonkey.tasker.swingui.model;

import de.loonymonkey.tasker.model.api.Task;
import de.loonymonkey.tasker.model.api.ProjectItem;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * @author Frank Scho&ouml;nheit
 */
public class TaskNode implements TreeNode {
    private final TaskNode parent;
    private final ProjectItem taskItem;

    public TaskNode(final TaskNode parent, final ProjectItem taskItem) {
        this.parent = parent;
        this.taskItem = Objects.requireNonNull(taskItem, "|taskItem| must not be null!");
    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        final Task subtask = this.taskItem.getSubtasks().get(childIndex);
        return new TaskNode(this, subtask);
    }

    @Override
    public int getChildCount() {
        return this.taskItem.getSubtasks().size();
    }

    @Override
    public TreeNode getParent() {
        return parent;
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
        final List<Task> subtasks = new ArrayList<>(this.taskItem.getSubtasks());
        final Iterator<Task> taskIterator = subtasks.iterator();
        return new Enumeration<TreeNode>() {

            @Override
            public boolean hasMoreElements() {
                return taskIterator.hasNext();
            }

            @Override
            public TreeNode nextElement() {
                return new TaskNode(TaskNode.this, taskIterator.next());
            }
        };
    }

    @Override
    public String toString() {
        return this.taskItem.getTitle();
    }
}
