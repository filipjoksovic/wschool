package su.um.feri.zimskasola.project.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import su.um.feri.zimskasola.project.Project;

@RequiredArgsConstructor
@Data
public class ProjectCreateDTO {

    public String name;
    public String description;
    public String dueDate;

    public Project toProject() {
        String convertedDate = this.dueDate;
        return new Project(this.name, this.description, convertedDate);
    }

}
