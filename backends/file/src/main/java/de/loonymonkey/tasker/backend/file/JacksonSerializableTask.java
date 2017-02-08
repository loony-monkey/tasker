/**
 * Created on 08.02.2017
 */
package de.loonymonkey.tasker.backend.file;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import de.loonymonkey.tasker.model.api.Task;

import java.util.Objects;

/**
 * @author Frank Scho&ouml;nheit
 */
@JsonPropertyOrder({"title", "notes", "subtasks"})
class JacksonSerializableTask extends JacksonSerializableTaskContainer implements Task {
    @JsonProperty
    private String title;
    @JsonProperty
    private String notes;

    @SuppressWarnings("unused")
    private JacksonSerializableTask() {
    }

    JacksonSerializableTask(final String title) {
        this.title = Objects.requireNonNull(title, "|title| must not be null!");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
