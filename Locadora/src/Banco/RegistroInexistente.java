package Banco;

public class RegistroInexistente extends Exception {

	public RegistroInexistente(String chave) {
		super("Registro " + chave + " n�o existente.");
	}
	  
}
