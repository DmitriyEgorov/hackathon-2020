package hackathon.processor;

import hackathon.exception.TestDataEntityNotFoundException;
import hackathon.model.TestData;
import hackathon.service.TestDataEntityService;
import org.springframework.stereotype.Service;

import static hackathon.adapter.TestDataAdapter.adapt;

/**
 * @author egorov
 * @since 03.06.2019
 */
@Service
public class TestDataProcessor {

    private final TestDataEntityService testDataEntityService;

    public TestDataProcessor(TestDataEntityService testDataEntityService) {
        this.testDataEntityService = testDataEntityService;
    }

    public TestData findDataById(Long id) throws TestDataEntityNotFoundException {
        return adapt(testDataEntityService.findTestDataEntityById(id));
    }

}
