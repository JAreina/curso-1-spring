package jareina;

public class Administrador {

	
	private int id;
	private String nombre;
	private Direccion direccion;
	
	public Administrador() {};
	
	public Administrador(int id, String nombre) {
		
		this.id = id;
		this.nombre = nombre;
	}

	

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion= direccion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	



	@Override
	public String toString() {
		return "Administrador [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}

	public void imprimir() {
		System.out.println("hola");
		
	}
}
