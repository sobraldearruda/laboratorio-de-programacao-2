/**
 * Laboratório de Programação 2 - Lab02
 * @author Rafael de Arruda Sobral
 */

package coisa;

/**
 * A classe RegistroResumos faz um registro de resumos de estudos,
 * limitando-o a uma quantidade específica e substituindo os resumos
 * mais antigos quando o limite é atingido.
 */
public class RegistroResumos {
	
	private int numeroDeResumos;
	private String[] temas;
	private String[] resumos;
	private int contador;
	
	/**
	 * Construtor da classe.
	 * Cria um registro de resumos com o número especificado.
	 * Inicia o array de temas e o array de resumos com o número especificado.
	 * Inicia o contador de resumos com 0.
	 * @param numeroDeResumos - o número de resumos especificado.
	 */
	public RegistroResumos(int numeroDeResumos) {
		this.numeroDeResumos = numeroDeResumos;
		this.temas = new String[numeroDeResumos];
		this.resumos = new String[numeroDeResumos];
		this.contador = 0;
	}
	
	/**
	 * Adiciona temas e resumos ao registro.
	 * Se o número máximo de resumos já foi atingido,
	 * o contador é reiniciado e o tema e o resumo em suas devidas posições
	 * são substituídos por novos.
	 * @param tema - o tema do resumo.
	 * @param resumo - o texto do resumo.
	 */
	public void adiciona(String tema, String resumo) {
		this.temas[this.contador] = tema;
		this.resumos[this.contador] = resumo;
		this.contador += 1;
		if (this.contador >= this.numeroDeResumos) {
			this.contador = 0;
		}
	}
	
	/**
	 * Retorna todos os temas e resumos do registro como um array de strings.
	 * @return um array de strings com todos os temas e resumos armazenados.
	 */
	public String[] pegaResumos() {
		String[] todosResumos = new String[this.numeroDeResumos];
		for (int i = 0; i < this.numeroDeResumos; i++) {
			todosResumos[i] = this.temas[i] + ": " + this.resumos[i];
		}
		return todosResumos;
	}
	
	/**
	 * Retorna uma string com a impressão dos temas dos resumos armazenados no registro.
	 * A string contém o número de resumos registrados e os temas mais recentes.
	 * @return uma string com os temas dos resumos armazenados no registro.
	 */
	public String imprimeResumos() {
		String impressao = "- " + this.conta() + " resumo(s) cadastrado(s)\n";
		if (this.conta() > 0) {
			impressao += "- " + this.temas[0] + " | " + this.temas[1];
		}
		return impressao;
	}
	
	/**
	 * Retorna o contador com a quantidade de resumos cadastrados no registro.
	 * @return o contador com a a quantidade de resumos cadastrados no registro.
	 */
	public int conta() {
		int conta = 0;
		for (int i = 0; i < this.numeroDeResumos; i++) {
			if (temas[i] == null) {
				break;
			} else {
				conta += 1;
			}
		}
		return conta;
	}
	
	/**
	 * Verifica se há algum resumo cadastrado com o tema especificado.
	 * @param tema - o tema do resumo a ser verificado no registro.
	 * @return true se há pelo menos um resumo cadastrado com o tema especificado,
	 * false caso contrário.
	 */
	public boolean temResumo(String tema) {
		for (int i = 0; i < this.contador; i++) {
			if (this.temas[i].equals(tema)) {
				return true;
			}
		}
		return false;
	}

}
