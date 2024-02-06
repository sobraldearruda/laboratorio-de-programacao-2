/**
 * Laboratório de Programação 2 - Lab01 
 * @author Rafael de Arruda Sobral
 */

/**
 * Para avaliar uma população de dados é comum olhar o comportamento e características 
 * de elementos que estão acima (ou abaixo) da média. Faça um programa que receba, 
 * em uma linha, uma lista de inteiros e que imprima, na saída, apenas os valores que estão 
 * acima da média.
 * Seu programa deve imprimir os resultados em uma única linha e na mesma ordem que foram 
 * inseridos. Valores iguais a média não devem ser impressos e considere que para toda entrada, 
 * haverá pelo menos um valor na saída. Veja o exemplo: 
 * Entrada: 5 2 4 3 1 Saída: 5 4
 */

import java.util.Scanner;

public class MaiorMedia {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String num = sc.nextLine();
		String[] numeros = num.split(" ");
		int[] n = new int[numeros.length];
		int soma = 0;

		for (int i = 0; i < numeros.length; i++) {
			n[i] = Integer.parseInt(numeros[i]);
			soma += n[i];
		}

		int media = (soma / numeros.length);
		int[] maior = new int[numeros.length];

		for (int i = 0; i < numeros.length; i++) {
			if (n[i] > media) {
				maior[i] += n[i];
				System.out.print(maior[i] + " ");
			}
		}

	}
}
