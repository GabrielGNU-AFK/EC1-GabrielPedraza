package com.idat.ec1.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="mallasCurriculares")
public class MallaCurricular {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMalla;
	private String año;
	
	@OneToMany(mappedBy = "mallas")
	private List<Curso> cursos=new ArrayList<>();
	
	@OneToOne
	private Universidad universidad;
	
	
	public int getIdMalla() {
		return idMalla;
	}
	public void setIdMalla(int idMalla) {
		this.idMalla = idMalla;
	}
	public String getAño() {
		return año;
	}
	public void setAño(String año) {
		this.año = año;
	}
	
	
	
	

}
