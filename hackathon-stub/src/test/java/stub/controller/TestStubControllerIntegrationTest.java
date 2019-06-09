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
import stub.db.model.TestStubDataEntity;
import stub.db.repository.TestStubDataEntityRepository;

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

    @Autowired
    private TestStubDataEntityRepository testStubDataEntityRepository;

    @Test
    public void testHi() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get(TEST_PATH.concat("/hi"))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("stub server says hi!")));
    }

    @Test
    public void testData_success() throws Exception {
        String test_data = "test_stub_data";
        TestStubDataEntity testDataEntity = new TestStubDataEntity();
        testDataEntity.setData(test_data);
        testDataEntity = testStubDataEntityRepository.save(testDataEntity);
        mvc.perform(MockMvcRequestBuilders.get(TEST_PATH.concat("/data/{id}"), testDataEntity.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(mvcResult ->
                        assertTrue(mvcResult.getResponse().getContentAsString().contains(test_data)));
    }

    @Test
    public void testData_notFound() throws Exception {
        testStubDataEntityRepository.deleteAll();
        mvc.perform(MockMvcRequestBuilders.get(TEST_PATH.concat("/data/{id}"), Long.MAX_VALUE)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testData_badRequest() throws Exception {
        testStubDataEntityRepository.deleteAll();
        mvc.perform(MockMvcRequestBuilders.get(TEST_PATH.concat("/data/{id}"), "string")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

}