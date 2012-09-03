package Banco;

import java.util.ArrayList;
<<<<<<< HEAD
import java.util.LinkedList;
=======
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
>>>>>>> bruno/master

import Locavel.Midia;
import RecursosHumanos.Cliente;

public class Banco {
	
	/*
	 * Declaração das listas do Banco 
	 */
	ArrayList<Midia> midia = new ArrayList<Midia>();
	ArrayList<Cliente> cliente = new ArrayList<Cliente>();
	
<<<<<<< HEAD
=======
	Map midias = new HashMap();
	Map clientes = new HashMap();
	
>>>>>>> bruno/master
	public Banco() {
		this.midia = new ArrayList<Midia>();
	}
	
	/*
	 * Classes internas 
	 */
	
<<<<<<< HEAD
	private int retornaIndice ( ArrayList<Tabulavel> lista, String valorChave ) {
		
		int retorno = -1;
		Tabulavel registro;
=======
	private int retornaIndice ( ArrayList<Tabelavel> lista, String valorChave ) {
		
		int retorno = -1;
		Tabelavel registro;
>>>>>>> bruno/master
		
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
	
<<<<<<< HEAD
	private Tabulavel consultaDaLista ( ArrayList<Tabulavel> lista, String chave ) throws RegistroInexistente {
=======
	private Tabelavel consultaDaLista ( ArrayList<Tabelavel> lista, String chave ) throws RegistroInexistente {
>>>>>>> bruno/master
		
		int indice = retornaIndice(lista, chave);
		
		if ( indice == -1 ) {
			throw new RegistroInexistente(chave);
		}
		else {
			return lista.get(indice);
		}
	}

<<<<<<< HEAD
	private int verificaChaveDuplicada ( ArrayList<Tabulavel> lista, String valorChave, int indiceNaoVerificado ) {
		
		int retorno = -1;
		Tabulavel registro;
=======
	private int verificaChaveDuplicada ( ArrayList<Tabelavel> lista, String valorChave, int indiceNaoVerificado ) {
		
		int retorno = -1;
		Tabelavel registro;
>>>>>>> bruno/master
		
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
	
<<<<<<< HEAD
	private void insereNaLista ( ArrayList<Tabulavel> lista, Tabulavel registro ) throws RegistroJaExiste {
=======
	private void insereNaLista ( ArrayList<Tabelavel> lista, Tabelavel registro ) throws RegistroJaExiste {
>>>>>>> bruno/master
			
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
		
<<<<<<< HEAD
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
=======
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
>>>>>>> bruno/master
			lista.add(indice,registro);
		}
	}
	
<<<<<<< HEAD
	private void removeDaLista ( ArrayList<Tabulavel> lista, String chave ) throws RegistroInexistente {
=======
	private void removeDaLista ( ArrayList<Tabelavel> lista, String chave ) throws RegistroInexistente {
>>>>>>> bruno/master
		
		int indice = retornaIndice(lista, chave);
		
		if ( indice == -1 ) {
			throw new RegistroInexistente(chave);
		}
		else {
			lista.set(indice, null);
		}
	}

<<<<<<< HEAD
	private void removeDaLista ( ArrayList<Tabulavel> lista, int indice ) throws RegistroInexistente {
=======
	private void removeDaLista ( ArrayList<Tabelavel> lista, int indice ) throws RegistroInexistente {
>>>>>>> bruno/master
		if ( indice < lista.size() ) {
			lista.set(indice, null);
		}
		else {
			throw new RegistroInexistente(" "+indice+" ");
		}
	}
	
<<<<<<< HEAD
	private Tabulavel consultaDaLista ( ArrayList<Tabulavel> lista, int indice ) throws RegistroInexistente {
		
		Tabulavel registro = lista.get(indice);
=======
	private Tabelavel consultaDaLista ( ArrayList<Tabelavel> lista, int indice ) throws RegistroInexistente {
		
		Tabelavel registro = lista.get(indice);
>>>>>>> bruno/master
		
		if ( registro == null ) {
			throw new RegistroInexistente("vazio");
		}
		
		return registro;
	}

	/*
	 * Classe para manipulação de Midia
	 */
	
    public void Insere ( Midia midia ) throws RegistroJaExiste{
<<<<<<< HEAD
		insereNaLista( (ArrayList) this.midia, (Tabulavel) midia);
=======
		insereNaLista( (ArrayList) this.midia, (Tabelavel) midia);
>>>>>>> bruno/master
	}
		
    public void ExcluiMidia ( String chave ) throws RegistroInexistente{
		removeDaLista( (ArrayList) this.midia, chave);
	}
	
    public void ExcluiMidia ( int indice ) throws RegistroInexistente{
		removeDaLista( (ArrayList) this.midia, indice);
	}
	
	public void Altera ( Midia midia) throws RegistroInexistente, RegistroJaExiste{
<<<<<<< HEAD
		alteraNaLista( (ArrayList) this.midia, (Tabulavel) midia);
=======
		alteraNaLista( (ArrayList) this.midia, (Tabelavel) midia);
>>>>>>> bruno/master
	}
	
	public Midia ConsultaMidia ( String chave ) throws RegistroInexistente{
		return (Midia) consultaDaLista( (ArrayList) this.midia, chave);
	}
	
	public Midia ConsultaMidia ( int indice ) throws RegistroInexistente{
		return (Midia) consultaDaLista( (ArrayList) this.midia, indice);
	}
	
	public LinkedList<Midia> ListMidia () {

        LinkedList<Midia> lista = new LinkedList<Midia>();
<<<<<<< HEAD
=======
        
>>>>>>> bruno/master
        Midia registro;
       
        for (int i = 0; i < midia.size(); i++) {
           
            registro = midia.get(i);
           
            if ( registro != null ) {
           
                lista.add(registro);
               
            }
           
        }
       
        return lista;
    }
	
	/*
	 * Classe para manipulação de Cliente
	 */
	
    public void Insere ( Cliente cliente ) throws RegistroJaExiste{
<<<<<<< HEAD
		insereNaLista( (ArrayList) this.cliente, (Tabulavel) cliente);
=======
		insereNaLista( (ArrayList) this.cliente, (Tabelavel) cliente);
>>>>>>> bruno/master
	}
		
    public void ExcluiCliente ( String chave ) throws RegistroInexistente{
		removeDaLista( (ArrayList) this.cliente, chave);
	}
	
    public void ExcluiCliente ( int indice ) throws RegistroInexistente{
		removeDaLista( (ArrayList) this.cliente, indice);
	}
	
	public void Altera ( Cliente cliente) throws RegistroInexistente, RegistroJaExiste{
<<<<<<< HEAD
		alteraNaLista( (ArrayList) this.cliente, (Tabulavel) cliente);
=======
		alteraNaLista( (ArrayList) this.cliente, (Tabelavel) cliente);
>>>>>>> bruno/master
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
	
	public void showMidia ( ) {
		
		Midia registro;
		
		for (int i = 0; i < midia.size(); i++) {
			
			registro = midia.get(i);
			
			if ( registro != null ) {
							
				System.out.println( "Mídia " + registro.getIndice() +
									" código " + registro.getCodigo() +
									" e descrição " + registro.getDescricao() + ".");
			
			}
			
		}
		
	}
<<<<<<< HEAD
	
=======
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
	 
>>>>>>> bruno/master
}
