package Locavel;

import java.util.Date;

import Banco.RegistroInexistente;

public class Filme extends Produto{
	
	private Date dataLancamento;
	private int faixaEtaria;
	private String sinopse;
	private Genero genero;
	
	public Filme(String nome, Double preco, Date dataLancamento, int faixaEtaria, String sinopse, String genero) throws RegistroInexistente {
		super(nome, preco);
		this.dataLancamento = dataLancamento;
		this.faixaEtaria = faixaEtaria;
		this.sinopse = sinopse;
		this.genero = buscaGenero(genero);

	}
	
	public Filme(String nome, Double preco, Date dataLancamento, int faixaEtaria, String sinopse, Genero genero) {
		super(nome, preco);
		this.dataLancamento = dataLancamento;
		this.faixaEtaria = faixaEtaria;
		this.sinopse = sinopse;
		this.genero = genero;

	}
	
	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public int getFaixaEtaria() {
		return faixaEtaria;
	}

	public void setFaixaEtaria(int faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	public Genero buscaGenero(String criterio) throws RegistroInexistente{
		Genero genero =  Run.Main.bancoGenero.Consulta(criterio);
		return genero;
		
	}

	public String toString(){
		return "Nome: " + this.getNome() + " | Sinopse : " + this.getSinopse();
	}
}
