package com.techelevator;

import java.math.BigDecimal;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class LectureExample {

	public static void main(String[] args) {
		BasicDataSource sqlDatasource = new BasicDataSource();
		sqlDatasource.setUrl("jdbc:postgresql://localhost:5432/world");
		sqlDatasource.setUsername("postgres");
		sqlDatasource.setPassword("password");
		
		JdbcTemplate worldConnection = new JdbcTemplate(sqlDatasource);
		
		String continent = "Asia";
		int minPopulation = 5000;
		
		String sqlAllCountriesInContinent = "SELECT * FROM country WHERE continent=? AND population >= ?";
		
		SqlRowSet countryRowSet = worldConnection.queryForRowSet(sqlAllCountriesInContinent, continent, minPopulation);
		
		while(countryRowSet.next()) {
			String name = countryRowSet.getString("name");
			int population = countryRowSet.getInt("population");
			BigDecimal gnp = countryRowSet.getBigDecimal("gnp");
			
			System.out.println(name + " - " + population + " - " + gnp);
		}
		
		String sqlCountCountriesInContinent = "SELECT count(*) FROM country WHERE continent=? AND population >= ?";

		int countOfCountries = worldConnection.queryForObject(sqlCountCountriesInContinent, Integer.class, continent, minPopulation);
		
		System.out.println("Number of countries was: " + countOfCountries);
		
		String sqlCreateCity = "INSERT INTO city (id, name, countrycode, district, population) VALUES (?,?,?,?,?)";
		
		//worldConnection.update(sqlCreateCity, 5500, "Joeville", "USA", "Ohio", 1);
		
		
		BasicDataSource sqlDVDDatasource = new BasicDataSource();
		sqlDVDDatasource.setUrl("jdbc:postgresql://localhost:5432/dvdstore");
		sqlDVDDatasource.setUsername("postgres");
		sqlDVDDatasource.setPassword("password");
		
		JdbcTemplate dvdConnection = new JdbcTemplate(sqlDVDDatasource);
		
		String sqlCreateActor = "INSERT INTO actor (first_name, last_name) VALUES (?,?) RETURNING actor_id";
		int newActorId = dvdConnection.queryForObject(sqlCreateActor, Integer.class, "Joe", "Erickson");
		
		System.out.println("New actor is: " + newActorId);
	}

}
