package ru.ais.demospringbootproject.model;

public interface Customer extends Person<Customer> {
  boolean isBroke();

  Customer setBroke(boolean broke);

}
