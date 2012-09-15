package Visual;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import Banco.RegistroJaExiste;


public class GeneroCadastrar extends Home{

	private JFrame frameGeneroCadastrar;
	private JTextField txNomeGenero;
	private JTextField txDescricao;

	public GeneroCadastrar() {
		initialize();
		btCadastrar();
	}

	private void frameGeneroCadastrar(){
		
		frameGeneroCadastrar = new JFrame();
		frameGeneroCadastrar = getFramePadrao();
		frameGeneroCadastrar.setTitle("Locadora Unisal - Cadastrar Novo Genero");
		frameGeneroCadastrar.setBounds(100, 100, 450, 300);
		frameGeneroCadastrar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameGeneroCadastrar.setVisible(true);
	}
	private void initialize() {
		frameGeneroCadastrar();
		

		JLabel lbNomeGenero = new JLabel("Nome:");
		lbNomeGenero.setForeground(new Color(255, 255, 255));
		lbNomeGenero.setBackground(new Color(255, 255, 255));
		lbNomeGenero.setBounds(90, 110, 59, 14);
		frameGeneroCadastrar.getContentPane().add(lbNomeGenero);
		
		JLabel lblDescricao = new JLabel("Descricao:");
		lblDescricao.setForeground(new Color(255, 255, 255));
		lblDescricao.setBounds(90, 132, 83, 21);
		frameGeneroCadastrar.getContentPane().add(lblDescricao);
		

		
		txNomeGenero = new JTextField();
		txNomeGenero.setBounds(157, 110, 187, 20);
		frameGeneroCadastrar.getContentPane().add(txNomeGenero);
		txNomeGenero.setColumns(10);
		
		txDescricao = new JTextField();
		txDescricao.setBounds(157, 132, 187, 20);
		frameGeneroCadastrar.getContentPane().add(txDescricao);
		txDescricao.setColumns(10);
			
		JButton btCancelar = new JButton("Cancelar");
		
		btCancelar.setBounds(197, 217, 89, 23);
		frameGeneroCadastrar.getContentPane().add(btCancelar);
		
		JLabel lbCadastrarGenero = new JLabel("Cadastrar Genero");
		lbCadastrarGenero.setHorizontalAlignment(SwingConstants.CENTER);
		lbCadastrarGenero.setForeground(new Color(255, 255, 255));
		lbCadastrarGenero.setFont(new Font("Calibri", Font.BOLD, 17));
		lbCadastrarGenero.setBounds(0, 46, 434, 21);
		frameGeneroCadastrar.getContentPane().add(lbCadastrarGenero);

		

		frameGeneroCadastrar.setTitle("Locadora Unisal");
		frameGeneroCadastrar.setBounds(100, 100, 450, 300);
		frameGeneroCadastrar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameGeneroCadastrar.setVisible(true);
	}
	
	private void btCadastrar() {
		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastrarNovoGenero();
			}
		});
		btCadastrar.setBounds(312, 217, 98, 23);
		frameGeneroCadastrar.getContentPane().add(btCadastrar);
	}
	
	public void CadastrarNovoGenero(){
	

		
		try {
				Locavel.Genero novoGenero = new Locavel.Genero(
						
	     				txNomeGenero.getText(),
						txDescricao.getText());
				
				Run.Main.bancoGenero.Insere(novoGenero);
				
				JOptionPane.showMessageDialog(null,"Genero cadastrado com sucesso!");
				LimparDadosDaTela();
				
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,e.getMessage(),"Valor não esperado",JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (RegistroJaExiste e) {
				JOptionPane.showMessageDialog(null,e.getMessage(),"Valor não esperado",JOptionPane.WARNING_MESSAGE);
				e.printStackTrace();
			}
		}

	private void LimparDadosDaTela(){
		txNomeGenero.setText(null);
		txDescricao.setText(null);
	}
}
