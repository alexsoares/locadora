package Banco;

public class RegistroInexistente extends Exception {

	private static final long serialVersionUID = -4290843788482263944L;

	public RegistroInexistente(String chave) {
		super("Registro " + chave + " não existente.");
	}
	  
}
