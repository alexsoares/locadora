package Banco;

import java.util.ArrayList;
import java.util.LinkedList;

import Locavel.Midia;

public class BancoMidia extends Banco {

	ArrayList<Midia> midia = new ArrayList<Midia>();
	
	/*
	 * Classe para manipulação de Midia
	 */
	
    public void Insere ( Midia midia ) throws RegistroJaExiste{
		insereNaLista( (ArrayList) this.midia, (Tabelavel) midia);
	}
		
    public void Exclui ( String chave ) throws RegistroInexistente{
		removeDaLista( (ArrayList) this.midia, chave);
	}
	
    public void Exclui ( int indice ) throws RegistroInexistente{
		removeDaLista( (ArrayList) this.midia, indice);
	}
	
	public void Altera ( Midia midia) throws RegistroInexistente, RegistroJaExiste{
		alteraNaLista( (ArrayList) this.midia, (Tabelavel) midia);
	}
	
	public Midia Consulta ( String chave ) throws RegistroInexistente{
		return (Midia) consultaDaLista( (ArrayList) this.midia, chave);
	}
	
	public Midia Consulta ( int indice ) throws RegistroInexistente{
		return (Midia) consultaDaLista( (ArrayList) this.midia, indice);
	}
	
	public LinkedList<Midia> RetornaLinkedList () {

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
	
}
