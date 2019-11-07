package ru.ais.demospringbootproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@RequiredArgsConstructor
public class Country {

  int id;

  @NonNull
  String name;

  @NonNull
  String codeName;

}
