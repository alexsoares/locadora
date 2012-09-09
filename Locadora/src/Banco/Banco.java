package Banco;

import java.util.ArrayList;


/*
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
*/

public class Banco {
	
	//Map midias = new HashMap();
	//Map clientes = new HashMap();
	
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
	
	protected Tabelavel consultaDaLista ( ArrayList<Tabelavel> lista, String chave ) throws RegistroInexistente {
		
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
	
	protected void insereNaLista ( ArrayList<Tabelavel> lista, Tabelavel registro ) throws RegistroJaExiste {
			
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
		
	protected void alteraNaLista ( ArrayList<Tabelavel> lista, Tabelavel registro ) throws RegistroInexistente, RegistroJaExiste {
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
	
	protected void removeDaLista ( ArrayList<Tabelavel> lista, String chave ) throws RegistroInexistente {
		
		int indice = retornaIndice(lista, chave);
		
		if ( indice == -1 ) {
			throw new RegistroInexistente(chave);
		}
		else {
			lista.set(indice, null);
		}
	}

	protected void removeDaLista ( ArrayList<Tabelavel> lista, int indice ) throws RegistroInexistente {
		if ( indice < lista.size() ) {
			lista.set(indice, null);
		}
		else {
			throw new RegistroInexistente(" "+indice+" ");
		}
	}
	
	protected Tabelavel consultaDaLista ( ArrayList<Tabelavel> lista, int indice ) throws RegistroInexistente {
		
		Tabelavel registro = lista.get(indice);
		
		if ( registro == null ) {
			throw new RegistroInexistente("vazio");
		}
		
		return registro;
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
