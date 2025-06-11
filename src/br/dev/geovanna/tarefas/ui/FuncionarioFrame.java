package br.dev.geovanna.tarefas.ui;

import java.awt.Container;	
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.dev.geovanna.tarefas.dao.FuncionarioDAO;
import br.dev.geovanna.tarefas.model.Funcionario;

public class FuncionarioFrame {

	public FuncionarioFrame(JFrame tela) {
		criarTela(tela);

	}

	private void criarTela(JFrame parent) {

		JDialog tela = new JDialog(parent);
		tela.setSize(400, 400);
		tela.setTitle("Cadastro de Funcionários");
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);

		JLabel labelNome = new JLabel("Nome:");
		labelNome.setBounds(10, 10, 150, 30);
		JTextField txtNome = new JTextField();
		txtNome.setBounds(10, 40, 200, 30);

		JLabel labelCargo = new JLabel("Cargo:");
		labelCargo.setBounds(10, 75, 150, 30);
		JTextField txtCargo = new JTextField();
		txtCargo.setBounds(10, 105, 150, 30);

		JLabel labelSetor = new JLabel("Setor:");
		labelSetor.setBounds(10, 140, 150, 30);
		JTextField txtSetor = new JTextField();
		txtSetor.setBounds(10, 170, 200, 30);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 250, 150, 40);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(170, 250, 100, 40);

		Container painel = tela.getContentPane();
		painel.add(labelNome);
		painel.add(txtNome);

		painel.add(labelCargo);
		painel.add(txtCargo);

		painel.add(labelSetor);
		painel.add(txtSetor);
		painel.add(btnSalvar);
		painel.add(btnSair);

		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Funcionario f = new Funcionario();
				f.setNome(txtNome.getText());
				f.setCargo(txtCargo.getText());
				f.setSetor(txtSetor.getText());

				FuncionarioDAO dao = new FuncionarioDAO(f);
				dao.salvar();

				JOptionPane.showMessageDialog(tela, f.getNome() + " gravado com sucesso!");

				txtNome.setText(null);
				txtCargo.setText(null);
				txtSetor.setText(null);

			}
		});
		
		
		 btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(tela, "Sair do sistema?");
				if(resposta == 0) {
					
					tela.dispose();

				}
			}
		});
		 
		 
		 
	
		
		  

		tela.setVisible(true);

	}

}
