package br.dev.geovanna.tarefas.ui;

import java.awt.Color;	
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.dev.geovanna.tarefas.dao.FuncionarioDAO;
import br.dev.geovanna.tarefas.model.Funcionario;

public class FuncionariosListaFrame {
	
	private JLabel labelTitulo;
	private JButton btnNovo;
	
	private JTable tabelaFuncionarios;
	private DefaultTableModel modelFuncionarios;
	private JScrollPane scroll;
	
	private String[] colunas = {"CÓDIGO", "NOME DO FUNCIONÁRIO", "CARGO"};
	
	
	public FuncionariosListaFrame() {
		criarTela();
		
	}
	
	private void criarTela() {
		JFrame tela = new JFrame("Lista de funcionários");
		tela.setSize(600, 500);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		
		Container painel = tela.getContentPane();
		
		labelTitulo = new JLabel("Cadastro de funcionários");
		labelTitulo.setFont(new Font ("arial", Font.BOLD, 28));
		labelTitulo.setForeground(new Color (100, 0,100));
		labelTitulo.setBounds(10, 10, 400, 40);
		
		
		
		modelFuncionarios = new DefaultTableModel(colunas, 1);
		carregarDados();
		tabelaFuncionarios = new JTable(modelFuncionarios);
		scroll = new JScrollPane(tabelaFuncionarios);
		scroll.setBounds(10, 60, 580, 340);
		
		btnNovo = new JButton("Novo");
		btnNovo.setBounds(10, 410, 150, 40);
		
		btnNovo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FuncionarioFrame(tela);
				carregarDados();
			}
		});
		
		
		
		
		painel.add(labelTitulo);
		painel.add(scroll);
		painel.add(btnNovo);
		
		tela.setVisible(true);
		
		
		
	}
	
	private Object[][] carregarDados() {
		// Obter os dados que serão exibidos na Tabela
		FuncionarioDAO dao = new FuncionarioDAO(null);
		List<Funcionario> funcionarios = dao.getFuncionarios();
		
		Object[][] dados = new Object[funcionarios.size()][3];
		
		int i = 0;
		for(Funcionario f : funcionarios) {
			dados[i][0] = f.getMatricula();
			dados[i][1] = f.getNome();
			dados[i][2] = f.getCargo();
			i++;
		}
		modelFuncionarios.setDataVector(dados, colunas);
		return dados;
	}

	
}
