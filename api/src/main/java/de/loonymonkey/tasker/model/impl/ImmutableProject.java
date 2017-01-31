package de.loonymonkey.tasker.model.impl;

import de.loonymonkey.tasker.model.api.Project;
import de.loonymonkey.tasker.model.api.Task;

import java.util.List;
import java.util.Objects;

/**
 * a rudimentary implementation of the {@link Project} interface, which will probably never be used :)
 */
public class ImmutableProject implements Project {
    private final SubTaskContainer subtasks = new SubTaskContainer();
    private final String title;

    public ImmutableProject(final String title) {
        this.title = Objects.requireNonNull(title);
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<Task> getSubtasks() {
        return subtasks.getSubtasks();
    }
}
