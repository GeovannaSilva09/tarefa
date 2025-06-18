package br.dev.geovanna.tarefas.ui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.dev.geovanna.tarefas.model.Tarefa;

public class TarefasListaFrame {
	
	private JLabel titulo;
    private JButton btnNovaTarefa;
    private JButton btnFechar;

    private JTable tabela;
    private DefaultTableModel modeloTabela;
    private JScrollPane painelRolagem;


    private String[] colunasTabela = {"Código",  "Nome", "Responsável"};

    
    
    
    public TarefasListaFrame(JFrame parent) {
        criarTela(parent);
    }

    private void criarTela(JFrame parent) {
        JDialog tela = new JDialog(parent, true);
        tela.setSize(600, 500);
        tela.setTitle("Lista de Tarefas");
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // DISPOSE_ON_CLOSE fecha apenas a janela selecionada
        tela.setResizable(false);
        tela.setLayout(null);
        tela.setLocationRelativeTo(null);
        
        
     
        titulo = new JLabel("Tarefas");
        titulo.setFont(new Font("Serif", Font.BOLD, 28));
        titulo.setBounds(10, 10, 400, 40);

      
        modeloTabela = new DefaultTableModel(colunasTabela, 0);
        tabela = new JTable(modeloTabela);
        painelRolagem = new JScrollPane(tabela);
        painelRolagem.setBounds(10, 60, 580, 340);

    
        btnNovaTarefa = new JButton("Nova tarefa");
        btnNovaTarefa.setBounds(10, 410, 150, 40);

        btnFechar = new JButton("Fechar");
        btnFechar.setBounds(200, 410, 150, 40);
        
     
        btnNovaTarefa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TarefasFrame(tela);
			}
		});		
        
        
        
        btnFechar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(tela, "Sair da lista de tarefas?");
				if(resposta == JOptionPane.YES_OPTION) {
					tela.dispose();
				}
						
				
			}
		});
        
        
        Container painel = tela.getContentPane();
        painel.add(titulo);
        painel.add(painelRolagem);
        painel.add(btnNovaTarefa);
        painel.add(btnFechar);
        
        tela.setVisible(true);
     

        
    }
}
