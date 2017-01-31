package de.loonymonkey.tasker.model.api;

/**
 * a task. Well, something which will represent a task when it's grown up.
 */
public interface Task extends TaskList {
    public abstract String getTitle();
    public abstract String getNotes();
}
