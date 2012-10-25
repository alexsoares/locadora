package Visual;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import Banco.RegistroInexistente;
import Locavel.Genero;

public class Home {
	
	private JFrame 	 frameHome;

	private JMenuBar menuBar(){
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 450, 21);
		menuBar.add(menuFilmes());
		menuBar.add(menuGenero());
		menuBar.add(menuCliente());
		menuBar.add(menuMidia());
		menuBar.add(menuItem());
		return menuBar;		
	}
	
	private JMenuItem instanciaItemDoMenuFilme(String nomeDoItem){
		JMenuItem  itemDoMenu = new JMenuItem(nomeDoItem);
		itemDoMenu.addActionListener(new ActionListener(){
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e){
				if(e.getActionCommand().equals("Cadastrar")){
					FilmeCadastrar cadastrarNovoFilme = new FilmeCadastrar();
					cadastrarNovoFilme.setVisible(true);
				}
				if(e.getActionCommand().equals("Consultar e Editar")){
					
					FilmeConsultar consultarFilme = new FilmeConsultar(); 
				}
			}
		});
		return itemDoMenu;
	}
	
	private JMenuItem instanciaItemDoMenuCliente(String nomeDoItem){
		JMenuItem  itemDoMenu = new JMenuItem(nomeDoItem);
		itemDoMenu.addActionListener(new ActionListener(){
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e){
				
				if (e.getActionCommand().equals("Cadastrar")){
					ClienteCadastrar cadastrarNovoCliente = new ClienteCadastrar();
					frameHome.setVisible(false);
				}
				
				if(e.getActionCommand().equals("Consultar")){
					ClienteConsultar consultarCliente = new ClienteConsultar();
				}
				
				if(e.getActionCommand().equals("Atualizar")){
					ClienteAtualizar atualizarCliente = new ClienteAtualizar();
				}
				
				if(e.getActionCommand().equals("Remover")){
					int codigoClienteRemovido = 0;
					
					String validaDado =JOptionPane.showInputDialog("Favor informar o codigo do cliente que deseja remover:");
					
					if(validaDado ==null){
						JOptionPane.showMessageDialog(null,"Operacao Cancelada.");
					}
					else
					{
						codigoClienteRemovido =Integer.parseInt(validaDado);
						try {
							if (JOptionPane.showConfirmDialog(null, "Deseja realmente remover o cliente numero: "+codigoClienteRemovido+"?") == 0){
								Run.Main.bancoCliente.Exclui(codigoClienteRemovido);
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Operacao Cancelada.");
							}
						} catch (RegistroInexistente e1) {
							JOptionPane.showMessageDialog(null,e1.getMessage(),"Valor nao esperado",JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						}
					}
				}
			}
		});
		return itemDoMenu;
	}
	
	private JMenuItem instanciaItemDoMenuGenero(String nomeDoItem){
		JMenuItem  itemDoMenu = new JMenuItem(nomeDoItem);
		itemDoMenu.addActionListener(new ActionListener(){
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e){
				if(e.getActionCommand().equals("Cadastrar")){
					GeneroCadastrar cadastrarNovoGenero = new GeneroCadastrar();
					frameHome.setVisible(false);
				}
				if(e.getActionCommand().equals("Atualizar")){
					GeneroAtualizar atualizarGenero = new GeneroAtualizar();
				}
				if(e.getActionCommand().equals("Consultar")){
					GeneroConsultar consultarGenero = new GeneroConsultar();
					//consultarGenero.setVisible(true);
				}
				
				if(e.getActionCommand().equals("Remover")){
					int codigoGeneroRemovido = 0;
					
					//String validaDado =JOptionPane.showInputDialog("Favor informar o codigo do genero que deseja remover:");
					String validaDado = CapturarCriterioPesquista("Descrição").toString();
					if(validaDado ==null){
						JOptionPane.showMessageDialog(null,"Operacao Cancelada.");
					}
					else
					{
						try {
							Genero generoEncontrado = Run.Main.bancoGenero.Consulta((validaDado));
							codigoGeneroRemovido = generoEncontrado.getIndice();
							
						} catch (RegistroInexistente e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						
						try {
							if (JOptionPane.showConfirmDialog(null, "Deseja realmente remover o genero numero: "+codigoGeneroRemovido+"?") == 0){
								Run.Main.bancoGenero.Exclui(codigoGeneroRemovido);
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Operacao Cancelada.");
							}
						} catch (RegistroInexistente e1) {
							JOptionPane.showMessageDialog(null,e1.getMessage(),"Valor nao esperado",JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						}
					}
				}
			}
		});
		return itemDoMenu;
	}
	
	// Comeca Aqui
	
	private JMenuItem instanciaItemDoMenuMidia(String nomeDoItem){
		JMenuItem  itemDoMenu = new JMenuItem(nomeDoItem);
		itemDoMenu.addActionListener(new ActionListener(){
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e){
				if(e.getActionCommand().equals("Cadastrar")){
					MidiaCadastrar cadastrarNovaMidia = new MidiaCadastrar();
					frameHome.setVisible(true);
				}
				if(e.getActionCommand().equals("Atualizar")){
					GeneroAtualizar atualizarGenero = new GeneroAtualizar();
				}
				if(e.getActionCommand().equals("Consultar")){
					GeneroConsultar consultarGenero = new GeneroConsultar();
					//consultarGenero.setVisible(true);
				}
				
				if(e.getActionCommand().equals("Remover")){
					int codigoGeneroRemovido = 0;
					
					//String validaDado =JOptionPane.showInputDialog("Favor informar o codigo do genero que deseja remover:");
					String validaDado = CapturarCriterioPesquista("Descrição").toString();
					if(validaDado ==null){
						JOptionPane.showMessageDialog(null,"Operacao Cancelada.");
					}
					else
					{
						try {
							Genero generoEncontrado = Run.Main.bancoGenero.Consulta((validaDado));
							codigoGeneroRemovido = generoEncontrado.getIndice();
							
						} catch (RegistroInexistente e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						
						try {
							if (JOptionPane.showConfirmDialog(null, "Deseja realmente remover o genero numero: "+codigoGeneroRemovido+"?") == 0){
								Run.Main.bancoGenero.Exclui(codigoGeneroRemovido);
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Operacao Cancelada.");
							}
						} catch (RegistroInexistente e1) {
							JOptionPane.showMessageDialog(null,e1.getMessage(),"Valor nao esperado",JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						}
					}
				}
			}
		});
		return itemDoMenu;
	}
	
	// Fim aqui

	// Item Comeca Aqui
	
	private JMenuItem instanciaItemDoMenuItem(String nomeDoItem){
		JMenuItem  itemDoMenu = new JMenuItem(nomeDoItem);
		itemDoMenu.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				if(e.getActionCommand().equals("Cadastrar")){
					ItemCadastrar cadastrarNovoItem = new ItemCadastrar();
					frameHome.setVisible(false);
				}
				if(e.getActionCommand().equals("Atualizar")){
					//GeneroAtualizar atualizarGenero = new GeneroAtualizar();
				}
				if(e.getActionCommand().equals("Consultar")){
					//GeneroConsultar consultarGenero = new GeneroConsultar();
					//consultarGenero.setVisible(true);
				}
				
				if(e.getActionCommand().equals("Remover")){
				}
			}
		});
		return itemDoMenu;
	}
	
	// Fim aqui
	
	private JMenu menuCliente(){
		JMenu menuCliente = new JMenu("Cliente");
		menuCliente.add(instanciaItemDoMenuCliente("Cadastrar"));
		menuCliente.add(instanciaItemDoMenuCliente("Consultar"));
		menuCliente.add(instanciaItemDoMenuCliente("Remover"));
		menuCliente.add(instanciaItemDoMenuCliente("Atualizar"));
		return menuCliente;
	}
	
	private JMenu menuGenero(){
		JMenu menuGenero = new JMenu("Genero");
		menuGenero.add(instanciaItemDoMenuGenero("Cadastrar"));
		menuGenero.add(instanciaItemDoMenuGenero("Consultar"));
		menuGenero.add(instanciaItemDoMenuGenero("Remover"));
		menuGenero.add(instanciaItemDoMenuGenero("Atualizar"));
		return menuGenero;
		
	}
	
	private JMenu menuMidia(){
		JMenu menuMidia = new JMenu("Midia");
		menuMidia.add(instanciaItemDoMenuMidia("Cadastrar"));
		menuMidia.add(instanciaItemDoMenuMidia("Consultar"));
		menuMidia.add(instanciaItemDoMenuMidia("Remover"));
		menuMidia.add(instanciaItemDoMenuMidia("Atualizar"));
		return menuMidia;
		
	}
	
	
	private JMenu menuFilmes(){
		JMenu menuFilmes = new JMenu("Filmes");
		menuFilmes.add(instanciaItemDoMenuFilme("Cadastrar"));
		menuFilmes.add(instanciaItemDoMenuFilme("Consultar e Editar"));
		return menuFilmes;
	}
	
	private JMenu menuItem(){
		JMenu menuItem = new JMenu("Item");
		menuItem.add(instanciaItemDoMenuItem("Cadastrar"));
		menuItem.add(instanciaItemDoMenuItem("Consultar"));
		menuItem.add(instanciaItemDoMenuItem("Remover"));
		menuItem.add(instanciaItemDoMenuItem("Atualizar"));
		return menuItem;
		
	}
	
	
	public Home() {
		frameHome();
		frameHome.getContentPane().add(menuBar());
		frameHome.setVisible(true);
	}
	public String CapturarCriterioPesquista(String criterio){
		String CriterioPesquisa = JOptionPane.showInputDialog(null, "Informe a " + criterio + " do genero que terá seus dados excluídos:");
		return CriterioPesquisa;
}

	public JFrame getFramePadrao(){
		return this.frameHome;
	}
	
	private void frameHome() {
		frameHome = new JFrame();
		frameHome.getContentPane().setBackground(new Color(105, 105, 105));
		frameHome.getContentPane().setLayout(null);
		frameHome.setTitle("Locadora Unisal - Bem vindo");
		frameHome.setBounds(100, 100, 450, 300);
		frameHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frameHome.setResizable(false);
	}
}
