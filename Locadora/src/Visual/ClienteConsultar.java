package Visual;

import java.awt.BorderLayout;
import java.util.ListIterator;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ClienteConsultar{

	private JFrame frameClienteConsultar;
	private DefaultTableModel modelo;
	private JTable tbClientes;
	
	public ClienteConsultar(){
		frameClienteConsultar();
		CriaTabela();
		AdicionaLinhasTabela();
	}
	
	private void CriaTabela() {
		
		String[] columns = new String[]{"C�digo","Nome","CPF","Rua","N�mero","Bairro","Cidade","E-mail","Data Nascimento"};
		
		modelo = new DefaultTableModel(null,columns);
		tbClientes = new JTable(modelo);
		tbClientes.setBounds(20,75, 380, 100);
		frameClienteConsultar.add(tbClientes.getTableHeader(),BorderLayout.PAGE_START);
		frameClienteConsultar.add(tbClientes,BorderLayout.CENTER);
				
	}

	private void AdicionaLinhasTabela(){

		ListIterator<RecursosHumanos.Cliente> iterator = Run.Main.clientes.listIterator(); 

		while (iterator.hasNext()){
			RecursosHumanos.Cliente tempCliente = iterator.next();
			modelo.addRow(new Object[]
					{
					tempCliente.getCodigoCliente(),
					tempCliente.getNome(),
					String.valueOf(tempCliente.getCpf()),
					tempCliente.getRua(),
					tempCliente.getNumero(),
					tempCliente.getBairro(),
					tempCliente.getCidade(),
					tempCliente.getEmail(),
					tempCliente.getDataNascimentoFormatada()
					}
			);
		}

	}
	
	private void frameClienteConsultar(){
		frameClienteConsultar = new JFrame();
		frameClienteConsultar.setLayout(new BorderLayout());
		frameClienteConsultar.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frameClienteConsultar.setTitle("Locadora Unisal - Consultar Cliente");
		frameClienteConsultar.setVisible(true);
		frameClienteConsultar.setBounds(100, 100, 800, 300);
	}
}
