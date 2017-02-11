package de.loonymonkey.tasker.model.api;

import java.util.List;

/**
 * a list of {@link Task}s
 */
public interface TaskList {
    /**
     * returns an immutable view to the current sub tasks of the element.
     *
     * @return an immutable view to the current sub tasks of the element.
     */
    List<Task> getSubtasks();
}
