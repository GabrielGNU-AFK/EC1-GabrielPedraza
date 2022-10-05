package com.idat.ec1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ec1.model.MallaCurricular;
import com.idat.ec1.repository.MallaCurricularRepository;

@Service
public class MallaCurricularImpl implements MallaCurricularService {
	
	@Autowired
	private MallaCurricularRepository repository;

	@Override
	public void guardar(MallaCurricular malla) {
		repository.save(malla);
		
	}

	@Override
	public void actualizar(MallaCurricular malla) {
		repository.saveAndFlush(malla);
	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<MallaCurricular> listar() {
		return repository.findAll();
	}

	@Override
	public MallaCurricular obtener(Integer id) {
		return repository.findById(id).orElse(null);
	}

}
