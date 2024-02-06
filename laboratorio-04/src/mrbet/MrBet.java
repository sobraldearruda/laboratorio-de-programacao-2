/**
 * Laboratório de Programação 2 - Lab04
 * @author Rafael de Arruda Sobral
 */

package mrbet;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * A classe MrBet representa um sistema de times, campeonatos e apostas de futebol.
 * É possível cadastrar, exibir e listar times, campeonatos e apostas, bem como verificar
 * a existência de times e campeonatos no sistema.
 */
public class MrBet {
	
	/**
	 * Atributos da classe, representando duas coleções de mapas com times e campeonatos,
	 * assim como uma lista de apostas.
	 */
	private Map<String, Time> times;
	private Map<String, Campeonato> campeonatos;
	private List<Aposta> apostas;

	/**
	 * Construtor da classe.
	 * Inicializa os atributos de acordo com o tipo de coleção usada.
	 */
	public MrBet() {
		this.times = new HashMap<String, Time>();
		this.campeonatos = new HashMap<String, Campeonato>();
		this.apostas = new ArrayList<Aposta>();
	}
	
	/**
	 * Cadastra times com código identificador, nome e mascote.
	 * @param codigo - o identificador do time.
	 * @param nome - o nome do time.
	 * @param mascote - o mascote do time.
	 * @return a informação de que o time já existe no sistema ou que o cadastro foi realizado.
	 */
	public String incluiTimes(String codigo, String nome, String mascote) {
		Time time = new Time(codigo, nome, mascote);
		if (this.times.containsKey(codigo.toUpperCase())) {
			return "TIME JÁ EXISTE!";
		}
		if (codigo.isBlank() || codigo.isEmpty() || nome.isBlank() || nome.isEmpty() ||
				mascote.isBlank() || mascote.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.times.put(codigo.toUpperCase(), time);
		return "INCLUSÃO REALIZADA!";
	}
	
	/**
	 * Exibe um time a partir do seu código identificador.
	 * @param codigo - o identificador do time.
	 * @return o time requerido ou a informação de que o time não existe no sistema.
	 */
	public String recuperaTimes(String codigo) {
		if (this.times.containsKey(codigo.toUpperCase())) {
			return this.times.get(codigo.toUpperCase()).toString();
		}
		if (codigo.isBlank() || codigo.isEmpty()) {
			throw new IllegalArgumentException();
		}
		return "TIME NÃO EXISTE!";
	}
	
	/**
	 * Cadastra campeonatos com nome e número máximo de participantes.
	 * @param nomeCampeonato - o nome do campeonato.
	 * @param numParticipantes - o número de participantes.
	 * @return a informação de que o campeonato já existe no sistema ou que o cadastro foi realizado.
	 */
	public String adicionaCampeonato(String nomeCampeonato, int numParticipantes) {
		Campeonato campeonato = new Campeonato(nomeCampeonato, numParticipantes);
		if (this.campeonatos.containsKey(nomeCampeonato.toUpperCase())) {
			return "CAMPEONATO JÁ EXISTE!";
		}
		if (nomeCampeonato.isBlank() || nomeCampeonato.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.campeonatos.put(nomeCampeonato.toUpperCase(), campeonato);
		return "CAMPEONATO ADICIONADO!";
	}
	
	/**
	 * Cadastra times em campeonatos a partir do código identificador e nome do campeonato.
	 * @param codigo - o identificador do time.
	 * @param nomeCampeonato - o nome do campeonato.
	 * @return a informação de que o time ou o campeonato não existem no sistema, ou de que o campeonato
	 * já atingiu o limite de participantes, ou ainda a mensagem de que o cadastro foi realizado.
	 */
	public String incluiTimeCampeonato(String codigo, String nomeCampeonato) {
		if (!this.times.containsKey(codigo.toUpperCase())) {
			return "TIME NÃO EXISTE!";
		}
		if (!this.campeonatos.containsKey(nomeCampeonato.toUpperCase())) {
			return "CAMPEONATO NÃO EXISTE!";
		}
		if (!this.campeonatos.get(nomeCampeonato.toUpperCase())
				.adicionaTimesCampeonatos(this.times.get(codigo.toUpperCase()))) {
			return "TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!";
		}
		if (codigo.isBlank() || codigo.isEmpty() || nomeCampeonato.isBlank() || 
				nomeCampeonato.isEmpty()) {
			throw new IllegalArgumentException();
		}
		return "TIME INCLUÍDO NO CAMPEONATO!";
	}
	
	/**
	 * Verifica se um time participa de um campeonato.
	 * @param codigo - o identificador do time.
	 * @param nomeCampeonato - o nome do campeonato.
	 * @return a informação de que o time ou o campeonato não existem no sistema, ou ainda de que o time
	 * participa ou não de um campeonato.
	 */
	public String verificaTimeCampeonato(String codigo, String nomeCampeonato) {
		if (!this.times.containsKey(codigo.toUpperCase())) {
			return "O TIME NÃO EXISTE!";
		}
		if (!this.campeonatos.containsKey(nomeCampeonato.toUpperCase())) {
			return "O CAMPEONATO NÃO EXISTE!";
		}
		if (!this.campeonatos.get(nomeCampeonato.toUpperCase())
				.verificaTimesCampeonatos(this.times.get(codigo.toUpperCase()))) {
			return "O TIME NÃO ESTÁ NO CAMPEONATO!";
		}
		if (codigo.isBlank() || codigo.isEmpty() || nomeCampeonato.isBlank() || 
				nomeCampeonato.isEmpty()) {
			throw new IllegalArgumentException();
		}
		return "O TIME ESTÁ NO CAMPEONATO!";
	}
	
	/**
	 * Lista os campeonatos do qual um time faz parte.
	 * @param codigo - o identificador do time.
	 * @return uma string formatada com a listagem dos campeonatos nos quais um time participa.
	 */
	public String exibeTimeCampeonatoParticipante(String codigo) {
		if (!this.times.containsKey(codigo.toUpperCase())) {
			return "TIME NÃO CADASTRADO NO SISTEMA!";
		}
		if (codigo.isBlank() || codigo.isEmpty()) {
			throw new IllegalArgumentException();
		}
		String saida = "Campeonatos do " + this.times.get(codigo.toUpperCase()).getNome() + ":";
		for (String chave: this.campeonatos.keySet()) {
			if (this.campeonatos.get(chave.toUpperCase())
					.verificaTimesCampeonatos(this.times.get(codigo.toUpperCase()))) {
				saida += "\n* " + this.campeonatos.get(chave.toUpperCase()).getNomeCampeonato() + 
							" - " + this.campeonatos.get(chave.toUpperCase()).toString();
			}
		}
		return saida;
	}
	
	/**
	 * Cadastra apostas em um time em um campeonato.
	 * @param codigo - o identificador do time.
	 * @param nomeCampeonato - o nome do campeonato.
	 * @param colocacao - a colocação final do time na aposta.
	 * @param valorAposta - o valor da aposta feita.
	 * @return a informação de que o time ou o campeonato não existem no sistema, ou ainda de que a aposta
	 * foi registrada ou não.
	 */
	public String tentaSorteAposta(String codigo, String nomeCampeonato, int colocacao, double valorAposta) {
		Aposta aposta = new Aposta(codigo, nomeCampeonato, colocacao, valorAposta);
		if (!this.times.containsKey(codigo.toUpperCase())) {
			return "O TIME NÃO EXISTE!";
		}
		if (!this.campeonatos.containsKey(nomeCampeonato.toUpperCase())) {
			return "O CAMPEONATO NÃO EXISTE!";
		}
		if (colocacao > this.campeonatos.get(nomeCampeonato.toUpperCase()).getNumParticipantes()) {
			return "APOSTA NÃO REGISTRADA!";
		}
		if (codigo.isBlank() || codigo.isEmpty() || nomeCampeonato.isBlank() || 
				nomeCampeonato.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.apostas.add(aposta);
		return "APOSTA REGISTRADA!";
	}
	
	/**
	 * Lista as apostas cadastradas no sistema.
	 * @return uma string formatada com a listagem das apostas feitas.
	 */
	public String statusApostas() {
		String lista = "Apostas:";
		for (Aposta elemento: this.apostas) {
			lista += "\n" + ((Integer) this.apostas.indexOf(elemento) + 1)
					+ ". [" + elemento.getCodigoAposta() + "] "
					+ "\n" + elemento.getNomeCampeonatoAposta()
					+ "\nR$ " + elemento.getValorAposta();
		}
		return lista;
	}
	
}
