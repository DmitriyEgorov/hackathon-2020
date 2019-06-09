package stub.controller;

import hackathon.model.TestStubData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stub.db.adapter.TestStubDataAdapter;
import stub.db.model.TestStubDataEntity;
import stub.db.repository.TestStubDataEntityRepository;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * test controller for application
 *
 * @author Dmitriy
 * @since 28.05.2019
 */
@RestController
@RequestMapping("/test-stub")
public class TestStubController {

    private final TestStubDataEntityRepository testStubDataEntityRepository;

    public TestStubController(TestStubDataEntityRepository testStubDataEntityRepository) {
        this.testStubDataEntityRepository = testStubDataEntityRepository;
    }

    private static final String STUB_HI = "stub server says hi!";

    @GetMapping("/hi")
    public String sayHi() {
        return STUB_HI;
    }

    @GetMapping("/data/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<TestStubData> getTestData(@PathVariable("id") Long id) {
        TestStubDataEntity testStubData =
                testStubDataEntityRepository.findById(id)
                .orElse(null);
        if (testStubData != null) {
            return ResponseEntity.ok(TestStubDataAdapter.adapt(testStubData));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
