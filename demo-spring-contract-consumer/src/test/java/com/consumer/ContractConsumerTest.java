package com.consumer;

import com.consumer.dto.Saludo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.NONE)
@AutoConfigureStubRunner(
        ids = "com.example:demo-spring-contract-producer:+:stubs:8100",
        workOffline = true
        //repositoryRoot = "http://.."
)
@DirtiesContext
public class ContractConsumerTest {

    @Test
    public void get_example_contract() {
        // given:
        RestTemplate restTemplate = new RestTemplate();

        // when:
        ResponseEntity<Saludo> saludoResponseEntity =
                restTemplate.getForEntity("http://localhost:8100/get-example", Saludo.class);

        // then:
        Assert.assertEquals(saludoResponseEntity.getStatusCodeValue(), 200);
        Assert.assertEquals(saludoResponseEntity.getBody().getMensaje(), "Hola Mundo CDC");
    }
}
