package br.dev.geovanna.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.dev.geovanna.tarefas.dao.TarefasDAO;
import br.dev.geovanna.tarefas.model.Funcionario;
import br.dev.geovanna.tarefas.model.Tarefa;
import br.dev.geovanna.tarefas.dao.FuncionarioDAO;


	public class TarefasFrame {

	private JLabel labelTitulo;
	private JTextField txtTitulo;
	private JLabel labelDescricao;
	private JTextField txtDescricao;
	private JLabel labelDataI;
	private JFormattedTextField txtDataI;
	private JLabel labelPrazo;
	private JFormattedTextField txtPrazo;
	private JLabel labelDataC;
	private JFormattedTextField txtDataC;
	private JLabel labelStatus;
	private JComboBox<String> cmbStatus;
	private JLabel labelResponsavel;
	private JComboBox<String> cmbFuncionario;
	private JButton btnSalvar;
	private JButton btnSair;
	MaskFormatter mascaraData = null;
		
	public TarefasFrame(JFrame tela) {
	
	criarTela(tela);
	
	}



	private void criarTela(JFrame tela2) {
		
		try {
            mascaraData = new MaskFormatter("##/##/####");
            mascaraData.setPlaceholderCharacter('_');
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
		JDialog tela = new JDialog(tela2, true);
		tela.setTitle("Cadastro de Tarefas");
		tela.setSize(500,600);
		tela.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		labelTitulo = new JLabel("Título:");
        txtTitulo = new JTextField();
        labelTitulo.setBounds(20, 20, 100, 25);
        txtTitulo.setBounds(20, 45, 300, 25);

        labelDescricao = new JLabel("Descrição:");
        txtDescricao = new JTextField();
        labelDescricao.setBounds(20, 80, 100, 25);
        txtDescricao.setBounds(20, 105, 300, 25);
        

        labelDataI = new JLabel("Data Inicial:");
        txtDataI = new JFormattedTextField(mascaraData);
        labelDataI.setBounds(20, 140, 100, 25);
        txtDataI.setBounds(20, 165, 300, 25);

        labelPrazo = new JLabel("Prazo:");
        txtPrazo = new JFormattedTextField(mascaraData);
        labelPrazo.setBounds(20, 200, 100, 25);
        txtPrazo.setBounds(20, 225, 300, 25);

        labelDataC = new JLabel("Data conclusão:");
        txtDataC = new JFormattedTextField(mascaraData);
        labelDataC.setBounds(20, 260, 150, 25);
        txtDataC.setBounds(20, 285, 300, 25);

        labelStatus = new JLabel("Status:");
        cmbStatus = new JComboBox<>(new String[]{"NÃO INICIADO", "EM ANDAMENTO", "CONCLUÍDO"});
        labelStatus.setBounds(20, 320, 100, 25);
        cmbStatus.setBounds(20, 345, 300, 25);

        labelResponsavel = new JLabel("Responsável:");
        FuncionarioDAO daoFuncionario = new FuncionarioDAO(null);
        List<Funcionario> funcionarios = daoFuncionario.getFuncionarios();

        String[] nomesFuncionarios = new String[funcionarios.size()];
        for (int i = 0; i < funcionarios.size(); i++) {
            nomesFuncionarios[i] = funcionarios.get(i).getNome();
        }

        cmbFuncionario = new JComboBox<>(nomesFuncionarios);

        labelResponsavel.setBounds(20, 380, 150, 25);
        cmbFuncionario.setBounds(20, 405, 300, 25);

        btnSalvar = new JButton("Salvar");
        btnSair = new JButton("Sair");
        btnSalvar.setBounds(20, 460, 120, 40);
        btnSair.setBounds(160, 460, 120, 40);
        
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tarefa t = new Tarefa();
                t.setNome(txtTitulo.getText());
                t.setDescricao(txtDescricao.getText());
                t.setDataInicio(txtDataI.getText());
                t.setPrazo(txtPrazo.getText());
                t.setDataEntrega(txtDataC.getText());

                // Obter responsável
                String nomeSelecionado = (String) cmbFuncionario.getSelectedItem();
                FuncionarioDAO daoFuncionario = new FuncionarioDAO(null);
                List<Funcionario> funcionarios = daoFuncionario.getFuncionarios();

                Funcionario responsavel = null;
                for (Funcionario f : funcionarios) {
                    if (f.getNome().equals(nomeSelecionado)) {
                        responsavel = f;
                        break;
                    }
                }

                t.setResponsavel(responsavel);

                TarefasDAO dao = new TarefasDAO(t);
                dao.salvar();

                JOptionPane.showMessageDialog(tela, t.getNome() + " gravado com sucesso!");

                txtTitulo.setText(null);
                txtDescricao.setText(null);
                txtDataI.setText(null);
                txtPrazo.setText(null);
                txtDataC.setText(null);
            }
        });

        
        btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int resposta = JOptionPane.showConfirmDialog(tela, "Sair do Sistema?");
				if (resposta == 0) {
					tela.dispose();
				}
				
			}
		});
		
		Container painel = tela.getContentPane();
		painel.add(labelTitulo);
		painel.add(txtTitulo);
		painel.add(labelDescricao);
		painel.add(txtDescricao);
		painel.add(labelDataI);
		painel.add(txtDataI);
		painel.add(labelPrazo);
		painel.add(txtPrazo);
		painel.add(labelDataC);
		painel.add(txtDataC);
		painel.add(labelStatus);
		painel.add(cmbStatus);
		painel.add(labelResponsavel);
		painel.add(cmbFuncionario);
		painel.add(btnSalvar);
		painel.add(btnSair);
		
		
		tela.setVisible(true);
		
	}

}