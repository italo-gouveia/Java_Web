package br.com.conductor.rest;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.conductor.dao.TransacaoDAO;
import br.com.conductor.entitys.TransacaoModel;

@Path("/transacoes")
public class TransacoesService {
	
	private TransacaoDAO transacaoDAO;
	
	@PostConstruct
	private void init() {
		transacaoDAO = new TransacaoDAO();
	}
	
	@GET
	@Path("/list")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public List<TransacaoModel> listarTransacoesPorId(@QueryParam("id") int idConta){
		List<TransacaoModel> lista = null;
		
		try {
			lista = transacaoDAO.listarTransacoesPorId((int) idConta);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	@GET
	@Path("/list/periodo")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	@Produces(MediaType.APPLICATION_JSON)
	public List<TransacaoModel> listarTransacoesPorPeriodo(@QueryParam("id") int idConta, @QueryParam("inicio") String dataInicio, @QueryParam("fim") String dataFim){
		List<TransacaoModel> lista = null;
		
		try {
			lista = transacaoDAO.listarTransacoesPorPeriodo(idConta, dataInicio, dataFim);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
}
