package br.dev.geovanna.tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.geovanna.tarefas.model.Tarefa;

public class TarefasDAO {

    private Tarefa tarefa;

    private final String arquivo = "/Users/25132823/tarefasDS1TA/tarefas.csv";

    // Construtor recebe uma tarefa para salvar
    public TarefasDAO(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    // Salva a tarefa no arquivo CSV
    public void salvar() {
        try (FileWriter fw = new FileWriter(arquivo, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(tarefa.toString());
            bw.newLine(); // para garantir que cada tarefa fique em uma linha separada
            bw.flush();

            System.out.println(tarefa.getNome() + " gravado com sucesso!");

        } catch (IOException e) {
            System.err.println("Erro ao salvar a tarefa: " + e.getMessage());
        }
    }

    // Lê todas as tarefas do arquivo CSV e retorna numa lista
    public List<Tarefa> getTarefas() {
        List<Tarefa> tarefas = new ArrayList<>();

        try (FileReader fr = new FileReader(arquivo);
             BufferedReader br = new BufferedReader(fr)) {

            String linha;

            while ((linha = br.readLine()) != null) {
                // Supondo que o CSV esteja no formato: dataEntrega,dataInicio,status,nome,descricao,responsavel,...
                String[] dados = linha.split(",");

                if (dados.length >= 4) { // verifica se tem pelo menos os campos necessários
                    Tarefa t = new Tarefa();

                    t.setDataEntrega(dados[0]);
                    t.setDataInicio(dados[1]);
                    t.setStatus(dados[2]);
                    t.setNome(dados[3]);

                    // Se você tiver mais campos (descrição, responsável, etc.), pode adicionar aqui, exemplo:
                    // t.setDescricao(dados[4]);
                    // t.setResponsavel(dados[5]);

                    tarefas.add(t);
                }
            }

        } catch (IOException e) {
            System.err.println("Erro ao ler tarefas: " + e.getMessage());
        }

        return tarefas;
    }
}