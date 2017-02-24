package de.loonymonkey.tasker.model.api;

import java.time.LocalDateTime;

/**
 * a task. Well, something which will represent a task when it's grown up.
 */
public interface Task extends ProjectItem {
    /**
     * determines whether the task is already completed.
     *
     * @return
     */
    boolean isCompleted();

    /**
     * controls whether the task is considered completed.
     *
     * @param completed
     */
    void setCompleted(final boolean completed);

    /**
     * the date/time at which the task was completed, if at all.
     * <p>Note that implementations are not required to maintain this attribute, instead whoever completes a task is responsible
     * to also set (or reset) the completion date.</p>
     *
     * @return the date of completion, if the task is already completed, <code>null</code> otherwise.
     */
    LocalDateTime getCompletionDate();

    /**
     * sets a completion date.
     * @param dateTime
     */
    void setCompletionDate(LocalDateTime dateTime);
}
