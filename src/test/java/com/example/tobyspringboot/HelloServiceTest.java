package com.example.tobyspringboot;

import com.example.tobyspringboot.helloboot.HelloDecorator;
import com.example.tobyspringboot.helloboot.HelloService;
import com.example.tobyspringboot.helloboot.SimpleHelloService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloServiceTest {

    @Test
    void simpleHelloService() {
        SimpleHelloService simpleHelloService = new SimpleHelloService();
        String ret = simpleHelloService.sayHello("Spring");
        Assertions.assertThat(ret).isEqualTo("Hello Spring");
    }
    @Test
    void helloDecorator (){
        HelloDecorator helloDecorator = new HelloDecorator(new HelloService() {
            @Override
            public String sayHello(String name) {
                return name;
            }
        });
        String ret = helloDecorator.sayHello("Test");

        Assertions.assertThat(ret).isEqualTo("*Test*");
    }
}
