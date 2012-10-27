package Locavel;

import java.util.Date;

import Banco.Tabelavel;

public class Item implements Tabelavel {

	private int indice;
	private String codigo_barra;
	private Filme filme;
	private Midia midia;
	private Date data_aquisicao;
	private boolean ativo;
	private boolean locavel;
	
	public Item( String codigo_barra, Filme filme, Midia midia,
		     Date data_aquisicao ) {
		this.indice = -1;
		this.codigo_barra = codigo_barra;
		this.filme = filme;
		this.midia = midia;
		this.data_aquisicao = data_aquisicao;
		this.ativo = true;
		this.locavel = true;
	}

	public String getCodigo_barra() {
		return codigo_barra;
	}

	public Filme getFilme() {
		return filme;
	}

	public Midia getMidia() {
		return midia;
	}

	public Date getData_aquisicao() {
		return data_aquisicao;
	}

	public boolean getLocavel() {
		if (ativo) {
			return locavel;
		}
		else {
			return ativo;
		}
	}
	
	public boolean comparaCampoChave(String chave) {
		if ( this.codigo_barra.equals(chave) ) {
			return true;
		}
		else {
			return false;
		}
	}

	public String retornaValorChave() {
		return codigo_barra;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public int getIndice() {
		return this.indice;
	}
	
	public void locar() {
		locavel = false;
	}
	
	public void devolver() {
		locavel = true;
	}
	
	public String toString(){
		return "Codigo: " + this.codigo_barra + " | Filme: " + this.filme + " | Data Aquisicao: " + this.data_aquisicao.toString();
	}

	public void setFilme(Filme filme2) {
		this.filme = filme;
	}
	
}
