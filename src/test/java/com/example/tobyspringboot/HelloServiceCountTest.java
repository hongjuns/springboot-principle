package com.example.tobyspringboot;

import com.example.tobyspringboot.helloboot.HelloRepository;
import com.example.tobyspringboot.helloboot.HelloService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class HelloServiceCountTest {

    @Autowired
    HelloService helloService;
    @Autowired
    HelloRepository helloRepository;

    @Test
    void sayHelloIncreaseCount(){
        helloService.sayHello("Toby");
        Assertions.assertThat(helloRepository.countOf("Toby"))
                .isEqualTo(1);

        helloService.sayHello("Toby");
        Assertions.assertThat(helloRepository.countOf("Toby"))
                .isEqualTo(2);
    }
}
