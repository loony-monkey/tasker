package de.loonymonkey.tasker.model.impl;

import de.loonymonkey.tasker.model.api.Task;
import de.loonymonkey.tasker.model.impl.ImmutableTask;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;

public class ImmutableTaskTest {
    private static final String TITLE = "Some Task";

    @Test(expected = NullPointerException.class)
    public void when_constructing_with_null_title_exception_is_thrown() {
        final ImmutableTask objectUnderTest = new ImmutableTask(null);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void tasL_list_should_be_immutable() {
        // given
        final ImmutableTask objectUnderTest = new ImmutableTask(TITLE);

        // when
        final List<Task> subTasks = objectUnderTest.getSubtasks();

        // then
        subTasks.add(mock(Task.class));
    }
}
