package Locavel;

import Banco.Tabulavel;

public class Midia implements Tabulavel {

	String codigo;
	String descricao;
	
	public Midia ( String codigo, String descricao ) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public boolean comparaCampo(String chave) {
		if ( this.codigo == chave ) {
			return true;
		}
		else {
			return false;
		}
	}

	public String retornaValorChave() {
		return this.codigo;
	}

}
