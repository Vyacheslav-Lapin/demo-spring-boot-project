package ru.ais.demospringbootproject.model;

import java.util.List;
import org.jetbrains.annotations.NotNull;

public interface Person {

  default void sayHello(@NotNull Person person2) {
    System.out.printf("Hello, %s, I'm %s",
        person2.getName(),
        getName());
  }

  int getId();

  Person setId(int id);

  String getName();

  Person setName(String name);

  Country getCountry();

  Person setCountry(Country country);

  int getAge();

  Person setAge(int age);

  float getHeight();

  Person setHeight(float height);

  boolean isProgrammer();

  Person setProgrammer(boolean isProgrammer);

  List<String> getContacts();

  Person setContacts(List<String> contacts);
}
