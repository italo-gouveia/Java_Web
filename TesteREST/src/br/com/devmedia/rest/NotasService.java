package br.com.devmedia.rest;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.devmedia.dao.NotaDAO;
import br.com.devmedia.entidades.Nota;

@Path("/notas")
public class NotasService {
	
	private NotaDAO notaDAO;
	
	@PostConstruct
	private void init() {
		notaDAO = new NotaDAO();
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Nota> listarNotas(){
		List<Nota> lista = null;
		try {
			lista = notaDAO.listarNotas();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
}
