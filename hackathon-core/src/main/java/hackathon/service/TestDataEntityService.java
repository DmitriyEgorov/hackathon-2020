package hackathon.service;

import hackathon.db.model.TestDataEntity;
import hackathon.db.repository.TestDataEntityRepository;
import hackathon.exception.TestDataEntityNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author egorov
 * @since 03.06.2019
 */
@Service
public class TestDataEntityService {
    private static final String NOT_FOUND_MESSAGE = "TestData with id %s not found";

    private final TestDataEntityRepository testDataEntityRepository;

    public TestDataEntityService(TestDataEntityRepository testDataEntityRepository) {
        this.testDataEntityRepository = testDataEntityRepository;
    }

    public TestDataEntity findTestDataEntityById(Long id) throws TestDataEntityNotFoundException {
        return testDataEntityRepository.findById(id)
                .orElseThrow(() -> new TestDataEntityNotFoundException(String.format(NOT_FOUND_MESSAGE, id.toString())));
    }

}
