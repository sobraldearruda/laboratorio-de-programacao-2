/**
 * Laboratório de Programação 2 - Lab03
 * @author Rafael de Arruda Sobral
 */

package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus de texto para manipular uma agenda de contatos.
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo.
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}
		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
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
						"(C)adastrar Contato\n" + 
						"(L)istar Contatos\n" + 
						"(E)xibir Contato\n" + 
						"(F)avoritos\n" + 
						"(A)dicionar Favorito\n" + 
						"(R)emover Favorito\n" + 
						"(S)air\n" + 
						"\n" + 
						"Opção: ");
		return scanner.nextLine().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * @param opcao - opção digitada.
	 * @param agenda - a agenda.
	 * @param scanner - o scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda, scanner);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "F":
			listaFavoritos(agenda);
			break;
		case "A":
			adicionaFavorito(agenda, scanner);
			break;
		case "R":
			removeFavorito(agenda, scanner);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("OPÇÃO INVÁLIDA!");
		}
	}
	
	/**
	 * Cadastra um contato na agenda.
	 * @param agenda - a agenda.
	 * @param scanner - o scanner para pedir informações do contato.
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosição na agenda: ");
		int posicao = Integer.parseInt(scanner.nextLine());
		System.out.print("\nNome: ");
		String nome = scanner.nextLine();
		System.out.print("\nSobrenome: ");
		String sobrenome = scanner.nextLine();
		System.out.print("\nTelefone: ");
		String telefone = scanner.nextLine();
		String cadastro = agenda.cadastraContato(posicao, nome, sobrenome, telefone);
		System.out.println(cadastro);
	}

	/**
	 * Imprime uma lista de contatos da agenda.
	 * @param agenda - a agenda.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println("\nLista de contatos: ");
		System.out.println(agenda.listaContatos());
	}

	/**
	 * Exibe os detalhes de um dos contatos da agenda.
	 * @param agenda - a agenda.
	 * @param scanner - o scanner para capturar o contato.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nQual contato: ");
		int posicao = Integer.parseInt(scanner.nextLine());
		String contato = agenda.exibeContato(posicao);
		System.out.println("Dados do contato:\n" + contato);
	}
	
	/**
	 * Lista os contatos (nome e sobrenome) favoritos da agenda.
	 * @param agenda - a agenda.
	 */
	private static void listaFavoritos(Agenda agenda) {
		System.out.println("\nLista de favoritos: ");
		System.out.println(agenda.listaFavoritos());
	}
	
	/**
	 * Adiciona um novo contato como favorito em uma posição válida da agenda.
	 * @param agenda - a agenda.
	 * @param scanner - o scanner para capturar as opções.
	 */
	private static void adicionaFavorito(Agenda agenda, Scanner scanner) {
		System.out.print("\nQual contato: ");
		int indiceContato = Integer.parseInt(scanner.nextLine());
		System.out.print("\nPosição na agenda: ");
		int indiceFavorito = Integer.parseInt(scanner.nextLine());
		String favorito = agenda.adicionaFavorito(indiceContato, indiceFavorito);
		System.out.println(favorito);
	}
	
	/**
	 * Remove um contato da lista de favoritos.
	 * @param agenda - a agenda.
	 * @param scanner - o scanner para capturar a posição do favorito.
	 */
	private static void removeFavorito(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosição na agenda: ");
		int indiceFavorito = Integer.parseInt(scanner.nextLine());
		agenda.removeFavorito(indiceFavorito);
	}

	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}

	/**
	 * Lê uma agenda de um arquivo CSV.
	 * @param arquivoContatos - o caminho para o arquivo.
	 * @param agenda - a agenda que deve ser populada com os dados.
	 * @throws IOException - caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}
	
}
