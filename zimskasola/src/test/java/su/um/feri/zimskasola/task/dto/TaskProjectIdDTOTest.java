package su.um.feri.zimskasola.task.dto;

import org.junit.jupiter.api.Test;
import su.um.feri.zimskasola.task.Task;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskProjectIdDTOTest {

    @Test
    void toDTOList() {
        Task t1 = new Task(1, "Name 1", "Description 1", "");
        Task t2 = new Task(2, "Name 2", "Description 2", "");
        Task t3 = new Task(3, "Name 3", "Description 3", "");

        List<Task> tasks = List.of(t1, t2, t3);

        List<TaskProjectIdDTO> tasksDto = TaskProjectIdDTO.toDTOList(tasks);

        assertEquals(tasksDto.size(), 3);
    }
}