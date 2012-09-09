package Banco;

import java.util.ArrayList;
import java.util.LinkedList;

import RecursosHumanos.Cliente;

public class BancoCliente extends Banco {

	ArrayList<Cliente> cliente = new ArrayList<Cliente>();
	
	/*
	 * Classe para manipulação de Cliente
	 */
	
    public void Insere ( Cliente cliente ) throws RegistroJaExiste{
		insereNaLista( (ArrayList) this.cliente, (Tabelavel) cliente);
	}
		
    public void Exclui ( String chave ) throws RegistroInexistente{
		removeDaLista( (ArrayList) this.cliente, chave);
	}
	
    public void Exclui ( int indice ) throws RegistroInexistente{
		removeDaLista( (ArrayList) this.cliente, indice);
	}
	
	public void Altera ( Cliente cliente) throws RegistroInexistente, RegistroJaExiste{
		alteraNaLista( (ArrayList) this.cliente, (Tabelavel) cliente);
	}
	
	public Cliente Consulta ( String chave ) throws RegistroInexistente{
		return (Cliente) consultaDaLista( (ArrayList) this.cliente, chave);
	}
	
	public Cliente Consulta ( int indice ) throws RegistroInexistente{
		return (Cliente) consultaDaLista( (ArrayList) this.cliente, indice);
	}
	

    public LinkedList<Cliente> RetornaLinkedList () {
    	
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
	
}
