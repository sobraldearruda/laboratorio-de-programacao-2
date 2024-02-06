/**
 * Laboratório de Programação 2 - Lab01 
 * @author Rafael de Arruda Sobral
 */

/**
 * Um professor gerou uma lista com os alunos e as notas das provas (0 a 1000) desses alunos. 
 * Ele deseja saber informações gerais sobre a prova e pede que você calcule: maior nota, 
 * menor nota, média, número de alunos com nota acima ou igual a 700, número de alunos com nota 
 * abaixo de 700. O programa para ao ler uma linha com um traço (-). 
 * Veja o exemplo abaixo para entender como deve ficar a saída do seu programa. 
 * Imprima sempre a média truncada.
 * Entrada:
 * pedro 1000
 * arthur 550
 * ana 920
 * jorge 700
 * -
 * Saída:
 * maior: 1000
 * menor: 550
 * media: 792
 * acima: 3
 * abaixo: 1
 */

import java.util.Scanner;

public class Resultados {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int maior = Integer.MIN_VALUE;
		int menor = Integer.MAX_VALUE;
		int cont = 0;
		int soma = 0;
		int media = 0;
		int acima = 0;
		int abaixo = 0;

		while (true) {
			String dados = sc.nextLine();
			if (dados.equals("-")) {
				break;
			} else {
				String[] lista = dados.split(" ");
				int numero = Integer.parseInt(lista[1]);
				soma += numero;
				cont++;
				media = soma / cont;
				if (numero > maior) {
					maior = numero;
				} if (numero < menor) {
					menor = numero;
				} if (numero >= 700) {
					acima++;
				} if (numero < 700) {
					abaixo++;
				}
			}
		}

		System.out.println("maior: " + maior);
		System.out.println("menor: " + menor);
		System.out.println("media: " + media);
		System.out.println("acima: " + acima);
		System.out.println("abaixo: " + abaixo);

	}
}
