package com.example.tobyspringboot;

import com.example.tobyspringboot.helloboot.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloServiceTest {

    @Test
    void simpleHelloService() {
        SimpleHelloService helloService = new SimpleHelloService(helloRepositoryStub);
        String ret = helloService.sayHello("Spring");
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
    private static HelloRepository helloRepositoryStub = new HelloRepository() {
        @Override
        public Hello findHello(String name) {
            return null;
        }

        @Override
        public void increaseCount(String name) {

        }
    };

}
