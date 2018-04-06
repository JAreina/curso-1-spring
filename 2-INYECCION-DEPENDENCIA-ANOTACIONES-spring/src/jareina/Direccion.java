package jareina;

import org.springframework.stereotype.Component;

// sin usar archivo xml de config con @Component 
//puede ser inyectada en otra clase


@Component
public class Direccion {

	private String calle;
	private String cp;
	
	public Direccion() {}

	public Direccion(String calle, String cp) {
		super();
		this.calle = calle;
		this.cp = cp;
	}

	@Override
	public String toString() {
		return "Direccion [calle=" + calle + ", cp=" + cp + "]";
	};
	
	
	
}
