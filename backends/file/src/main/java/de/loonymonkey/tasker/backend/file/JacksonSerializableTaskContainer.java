/**
 * Created on 08.02.2017
 */
package de.loonymonkey.tasker.backend.file;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.loonymonkey.tasker.model.api.Task;
import de.loonymonkey.tasker.model.api.TaskList;
import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Frank Scho&ouml;nheit
 */
class JacksonSerializableTaskContainer implements TaskList {
    @JsonProperty
    private final List<JacksonSerializableTask> subtasks = new ArrayList<>();

    protected JacksonSerializableTaskContainer() {
    }

    @Override
    public List<Task> getSubtasks() {
        return Collections.unmodifiableList(this.subtasks);
    }

    void addSubtask(final JacksonSerializableTask subtask) {
        Validate.notNull(subtask, "|subtask| must not be null!");
        subtasks.add(subtask);
    }

    JacksonSerializableTask addSubtask(String title) {
        final JacksonSerializableTask task = new JacksonSerializableTask(title);
        addSubtask(task);
        return task;
    }
}
