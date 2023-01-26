package su.um.feri.zimskasola.task.dto;

import su.um.feri.zimskasola.task.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskProjectIdDTO {

    int id;
    String name;
    String description;
    String dueDate;
    Integer project_id;

    public TaskProjectIdDTO(Task task, Integer project_id) {
        this.id = task.getId();
        this.name = task.getName();
        this.description = task.getDescription();
        this.dueDate = task.getDueDate();
        this.project_id = project_id;
    }

    public static List<TaskProjectIdDTO> toDTOList(List<Task> tasks) {
        List<TaskProjectIdDTO> list = new ArrayList<>();
        for (Task t : tasks) {
            list.add(new TaskProjectIdDTO(t, t.getProject() != null ? t.getProject().getId() : -1));
        }
        return list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }
}
