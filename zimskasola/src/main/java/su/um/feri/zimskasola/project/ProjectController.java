package su.um.feri.zimskasola.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/project")
@CrossOrigin("http://localhost:3000")
public class ProjectController implements Serializable {
    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{id}")
    public Project getByID(@PathVariable int id) {
        Optional<Project> project = projectService.getProject(id);
        return project.orElse(null);
    }

    @GetMapping
    public List<Project> getAll() {
        return projectService.getAllProjects();
    }

    @PostMapping
    public Project save(@RequestBody Project project) {
//        project.setDueDate(LocalDateTime.now());
        return this.projectService.save(project);
    }

    @PutMapping
    public Project update(@RequestBody Project project) {
        return this.projectService.update(project);
    }

    @DeleteMapping("/{id}")
    public Project delete(@PathVariable int id) {
        return this.projectService.delete(id);
    }

}
