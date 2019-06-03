package hackathon.processor;


import hackathon.db.model.TestDataEntity;
import hackathon.exception.TestDataEntityNotFoundException;
import hackathon.model.TestData;
import hackathon.service.TestDataEntityService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * @author Dmitriy
 * @since 03.06.2019
 */
@RunWith(MockitoJUnitRunner.class)
public class TestDataProcessorTest {

    @InjectMocks
    private TestDataProcessor testDataProcessor;

    @Mock
    private TestDataEntityService testDataEntityService;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void test_findSuccess() throws Exception {
        Long id = 1L;
        String data = "data";

        TestDataEntity testDataEntity = new TestDataEntity();
        testDataEntity.setId(id);
        testDataEntity.setData(data);

        TestData testDataExpected = new TestData();
        testDataExpected.setData(data);
        when(testDataEntityService.findTestDataEntityById(id)).thenReturn(testDataEntity);

        TestData testDataReal = testDataProcessor.findDataById(id);

        assertEquals(testDataExpected, testDataReal);
    }

    @Test
    public void test_notFound() throws Exception {
        Long id = 1L;
        String message = "message";

        when(testDataEntityService.findTestDataEntityById(id))
                .thenThrow(new TestDataEntityNotFoundException(message));

        expectedException.expect(TestDataEntityNotFoundException.class);
        expectedException.expectMessage(message);
        testDataProcessor.findDataById(id);
    }


}
