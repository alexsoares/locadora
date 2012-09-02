package Visual;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JTextField;
import javax.swing.JButton;

import Banco.RegistroJaExiste;


public class ClienteCadastrar extends Home{

	private JFrame frameClienteCadastrar;
	private JTextField txNome;
	private JTextField txCPF;
	private JTextField txTelefone;
	private JTextField txRua;
	private JTextField txNumero;
	private JTextField txBairro;
	private JTextField txCidade;
	private JTextField txDataNascimento;
	private JTextField txEmail;

	
	public ClienteCadastrar() {
		frameClienteCadastrar();
		lbCadastrarCliente();
		lbCPF();		
		lbNome();
		lbRua();
		lbNumero();
		lbTelefone();
		lbEmail();
		lbDataNascimento();
		txNome();
		txCPF();
		txTelefone();
		txRua();
		txNumero();
		lbBairro();
		txBairro();
		lbCidade();
		txCidade();
		txDataNascimento();
		txEmail();
		btCadastrar();
		btCancelar();
	}
	
	private void frameClienteCadastrar(){
		frameClienteCadastrar = new JFrame();
		frameClienteCadastrar = getFramePadrao();
		frameClienteCadastrar.setTitle("Locadora Unisal - Cadastrar Novo Cliente");
		frameClienteCadastrar.setBounds(100, 100, 450, 300);
		frameClienteCadastrar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameClienteCadastrar.setVisible(true);
	}
	
	
	private void lbCadastrarCliente (){
		JLabel lbCadastrarCliente = new JLabel("Cadastrar Cliente");
		lbCadastrarCliente.setForeground(new Color(255, 255, 255));
		lbCadastrarCliente.setFont(new Font("Calibri", Font.BOLD, 17));
		lbCadastrarCliente.setBackground(new Color(255, 255, 255));
		lbCadastrarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lbCadastrarCliente.setBounds(0, 36, 434, 14);
		frameClienteCadastrar.getContentPane().add(lbCadastrarCliente);
	}
	
	private void lbCPF(){
		JLabel lbCpf = new JLabel("CPF:");
		lbCpf.setForeground(new Color(255, 255, 255));
		lbCpf.setBounds(27, 97, 46, 14);
		frameClienteCadastrar.getContentPane().add(lbCpf);
	}
	
	private void lbNome(){
		JLabel lbNome = new JLabel("Nome Completo:");
		lbNome.setForeground(new Color(255, 255, 255));
		lbNome.setBounds(27, 72, 104, 14);
		frameClienteCadastrar.getContentPane().add(lbNome);	
	}
	
	private void lbRua(){
		JLabel lbRua = new JLabel("Rua:");
		lbRua.setForeground(new Color(255, 255, 255));
		lbRua.setBounds(27, 123, 33, 14);
		frameClienteCadastrar.getContentPane().add(lbRua);
	}

	private void lbNumero(){
		JLabel lbNumero = new JLabel("Numero:");
		lbNumero.setForeground(new Color(255, 255, 255));
		lbNumero.setBounds(291, 123, 62, 14);
		frameClienteCadastrar.getContentPane().add(lbNumero);
	}
	
	private void lbTelefone(){
		JLabel lbTelefone = new JLabel("Telefone:");
		lbTelefone.setForeground(new Color(255, 255, 255));
		lbTelefone.setBounds(247, 176, 62, 14);
		frameClienteCadastrar.getContentPane().add(lbTelefone);
	}
	
	private void lbEmail(){
		JLabel lbEmail = new JLabel("E-mail:");
		lbEmail.setForeground(new Color(255, 255, 255));
		lbEmail.setBounds(27, 176, 46, 14);
		frameClienteCadastrar.getContentPane().add(lbEmail);
	}
	
	private void lbDataNascimento(){
		JLabel lbDataNascimento = new JLabel("Data Nascimento:");
		lbDataNascimento.setForeground(new Color(255, 255, 255));
		lbDataNascimento.setBounds(198, 97, 111, 14);
		frameClienteCadastrar.getContentPane().add(lbDataNascimento);
	}
	
	private void txNome(){
		txNome = new JTextField();
		txNome.setBounds(141, 69, 269, 20);
		frameClienteCadastrar.getContentPane().add(txNome);

	}
	
