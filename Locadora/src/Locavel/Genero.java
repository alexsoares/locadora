package Locavel;

import Banco.Tabulavel;


public class Genero implements  Tabulavel {

	private String nome;
	private String descricao;
	
	
	
	public Genero(String nome, String descricao){
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

	@Override
	public boolean comparaCampoChave(String chave) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String retornaValorChave() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setIndice(int indice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getIndice() {
		// TODO Auto-generated method stub
		return 0;
	}	
	
}
