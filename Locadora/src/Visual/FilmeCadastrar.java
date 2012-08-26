package Visual;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FilmeCadastrar {

	private JFrame frmLocadoraUnisal;
	private JTextField txNomeFilme;
	private JTextField txFaixaEtaria;

	public FilmeCadastrar() {
		initialize();
	}

	private void initialize() {
		frmLocadoraUnisal = new JFrame();
		frmLocadoraUnisal.getContentPane().setBackground(new Color(105, 105, 105));
		frmLocadoraUnisal.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 21);
		frmLocadoraUnisal.getContentPane().add(menuBar);
		
		JMenu menuFilmes = new JMenu("Filmes");
		menuBar.add(menuFilmes);
		
		JMenuItem menuFilmesCadastrar = new JMenuItem("Cadastrar");
		menuFilmes.add(menuFilmesCadastrar);
		
		JMenuItem menuFilmesConsultar = new JMenuItem("Consultar");
		menuFilmes.add(menuFilmesConsultar);
		
		JMenuItem menuFilmesRemover = new JMenuItem("Remover");
		menuFilmes.add(menuFilmesRemover);
		
		JMenuItem menuFilmesAtualizar = new JMenuItem("Atualizar");
		menuFilmes.add(menuFilmesAtualizar);
		
		JMenu menoGenero = new JMenu("G\u00EAnero");
		menuBar.add(menoGenero);
		
		JMenuItem menuGeneroCadastrar = new JMenuItem("Cadastrar");
		menoGenero.add(menuGeneroCadastrar);
		
		JMenuItem menuGeneroConsultar = new JMenuItem("Consultar");
		menoGenero.add(menuGeneroConsultar);
		
		JMenuItem menuGeneroRemover = new JMenuItem("Remover");
		menoGenero.add(menuGeneroRemover);
		
		JMenuItem menuGeneroAtualizar = new JMenuItem("Atualizar");
		menoGenero.add(menuGeneroAtualizar);
		
		JMenu menuCliente = new JMenu("Cliente");
		menuBar.add(menuCliente);
		
		JMenuItem menuClienteCadastrar = new JMenuItem("Cadastrar");
		menuCliente.add(menuClienteCadastrar);
		
		JMenuItem menuClienteConsultar = new JMenuItem("Consultar");
		menuCliente.add(menuClienteConsultar);
		
		JMenuItem menuClienteRemover = new JMenuItem("Remover");
		menuCliente.add(menuClienteRemover);
		
		JMenuItem menuClienteAtualizar = new JMenuItem("Atualizar");
		menuCliente.add(menuClienteAtualizar);
		
		JLabel lbNomeFilme = new JLabel("Nome:");
		lbNomeFilme.setForeground(new Color(255, 255, 255));
		lbNomeFilme.setBackground(new Color(255, 255, 255));
		lbNomeFilme.setBounds(90, 90, 59, 14);
		frmLocadoraUnisal.getContentPane().add(lbNomeFilme);
		
		JLabel lbGenero = new JLabel("Genero:");
		lbGenero.setForeground(new Color(255, 255, 255));
		lbGenero.setBounds(90, 124, 46, 14);
		frmLocadoraUnisal.getContentPane().add(lbGenero);
		
		JLabel lblFaixaEtria = new JLabel("Faixa Et\u00E1ria:");
		lblFaixaEtria.setForeground(new Color(255, 255, 255));
		lblFaixaEtria.setBounds(90, 149, 83, 21);
		frmLocadoraUnisal.getContentPane().add(lblFaixaEtria);
		
		txNomeFilme = new JTextField();
		txNomeFilme.setBounds(177, 87, 187, 20);
		frmLocadoraUnisal.getContentPane().add(txNomeFilme);
		txNomeFilme.setColumns(10);
		
		JComboBox cbGenero = new JComboBox();
		cbGenero.setBounds(177, 121, 187, 20);
		frmLocadoraUnisal.getContentPane().add(cbGenero);
		
		txFaixaEtaria = new JTextField();
		txFaixaEtaria.setBounds(177, 149, 59, 20);
		frmLocadoraUnisal.getContentPane().add(txFaixaEtaria);
		txFaixaEtaria.setColumns(10);
		
		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.setBounds(296, 217, 97, 23);
		frmLocadoraUnisal.getContentPane().add(btCadastrar);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Home inicial = new Home();
				frmLocadoraUnisal.setVisible(false);
			}
		});
		btCancelar.setBounds(197, 217, 89, 23);
		frmLocadoraUnisal.getContentPane().add(btCancelar);
		
		JLabel lbCadastrarFilme = new JLabel("Cadastrar Filme");
		lbCadastrarFilme.setHorizontalAlignment(SwingConstants.CENTER);
		lbCadastrarFilme.setForeground(new Color(255, 255, 255));
		lbCadastrarFilme.setFont(new Font("Calibri", Font.BOLD, 17));
		lbCadastrarFilme.setBounds(0, 46, 434, 21);
		frmLocadoraUnisal.getContentPane().add(lbCadastrarFilme);
		
		JLabel lblAnos = new JLabel("anos");
		lblAnos.setForeground(new Color(255, 255, 255));
		lblAnos.setBounds(246, 152, 46, 14);
		frmLocadoraUnisal.getContentPane().add(lblAnos);
		frmLocadoraUnisal.setTitle("Locadora Unisal");
		frmLocadoraUnisal.setBounds(100, 100, 450, 300);
		frmLocadoraUnisal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLocadoraUnisal.setVisible(true);
	}
}
