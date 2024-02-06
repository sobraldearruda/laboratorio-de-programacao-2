/**
 * Laboratório de Programação 2 - Lab05
 * @author Rafael de Arruda Sobral
 */

package documin.views;

/**
 * A interface Visao representa um contrato entre as visões.
 */
public interface Visao {

	/**
	 * Exibe a visão de um documento.
	 * @param visaoId - a posição do documento.
	 * @return um array de strings com a visão.
	 */
	public String[] exibeVisao(int visaoId);

}
