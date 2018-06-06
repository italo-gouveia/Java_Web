package br.com.italo.springrest.avaliacaodesoftware.dao;

import java.util.List;

import br.com.italo.springrest.avaliacaodesoftware.domain.Usuario;

public interface UsuarioDao {
	void salvar(Usuario usuario);
	
	void editar(Usuario usuario);
	
	void excluir(Long id);
	
	Usuario getId(Long id);
	
	List<Usuario> getTodos();
	
	List<Usuario> getByNome(String nome);
}
