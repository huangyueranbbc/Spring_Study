package com.hyr.dao.implement;

import com.hyr.dao.UserDAO;
import com.hyr.model.User;

public class UserDAOODBCImplement implements UserDAO {

	private int id;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void save(User user) {
		System.out.println("a user saved! -----by ODBC");
	}
	@Override
	public String toString() {
		return this.getClass().getName()+"Id="+id;
	}
}
