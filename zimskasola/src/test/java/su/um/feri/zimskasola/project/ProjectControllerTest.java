package su.um.feri.zimskasola.project;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import su.um.feri.zimskasola.ZimskasolaApplication;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,
//        classes = ZimskasolaApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
@WebMvcTest(ProjectController.class)
@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = ZimskasolaApplication.class)
public class ProjectControllerTest {
    @Autowired
    private MockMvc mockMvc;
//    @MockBean
//    private ProjectService projectService;

//    @BeforeEach
//    void init() {
//        Project p1 = new Project("Project name", "Project description", fixedDate);
//        Project p2 = new Project("Project name 2", "Project description 2", fixedDate);
//        Project p3 = new Project("Project name 3", "Project description 3", fixedDate);
//
//        projectService.save(p1);
//        projectService.save(p2);
//        projectService.save(p3);
//
//    }

    @Test
    void getByID() {

    }

    @Test
    void getAll() throws Exception {
        Project p = new Project("New project", "description", LocalDateTime.now());
        List<Project> allProjects = List.of(p);
//        given(projectService.getAllProjects()).willReturn(allProjects);
        RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/project").contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request).andReturn();

//        mockMvc.perform(request).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].id", equalTo(p.getId())));
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}
