package Visual;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import Banco.RegistroInexistente;
import Banco.RegistroJaExiste;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FilmeConsultar {

	private JFrame frame;
	private JMenuBar menuBar = new JMenuBar();
	private JTable table;
	private DefaultTableModel modelo;
	
	public FilmeConsultar() {
		initialize();
		menuConsulta();
		frame.setJMenuBar(menuBar);
		menuBar.add(menuConsulta());
		menuBar.add(menuEditar());
		criaModeloTabela();
		
	}
	
	private void adicionarLinhaModelo (Object a []){
		this.modelo.addRow(a);
	}

	@SuppressWarnings("serial")
	private void criaModeloTabela(){
		String[] columns = new String[]{"Indice","Nome","Preco", "Data Lancamento", "Faixa Etaria", "Genero", "Sinopse"};
		
		modelo = new DefaultTableModel(null,columns);
		table = new JTable(modelo){boolean[] columnEditables = new boolean[] 
					{false,true, true, true, false, true};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
		}};
		table.setBounds(20,75, 380, 100);
		
		frame.getContentPane().add(table.getTableHeader(),BorderLayout.PAGE_START);
		frame.getContentPane().add(table,BorderLayout.CENTER);
	}
	
	private void AdicionaLinhasTabela(Locavel.Filme filme){
		SimpleDateFormat FormatDate = new SimpleDateFormat("dd/MM/yyyy");
		Run.Main.bancoGenero.RetornaLinkedList().toString();
		
		adicionarLinhaModelo(new Object[]{
				filme.getIndice(),
				filme.getNome(),
				filme.getPreco(),
				FormatDate.format(filme.getDataLancamento()),
				filme.getFaixaEtaria(),
				filme.getGenero().getNome(),
				filme.getSinopse()
		});
	}
	
	private void getFilme(String nomeFilme) throws RegistroInexistente{
		Locavel.Filme filmeConsultado =	Run.Main.bancoFilme.Consulta(nomeFilme);
		AdicionaLinhasTabela(filmeConsultado);
	}
	
	private void getFilme(int codigoFilme) throws RegistroInexistente{
		Locavel.Filme filmeConsultado = Run.Main.bancoFilme.Consulta(codigoFilme);
		AdicionaLinhasTabela(filmeConsultado);
	}
	
	private void atualizarFilme(Locavel.Filme filme) throws RegistroInexistente, RegistroJaExiste{
		Run.Main.bancoFilme.Altera(filme);
	}
	
	private JMenuItem itensMenuEditar(String nomeDoItem){
		JMenuItem  itemDoMenu = new JMenuItem(nomeDoItem);
		
		itemDoMenu.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				if(e.getActionCommand().equals("Salvar")){
					
					SimpleDateFormat FormatDate = new SimpleDateFormat("dd/MM/yyyy");
					
					for(int i = 0; i<= table.getRowCount();i++){
						try {
							Locavel.Filme filme = new Locavel.Filme( 
							table.getValueAt(i, 1).toString(), //nome
							Double.parseDouble(table.getValueAt(i, 2).toString()), //preco
							FormatDate.parse((String) table.getValueAt(i, 3)), //Data lancamento
							Integer.parseInt(table.getValueAt(i, 4).toString()), //faixa etaria
							table.getValueAt(i, 6).toString(), //Sinopse
							Run.Main.bancoGenero.Consulta(table.getValueAt(i,5).toString()));
							
							Run.Main.bancoFilme.Altera(filme);
							
						} catch (NumberFormatException | ParseException| RegistroInexistente e1) {
							JOptionPane.showMessageDialog(null,e1.toString());
						} catch (RegistroJaExiste e1) {
							JOptionPane.showMessageDialog(null,e1.toString());
						}
					}
				}
			}
		});
		return itemDoMenu;
	}
	
	private JMenuItem itensMenuConsulta(String nomeDoItem){
		
		JMenuItem  itemDoMenu = new JMenuItem(nomeDoItem);
		itemDoMenu.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent e){
				
				if(e.getActionCommand().equals("Por Codigo")){
					try {
						getFilme(Integer.parseInt(JOptionPane.showInputDialog("Informe o codigo do Filme:")));
					} catch (NumberFormatException | HeadlessException| RegistroInexistente e1) {
						JOptionPane.showMessageDialog(null,e1.toString());
					}
				}
					
				if(e.getActionCommand().equals("Por Nome")){
					 try {
						getFilme(JOptionPane.showInputDialog("Informe o nome do Filme:"));
					} catch (HeadlessException | RegistroInexistente e1) {
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
		menuEditar.add(itensMenuEditar("Salvar"));
		menuEditar.add(itensMenuEditar("Salvar e Sair"));
		menuEditar.add(itensMenuEditar("Sair"));
		return menuEditar;
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setBounds(100, 100, 800, 157);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("Locadora Unisal - Gestao de Filmes");
		
	}
}
