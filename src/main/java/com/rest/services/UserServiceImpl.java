package com.rest.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import jersey.repackaged.com.google.common.collect.Lists;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.entities.User;
import com.rest.repositories.UserRepository;

@Service
@Path("/user")
public class UserServiceImpl {
	
	@Autowired
	UserRepository userRepository;

	@GET
	@Path("/get/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllUsersData() {
		System.out.println("Get all users data");
		List<User> users = Lists.newArrayList(userRepository.findAll());
		if(users != null && !users.isEmpty()) {
			return users;
		}
		return null;
	}
	
	@GET
	@Path("/get/{parameter}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserData(@PathParam("parameter") String parameter) {
		System.out.println("Get user data");
		return userRepository.findOne(Integer.parseInt(parameter));
	}
	
	@POST
	@Path("/add/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addUser(User user) {
		if(user != null) {
			System.out.println(" In Post Method .. :) " + user.getName() +","+user.getPassword());
			userRepository.save(user);
			return "New User Added successfully..";
		} else {
			return "Invalid Input - User data not available..";
		}
	}

	@PUT
	@Path("/update/{parameter}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updateUser(@PathParam("parameter") String parameter,User user) {
		System.out.println(" In Put Method .. :) ");
		User updateUser = userRepository.findOne(Integer.parseInt(parameter));
		if(updateUser != null) {
			updateUser.setName(user.getName());
			updateUser.setPassword(user.getPassword());
			userRepository.save(updateUser);
			return "User updated successfully..";		
		}
		return "No User found with id : "+parameter;		
		
	}

	@DELETE
	@Path("/delete/{parameter}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteUser(@PathParam("parameter") String parameter) {
		System.out.println(" In Delete Method .. :) ");
		User deleteUser = userRepository.findOne(Integer.parseInt(parameter));
		if(deleteUser != null) {
			userRepository.delete(deleteUser);
			return "User deleted successfully..";
		}
		return "No User found with id : "+parameter;		
	}
	
}
