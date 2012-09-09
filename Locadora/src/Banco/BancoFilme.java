package Banco;

import java.util.ArrayList;
import java.util.LinkedList;

import Locavel.Filme;

public class BancoFilme extends Banco {

	ArrayList<Filme> filme = new ArrayList<Filme>();	
	
	/*
	 * Classe para manipulação de Filme
	 */
	
    public void Insere ( Filme filme ) throws RegistroJaExiste{
		insereNaLista( (ArrayList) this.filme, (Tabelavel) filme);
	}
		
    public void Exclui ( String chave ) throws RegistroInexistente{
		removeDaLista( (ArrayList) this.filme, chave);
	}
	
    public void Exclui ( int indice ) throws RegistroInexistente{
		removeDaLista( (ArrayList) this.filme, indice);
	}
	
	public void Altera ( Filme filme) throws RegistroInexistente, RegistroJaExiste{
		alteraNaLista( (ArrayList) this.filme, (Tabelavel) filme);
	}
	
	public Filme Consulta ( String chave ) throws RegistroInexistente{
		return (Filme) consultaDaLista( (ArrayList) this.filme, chave);
	}
	
	public Filme Consulta ( int indice ) throws RegistroInexistente{
		return (Filme) consultaDaLista( (ArrayList) this.filme, indice);
	}
	

    public LinkedList<Filme> RetornaLinkedList () {
    	
        LinkedList<Filme> lista = new LinkedList<Filme>();
        
        Filme registro;
        
        for (int i = 0; i < filme.size(); i++) {
           
            registro = filme.get(i);
           
            if ( registro != null ) {
           
                lista.addLast(registro);
               
            }
           
        }
        
        return lista;
    }

}
