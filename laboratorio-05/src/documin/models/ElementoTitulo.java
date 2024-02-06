/**
 * Laboratório de Programação 2 - Lab05
 * @author Rafael de Arruda Sobral
 */

package documin.models;

/**
 * A classe ElementoTítulo implementa a interface Elemento e representa um elemento do tipo título.
 */
public class ElementoTitulo implements Elemento {

	private String valorLista;
	private int prioridadeLista;
	private int nivelLista;
	private boolean linkavelLista;
	
	/**
	 * Construtor da classe.
	 * Inicializa os parâmetros.
	 * @param valorLista - os dados do elemento.
	 * @param prioridadeLista - a prioridade do elemento.
	 * @param nivelLista - o nível do elemento.
	 * @param linkavelLista - o link do elemento.
	 */
	public ElementoTitulo(String valorLista, int prioridadeLista, int nivelLista, boolean linkavelLista) {
		this.valorLista = valorLista;
		this.prioridadeLista = prioridadeLista;
		this.nivelLista = nivelLista;
		this.linkavelLista = linkavelLista;
	}
	
	/**
	 * Pega a representação completa do elemento.
	 * @return uma string com a representação completa.
	 */
	@Override
	public String representacaoCompleta() {
		if (this.linkavelLista) {
			return this.nivelLista + ". " + this.valorLista + "--\n"
					+ this.nivelLista + "-" + this.valorLista.toUpperCase().replace(" ", "");
		}
		return this.nivelLista + ". " + this.valorLista;
	}
	
	/**
	 * Pega a representação resumida do elemento.
	 * @return uma string com a representação resumida.
	 */
	@Override
	public String representacaoResumida() {
		String[] valor = this.valorLista.split(" ");
		if (this.linkavelLista) {
			return this.nivelLista + ". " + valor[0];
		}
		return this.nivelLista + ". " + this.valorLista;
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
