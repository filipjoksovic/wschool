package su.um.feri.zimskasola.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import su.um.feri.zimskasola.project.Project;
import su.um.feri.zimskasola.project.ProjectRepository;
import su.um.feri.zimskasola.task.Task;
import su.um.feri.zimskasola.task.TaskRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {
    @Autowired
    private final ProjectRepository projectRepository;
    @Autowired
    private final TaskRepository taskRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Task t1 = new Task("t1", "description", "2011-10-05T14:48:00.000Z");
        Task t2 = new Task("t2", "description", "2011-10-05T14:48:00.000Z");
        Task t3 = new Task("t3", "description", "2011-10-05T14:48:00.000Z");
        Task t4 = new Task("t4", "description", "2011-10-05T14:48:00.000Z");
        Task t5 = new Task("t5", "description", "2011-10-05T14:48:00.000Z");

        Project p1 = new Project("p1", "description", "2011-10-05T14:48:00.000Z");
        Project p2 = new Project("p2", "description", "2011-10-05T14:48:00.000Z");
        Project p3 = new Project("p3", "description", "2011-10-05T14:48:00.000Z");
        Project p4 = new Project("p4", "description", "2011-10-05T14:48:00.000Z");
        Project p5 = new Project("p5", "description", "2011-10-05T14:48:00.000Z");


        t1.setProject(p1);
        t2.setProject(p1);
        t3.setProject(p3);
        t4.setProject(p4);
        t5.setProject(p5);

        p1.getTasks().add(t1);
        p1.getTasks().add(t2);
        p3.getTasks().add(t3);
        p4.getTasks().add(t4);
        p5.getTasks().add(t5);

        taskRepository.saveAll(List.of(t1, t2, t3, t4, t5));
        projectRepository.saveAll(List.of(p1, p2, p3, p4, p5));


    }
}
