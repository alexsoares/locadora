package Visual;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;


public class FilmeCadastrar extends Home{

	private JFrame frameFilmeCadastrar;
	private JTextField txNomeFilme;
	private JTextField txFaixaEtaria;

	public FilmeCadastrar() {
		initialize();
	}

	private void frameClienteCadastrar(){
		
		frameFilmeCadastrar = new JFrame();
		frameFilmeCadastrar = getFramePadrao();
		frameFilmeCadastrar.setTitle("Locadora Unisal - Cadastrar Novo Cliente");
		frameFilmeCadastrar.setBounds(100, 100, 450, 300);
		frameFilmeCadastrar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameFilmeCadastrar.setVisible(true);
	}
	private void initialize() {
		frameClienteCadastrar();
		
		JLabel lbNomeFilme = new JLabel("Nome:");
		lbNomeFilme.setForeground(new Color(255, 255, 255));
		lbNomeFilme.setBackground(new Color(255, 255, 255));
		lbNomeFilme.setBounds(90, 90, 59, 14);
		frameFilmeCadastrar.getContentPane().add(lbNomeFilme);
		
		JLabel lbGenero = new JLabel("Genero:");
		lbGenero.setForeground(new Color(255, 255, 255));
		lbGenero.setBounds(90, 124, 46, 14);
		frameFilmeCadastrar.getContentPane().add(lbGenero);
		
		JLabel lblFaixaEtria = new JLabel("Faixa Et\u00E1ria:");
		lblFaixaEtria.setForeground(new Color(255, 255, 255));
		lblFaixaEtria.setBounds(90, 149, 83, 21);
		frameFilmeCadastrar.getContentPane().add(lblFaixaEtria);
		
		txNomeFilme = new JTextField();
		txNomeFilme.setBounds(177, 87, 187, 20);
		frameFilmeCadastrar.getContentPane().add(txNomeFilme);
		txNomeFilme.setColumns(10);
		
		JComboBox cbGenero = new JComboBox();
		cbGenero.setBounds(177, 121, 187, 20);
		frameFilmeCadastrar.getContentPane().add(cbGenero);
		
		txFaixaEtaria = new JTextField();
		txFaixaEtaria.setBounds(177, 149, 59, 20);
		frameFilmeCadastrar.getContentPane().add(txFaixaEtaria);
		txFaixaEtaria.setColumns(10);
		
		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.setBounds(296, 217, 97, 23);
		frameFilmeCadastrar.getContentPane().add(btCadastrar);
		
		JButton btCancelar = new JButton("Cancelar");
		
		btCancelar.setBounds(197, 217, 89, 23);
		frameFilmeCadastrar.getContentPane().add(btCancelar);
		
		JLabel lbCadastrarFilme = new JLabel("Cadastrar Filme");
		lbCadastrarFilme.setHorizontalAlignment(SwingConstants.CENTER);
		lbCadastrarFilme.setForeground(new Color(255, 255, 255));
		lbCadastrarFilme.setFont(new Font("Calibri", Font.BOLD, 17));
		lbCadastrarFilme.setBounds(0, 46, 434, 21);
		frameFilmeCadastrar.getContentPane().add(lbCadastrarFilme);
		
		JLabel lblAnos = new JLabel("anos");
		lblAnos.setForeground(new Color(255, 255, 255));
		lblAnos.setBounds(246, 152, 46, 14);
		frameFilmeCadastrar.getContentPane().add(lblAnos);
		frameFilmeCadastrar.setTitle("Locadora Unisal");
		frameFilmeCadastrar.setBounds(100, 100, 450, 300);
		frameFilmeCadastrar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameFilmeCadastrar.setVisible(true);
	}
}
