package su.um.feri.zimskasola.project;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Optional<Project> getProject(int id) {
        return this.projectRepository.findById(id);
    }

    public Optional<Project> getProjectByName(String name) {
        return this.projectRepository.findProjectByName(name);
    }

    public List<Project> getAllProjects() {
        return (List<Project>) this.projectRepository.findAll();
    }

    public Project save(Project project) {
        return this.projectRepository.save(project);
    }

    public Project update(Project project) {
        return this.projectRepository.save(project);
    }

    public void delete(Project project) {
        this.projectRepository.delete(project);
    }

}
