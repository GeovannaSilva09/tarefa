package br.dev.geovanna.tarefas.model;

import java.time.LocalDate;

public class Tarefa {

	private String nome;
	private String descricao;
	private String dataInicio;
	private String prazo;
	private String dataPrevisaoDeEntrega;
	private String dataEntrega;
	private String status;
	private String responsavel;

	public Tarefa() {
		System.out.println("Criando uma tarefa...");

	}

	public Tarefa(String nome) {
		System.out.println("Criando a tarefa " + nome);
		this.nome = nome;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String string) {
		this.dataInicio = string;
	}

	public String getPrazo() {
		return prazo;
	}

	public void setPrazo(String string) {
		this.prazo = string;
	}

	public String getDataPrevisaoDeEntrega() {
		return dataPrevisaoDeEntrega;
	}

	public void setDataPrevisaoDeEntrega(String string) {
		this.dataPrevisaoDeEntrega = string;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Object object) {
		this.dataEntrega = (String) object;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String string) {
		this.responsavel = string;
	}

	
}
