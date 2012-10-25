package Visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import Banco.RegistroInexistente;
import Banco.RegistroJaExiste;
import Locavel.Filme;
import Locavel.Item;
import Locavel.Midia;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ListIterator;
import javax.swing.JLabel;


public class ItemCadastrar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JComboBox<String> cbFilme = new JComboBox<String>();
    private JComboBox<String> cbMidia = new JComboBox<String>();
    private JLabel lblFilme;
    private JLabel lblCodigoDeBarras;
    private JLabel lblMidia;
    private JTextField txDtAquisicao;
    private JLabel lblDataDeAquisio;
  

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ItemCadastrar frame = new ItemCadastrar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ItemCadastrar() {
		ListIterator<Filme> iterator = (ListIterator<Filme>) Run.Main.bancoFilme.RetornaLinkedList().listIterator();
		cbFilme.addItem("Selectione");
		while (iterator.hasNext()){
			Filme tempFilme = iterator.next();
			cbFilme.addItem(tempFilme.getNome());     
		}		
		ListIterator<Midia> iterator2 = (ListIterator<Midia>) Run.Main.bancoMidia.RetornaLinkedList().listIterator();
		cbMidia.addItem("Selectione");
		while (iterator2.hasNext()){
			Midia tempMidia = iterator2.next();
			cbMidia.addItem(tempMidia.getDescricao());     
		}		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					CadastrarNovoItem();
				} catch (RegistroInexistente e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		});
		btnSalvar.setBounds(25, 194, 89, 23);
		contentPane.add(btnSalvar);
		
		cbFilme.setBounds(119, 40, 101, 20);
		contentPane.add(cbFilme);
		
		lblFilme = new JLabel("Filme");
		lblFilme.setBounds(25, 43, 46, 14);
		contentPane.add(lblFilme);
		
		lblCodigoDeBarras = new JLabel("Codigo de Barras");
		lblCodigoDeBarras.setBounds(25, 11, 89, 14);
		contentPane.add(lblCodigoDeBarras);
		
	
		
		
		cbMidia.setBounds(119, 71, 101, 20);
		contentPane.add(cbMidia);
		
		lblMidia = new JLabel("Midia");
		lblMidia.setBounds(25, 74, 46, 14);
		contentPane.add(lblMidia);
		
		txDtAquisicao = new JTextField();
		txDtAquisicao.setBounds(119, 102, 86, 20);
		contentPane.add(txDtAquisicao);
		txDtAquisicao.setColumns(10);
		
		lblDataDeAquisio = new JLabel("Data de aquisi\u00E7\u00E3o");
		lblDataDeAquisio.setBounds(25, 105, 89, 14);
		contentPane.add(lblDataDeAquisio);
	}
	
	public void CadastrarNovoItem() throws RegistroInexistente{
		
		try {
			DateFormat formatter = new SimpleDateFormat("dd/MM/yy");

				 
		        Item novoItem = new Locavel.Item("",cbFilme.getSelectedItem().toString(),cbMidia.getSelectedItem().toString(),formatter.parse(txDtAquisicao.getText()));
		
				Run.Main.bancoItem.Insere(novoItem);
				
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
		txDtAquisicao.setText(null);
		
	}

}
