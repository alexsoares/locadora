package Banco;

import java.util.ArrayList;
import java.util.LinkedList;

import Locavel.Item;
import Locavel.ItemEstoque;

public class BancoItem extends Banco {

	ArrayList<Item> item = new ArrayList<Item>();

	/*
	 * Classe para manipulação de Item
	 */
	
    public void Insere ( Item item ) throws RegistroJaExiste{
		insereNaLista( (ArrayList) this.item, (Tabelavel) item);
	}
		
    public void Exclui ( String chave ) throws RegistroInexistente{
		removeDaLista( (ArrayList) this.item, chave);
	}
	
    public void Exclui ( int indice ) throws RegistroInexistente{
		removeDaLista( (ArrayList) this.item, indice);
	}
	
	public void Altera ( Item item) throws RegistroInexistente, RegistroJaExiste{
		alteraNaLista( (ArrayList) this.item, (Tabelavel) item);
	}
	
	public Item Consulta ( String chave ) throws RegistroInexistente{
		return (Item) consultaDaLista( (ArrayList) this.item, chave);
	}
	
	public Item Consulta ( int indice ) throws RegistroInexistente{
		return (Item) consultaDaLista( (ArrayList) this.item, indice);
	}
	
	public LinkedList<Item> RetornaLinkedList () {
    	
        LinkedList<Item> lista = new LinkedList<Item>();
        
        Item registro;
        
        for (int i = 0; i < item.size(); i++) {
           
            registro = item.get(i);
           
            if ( registro != null ) {
           
                lista.addLast(registro);
               
            }
           
        }
        
        return lista;
    }

	public LinkedList<Item> ConsultaListItemLocavel () {
		
	    LinkedList<Item> lista = new LinkedList<Item>();
	    
	    Item registro;
	    
	    for (int i = 0; i < item.size(); i++) {
	       
	        registro = item.get(i);
	       
	        if ( registro != null ) {
	       
	        	if ( registro.getLocavel() ) {
	        	
	        		lista.addLast(registro);
	        	
	        	}
	           
	        }
	       
	    }
	    
	    return lista;
	
	}
	
	public LinkedList<ItemEstoque> ConsultaEstoque () {
		
		ArrayList<ItemEstoque> arrayItemEstoque = new ArrayList<ItemEstoque>();
	    LinkedList<ItemEstoque> lista = new LinkedList<ItemEstoque>();
	    
	    Item registroItem;
	    ItemEstoque itemEstoque;
	    
	    for (int i = 0; i < item.size(); i++) {
	       
	        registroItem = item.get(i);
	       
	        if ( registroItem != null ) {
	       
	        	if ( registroItem.getLocavel() ) {
	        	
	        		itemEstoque = new ItemEstoque(registroItem.getFilme(), registroItem.getMidia());
	        	
	        		try {
						insereNaLista( (ArrayList) arrayItemEstoque, (Tabelavel) itemEstoque);
					} catch (RegistroJaExiste e) {
						try {
							itemEstoque = (ItemEstoque) consultaDaLista((ArrayList) arrayItemEstoque, itemEstoque.getIndice());
						} catch (RegistroInexistente e1) {
							e1.printStackTrace();
						}
						itemEstoque.incrementeQuantidade();
					}
	        		
	        	}
	           
	        }
	       
	    }
	    
	    for (int i = 0; i < arrayItemEstoque.size(); i++) {
		       
	    	itemEstoque = arrayItemEstoque.get(i);
	        lista.addLast(itemEstoque);
	       
	    }
	    
	    return lista;
	
	}

}
