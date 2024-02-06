/**
 * Laboratório de Programação 2 - Lab01 
 * @author Rafael de Arruda Sobral
 */

/**
 * Faça um programa que recebe 2 números de ponto flutuante (dica: nextFloat do Scanner) 
 * e que imprime “pass: True!” se a média desses dois números for maior ou igual a 7.0 e 
 * imprime “pass: False!” caso contrário.
 */

import java.util.Scanner;

public class Media {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		double nota1 = sc.nextFloat();
		double nota2 = sc.nextFloat();
		double media = (nota1 + nota2) / 2;

		if (media >= 7) {
			System.out.println("pass: True!");
		} else {
			System.out.println("pass: False!");
		}

	}
}
