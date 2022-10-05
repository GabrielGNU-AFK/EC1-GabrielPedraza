package com.idat.ec1.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="universidades")
public class Universidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUniversidad;
	private String universidad;
	
	@OneToOne
	private MallaCurricular malla;
	
	
	public int getIdUniversidad() {
		return idUniversidad;
	}
	public void setIdUniversidad(int idUniversidad) {
		this.idUniversidad = idUniversidad;
	}
	public String getUniversidad() {
		return universidad;
	}
	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}
	

	
	
	
	

}
