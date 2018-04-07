package jareina.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	}

	public String getCalle() {
		return calle;
	}

	@Autowired
	public void setCalle(@Value("valor por defecto de calle")String calle) {
		this.calle = calle;
	}

	public String getCp() {
		return cp;
	}
      @Autowired
	public void setCp(@Value("valor por defecto codigo postal")String cp) {
		this.cp = cp;
	};
	
	
	
}
