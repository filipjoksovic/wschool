package su.um.feri.zimskasola.task.dto;

import su.um.feri.zimskasola.task.Task;

public class TaskCreateDTO {
    public int id;
    public String name;
    public String description;
    public String dueDate;
    public int project_id;

    public TaskCreateDTO(int id, String name, String description, String dueDate, int project_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.project_id = project_id;
    }

    public static Task fromDTO(TaskCreateDTO dto) {
        Task t = new Task(dto.name, dto.description, dto.dueDate);
        if (dto.id != -1) {
            t.setId(dto.id);
        }
        return t;
    }

}
