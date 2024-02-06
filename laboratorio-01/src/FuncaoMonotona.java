/**
 * Laboratório de Programação 2 - Lab01 
 * @author Rafael de Arruda Sobral
 */

/**
 * Uma função monótona é uma função que tem o mesmo comportamento crescente ou 
 * decrescente de valores. Quando todos os valores da função aumentam e não são iguais entre si, 
 * chamamos essa função de estritamente crescente. Quando todos os valores da função diminuem 
 * (e também não são iguais entre si) chamamos essa função de estritamente decrescente. 
 * É possível ter fortes indícios de uma função ser estritamente crescente ou decrescente observando 
 * alguns valores da função. Se todos os valores forem crescentes esta função pode vir a ser uma 
 * função monótona estritamente crescente. Se todos os valores forem decrescentes, esta função pode 
 * vir a ser uma função monótona estritamente decrescente. 
 * Faça um programa que receba 4 valores e retorne as mensagens 
 * "POSSIVELMENTE ESTRITAMENTE CRESCENTE" e "POSSIVELMENTE ESTRITAMENTE DECRESCENTE" 
 * se os valores recebidos forem, respectivamente, todos crescentes e diferentes entre si, 
 * todos decrescentes e diferentes entre si. Caso nenhuma dessas condições seja satisfeita, 
 * imprima a mensagem: "FUNCAO NAO ESTRITAMENTE CRES/DECR".
 */

import java.util.Scanner;

public class FuncaoMonotona {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		int num4 = sc.nextInt();

		if ((num1 < num2) && (num2 < num3) && (num3 < num4)) {
			System.out.println("POSSIVELMENTE ESTRITAMENTE CRESCENTE");
		} else if ((num1 > num2) && (num2 > num3) && (num3 > num4)) {
			System.out.println("POSSIVELMENTE ESTRITAMENTE DECRESCENTE");
		} else {
			System.out.println("FUNCAO NAO ESTRITAMENTE CRES/DECR");
		}

	}
}
