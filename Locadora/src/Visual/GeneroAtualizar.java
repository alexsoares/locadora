package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.ListIterator;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Banco.RegistroInexistente;
import Banco.RegistroJaExiste;
import Locavel.Genero;
import RecursosHumanos.Cliente;

@SuppressWarnings("unused")
public class GeneroAtualizar extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private DefaultTableModel modeloDaTabela;
	private JTable tabelaGenerosAtualizar;
	private JMenuBar menuBar = new JMenuBar();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneroAtualizar frame = new GeneroAtualizar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GeneroAtualizar() {
		jFrame();
		adicionarMenuAoFrame();
		CriaTabela();
		AdiconarTabelaAoFrame();
	}
	public String CapturarCriterioPesquista(String criterio){
		
		if (modeloDaTabela.getRowCount() > 0){
			modeloDaTabela.removeRow(0);
		}
		String CriterioPesquisa = JOptionPane.showInputDialog(null, "Informe o " + criterio + " do genero que terá seus dados atualizados:");
		return CriterioPesquisa;
}



@SuppressWarnings("serial")
public void CriaTabela() {
	
	String[] columns = new String[]{"Código","Nome","Descriçao"};
	
	modeloDaTabela = new DefaultTableModel(null,columns);
	tabelaGenerosAtualizar = new JTable(modeloDaTabela)
	{
		boolean[] columnEditables = new boolean[] {
			false, true, true
		};
		public boolean isCellEditable(int row, int column) {
			return columnEditables[column];
	}};
	tabelaGenerosAtualizar.setBackground(SystemColor.scrollbar);
	tabelaGenerosAtualizar.setBounds(20,75, 380, 100);
	tabelaGenerosAtualizar.setVisible(true);
	tabelaGenerosAtualizar.setAutoscrolls(true);
}


private void AdiconarTabelaAoFrame() {
	frame.getContentPane().add(tabelaGenerosAtualizar.getTableHeader(),BorderLayout.PAGE_START);
	frame.getContentPane().add(tabelaGenerosAtualizar,BorderLayout.CENTER);
	
}

public void AdicionarLinhaModelo (Object a []){
	this.modeloDaTabela.addRow(a);
}

private JMenuItem menuCodigoDoGenero(){
	
	JMenuItem mntmCdigoDoCliente = new JMenuItem("C\u00F3digo do Gênero");
	mntmCdigoDoCliente.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			
			String criterioDaPesquisa = CapturarCriterioPesquista("Código do Gênero").toString();
		
			if (criterioDaPesquisa != null){
				
				try{
					
					LinkedList<Genero> generosEncontrados = new LinkedList<Genero>();
					generosEncontrados.add(Run.Main.bancoGenero.Consulta(Integer.parseInt(criterioDaPesquisa)));

					ListIterator<Locavel.Genero> iterator = generosEncontrados.listIterator();
					
					while (iterator.hasNext()){
						
						Locavel.Genero tempGenero = iterator.next();
						AdicionarLinhaModelo(new Object[]
								{
								tempGenero.getIndice(),
								tempGenero.getNome(),
								tempGenero.getDescricao(),
								}
						);
					}
				}
				catch (Exception e1){
					JOptionPane.showMessageDialog(null,e1.getMessage(),"Valor não esperado.",JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
	});
	return mntmCdigoDoCliente;
}


private void adicionarMenuAoFrame(){
	
	JMenu mnEditar = new JMenu("Editar");
	
	menuBar.add(mnEditar);
	mnEditar.add(menuSalvar());
	mnEditar.add(menuSair());
	menuBar.add(menuPesquisar());
}

private JMenuItem menuDescricao(){
	JMenuItem mntmDescricao = new JMenuItem("Descrição");
	mntmDescricao.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			String criterioDaPesquisa = CapturarCriterioPesquista("Descrição").toString();
			
			if (criterioDaPesquisa != null){
				
				try{
					
					LinkedList<Locavel.Genero> generosEncontrados = new LinkedList<Locavel.Genero>();
					generosEncontrados.add(Run.Main.bancoGenero.Consulta(criterioDaPesquisa));
					
					ListIterator<Locavel.Genero> iterator = generosEncontrados.listIterator();
					
					while (iterator.hasNext()){
						
						Locavel.Genero tempGenero = iterator.next();
						AdicionarLinhaModelo(new Object[]
								{
								tempGenero.getIndice(),
								tempGenero.getNome(),
								tempGenero.getDescricao()
								}
						);
					}
				}
				catch (Exception e1){
					JOptionPane.showMessageDialog(null,e1.getMessage(),"Valor não esperado.",JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
	});
	return mntmDescricao;
}


private JMenu menuPesquisar(){
	JMenu mnPesquisar = new JMenu("Pesquisar");
	mnPesquisar.add(menuCodigoDoGenero());
	mnPesquisar.add(menuDescricao());
	return mnPesquisar;
}

private JMenuItem menuSalvar(){
	
	JMenuItem mntmSalvar = new JMenuItem("Salvar");
	mntmSalvar.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
	
			
			Locavel.Genero generoAtualizar =
					new Locavel.Genero(
					tabelaGenerosAtualizar.getValueAt(0, 1).toString(),//Nome
					tabelaGenerosAtualizar.getValueAt(0,2).toString());//descricao
			generoAtualizar.setIndice(Integer.parseInt(tabelaGenerosAtualizar.getValueAt(0, 0).toString()));
			
			try {
				//generoAtualizar.setIndice(Integer.parseInt(tabelaGenerosAtualizar.getValueAt(0, 0).toString()));
				Run.Main.bancoGenero.Altera(generoAtualizar);
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, e1);
			} catch (RegistroInexistente e1) {
				JOptionPane.showMessageDialog(null, e1);
			} catch (RegistroJaExiste e1) {
				JOptionPane.showMessageDialog(null, e1);
			}
			}
		}
	);
	return mntmSalvar;
	
	/*
	 * 			Locavel.Genero generoAtualizar = null;
			try {
				generoAtualizar = Run.Main.bancoGenero.Consulta( Integer.parseInt(tabelaGenerosAtualizar.getValueAt(0, 0).toString()) );
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(null, e2);
			} catch (RegistroInexistente e2) {
				JOptionPane.showMessageDialog(null, e2);
			}
			
			generoAtualizar.setNome(tabelaGenerosAtualizar.getValueAt(0, 1).toString());
			generoAtualizar.setDescricao(tabelaGenerosAtualizar.getValueAt(0, 2).toString());
			*/
}

private JMenuItem menuSair(){
	
	JMenuItem mntmSair = new JMenuItem("Sair");

	mntmSair.addActionListener(new ActionListener() {
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent arg0) {
			frame.hide();
		}
	});
	return mntmSair;
}


private void jFrame() {
	
	frame = new JFrame();
	frame.getContentPane().setLayout(new BorderLayout());
	frame.setResizable(false);
	frame.setBounds(100, 100, 800, 107);
	frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	frame.setTitle("Locadora Unisal - Atualizar Cadastro");
	frame.setVisible(true);
	frame.setBackground(new Color(105, 105, 105));
	frame.setJMenuBar(menuBar);
		
}


}
