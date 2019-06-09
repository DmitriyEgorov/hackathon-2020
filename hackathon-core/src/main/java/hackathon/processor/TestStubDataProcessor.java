package hackathon.processor;

import hackathon.model.TestStubData;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author egorov
 * @since 03.06.2019
 */
@Service
public class TestStubDataProcessor {

    private final RestTemplate restTemplate = new RestTemplate();
    private final HttpEntity<Object> entity = new HttpEntity<>(new HttpHeaders());

    public TestStubData findDataById(Long id, String url) {
        UriComponents uri = UriComponentsBuilder
                .fromHttpUrl(url.concat("/test-stub/data/{id}"))
                .buildAndExpand(id);

        ResponseEntity<TestStubData> response = restTemplate
                .exchange(uri.toUri(),
                        HttpMethod.GET,
                        entity,
                        TestStubData.class);

        return response.getBody();
    }

}
