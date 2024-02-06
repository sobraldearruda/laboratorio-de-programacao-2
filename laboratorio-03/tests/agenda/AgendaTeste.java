/**
 * Laboratório de Programação 2 - Lab03
 * @author Rafael de Arruda Sobral
 */

package agenda;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AgendaTeste {
	
	private Agenda agendaTeste;
	
	@BeforeEach
	void preparaAgenda() {
		this.agendaTeste = new Agenda();
	}

	@Test
	void testCadastraContato() {
		assertEquals(this.agendaTeste.cadastraContato(1, "Matheus", "Gaudêncio", 
						"(83) 99999-0000"), "CADASTRO REALIZADO");
	}
	
	@Test
	void testCadastraContatoSubstituido() {
		assertEquals(this.agendaTeste.cadastraContato(1, "Matheus", "Gaudêncio", 
						"(83) 99999-0000"), "CADASTRO REALIZADO");
		assertEquals(this.agendaTeste.cadastraContato(1, "Pedro", "Silva", 
						"(83) 98888-1111"), "CADASTRO REALIZADO");
	}
	
	@Test
	void testCadastraContatoRepetido() {
		assertEquals(this.agendaTeste.cadastraContato(1, "Matheus", "Gaudêncio", 
						"(83) 99999-0000"), "CADASTRO REALIZADO");
		assertEquals(this.agendaTeste.cadastraContato(3, "Matheus", "Gaudêncio", 
						"(83) 99999-0000"), "CONTATO JÁ CADASTRADO");
	}
	
	@Test
	void testCadastraContatoLimite() {
		assertEquals(this.agendaTeste.cadastraContato(100, "Maria", "Madalena", 
						"(83) 11111-0000"), "CADASTRO REALIZADO");
	}

	@Test
	void testCadastraContatoLimiteInferior() {
		assertEquals(this.agendaTeste.cadastraContato(0, "Matheus", "Gaudêncio", 
						"(83) 99999-0000"), "POSIÇÃO INVÁLIDA");
	}
	
	@Test
	void testCadastraContatoLimiteSuperior() {
		assertEquals(this.agendaTeste.cadastraContato(101, "Matheus", "Gaudêncio", 
						"(83) 99999-0000"), "POSIÇÃO INVÁLIDA");
	}
	
	@Test
	void testCadastraContatoSemTelefone() {
		assertEquals(this.agendaTeste.cadastraContato(1, "Matheus", "Gaudêncio", 
						""), "CONTATO INVÁLIDO");
	}
	
	@Test
	void testCadastraContatoSemNome() {
		assertEquals(this.agendaTeste.cadastraContato(1, "", "Gaudêncio", 
						"(83) 99999-0000"), "CONTATO INVÁLIDO");
	}

	@Test
	void testCadastraContatoSemSobrenome() {
		assertEquals(this.agendaTeste.cadastraContato(1, "Matheus", "", 
						"(83) 99999-0000"), "CONTATO INVÁLIDO");
	}

	@Test
	void testListaContatos() {
		this.agendaTeste.cadastraContato(1, "Matheus", "Gaudêncio", 
						"(83) 99999-0000");
		this.agendaTeste.cadastraContato(2, "Rafael", "Sobral", 
						"(83) 11111-2222");
		assertEquals(("1 - Matheus Gaudêncio\n" + 
						"2 - Rafael Sobral"), this.agendaTeste.listaContatos());
	}

	@Test
	void testListaContatosInexistentes() {
		try {
			this.agendaTeste.listaContatos();
		} catch (NullPointerException e) {
		}
	}

	@Test
	void testExibeContato() {
		this.agendaTeste.cadastraContato(1, "Matheus", "Gaudêncio", 
						"(83) 99999-0000");
		assertEquals(("Matheus Gaudêncio\n(83) 99999-0000"), this.agendaTeste.exibeContato(1));
	}

	@Test
	void testExibeContatoInexistente() {
		try {
			this.agendaTeste.exibeContato(100);
		} catch (NullPointerException e) {
		}
	}

	@Test
	void testExibeContatoFavorito() {
		this.agendaTeste.cadastraContato(1, "Matheus", "Gaudêncio", 
						"(83) 99999-0000");
		this.agendaTeste.adicionaFavorito(1, 1);
		assertEquals(("❤️ Matheus Gaudêncio\n(83) 99999-0000"), this.agendaTeste.exibeContato(1));
	}

	@Test
	void testExibeContatoFavoritoInexistente() {
		try {
			this.agendaTeste.cadastraContato(1, "Matheus", "Gaudêncio", 
							"(83) 99999-0000");
			this.agendaTeste.adicionaFavorito(1, 1);
			this.agendaTeste.exibeContato(8);
		} catch (NullPointerException e) {
		}
	}
	
	@Test
	void testExibeContatoLimiteInferior() {
		try {
			this.agendaTeste.exibeContato(0);
		} catch (IndexOutOfBoundsException e) {
		}
	}
	
	@Test
	void testExibeContatoLimiteSuperior() {
		try {
			this.agendaTeste.exibeContato(101);
		} catch (IndexOutOfBoundsException e) {	
		}
	}

	@Test
	void testAdicionaFavorito() {
		this.agendaTeste.cadastraContato(1, "Matheus", "Gaudêncio", 
						"(83) 99999-0000");
		this.agendaTeste.adicionaFavorito(1, 1);
		assertEquals("❤️ Matheus Gaudêncio\n(83) 99999-0000", this.agendaTeste.exibeContato(1));
	}

	@Test
	void testAdicionaFavoritoSubstituido() {
		this.agendaTeste.cadastraContato(1, "Matheus", "Gaudêncio", 
						"(83) 99999-0000");
		this.agendaTeste.adicionaFavorito(1, 1);
		this.agendaTeste.cadastraContato(2, "Rafael", "Sobral", 
						"(83) 98604-3788");
		this.agendaTeste.adicionaFavorito(2, 1);
		assertEquals("Matheus Gaudêncio\n(83) 99999-0000", this.agendaTeste.exibeContato(1));
		assertEquals("❤️ Rafael Sobral\n(83) 98604-3788", this.agendaTeste.exibeContato(2));
	}

	@Test
	void testAdicionaFavoritoLimiteInferior() {
		try {
			this.agendaTeste.cadastraContato(1, "Matheus", "Gaudêncio", 
							"(83) 99999-0000");
			this.agendaTeste.adicionaFavorito(1, 0);
		} catch(IndexOutOfBoundsException e) {
		}
	}
	
	@Test
	void testAdicionaFavoritoLimiteSuperior() {
		try {
			this.agendaTeste.cadastraContato(1, "Matheus", "Gaudêncio", 
							"(83) 99999-0000");
			this.agendaTeste.adicionaFavorito(1, 11);
		} catch(IndexOutOfBoundsException e) {
		}
	}
	
	@Test
	void testAdicionaFavoritoInexistente() {
		try {
			this.agendaTeste.adicionaFavorito(1, 1);
		} catch(NullPointerException e) {
		}
	}
	
	@Test
	void testAdicionaFavoritoDuplicado() {
		try {
			this.agendaTeste.cadastraContato(1, "Matheus", "Gaudêncio", 
							"(83) 99999-0000");
			this.agendaTeste.adicionaFavorito(1, 1);
			this.agendaTeste.adicionaFavorito(1, 5);
		} catch (RuntimeException e) {
		}
	}

	@Test
	void testListaFavoritos() {
		this.agendaTeste.cadastraContato(1, "Matheus", "Gaudêncio", 
						"(83) 99999-0000");
		this.agendaTeste.adicionaFavorito(1, 1);
		this.agendaTeste.cadastraContato(2, "Rafael", "Sobral", 
						"(83) 11111-2222");
		this.agendaTeste.adicionaFavorito(2, 2);
		assertEquals(("1 - Matheus Gaudêncio\n" + 
						"2 - Rafael Sobral"), this.agendaTeste.listaFavoritos());
	}

	@Test
	void testListaFavoritosInexistentes() {
		try {
			this.agendaTeste.listaFavoritos();
		} catch (NullPointerException e) {
		}
	}

	@Test
	void testRemoveFavorito() {
		this.agendaTeste.cadastraContato(1, "Matheus", "Gaudêncio", 
						"(83) 99999-0000");
		this.agendaTeste.adicionaFavorito(1, 1);
		this.agendaTeste.removeFavorito(1);
		assertEquals("Matheus Gaudêncio\n(83) 99999-0000", this.agendaTeste.exibeContato(1));
	}

	@Test
	void testRemoveFavoritoLimiteInferior() {
		try {
			this.agendaTeste.cadastraContato(1, "Matheus", "Gaudêncio", 
								"(83) 99999-0000");
			this.agendaTeste.removeFavorito(0);
		} catch (IndexOutOfBoundsException e) {
		}
	}
	
	@Test
	void testRemoveFavoritoLimiteSuperior() {
		try {
			this.agendaTeste.cadastraContato(1, "Matheus", "Gaudêncio", 
								"(83) 99999-0000");
			this.agendaTeste.removeFavorito(11);
		} catch (IndexOutOfBoundsException e) {
		}
	}
	
	@Test
	void testRemoveFavoritoInexistente() {
		try {
			this.agendaTeste.removeFavorito(1);
		} catch (NullPointerException e) {
		}
	}

}
