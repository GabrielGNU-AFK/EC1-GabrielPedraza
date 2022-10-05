package com.idat.ec1.model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cursos")
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCurso;
	private String curso;
	private String descripcion;
	
	
	@ManyToMany()
	@JoinTable(
			name="curso_profesor",
			joinColumns = @JoinColumn(
					name="id_curso",
					nullable = false,
					unique = true,
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_curso) references cursos(id_curso)")
					),
			inverseJoinColumns = @JoinColumn(
					name="id_profesor",
					nullable = false,
					unique = true,
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_profesor) references profesores(id_profesor)")

					)
			
			)
	private List<Profesor> profesores=new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(
			name = "id_malla",
			nullable = false,
			unique = true,
			foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_malla) references mallas_curriculares(id_malla)")
			)
	private MallaCurricular mallas;
	
	
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	

}
