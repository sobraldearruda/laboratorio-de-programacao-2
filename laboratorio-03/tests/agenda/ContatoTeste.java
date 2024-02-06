/**
 * Laboratório de Programação 2 - Lab03
 * @author Rafael de Arruda Sobral
 */

package agenda;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContatoTeste {

	private Contato contatoTeste;
	
	@BeforeEach
	void preparaContato() {
		this.contatoTeste = new Contato("Rafael", "Sobral", "(83) 11111-2222");
	}
	
	@Test
	void testContatoIgual() {
		Contato contato = new Contato("Rafael", "Sobral", "(83) 11111-2222");
		assertTrue(this.contatoTeste.equals(contato));
	}
	
	@Test
	void testContatoIgualTelefoneDiferente() {
		Contato contato = new Contato("Rafael", "Sobral", "(83) 11111-1111");
		assertTrue(this.contatoTeste.equals(contato));
	}
	
	@Test
	void testContatoDiferente() {
		Contato contato = new Contato("André", "Felipe", "(83) 98867-5499");
		assertFalse(this.contatoTeste.equals(contato));
	}

	@Test
	void testContatoSobrenomeDiferente() {
		Contato contato = new Contato("Rafael", "Gaudêncio", "(83) 98986-5988");
		assertFalse(this.contatoTeste.equals(contato));
	}
	
	@Test
	void testContatoNomeDiferente() {
		Contato contato = new Contato("Mateus", "Sobral", "(83) 98657-4351");
		assertFalse(this.contatoTeste.equals(contato));
	}
	
	@Test
	void testToString() {
		assertEquals(this.contatoTeste.toString(), "Rafael Sobral\n(83) 11111-2222");
	}

}
