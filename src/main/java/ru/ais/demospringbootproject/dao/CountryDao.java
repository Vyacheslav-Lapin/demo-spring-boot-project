package ru.ais.demospringbootproject.dao;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;
import ru.ais.demospringbootproject.model.Country;

@Repository
public class CountryDao extends NamedParameterJdbcDaoSupport {

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
  private static final String LOAD_COUNTRIES_SQL = "insert into country (name, code_name) values (:name, :codeName)";
  //language=H2
  private static final String GET_ALL_COUNTRIES_SQL = "select id, name, code_name from country";
  //language=H2
  private static final String GET_COUNTRIES_BY_NAME_SQL = "select id, name, code_name from country where name like :name";
  //language=H2
  private static final String GET_COUNTRY_BY_NAME_SQL = "select id, name, code_name from country where name = :name";
  //language=H2
  private static final String GET_COUNTRY_BY_CODE_NAME_SQL = "select id, name, code_name from country where code_name = :codeName";
  //language=H2
  private static final String UPDATE_COUNTRY_NAME_SQL = "update country set name=:name where code_name = :codeName";

  private static final RowMapper<Country> COUNTRY_ROW_MAPPER =
      (resultSet, __) ->
          Country.builder()
              .id(resultSet.getInt(Country.Fields.id))
              .name(resultSet.getString(Country.Fields.name))
              // TODO: implement it
              .build();

  public List<Country> getCountryList() {
    // TODO: implement it
    return null;
  }

  public List<Country> getCountryListStartWith(String name) {
    return Objects.requireNonNull(getNamedParameterJdbcTemplate())
               .query(GET_COUNTRIES_BY_NAME_SQL,
                   Map.of("name", name + "%"),
                   COUNTRY_ROW_MAPPER);
  }

  public void updateCountryName(String codeName, String newCountryName) {
    // TODO: implement it
  }

  public void loadCountries() {
    for (String[] countryData : COUNTRY_INIT_DATA) {
      Objects.requireNonNull(getNamedParameterJdbcTemplate())
          .update(LOAD_COUNTRIES_SQL,
              Map.of(
                  "name", countryData[0],
                  "codeName", countryData[1]));
    }
  }

  public Country getCountryByCodeName(String codeName) {
    return Objects.requireNonNull(getJdbcTemplate())
               .queryForObject(
                   GET_COUNTRY_BY_CODE_NAME_SQL,
                   COUNTRY_ROW_MAPPER,
                   Map.of("codeName", codeName));
  }

  public Country getCountryByName(String name)
      throws CountryNotFoundException {
    JdbcTemplate jdbcTemplate = getJdbcTemplate();
    //		List<Country> countryList = jdbcTemplate.query(GET_COUNTRY_BY_NAME_SQL
    //				+ name + "'", COUNTRY_ROW_MAPPER);
    //		if (countryList.isEmpty()) {
    //			throw new CountryNotFoundException();
    //		}
    //		return countryList.get(0);
    return null;
  }
}
