package Banco;

@SuppressWarnings("serial")
public class RegistroJaExiste extends Exception {

	public RegistroJaExiste(String chave) {
		super("Registro " + chave + " j� existe.");
	}
	  
}
