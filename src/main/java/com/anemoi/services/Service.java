package com.anemoi.services;

import java.sql.SQLException;
import java.util.List;

import com.anemoi.model.User;

public interface Service {
//	connecting to database
//	public Connection connection() throws ClassNotFoundException, SQLException;
//	posting data
	public String insertdata(User user) throws ClassNotFoundException, SQLException;

//	Getting data	
	public List<User> getuserdata() throws ClassNotFoundException, SQLException;
//	Updating the user data 

	public User updateuserdata(User user, int id) throws ClassNotFoundException, SQLException;

	public String deleteuserdata(int id) throws SQLException;
}
