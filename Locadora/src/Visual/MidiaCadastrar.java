package Visual;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import Banco.RegistroInexistente;
import Banco.RegistroJaExiste;
import Locavel.Midia;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MidiaCadastrar{

	private JFrame frame;
	private JTextField txMidiaDesc;
	private JTextField txMidiaCod;

	/**
	 * Create the application.
	 */
	public MidiaCadastrar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Locadora Unisal - Cadastrar Nova Mídia");

		frame.setBounds(100, 100, 450, 300);
		frame.setVisible(true);
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(55, 84, 46, 14);
		frame.getContentPane().add(lblNome);
		
		txMidiaDesc = new JTextField();
		txMidiaDesc.setBounds(111, 81, 200, 20);
		frame.getContentPane().add(txMidiaDesc);
		txMidiaDesc.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(55, 59, 46, 14);
		frame.getContentPane().add(lblCodigo);
		
		txMidiaCod = new JTextField();
		txMidiaCod.setBounds(111, 53, 46, 20);
		frame.getContentPane().add(txMidiaCod);
		txMidiaCod.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					CadastrarMidia();
				} catch (RegistroInexistente e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnSalvar.setBounds(307, 123, 89, 23);
		frame.getContentPane().add(btnSalvar);
		
		JLabel lblCadastroDeMdias = new JLabel("Cadastro de M\u00EDdias");
		lblCadastroDeMdias.setFont(new Font("Arial", Font.BOLD, 18));
		lblCadastroDeMdias.setBounds(99, 11, 172, 14);
		frame.getContentPane().add(lblCadastroDeMdias);
	}
	
	
	public void CadastrarMidia() throws RegistroInexistente{
		
		try {
		        Midia midia = new Midia(txMidiaCod.getText(),txMidiaDesc.getText());
		
				Run.Main.bancoMidia.Insere(midia);
				
				JOptionPane.showMessageDialog(null,"Midia cadastrada com sucesso!");
				limparDadosDaTela();
				
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,e.getMessage(),"Valor não esperado",JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (RegistroJaExiste e) {
				JOptionPane.showMessageDialog(null,e.getMessage(),"Valor não esperado",JOptionPane.WARNING_MESSAGE);
				e.printStackTrace();
			}
	}
	private void limparDadosDaTela() {
		txMidiaCod.setText(null);
		txMidiaDesc.setText(null);
	}
}
