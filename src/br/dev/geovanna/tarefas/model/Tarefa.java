package br.dev.geovanna.tarefas.model;

import br.dev.geovanna.tarefas.utils.Utils;

public class Tarefa {

	private String codigo;
	private String nome;
	private String descricao;
	private String dataInicio;
	private String Prazo;
	private String dataEntrega;
	private Status status;
	private Funcionario responsavel;

	
    public Tarefa() {
        this.codigo = Utils.gerarUUID8();
    }

    public Tarefa(String nome) {
        this.nome = nome;
        this.codigo = Utils.gerarUUID8();
    }
	
	
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getPrazo() {
		return Prazo;
	}

	public void setPrazo(String prazo) {
		Prazo = prazo;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Funcionario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Funcionario responsavel) {
		this.responsavel = responsavel;
	}
	
	@Override
	public String toString() {
		return nome + "," + descricao +  "," + dataInicio + "," + Prazo + "," + dataEntrega + responsavel + "\n";
	}
	
	
}