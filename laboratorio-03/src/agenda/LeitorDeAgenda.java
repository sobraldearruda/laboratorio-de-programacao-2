/**
 * Laboratório de Programação 2 - Lab03
 * @author Rafael de Arruda Sobral
 */

package agenda;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Lógica para ler de arquivos CSV os dados necessários e povoar uma agenda.
 * @author nazarenoandrade
 */
public class LeitorDeAgenda {

	private static final int COLUNA_POSICAO = 0;
	private static final int COLUNA_NOME = 1;
	private static final int COLUNA_SOBRENOME = 2;
	private static final int COLUNA_TELEFONE = 3;

	/**
	 * Lê contatos de um arquivo CSV e os coloca em uma agenda.
	 * @param arquivoContatos - caminho para arquivo contendo contatos.
	 * @param agenda - a agenda a manipular.
	 * @return o número de contatos adicionados à agenda.
	 * @throws IOException caso não tenhamos permissão de ler o arquivo.
	 * @throws FileNotFoundException caso o arquivo não exista.
	 */
	public int carregaContatos(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		int carregados = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(arquivoContatos))) {
			String linha;
			while ((linha = br.readLine()) != null) {
				carregados += 1;
				if (carregados == 1) {
					// pulamos a primeira linha, o cabeçalho.
					continue;
				}
				String[] campos = linha.split(",");
				processaLinhaCsvContatos(campos, agenda);
			}
		}
		return carregados;
	}

	/**
	 * Coloca na agenda os dados de uma linha do arquivo de agenda inicial.
	 * @param campos - as informações lidas do CSV.
	 * @param agenda - a agenda a manipular.
	 */
	private void processaLinhaCsvContatos(String[] campos, Agenda agenda) {
		int posicao = Integer.parseInt(campos[COLUNA_POSICAO]);
		String nome = campos[COLUNA_NOME].trim();
		String sobrenome = campos[COLUNA_SOBRENOME].trim();
		String telefone = campos[COLUNA_TELEFONE].trim();
		agenda.cadastraContato(posicao, nome, sobrenome, telefone);
	}

}
