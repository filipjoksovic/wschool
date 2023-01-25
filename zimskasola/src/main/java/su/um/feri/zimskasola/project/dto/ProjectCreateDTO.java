package su.um.feri.zimskasola.project.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import su.um.feri.zimskasola.project.Project;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Data
public class ProjectCreateDTO {

    public String name;
    public String description;
    public String dueDate;

    public Project toProject() {
        LocalDateTime convertedDate = LocalDateTime.parse(this.dueDate);
        return new Project(this.name, this.description, convertedDate);
    }

}
