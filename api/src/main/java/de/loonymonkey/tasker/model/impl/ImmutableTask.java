package de.loonymonkey.tasker.model.impl;

import de.loonymonkey.tasker.model.api.Task;

import java.util.List;
import java.util.Objects;

/**
 * a rudimentary implementation of the {@link Task} interface, which will probably never be used :)
 */
public class ImmutableTask implements Task {
    private final String title;
    private final String notes = "";
    private final SubTaskContainer subtasks = new SubTaskContainer();

    public ImmutableTask(final String title) {
        this.title = Objects.requireNonNull(title);
    }

    public String getTitle() {
        return this.title;
    }

    public String getNotes() {
        return notes;
    }

    public List<Task> getSubtasks() {
        return subtasks.getSubtasks();
    }
}
