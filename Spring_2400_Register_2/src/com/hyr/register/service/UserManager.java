package com.hyr.register.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hyr.register.model.User;

public class UserManager {
	public boolean exists(User user){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/admin","root","666666");
				//检查用户名是否存在
				String sqlQuery="select count(*) from userregister where username = ?";
				PreparedStatement psQuery=connection.prepareStatement(sqlQuery);
				psQuery.setString(1, user.getUsername());
				ResultSet rs=psQuery.executeQuery();
				rs.next();
				int count=rs.getInt(1);
				psQuery.close();
				connection.close();
				if(count>0){
					return true;
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
	}
	
	public void add(User user) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/admin","root","666666");
			String sql="insert into userregister values(null,?,?)";
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.executeUpdate();
			pstmt.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
