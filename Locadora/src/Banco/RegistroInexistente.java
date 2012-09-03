package Banco;

public class RegistroInexistente extends Exception {

<<<<<<< HEAD
=======
	private static final long serialVersionUID = -4290843788482263944L;

>>>>>>> bruno/master
	public RegistroInexistente(String chave) {
		super("Registro " + chave + " não existente.");
	}
	  
}
