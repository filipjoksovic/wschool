package su.um.feri.zimskasola.task;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import su.um.feri.zimskasola.task.dto.TaskCreateDTO;
import su.um.feri.zimskasola.task.dto.TaskProjectIdDTO;

import java.util.List;

@RestController
@RequestMapping("api/v1/task")
@CrossOrigin("http://localhost:3000")
@RequiredArgsConstructor
public class TaskController {

    @Autowired
    private final TaskService taskService;

    @GetMapping
    public List<TaskProjectIdDTO> getAllTasks() {
        return TaskProjectIdDTO.toDTOList(this.taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public List<TaskProjectIdDTO> getTaksForProject(@PathVariable int id) {
        return TaskProjectIdDTO.toDTOList(this.taskService.getTasksForProject(id));
    }

    @PostMapping
    public TaskProjectIdDTO saveTask(@RequestBody TaskCreateDTO taskCreateDTO) {
        Task saved = this.taskService.save(taskCreateDTO);

        return new TaskProjectIdDTO(saved, saved.getProject().getId());
    }

    @PutMapping
    public Task updateTask(@RequestBody Task task) {
        return this.taskService.update(task);
    }

    @DeleteMapping("/{id}")
    public Task deleteTask(@PathVariable int id) {
        return this.taskService.delete(id);
    }


}
