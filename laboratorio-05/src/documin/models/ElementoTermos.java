/**
 * Laboratório de Programação 2 - Lab05
 * @author Rafael de Arruda Sobral
 */

package documin.models;

import java.util.Arrays;

/**
 * A classe ElementoTermos implementa a interface Elemento e representa um elemento do tipo termos.
 */
public class ElementoTermos implements Elemento  {

	private String valorTermos;
	private int prioridadeTermos;
	private String separadorTermos;
	private String ordemTermos;
	
	/**
	 * Construtor da classe.
	 * Inicializa os parâmetros.
	 * @param valorTermos - os dados do elemento.
	 * @param prioridadeTermos - a prioridade do elemento.
	 * @param separadorTermos - o separador do elemento.
	 * @param ordemTermos - a ordem do elemento.
	 */
	public ElementoTermos(String valorTermos, int prioridadeTermos, String separadorTermos, String ordemTermos) {
		this.valorTermos = valorTermos;
		this.prioridadeTermos = prioridadeTermos;
		this.separadorTermos = separadorTermos;
		this.ordemTermos = ordemTermos;
	}
	
	/**
	 * Pega a representação completa do elemento.
	 * @return uma string com a representação completa.
	 */
	@Override
	public String representacaoCompleta() {
		String[] termos = this.valorTermos.split(" " + this.separadorTermos + " ");
		String totalTermos = "Total termos: " + termos.length + "\n";
		if (this.ordemTermos.toUpperCase().equals("ALFABÉTICA")) {
			Arrays.sort(termos, String.CASE_INSENSITIVE_ORDER);
		}
		if (this.ordemTermos.toUpperCase().equals("TAMANHO")) {
			for (int i = 0; i < termos.length; i++) {
				int indiceMaior = i;
				for (int j = i+1; j < termos.length; j++) {
					if (termos[j].length() > termos[indiceMaior].length()) {
						indiceMaior = j;
					}
				}
				String auxiliar = termos[i];
				termos[i] = termos[indiceMaior];
				termos[indiceMaior] = auxiliar;
			}
		}
		String representacao = "- ";
		for (int r = 0; r < termos.length; r++) {
			if (representacao == "- ") {
				representacao += termos[r];
			} else {
				representacao += ", " + termos[r];
			}
		}
		return totalTermos + representacao;
	}
	
	/**
	 * Pega a representação resumida do elemento.
	 * @return uma string com a representação resumida.
	 */
	@Override
	public String representacaoResumida() {
		String[] termos = this.valorTermos.split(" " + this.separadorTermos + " ");
		if (this.ordemTermos.toUpperCase().equals("ALFABÉTICA")) {
			Arrays.sort(termos, String.CASE_INSENSITIVE_ORDER);
		}
		if (this.ordemTermos.toUpperCase().equals("TAMANHO")) {
			for (int i = 0; i < termos.length; i++) {
				int indiceMaior = i;
				for (int j = i+1; j < termos.length; j++) {
					if (termos[j].length() > termos[indiceMaior].length()) {
						indiceMaior = j;
					}
				}
				String auxiliar = termos[i];
				termos[i] = termos[indiceMaior];
				termos[indiceMaior] = auxiliar;
			}
		}
		String representacao = "";
		for (int r = 0; r < termos.length; r++) {
			if (representacao == "") {
				representacao += termos[r];
			} else {
				representacao += " " + this.separadorTermos + " " + termos[r];
			}
		}
		return representacao;
	}
	
	/**
	 * Pega a prioridade do elemento.
	 * @return um número inteiro que representa a prioridade do elemento.
	 */
	@Override
	public int getPrioridade() {
		return this.prioridadeTermos;
	}
	
}
