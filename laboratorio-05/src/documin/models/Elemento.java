/**
 * Laboratório de Programação 2 - Lab05
 * @author Rafael de Arruda Sobral
 */

package documin.models;

/**
 * A interface Elemento representa um contrato entre os elementos.
 */
public interface Elemento {
	
	/**
	 * Pega a representação completa do elemento.
	 * @return uma string com a representação completa.
	 */
	public String representacaoCompleta();
	
	/**
	 * Pega a representação resumida do elemento.
	 * @return uma string com a representação resumida.
	 */
	public String representacaoResumida();
	
	/**
	 * Pega a prioridade do elemento.
	 * @return um número inteiro que representa a prioridade.
	 */
	public int getPrioridade();

}
