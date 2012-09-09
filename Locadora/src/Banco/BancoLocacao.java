package Banco;

import java.util.ArrayList;
import java.util.LinkedList;

import Locavel.Locacao;

public class BancoLocacao extends Banco {

	ArrayList<Locacao> locacao = new ArrayList<Locacao>();
	
    public void Insere ( Locacao locacao ) throws RegistroJaExiste{
		insereNaLista( (ArrayList) this.locacao, (Tabelavel) locacao);
	}
    
    public void Exclui ( String chave ) throws RegistroInexistente{
		removeDaLista( (ArrayList) this.locacao, chave);
	}
	
    public void Exclui ( int indice ) throws RegistroInexistente{
		removeDaLista( (ArrayList) this.locacao, indice);
	}
	
	public void Altera ( Locacao locacao) throws RegistroInexistente, RegistroJaExiste{
		alteraNaLista( (ArrayList) this.locacao, (Tabelavel) locacao);
	}
	
	public Locacao Consulta ( String chave ) throws RegistroInexistente{
		return (Locacao) consultaDaLista( (ArrayList) this.locacao, chave);
	}
	
	public Locacao Consulta ( int indice ) throws RegistroInexistente{
		return (Locacao) consultaDaLista( (ArrayList) this.locacao, indice);
	}
	
	public LinkedList<Locacao> ListItem () {
    	
        LinkedList<Locacao> lista = new LinkedList<Locacao>();
        
        Locacao registro;
        
        for (int i = 0; i < locacao.size(); i++) {
           
            registro = locacao.get(i);
           
            if ( registro != null ) {
           
                lista.addLast(registro);
               
            }
           
        }
        
        return lista;
    }
	
}
