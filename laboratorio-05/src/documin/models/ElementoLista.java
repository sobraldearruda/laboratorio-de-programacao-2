/**
 * Laboratório de Programação 2 - Lab05
 * @author Rafael de Arruda Sobral
 */

package documin.models;

/**
 * A classe ElementoLista implementa a interface Elemento e representa um elemento do tipo lista.
 */
public class ElementoLista implements Elemento {

	private String valorLista;
	private int prioridadeLista;
	private String separadorLista;
	private String charLista;
	
	/**
	 * Construtor da classe.
	 * Inicializa os parâmetros.
	 * @param valorLista - os dados do elemento.
	 * @param prioridadeLista - a prioridade do elemento.
	 * @param separadorLista - o separador do elemento.
	 * @param charLista - o caractere do elemento.
	 */
	public ElementoLista(String valorLista, int prioridadeLista, String separadorLista, String charLista) {
		this.valorLista = valorLista;
		this.prioridadeLista = prioridadeLista;
		this.separadorLista = separadorLista;
		this.charLista = charLista;
	}
	
	/**
	 * Pega a representação completa do elemento.
	 * @return uma string com a representação completa.
	 */
	@Override
	public String representacaoCompleta() {
		String[] valor = this.valorLista.split(" " + this.separadorLista + " ");
		String representacao = "";
		for (int i = 0; i < valor.length - 1; i++) {
			if (i % 2 == 0) {
				representacao += this.charLista + " " + valor[i] + "\n";
			}
		}
		representacao += this.charLista + " " + valor[valor.length - 1];
		return representacao;
	}
	
	/**
	 * Pega a representação resumida do elemento.
	 * @return uma string com a representação resumida.
	 */
	@Override
	public String representacaoResumida() {
		String representacao = this.valorLista.replace(" ", "");
		return representacao.replace(this.separadorLista, ", ");
	}
	
	/**
	 * Pega a prioridade do elemento.
	 * @return um número inteiro que representa a prioridade do elemento.
	 */
	@Override
	public int getPrioridade() {
		return this.prioridadeLista;
	}
	
}
