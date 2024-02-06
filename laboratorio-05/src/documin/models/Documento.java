/**
 * Laboratório de Programação 2 - Lab05
 * @author Rafael de Arruda Sobral
 */

package documin.models;

import java.util.*;

/**
 * A classe Documento representa um documento com as suas respectivas características.
 */
public class Documento {
	
	private String titulo;
	private int tamanhoMaximo;
	private boolean possuiTamanho;
	private List<Elemento> elementos;
	private boolean ehAtalho;
	
	/**
	 * Primeiro construtor da classe.
	 * Cria uma lista de elementos e inicializa os demais atributos.
	 * @param titulo - o título do documento.
	 */
	public Documento(String titulo) {
		this.titulo = titulo;
		this.possuiTamanho = true;
		this.elementos = new ArrayList<>();
		this.ehAtalho = false;
	}
	
	/**
	 * Segundo construtor da classe, com o parâmetro de tamanho máximo.
	 * Cria uma lista de elementos e inicializa os demais atributos.
	 * @param titulo - o título do documento.
	 * @param tamanhoMaximo - o tamanho máximo do documento.
	 */
	public Documento(String titulo, int tamanhoMaximo) {
		this.titulo = titulo;
		this.tamanhoMaximo = tamanhoMaximo;
		this.possuiTamanho = true;
		this.elementos = new ArrayList<>();
		this.ehAtalho = false;
	}
	
	/**
	 * Sobrescreve o hashCode do título do documento.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(titulo);
	}
	
	/**
	 * Sobrescreve o equals para fins de comparação do título do documento.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Documento other = (Documento) obj;
		return Objects.equals(titulo, other.titulo);
	}
	
	/**
	 * Pega a prioridade de um elemento em uma determinada posição.
	 * @param posicaoElemento - a posição do elemento.
	 * @return a prioridade do elemento especificado por sua posição.
	 */
	public int getPrioridadeElemento(int posicaoElemento) {
		return this.elementos.get(posicaoElemento).getPrioridade();
	}
	
	/**
	 * Pega a média de prioridades dos elementos.
	 * @return um número inteiro que representa a média de prioridades.
	 */
	public int getMediaPrioridades() {
		int soma = 0;
		for (Elemento elemento: this.elementos) {
			if (elemento != null) {
				soma += elemento.getPrioridade();
			}
		}
		return (soma / this.elementos.size());
	}
	
	/**
	 * Pega o número total de elementos na lista.
	 * @return um número inteiro que representa o total de elementos na lista.
	 */
	public int getNumElementos() {
		return this.elementos.size();
	}
	
	/**
	 * Pega os elementos adicionados na lista de elementos.
	 * @return os elementos adicionados na lista de elementos.
	 */
	public List<Elemento> getElementos() {
		return this.elementos;
	}
	
	/**
	 * Adiciona um elemento na lista de elementos de acordo com o seu tamanho ou não.
	 * @param elemento - um elemento.
	 * @return true, caso o elemento seja adicionado devidamente; false, caso contrário.
	 */
	public boolean cadastraElemento(Elemento elemento) {
		if (this.possuiTamanho) {
			if (this.elementos.size() == this.tamanhoMaximo) {
				return false;
			}
		}
		this.elementos.add(elemento);
		return true;
	}
	
	/**
	 * Exibe a representação completa do elemento.
	 * @return um array de strings com a representação completa do elemento.
	 */
	public String[] exibeElemento() {
		String[] exibeElemento = new String[this.elementos.size()];
		for (int i = 0; i < this.elementos.size(); i++) {
			 exibeElemento[i] = this.elementos.get(i).representacaoCompleta();
		}
		return exibeElemento;
	}
	
	/**
	 * Pega a representação completa de um elemento em uma posição específica.
	 * @param elementoPosicao - a posição do elemento.
	 * @return a representação completa do elemento, ou ainda uma exceção para uma posição inválida.
	 */
	public String representacaoCompleta(int elementoPosicao) {
		if (elementoPosicao >= 0 || elementoPosicao <= this.elementos.size()) {
			return this.elementos.get(elementoPosicao).representacaoCompleta();
		} else {
			throw new IndexOutOfBoundsException("POSIÇÃO INVÁLIDA!");
		}
	}
	
	/**
	 * Pega a representação resumida de um elemento em uma posição específica.
	 * @param elementoPosicao - a posição do elemento.
	 * @return a representação resumida do elemento, ou ainda uma exceção para uma posição inválida.
	 */
	public String representacaoResumida(int elementoPosicao) {
		if (elementoPosicao >= 0 || elementoPosicao <= this.elementos.size()) {
			return this.elementos.get(elementoPosicao).representacaoResumida();
		} else {
			throw new IndexOutOfBoundsException("POSIÇÃO INVÁLIDA!");
		}
	}
	
	/**
	 * Apaga um elemento em uma posição específica.
	 * @param elementoPosicao - a posição do elemento.
	 * @return true, caso o elemento seja devidamente excluído; false, caso contrário.
	 */
	public boolean apagaElemento(int elementoPosicao) {
		if (elementoPosicao >= 0 || elementoPosicao <= this.elementos.size()) {
			this.elementos.remove(elementoPosicao);
			return true;
		}
		return false;
	}
	
	/**
	 * Move um elemento, trocando a sua posição com a do elemento mais próximo do início do documento.
	 * Retorna uma exceção para uma posição inválida.
	 * @param elementoPosicao - a posição do elemento.
	 */
	public void moveParaCima(int elementoPosicao) {
		if (elementoPosicao > 0 && elementoPosicao <= this.elementos.size()) {
			Collections.swap(this.elementos, elementoPosicao, elementoPosicao - 1);
		} else {
			throw new IndexOutOfBoundsException("POSIÇÃO INVÁLIDA!");
		}
	}
	
	/**
	 * Move um elemento, trocando a sua posição com a do elemento mais próximo do final do documento.
	 * Retorna uma exceção para uma posição inválida.
	 * @param elementoPosicao - a posição do elemento.
	 */
	public void moveParaBaixo(int elementoPosicao) {
		if (elementoPosicao >= 0 && elementoPosicao <= this.elementos.size() - 1) {
			Collections.swap(this.elementos, elementoPosicao, elementoPosicao + 1);
		} else {
			throw new IndexOutOfBoundsException("POSIÇÃO INVÁLIDA!");
		}
	}
	
	/**
	 * Verifica se um documento é um atalho.
	 * @return true, caso o documento seja um atalho; false, caso contrário.
	 */
	public boolean ehAtalho() {
		return this.ehAtalho;
	}
	
	/**
	 * Atualiza um documento, caso se torne um atalho.
	 * @return true, caso o documento se torne um atalho; false, caso contrário.
	 */
	public boolean atualizaAtalho() {
		if (this.ehAtalho == true) {
			return true;
		}
		return false;
	}
	
	/**
	 * Verifica se um documento tem um atalho.
	 * @return true, caso o documento tenha um atalho; false, caso contrário.
	 */
	public boolean verificaAtalho() {
        for (int i = 0; i < this.elementos.size(); i ++) {
            if (this.elementos.get(i).getClass().getSimpleName().equals("ElementoAtalho")) {
                return true;
            }
        } return false;
	}
	
}
