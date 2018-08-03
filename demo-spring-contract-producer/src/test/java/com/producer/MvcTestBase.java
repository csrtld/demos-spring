package com.producer;

import com.producer.controller.ProducerController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProducerApplication.class)
public class MvcTestBase {

    @Autowired
    private ProducerController producerController;

    @Before
    public void setUp() {
        StandaloneMockMvcBuilder standaloneMockMvcBuilder = MockMvcBuilders.standaloneSetup(producerController);
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
    }
}
