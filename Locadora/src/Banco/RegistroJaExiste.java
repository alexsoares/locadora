package Banco;

public class RegistroJaExiste extends Exception {

	private static final long serialVersionUID = -4413056336145690353L;

	public RegistroJaExiste(String chave) {
		super("Registro " + chave + " já existe.");
	}
	  
}
