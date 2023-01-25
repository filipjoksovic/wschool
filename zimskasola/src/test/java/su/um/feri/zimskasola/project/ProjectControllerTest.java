package su.um.feri.zimskasola.project;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.core.Local;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(SpringExtension.class)
//@WebMvcTest(ProjectController.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ProjectControllerTest {

    static LocalDateTime fixedDate = LocalDateTime.of(2023, 1, 24, 1, 1);
    @Autowired
    private ProjectService projectService;

    @BeforeEach
    void init() {
        Project p1 = new Project("Project name", "Project description", fixedDate);
        Project p2 = new Project("Project name 2", "Project description 2", fixedDate);
        Project p3 = new Project("Project name 3", "Project description 3", fixedDate);

        projectService.save(p1);
        projectService.save(p2);
        projectService.save(p3);

    }

    @Test
    void getByID() throws Exception {
        Optional<Project> project = projectService.getProject(1);
        assertTrue(project.isPresent());

        assertEquals(project.get().getName(), "Project name");
        assertEquals(project.get().getId(), 1);
    }

    @Test
    void getAll() {
        List<Project> allProjects = projectService.getAllProjects();
        assertEquals(allProjects.size(), 3);
    }

    @Test
    void save() {
        LocalDateTime dateToSave = fixedDate;
        Project newProject = new Project("Project 4", "Project description 4", dateToSave);
        Project saved = projectService.save(newProject);
        assertEquals(saved.getId(), 4);
        assertEquals(saved.getName(), "Project 4");
        assertEquals(saved.getDescription(), "Project description 4");
        assertEquals(saved.getDueDate(), dateToSave);
    }

    @Test
    void update() {
        LocalDateTime updatedDate = fixedDate.minusDays(10);
        Project toUpdate = new Project(3, "Updated project 3", "Updated description", updatedDate);
        Project updated = projectService.update(toUpdate);
        assertThat(updated, samePropertyValuesAs(toUpdate));
    }

    @Test
    void delete() {
        int projectId = 3;
        Project expectedReturn = new Project(3, "Project name 3", "Project description 3", fixedDate);
        Project deleted = projectService.delete(3);
        assertThat(deleted, samePropertyValuesAs(expectedReturn));

    }
}