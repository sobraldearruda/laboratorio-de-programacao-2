/**
 * Laboratório de Programação 2 - Lab05
 * @author Rafael de Arruda Sobral
 */

package documin.views;

import documin.models.Documento;

/**
 * A classe VisaoResumida implementa a interface Visao e representa uma visão resumida.
 */
public class VisaoResumida implements Visao {
	
	private Documento documento;
	
	/**
	 * Construtor da classe.
	 * Inicializa o parâmetro.
	 * @param documento - um documento.
	 */
	public VisaoResumida(Documento documento) {
		this.documento = documento;
	}
	
	/**
	 * Exibe a representação resumida de uma visão resumida.
	 * @param visaoId - a posição do documento.
	 * @return um array de strings com a visão.
	 */
	@Override
	public String[] exibeVisao(int visaoId) {
		String[] visao = new String[this.documento.getNumElementos()];
		for (int i = 0; i < this.documento.getNumElementos(); i++) {
			visao[i] = this.documento.representacaoResumida(i);
		}
		return visao;
	}
	
}
