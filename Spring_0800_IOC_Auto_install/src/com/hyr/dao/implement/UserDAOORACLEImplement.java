package com.hyr.dao.implement;

import com.hyr.dao.UserDAO;
import com.hyr.model.User;

public class UserDAOORACLEImplement implements UserDAO {

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
		System.out.println("a user saved! -----use ORACLE");
	}
	@Override
	public String toString() {
		return this.getClass().getName()+"Id="+id;
	}
}
