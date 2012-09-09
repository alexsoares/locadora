package Banco;

import java.util.ArrayList;
import java.util.LinkedList;

import Locavel.Genero;

public class BancoGenero extends Banco {

	ArrayList<Genero> genero = new ArrayList<Genero>();	
	
	/*
	 * Classe para manipulação de Genero
	 */
	
    public void Insere ( Genero genero ) throws RegistroJaExiste{
		insereNaLista( (ArrayList) this.genero, (Tabelavel) genero);
	}
		
    public void Exclui ( String chave ) throws RegistroInexistente{
		removeDaLista( (ArrayList) this.genero, chave);
	}
	
    public void Exclui ( int indice ) throws RegistroInexistente{
		removeDaLista( (ArrayList) this.genero, indice);
	}
	
	public void Altera ( Genero genero) throws RegistroInexistente, RegistroJaExiste{
		alteraNaLista( (ArrayList) this.genero, (Tabelavel) genero);
	}
	
	public Genero Consulta ( String chave ) throws RegistroInexistente{
		return (Genero) consultaDaLista( (ArrayList) this.genero, chave);
	}
	
	public Genero Consulta ( int indice ) throws RegistroInexistente{
		return (Genero) consultaDaLista( (ArrayList) this.genero, indice);
	}
	
    public LinkedList<Genero> RetornaLinkedList () {
    	
        LinkedList<Genero> lista = new LinkedList<Genero>();
        
        Genero registro;
        
        for (int i = 0; i < genero.size(); i++) {
           
            registro = genero.get(i);
           
            if ( registro != null ) {
           
                lista.addLast(registro);
               
            }
           
        }
        
        return lista;
    }
	
}
