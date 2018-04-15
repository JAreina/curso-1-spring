package jareina.dao;

import java.util.List;

import jareina.pojo.Admin;

public interface AdminDao {

	public boolean save(Admin admin) ;
	
	public List<Admin> findAll();
	
	public Admin encontrarPorId(int id);
	public List<Admin> encontrarPorNombre(String nombre);
	public boolean actualiza(Admin admin);
	public boolean borrar(int idAd);
	//batch update: guardar varios registros al mismo tiempo
	public int [] salvarTodos(List<Admin> administradores);
}
