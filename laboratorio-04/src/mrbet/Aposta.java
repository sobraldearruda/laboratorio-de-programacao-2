/**
 * Laboratório de Programação 2 - Lab04
 * @author Rafael de Arruda Sobral
 */

package mrbet;

/**
 * A classe Aposta representa uma aposta em um time em um campeonato, com possível colocação
 * e um valor para a aposta.
 */
public class Aposta {
	
	/**
	 * Atributos da classe, representando o código identificador do time, o nome do campeonato,
	 * a colocação e o valor da aposta.
	 */
	private String codigo;
	private String nomeCampeonato;
	private int colocacao;
	private double valorAposta;
	
	/**
	 * Construtor da classe.
	 * Inicializa os atributos com os respectivos parâmetros.
	 * @param codigo - o identificador do time.
	 * @param nomeCampeonato - o nome do campeonato.
	 * @param colocacao - a colocação do time no campeonato.
	 * @param valorAposta - o valor da aposta.
	 */
	public Aposta(String codigo, String nomeCampeonato, int colocacao, double valorAposta) {
		this.codigo = codigo;
		this.nomeCampeonato = nomeCampeonato;
		this.colocacao = colocacao;
		this.valorAposta = valorAposta;
	}
	
	/**
	 * Exibe apenas o código identificador do time em que se aposta.
	 * @return o código identificador do time apostado.
	 */
	public String getCodigoAposta() {
		return this.codigo;
	}

	/**
	 * Exibe apenas o nome do campeonato em que se aposta.
	 * @return o nome do campeonato apostado.
	 */
	public String getNomeCampeonatoAposta() {
		return this.nomeCampeonato;
	}
	
	/**
	 * Exibe apenas a colocação final do time em um campeonato.
	 * @return a colocação final no campeonato.
	 */
	public int getColocacaoAposta() {
		return this.colocacao;
	}
	
	/**
	 * Exibe apenas o valor de uma aposta em um time.
	 * @return o valor da aposta feita.
	 */
	public double getValorAposta() {
		return this.valorAposta;
	}
	
	/**
	 * Representa em uma string formatada o nome do campeonato, a colocação do time e o valor da aposta.
	 * @return uma string com o nome do campeonato, a colocação do time e o valor da aposta.
	 */
	public String toString() {
        return this.nomeCampeonato + "\n"
        		+ this.colocacao + "/"
        		+ "\nR$ " + this.valorAposta;
    }
	
}
