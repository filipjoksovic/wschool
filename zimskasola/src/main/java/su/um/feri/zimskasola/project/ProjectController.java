package su.um.feri.zimskasola.project;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/project")
public class ProjectController {
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
        return this.projectService.save(project);
    }

    @PutMapping
    public Project update(@RequestBody Project project) {
        return this.projectService.update(project);
    }

    @DeleteMapping
    public Project delete(@RequestBody Project project) {
        this.projectService.delete(project);
        return project;
    }

}
