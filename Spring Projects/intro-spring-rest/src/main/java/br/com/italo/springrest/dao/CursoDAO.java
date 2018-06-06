package br.com.italo.springrest.dao;

import java.util.List;

import br.com.italo.springrest.domain.Curso;

public interface CursoDAO {

	void save(Curso curso);
	
	void update(Curso curso);
	
	void delete(Long id);
	
	Curso findById(Long id);
	
	List<Curso> findAll();
	
}
