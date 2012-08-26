package RecursosHumanos;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Banco.Tabulavel;
public class Cliente extends Pessoa implements Tabulavel{

	public Cliente(String cpf, String nome, String cidade, int telefone, String email, String nascimento) throws ParseException {
		this.setCpf(cpf);
		this.setNome(nome);
		this.setCidade(cidade);
		this.setTelefone(telefone);
		this.setEmail(email);
		this.setNascimento(convert_data(nascimento));
	}

	
	private Date convert_data(String nascimento) throws ParseException{
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		Date teste = sd.parse(nascimento);
		return teste;
	}


	public boolean comparaCampo(String chave) {
		if ( this.getCPF() == chave ) {
			return true;
		}
		else {
			return false;
		}	}



	public String retornaValorChave() {
		return this.getCPF();
	}
}
