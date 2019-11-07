package ru.ais.demospringbootproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class DemoSpringBootProjectApplication {

  public static void main(String[] args) {
    //    var context =
    SpringApplication.run(DemoSpringBootProjectApplication.class, args);

    //    System.out.println(context.getBeanDefinitionCount());
  }

}
