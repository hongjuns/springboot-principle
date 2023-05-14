package com.example.tobyspringboot;

import com.example.tobyspringboot.helloboot.HelloController;
import com.example.tobyspringboot.helloboot.HelloService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloControllerTest {

    @Test
    void helloController() {
       HelloController helloController = new HelloController(new HelloService() {
           @Override
           public String sayHello(String name) {
               return name;
           }
       });
       String ret =  helloController.hello("Test");
       Assertions.assertThat(ret).isEqualTo("Test");
    }

    @Test
    void failsHelloController(){
        HelloController helloController = new HelloController(new HelloService() {
            @Override
            public String sayHello(String name) {
                return name;
            }
        });

        Assertions.assertThatThrownBy(() ->{
            helloController.hello(null);
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() ->{
            helloController.hello("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
