/**
 * Laboratório de Programação 2 - Lab05
 * @author Rafael de Arruda Sobral
 */

package documin.views;

import documin.models.Documento;

/**
 * A classe VisaoCompleta implementa a interface Visao e representa uma visão completa.
 */
public class VisaoCompleta implements Visao {
	
	private Documento documento;
	
	/**
	 * Construtor da classe.
	 * Inicializa o parâmetro.
	 * @param documento - um documento.
	 */
	public VisaoCompleta(Documento documento) {
		this.documento = documento;
	}
	
	/**
	 * Exibe a representação completa de uma visão completa.
	 * @param visaoId - a posição do documento.
	 * @return um array de strings com a visão.
	 */
	@Override
	public String[] exibeVisao(int visaoId) {
		String[] visao = new String[this.documento.getNumElementos()];
		for (int i = 0; i < this.documento.getNumElementos(); i++) {
			visao[i] = this.documento.representacaoCompleta(i);
		}
		return visao;
	}
	
}
