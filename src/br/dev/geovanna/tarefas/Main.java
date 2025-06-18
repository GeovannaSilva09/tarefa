package br.dev.geovanna.tarefas;

import java.io.BufferedReader;	
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.UUID;

import br.dev.geovanna.tarefas.dao.FuncionarioDAO;
import br.dev.geovanna.tarefas.model.Funcionario;
import br.dev.geovanna.tarefas.model.Tarefa;
import br.dev.geovanna.tarefas.ui.FuncionarioFrame;
import br.dev.geovanna.tarefas.ui.FuncionariosListaFrame;
import br.dev.geovanna.tarefas.ui.GerenciadorFrame;
import br.dev.geovanna.tarefas.ui.TarefasFrame;
import br.dev.geovanna.tarefas.ui.TarefasListaFrame;

public class Main {
	static String caminho = "/Users/25132823/tarefasDS1TA/tarefas";

	public static void main(String[] args) {
		  
		
		//FuncionarioDAO dao = new FuncionarioDAO(null);
		//dao.getFuncionarios();
		
//		String[][] frutas = new String[2][3];
//		frutas[0][0] = "Banana";
//		frutas[0][1] = 
//		
		
		//new TarefasListaFrame(null);
        new GerenciadorFrame();

//		UUID uuid = UUID.randomUUID();
//		System.out.println(uuid);
//
//		String escola = "Senai Jandira";
//		String cidade = escola.substring(6, 13);
//		System.out.println(cidade);
//
//		String uuid8 = uuid.toString().substring(0, 8);
//		System.out.println(uuid8);
//
//		Funcionario f = new Funcionario("Pedro", "Programador");
//		f.setSetor("TI");
//
//		Funcionario f2 = new Funcionario();
//		f2.setNome("Carlos Augusto");
//		f2.setCargo("Analista de sistemas");
//		f2.setSetor("TI");
//
//		FuncionarioDAO dao = new FuncionarioDAO(f2);
//		dao.salvar();

	}

	private static void escreverArquivo() {

		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter(caminho, true);
			bw = new BufferedWriter(fw);

			// Adicionando conteúdo ao arquivo
			bw.append("XPTO\n");

			bw.append("Senai Jandira\n");

			bw.append("Programação de computadores\n");

			// Mandando escrever no arquivo
			bw.flush();

		} catch (Exception e) {
			
		}

	}

	private static void lerArquivo() {

		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(caminho);
			br = new BufferedReader(fr);

			String retorno = br.readLine();

			while (retorno != null) {
				System.out.println(retorno);
				System.out.println(br.readLine());
			}

		} catch (FileNotFoundException erro) {
			System.out.println("O arquivo não foi encontrado!");
		} catch (Exception erro) {
			System.out.println("Ocorreu um erro!");
		}

		System.out.println("Fim");
	}

}




//control k para apagar arquivos no terminal ----> nano 
