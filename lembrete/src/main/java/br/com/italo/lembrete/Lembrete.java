package br.com.italo.lembrete;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lembrete {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //cria coluna auto_increment na tabela
	private long id;
	
	@Column(nullable = false) //define que a coluna não aceita valores nulos
	private String titulo;
	
	@Column(nullable = false)
	private String descricao;
	
	public Lembrete() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Lembrete [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + "]";
	}

}
