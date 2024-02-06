/**
 * Laboratório de Programação 2 - Lab05
 * @author Rafael de Arruda Sobral
 */

package documin.views;

import documin.models.Documento;

/**
 * A classe VisaoTitulo implementa a interface Visao e representa uma visão título.
 */
public class VisaoTitulo implements Visao {

	private Documento documento;
	
	/**
	 * Construtor da classe.
	 * Inicializa o parâmetro.
	 * @param documento - um documento.
	 */
	public VisaoTitulo(Documento documento) {
		this.documento = documento;
	}
	
	/**
	 * Exibe a representação resumida de uma visão título.
	 * @param visaoId - a posição do documento.
	 * @return um array de strings com a visão.
	 */
	@Override
	public String[] exibeVisao(int visaoId) {
		String[] visao = new String[this.documento.getNumElementos()];
		for (int i = 0; i < this.documento.getNumElementos(); i++) {
			if (this.documento.getElementos().get(i).getClass().getSimpleName().equals("ElementoTitulo")) {
				visao[i] = this.documento.representacaoResumida(i);
			}
		}
		return visao;
	}
	
}
