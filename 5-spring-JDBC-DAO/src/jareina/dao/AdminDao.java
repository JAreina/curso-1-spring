package jareina.dao;

import java.util.List;

import jareina.pojo.Admin;

public interface AdminDao {

	public boolean save(Admin admin) ;
	
	public List<Admin> findAll();
}
