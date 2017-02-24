/**
 * Created on 08.02.2017
 */
package de.loonymonkey.tasker.backend.file;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import de.loonymonkey.tasker.model.api.Task;

import java.time.LocalDateTime;

/**
 * @author Frank Scho&ouml;nheit
 */
@JsonPropertyOrder({"title", "notes", "subtasks"})
class JacksonSerializableTask extends JacksonSerializableProjectItem implements Task {
    @JsonProperty
    private boolean completed;
    @JsonProperty
    private LocalDateTime completionDate;

    @SuppressWarnings("unused")
    private JacksonSerializableTask() {
    }

    JacksonSerializableTask(final String title) {
        super(title);
    }

    @Override
    public boolean isCompleted() {
        return this.completed;
    }

    @Override
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public LocalDateTime getCompletionDate() {
        return this.completionDate;
    }

    @Override
    public void setCompletionDate(LocalDateTime completionDate) {
        this.completionDate = completionDate;
    }
}
