package de.loonymonkey.tasker.model.impl;

import de.loonymonkey.tasker.model.api.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SubTaskContainer {
    private final List<Task> subtasks = new ArrayList<>();

    SubTaskContainer() {
    }

    List<Task> getSubtasks() {
        return Collections.unmodifiableList(this.subtasks);
    }
}
