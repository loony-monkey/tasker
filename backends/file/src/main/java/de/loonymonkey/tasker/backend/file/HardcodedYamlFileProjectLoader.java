/**
 * Created on 08.02.2017
 */
package de.loonymonkey.tasker.backend.file;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import de.loonymonkey.tasker.model.api.Project;

import java.io.File;
import java.io.IOException;

/**
 * @author Frank Scho&ouml;nheit
 */
public class HardcodedYamlFileProjectLoader {
    public HardcodedYamlFileProjectLoader() {
    }

    public Project getProjectSingleton() {
        try {
            return readHardcodedProject(getHardcodedProjectFile());
        } catch (IOException e) {
            // TODO: proper handling
            throw new RuntimeException(e);
        }
    }

    public static void main(final String[] args) throws IOException {
        final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        final JacksonSerializableProject project = new JacksonSerializableProject("Things to be done");
        final JacksonSerializableTask task = project.addSubtask("Do something!");
        task.setNotes("Really, it is utterly important that this is being done!");
        task.addSubtask("first, start it");
        task.addSubtask("then, finish it");

        final File file = getHardcodedProjectFile();
        mapper.writeValue(file, project);
    }

    public static File getHardcodedProjectFile() {
        return new File(System.getProperty("user.home") + File.separator + ".tasker" + File.separator + "test.yaml");
    }

    private static JacksonSerializableProject readHardcodedProject(final File file) throws IOException {
        final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readValue(file, JacksonSerializableProject.class);
    }
}
