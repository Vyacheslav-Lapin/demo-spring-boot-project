package ru.ais.demospringbootproject.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.Singular;

@Data
@Builder
@AllArgsConstructor
//@Entity
public class UsualPerson implements Person {

//  @Id
  @Default
  int id = 1;

  String name;

//  @ManyToOne(fetch = FetchType.EAGER)
//  @JoinColumn(name = "country_id")
  Country country;

  int age;

  @Default
  float height = 1.78f;

  @Default
  boolean isProgrammer = true;

  @Singular
  List<String> contacts;
}
