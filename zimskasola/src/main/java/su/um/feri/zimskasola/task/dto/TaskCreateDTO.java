package su.um.feri.zimskasola.task.dto;

import su.um.feri.zimskasola.task.Task;

public class TaskCreateDTO {
    public int id;
    public String name;
    public String description;
    public String dueDate;
    public int project_id;

    public static Task fromDTO(TaskCreateDTO dto) {
        return new Task(dto.name, dto.description, dto.dueDate);
    }

}
