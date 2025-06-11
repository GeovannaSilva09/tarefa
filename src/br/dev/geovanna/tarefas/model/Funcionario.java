package br.dev.geovanna.tarefas.model;


import br.dev.geovanna.tarefas.utils.Utils;

public class Funcionario {

	private String nome;
	private String setor;
	private String matricula;
	private String cargo;

	public Funcionario(String nome) {
		this.nome = nome;
		this.matricula = Utils.gerarUUID8();
	}

	public Funcionario(String nome, String cargo) {
		this.nome = nome;
		this.cargo = cargo;
		this.matricula = Utils.gerarUUID8();

	}

	public Funcionario() {
		this.matricula = Utils.gerarUUID8();

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getMatricula() {
		return matricula;
	}
	 
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return matricula + "," + nome + "," + cargo + "," + setor + "\n";
	}

}
// Métodos podem ter nomes iguais se tiverem argumentos diferentes exemplo: public Funcionario.
//f guarda o endereço do objeto
//Split UUID
// \n mudança de linha
//Polimorfismo



// command /


















//public static void main(String[] args) {

//UUID uuid = UUID.randomUUID();
//System.out.println(uuid);

//String escola = "Senai Jandira";
//String cidade = escola.substring(6, 13);
//System.out.println(cidade);

//String uuid8 = uuid.toString().substring(0, 8);
//System.out.println(uuid8);

//Funcionario f = new Funcionario("Pedro", "Programador");
//f.setSetor("TI");
//System.out.println(f.getNome());
//System.out.println(f.getMatricula());

//Funcionario f2 = new Funcionario();
//f2.setNome("Carlos Augusto");

//System.out.println(f2.getNome());