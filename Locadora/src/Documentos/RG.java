package Documentos;
import java.util.Date;

public class RG extends Documento{
	private Date nascimento;

	public RG(int numero,Date nascimento) {
		super(numero);
		
		this.nascimento = nascimento;
		// TODO Auto-generated constructor stub
	}

}
