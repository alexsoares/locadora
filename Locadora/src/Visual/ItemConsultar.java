package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ItemConsultar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ItemConsultar frame = new ItemConsultar();
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
	public ItemConsultar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(41, 199, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(140, 199, 89, 23);
		contentPane.add(btnAlterar);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(53, 44, 46, 14);
		contentPane.add(lblCodigo);
		
		textField = new JTextField();
		textField.setBounds(109, 41, 56, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(53, 69, 46, 14);
		contentPane.add(lblNome);
		
		textField_1 = new JTextField();
		textField_1.setBounds(109, 66, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDataDeAquisio = new JLabel("Data de Aquisi\u00E7\u00E3o");
		lblDataDeAquisio.setBounds(53, 94, 89, 14);
		contentPane.add(lblDataDeAquisio);
		
		textField_2 = new JTextField();
		textField_2.setBounds(161, 91, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
	}
}
