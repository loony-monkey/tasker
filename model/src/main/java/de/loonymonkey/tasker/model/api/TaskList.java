package de.loonymonkey.tasker.model.api;

import javax.validation.constraints.NotNull;
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
    @NotNull
    List<Task> getSubtasks();
}
