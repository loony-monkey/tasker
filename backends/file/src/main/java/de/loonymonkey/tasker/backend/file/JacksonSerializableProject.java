/**
 * Created on 08.02.2017
 */
package de.loonymonkey.tasker.backend.file;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import de.loonymonkey.tasker.model.api.Project;

/**
 * @author Frank Scho&ouml;nheit
 */
@JsonPropertyOrder({"title", "notest", "subtasks"})
class JacksonSerializableProject extends JacksonSerializableProjectItem implements Project {
    @SuppressWarnings("unused")
    private JacksonSerializableProject() {
    }

    JacksonSerializableProject(final String title, final String notes) {
        super(title, notes);
    }
}
