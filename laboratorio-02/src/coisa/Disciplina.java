/**
 * Laboratório de Programação 2 - Lab02
 * @author Rafael de Arruda Sobral
 */

package coisa;

import java.util.Arrays;

/**
 * A classe Disciplina registra o desempenho e a avaliação de um aluno em uma disciplina.
 */
public class Disciplina {
	
	private String nomeDisciplina;
	private int horas;
	private double[] notas;
	
	/**
	 * Construtor da classe.
	 * Cria uma disciplina com o nome especificado e inicia o array de notas com tamanho 4.
	 * @param nomeDisciplina - o nome da disciplina.
	 */
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.notas = new double[4];
	}
	
	/**
	 * Cadastra as horas de estudo na disciplina.
	 * @param horas - o número de horas de estudo.
	 */
	public void cadastraHoras(int horas) {
		this.horas += horas;
	}
	
	/**
	 * Cadastra as notas na disciplina.
	 * @param nota - o número da nota (1 a 4).
	 * @param valorNota - o valor da nota (0 a 10).
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota-1] = valorNota;
	}
	
	/**
	 * Calcula a média aritmética das notas da disciplina.
	 * @return a média aritmética.
	 */
	private double media() {
		double soma = 0;
		for (int i = 0; i < this.notas.length; i++) {
			soma += this.notas[i];
		}
		return (soma / this.notas.length);
	}
	
	/**
	 * Verifica se o aluno foi aprovado na disciplina.
	 * Caso a média das notas seja maior ou igual a 7, o aluno está aprovado.
	 * @return true se o aluno foi aprovado, false caso contrário.
	 */
	public boolean aprovado() {
		double media = this.media();
		if (media >= 7) {
			return true;
		}
		return false;
	}
	
	/**
	 * Retorna uma string que representa o estado final do aluno na disciplina.
	 * @return uma string com o nome da disciplina, as horas de estudo, a média das notas,
	 * e todas as notas da disciplina.
	 */
	@Override
	public String toString() {
		return this.nomeDisciplina + " " 
				+ this.horas + " " 
				+ this.media() + " " 
				+ Arrays.toString(this.notas);
	}

}
