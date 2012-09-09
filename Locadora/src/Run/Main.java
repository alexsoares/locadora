package Run;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Banco.*;
import Locavel.*;
import RecursosHumanos.*;

public class Main {

	public static BancoCliente bancoCliente = new BancoCliente();
	public static BancoGenero bancoGenero = new BancoGenero();
	public static BancoFilme bancoFilme = new BancoFilme();
	public static BancoMidia bancoMidia = new BancoMidia();
	public static BancoItem bancoItem = new BancoItem();
	public static BancoLocacao bancoLocacao = new BancoLocacao();

	public static void main(String[] args) throws ParseException {
		
		InicializaBanco();
		
		@SuppressWarnings("unused")
		Visual.Home paginaInicial = new Visual.Home();
		
	}
	
	public static void InicializaBanco() throws ParseException {
		
		SimpleDateFormat FormatDate = new SimpleDateFormat("dd/MM/yyyy");
		
		Cliente cliente1 = new Cliente("Bruno Schionato", "1111111","Saudade",1242, "Centro", "Cosmopolis", "schionato@gmail.com", FormatDate.parse("22/09/1987"));
		Cliente cliente2 = new Cliente("Aldair Roberto", "2331111","Paulisa",2356, "Centro", "São Paulo", "aldair@gmail.com", FormatDate.parse("01/05/1980"));
		Cliente cliente3 = new Cliente("Juliana Aparecida", "233567","7 de Setembro",9856, "Bela Vista", "Holambra", "juliana@ms.com", FormatDate.parse("28/05/1981"));
		
		Genero genero1 = new Genero("Drama", "Filme Dramático");
		Genero genero2 = new Genero("Terror", "Filme de Terror");
		
		Filme filme1 = new Filme("E o Vento Levou", 15.0, FormatDate.parse("01/05/1980"), 0, "Sinopse do FIlme...", genero1 );
		Filme filme2 = new Filme("As Horas", 15.0, FormatDate.parse("01/03/2004"), 12, "Sinopse do FIlme...", genero1 );
		Filme filme3 = new Filme("Sexta-Feira 13", 15.0, FormatDate.parse("02/11/1995"), 16, "Sinopse do FIlme...", genero2 );
		
		Midia midia1 = new Midia("DVD", "Digital Video Disc");
		Midia midia2 = new Midia("Blu-Ray", "Raio Azul");
		
		Item item1 = new Item("000001", filme1, midia1, FormatDate.parse("01/03/2011"));
		Item item2 = new Item("000002", filme1, midia1, FormatDate.parse("02/03/2011"));
		Item item3 = new Item("000003", filme1, midia1, FormatDate.parse("03/03/2011"));
		Item item4 = new Item("000004", filme1, midia2, FormatDate.parse("03/03/2011"));
		Item item5 = new Item("000005", filme2, midia1, FormatDate.parse("04/03/2011"));
		Item item6 = new Item("000006", filme3, midia1, FormatDate.parse("05/03/2011"));
		Item item7 = new Item("000007", filme3, midia1, FormatDate.parse("06/03/2011"));
		Item item8 = new Item("000008", filme3, midia2, FormatDate.parse("06/03/2011"));
		
		try {
			
			bancoCliente.Insere(cliente1);
			bancoCliente.Insere(cliente2);
			bancoCliente.Insere(cliente3);
			
			bancoGenero.Insere(genero1);
			bancoGenero.Insere(genero2);
			
			bancoFilme.Insere(filme1);
			bancoFilme.Insere(filme2);
			bancoFilme.Insere(filme3);
			
			bancoMidia.Insere(midia1);
			bancoMidia.Insere(midia2);
			
			bancoItem.Insere(item1);
			bancoItem.Insere(item2);
			bancoItem.Insere(item3);
			bancoItem.Insere(item4);
			bancoItem.Insere(item5);
			bancoItem.Insere(item6);
			bancoItem.Insere(item7);
			bancoItem.Insere(item8);
			
		} catch (RegistroJaExiste e) {
			e.printStackTrace();
		}
	}

}

