package com.techelevator;

import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.city.City;
import com.techelevator.city.CityDAO;
import com.techelevator.city.JDBCCityDAO;

public class DAOExample {

	public static void main(String[] args) {
	
		BasicDataSource worldDataSource = new BasicDataSource();
		worldDataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		worldDataSource.setUsername("postgres");
		worldDataSource.setPassword("postgres1");
		
		CityDAO dao = new JDBCCityDAO(worldDataSource);
		
		City smallville = new City();
		smallville.setId(6000L);
		smallville.setCountryCode("USA");
		smallville.setDistrict("Kansas");
		smallville.setName("Smallville");
		smallville.setPopulation(42080);
		
		
		//dao.save(smallville);
		//update statement will use DAO  to update new info we put into smallville object
		dao.update(smallville);
		
		City theCity = dao.findCityById(smallville.getId());
		
		City theeCity = dao.findCityById(65);
		
		
		System.out.println(theeCity.getName());
		
		
		List<City> allCitiesInCanada = dao.findCityByCountryCode("CAN");
			for(City thisOne : allCitiesInCanada){
				thisOne.setName(thisOne.getName() + ", eh?");
				dao.update(thisOne);
			}
	}

}
