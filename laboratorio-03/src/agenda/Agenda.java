/**
 * Laboratório de Programação 2 - Lab03
 * @author Rafael de Arruda Sobral
 */

package agenda;

/**
 * A classe Agenda mantém uma lista de contatos com posições.
 * É possível cadastrar, listar, exibir e favoritar contatos.
 * Possui limitação de 100 contatos na agenda e de 10 contatos favoritos.
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 100;
	private Contato[] contatos;
	private Contato[] contatosFavoritos;

	/**
	 * Construtor da classe.
	 * Cria uma agenda vazia com 100 posições para contatos e
	 * 10 posições para contatos favoritos.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.contatosFavoritos = new Contato[10];
	}
	
	/**
	 * Cadastra um contato em uma posição válida.
	 * Um cadastro em uma posição que já existe sobrescreve o anterior.
	 * @param posicao - posição do contato.
	 * @param nome - primeiro nome do contato.
	 * @param sobrenome - sobrenome do contato.
	 * @param telefone - telefone do contato.
	 * @return uma mensagem de posição inválida ou de contato inválido,
	 * ou ainda de contato já cadastrado ou de cadastro realizado.
	 */
	public String cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		Contato contato = new Contato(nome, sobrenome, telefone);
		if (posicao <= 0 || posicao > 100) {
			return "POSIÇÃO INVÁLIDA";
		} if (nome.isBlank() || nome.isEmpty() || sobrenome.isBlank() || sobrenome.isEmpty() || 
				telefone.isBlank() || telefone.isEmpty()) {
			return "CONTATO INVÁLIDO";
		}
		for (Contato elemento: this.contatos) {
			if (elemento != null && elemento.equals(contato)) {
				return "CONTATO JÁ CADASTRADO";
			}
		}
		this.contatos[posicao - 1] = contato;
		return "CADASTRO REALIZADO";
	}
	
	/**
	 * Lista todos os nomes e sobrenomes dos contatos cadastrados na agenda.
	 * @return uma string com os nomes e sobrenomes dos contatos.
	 */
	public String listaContatos() {
		String lista = "";
		for (int i = 0; i < this.contatos.length; i++) {
			if (this.contatos[i] != null) {
				lista += (i + 1) + " - " + this.contatos[i].getNome() + 
							" " + this.contatos[i].getSobrenome() + "\n";
			}
		}
		return lista.trim();
	}

	/**
	 * Exibe os dados de um contato específico, seja favorito ou não.
	 * @param posicao - a posição do contato na agenda.
	 * @return uma string com os dados do contato (favorito ou não),
	 * ou uma mensagem de erro se a posição é inválida.
	 */
	public String exibeContato(int posicao) {
		if (this.contatos[posicao - 1] == null) {
			return "POSIÇÃO INVÁLIDA!";
		} else {
			boolean seFavorito = false;
			for (int i = 0; i < this.contatosFavoritos.length; i++) {
				if (this.contatosFavoritos[i] == (this.contatos[posicao - 1])) {
					seFavorito = true;
				}
			}
			if (seFavorito) {
				return "❤️ " + this.contatos[posicao - 1].toString();
			}
			return this.contatos[posicao - 1].toString();
		}
	}
	
	/**
	 * Lista todos os contatos (nome e sobrenome) favoritos da agenda.
	 * @return uma string com os contatos favoritos.
	 */
	public String listaFavoritos() {
		String lista = "";
		for (int i = 0; i < this.contatosFavoritos.length; i++) {
			if (this.contatosFavoritos[i] != null) {
				lista += (i + 1) + " - " + this.contatosFavoritos[i].getNome() + 
							" " + this.contatosFavoritos[i].getSobrenome() + "\n";
			}
		}
		return lista.trim();
	}
	
	/**
	 * Adiciona um novo contato como favorito em uma posição válida da agenda.
	 * @param indiceContato - o índice do contato a ser favoritado.
	 * @param indiceFavorito - o índice na lista de favoritos onde o contato será adicionado.
	 * @return uma string com uma mensagem informando o resultado da ação.
	 */
	public String adicionaFavorito(int indiceContato, int indiceFavorito) {
		if (indiceContato >= 1 && indiceContato <= 100) {
			if (indiceFavorito >= 1 && indiceFavorito <= 10) {
				if (this.contatos[indiceContato - 1] != null) {
					boolean contatoIgual = false;
					for (int i = 0; i < this.contatosFavoritos.length; i++) {
						if (this.contatosFavoritos[i] == this.contatos[indiceContato - 1]) {
							contatoIgual = true;
						}
					} if (!contatoIgual) {
						this.contatosFavoritos[indiceFavorito - 1] = this.contatos[indiceContato - 1];
						return "CONTATO FAVORITADO NA POSIÇÃO " + indiceFavorito + "!";
					} else {
						return "CONTATO JÁ FAVORITO";
					}
				} else {
					return "CONTATO NÃO CADASTRADO";
				}
			} else {
				return "POSIÇÃO DE FAVORITO INVÁLIDA";
			}
		} else {
			return "POSIÇÃO DE CONTATO INVÁLIDA";
		}
	}
	
	/**
	 * Remove um contato da lista de favoritos.
	 * @param indiceFavorito - o índice na lista de favoritos onde o contato foi favoritado.
	 * @throws IndexOutOfBoundsException caso o índice seja inválido.
	 */
	public void removeFavorito(int indiceFavorito) {
		if (indiceFavorito >= 1 && indiceFavorito <= 10) {
			this.contatosFavoritos[indiceFavorito - 1] = null;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

}
