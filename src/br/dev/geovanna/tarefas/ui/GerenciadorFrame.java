package br.dev.geovanna.tarefas.ui;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GerenciadorFrame {

    public GerenciadorFrame() {
        CriarTela();
    }

    private void CriarTela() {
        JFrame tela = new JFrame("Gerenciador de Tarefas");
        tela.setSize(530, 200);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Encerra toda a aplicação
		tela.setResizable(false);
        tela.setResizable(false);
        tela.setLayout(null);
        tela.setLocationRelativeTo(null);

        // Botão para abrir a lista de funcionários
        JButton botaoFuncionarios = new JButton("Funcionários");
        botaoFuncionarios.setBounds(10, 30, 250, 80);

        // Botão para abrir a lista de tarefas
        JButton botaoTarefas = new JButton("Tarefas");
        botaoTarefas.setBounds(265, 30, 250, 80);

        // Ação do botão Funcionários
        botaoFuncionarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FuncionariosListaFrame();
            }
        });

        // Ação do botão Tarefas
        botaoTarefas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TarefasListaFrame();
            }
        });

        Container painel = tela.getContentPane();
        painel.add(botaoFuncionarios);
        painel.add(botaoTarefas);

        tela.setVisible(true);
    }
}