/**
 * Laboratório de Programação 2 - Lab01 
 * @author Rafael de Arruda Sobral
 */

/**
 * Faça um programa que receba como entrada um número inteiro X e imprime como saída a mensagem 
 * “dobro: Y, triplo: Z” (sem as aspas). 
 * Por exemplo, para a entrada 2, a saída deve ser:
 * dobro: 4, triplo: 6
 */

import java.util.Scanner;

public class DobroTriplo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println("dobro: " + (num * 2) + ", triplo: " + (num * 3));
	}
}
