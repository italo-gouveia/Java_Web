package br.com.conductor.rest;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.conductor.dao.ContaDAO;
import br.com.conductor.entitys.ContaModel;

@Path("/contas")
public class ContaService {
	
	private static final String CHARSET_UTF8 = ";charset=utf-8";
	
	private ContaDAO contaDAO;
	
	@PostConstruct
	private void init() {
		contaDAO = new ContaDAO();
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN)
	public String addConta(ContaModel conta) {
		String msg = "";

		try {
			int idGerado = contaDAO.addConta(conta);
			String txtIdGerado = String.valueOf(idGerado);
			msg = "Conta adicionada com sucesso! ID: " + txtIdGerado;
		} catch (Exception e) {
			msg = "Erro ao adicionar a conta!";
			e.printStackTrace();
		}

		return msg;
	}
	
	@GET
	@Path("/getSaldo/{id}")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN)
	public float consultarSaldoPorId(@PathParam("id") int idConta) {
		float conta = 0;
		
		try {
			conta = contaDAO.getSaldoPorId(idConta);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conta;
	}
	
	@PUT
	@Path("/sacar")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN)
	public String saqueConta(@QueryParam("valorSaque") double valorSaque, @QueryParam("id") int idConta) {
		String msg = "";
		
		try {
			double valorSacado = contaDAO.sacar(idConta, valorSaque);
			if(valorSacado == 0) {
				msg = " Impossível Realizar saque por um dos seguintes motivos:"
						+ "\n Saldo em conta insuficiente"
						+ "\n Limite diário de saque insuficiente"
						+ "\n Cota de saques diários esgotada hoje"
						+ "\n Cliente inativo.";
			}else {
				msg = "Saque realizado com sucesso!";	
			}
		}catch(Exception e) {
			msg = "Erro ao realizar o saque!";
			e.printStackTrace();
		}
		
		return msg;
	}
	
	@PUT
	@Path("/depositar")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN)
	public String depositoConta(@QueryParam("valorDeposito") double valorDeposito, @QueryParam("id") int idConta) {
		String msg = "";
		
		try {
			int result = contaDAO.depositar(idConta, valorDeposito);
			if(result > 0) {
				msg = "Deposito realizado com sucesso!";	
			}else {
				msg = "Deposito não pode ser feito em contas inátivas ou inexistentes";
			}
		}catch(Exception e) {
			msg = "Erro ao realizar o deposito!";
			e.printStackTrace();
		}
		
		return msg;
	}
	
	@PUT
	@Path("/ativo")
	@Consumes({MediaType.MULTIPART_FORM_DATA, MediaType.APPLICATION_JSON})
	@Produces(MediaType.TEXT_PLAIN)
	public String bloqueioConta(@QueryParam("flagAtivo") boolean bloqueio, @QueryParam("id") int idConta) {
		String msg = "";
		
		try {
			contaDAO.statusConta((int) idConta, (boolean) bloqueio);
			msg = "Operação realizada com sucesso!";
		}catch(Exception e) {
			msg = "Erro ao realizar a Operação!";
			e.printStackTrace();
		}
		
		return msg;
	}
	
}
