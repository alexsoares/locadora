package Visual;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import Locavel.Genero;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GeneroConsultar {

	private JFrame frameGenero;
	private JTextField txConCodigo;
	private JTextField txConNome;
	private JTextField txConDescricao;
	
	
	private void criaFrame(){
		frameGenero = new JFrame();
		frameGenero.getContentPane();
		frameGenero.setLayout(null);
		frameGenero.setBounds(100, 100, 450, 300);
		frameGenero.setVisible(true);
	}

	public GeneroConsultar() {
		criaFrame();
		JLabel label = new JLabel("Codigo");
		label.setBounds(23, 57, 46, 14);
		frameGenero.add(label);
		
		JLabel label_1 = new JLabel("Nome Genero");
		label_1.setBounds(23, 88, 88, 14);
		frameGenero.add(label_1);
		
		txConCodigo = new JTextField();
		txConCodigo.setEditable(false);
		txConCodigo.setColumns(10);
		txConCodigo.setBounds(149, 54, 86, 20);
		frameGenero.add(txConCodigo);
		
		txConNome = new JTextField();
		txConNome.setEditable(false);
		txConNome.setEnabled(true);
		txConNome.setColumns(10);
		txConNome.setBounds(149, 85, 152, 20);
		frameGenero.add(txConNome);
		
		txConDescricao = new JTextField();
		txConDescricao.setEnabled(true);
		txConDescricao.setEditable(false);
		txConDescricao.setColumns(10);
		txConDescricao.setBounds(149, 120, 152, 20);
		frameGenero.add(txConDescricao);
		
		JLabel label_2 = new JLabel("Descri\u00E7\u00E3o Genero");
		label_2.setBounds(23, 123, 116, 14);
		frameGenero.add(label_2);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String criterioDaPesquisa = CapturarCriterioPesquista("Nome do Gênero").toString();
				
				if (criterioDaPesquisa != null){
					
					try{
						Genero generoEncontrado = Run.Main.bancoGenero.Consulta(criterioDaPesquisa);
						txConNome.setText(generoEncontrado.getNome());
						txConDescricao.setText(generoEncontrado.getDescricao());
						txConCodigo.setText(Integer.toString(generoEncontrado.getIndice()));

				    }
					catch (Exception e1){
						JOptionPane.showMessageDialog(null,e1.getMessage(),"Valor não esperado.",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnBuscar.setBounds(23, 159, 88, 23);
		frameGenero.add(btnBuscar);
	}

	

	public String CapturarCriterioPesquista(String criterio){
		
		String CriterioPesquisa = JOptionPane.showInputDialog(null, "Informe o " + criterio + " do genero que terá seus dados atualizados:");
		return CriterioPesquisa;
    }

}
