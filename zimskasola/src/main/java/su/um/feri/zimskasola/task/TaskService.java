package su.um.feri.zimskasola.task;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import su.um.feri.zimskasola.project.Project;
import su.um.feri.zimskasola.project.ProjectRepository;
import su.um.feri.zimskasola.task.dto.TaskCreateDTO;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {
    @Autowired
    private final TaskRepository repository;
    @Autowired
    private final ProjectRepository projectRepository;

    public Task getTask(int id) {
        Optional<Task> task = repository.findById(id);
        return task.orElse(null);
    }

    public List<Task> getAllTasks() {
        List<Task> allTasks = (List<Task>) repository.findAll();
        return (List<Task>) repository.findAll();
    }

    public Task save(TaskCreateDTO taskDto) {
        Optional<Project> project = projectRepository.findById(taskDto.project_id);
        if (project.isPresent()) {
            Task task = TaskCreateDTO.fromDTO(taskDto);
            Task createdTask = repository.save(task);
            Project found = project.get();
            found.getTasks().add(createdTask);
            Project updated = projectRepository.save(found);
            createdTask.setProject(updated);
            repository.save(createdTask);
            return task;
        }
        return null;
    }

    public Task update(TaskCreateDTO taskDto) {
        Optional<Project> project = projectRepository.findById(taskDto.project_id);
        if (project.isPresent()) {
            Task task = TaskCreateDTO.fromDTO(taskDto);
            Task createdTask = repository.save(task);
            Project found = project.get();
            for (Task t : found.getTasks()) {
                if (Objects.equals(t.getId(), task.getId())) {
                    t.setName(task.getName());
                    t.setDescription(task.getDescription());
                    t.setDueDate(task.getDueDate());
                    break;
                }
            }
//            found.getTasks().stream().(t->t.id == taskDto.id);
            Project updated = projectRepository.save(found);
            createdTask.setProject(updated);
            repository.save(createdTask);
            return task;
        }
        return null;
    }

    public Task delete(int id) {
        Optional<Task> found = repository.findById(id);
        if (found.isPresent()) {
            repository.delete(found.get());
            return found.get();
        }
        return null;
    }


    public List<Task> getTasksForProject(int id) {
        return repository.findByProject_Id(id);
    }
}
