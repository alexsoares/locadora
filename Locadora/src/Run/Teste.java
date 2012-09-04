package Run;

import java.util.ArrayList;


import Banco.*;
import Locavel.Midia;
import Locavel.Genero;

public class Teste {

	public static void main(String[] args) throws RegistroInexistente {
		
		Banco banco = new Banco();
		
		Genero g1 = new Genero("1","Teste", "Teste");
		Genero g2 = new Genero("2","Teste2", "Teste2");
		Genero g3 = new Genero("3","Teste3", "Teste3");
		Genero g4 = new Genero("3","Teste4", "Teste4");
		try {
			System.out.println("Show generos");
			banco.Insere(g1);
			banco.Insere(g2);
			banco.Insere(g3);
			banco.showGenero();
			System.out.println("Exclui genero codigo 1");
			banco.showGenero();
			
		} catch (RegistroJaExiste e) {
			System.out.println("(1) N�o deve passar aqui.");
		}

		try {
			banco.ExcluiGenero("2");
		} catch (RegistroInexistente e) {
			System.out.println("(5)  N�o deve passar aqui.");
		}

		try {
			banco.AlteraGenero(g2);
		} catch (RegistroInexistente e) {
			System.out.println("(8)  N�o deve passar aqui.");
		} catch (RegistroJaExiste e) {
			System.out.println("(8.0)  Midia j� existe.");
		}
		
	/*	
		Midia midia1 = new Midia("1", "Midia 1");
		Midia midia2 = new Midia("2", "Midia 2");
		Midia midia3 = new Midia("3", "Midia 3");
		Midia midia4 = new Midia("4", "Midia 4");
		midia4.setIndice(0);
		Midia midia5 = new Midia("2", "Midia 5");
		Midia midia = null;
		
		System.out.println("(0) inicio");

		try {
			banco.Insere(midia1);
			banco.Insere(midia2);
			banco.Insere(midia3);
		} catch (RegistroJaExiste e) {
			System.out.println("(1) N�o deve passar aqui.");
		}
		
		System.out.println("(2) inicio");

		try {
			banco.Insere(midia5);
		} catch (RegistroJaExiste e) {
			System.out.println("(3) Duplicidade.");
		}
		
		System.out.println("(4)  Show Midia.");
		
		banco.showMidia();

		System.out.println("(4.1) Exclui");

		try {
			banco.ExcluiMidia("2");
		} catch (RegistroInexistente e) {
			System.out.println("(5)  N�o deve passar aqui.");
		}

		System.out.println("(6) Show Midia.");
		
		banco.showMidia();

		System.out.println("(7) Altera");
		
		try {
			banco.Altera(midia5);
		} catch (RegistroInexistente e) {
			System.out.println("(8)  N�o deve passar aqui.");
		} catch (RegistroJaExiste e) {
			System.out.println("(8.0)  Midia j� existe.");
		}
		
		System.out.println("(8.1) Show Midia.");
		
		banco.showMidia();

		System.out.println("(9) Consulta.");
		
		try {
			banco.Altera(midia4);
		} catch (RegistroInexistente e) {
			System.out.println("(9.1)  N�o deve passar aqui.");
		} catch (RegistroJaExiste e) {
			System.out.println("(9.2)  Midia j� existe.");
		}
		
		banco.showMidia();

		System.out.println("(10) Consulta.");
		
		try {
			midia = banco.ConsultaMidia("2");
		} catch (RegistroInexistente e) {
			System.out.println("(10.1) Registro n�o existe.");
		}
		
		System.out.println("(100) FIM");
*/		
	}
	
}