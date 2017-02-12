/**
 * Created on 09.02.2017
 */
package de.loonymonkey.tasker.ui.javafx.model;

import de.loonymonkey.tasker.model.api.Project;
import de.loonymonkey.tasker.model.api.Task;
import de.loonymonkey.tasker.model.api.TaskListItem;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * an JavaFX-version of a {@link Task} - basically an adapter from an arbitrary {@link Task} implementation into the
 * JavaFX beans world.
 *
 * @author Frank Scho&ouml;nheit
 */
public class FXTask implements Task {
    // TODO: not sure it really makes sense to subclass from Task here...
    private StringProperty title;
    private StringProperty notes;
    private BooleanProperty completed;
    private SimpleObjectProperty completionDate;

    private List<Task> subtasks;

    private FXTask(final TaskListItem item) {
        setTitle(item.getTitle());
        this.subtasks = new ArrayList<>(item.getSubtasks());
    }

    /**
     * creates an instance having the same property values as the given {@link Project}, as far as applicable.
     * <p>Note that at the moment, there's no dyanmic relationship between the two implementations. Changing the one
     * doesn't affect the other in any way.</p>
     * <p>
     * <p>TODO: We might want to change this, and implement dynamic binding.</p>
     *
     * @param project
     * @return
     */
    public static FXTask from(Project project) {
        final FXTask fxProject = new FXTask(project);
        return fxProject;
    }

    /**
     * creates an instance having the same property values as the given {@link Task}
     * <p>Note that at the moment, there's no dyanmic relationship between the two task implementations. Changing the one
     * doesn't affect the other in any way.</p>
     * <p>
     * <p>TODO: We might want to change this, and implement dynamic binding.</p>
     *
     * @param task
     * @return
     */
    public static FXTask from(final Task task) {
        final FXTask fxTask = new FXTask(task);
        fxTask.setNotes(task.getNotes());
        fxTask.setCompleted(task.isCompleted());
        fxTask.setCompletionDate(task.getCompletionDate());
        return fxTask;
    }

    @Override
    public List<Task> getSubtasks() {
        return this.subtasks;
    }

    @Override
    public String getNotes() {
        return notesProperty().get();
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

    @Override
    public String getTitle() {
        return titleProperty().get();
    }

    void setTitle(final String title) {
        titleProperty().set(title);
    }

    public StringProperty titleProperty() {
        if (this.title == null)
            this.title = new SimpleStringProperty(this, "title");
        return this.title;
    }

    public StringProperty notesProperty() {
        if (this.notes == null)
            this.notes = new SimpleStringProperty(this, "notes");
        return this.notes;
    }

    public BooleanProperty completedProperty() {
        if (this.completed == null)
            this.completed = new SimpleBooleanProperty(this, "completed");
        return this.completed;
    }

    public ObjectProperty completionDateProperty() {
        if (this.completionDate == null)
            this.completionDate = new SimpleObjectProperty(this, "completionDate");
        return this.completionDate;
    }
}
