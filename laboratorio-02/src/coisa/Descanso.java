/**
 * Laboratório de Programação 2 - Lab02
 * @author Rafael de Arruda Sobral
 */

package coisa;

/**
 * A classe Descanso representa o estado de descanso de um aluno.
 * Para que o aluno seja considerado descansado, ele deve ter descansado
 * pelo menos 26 horas em uma semana.
 */
public class Descanso {
	
	private int horasDescanso;
	private int numeroSemanas;
	
	/**
	 * Construtor da classe.
	 * Inicia com 0 horas de descanso e 0 semanas.
	 */
	public Descanso() {
		this.horasDescanso = 0;
		this.numeroSemanas = 0;
	}
	
	/**
	 * Define a quantidade de horas de lazer registradas.
	 * @param horasDescanso - a quantidade de horas de descanso.
	 */
	public void defineHorasDescanso(int horasDescanso) {
		this.horasDescanso = horasDescanso;
	}
	
	/**
	 * Define a quantidade de semanas registradas.
	 * @param numeroSemanas - a quantidade de semanas.
	 */
	public void defineNumeroSemanas(int numeroSemanas) {
		this.numeroSemanas = numeroSemanas;
	}
	
	/**
	 * Retorna o estado de descanso do aluno.
	 * Se não há semanas registradas, retorna "cansado".
	 * Se a média de horas de descanso por semana é maior ou igual a 26, retorna "descansado".
	 * Caso contrário, retorna "cansado".
	 * @return estadoDescanso - o estado de descanso do aluno.
	 */
	public String getStatusGeral() {
		String estadoDescanso = "cansado";
		if (this.numeroSemanas == 0) {
			estadoDescanso = "cansado";
		} else if ((this.horasDescanso / this.numeroSemanas) >= 26) {
			estadoDescanso = "descansado";
		}
		return estadoDescanso;
	}

}
