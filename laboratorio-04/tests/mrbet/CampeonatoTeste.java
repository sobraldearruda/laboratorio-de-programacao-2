/**
 * Laboratório de Programação 2 - Lab04
 * @author Rafael de Arruda Sobral
 */

 package mrbet;

 import static org.junit.jupiter.api.Assertions.*;
 import org.junit.jupiter.api.BeforeEach;
 import org.junit.jupiter.api.Test;

public class CampeonatoTeste {

    private Campeonato campeonatoTeste;
    private Time timeTeste;

    @BeforeEach
    void preparaCampeonato() {
        this.campeonatoTeste = new Campeonato("Campeonato Paraibano", 5);
        this.timeTeste = new Time("250_PB", "Branco", "Pedra");
    }

    @Test
    void testCampeonatoIgual() {
        Campeonato campeonato = new Campeonato("Campeonato Paraibano", 5);
        assertTrue(this.campeonatoTeste.equals(campeonato));
    }

    @Test
    void testCampeonatoDiferente() {
        Campeonato campeonato = new Campeonato("Campeonato Paulistano", 10);
        assertFalse(this.campeonatoTeste.equals(campeonato));
    }

    @Test
    void testAdicionaTimesCampeonatos() {
        assertTrue(this.campeonatoTeste.adicionaTimesCampeonatos(this.timeTeste));
    }

    @Test
    void testAdicionaTimesCampeonatosInvalido() {
        assertTrue(this.campeonatoTeste.adicionaTimesCampeonatos(this.timeTeste));
        Time timeDois = new Time("320_PB", "Vermelho", "Cachorro");
        assertTrue(this.campeonatoTeste.adicionaTimesCampeonatos(timeDois));
        Time timeTres = new Time("150_PB", "Amarelo", "Pato");
        assertTrue(this.campeonatoTeste.adicionaTimesCampeonatos(timeTres));
        Time timeQuatro = new Time("100_PB", "Verde", "Tartaruga");
        assertTrue(this.campeonatoTeste.adicionaTimesCampeonatos(timeQuatro));
        Time timeCinco = new Time("500_PB", "Azul", "Peixe");
        assertTrue(this.campeonatoTeste.adicionaTimesCampeonatos(timeCinco));
        Time timeSeis = new Time("999_PB", "Rosa", "Flor");
        assertFalse(this.campeonatoTeste.adicionaTimesCampeonatos(timeSeis));
    }

    @Test
    void testVerificaTimesCampeonatos() {
        this.campeonatoTeste.adicionaTimesCampeonatos(this.timeTeste);
        assertTrue(this.campeonatoTeste.verificaTimesCampeonatos(this.timeTeste));
    }

    @Test
    void testVerificaTimesCampeonatosInvalido() {
        assertFalse(this.campeonatoTeste.verificaTimesCampeonatos(this.timeTeste));
    }

    @Test
    void testToString() {
        this.campeonatoTeste.adicionaTimesCampeonatos(this.timeTeste);
        Time timeDois = new Time("320_PB", "Vermelho", "Cachorro");
        this.campeonatoTeste.adicionaTimesCampeonatos(timeDois);
        assertEquals(this.campeonatoTeste.toString(), 2 + "/" + 5);
    }

    @Test
    void testToStringInvalido() {
        this.campeonatoTeste.adicionaTimesCampeonatos(this.timeTeste);
        Time timeDois = new Time("320_PB", "Vermelho", "Cachorro");
        this.campeonatoTeste.adicionaTimesCampeonatos(timeDois);
        assertFalse(this.campeonatoTeste.toString().equals(1 + "/" + 5));
    }
    
}
