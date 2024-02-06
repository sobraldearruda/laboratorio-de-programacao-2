/**
 * Laboratório de Programação 2 - Lab04
 * @author Rafael de Arruda Sobral
 */

package mrbet;

import java.util.Set;
import java.util.HashSet;
import java.util.Objects;

/**
 * A classe Campeonato representa um campeonato de futebol, com nome e número de participantes.
 */
public class Campeonato {
	
	/**
	 * Atributos da classe, representando o nome e o número de participantes de um campeonato,
	 * bem como um conjunto de times participantes de um campeonato e um contador de times
	 * participantes de um campeonato.
	 */
	private String nomeCampeonato;
	private int numParticipantes;
	private Set<Time> timesCampeonatos;
	private int contaTimesCampeonatos;
	
	/**
	 * Construtor da classe.
	 * Inicializa os atributos com os respectivos parâmetros e demais estados de início.
	 * @param nomeCampeonato - o nome de um campeonato.
	 * @param numParticipantes - o número de participantes de um campeonato.
	 */
	public Campeonato(String nomeCampeonato, int numParticipantes) {
		this.nomeCampeonato = nomeCampeonato;
		this.numParticipantes = numParticipantes;
		this.timesCampeonatos = new HashSet<>();
		this.contaTimesCampeonatos = 0;
	}
	
	/**
	 * Sobrescreve o hashCode do nome do campeonato, uma vez que cada campeonato é único.
	 * @return o hashCode do nome do campeonato.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.nomeCampeonato);
	}
	
	/**
	 * Sobrescreve o equals do nome do campeonato para fins de comparação de strings.
	 * @return true ou false para a comparação de nomes de campeonatos.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campeonato other = (Campeonato) obj;
		return Objects.equals(this.nomeCampeonato, other.nomeCampeonato);
	}
	
	/**
	 * Verifica a adição de um time em um campeonato, caso o número de participantes 
	 * não esteja além do limite.
	 * @param time - o time de futebol.
	 * @return true ou false para a adição do time em um campeonato.
	 */
	public boolean adicionaTimesCampeonatos(Time time) {
		if (this.contaTimesCampeonatos < this.numParticipantes) {
			this.timesCampeonatos.add(time);
			this.contaTimesCampeonatos++;
			return true;
		}
		return false;
	}
	
	/**
	 * Verifica se um time participa de um campeonato.
	 * @param time - o time de futebol.
	 * @return true ou false para a existência do time em um campeonato.
	 */
	public boolean verificaTimesCampeonatos(Time time) {
		return this.timesCampeonatos.contains(time);
	}
	
	/**
	 * Exibe apenas o nome de um campeonato.
	 * @return o nome do campeonato.
	 */
	public String getNomeCampeonato() {
		return this.nomeCampeonato;
	}
	
	/**
	 * Exibe apenas o número de participantes de um campeonato.
	 * @return o número de participantes do campeonato.
	 */
	public int getNumParticipantes() {
		return this.numParticipantes;
	}
	
	/**
	 * Representa em uma string formatada a quantidade de times participantes de um campeonato
	 * e o respectivo número máximo de participantes.
	 * @return uma string com o contador e o número máximo de participantes de um campeonato.
	 */
	@Override
	public String toString() {
		return this.contaTimesCampeonatos + "/" + this.numParticipantes;
	}
	
}
