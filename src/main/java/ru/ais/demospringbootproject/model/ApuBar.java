package ru.ais.demospringbootproject.model;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class ApuBar implements Bar {

  @Override
  public Squishee sellSquishee(@NotNull Customer customer) {
    if (customer.isBroke()) throw new CustomerBrokenException();

    System.out.println("Here is your Squishee");
    return new Squishee("Usual Squishee");
  }
}
