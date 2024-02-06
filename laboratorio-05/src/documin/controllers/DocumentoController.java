/**
 * Laboratório de Programação 2 - Lab05
 * @author Rafael de Arruda Sobral
 */

package documin.controllers;

import java.util.*;
import documin.models.*;
import documin.views.*;

/**
 * A classe DocumentoController representa o controlador de documentos
 * e de seus respectivos elementos e suas visões.
 */
public class DocumentoController {
	
	private Map<String, Documento> documentos;
	private List<Visao> visoes;
	
	/**
	 * Construtor da classe.
	 * Cria um mapa de documentos e uma lista de visões.
	 */
	public DocumentoController() {
		this.documentos = new HashMap<>();
		this.visoes = new ArrayList<>();
	}

	/**
	 * Valida a entrada de dados para o título inválido.
	 * Retorna uma exceção para argumento inválido.
	 * @param titulo - o título do documento.
	 */
	private void validaTituloInvalido(String titulo) {
		if (titulo == null || titulo.trim() == " ") {
			throw new IllegalArgumentException("TÍTULO INVÁLIDO!");
		}
	}

	/**
	 * Valida a entrada de dados para o título não cadastrado.
	 * Retorna uma exceção para objeto inexistente.
	 * @param titulo - o título do documento.
	 */
	private void validaTituloNaoCadastrado(String titulo) {
		if (!this.documentos.containsKey(titulo)) {
			throw new NoSuchElementException("TÍTULO NÃO CADASTRADO!");
		}
	}
	
	/**
	 * Cria um documento e o adiciona ao mapa de documentos.
	 * @param titulo - o título do documento.
	 * @return true, caso o documento seja criado e adicionado ao mapa; false, caso o mapa
	 * já possua o cadastro, ou ainda uma exceção para um título inválido.
	 */
	public boolean criaDocumento(String titulo) {
		this.validaTituloInvalido(titulo);
		if (this.documentos.containsKey(titulo)) {
			return false;
		}
		Documento documento = new Documento(titulo);
		documentos.put(titulo, documento);
		return true;
	}
	
	/**
	 * Cria um documento e o adiciona ao mapa de documentos de acordo com o seu tamanho máximo.
	 * @param titulo - o título do documento.
	 * @param tamanhoMaximo - o tamanho máximo de elementos no documento.
	 * @return true, caso o documento seja criado e adicionado ao mapa; false, caso o mapa
	 * já possua o cadastro, ou ainda uma exceção para um título ou um tamanho inválido.
	 */
	public boolean criaDocumento(String titulo, int tamanhoMaximo) {
		this.validaTituloInvalido(titulo);
		if (this.documentos.containsKey(titulo)) {
			return false;
		}
		if (tamanhoMaximo <= 0) {
			throw new IndexOutOfBoundsException("TAMANHO INVÁLIDO!");
		}
		Documento documento = new Documento(titulo, tamanhoMaximo);
		documentos.put(titulo, documento);
		return true;
	}
	
	/**
	 * Remove um documento do mapa de documentos de acordo com o seu título.
	 * Retorna uma exceção para os casos de título inválido ou não cadastrado.
	 * @param titulo - o título do documento.
	 */
	public void removeDocumento(String titulo) {
		this.validaTituloInvalido(titulo);
		this.validaTituloNaoCadastrado(titulo);
		if (this.documentos.containsKey(titulo)) {
			this.documentos.remove(titulo);
		}
	}
	
	/**
	 * Conta o número de elementos em um documento.
	 * @param titulo - o título do documento.
	 * @return o número inteiro que representa a quantidade de elementos em um documento,
	 * ou ainda uma exceção para um título inválido.
	 */
	public int contaElementos(String titulo) {
		this.validaTituloInvalido(titulo);
		if (this.documentos.containsKey(titulo)) {
			return this.documentos.get(titulo).getNumElementos();
		} else {
			return 0;
		}
	}
	
	/**
	 * Exibe um documento com os seus elementos em um array de strings.
	 * @param titulo - o título do documento.
	 * @return um array de strings com o documento requerido, ou ainda uma exceção
	 * para os casos de título inválido ou não cadastrado.
	 */
	public String[] exibeDocumento(String titulo) {
		this.validaTituloInvalido(titulo);
		this.validaTituloNaoCadastrado(titulo);
		return this.documentos.get(titulo).exibeElemento();
	}
	
	/**
	 * Cria um elemento de texto e o adiciona ao mapa de documentos.
	 * @param titulo - o título do documento.
	 * @param valor - o valor com os dados do texto.
	 * @param prioridade - o valor de prioridade do texto.
	 * @return a posição do elemento de texto ao ser adicionado ao mapa de documentos,
	 * ou ainda uma exceção para os casos de título inválido ou não cadastrado.
	 */
	public int criaTexto(String titulo, String valor, int prioridade) {
		this.validaTituloInvalido(titulo);
		this.validaTituloNaoCadastrado(titulo);
		Elemento texto = new ElementoTexto(valor, prioridade);
		this.documentos.get(titulo).cadastraElemento(texto);
		return this.documentos.get(titulo).getNumElementos() - 1;
	}
	
