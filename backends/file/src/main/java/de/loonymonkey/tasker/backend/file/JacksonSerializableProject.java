/**
 * Created on 08.02.2017
 */
package de.loonymonkey.tasker.backend.file;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import de.loonymonkey.tasker.model.api.Project;

import java.util.Objects;

/**
 * @author Frank Scho&ouml;nheit
 */
@JsonPropertyOrder({"title", "subtasks"})
class JacksonSerializableProject extends JacksonSerializableTaskContainer implements Project {
    private final String title;

    @SuppressWarnings("unused")
    private JacksonSerializableProject() {
        title = null;
    }

    JacksonSerializableProject(final String title){
        this.title = Objects.requireNonNull(title, "|title| must not be null!");
    }

    @Override
    public String getTitle() {
        return title;
    }
}
