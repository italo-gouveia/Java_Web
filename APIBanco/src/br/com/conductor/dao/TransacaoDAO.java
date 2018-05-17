package br.com.conductor.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.conductor.config.BDConfig;
import br.com.conductor.entitys.TransacaoModel;

public class TransacaoDAO {
	
	public List<TransacaoModel> listarTransacoesPorId(int idConta) throws Exception {
		List<TransacaoModel> lista = new ArrayList<>();
		
		Connection conexao = BDConfig.getConnection();
		String sql = "SELECT * FROM transacoes WHERE idConta = ?";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, idConta);
		ResultSet rs = statement.executeQuery();
		
		while (rs.next()) {
			TransacaoModel transacao = new TransacaoModel();
			transacao.setIdConta(rs.getInt("idConta"));
			transacao.setValor(rs.getDouble("valor"));
			transacao.setIdTransacao(rs.getInt("idTransacao"));
			transacao.setDataTransacao(rs.getDate("dataTransacao"));

			lista.add(transacao);
		}
		return lista;		
	}
	
	public List<TransacaoModel> listarTransacoesPorPeriodo(int idConta, String dataInicio, String dataFim) throws Exception {
		List<TransacaoModel> lista = new ArrayList<>();
		Date inicioSql = Date.valueOf(dataInicio);
		Date fimSql = Date.valueOf(dataFim);
		
		Connection conexao = BDConfig.getConnection();
		String sql = "SELECT * FROM transacoes WHERE idConta = ? AND dataTransacao BETWEEN ? AND ?";
		
		PreparedStatement statement = conexao.prepareStatement(sql);				
		statement.setInt(1, idConta);
		statement.setDate(2, inicioSql);
		statement.setDate(3, fimSql);
		ResultSet rs = statement.executeQuery();
		
		while (rs.next()) {
			TransacaoModel transacao = new TransacaoModel();
			transacao.setIdConta(rs.getInt("idConta"));
			transacao.setValor(rs.getDouble("valor"));
			transacao.setIdTransacao(rs.getInt("idTransacao"));
			transacao.setDataTransacao(rs.getDate("dataTransacao"));

			lista.add(transacao);
		}
		return lista;		
	}
	
	public int addTransacao(TransacaoModel transacao) throws Exception {
		int idGerado = 0;
		Date data = new Date(System.currentTimeMillis());
		
		Connection conexao = BDConfig.getConnection();
		String sql = "INSERT INTO transacoes(idConta, valor, dataTransacao) VALUES(?, ?, ?)";

		PreparedStatement statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		statement.setInt(1, transacao.getIdConta());
		statement.setDouble(2, transacao.getValor());
		statement.setDate(3, data);
		statement.execute();
		
		ResultSet rs = statement.getGeneratedKeys();
		if(rs.next()) {
			idGerado = rs.getInt(1);
		}
		return idGerado;
	}
}