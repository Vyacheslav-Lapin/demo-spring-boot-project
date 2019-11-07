package ru.ais.demospringbootproject.dao;

import static ru.ais.demospringbootproject.model.Country.Fields.codeName;
import static ru.ais.demospringbootproject.model.Country.Fields.id;
import static ru.ais.demospringbootproject.model.Country.Fields.name;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.sql.DataSource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;
import ru.ais.demospringbootproject.model.Country;
import ru.ais.demospringbootproject.model.Country.Fields;

@Repository
public class CountryDao extends NamedParameterJdbcDaoSupport {

  public CountryDao(DataSource dataSource) {
    setDataSource(dataSource);
  }

  public static final String[][] COUNTRY_INIT_DATA = {
      {"Australia", "AU"},
      {"Canada", "CA"},
      {"France", "FR"},
      {"Hong Kong", "HK"},
      {"Iceland", "IC"},
      {"Japan", "JP"},
      {"Nepal", "NP"},
      {"Russian Federation", "RU"},
      {"Sweden", "SE"},
      {"Switzerland", "CH"},
      {"United Kingdom", "GB"},
      {"United States", "US"}
  };

  //language=H2
  private static final String LOAD_COUNTRIES_SQL = "insert into country (name, code_name) values (:name, :code_name)";
  //language=H2
  private static final String GET_ALL_COUNTRIES_SQL = "select id, name, code_name from country";
  //language=H2
  private static final String GET_COUNTRIES_BY_NAME_SQL = "select id, name, code_name from country where name like :name";
  //language=H2
  private static final String GET_COUNTRY_BY_NAME_SQL = "select id, name, code_name from country where name = :name";
  //language=H2
  private static final String GET_COUNTRY_BY_CODE_NAME_SQL = "select id, name, code_name from country where code_name = :code_name";
  //language=H2
  private static final String UPDATE_COUNTRY_NAME_SQL = "update country set name=:name where code_name = :code_name";

  private static final RowMapper<Country> COUNTRY_ROW_MAPPER =
      (resultSet, __) ->
          Country.builder()
              .id(resultSet.getInt(id))
              .name(resultSet.getString(name))
              .codeName(resultSet.getString("code_name"))
              .build();

  public List<Country> get() {
    return Objects.requireNonNull(getNamedParameterJdbcTemplate())
               .query(GET_ALL_COUNTRIES_SQL,
                   COUNTRY_ROW_MAPPER);
  }

  public List<Country> getStartWith(String name) {
    return Objects.requireNonNull(getNamedParameterJdbcTemplate())
               .query(GET_COUNTRIES_BY_NAME_SQL,
                   Map.of(Fields.name, name + "%"),
                   COUNTRY_ROW_MAPPER);
  }

  public void updateName(String codeName, String newCountryName) {
    Objects.requireNonNull(getNamedParameterJdbcTemplate())
        .update(UPDATE_COUNTRY_NAME_SQL, Map.of(
            "code_name", codeName,
            "name", newCountryName));
  }

  public void loadInitData() {
    for (String[] countryData : COUNTRY_INIT_DATA)
      insert(countryData[0], countryData[1]);
  }

  public void insert(String name, String codeName) {
    Objects.requireNonNull(getNamedParameterJdbcTemplate())
        .update(LOAD_COUNTRIES_SQL,
            Map.of(
                Fields.name, name,
                "code_name", codeName));
  }

  public Country getByCodeName(String codeName) {
    return Objects.requireNonNull(getNamedParameterJdbcTemplate())
               .queryForObject(
                   GET_COUNTRY_BY_CODE_NAME_SQL,
                   Map.of("code_name", codeName),
                   COUNTRY_ROW_MAPPER);
  }

  public Country getCountryByName(String name) throws CountryNotFoundException {
    List<Country> countries =
        Objects.requireNonNull(getNamedParameterJdbcTemplate())
            .query(GET_COUNTRY_BY_NAME_SQL,
                Map.of(Fields.name, name),
                COUNTRY_ROW_MAPPER);

    if (countries.isEmpty()) throw new CountryNotFoundException();
    return countries.get(0);
  }
}
