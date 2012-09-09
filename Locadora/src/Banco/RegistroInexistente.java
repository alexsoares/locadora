package Banco;

@SuppressWarnings("serial")
public class RegistroInexistente extends Exception {

	public RegistroInexistente(String chave) {
		super("Registro " + chave + " n�o existente.");
	}
	  
}
