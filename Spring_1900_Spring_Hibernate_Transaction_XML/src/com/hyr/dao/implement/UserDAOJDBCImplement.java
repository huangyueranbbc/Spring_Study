package com.hyr.dao.implement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Component;

import com.hyr.dao.UserDAO;
import com.hyr.model.User;

@Component("u1")
public class UserDAOJDBCImplement implements UserDAO {
	private DataSource dataSource;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	@Override
	public void save(User user) {
		try {
			conn=dataSource.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from µç»°±¡");
			while(rs.next()){
				System.out.print(rs.getString("name")+":");
				System.out.println(rs.getDate("date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(stmt!=null){
				try {
					stmt.close();
					stmt=null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null){
				try {
					rs.close();
					rs=null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
					conn=null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("a user saved! -----by JDBC");
	}
	public DataSource getDataSource() {
		return dataSource;
	}
	@Resource(name="myDataSource")
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
		
}
