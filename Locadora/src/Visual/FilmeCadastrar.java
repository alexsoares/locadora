package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Banco.RegistroJaExiste;
import Locavel.Genero;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.util.ListIterator;

public class FilmeCadastrar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txDtFilme;
	private JTextField txSinopseFilme;
	private JTextField txFxFilme;
	private JTextField txNomeFilme;
	private JTextField txPrecoFilme;

	
	/**
	 * Create the frame.
	 */
	public FilmeCadastrar() {
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JComboBox<String> cbGeneroFilme = new JComboBox<String>();
		ListIterator<Genero> iterator = (ListIterator<Genero>) Run.Main.bancoGenero.RetornaLinkedList().listIterator();
		cbGeneroFilme.addItem("Selectione");
		while (iterator.hasNext()){
			Genero tempGenero = iterator.next();
			cbGeneroFilme.addItem(tempGenero.getNome());     
		}		
		cbGeneroFilme.setBounds(128, 80, 108, 20);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setBounds(27, 83, 35, 14);
		
		JLabel lblDataLancamento = new JLabel("Data Lancamento");
		lblDataLancamento.setBounds(27, 114, 102, 14);
		
		JLabel lblSinopse = new JLabel("Sinopse");
		lblSinopse.setBounds(27, 145, 37, 14);
		
		txDtFilme = new JTextField();
		txDtFilme.setBounds(136, 111, 86, 20);
		txDtFilme.setColumns(10);
		
		txSinopseFilme = new JTextField();
		txSinopseFilme.setBounds(136, 145, 288, 53);
		txSinopseFilme.setColumns(10);
		
		JLabel lblFaixaEtaria = new JLabel("Faixa etaria");
		lblFaixaEtaria.setBounds(254, 48, 84, 14);
		
		txFxFilme = new JTextField();
		txFxFilme.setBounds(338, 52, 86, 20);
		txFxFilme.setColumns(10);
	
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCadastrar.setBounds(331, 206, 93, 23);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparDadosDaTela();
			}
		});
		btnCancelar.setBounds(117, 206, 108, 23);
		
		JLabel lblCadastroDeFilmes = new JLabel("Cadastro de Filmes");
		lblCadastroDeFilmes.setBounds(260, 11, 164, 26);
		lblCadastroDeFilmes.setFont(new Font("Arial Black", Font.PLAIN, 13));
		contentPane.setLayout(null);
		contentPane.add(btnCancelar);
		contentPane.add(btnCadastrar);
		contentPane.add(lblDataLancamento);
		contentPane.add(lblGenero);
		contentPane.add(lblSinopse);
		contentPane.add(lblFaixaEtaria);
		contentPane.add(lblCadastroDeFilmes);
		contentPane.add(txSinopseFilme);
		contentPane.add(cbGeneroFilme);
		contentPane.add(txDtFilme);
		contentPane.add(txFxFilme);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(27, 29, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setBounds(27, 58, 46, 14);
		contentPane.add(lblPreo);
		
		txNomeFilme = new JTextField();
		txNomeFilme.setBounds(127, 26, 86, 20);
		contentPane.add(txNomeFilme);
		txNomeFilme.setColumns(10);
		
		txPrecoFilme = new JTextField();
		txPrecoFilme.setBounds(127, 52, 86, 20);
		contentPane.add(txPrecoFilme);
		txPrecoFilme.setColumns(10);
		
	}
	public void CadastrarNovoCliente(){
		
		try {
				Locavel.Cliente novoCliente = new Locavel.Filme(
						txNome.getText());
				
				Run.Main.bancoCliente.Insere(novoCliente);
				
				JOptionPane.showMessageDialog(null,"Cliente cadastrado com sucesso!");
				limparDadosDaTela();
				
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
	
	private void limparDadosDaTela() {
		txDtFilme.setText(null);
		txFxFilme.setText(null);
		txNomeFilme.setText(null);
		txPrecoFilme.setText(null);
		txSinopseFilme.setText(null);
		
	}
}
