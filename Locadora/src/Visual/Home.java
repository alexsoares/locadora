package Visual;
import javax.swing.*;

import Banco.RegistroInexistente;

import java.awt.*;
import java.awt.event.*;
import java.util.ListIterator;

public class Home {

	private JFrame frameHome;

	public Home() {
		frameHome();
		menuBar();
		frameHome.setVisible(true);
	}

	public JFrame getFramePadrao(){
		return this.frameHome;
	}
	
	private void menuBar() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 21);
		frameHome.getContentPane().add(menuBar);
		
		JMenu menuFilmes = new JMenu("Filmes");
		JMenuItem menuFilmesCadastrar = new JMenuItem("Cadastrar");
		JMenuItem menuFilmesConsultar = new JMenuItem("Consultar");
		JMenuItem menuFilmesRemover = new JMenuItem("Remover");
		JMenuItem menuFilmesAtualizar = new JMenuItem("Atualizar");
		JMenu menoGenero = new JMenu("G\u00EAnero");
		JMenuItem menuGeneroCadastrar = new JMenuItem("Cadastrar");
		JMenuItem menuGeneroConsultar = new JMenuItem("Consultar");
		JMenuItem menuGeneroRemover = new JMenuItem("Remover");
		JMenuItem menuGeneroAtualizar = new JMenuItem("Atualizar");
		JMenu menuCliente = new JMenu("Cliente");
		JMenuItem menuClienteCadastrar = new JMenuItem("Cadastrar");
		JMenuItem menuClienteConsultar = new JMenuItem("Consultar");
		JMenuItem menuClienteRemover = new JMenuItem("Remover");
		menuClienteRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int codigoClienteRemovido;
				codigoClienteRemovido =	 Integer.parseInt(JOptionPane.showInputDialog("Favor informar o código do cliente que deseja remover:"));
				JOptionPane.showConfirmDialog(null, "Deseja realmente remover o cliente número:"+codigoClienteRemovido+"?");
				try {
					Run.Main.banco.ExcluiCliente(codigoClienteRemovido);
				} catch (RegistroInexistente e) {
					JOptionPane.showMessageDialog(null,e.getMessage(),"Registro não encontrado",JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
		});
		JMenuItem menuClienteAtualizar = new JMenuItem("Atualizar");
		
		menuBar.add(menuFilmes);
		menuFilmes.add(menuFilmesCadastrar);
		menuFilmes.add(menuFilmesConsultar);
		menuFilmes.add(menuFilmesRemover);
		menuFilmes.add(menuFilmesAtualizar);
		menuBar.add(menoGenero);
		menoGenero.add(menuGeneroCadastrar);
		menoGenero.add(menuGeneroConsultar);
		menoGenero.add(menuGeneroRemover);
		menoGenero.add(menuGeneroAtualizar);
		menuBar.add(menuCliente);
		menuCliente.add(menuClienteCadastrar);
		menuCliente.add(menuClienteConsultar);
		menuCliente.add(menuClienteRemover);
		menuCliente.add(menuClienteAtualizar);
		
		menuFilmesCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FilmeCadastrar cadastrarFilme = new FilmeCadastrar();
				frameHome.setVisible(false);			
			}
		});
		
		menuClienteCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteCadastrar cadastrarNovoCliente = new ClienteCadastrar();
				frameHome.setVisible(false);
			}			
		});
		
		menuClienteConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteConsultar consultarCliente = new ClienteConsultar();
			}
		});
	}
	
	private void frameHome() {
		frameHome = new JFrame();
		frameHome.getContentPane().setBackground(new Color(105, 105, 105));
		frameHome.getContentPane().setLayout(null);
		frameHome.setTitle("Locadora Unisal - Home");
		frameHome.setBounds(100, 100, 450, 300);
		frameHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
		
		
		
		
		
