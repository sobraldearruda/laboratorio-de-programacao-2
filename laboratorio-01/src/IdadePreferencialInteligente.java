/**
 * Laboratório de Programação 2 - Lab01 
 * @author Rafael de Arruda Sobral
 */

import java.util.Scanner;

public class IdadePreferencialInteligente {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite a sua idade: ");
		int idade = sc.nextInt();

		if (idade >= 60) {
			System.out.println("Preferencial Idoso.");
		} else {
			System.out.println("Você está grávida?");
			sc.nextLine();
			String gravida = sc.nextLine().toLowerCase();
			if (gravida == "sim") {
				System.out.println("Preferencial Gestante.");
			} else {
				System.out.println("Está com crianças de colo? Quantas? ");
				int criancas = sc.nextInt();
				if (criancas > 0) {
					System.out.println("Preferencial, pois está com " + 
										criancas + " criança(s) de colo.");
				} else {
					System.out.println("Você tem " + idade + 
										" anos. Você ainda não pode usar o atendimento especial.");
				}
			}
		}
	}
	
}