	/**
	 * Cria um elemento de título e o adiciona ao mapa de documentos.
	 * @param titulo - o título do documento.
	 * @param valor - o valor com os dados do título.
	 * @param prioridade - o valor de prioridade do título.
	 * @param nivel - o nível do título.
	 * @param linkavel - o dado de link do título.
	 * @return a posição do elemento de título ao ser adicionado ao mapa de documentos,
	 * ou ainda uma exceção para os casos de título inválido ou não cadastrado.
	 */
	public int criaTitulo(String titulo, String valor, int prioridade, int nivel, boolean linkavel) {
		this.validaTituloInvalido(titulo);
		this.validaTituloNaoCadastrado(titulo);
		Elemento elementoTitulo = new ElementoTitulo(valor, prioridade, nivel, linkavel);
		this.documentos.get(titulo).cadastraElemento(elementoTitulo);
		return this.documentos.get(titulo).getNumElementos() - 1;
	}
	
	/**
	 * Cria um elemento de lista e o adiciona ao mapa de documentos.
	 * @param titulo - o título do documento.
	 * @param valor - o valor com os dados da lista.
	 * @param prioridade - o valor de prioridade da lista.
	 * @param separador - o separador da lista.
	 * @param charLista - o caractere da lista.
	 * @return a posição do elemento de lista ao ser adicionado ao mapa de documentos,
	 * ou ainda uma exceção para os casos de título inválido ou não cadastrado.
	 */
	public int criaLista(String titulo, String valor, int prioridade, String separador, String charLista) {
		this.validaTituloInvalido(titulo);
		this.validaTituloNaoCadastrado(titulo);
		Elemento lista = new ElementoLista(valor, prioridade, separador, charLista);
		this.documentos.get(titulo).cadastraElemento(lista);
		return this.documentos.get(titulo).getNumElementos() - 1;
	}
	
	/**
	 * Cria um elemento de termos e o adiciona ao mapa de documentos.
	 * @param titulo - o título do documento.
	 * @param valor - o valor com os dados dos termos.
	 * @param prioridade - o valor de prioridade dos termos.
	 * @param separador - o separador de termos.
	 * @param ordem - o tipo de ordem seguida nos termos.
	 * @return a posição do elemento de termos ao ser adicionado ao mapa de documentos,
	 * ou ainda uma exceção para os casos de título inválido ou não cadastrado.
	 */
	public int criaTermos(String titulo, String valor, int prioridade, String separador, String ordem) {
		this.validaTituloInvalido(titulo);
		this.validaTituloNaoCadastrado(titulo);
		Elemento termos = new ElementoTermos(valor, prioridade, separador, ordem);
		this.documentos.get(titulo).cadastraElemento(termos);
		return this.documentos.get(titulo).getNumElementos() - 1;
	}
	
	/**
	 * A representação completa de um elemento do documento.
	 * @param titulo - o título do documento.
	 * @param elementoPosicao - a posição do elemento.
	 * @return uma visão da representação completa do elemento,
	 * ou ainda uma exceção para os casos de título inválido ou não cadastrado.
	 */
	public String pegaRepresentacaoCompleta(String titulo, int elementoPosicao) {
		this.validaTituloInvalido(titulo);
		this.validaTituloNaoCadastrado(titulo);
		return this.documentos.get(titulo).representacaoCompleta(elementoPosicao);
	}
	
	/**
	 * A representação resumida de um elemento do documento.
	 * @param titulo - o título do documento.
	 * @param elementoPosicao - a posição do elemento.
	 * @return uma visão da representação resumida do elemento,
	 * ou ainda uma exceção para os casos de título inválido ou não cadastrado.
	 */
	public String pegaRepresentacaoResumida(String titulo, int elementoPosicao) {
		this.validaTituloInvalido(titulo);
		this.validaTituloNaoCadastrado(titulo);
		return this.documentos.get(titulo).representacaoResumida(elementoPosicao);
	}
	
	/**
	 * Apaga um elemento do mapa de documentos de acordo com o seu título e posição.
	 * @param titulo - o título do documento.
	 * @param elementoPosicao - a posição do elemento.
	 * @return true, caso o elemento seja apagado, ou ainda uma exceção para os casos 
	 * de título inválido ou não cadastrado.
	 */
	public boolean apagaElemento(String titulo, int elementoPosicao) {
		this.validaTituloInvalido(titulo);
		this.validaTituloNaoCadastrado(titulo);
		this.documentos.get(titulo).apagaElemento(elementoPosicao);
		return true;
	}
	
