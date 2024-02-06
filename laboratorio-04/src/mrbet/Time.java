/**
 * Laboratório de Programação 2 - Lab04
 * @author Rafael de Arruda Sobral
 */

package mrbet;

import java.util.Objects;

/**
 * A classe Time representa um time de futebol com código identificador, nome e mascote.
 */
public class Time {
	
	/**
	 * Atributos da classe, representando o código identificador, o nome e o mascote do time.
	 */
	private String codigo;
	private String nome;
	private String mascote;
	
	/**
	 * Construtor da classe.
	 * Inicializa os atributos com os respectivos parâmetros.
	 * @param codigo - o identificador do time.
	 * @param nome - o nome do time.
	 * @param mascote - o mascote do time.
	 */
	public Time(String codigo, String nome, String mascote) {
		this.codigo = codigo;
		this.nome = nome;
		this.mascote = mascote;
	}
	
	/**
	 * Sobrescreve o hashCode do código identificador, uma vez que
	 * esse código deve ser único dentre os cadastros de times.
	 * @return o hashCode do código identificador.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.codigo);
	}
	
	/**
	 * Sobrescreve o equals do código identificador para fins de comparação de strings.
	 * @return true ou false para a comparação de códigos.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		return Objects.equals(this.codigo, other.codigo);
	}
	
	/**
	 * Exibe apenas o código identificador do time.
	 * @return o código identificador.
	 */
	public String getCodigo() {
		return this.codigo;
	}
	
	/**
	 * Exibe apenas o nome do time.
	 * @return o nome do time.
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Exibe apenas o mascote do time.
	 * @return o mascote do time.
	 */
	public String getMascote() {
		return this.mascote;
	}
	
	/**
	 * Representa em uma string formatada um time com seus respectivos atributos.
	 * @return uma string que representa um time.
	 */
	@Override
	public String toString() {
		return "[" + this.codigo + "] " + this.nome + " / " + this.mascote;
	}
	
}