	private void txCPF(){
		txCPF = new JTextField();
		txCPF.setBounds(71, 94, 98, 20);
		frameClienteCadastrar.getContentPane().add(txCPF);
	}
	
	private void txTelefone(){
		txTelefone = new JTextField();
		txTelefone.setBounds(312, 173, 98, 20);
		frameClienteCadastrar.getContentPane().add(txTelefone);
	}
	
	private void txRua(){
		txRua = new JTextField();
		txRua.setBounds(71, 120, 208, 20);
		frameClienteCadastrar.getContentPane().add(txRua);
	}
	
	private void txNumero(){
		txNumero = new JTextField();
		txNumero.setBounds(354, 120, 56, 20);
		frameClienteCadastrar.getContentPane().add(txNumero);
	}
	
	private void lbBairro(){
		JLabel lbBairro = new JLabel("Bairro:");
		lbBairro.setForeground(new Color(255, 255, 255));
		lbBairro.setBounds(27, 149, 46, 14);
		frameClienteCadastrar.getContentPane().add(lbBairro);
	}
	
	private void txBairro(){
		txBairro = new JTextField();
		txBairro.setBounds(71, 146, 98, 20);
		frameClienteCadastrar.getContentPane().add(txBairro);
	}
	
	private void lbCidade(){
		JLabel lbCidade = new JLabel("Cidade:");
		lbCidade.setForeground(new Color(255, 255, 255));
		lbCidade.setBounds(216, 149, 46, 14);
		frameClienteCadastrar.getContentPane().add(lbCidade);
	}
	
	private void btCancelar() {
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LimparDadosDaTela();
			}
		});
		btCancelar.setBounds(207, 228, 89, 23);
		frameClienteCadastrar.getContentPane().add(btCancelar);
		
	}

	private void btCadastrar() {
		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastrarNovoCliente();
			}
		});
		btCadastrar.setBounds(312, 228, 98, 23);
		frameClienteCadastrar.getContentPane().add(btCadastrar);
	}
	
	public void CadastrarNovoCliente(){
	
		SimpleDateFormat FormatDate = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
				RecursosHumanos.Cliente novoCliente = new RecursosHumanos.Cliente(
						txNome.getText(),
						txCPF.getText(),
						txRua.getText(),
						Integer.parseInt(txNumero.getText()),
						txBairro.getText(),
						txCidade.getText(),
						txEmail.getText(),
						FormatDate.parse(txDataNascimento.getText()));
				
				Run.Main.banco.Insere(novoCliente);
				
				JOptionPane.showMessageDialog(null,"Cliente cadastrado com sucesso!");
				LimparDadosDaTela();
				
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,e.getMessage(),"Valor não esperado",JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null,e.getMessage(),"Valor não esperado",JOptionPane.WARNING_MESSAGE);
				e.printStackTrace();
			} catch (RegistroJaExiste e) {
				JOptionPane.showMessageDialog(null,e.getMessage(),"Valor não esperado",JOptionPane.WARNING_MESSAGE);
				e.printStackTrace();
			}
		}
	
	private void LimparDadosDaTela(){
		txNome.setText(null);
		txCPF.setText(null);
		txRua.setText(null);
		txNumero.setText(null);
		txBairro.setText(null);
		txCidade.setText(null);
		txEmail.setText(null);
		txDataNascimento.setText(null);
		txTelefone.setText(null);
	}
	
	private void txEmail() {
		txEmail = new JTextField();
		txEmail.setBounds(71, 173, 164, 20);
		frameClienteCadastrar.getContentPane().add(txEmail);
	}

	private void txDataNascimento() {
		txDataNascimento = new JTextField();
		txDataNascimento.setAutoscrolls(false);
		txDataNascimento.setHorizontalAlignment(SwingConstants.CENTER);
		txDataNascimento.setBounds(306, 94, 104, 20);
		frameClienteCadastrar.getContentPane().add(txDataNascimento);
	}

	private void txCidade() {
		txCidade = new JTextField();
		txCidade.setBounds(274, 146, 136, 20);
		frameClienteCadastrar.getContentPane().add(txCidade);
	}
}