	/**
	 * Move um elemento, trocando a sua posição com a do elemento mais próximo do início do documento.
	 * Retorna uma exceção para os casos de título inválido ou não cadastrado.
	 * @param titulo - o título do documento.
	 * @param elementoPosicao - a posição do elemento.
	 */
	public void moveParaCima(String titulo, int elementoPosicao) {
		this.validaTituloInvalido(titulo);
		this.validaTituloNaoCadastrado(titulo);
		this.documentos.get(titulo).moveParaCima(elementoPosicao);
	}
	
	/**
	 * Move um elemento, trocando a sua posição com a do elemento mais próximo do final do documento.
	 * Retorna uma exceção para os casos de título inválido ou não cadastrado.
	 * @param titulo - o título do documento.
	 * @param elementoPosicao - a posição do elemento.
	 */
	public void moveParaBaixo(String titulo, int elementoPosicao) {
		this.validaTituloInvalido(titulo);
		this.validaTituloNaoCadastrado(titulo);
		this.documentos.get(titulo).moveParaBaixo(elementoPosicao);
	}
	
	/**
	 * Cria uma atalho para um elemento do documento.
	 * @param titulo - o título do documento.
	 * @param documento - o documento.
	 * @return a posição em que o atalho é adicionado na lista, 
	 * ou ainda uma exceção para os casos de título inválido, já cadastrado como um atalho, 
	 * ou de um documento já possuir um atalho.
	 */
	public int criaAtalho(String titulo, String documento) {
		this.validaTituloInvalido(titulo);
		this.validaTituloNaoCadastrado(titulo);
		if (this.documentos.get(titulo).ehAtalho()) {
			throw new IllegalStateException("O DOCUMENTO JÁ É UM ATALHO!");
		}
		if (this.documentos.get(documento).verificaAtalho()) {
			throw new IllegalStateException("O DOCUMENTO JÁ POSSUI UM ATALHO!");
		}
		Elemento atalho = new ElementoAtalho(this.documentos.get(documento));
		this.documentos.get(titulo).cadastraElemento(atalho);
		this.documentos.get(documento).atualizaAtalho();
		return this.documentos.get(titulo).getNumElementos() - 1;
	}
	
	/**
	 * Cria uma visão completa de um documento.
	 * @param titulo - o título do documento.
	 * @return um número inteiro que representa a posição de cadastro de uma visão completa,
	 * ou ainda uma exceção para os casos de título inválido ou não cadastrado.
	 */
	public int criaVisaoCompleta(String titulo) {
		this.validaTituloInvalido(titulo);
		this.validaTituloNaoCadastrado(titulo);
		Visao visaoCompleta = new VisaoCompleta(this.documentos.get(titulo));
		this.visoes.add(visaoCompleta);
		return this.visoes.indexOf(visaoCompleta);
	}
	
	/**
	 * Cria uma visão resumida de um documento.
	 * @param titulo - o título do documento.
	 * @return um número inteiro que representa a posição de cadastro de uma visão resumida,
	 * ou ainda uma exceção para os casos de título inválido ou não cadastrado.
	 */
	public int criaVisaoResumida(String titulo) {
		this.validaTituloInvalido(titulo);
		this.validaTituloNaoCadastrado(titulo);
		Visao visaoResumida = new VisaoCompleta(this.documentos.get(titulo));
		this.visoes.add(visaoResumida);
		return this.visoes.indexOf(visaoResumida);
	}
	
	/**
	 * Cria uma visão prioritária de um documento.
	 * @param titulo - o título do documento.
	 * @param prioridade - a prioridade do documento.
	 * @return um número inteiro que representa a posição de cadastro de uma visão prioritária,
	 * ou ainda uma exceção para os casos de título inválido ou não cadastrado.
	 */
	public int criaVisaoPrioritaria(String titulo, int prioridade) {
		this.validaTituloInvalido(titulo);
		this.validaTituloNaoCadastrado(titulo);
		Visao visaoPrioritaria = new VisaoPrioritaria(this.documentos.get(titulo), prioridade);
		this.visoes.add(visaoPrioritaria);
		return this.visoes.indexOf(visaoPrioritaria);
	}
	
	/**
	 * Cria uma visão de um documento do tipo título.
	 * @param titulo - o título do documento.
	 * @return um número inteiro que representa a posição de cadastro de uma visão de um documento 
	 * do tipo título, ou ainda uma exceção para os casos de título inválido ou não cadastrado.
	 */
	public int criaVisaoTitulo(String titulo) {
		this.validaTituloInvalido(titulo);
		this.validaTituloNaoCadastrado(titulo);
		Visao visaoTitulo = new VisaoTitulo(this.documentos.get(titulo));
		this.visoes.add(visaoTitulo);
		return this.visoes.indexOf(visaoTitulo);
	}
	
	/**
	 * Exibe uma visão do documento em um array de strings.
	 * @param visaoId - a posição do documento.
	 * @return um array de strings com a visão requerida.
	 */
	public String[] exibeVisao(int visaoId) {
		return this.visoes.get(visaoId).exibeVisao(visaoId);
	}
	
}
