package br.com.conductor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import br.com.conductor.config.BDConfig;
import br.com.conductor.entitys.ContaModel;
import br.com.conductor.entitys.TransacaoModel;

public class ContaDAO {
	
	TransacaoDAO transacaoDao = new TransacaoDAO();
	
	public float getSaldoPorId(int idConta) throws Exception{
		float saldo = 0;
		
		Connection conexao = BDConfig.getConnection();
		String sql = "SELECT saldo FROM contas WHERE idConta= ?";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, idConta);
		ResultSet rs = statement.executeQuery();
		
		if(rs.next()) {
			saldo = rs.getFloat("saldo");
		}
		return saldo;
	}
	
	public float getLimiteSaquePorId(int idConta) throws Exception{
		float limiteSaqueDiario = 0;
		
		Connection conexao = BDConfig.getConnection();
		String sql = "SELECT limiteSaqueDiario FROM contas WHERE idConta= ?";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, idConta);
		ResultSet rs = statement.executeQuery();
		
		if(rs.next()) {
			limiteSaqueDiario = rs.getFloat("limiteSaqueDiario");
		}
		
		return limiteSaqueDiario;
	}
	
	public float getTotalSacadoHoje(int idConta) throws Exception {
		float valorTotalSacado = 0;
		
		Connection conexao = BDConfig.getConnection();
		String sql = "SELECT SUM(valor) FROM transacoes WHERE idConta=? AND dataTransacao = CURRENT_DATE";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, idConta);
		ResultSet rs = statement.executeQuery();
		
		if(rs.next()) {
			valorTotalSacado = rs.getFloat("sum(valor)");
		}
		return valorTotalSacado;
	}
	
	public boolean verificarStatusConta(int idConta) throws Exception{
		boolean isActivity = false;
		
		Connection conexao = BDConfig.getConnection();
		String sql = "SELECT flagAtivo FROM contas WHERE idConta= ?";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, idConta);
		ResultSet rs = statement.executeQuery();
		
		if(rs.next()) {
			isActivity = rs.getBoolean("flagAtivo");
		}
		return isActivity;
	}
	
	public int addConta(ContaModel conta) throws Exception {
		int idGerado = 0;
		
		Connection conexao = BDConfig.getConnection();
		String sql = "INSERT INTO contas(idPessoa, saldo, limiteSaqueDiario, flagAtivo, tipoConta, dataCriacao) VALUES(?, ?, ?, ?, ?, CURRENT_DATE)";

		PreparedStatement statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		statement.setInt(1, conta.getIdPessoa());
		statement.setFloat(2, conta.getSaldo());
		statement.setFloat(3, conta.getLimiteSaqueDiario());
		statement.setBoolean(4, conta.isFlagAtivo());
		statement.setInt(5, conta.getTipoConta());
		statement.executeUpdate();
		
		ResultSet rs = statement.getGeneratedKeys();
		if(rs.next()) {
			idGerado = rs.getInt(1);
		}
		return idGerado;
	}
	
	public int depositar(int idConta, double valorDeposito) throws Exception {
		boolean isActive = verificarStatusConta(idConta);
		float saldoAtual = getSaldoPorId(idConta);
		double novoSaldo = saldoAtual+valorDeposito;
		int resultSQL=0;
		if(isActive == true) {
			Connection conexao = BDConfig.getConnection();
			String sql = "UPDATE contas SET saldo = ? WHERE idConta = ?";
			
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setDouble(1, novoSaldo);
			statement.setInt(2, idConta);
			resultSQL = statement.executeUpdate();
			
			if(resultSQL > 0) {
				TransacaoModel transacao = new TransacaoModel(idConta, valorDeposito);
				transacaoDao.addTransacao(transacao);	
			}	
		}
		return resultSQL;
	}
	
	public double sacar(int idConta, double valorSaque) throws Exception{
		float saldoAtual = getSaldoPorId(idConta);
		float limiteSaque = getLimiteSaquePorId(idConta);
		boolean isActive = verificarStatusConta(idConta);
		float valorTotalSacadoHoje = getTotalSacadoHoje(idConta);
		limiteSaque = limiteSaque - valorTotalSacadoHoje;
		
		if(valorSaque <= saldoAtual && valorSaque <= limiteSaque && isActive == true) {
			Connection conexao = BDConfig.getConnection();
			String sql = "UPDATE contas SET saldo = ? WHERE idConta = ?";
			
			double novoSaldo = saldoAtual-valorSaque;
			
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setDouble(1, novoSaldo);
			statement.setInt(2, idConta);
			int resultSQL = statement.executeUpdate();
			
			if(resultSQL > 0) {
				TransacaoModel transacao = new TransacaoModel(idConta, valorSaque);
				transacaoDao.addTransacao(transacao);	
			}
			
		}else {
			valorSaque = 0;
		}
		
		return valorSaque;
	}
	
	public void statusConta(int idConta, boolean bloqueio) throws Exception{
		Connection conexao = BDConfig.getConnection();
		String sql = "UPDATE contas SET flagAtivo = ? WHERE idConta = ?";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setBoolean(1, bloqueio);
		statement.setInt(2, idConta);
		statement.execute();
	}
		
}
