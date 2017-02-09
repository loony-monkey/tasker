/**
 * Created on 09.02.2017
 */
package de.loonymonkey.tasker.ui.javafx;

import de.loonymonkey.tasker.model.api.TaskListItem;
import org.apache.commons.lang3.NotImplementedException;

import java.util.Objects;

/**
 * @author Frank Scho&ouml;nheit
 */
public class FXTask {
    private final TaskListItem task;

    public FXTask(final TaskListItem task) {
        this.task = Objects.requireNonNull(task, "|task| must not be null!");
    }

    public void setTitle(final String title) {
        throw new NotImplementedException("this class is immutable, actually");
    }

    public String getTitle() {
        return this.task.getTitle();
    }

//    public StringProperty titleProperty() {
//        return title;
//    }
}
