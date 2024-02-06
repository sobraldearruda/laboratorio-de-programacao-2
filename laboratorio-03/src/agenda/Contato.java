/**
 * Laboratório de Programação 2 - Lab03
 * @author Rafael de Arruda Sobral
 */

package agenda;

/**
 * A classe Contato representa um contato com nome, sobrenome e telefone.
 */
public class Contato {
	
	private String nome;
	private String sobrenome;
	private String telefone;
	
	/**
	 * Construtor da classe.
	 * Cria um contato com nome, sobrenome e telefone.
	 * @param nome - o primeiro nome do contato.
	 * @param sobrenome - o sobrenome do contato.
	 * @param telefone - o telefone do contato.
	 */
	public Contato(String nome, String sobrenome, String telefone) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}
	
	/**
	 * Sobrescreve o método Equals.
	 * Compara um contato à outro para verificar se são iguais.
	 * @param igual - o objeto a ser comparado.
	 * @return true se for um contato igual, false caso contrário.
	 */
	@Override
	public boolean equals(Object igual) {
		String nomeCompleto = this.nome + this.sobrenome;
		Contato contatoIgual = (Contato) igual;
		if (nomeCompleto.equals(contatoIgual.outroNomeCompleto())) {
			return true;
		}
		return false;
	}
	
	private String outroNomeCompleto() {
		return this.nome + this.sobrenome;
	}
	
	/**
	 * Exibe apenas o primeiro nome do contato.
	 * @return o primeiro nome do contato.
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Exibe apenas o sobrenome do contato.
	 * @return o sobrenome do contato.
	 */
	public String getSobrenome() {
		return this.sobrenome;
	}
	
	/**
	 * Retorna uma string que representa o contato formatado.
	 * @return o contato formatado.
	 */
	@Override
	public String toString() {
		return this.nome + " " + this.sobrenome + "\n" + this.telefone;
	}
	
}
