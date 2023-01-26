package su.um.feri.zimskasola.task.dto;

import org.junit.jupiter.api.Test;
import su.um.feri.zimskasola.task.Task;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskCreateDTOTest {

    @Test
    void fromDTO() {
        TaskCreateDTO dto = new TaskCreateDTO(1, "New name", "Description", "Due date", 1);
        Task converted = TaskCreateDTO.fromDTO(dto);

        assertEquals(converted.getId(), dto.id);
        assertEquals(converted.getName(), dto.name);
        assertEquals(converted.getDescription(), dto.description);


    }
}