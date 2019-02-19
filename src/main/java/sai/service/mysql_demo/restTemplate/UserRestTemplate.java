package sai.service.mysql_demo.restTemplate;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import sai.service.mysql_demo.properties.DemoProperties;

import java.util.Optional;

@AllArgsConstructor
@Slf4j
@Component
public class UserRestTemplate {


    private final RestTemplate demoRestTemplate;
    private final DemoProperties demoProperties;


    public String checkConnection() {

        ResponseEntity<String> response = null;
        try {

            demoProperties.setBaseURL("http://localhost:9090/demotest");

            response = demoRestTemplate.exchange(
                    demoProperties.getBaseURL()+"/test", HttpMethod.GET,null,
            new ParameterizedTypeReference<String>(){});

        } catch (HttpServerErrorException | HttpClientErrorException exception) {
            log.error("Some error in connection ---> ", exception);
        }

        return getResponseBody(response);
    }

    public static <T> T getResponseBody(ResponseEntity<T> object) {
        return Optional.ofNullable(object).map(ResponseEntity::getBody).orElse(null);
    }

}
