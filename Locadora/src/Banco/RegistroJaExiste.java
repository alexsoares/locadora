package Banco;

public class RegistroJaExiste extends Exception {

	public RegistroJaExiste(String chave) {
		super("Registro " + chave + " j� existe.");
	}
	  
}
