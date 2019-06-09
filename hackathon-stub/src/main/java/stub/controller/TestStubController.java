package stub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * test controller for application
 *
 * @author Dmitriy
 * @since 28.05.2019
 */
@RestController
@RequestMapping("/test-stub")
public class TestStubController {

    private static final String STUB_HI = "stub server says hi!";

    @GetMapping("/hi")
    public String sayHi() {
        return STUB_HI;
    }

}
