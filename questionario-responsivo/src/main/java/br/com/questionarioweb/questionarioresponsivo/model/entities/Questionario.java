package br.com.questionarioweb.questionarioresponsivo.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




@Entity
@Table(name="tb_questionario")
public class Questionario {
	
	public Questionario() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="titulo", length=100)
	private String titulo;
	
	private String usuario;
	
	@OneToMany(mappedBy = "questionario", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("questionario")
	private List<Questao> questoes;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_criacao")
	private Date dataCriacao = new java.sql.Date(System.currentTimeMillis());
	
	public Questionario(String titulo, String usuario, Date data) {		
		this.titulo = titulo;
		this.usuario = usuario;
		this.dataCriacao = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
}
