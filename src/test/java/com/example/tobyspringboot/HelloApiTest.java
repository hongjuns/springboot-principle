package com.example.tobyspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
public class HelloApiTest {

    @Test
    void helloApi (){

        TestRestTemplate rest = new TestRestTemplate();

        ResponseEntity<String> res =
                    rest.getForEntity("http://localhost:9090/hello?name={name}",String.class,"Spring");

        //Status Code
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
        //Header Content
        assertThat(res.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
        //Response Body
        assertThat(res.getBody()).isEqualTo("*Hello Spring*");
    }

    @Test
    void failsHelloApi (){
        TestRestTemplate rest = new TestRestTemplate();

        ResponseEntity<String> res =
                rest.getForEntity("http://localhost:8080/hello?name=", String.class,"");

        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
