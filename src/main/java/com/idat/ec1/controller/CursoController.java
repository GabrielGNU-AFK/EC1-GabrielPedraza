package com.idat.ec1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.idat.ec1.model.Curso;
import com.idat.ec1.service.CursoService;

@RestController
@RequestMapping("/curso/v1")
public class CursoController {
	
	@Autowired
	private CursoService service;
	
	@RequestMapping(path="/listar", method=RequestMethod.GET)
	public ResponseEntity<List<Curso>> listar(){
		return new ResponseEntity<List<Curso>>(service.listar(),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Curso curso){
		service.guardar(curso);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	@RequestMapping(path="/listar/{id}", method=RequestMethod.GET)
	public ResponseEntity<Curso> obtenerPorId(@PathVariable Integer id){
		Curso curso=service.obtener(id);
		if(curso!=null) {
			return new ResponseEntity<Curso>(curso,HttpStatus.OK);
		}else {
			return new ResponseEntity<Curso>(curso,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path="/editar", method =RequestMethod.PUT )
	public ResponseEntity<Void> editar(@RequestBody Curso curso){
		
		Curso Obj=service.obtener(curso.getIdCurso());
		if(Obj !=null) {
			service.actualizar(curso);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path="/eliminar/{id}",  method =RequestMethod.DELETE )
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Curso Obj=service.obtener(id);
		if(Obj !=null) {
			service.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else{

			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	
	
	

}
