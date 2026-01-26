package com.junit.taskmanager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {
    private final TaskManager manager = new TaskManager();

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testLongRunningTask() {
        // This should fail (takes 3s > 2s timeout)
        assertEquals("Task completed", manager.longRunningTask());
    }
}