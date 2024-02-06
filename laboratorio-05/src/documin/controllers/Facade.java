/**
 * Laboratório de Programação 2 - Lab05
 * @author Rafael de Arruda Sobral
 */

package documin.controllers;

public class Facade {
	
	private DocumentoController documentoController;
	
	public Facade() {
		this.documentoController = new DocumentoController();
	}
	
	public boolean criaDocumento(String titulo) {
		return this.documentoController.criaDocumento(titulo);
	}
	
	public boolean criaDocumento(String titulo, int tamanhoMaximo) {
		return this.documentoController.criaDocumento(titulo, tamanhoMaximo);
	}
	
	public void removeDocumento(String titulo) {
		this.documentoController.removeDocumento(titulo);
	}
	
	public int contaElementos(String titulo) {
		return this.documentoController.contaElementos(titulo);
	}
	
	public String[] exibeDocumento(String titulo) {
		return this.documentoController.exibeDocumento(titulo);
	}
	
	public int criaTexto(String titulo, String valor, int prioridade) {
		return this.documentoController.criaTexto(titulo, valor, prioridade);
	}
	
	public int criaTitulo(String titulo, String valor, int prioridade, int nivel, boolean linkavel) {
		return this.documentoController.criaTitulo(titulo, valor, prioridade, nivel, linkavel);
	}
	
	public int criaLista(String titulo, String valor, int prioridade, String separador, String charLista) {
		return this.documentoController.criaLista(titulo, valor, prioridade, separador, charLista);
	}
	
	public int criaTermos(String titulo, String valor, int prioridade, String separador, String ordem) {
		return this.documentoController.criaTermos(titulo, valor, prioridade, separador, ordem);
	}
	
	public String pegaRepresentacaoCompleta(String titulo, int elementoPosicao) {
		return this.documentoController.pegaRepresentacaoCompleta(titulo, elementoPosicao);
	}
	
	public String pegaRepresentacaoResumida(String titulo, int elementoPosicao) {
		return this.documentoController.pegaRepresentacaoResumida(titulo, elementoPosicao);
	}
	
	public boolean apagaElemento(String titulo, int elementoPosicao) {
		return this.documentoController.apagaElemento(titulo, elementoPosicao);
	}
	
	public void moveParaCima(String titulo, int elementoPosicao) {
		this.documentoController.moveParaCima(titulo, elementoPosicao);
	}
	
	public void moveParaBaixo(String titulo, int elementoPosicao) {
		this.documentoController.moveParaBaixo(titulo, elementoPosicao);
	}
	
	public int criaAtalho(String titulo, String tituloDocReferenciado) {
		return this.documentoController.criaAtalho(titulo, tituloDocReferenciado);
	}
	
	public int criaVisaoCompleta(String titulo) {
		return this.documentoController.criaVisaoCompleta(titulo);
	}
	
	public int criaVisaoResumida(String titulo) {
		return this.documentoController.criaVisaoResumida(titulo);
	}
	
	public int criaVisaoPrioritaria(String titulo, int prioridade) {
		return this.documentoController.criaVisaoPrioritaria(titulo, prioridade);
	}
	
	public int criaVisaoTitulo(String titulo) {
		return this.documentoController.criaVisaoTitulo(titulo);
	}
	
	public String[] exibeVisao(int visaoId) {
		return this.documentoController.exibeVisao(visaoId);
	}
	
}
