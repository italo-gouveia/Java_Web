package br.com.italo.springrest.dao;

import br.com.italo.springrest.domain.Curso;
import br.com.italo.springrest.exception.NaoExisteDaoException;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CursoDAOImpl implements CursoDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void save(Curso curso) {
		entityManager.persist(curso);
	}

	@Override
	public void update(Curso curso) {
		entityManager.merge(curso);
	}

	@Override
	public void delete(Long id) {
		try {
			entityManager.remove(entityManager.getReference(Curso.class, id));
		}catch(EntityNotFoundException ex) {
			throw new NaoExisteDaoException("Curso nÃ£o encontrado para id = " + id + ".");
		}
		
	}

	@Override
	public Curso findById(Long id) {
        Curso curso = entityManager.find(Curso.class, id);
        if (curso == null) {
            throw new NaoExisteDaoException("Curso nÃ£o encontrado para id = " + id + ".");
        }
        return curso;
	}

	@Override
	public List<Curso> findAll() {
		return entityManager
				.createQuery("select c from Curso c", Curso.class)
				.getResultList();
	}

}
