/**
 * Laboratório de Programação 2 - Lab01 
 * @author Rafael de Arruda Sobral
 */

/**
 * Construa um programa de calculadora onde o usuário irá escolher uma das 4 operações básicas 
 * abaixo como ação do usuário. Caso o usuário digite um dos símbolos: +-*\ o programa deve 
 * consumir duas entradas seguintes. Se o usuário digitar qualquer outra entrada, deve apenas exibir: 
 * ENTRADA INVALIDA e terminar o programa.
 * Após consumir as duas entradas, o programa deve exibir o resultado da operação com a mensagem: 
 * RESULTADO: X onde X é o resultado da operação sobre as duas entradas de valores. 
 * Isto será exibido em todas as situações, exceto quando o segundo valor de entrada for 0 
 * e a operação for de divisão. Neste caso, é exibida a mensagem "ERRO".
 */

import java.util.Scanner;

public class Calculadora {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String operacao = sc.nextLine();

		if (operacao.equals("+")) {
			double num1 = sc.nextFloat();
			double num2 = sc.nextFloat();
			System.out.println("RESULTADO: " + (num1 + num2));
		} else if (operacao.equals("-")) {
			double num1 = sc.nextFloat();
			double num2 = sc.nextFloat();
			System.out.println("RESULTADO: " + (num1 - num2));
		} else if (operacao.equals("*")) {
			double num1 = sc.nextFloat();
			double num2 = sc.nextFloat();
			System.out.println("RESULTADO: " + (num1 * num2));
		} else if (operacao.equals("/")) {
			double num1 = sc.nextFloat();
			double num2 = sc.nextFloat();
			if (num2 == 0) {
				System.out.println("ERRO");
			} else {
				System.out.println("RESULTADO: " + (num1 / num2));
			}
		} else {
			System.out.println("ENTRADA INVALIDA");
		}

	}
}
