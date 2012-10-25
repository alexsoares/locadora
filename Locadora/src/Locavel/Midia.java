package Locavel;

import Banco.Tabelavel;

public class Midia implements Tabelavel {


	int indice;
	String codigo;
	String descricao;
	
	public Midia ( String codigo, String descricao ) {
		this.indice = -1;
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public void setIndice( int indice) {
		this.indice = indice;
	}
	
	public int getIndice() {
		return this.indice;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public boolean comparaCampoChave(String chave) {
		if ( this.codigo.equals(chave) ) {
			return true;
		}
		else {
			return false;
		}
	}

	public String retornaValorChave() {
		return this.codigo;
	}
	
	public String toString(){
		return "Codigo: " + this.codigo + " | Descricao: " +  this.descricao;
	}

}
