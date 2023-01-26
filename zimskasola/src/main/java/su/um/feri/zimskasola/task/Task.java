package su.um.feri.zimskasola.task;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import su.um.feri.zimskasola.project.Project;


@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String dueDate;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }


    public Task(Integer id, String name, String description, String dueDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
    }


    public Task() {
    }

    public Task(String name, String description, String dueDate) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
    }

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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


}
