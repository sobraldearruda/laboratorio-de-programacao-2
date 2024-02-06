/**
 * Laboratório de Programação 2 - Lab02
 * @author Rafael de Arruda Sobral
 */

package coisa;

/**
 * A classe RegistroTempoOnline mantém a informação sobre a quantidade de horas
 * dedicada a uma disciplina. Espera-se que o aluno dedique o dobro de x tempo online
 * para realizar a disciplina.
 */
public class RegistroTempoOnline {
	
	private String nomeDisciplina;
	private int tempoGastoOnline;
	private int tempoOnlineEsperado;
	
	/**
	 * Primeiro construtor da classe.
	 * Recebe o nome da disciplina e define um valor padrão de tempo online esperado.
	 * @param nomeDisciplina - o nome da disciplina.
	 */
	public RegistroTempoOnline(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnlineEsperado = 120;
	}
	
	/**
	 * Segundo construtor da classe.
	 * Recebe o nome da disciplina e o tempo online esperado em horas.
	 * Inicia o tempo gasto online com 0 horas.
	 * @param nomeDisciplina - o nome da disciplina.
	 * @param tempoOnlineEsperado - o tempo online esperado em horas.
	 */
	public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnlineEsperado = tempoOnlineEsperado;
		this.tempoGastoOnline = 0;
	}
	
	/**
	 * Incrementa o tempo online gasto pelo aluno para a disciplina.
	 * @param tempoGastoOnline - o tempo online gasto em horas.
	 */
	public void adicionaTempoOnline(int tempoGastoOnline) {
		this.tempoGastoOnline += tempoGastoOnline;
	}
	
	/**
	 * Verifica se o aluno atingiu a meta de tempo online para a disciplina,
	 * em que o tempo gasto online deve ser maior ou igual ao tempo online esperado.
	 * @return true se o aluno atingiu a meta de tempo online, false caso contrário.
	 */
	public boolean atingiuMetaTempoOnline() {
		if (this.tempoGastoOnline >= this.tempoOnlineEsperado) {
			return true;
		}
		return false;
	}
	
	/**
	 * Retorna uma string que representa o registro de tempo online.
	 * @return uma string com o nome da disciplina, o tempo online gasto
	 * e o tempo online esperado.
	 */
	@Override
	public String toString() {
		return this.nomeDisciplina + " " 
				+ this.tempoGastoOnline + "/" 
				+ this.tempoOnlineEsperado;
	}

}
