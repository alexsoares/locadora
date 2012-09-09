package Locavel;

import java.util.Date;

import Banco.Tabelavel;
import RecursosHumanos.Cliente;

public class Locacao implements Tabelavel {

	private int indice;
	private String codigo;
	private Cliente cliente;
	private Item item;
	private Date dataLocacao;
	private Date dataDevolucao;
	
	public Locacao (Cliente cliente, Item item, Date dataLocacao) {
		this.indice = -1;
		this.codigo = "-1";
		this.cliente = cliente;
		this.item = item;
		this.dataLocacao = dataLocacao;
		this.dataDevolucao = null;
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
		return codigo;
	}

	public void setIndice(int indice) {
		this.indice = indice;
		this.codigo = Integer.toString(indice);
	}

	public int getIndice() {
		return indice;
	}
	
	public boolean verificaSeEstaLocado() {
		if ( dataDevolucao == null ) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public void devolucao (Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Item getItem() {
		return item;
	}

	public Date getDataLocacao() {
		return dataLocacao;
	}
	
}
