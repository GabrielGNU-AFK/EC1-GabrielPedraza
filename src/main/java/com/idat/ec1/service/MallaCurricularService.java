package com.idat.ec1.service;

import java.util.List;

import com.idat.ec1.model.MallaCurricular;


public interface MallaCurricularService {
	void guardar(MallaCurricular malla);
	void actualizar(MallaCurricular malla);
	void eliminar(Integer id);
	List<MallaCurricular> listar();
	MallaCurricular obtener(Integer id);
}
