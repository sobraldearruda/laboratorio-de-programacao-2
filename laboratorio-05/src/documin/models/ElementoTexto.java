/**
 * Laboratório de Programação 2 - Lab05
 * @author Rafael de Arruda Sobral
 */

package documin.models;

/**
 * A classe ElementoTexto implementa a interface Elemento e representa um elemento do tipo texto.
 */
public class ElementoTexto implements Elemento {
	
	private String valorTexto;
	private int prioridadeTexto;
	
	/**
	 * Construtor da classe.
	 * Inicializa os parâmetros.
	 * @param valorTexto - os dados do elemento.
	 * @param prioridadeTexto - a prioridade do elemento.
	 */
	public ElementoTexto(String valorTexto, int prioridadeTexto) {
		this.valorTexto = valorTexto;
		this.prioridadeTexto = prioridadeTexto;
	}
	
	/**
	 * Pega a representação completa do elemento.
	 * @return uma string com a representação completa.
	 */
	@Override
	public String representacaoCompleta() {
		return this.valorTexto;
	}
	
	/**
	 * Pega a representação resumida do elemento.
	 * @return uma string com a representação resumida.
	 */
	@Override
	public String representacaoResumida() {
		return this.valorTexto;
	}
	
	/**
	 * Pega a prioridade do elemento.
	 * @return um número inteiro que representa a prioridade do elemento.
	 */
	@Override
	public int getPrioridade() {
		return this.prioridadeTexto;
	}
	
}
