package br.com.conductor.entitys;

import java.util.Date;

public class ContaModel {


	private int idConta;
	private int idPessoa;
	private float saldo;
	private float limiteSaqueDiario;
	private boolean flagAtivo;
	private int tipoConta;
	private Date dataCriacao;
	
	public ContaModel() {
		
	}
	
	public ContaModel(int idPessoa, float saldo, float limiteSaqueDiario, boolean flagAtivo, int tipoConta) {
		super();
		this.idPessoa = idPessoa;
		this.saldo = saldo;
		this.limiteSaqueDiario = limiteSaqueDiario;
		this.flagAtivo = flagAtivo;
		this.tipoConta = tipoConta;
		this.dataCriacao = new Date(System.currentTimeMillis());;
	}

	public int getIdConta() {
		return idConta;
	}

	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public float getLimiteSaqueDiario() {
		return limiteSaqueDiario;
	}

	public void setLimiteSaqueDiario(float limiteSaqueDiario) {
		this.limiteSaqueDiario = limiteSaqueDiario;
	}

	public boolean isFlagAtivo() {
		return flagAtivo;
	}

	public void setFlagAtivo(boolean flagAtivo) {
		this.flagAtivo = flagAtivo;
	}

	public int getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(int tipoConta) {
		this.tipoConta = tipoConta;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Override
	public String toString() {
		return "ContaModel [idConta=" + idConta + ", idPessoa=" + idPessoa + ", saldo=" + saldo + ", limiteSaqueDiario="
				+ limiteSaqueDiario + ", flagAtivo=" + flagAtivo + ", tipoConta=" + tipoConta + ", dataCriacao="
				+ dataCriacao + "]";
	}
	
}
