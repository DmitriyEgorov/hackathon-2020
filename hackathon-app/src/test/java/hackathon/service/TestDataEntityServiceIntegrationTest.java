package hackathon.service;

import hackathon.config.HackathonApplication;
import hackathon.db.model.TestDataEntity;
import hackathon.db.repository.TestDataEntityRepository;
import hackathon.exception.TestDataEntityNotFoundException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitriy
 * @since 03.06.2019
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = HackathonApplication.class)
public class TestDataEntityServiceIntegrationTest {

    @Autowired
    private TestDataEntityRepository testDataEntityRepository;

    @Autowired
    private TestDataEntityService testDataEntityService;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void test_findSuccess() throws Exception {
        String test_data = "test_data";
        TestDataEntity testDataEntity = new TestDataEntity();
        testDataEntity.setData(test_data);
        testDataEntity = testDataEntityRepository.save(testDataEntity);

        TestDataEntity testDataEntityReal = testDataEntityService.findTestDataEntityById(testDataEntity.getId());

        assertEquals(testDataEntity, testDataEntityReal);
    }

    @Test
    public void test_notFound() throws Exception {
        testDataEntityRepository.deleteAll();

        expectedException.expect(TestDataEntityNotFoundException.class);
        testDataEntityService.findTestDataEntityById(Long.MAX_VALUE);
    }
}
