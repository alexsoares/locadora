package Visual;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import Banco.RegistroInexistente;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FilmeConsultar {

	private JFrame frame;
	private JMenuBar menuBar = new JMenuBar();
	private JTable table;
	
	public FilmeConsultar() {
		initialize();
		menuConsulta();
		frame.setJMenuBar(menuBar);
		menuBar.add(menuConsulta());
		menuBar.add(menuEditar());
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Data Lancamento", "Faixa Etaria", "Genero", "Sinopse"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(97);
		table.setBounds(10, 11, 414, 104);
		frame.getContentPane().add(table.getTableHeader(),BorderLayout.PAGE_START);
		frame.getContentPane().add(table,BorderLayout.CENTER);
	}
	
	
	private JMenuItem itensMenuEditar(String nomeDoItem){
		JMenuItem  itemDoMenu = new JMenuItem(nomeDoItem);
		
		itemDoMenu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
		return itemDoMenu;
	}
	
	private JMenuItem itensMenuConsulta(String nomeDoItem){
		
		JMenuItem  itemDoMenu = new JMenuItem(nomeDoItem);
		itemDoMenu.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent e){
				Banco.BancoFilme consultarFilme = new Banco.BancoFilme();
				
				if(e.getActionCommand().equals("Por Codigo")){
					
					int codigoFilme = Integer.parseInt(JOptionPane.showInputDialog("Informe o codigo do Filme:"));

					try {
						
						Locavel.Filme filmeConsultado = consultarFilme.Consulta(codigoFilme);
						JOptionPane.showMessageDialog(null,filmeConsultado.getNome());
						
					} catch (RegistroInexistente e1) {
						JOptionPane.showMessageDialog(null,e1.toString());
					}
					
				}
				if(e.getActionCommand().equals("Por Nome")){
					
					String nomeFilme = JOptionPane.showInputDialog("Informe o nome do Filme:");
					
					try {
						
						Locavel.Filme filmeConsultado = consultarFilme.Consulta(nomeFilme);
						JOptionPane.showMessageDialog(null, filmeConsultado.getNome());
						
					} catch (RegistroInexistente e2) {
						JOptionPane.showMessageDialog(null,e2.toString());
					}
					
					try {
						
						Locavel.Filme filmeConsultado = consultarFilme.Consulta(nomeFilme);
						JOptionPane.showMessageDialog(null,filmeConsultado.getNome());
					} catch (RegistroInexistente e1) {
						JOptionPane.showMessageDialog(null,e1.toString());
					}
					
				}
			}
		});
		return itemDoMenu;
	}
	
	private JMenu menuConsulta(){
		JMenu menuConsultar = new JMenu("Consultar");
		 menuConsultar.add(itensMenuConsulta("Por Codigo"));
		 menuConsultar.add(itensMenuConsulta("Por Nome"));
		 return menuConsultar;
	}
	
	private JMenu menuEditar(){
		JMenu menuEditar = new JMenu("Editar");
		menuEditar.add(itensMenuEditar("Remover"));
		menuEditar.add(itensMenuEditar("Salvar e Sair"));
		menuEditar.add(itensMenuEditar("Sair"));
		return menuEditar;
	}
	

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("Locadora Unisal - Gestao de Filmes");
		
	}
}
