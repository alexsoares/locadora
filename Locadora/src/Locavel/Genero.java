package Locavel;

import Banco.Tabelavel;


public class Genero implements  Tabelavel {

	private String nome;
	private String descricao;
	private String codigo;
	private int indice;
	
	
	
	public Genero(String codigo,String nome, String descricao){
		this.indice = -1;
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;

	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCodigo() {
		return this.codigo;
	}

	@Override
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

	
	public void setIndice(int indice) {
		this.indice = indice;
		
	}

	
	public int getIndice() {
		return this.indice;
	}	
	
}
