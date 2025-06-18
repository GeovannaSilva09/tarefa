package br.dev.geovanna.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.text.MaskFormatter;

import br.dev.geovanna.tarefas.dao.FuncionarioDAO;
import br.dev.geovanna.tarefas.model.Funcionario;
import br.dev.geovanna.tarefas.model.Status;
import br.dev.geovanna.tarefas.model.Tarefa;

public class TarefasFrame {
	
	private JLabel labelTituloTarefa;
	private JTextField txtTituloTarefa;
	
	private JLabel labelDescricao;
	private JTextField txtDescricao;
	
	private JLabel labelDataInicio;
	private JTextField txtDataInicio;
	
	private JLabel labelPrazo;
	private JTextField txtPrazo;
	
	private JLabel labelStatus;
	
	private JLabel labelDataConclusao;
	private JTextField txtDataConclusao;
	
	private JLabel labelResponsavel;
	
	private JButton btnSalvar;
	private JButton btnSair;
	
	
	MaskFormatter mascaraData = null;
	

    public TarefasFrame(JDialog parent) {
        criarTela(parent);
    }

    private void criarTela(JDialog parent) {
    	
    	try {
    		mascaraData = new MaskFormatter("##/##/####");
    		mascaraData.setPlaceholderCharacter('_');
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	
        JDialog tela = new JDialog(parent, true);
        tela.setSize(300, 700);
        tela.setTitle("Tarefas");
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tela.setResizable(false);
        tela.setLayout(null);
        tela.setLocationRelativeTo(null);

        JLabel labelTituloTarefa = new JLabel("Título");
        labelTituloTarefa.setBounds(10, 15, 200, 30);

        JTextField txtTituloTarefa = new JTextField();
        txtTituloTarefa.setBounds(10, 50, 280, 30);

        JLabel labelDescricao = new JLabel("Descrição");
        labelDescricao.setBounds(10, 90, 200, 30);

        JTextField txtDescricao = new JTextField();
        txtDescricao.setBounds(10, 125, 280, 30);

        JLabel labelDataInicio = new JLabel("Data inicial");
        labelDataInicio.setBounds(10, 230, 200, 30);

        JFormattedTextField txtDataInicio = new JFormattedTextField();
        labelDataInicio.setBounds(10, 260, 280, 30);

        JLabel labelPrazo = new JLabel("Prazo");
        labelPrazo.setBounds(10, 295, 200, 30);

        JFormattedTextField txtPrazo = new JFormattedTextField();
        txtPrazo.setBounds(10, 330, 260, 30);

        JLabel labelStatus = new JLabel("Status:");
        labelStatus.setBounds(10, 435, 55, 30);

        JComboBox<Status> cbStatus = new JComboBox<>(Status.values());
        cbStatus.setBounds(70, 435, 150, 30);
        
        JLabel labelDataConclusao = new JLabel("Data de Conclusão");
        labelDataConclusao.setBounds(10, 470, 200, 30);
        
        JTextField txtDataConclusao = new JTextField();
        txtDataConclusao.setBounds(10, 505, 260, 30);
     
        JLabel labelResponsavel = new JLabel("Responsável");
        labelResponsavel.setBounds(10, 165, 150, 30);

        JComboBox<String> cbFuncionarios = new JComboBox<>(carregarMatricula());
        cbFuncionarios.setBounds(10, 200, 260, 30);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(10, 550, 135, 40);

        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(150, 550, 135, 40);

        Container painel = tela.getContentPane();
        painel.add(labelTituloTarefa);
        painel.add(txtTituloTarefa);
        painel.add(labelDescricao);
        painel.add(txtDescricao);
        painel.add(labelResponsavel);
        painel.add(cbFuncionarios);
        painel.add(labelDataInicio);
        painel.add(txtDataInicio);
        painel.add(labelPrazo);
        painel.add(txtPrazo);
        painel.add(labelStatus);
        painel.add(cbStatus);
        painel.add(labelDataConclusao);
        painel.add(txtDataConclusao);  
        painel.add(btnSalvar);
        painel.add(btnSair);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tarefa t = new Tarefa();
                t.setNome(txtTituloTarefa.getText());
                t.setDescricao(txtDescricao.getText());
                t.setDataEntrega(txtDataConclusao.getText());
               
                JOptionPane.showMessageDialog(tela, "Tarefa salva!");
                tela.dispose();
            }
        });

        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resposta = JOptionPane.showConfirmDialog(tela, "Sair do sistema?");
                if (resposta == JOptionPane.YES_OPTION) {
                    tela.dispose();
                }
            }
        });

        tela.setVisible(true);
    }

    

    private Vector<String> carregarMatricula() {
        FuncionarioDAO dao = new FuncionarioDAO(null);
        List<Funcionario> funcionarios = dao.getFuncionarios();

        Vector<String> matriculas = new Vector<>();

        for (Funcionario f : funcionarios) {
            matriculas.add( "Nome: " + f.getNome() + "  | " + " Matricula: " + f.getMatricula());
        }
        return matriculas;
    }
    
    
    
    
    
}