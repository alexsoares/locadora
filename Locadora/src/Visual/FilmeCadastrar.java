package Visual;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;


public class FilmeCadastrar extends Home{

	public FilmeCadastrar() {
		super.getFramePadrao().setTitle("Locadora Unisal - Cadastrar Novo Filme");
		initialize();
	}
	
	private JLabel makeNewLabel(String mensagem,int a,int b, int c, int d){
		JLabel novoLabel = new JLabel(mensagem);
		novoLabel.setForeground(new Color(255, 255, 255));
		novoLabel.setBackground(new Color(255, 255, 255));
		novoLabel.setBounds(a,b,c,d);
		return novoLabel;
	}
	
	private JLabel labelNomeFilme(){
		JLabel lbNomeFilme = makeNewLabel("Nome:",90, 90, 59, 14);
		return lbNomeFilme;
	}

	private JLabel labelGenero(){
		JLabel lbGenero = makeNewLabel("Genero:",90, 124, 46, 14);
		return lbGenero;
	}
	
	private JLabel labelCadastrarFilme(){
		JLabel lbCadastrarFilme = makeNewLabel("Cadastrar Filme",0, 46, 434, 21);
		lbCadastrarFilme.setHorizontalAlignment(SwingConstants.CENTER);
		lbCadastrarFilme.setFont(new Font("Calibri", Font.BOLD, 17));
		return lbCadastrarFilme;
	}
	
	private JLabel labelAnos(){
		JLabel lblAnos = makeNewLabel("anos",246, 152, 46, 14);
		return lblAnos;
	}
	
	private JLabel labelFaixaEtaria(){
		JLabel lblFaixaEtria = makeNewLabel("Faixa Etária:",90, 149, 83, 21);
		return lblFaixaEtria;
	}
	
	private JTextField textNomeFilme(){
		JTextField txNomeFilme = new JTextField();
		txNomeFilme.setBounds(177, 87, 187, 20);
		return txNomeFilme;
	}
	
	@SuppressWarnings("rawtypes")
	private JComboBox comboGenero(){
		JComboBox cbGenero = new JComboBox();
		cbGenero.setBounds(177, 121, 187, 20);
		return cbGenero;
	}
	
	private JTextField textFaixaEtaria(){
		JTextField txFaixaEtaria = new JTextField();
		txFaixaEtaria.setBounds(177, 149, 59, 20);
		return txFaixaEtaria;
	}
		
	private JButton botaoCadastrar(){
		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.setBounds(296, 217, 97, 23);
		return btCadastrar;
	}
	
	private JButton botaoCancelar(){
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.setBounds(197, 217, 89, 23);
		return btCancelar;
	}
	
	private void initialize() {
				
		super.getFramePadrao().getContentPane().add(labelNomeFilme());
		super.getFramePadrao().getContentPane().add(labelGenero());
		super.getFramePadrao().getContentPane().add(labelCadastrarFilme());
		super.getFramePadrao().getContentPane().add(labelAnos());
		super.getFramePadrao().getContentPane().add(labelFaixaEtaria());
		super.getFramePadrao().getContentPane().add(textNomeFilme());
		super.getFramePadrao().getContentPane().add(comboGenero());
		super.getFramePadrao().getContentPane().add(textFaixaEtaria());
		super.getFramePadrao().getContentPane().add(botaoCadastrar());
		super.getFramePadrao().getContentPane().add(botaoCancelar());
	}
}
