package su.um.feri.zimskasola.project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ProjectControllerTest {
//    @Autowired
//    private ProjectController projectController;

    @Autowired
    private MockMvc mockMvc;
//    @Test
//    public void contextLoads() {
//        assertThat(projectController).isNotNull();
//    }

    @Test
    public void shouldReturnAllUsers() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/project")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().json("[]"));
    }
}
