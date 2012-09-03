package Banco;

public class RegistroJaExiste extends Exception {

<<<<<<< HEAD
=======
	private static final long serialVersionUID = -4413056336145690353L;

>>>>>>> bruno/master
	public RegistroJaExiste(String chave) {
		super("Registro " + chave + " já existe.");
	}
	  
}
