package de.loonymonkey.tasker.ui.javafx.model;

import de.loonymonkey.tasker.model.api.Project;
import de.loonymonkey.tasker.model.api.Task;
import org.apache.commons.lang3.NotImplementedException;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Frank Scho&ouml;nheit
 */
public class FXTaskTest {
    private static final String PROJECT_TITLE = "the coolest project ever!";
    private static final String TITLE = "BrumelForgami";
    private static final String NOTES = "HarpunigamoliSa";
    private static final LocalDateTime COMPLETION_DATE = LocalDateTime.now();

    @Test
    public void when_constructing_from_task_title_is_set() {
        // given
        final Task task = new TestTask(4);
        // when
        final FXTask objectUnderTest = FXTask.from(task);
        // then
        assertEquals(TITLE, objectUnderTest.getTitle());
    }

    @Test
    public void when_constructing_from_project_title_is_set() {
        // given
        final Project project = new TestProject(2);
        // when
        final FXTask objectUnderTest = FXTask.from(project);
        // then
        assertEquals(PROJECT_TITLE, objectUnderTest.getTitle());
    }

    @Test
    public void when_constructing_from_project_children_are_present() {
        // given
        final int childCount = 2;
        final Project project = new TestProject(childCount);

        // when
        final FXTask objectUnderTest = FXTask.from(project);

        // then
        final List<Task> children = objectUnderTest.getSubtasks();
        assertEquals(childCount, children.size());
        assertArrayEquals(project.getSubtasks().toArray(), children.toArray());
    }

    @Test
    public void when_constructing_from_task_children_are_present() {
        // given
        final int childCount = 5;
        final Task task = new TestTask(childCount);

        // when
        final FXTask objectUnderTest = FXTask.from(task);

        // then
        final List<Task> children = objectUnderTest.getSubtasks();
        assertEquals(childCount, children.size());
        assertArrayEquals(task.getSubtasks().toArray(), children.toArray());
    }

    @Test
    public void when_constructing_from_task_notes_are_set() {
        // given
        final Task task = new TestTask(0);
        // when
        final FXTask objectUnderTest = FXTask.from(task);
        // then
        assertEquals(NOTES, objectUnderTest.getNotes());
    }

    @Test
    public void when_constructing_from_completed_task_completed_flag_is_set() {
        // given
        final Task task = new TestTask(0);
        task.setCompleted(true);

        // when
        final FXTask objectUnderTest = FXTask.from(task);

        // then
        assertEquals(true, objectUnderTest.isCompleted());
    }

    @Test
    public void when_constructing_from_incomplete_task_completed_flag_is_set() {
        // given
        final Task task = new TestTask(0);
        task.setCompleted(false);

        // when
        final FXTask objectUnderTest = FXTask.from(task);

        // then
        assertEquals(false, objectUnderTest.isCompleted());
    }

    @Test
    public void when_constructing_from_task_completion_date_is_set() {
        // given
        final Task task = new TestTask(0);
        // when
        final FXTask objectUnderTest = FXTask.from(task);
        // then
        assertEquals(COMPLETION_DATE, objectUnderTest.getCompletionDate());
    }

    // TODO: am I paranoid in thinking that tests for the consistency between get/setFoo and fooProperty would be a good thing?

    private class TestTask implements Task {
        private final List<Task> children;
        private boolean completed = true;

        TestTask(final int childCount) {
            this.children = new ArrayList<>();
            for (int i = 0; i < childCount; ++i)
                this.children.add(new TestTask(0));
        }

        @Override
        public String getTitle() {
            return TITLE;
        }

        @Override
        public List<Task> getSubtasks() {
            return this.children;
        }

        @Override
        public String getNotes() {
            return NOTES;
        }

        @Override
        public boolean isCompleted() {
            return this.completed;
        }

        @Override
        public void setCompleted(boolean completed) {
            this.completed = completed;
        }

        @Override
        public LocalDateTime getCompletionDate() {
            return COMPLETION_DATE;
        }

        @Override
        public void setCompletionDate(LocalDateTime dateTime) {
            throw new NotImplementedException("this is an immutable test class!");
        }
    }

    private class TestProject implements Project {
        private final List children;

        public TestProject(int childCount) {
            this.children = new ArrayList<>();
            for (int i = 0; i < childCount; ++i)
                this.children.add(new TestTask(0));
        }

        @Override
        public String getTitle() {
            return PROJECT_TITLE;
        }

        @Override
        public List<Task> getSubtasks() {
            return this.children;
        }
    }
}
