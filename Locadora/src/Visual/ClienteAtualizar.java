package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.ListIterator;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import Banco.RegistroInexistente;
import Banco.RegistroJaExiste;
import RecursosHumanos.Cliente;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClienteAtualizar {

	private JFrame frame;
	private DefaultTableModel modeloDaTabela;
	private JTable tabelaClientesAtualizar;
	private JMenuBar menuBar = new JMenuBar();
	

	public ClienteAtualizar(){
		jFrame();
		adicionarMenuAoFrame();
		CriaTabela();
		AdiconarTabelaAoFrame();
	}
	
	public String CapturarCriterioPesquista(String criterio){
			
			if (modeloDaTabela.getRowCount() > 0){
				modeloDaTabela.removeRow(0);
			}
			String CriterioPesquisa = JOptionPane.showInputDialog(null, "Informe o " + criterio + " do cliente que terá seus dados atualizados:");
			return CriterioPesquisa;
	}
	

	
	@SuppressWarnings("serial")
	public void CriaTabela() {
		
		String[] columns = new String[]{"Código","Nome","CPF","Rua","Número","Bairro","Cidade","E-mail","Data Nascimento"};
		
		modeloDaTabela = new DefaultTableModel(null,columns);
		tabelaClientesAtualizar = new JTable(modeloDaTabela)
		{
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
		}};
		tabelaClientesAtualizar.setBackground(SystemColor.scrollbar);
		tabelaClientesAtualizar.setBounds(20,75, 380, 100);
		tabelaClientesAtualizar.setVisible(true);
		tabelaClientesAtualizar.setAutoscrolls(true);
	}

	
	private void AdiconarTabelaAoFrame() {
		frame.getContentPane().add(tabelaClientesAtualizar.getTableHeader(),BorderLayout.PAGE_START);
		frame.getContentPane().add(tabelaClientesAtualizar,BorderLayout.CENTER);
		
	}

	public void AdicionarLinhaModelo (Object a []){
		this.modeloDaTabela.addRow(a);
	}
	
	private JMenuItem menuCodigoDoCliente(){
		
		JMenuItem mntmCdigoDoCliente = new JMenuItem("Codigo do Cliente");
		mntmCdigoDoCliente.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String criterioDaPesquisa = CapturarCriterioPesquista("Codigo do Cliente").toString();
			
				if (criterioDaPesquisa != null){
					
					try{
						
						LinkedList<Cliente> clientesEncontrados = new LinkedList<Cliente>();
						clientesEncontrados.add(Run.Main.bancoCliente.Consulta(Integer.parseInt(criterioDaPesquisa)));

						ListIterator<RecursosHumanos.Cliente> iterator = clientesEncontrados.listIterator();
						
						while (iterator.hasNext()){
							
							RecursosHumanos.Cliente tempCliente = iterator.next();
							AdicionarLinhaModelo(new Object[]
									{
									tempCliente.getCodigoCliente(),
									tempCliente.getNome(),
									String.valueOf(tempCliente.getCpf()),
									tempCliente.getRua(),
									tempCliente.getNumero(),
									tempCliente.getBairro(),
									tempCliente.getCidade(),
									tempCliente.getEmail(),
									tempCliente.getDataNascimentoFormatada()
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
	
	private JMenuItem menuCPF(){
		JMenuItem mntmCpf = new JMenuItem("CPF");
		mntmCpf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String criterioDaPesquisa = CapturarCriterioPesquista("CPF").toString();
				
				if (criterioDaPesquisa != null){
					
					try{
						
						LinkedList<RecursosHumanos.Cliente> clientesEncontrados = new LinkedList<RecursosHumanos.Cliente>();
						clientesEncontrados.add(Run.Main.bancoCliente.Consulta(criterioDaPesquisa));
						
						ListIterator<RecursosHumanos.Cliente> iterator = clientesEncontrados.listIterator();
						
						while (iterator.hasNext()){
							
							RecursosHumanos.Cliente tempCliente = iterator.next();
							AdicionarLinhaModelo(new Object[]
									{
									tempCliente.getCodigoCliente(),
									tempCliente.getNome(),
									String.valueOf(tempCliente.getCpf()),
									tempCliente.getRua(),
									tempCliente.getNumero(),
									tempCliente.getBairro(),
									tempCliente.getCidade(),
									tempCliente.getEmail(),
									tempCliente.getDataNascimentoFormatada()
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
		return mntmCpf;
	}
	
	
	private JMenu menuPesquisar(){
		JMenu mnPesquisar = new JMenu("Pesquisar");
		mnPesquisar.add(menuCodigoDoCliente());
		mnPesquisar.add(menuCPF());
		return mnPesquisar;
	}
	
	private JMenuItem menuSalvar(){
		
		JMenuItem mntmSalvar = new JMenuItem("Salvar");
		mntmSalvar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				SimpleDateFormat FormatDate = new SimpleDateFormat("dd/MM/yyyy");
				
				try {
					
					RecursosHumanos.Cliente clienteAtualizar =	new RecursosHumanos.Cliente(						
							tabelaClientesAtualizar.getValueAt(0,1).toString(),//Nome 
							tabelaClientesAtualizar.getValueAt(0,2).toString(),//cpf 
							tabelaClientesAtualizar.getValueAt(0,3).toString(),//rua 
							Integer.parseInt(tabelaClientesAtualizar.getValueAt(0,4).toString()),//numero
							tabelaClientesAtualizar.getValueAt(0,5).toString(),//bairro
							tabelaClientesAtualizar.getValueAt(0,6).toString(),//cidade
							tabelaClientesAtualizar.getValueAt(0,7).toString(),//e-mail
							FormatDate.parse(tabelaClientesAtualizar.getValueAt(0,8).toString()));
					
					clienteAtualizar.setCodigoCliente(Integer.parseInt(tabelaClientesAtualizar.getValueAt(0, 0).toString()));
					
					Run.Main.bancoCliente.Altera(clienteAtualizar);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, e1);
				} catch (ParseException e1) {
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
