/**
 * Laboratório de Programação 2 - Lab04
 * @author Rafael de Arruda Sobral
 */

package mrbet;

import java.util.Scanner;

/**
 * Interface com menus de texto para manipular um sistema de campeonatos e apostas.
 */
public class MainMrBet {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MrBet mrBet = new MrBet();
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(scanner, mrBet, escolha);
		}
	}
	
	/**
	 * Exibe o menu e captura a escolha do usuário.
	 * @param scanner - captura da opção do usuário.
	 * @return o comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(M) Minha inclusão de times\n" + 
						"(R) Recuperar time\n" + 
						"(.) Adicionar campeonato\n" + 
						"(B) Bora incluir time em campeonato e Verificar se time está em campeonato\n" + 
						"(E) Exibir campeonatos que o time participa\n" + 
						"(T) Tentar a sorte e status\n" + 
						"(!) Já pode fechar o programa!\n" + 
						"\n" + 
						"Opção: ");
		return scanner.nextLine().toUpperCase();
	}
	
	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * @param scanner - para o caso do comando precisar de mais input.
	 * @param mrBet - o sistema de campeonatos e apostas.
	 * @param opcao - a opção digitada.
	 */
	private static void comando(Scanner scanner, MrBet mrBet, String opcao) {
		switch (opcao) {
		case "M":
			incluiTimes(scanner, mrBet);
			break;
		case "R":
			recuperaTimes(scanner, mrBet);
			break;
		case ".":
			adicionaCampeonato(scanner, mrBet);
			break;
		case "B":
			incluiVerificaTimeCampeonato(scanner, mrBet);
			break;
		case "E":
			exibeTimeCampeonatoParticipante(scanner, mrBet);
			break;
		case "T":
			tentaSorteStatus(scanner, mrBet);
			break;
		case "!":
			sai();
			break;
		default:
			System.out.println("OPÇÃO INVÁLIDA!");
		}
	}
	
	/**
	 * Cadastra times.
	 * @param scanner - o scanner para pedir informações do usuário.
	 * @param mrBet - o sistema de campeonatos e apostas.
	 */
	private static void incluiTimes(Scanner scanner, MrBet mrBet) {
		System.out.print("\nCódigo: ");
		String codigo = scanner.nextLine();
		System.out.print("\nNome: ");
		String nome = scanner.nextLine();
		System.out.print("\nMascote: ");
		String mascote = scanner.nextLine();
		String cadastro = mrBet.incluiTimes(codigo, nome, mascote);
		System.out.println(cadastro);
	}
	
	/**
	 * Recupera times para exibição.
	 * @param scanner - o scanner para pedir informações do usuário.
	 * @param mrBet - o sistema de campeonatos e apostas.
	 */
	private static void recuperaTimes(Scanner scanner, MrBet mrBet) {
		System.out.print("\nCódigo: ");
		String codigo = scanner.nextLine();
		String exibeTime = mrBet.recuperaTimes(codigo);
		System.out.println(exibeTime);
	}
	
	/**
	 * Adiciona campeonatos para apostas em times.
	 * @param scanner - o scanner para pedir informações do usuário.
	 * @param mrBet - o sistema de campeonatos e apostas.
	 */
	private static void adicionaCampeonato(Scanner scanner, MrBet mrBet) {
		System.out.print("\nCampeonato: ");
		String nome = scanner.nextLine();
		System.out.print("\nParticipantes: ");
		int participantes = Integer.parseInt(scanner.nextLine());
		String cadastroCampeonato = mrBet.adicionaCampeonato(nome, participantes);
		System.out.println(cadastroCampeonato);
	}
	
	/**
	 * Inclui ou verifica times em um campeonato.
	 * @param scanner - o scanner para pedir informações do usuário.
	 * @param mrBet - o sistema de campeonatos e apostas.
	 */
	private static void incluiVerificaTimeCampeonato(Scanner scanner, MrBet mrBet) {
		System.out.print("\n(I) Incluir time em campeonato ou (V) Verificar se time está em campeonato? ");
		String opcao = scanner.nextLine().toUpperCase();
		if (opcao.equals("I")) {
			System.out.print("\nCódigo: ");
			String codigo = scanner.nextLine();
			System.out.print("\nCampeonato: ");
			String nome = scanner.nextLine();
			String timeIncluido = mrBet.incluiTimeCampeonato(codigo, nome);
			System.out.println(timeIncluido);
		}
		else if (opcao.equals("V")) {
			System.out.print("\nCódigo: ");
			String codigo = scanner.nextLine();
			System.out.print("\nCampeonato: ");
			String nome = scanner.nextLine();
			String timeVerificado = mrBet.verificaTimeCampeonato(codigo, nome);
			System.out.println(timeVerificado);
		}
		else {
			System.out.println("OPÇÃO INVÁLIDA!");
		}
	}
	
	/**
	 * Exibe campeonatos em que times participam.
	 * @param scanner - o scanner para pedir informações do usuário.
	 * @param mrBet - o sistema de campeonatos e apostas.
	 */
	private static void exibeTimeCampeonatoParticipante(Scanner scanner, MrBet mrBet) {
		System.out.print("\nTime: ");
		String time = scanner.nextLine();
		String lista = mrBet.exibeTimeCampeonatoParticipante(time);
		System.out.println(lista);
	}

	/**
	 * Aposta em times ou verifica status das apostas.
	 * @param scanner - o scanner para pedir informações do usuário.
	 * @param mrBet - o sistema de campeonatos e apostas.
	 */
	private static void tentaSorteStatus(Scanner scanner, MrBet mrBet) {
		System.out.print("\n(A) Apostar ou (S) Status das Apostas? ");
		String opcao = scanner.nextLine().toUpperCase();
		if (opcao.equals("A")) {
			System.out.print("\nCódigo: ");
			String codigo = scanner.nextLine();
			System.out.print("\nCampeonato: ");
			String nome = scanner.nextLine();
			System.out.print("\nColocação: ");
			int colocacao = Integer.parseInt(scanner.nextLine());
			System.out.print("\nValor: ");
			double valor = Double.parseDouble(scanner.nextLine());
			String cadastroAposta = mrBet.tentaSorteAposta(codigo, nome, colocacao, valor);
			System.out.println(cadastroAposta);
		}
		else if (opcao.equals("S")) {
			String status = mrBet.statusApostas();
			System.out.println(status);
		}
		else {
			System.out.println("OPÇÃO INVÁLIDA!");
		}
	}
	
	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.out.println("\nPor hoje é só, pessoal!");
		System.exit(0);
	}

}
