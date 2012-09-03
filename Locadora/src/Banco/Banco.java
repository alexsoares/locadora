package Banco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import Locavel.Midia;
import Locavel.Genero;
import RecursosHumanos.Cliente;

public class Banco {
	
	/*
	 * Declara��o das listas do Banco 
	 */
	ArrayList<Midia> midia = new ArrayList<Midia>();
	ArrayList<Cliente> cliente = new ArrayList<Cliente>();
	ArrayList<Genero> genero = new ArrayList<Genero>();	
	Map midias = new HashMap();
	Map clientes = new HashMap();
	
	public Banco() {
		this.midia = new ArrayList<Midia>();
	}
	
	/*
	 * Classes internas 
	 */
	
	private int retornaIndice ( ArrayList<Tabelavel> lista, String valorChave ) {
		
		int retorno = -1;
		Tabelavel registro;
		
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
	
	private Tabelavel consultaDaLista ( ArrayList<Tabelavel> lista, String chave ) throws RegistroInexistente {
		
		int indice = retornaIndice(lista, chave);
		
		if ( indice == -1 ) {
			throw new RegistroInexistente(chave);
		}
		else {
			return lista.get(indice);
		}
	}

	private int verificaChaveDuplicada ( ArrayList<Tabelavel> lista, String valorChave, int indiceNaoVerificado ) {
		
		int retorno = -1;
		Tabelavel registro;
		
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
	
	private void insereNaLista ( ArrayList<Tabelavel> lista, Tabelavel registro ) throws RegistroJaExiste {
			
		String chave = registro.retornaValorChave();
		int tamanho = lista.size();

		if ( retornaIndice(lista, chave) == -1 ) {
			registro.setIndice(tamanho);
			lista.add(tamanho,registro);
		}
		else {
			throw new RegistroJaExiste(registro.retornaValorChave());
		}
		

	}
		
	private void alteraNaLista ( ArrayList<Tabelavel> lista, Tabelavel registro ) throws RegistroInexistente, RegistroJaExiste {
		System.out.println("alteraNaLista.01."+registro.retornaValorChave());
		int indice = registro.getIndice();
		System.out.println("alteraNaLista.02."+indice);
		if ( verificaChaveDuplicada(lista, registro.retornaValorChave(), indice) != -1) {
			throw new RegistroJaExiste(registro.retornaValorChave());
		}
		System.out.println("alteraNaLista.03");
		if ( indice == -1 ) {
			System.out.println("alteraNaLista.04");
			throw new RegistroInexistente(registro.retornaValorChave());
		}
		else {
			System.out.println("alteraNaLista.05");
			lista.remove(indice);
			System.out.println("alteraNaLista.06");
			lista.add(indice,registro);
		}
	}
	
	private void removeDaLista ( ArrayList<Tabelavel> lista, String chave ) throws RegistroInexistente {
		
		int indice = retornaIndice(lista, chave);
		
		if ( indice == -1 ) {
			throw new RegistroInexistente(chave);
		}
		else {
			lista.set(indice, null);
		}
	}

	private void removeDaLista ( ArrayList<Tabelavel> lista, int indice ) throws RegistroInexistente {
		if ( indice < lista.size() ) {
			lista.set(indice, null);
		}
		else {
			throw new RegistroInexistente(" "+indice+" ");
		}
	}
	
	private Tabelavel consultaDaLista ( ArrayList<Tabelavel> lista, int indice ) throws RegistroInexistente {
		
		Tabelavel registro = lista.get(indice);
		
		if ( registro == null ) {
			throw new RegistroInexistente("vazio");
		}
		
		return registro;
	}

	/*
	 * Classe para manipula��o de Midia
	 */
	
    public void Insere ( Midia midia ) throws RegistroJaExiste{
		insereNaLista( (ArrayList) this.midia, (Tabelavel) midia);
	}
		
    public void ExcluiMidia ( String chave ) throws RegistroInexistente{
		removeDaLista( (ArrayList) this.midia, chave);
	}
	
    public void ExcluiMidia ( int indice ) throws RegistroInexistente{
		removeDaLista( (ArrayList) this.midia, indice);
	}
	
	public void Altera ( Midia midia) throws RegistroInexistente, RegistroJaExiste{
		alteraNaLista( (ArrayList) this.midia, (Tabelavel) midia);
	}
	
	public Midia ConsultaMidia ( String chave ) throws RegistroInexistente{
		return (Midia) consultaDaLista( (ArrayList) this.midia, chave);
	}
	
	public Midia ConsultaMidia ( int indice ) throws RegistroInexistente{
		return (Midia) consultaDaLista( (ArrayList) this.midia, indice);
	}
	
	public LinkedList<Midia> ListMidia () {

        LinkedList<Midia> lista = new LinkedList<Midia>();
        
        Midia registro;
       
        for (int i = 0; i < midia.size(); i++) {
           
            registro = midia.get(i);
           
            if ( registro != null ) {
           
                lista.add(registro);
               
            }
           
        }
       
        return lista;
    }
	
/* Genero
 * 
 */
	
    public void Insere ( Genero genero ) throws RegistroJaExiste{
		insereNaLista( (ArrayList) this.genero, (Tabelavel) genero);
	}
    public void ExcluiGenero ( String chave ) throws RegistroInexistente{
		removeDaLista( (ArrayList) this.genero, chave);
	}
	public Genero ConsultaGenero ( String chave ) throws RegistroInexistente{
		return (Genero) consultaDaLista( (ArrayList) this.genero, chave);
	}

	public void AlteraGenero ( Genero genero) throws RegistroInexistente, RegistroJaExiste{
		alteraNaLista( (ArrayList) this.genero, (Tabelavel) genero);
	}

	
// Fim Genero
	
	/*
	 * Classe para manipula��o de Cliente
	 */
	
    public void Insere ( Cliente cliente ) throws RegistroJaExiste{
		insereNaLista( (ArrayList) this.cliente, (Tabelavel) cliente);
	}
		
    public void ExcluiCliente ( String chave ) throws RegistroInexistente{
		removeDaLista( (ArrayList) this.cliente, chave);
	}
	
    public void ExcluiCliente ( int indice ) throws RegistroInexistente{
		removeDaLista( (ArrayList) this.cliente, indice);
	}
	
	public void Altera ( Cliente cliente) throws RegistroInexistente, RegistroJaExiste{
		alteraNaLista( (ArrayList) this.cliente, (Tabelavel) cliente);
	}
	
	public Cliente ConsultaCliente ( String chave ) throws RegistroInexistente{
		return (Cliente) consultaDaLista( (ArrayList) this.cliente, chave);
	}
	
	public Cliente ConsultaCliente ( int indice ) throws RegistroInexistente{
		return (Cliente) consultaDaLista( (ArrayList) this.cliente, indice);
	}
	

    public LinkedList<Cliente> ListCliente () {
    	
        LinkedList<Cliente> lista = new LinkedList<Cliente>();
        
        Cliente registro;
        
        for (int i = 0; i < cliente.size(); i++) {
           
            registro = cliente.get(i);
           
            if ( registro != null ) {
           
                lista.addLast(registro);
               
            }
           
        }
        
        return lista;
    }

    public void showGenero ( ) {
		
		Genero registro;
		
		for (int i = 0; i < genero.size(); i++) {
			
			registro = genero.get(i);
			
			if ( registro != null ) {
							
				System.out.println( "Genero " + registro.getIndice() +
									" c�digo " + registro.getCodigo()  +
									" e descri��o " + registro.getDescricao() + ".");
			
			}
			
		}
		
	}

	
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
	/*	
	public static void main(String[] args) {
		//criacao banco
		Map banco = new HashMap();
		Map midias = new HashMap();
		Map clientes = new HashMap();
		banco.put(Entities.MIDIA, midias);
		banco.put(Entities.CLIENTES, clientes);
		
		//salvar um midia
		Map medias = (Map) banco.get(Entities.MIDIA);
		
		Midia midia = new Midia("1", "desc");
		medias.put(1,  midia);
		
		midia = new Midia("2", "desc");
		medias.put(2,  midia);
		
		medias.get(2);
		
		for (Iterator iterator =medias.entrySet().iterator(); iterator.hasNext();) {
				//entryset
	}	
		
		
	}
	*/
	 
}
