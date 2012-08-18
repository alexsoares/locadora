package Locavel;

import java.util.Date;

public class Filme extends Produto {
	
	private Date dataLancamento;
	private int faixaEtaria;
	private String sinopse;
	private Genero genero;
	private int quantidadeDisponivel;
	private int quantidadeLocada;
	private Boolean disponivel;

	
	public Filme(String nome, Double preco, int quantidade,Date dataLancamento, int faixaEtaria, String sinopse, Genero genero, int quantidadeDisponivel, int quantidadeLocada,Boolean disponivel) {
		super(nome, preco, quantidade);
		this.dataLancamento = dataLancamento;
		this.faixaEtaria = faixaEtaria;
		this.sinopse = sinopse;
		this.genero = genero;
		this.quantidadeDisponivel = quantidadeDisponivel;
		this.quantidadeLocada = quantidadeLocada;
		this.disponivel = disponivel;

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

	public int getQuantidadeDisponivel() {
		return quantidadeDisponivel;
	}

	public void setQuantidadeDisponivel(int quantidadeDisponivel) {
		this.quantidadeDisponivel = quantidadeDisponivel;
	}

	public int getQuantidadeLocada() {
		return quantidadeLocada;
	}

	public void setQuantidadeLocada(int quantidadeLocada) {
		this.quantidadeLocada = quantidadeLocada;
	}

	public Boolean getDisponivel() {
		return disponivel;
	}

	
}
