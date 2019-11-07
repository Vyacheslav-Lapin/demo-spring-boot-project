package ru.ais.demospringbootproject.model;

import java.util.List;
import org.jetbrains.annotations.NotNull;

public interface Person<T extends Person<T>> {

  default void sayHello(@NotNull Person person2) {
    System.out.printf("Hello, %s, I'm %s",
        person2.getName(),
        getName());
  }

  int getId();

  T setId(int id);

  String getName();

  T setName(String name);

  Country getCountry();

  T setCountry(Country country);

  int getAge();

  T setAge(int age);

  float getHeight();

  T setHeight(float height);

  boolean isProgrammer();

  T setProgrammer(boolean isProgrammer);

  List<String> getContacts();

  T setContacts(List<String> contacts);
}
