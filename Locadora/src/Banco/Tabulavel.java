package Banco;

public interface Tabulavel {

	public boolean comparaCampoChave(String chave);
	
	public String retornaValorChave();
	
	public void setIndice( int indice);
	
	public int getIndice();

}
