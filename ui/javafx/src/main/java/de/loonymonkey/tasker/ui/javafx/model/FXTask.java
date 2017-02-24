/**
 * Created on 24.02.2017
 */
package de.loonymonkey.tasker.ui.javafx.model;

import de.loonymonkey.tasker.model.api.Task;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author Frank Scho&ouml;nheit
 */
class FXTask extends FXProjectItem implements Task {
    FXTask(final Task item) {
        super(item);
    }

    @Override
    public Optional<String> getNotes() {
        return Optional.ofNullable(notesProperty().get());
    }

    public void setNotes(final String notes) {
        notesProperty().set(notes);
    }

    @Override
    public boolean isCompleted() {
        return completedProperty().get();
    }

    @Override
    public void setCompleted(boolean completed) {
        completedProperty().set(completed);
    }

    @Override
    public LocalDateTime getCompletionDate() {
        return LocalDateTime.class.cast(completionDateProperty().get());
    }

    @Override
    public void setCompletionDate(LocalDateTime completionDate) {
        completionDateProperty().set(completionDate);
    }
}
