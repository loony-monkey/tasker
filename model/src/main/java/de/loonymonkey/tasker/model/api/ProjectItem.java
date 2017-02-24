package de.loonymonkey.tasker.model.api;

import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * @author Frank Scho&ouml;nheit
 */
public interface ProjectItem extends TaskList {
    @NotNull
    String getTitle();

    /**
     * retrieves the notes associated with the item, if any
     *
     * @return retrieves the notes associated with the item
     */
    Optional<String> getNotes();
}
