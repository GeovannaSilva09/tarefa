package br.dev.geovanna.tarefas.dao;


import java.io.BufferedReader;	
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.geovanna.tarefas.model.Funcionario;

public class FuncionarioDAO {

	private Funcionario funcionario;
	private FileWriter fw;
	private BufferedWriter bw;
	private FileReader fr;
	private BufferedReader br;
	
	private String arquivo = "/Users/25132823/tarefasDS1TA/funcionarios.csv";

	public FuncionarioDAO(Funcionario funcionario) {
		this.funcionario = funcionario;

		try {

			fw = new FileWriter(arquivo, true);
			bw = new BufferedWriter(fw);
			fr = new FileReader(arquivo);
			br = new BufferedReader(fr);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void salvar() {
		try {
			bw.write(funcionario.toString());
			bw.flush();
			System.out.println(funcionario.getNome() + " gravado com sucesso!");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
       public List<Funcionario> getFuncionarios() {
		
		List<Funcionario> funcionarios = new ArrayList<>();
		
		try {
			String linha = "";
			
			while(linha != null) {
				linha = br.readLine();
			
					 if (linha != null) {
						String[] funcionarioVetor = linha.split(",");
						Funcionario funcionario = new Funcionario();
						funcionario.setMatricula(funcionarioVetor[0]);
						funcionario.setNome(funcionarioVetor[1]);
						funcionario.setCargo(funcionarioVetor[2]);
						funcionario.setSetor(funcionarioVetor[3]);
						funcionarios.add(funcionario);
					}
				}
			return funcionarios;
		} catch (Exception e) {
			
		}
		return null;
	}
	

}
