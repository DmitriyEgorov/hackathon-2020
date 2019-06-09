package stub.controller;

import app.config.TestHackathonStubApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Dmitriy
 * @since 09.06.2019
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestHackathonStubApplication.class)
@AutoConfigureMockMvc
public class TestStubControllerIntegrationTest {

    private static final String TEST_PATH = "/test-stub";

    @Autowired
    private MockMvc mvc;

    @Test
    public void testHi() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get(TEST_PATH.concat("/hi"))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("stub server says hi!")));
    }

}