/**
 * Created on 24.02.2017
 */
package de.loonymonkey.tasker.ui.javafx.model;

import de.loonymonkey.tasker.model.api.Project;

/**
 * @author Frank Scho&ouml;nheit
 */
class FXProject extends FXProjectItem implements Project {
    FXProject(final Project item) {
        super(item);
    }
}
