/**
 * Laboratório de Programação 2 - Lab01 
 * @author Rafael de Arruda Sobral
 */

/**
 * Wally mudou de nome. Felizmente, para a Interpol, ele adotou um novo nome qualquer de 5 letras. 
 * Para ajudar a desmascarar Wally, faça um programa que leia listas contendo nomes de pessoas. 
 * E imprima o último nome que pode ser o novo nome de Wally. Se não existir nenhum nome possível, 
 * imprima apenas o caractere ?. O programa termina quando encontrar uma linha com a palavra wally. 
 * Veja o exemplo:
 * Entrada:
 * diego thiago arthur pedro abdias
 * isaac matheus jorge joao nestor
 * avelange ezequiel thor epaminondas
 * wally
 * Saída:
 * pedro
 * jorge
 * ?
 */

import java.util.Scanner;

public class Wally {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String nomes = "";
		
		while (true) {
			nomes = sc.nextLine();
			if (nomes.equals("wally")) {
				break;
			} else {
				String[] lista = nomes.split(" ");
				for (int i = lista.length - 1; i >= 0; i--) {
					if (lista[i].length() == 5) {
						System.out.println(lista[i]);
						break;
					} else if (lista[i].length() != 5 && lista[i] == lista[0]) {
						System.out.println("?");
					}
				}
			}
		}

	}
}
