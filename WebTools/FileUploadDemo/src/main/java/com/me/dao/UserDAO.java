package com.me.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.exception.UserException;
import com.me.pojo.User;

public class UserDAO extends DAO {

	public UserDAO() {
	}

	 
	public List<User> get(String key,String flag) throws UserException {
		try {
			begin();
			String q="";
			if (flag.equalsIgnoreCase("first")) {
                q = "from User where fname= :fname";
            } else if (flag.equalsIgnoreCase("last")) {
                q = "from User where lname= :fname";
            } else if (flag.equalsIgnoreCase("email")) {
                q = "from User where email= :fname";
            }
			Query q1 = getSession().createQuery(q);
			q1.setString("fname", key);		
			List<User> user =q1.list();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user with " + key, e);
		}
	}

	public User register(User u)
			throws UserException {
		try {
			begin();
			System.out.println("inside DAO");			
			getSession().save(u);
			commit();
			return u;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}

	public void delete(User user) throws UserException {
		try {
			begin();
			getSession().delete(user);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not delete user " + user.getFname(), e);
		}
	}
}