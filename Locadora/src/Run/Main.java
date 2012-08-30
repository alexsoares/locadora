package Run;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main {

	public static List<RecursosHumanos.Cliente> clientes = new LinkedList<RecursosHumanos.Cliente>(); 

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat FormatDate = new SimpleDateFormat("dd/MM/yyyy");
		
		RecursosHumanos.Cliente bruno = new RecursosHumanos.Cliente("Bruno Schionato", 1111111.0,"Saudade",1242, "Centro", "Cosmopolis", "schionato@gmail.com", FormatDate.parse("22/09/1987"));
		RecursosHumanos.Cliente aldair = new RecursosHumanos.Cliente("Aldair Roberto", 2331111.0,"Paulisa",2356, "Centro", "São Paulo", "aldair@gmail.com", FormatDate.parse("01/05/1980"));
		RecursosHumanos.Cliente juliana = new RecursosHumanos.Cliente("Juliana Aparecida", 233567.0,"7 de Setembro",9856, "Bela Vista", "Holambra", "juliana@ms.com", FormatDate.parse("28/05/1981"));
		
		clientes.add(aldair);
		clientes.add(bruno);
		clientes.add(juliana);
		
		@SuppressWarnings("unused")
		Visual.Home paginaInicial = new Visual.Home();
		
	}
	
	public static void atualizarDadosDoCliente(RecursosHumanos.Cliente cliente){
		
		ListIterator<RecursosHumanos.Cliente> iterator = clientes.listIterator();
		
		while (iterator.hasNext()){
			RecursosHumanos.Cliente clienteAtualizado = iterator.next();
			
			if (cliente.getCodigoCliente() == clienteAtualizado.getCodigoCliente()){
	
				clienteAtualizado.setNome(cliente.getNome());
				clienteAtualizado.setBairro(cliente.getBairro());
				clienteAtualizado.setCidade(cliente.getCidade());
				clienteAtualizado.setCpf(cliente.getCpf());
				clienteAtualizado.setDataNascimento(cliente.getDataNascimento());
				clienteAtualizado.setNumero(cliente.getNumero());
				clienteAtualizado.setRua(cliente.getRua());
				
			}
		}
		
	}
	
	public static void addCliente(RecursosHumanos.Cliente cliente){
		clientes.add(cliente);
	}
	
	public static void removerCliente(double codigoCliente){
		
		ListIterator<RecursosHumanos.Cliente> iterator = Run.Main.clientes.listIterator();
		
		while (iterator.hasNext()){
			RecursosHumanos.Cliente tempCliente = iterator.next();
			
			if (tempCliente.getCodigoCliente() == codigoCliente){
				clientes.remove(tempCliente);
			}
			
		}
	}
	
	public static List<RecursosHumanos.Cliente> BuscarClientePorCodigo(Double criterio){
		
		List<RecursosHumanos.Cliente> clientesEncontrados = new LinkedList<RecursosHumanos.Cliente>();
		ListIterator<RecursosHumanos.Cliente> iterator = Run.Main.clientes.listIterator();
		
		while (iterator.hasNext()){
			
			RecursosHumanos.Cliente percorreListaClientes = iterator.next();
			
			if (percorreListaClientes.getCodigoCliente() ==  criterio){
				clientesEncontrados.add(percorreListaClientes);
			}
		}
		return clientesEncontrados;
	}
	
	public static List<RecursosHumanos.Cliente> BuscarClientePorCPF(Double criterio){
		
		List<RecursosHumanos.Cliente> clientesEncontrados = new LinkedList<RecursosHumanos.Cliente>();
		ListIterator<RecursosHumanos.Cliente> iterator = Run.Main.clientes.listIterator();
		
		while (iterator.hasNext()){
			
			RecursosHumanos.Cliente percorreListaClientes = iterator.next();
			
			if (percorreListaClientes.getCpf() ==  criterio){
				clientesEncontrados.add(percorreListaClientes);
			}
		}
		
		return clientesEncontrados;
	}

}
