package com.techelevator;

import java.math.BigDecimal;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class LectureExample {

	public static void main(String[] args) {
		//this JUST FINDS THE CONNECTION. DOESNT MAKE CONNECTION!!!
		BasicDataSource sqlDatasource = new BasicDataSource();
		sqlDatasource.setUrl("jdbc:postgresql://localhost:5432/world");
		sqlDatasource.setUsername("postgres");
		sqlDatasource.setPassword("password");
		
		//This is the ACTUAL connection to the database named sqlDatasource.
		JdbcTemplate worldConnection = new JdbcTemplate(sqlDatasource);
		
		String continent = "Africa";
		int minPopulation = 500;
		//String of SELECT statement. 
		//The ? is allowing continent to be changed.
		String sqlCountriesInNorthAmerica = "SELECT * FROM country WHERE continent =? AND population >= ?";
		
		//selecting the data using SqlRowSet.
		//The agruments put into queryForRowSet are related to variables created by ? in the Select statement
		SqlRowSet countryRowSet = worldConnection.queryForRowSet(sqlCountriesInNorthAmerica, continent, minPopulation);
		
		//goes to server and asks for info piece by piece.
		while(countryRowSet.next()){
		//ask datatype to convert to Java's datatype. If not, could be datatype foreign to java like serial. So were getting a String
			String name = countryRowSet.getString("name");
			int population  = countryRowSet.getInt("population");
			BigDecimal gnp = countryRowSet.getBigDecimal("gnp");
			
			System.out.println(name + " - " +  population + " - " + gnp);
		};
		
		
		
		//Creating count method
		
		
		String sqlCountCountriesInNorthAmerica = "SELECT count(*) FROM country WHERE continent =? AND population >= ? ";

		int countOfCountries = worldConnection.queryForObject(sqlCountCountriesInNorthAmerica, Integer.class, continent, minPopulation);
		
		System.out.println("Number of Countries was: " + countOfCountries);
		
		
		
		
		
		
		
		//Creating new city!!!
		String sqlCreateCity = "INSERT INTO city (id, name, countrycode, district, population) VALUES (?, ?, ?, ?, ?)";
		
		//worldConnection.update(sqlCreateCity, 5500, "Joeville", "USA", "Ohio", 1);
		
		
		
		
		
		BasicDataSource sqlDVDDatasource = new BasicDataSource();
		sqlDVDDatasource.setUrl("jdbc:postgresql://localhost:5432/dvdstore");
		sqlDVDDatasource.setUsername("postgres");
		sqlDVDDatasource.setPassword("password");
		
		JdbcTemplate dvdConnection = new JdbcTemplate(sqlDVDDatasource);
		
		//Using RETURN to create new actor_id (so you dont duplicate)
		String sqlCreateActor = "INSERT INTO actor (first_name, last_name) VALUES (?, ?) RETURNING actor_id";
		
		//Second parameter is class type!
		int newActorId = dvdConnection.queryForObject(sqlCreateActor, Integer.class, "Joe", "Erickson");
		
		System.out.println("New actor ID is: " + newActorId);
		
		

		
	}
	
	
	
	
	

}
