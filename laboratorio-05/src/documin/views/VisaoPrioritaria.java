/**
 * Laboratório de Programação 2 - Lab05
 * @author Rafael de Arruda Sobral
 */

package documin.views;

import documin.models.Documento;

/**
 * A classe VisaoPrioritária implementa a interface Visao e representa uma visão prioritária.
 */
public class VisaoPrioritaria implements Visao {
	
	private Documento documento;
	private int prioridade;
	
	/**
	 * Construtor da classe.
	 * Inicializa os parâmetros.
	 * @param documento - um documento.
	 * @param prioridade - a prioridade do documento.
	 */
	public VisaoPrioritaria(Documento documento, int prioridade) {
		this.documento = documento;
		this.prioridade = prioridade;
	}
	
	/**
	 * Exibe a representação completa de uma visão prioritária.
	 * @param visaoId - a posição do documento.
	 * @return um array de strings com a visão.
	 */
	@Override
	public String[] exibeVisao(int prioridade) {
		String[] visao = new String[this.documento.getNumElementos()];
		for (int i = 0; i < this.documento.getNumElementos(); i++) {
			if (this.documento.getPrioridadeElemento(i) >= this.prioridade) {
				visao[i] = this.documento.representacaoCompleta(i);
			}
		}
		return visao;
	}
	
}
