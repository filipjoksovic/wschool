package su.um.feri.zimskasola.project.dto;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class ProjectCreateDTO {

    public String name;
    public String description;
    public LocalDateTime dueDate;


}
