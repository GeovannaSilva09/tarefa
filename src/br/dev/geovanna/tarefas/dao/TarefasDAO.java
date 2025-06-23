package br.dev.geovanna.tarefas.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import br.dev.geovanna.tarefas.model.Funcionario;
import br.dev.geovanna.tarefas.model.Tarefa;



public class TarefasDAO {

    private static final String CAMINHO_ARQUIVO = 
        "C:\\Users\\geovanna\\OneDrive\\Documentos\\tarefas-DS1T-A\\tarefas.csv.txt";

    private Tarefa tarefa;

    public TarefasDAO() {
    }

    public TarefasDAO(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public void salvar() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO, true))) {
            String matriculaResponsavel = (tarefa.getResponsavel() != null) 
                ? tarefa.getResponsavel().getMatricula() 
                : ""; // Caso não tenha responsável
            bw.write(tarefa.getNome() + ","
                   + tarefa.getDescricao() + ","
                   + tarefa.getDataInicio() + ","
                   + tarefa.getPrazo() + ","
                   + tarefa.getDataEntrega() + ","
                   + matriculaResponsavel);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<Tarefa> getTarefas() {
        List<Tarefa> tarefas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO_ARQUIVO))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");

                if (dados.length >= 5) {
                    Tarefa tarefa = new Tarefa();
                    tarefa.setNome(dados[0]);
                    tarefa.setDescricao(dados[1]);
                    tarefa.setDataInicio(dados[2]);
                    tarefa.setPrazo(dados[3]);
                    tarefa.setDataEntrega(dados[4]);

                    // Se existir uma matrícula salva
                    if (dados.length >= 6 && !dados[5].isEmpty()) {
                        FuncionarioDAO daoFuncionario = new FuncionarioDAO(null);
                        Funcionario responsavel = daoFuncionario.buscarPorMatricula(dados[5]);
                        tarefa.setResponsavel(responsavel);
                    }

                    tarefas.add(tarefa);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tarefas;
    }
}