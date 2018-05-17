package br.com.conductor.entitys;

import java.util.Date;

public class TransacaoModel {

	private int idTransacao;
	private int idConta;
	private double valor;
	private Date dataTransacao;
		
	public TransacaoModel() {
		
	}
	
	public TransacaoModel(int idConta, double valor) {
		super();
		this.idConta = idConta;
		this.valor = valor;
		this.dataTransacao = new Date(System.currentTimeMillis());
	}

	public int getIdTransacao() {
		return idTransacao;
	}
	
	public void setIdTransacao(int idTransacao) {
		this.idTransacao = idTransacao;
	}
	
	public int getIdConta() {
		return idConta;
	}
	
	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public Date getDataTransacao() {
		return dataTransacao;
	}
	
	public void setDataTransacao(Date dataTransacao) {
		this.dataTransacao = dataTransacao;
	}

	@Override
	public String toString() {
		return "TransacaoModel [idTransacao=" + idTransacao + ", idConta=" + idConta + ", valor=" + valor
				+ ", dataTransacao=" + dataTransacao + "]";
	}
	
}