package de.loonymonkey.tasker.model.api;

import javax.validation.constraints.NotNull;

/**
 * @author Frank Scho&ouml;nheit
 */
public interface TaskListItem extends TaskList {
    @NotNull
    String getTitle();
}
