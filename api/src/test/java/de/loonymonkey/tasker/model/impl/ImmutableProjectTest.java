package de.loonymonkey.tasker.model.impl;

import de.loonymonkey.tasker.model.api.Task;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;

public class ImmutableProjectTest {
    private static final String TITLE = "Some Test";

    @Test(expected = NullPointerException.class)
    public void when_constructing_with_null_title_exception_is_thrown() {
        final ImmutableProject objectUnderTest = new ImmutableProject(null);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void tasL_list_should_be_immutable() {
        // given
        final ImmutableProject objectUnderTest = new ImmutableProject(TITLE);

        // when
        final List<Task> subTasks = objectUnderTest.getSubtasks();

        // then
        subTasks.add(mock(Task.class));
    }
}
