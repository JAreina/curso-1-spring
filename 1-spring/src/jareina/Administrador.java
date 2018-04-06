package jareina;

public class Administrador {

	
	private int id;
	private String nombre;
	
	
	public Administrador() {};
	
	public Administrador(int id, String nombre) {
		
		this.id = id;
		this.nombre = nombre;
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
		return "Administrador [id=" + id + ", nombre=" + nombre + "]";
	}



	public void imprimir() {
		System.out.println("hola");
		
	}
}
