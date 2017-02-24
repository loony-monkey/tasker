/**
 * Created on 08.02.2017
 */
package de.loonymonkey.tasker.backend.file;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import de.loonymonkey.tasker.model.api.ProjectItem;
import de.loonymonkey.tasker.model.api.Task;
import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Frank Scho&ouml;nheit
 */
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"title", "notes", "subtasks"})
class JacksonSerializableProjectItem implements ProjectItem {
    @JsonProperty
    private String title;
    // no @JsonProperty here, see #getNullableNotes
    private Optional<String> notes = Optional.empty();
    @JsonProperty
    private final List<JacksonSerializableTask> subtasks = new ArrayList<>();

    protected JacksonSerializableProjectItem() {
        title = null;
    }

    protected JacksonSerializableProjectItem(final String title) {
        this.title = Objects.requireNonNull(title, "|title| must not be null!");
    }

    public JacksonSerializableProjectItem(String title, String notes) {
        this(title);
        setNotes(notes);
    }

    @Override
    public List<Task> getSubtasks() {
        return Collections.unmodifiableList(this.subtasks);
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Optional<String> getNotes() {
        return this.notes;
    }

    public void setNotes(final String notes) {
        this.notes = Optional.of(notes);
    }

    public void clearNotes() {
        this.notes = Optional.empty();
    }

    @JsonProperty("notes")
    public String getNullableNotes() {
        return this.notes.orElse(null);
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
