package ru.ais.demospringbootproject.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.Singular;

@Data
@Builder
@AllArgsConstructor
//@Entity
public class CustomerImpl implements Customer {

  //  @Id
  @Default
  int id = 1;

  String name;

  int age;

  @Default
  @SuppressWarnings("UnusedAssignment")
  float height = 1.78f;

  @Default
  @SuppressWarnings("UnusedAssignment")
  boolean isProgrammer = true;

  boolean broke;

  //  @ManyToOne(fetch = FetchType.EAGER)
  //  @JoinColumn(name = "country_id")
  Country country;

  @Singular
  List<String> contacts;
}
