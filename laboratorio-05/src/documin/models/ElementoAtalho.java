/**
 * Laboratório de Programação 2 - Lab05
 * @author Rafael de Arruda Sobral
 */

package documin.models;

/**
 * A classe ElementoAtalho implementa a interface Elemento e representa um atalho.
 */
public class ElementoAtalho implements Elemento {
	
	private Documento atalhoDocumento;

	/**
	 * Construtor da classe.
	 * Inicializa o parâmetro.
	 * @param atalhoDocumento - um atalho.
	 */
	public ElementoAtalho(Documento atalhoDocumento) {
		this.atalhoDocumento = atalhoDocumento;
	}
	
	/**
	 * Pega a representação completa dos atalhos.
	 * @return uma string com a representação completa.
	 */
	@Override
	public String representacaoCompleta() {
		String lista = "";
		for (int i = 0; i < this.atalhoDocumento.getNumElementos(); i++) {
			if (lista == "") {
				lista += this.atalhoDocumento.representacaoCompleta(i);
			} else {
				lista += "\n" + this.atalhoDocumento.representacaoCompleta(i);
			}
		}
		return lista;
	}

	/**
	 * Pega a representação resumida dos atalhos.
	 * @return uma string com a representação resumida.
	 */
	@Override
	public String representacaoResumida() {
		String lista = "";
		for (int i = 0; i < this.atalhoDocumento.getNumElementos(); i++) {
			if (lista == "") {
				lista += this.atalhoDocumento.representacaoResumida(i);
			} else {
				lista += "\n" + this.atalhoDocumento.representacaoResumida(i);
			}
		}
		return lista;
	}
	
	/**
	 * Pega a prioridade do atalho.
	 * @return um número inteiro que representa a prioridade do atalho.
	 */
	@Override
	public int getPrioridade() {
		return this.atalhoDocumento.getMediaPrioridades();
	}
	
}
