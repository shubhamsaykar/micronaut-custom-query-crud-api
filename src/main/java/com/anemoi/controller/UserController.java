package com.anemoi.controller;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import com.anemoi.model.User;
import com.anemoi.services.Service;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;

@Controller
public class UserController {

	@Inject
	public Service service;

//	@Get("/connection")
//	public String getConnction() throws ClassNotFoundException, SQLException {
//		this.serviceimpl.connection();
//		return "Connected to database";
//	}
//
	@Post("/addusers")
	public String insertdata(@Body User user) throws ClassNotFoundException, SQLException {

		this.service.insertdata(user);

		return "data inserted successfully";

	}

	@Get("/getusers")
	public List<User> getuserdata() throws ClassNotFoundException, SQLException {

		List<User> users = this.service.getuserdata();

		return users;

	}

	@Put("/updatedata/{id}")
	public String updateuserdata(@PathVariable(value = "id") int id, @Body User user)
			throws ClassNotFoundException, SQLException {

		this.service.updateuserdata(user, id);
		return "Data Updated Successfully.";
	}

	@Delete("/deleteuser/{id}")
	public String deleteUser(@PathVariable(value = "id") int id) throws SQLException {

		this.service.deleteuserdata(id);
		return "Data deleted successfully";
	}

}
