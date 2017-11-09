package com.techelevator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.model.UserDao;

@RestController 
public class UserApiController {
	
	@Autowired
	UserDao dao;

}
