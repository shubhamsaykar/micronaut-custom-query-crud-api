package com.anemoi.services;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.anemoi.model.User;
import com.anemoi.repository.DbConnection;

@Singleton
public class serviceimpl implements Service {

	//DbConnection dbConnection = new DbConnection();
	
	@Inject
	public DbConnection dbConnection;

	List<User> listUser = new ArrayList<>();

//	public Connection connection() {

//		return this.dbConnection.getConnection();

//	}
	@Override
	public String insertdata(User user) throws ClassNotFoundException, SQLException {

		try {

			Connection conn = dbConnection.getConnection();

			String sql = "INSERT INTO USERS (uid,firstname,lastname,email)values(?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, user.getUid());
			pstmt.setString(2, user.getFirstname());
			pstmt.setString(3, user.getLastname());
			pstmt.setString(4, user.getEmail());

			pstmt.execute();

			pstmt.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return "Data Inserted";

	}

	@Override
	public List<User> getuserdata() throws ClassNotFoundException, SQLException {

//		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=userdb";
//		String user1 = "Anemoi";
//		String pass = "Anemoi@123";
//
//		Connection conn = DriverManager.getConnection(dbURL, user1, pass);

		Connection conn = dbConnection.getConnection();

		String sql = "SELECT * FROM USERS";

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			User user = new User();

			user.setUid(rs.getInt(1));
			user.setFirstname(rs.getString(2));
			user.setLastname(rs.getString(3));
			user.setEmail(rs.getString(4));

			listUser.add(user);
		}

		return listUser;

	}

	@Override
	public User updateuserdata(User user, int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Connection conn = dbConnection.getConnection();

		String sql = "UPDATE USERS SET firstname=?, lastname=?, email=? WHERE uid=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);

		ptmt.setString(1, user.getFirstname());
		ptmt.setString(2, user.getLastname());
		ptmt.setString(3, user.getEmail());
		ptmt.setInt(4, user.getUid());

		ptmt.executeUpdate();

		return null;
	}

	@Override
	public String deleteuserdata(int id) throws SQLException {
		Connection conn = dbConnection.getConnection();

		String sql = "DELETE FROM USERS WHERE uid=?";
		// String uid = Integer.toString(id);

		// String sql = sql1 + uid;

		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, id);
		ptmt.execute();

		return "Sucess";
	}

}
