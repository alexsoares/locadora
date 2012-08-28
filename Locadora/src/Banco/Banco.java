package Banco;

import java.util.ArrayList;
import Locavel.Midia;
import RecursosHumanos.Cliente;

public class Banco {
	
	/*
	 * Declara��o das listas do Banco 
	 */
	ArrayList<Midia> midia;
	// ArrayList<Cliente> cliente;
	
	public Banco() {
		this.midia = new ArrayList<Midia>();
	}
	
	/*
	 * Classes internas 
	 */
	
	private int retornaIndice ( ArrayList<Tabulavel> lista, String valorChave ) {
		
		int retorno = -1;
		Tabulavel registro;
		
		for (int i = 0; i < lista.size(); i++) {
			
			registro = lista.get(i);
			
			if ( registro != null ) {
							
				if ( registro.comparaCampoChave(valorChave) ) {
					retorno = i;
				}
				
			}
			
		}
		
		return retorno;
		
	}
	
	private int verificaChaveDuplicada ( ArrayList<Tabulavel> lista, String valorChave, int indiceNaoVerificado ) {
		
		int retorno = -1;
		Tabulavel registro;
		
		for (int i = 0; i < lista.size(); i++) {
			
			registro = lista.get(i);
			
			if ( registro != null ) {
			
				if ( registro.comparaCampoChave(valorChave) &&
					 i != indiceNaoVerificado  ) {
					retorno = i;
				}
				
			}
			
		}
		
		return retorno;
		
	}
	
	private void insereNaLista ( ArrayList<Tabulavel> lista, Tabulavel registro ) throws RegistroJaExiste {
			
		String indice = registro.retornaValorChave();
		int tamanho = lista.size();

		if ( retornaIndice(lista, indice) == -1 ) {
			registro.setIndice(tamanho);
			lista.add(tamanho,registro);
		}
		else {
			throw new RegistroJaExiste(registro.retornaValorChave());
		}
	}
		
	private void alteraNaLista ( ArrayList<Tabulavel> lista, Tabulavel registro ) throws RegistroInexistente, RegistroJaExiste {
		
		int indice = registro.getIndice();
		
		if ( verificaChaveDuplicada(lista, registro.retornaValorChave(), indice) != -1) {
			throw new RegistroJaExiste(registro.retornaValorChave());
		}
		
		if ( indice == -1 ) {
			throw new RegistroInexistente(registro.retornaValorChave());
		}
		else {
			lista.remove(indice);
			lista.add(indice,registro);
		}
	}
	
	private void removeDaLista ( ArrayList<Tabulavel> lista, String chave ) throws RegistroInexistente {
		
		int indice = retornaIndice(lista, chave);
		
		if ( indice == -1 ) {
			throw new RegistroInexistente(chave);
		}
		else {
			lista.set(indice, null);
		}
	}

	private void removeDaLista ( ArrayList<Tabulavel> lista, int indice ) throws RegistroInexistente {
		lista.set(indice, null);
	}
	
	private Tabulavel consultaDaLista ( ArrayList<Tabulavel> lista, String chave ) throws RegistroInexistente {
		
		int indice = retornaIndice(lista, chave);
		
		if ( indice == -1 ) {
			throw new RegistroInexistente(chave);
		}
		else {
			return lista.get(indice);
		}
	}

	private Tabulavel consultaDaLista ( ArrayList<Tabulavel> lista, int indice ) throws RegistroInexistente {
		
		Tabulavel registro = lista.get(indice);
		
		if ( registro == null ) {
			throw new RegistroInexistente("vazio");
		}
		
		return registro;
	}

	/*
	 * Classe para manipula��o de Midia
	 */
	
    public void Insere ( Midia midia ) throws RegistroJaExiste{
		insereNaLista( (ArrayList) this.midia, (Tabulavel) midia);
	}
		
    public void ExcluiMidia ( String chave ) throws RegistroInexistente{
		removeDaLista( (ArrayList) this.midia, chave);
	}
	
    public void ExcluiMidia ( int indice ) throws RegistroInexistente{
		removeDaLista( (ArrayList) this.midia, indice);
	}
	
	public void Altera ( Midia midia) throws RegistroInexistente, RegistroJaExiste{
		alteraNaLista( (ArrayList) this.midia, (Tabulavel) midia);
	}
	
	public Midia ConsultaMidia ( String chave ) throws RegistroInexistente{
		return (Midia) consultaDaLista( (ArrayList) this.midia, chave);
	}
	
	public Midia ConsultaMidia ( int indice ) throws RegistroInexistente{
		return (Midia) consultaDaLista( (ArrayList) this.midia, indice);
	}
	
	public ArrayList<Midia> ListMidia () {
		return midia;
	}
	
	/*
	 * Classe para manipula��o de Cliente
	 */
	
	/*
    public void Insere ( Cliente cliente ) throws RegistroJaExiste{
		insereNaLista( (ArrayList) this.midia, (Tabulavel) cliente);
	}
		
    public void ExcluiCliente ( String chave ) throws RegistroInexistente{
		removeDaLista( (ArrayList) this.cliente, chave);
	}
	
    public void ExcluiCliente ( int indice ) throws RegistroInexistente{
		removeDaLista( (ArrayList) this.cliente, indice);
	}
	
	public void Altera ( Cliente cliente) throws RegistroInexistente, RegistroJaExiste{
		alteraNaLista( (ArrayList) this.cliente, (Tabulavel) cliente);
	}
	
	public Cliente ConsultaCliente ( String chave ) throws RegistroInexistente{
		return (Cliente) consultaDaLista( (ArrayList) this.cliente, chave);
	}
	
	public Cliente ConsultaCliente ( int indice ) throws RegistroInexistente{
		return (Cliente) consultaDaLista( (ArrayList) this.cliente, indice);
	}
	
	public ArrayList<Cliente> ListCliente () {
		return cliente;
	}
	*/
	
	public void showMidia ( ) {
		
		Midia registro;
		
		for (int i = 0; i < midia.size(); i++) {
			
			registro = midia.get(i);
			
			if ( registro != null ) {
							
				System.out.println( "M�dia " + registro.getIndice() +
									" c�digo " + registro.getCodigo() +
									" e descri��o " + registro.getDescricao() + ".");
			
			}
			
		}
		
	}
	
}
