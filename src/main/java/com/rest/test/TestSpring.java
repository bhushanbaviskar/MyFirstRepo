package com.rest.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rest.entities.Account;
import com.rest.entities.Role;
import com.rest.entities.User;
import com.rest.services.UserServiceImpl;

public class TestSpring {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = 
		    	   new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
		UserServiceImpl userService = (UserServiceImpl) context.getBean("userServiceImpl");
//		AccountServiceImpl accountService = (AccountServiceImpl) context.getBean("accountServiceImpl");
		
		User user = new User();
		user.setName("NormalUser");
		user.setPassword("normalPwd");

		Role userRole = new Role();
		userRole.setType("User");
		user.setRole(userRole);
		
		List<Account> list = new ArrayList<>();
		Account account = new Account();
		account.setAccountType("Current");
		account.setBankName("HDFC Pvt Ltd");
		list.add(account);
		user.setAccount(list);
		
		userService.addUser(user);

		// To check cascade delete operation
		//userService.deleteUser("52");
		
/*		Account account = new Account();
		account.setAccountType("Saving");
		account.setBankName("HDFC");
		account.setOwner(user);
		System.out.println(accountService.saveAccountDetails(account));		
*/		
		List<User> users = userService.getAllUsersData();
		for(User userTemp : users)
			System.out.println(userTemp.toString());
	}
}
