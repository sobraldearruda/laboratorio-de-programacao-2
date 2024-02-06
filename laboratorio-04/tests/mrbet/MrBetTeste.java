/**
 * Laboratório de Programação 2 - Lab04
 * @author Rafael de Arruda Sobral
 */

package mrbet;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MrBetTeste {

    private MrBet mrBetTeste;

    @BeforeEach
    void preparaMrBet() {
        this.mrBetTeste = new MrBet();
    }

    @Test
    void testIncluiTimes() {
        assertEquals(this.mrBetTeste.incluiTimes("250_PB", "Branco", "Pedra"), 
                        "INCLUSÃO REALIZADA!");
    }

    @Test
    void testIncluiTimesCodigoRepetido() {
        assertEquals(this.mrBetTeste.incluiTimes("250_PB", "Branco", "Pedra"), 
                        "INCLUSÃO REALIZADA!");
        assertEquals(this.mrBetTeste.incluiTimes("250_PB", "Preto", "Pássaro"), 
                        "TIME JÁ EXISTE!");
    }

    @Test
    void testIncluiTimesNomeRepetido() {
        assertEquals(this.mrBetTeste.incluiTimes("250_PB", "Branco", "Pedra"), 
                        "INCLUSÃO REALIZADA!");
        assertEquals(this.mrBetTeste.incluiTimes("100_PB", "Branco", "Bola"), 
                        "INCLUSÃO REALIZADA!");
    }

    @Test
    void testIncluiTimesMascoteRepetido() {
        assertEquals(this.mrBetTeste.incluiTimes("250_PB", "Branco", "Pedra"), 
                        "INCLUSÃO REALIZADA!");
        assertEquals(this.mrBetTeste.incluiTimes("100_PB", "Preto", "Pedra"), 
                        "INCLUSÃO REALIZADA!");
    }

    @Test
    void testRecuperaTimes() {
        this.mrBetTeste.incluiTimes("250_PB", "Branco", "Pedra");
        assertEquals(this.mrBetTeste.recuperaTimes("250_PB"), "[250_PB] Branco / Pedra");
    }

    @Test
    void testRecuperaTimesInvalido() {
        this.mrBetTeste.incluiTimes("250_PB", "Branco", "Pedra");
        assertEquals(this.mrBetTeste.recuperaTimes("100_PB"), "TIME NÃO EXISTE!");
    }

    @Test
    void adicionaCampeonato() {
        assertEquals(this.mrBetTeste.adicionaCampeonato("Campeonato Paraibano", 2), 
                        "CAMPEONATO ADICIONADO!");
    }

    @Test
    void adicionaCampeonatoInvalido() {
        assertEquals(this.mrBetTeste.adicionaCampeonato("Campeonato Paraibano", 2), 
                        "CAMPEONATO ADICIONADO!");
        assertEquals(this.mrBetTeste.adicionaCampeonato("Campeonato Paraibano", 10), 
                        "CAMPEONATO JÁ EXISTE!");
    }

    @Test
    void testIncluiTimeCampeonato() {
        this.mrBetTeste.incluiTimes("250_PB", "Branco", "Pedra");
        this.mrBetTeste.adicionaCampeonato("Campeonato Paraibano", 2);
        assertEquals(this.mrBetTeste.incluiTimeCampeonato("250_PB", "Campeonato Paraibano"), 
                        "TIME INCLUÍDO NO CAMPEONATO!");
    }

    @Test
    void testIncluiTimeCampeonatoTimeInvalido() {
        this.mrBetTeste.incluiTimes("250_PB", "Branco", "Pedra");
        this.mrBetTeste.adicionaCampeonato("Campeonato Paraibano", 2);
        assertEquals(this.mrBetTeste.incluiTimeCampeonato("100_PB", "Campeonato Paraibano"), 
                        "TIME NÃO EXISTE!");
    }

    @Test
    void testIncluiTimeCampeonatoInvalido() {
        this.mrBetTeste.incluiTimes("250_PB", "Branco", "Pedra");
        this.mrBetTeste.adicionaCampeonato("Campeonato Paraibano", 2);
        assertEquals(this.mrBetTeste.incluiTimeCampeonato("250_PB", "Campeonato Paulistano"), 
                        "CAMPEONATO NÃO EXISTE!");
    }

    @Test
    void testIncluiTimeCampeonatoLimiteInvalido() {
        this.mrBetTeste.incluiTimes("250_PB", "Branco", "Pedra");
        this.mrBetTeste.adicionaCampeonato("Campeonato Paraibano", 2);
        assertEquals(this.mrBetTeste.incluiTimeCampeonato("250_PB", "Campeonato Paraibano"), 
                        "TIME INCLUÍDO NO CAMPEONATO!");
        this.mrBetTeste.incluiTimes("100_PB", "Preto", "Pássaro");
        assertEquals(this.mrBetTeste.incluiTimeCampeonato("100_PB", "Campeonato Paraibano"), 
                        "TIME INCLUÍDO NO CAMPEONATO!");
        this.mrBetTeste.incluiTimes("555_PB", "Verde", "Tartaruga");
        assertEquals(this.mrBetTeste.incluiTimeCampeonato("555_PB", "Campeonato Paraibano"), 
                        "TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!");
    }
    
    @Test
    void testVerificaTimeCampeonato() {
        this.mrBetTeste.incluiTimes("250_PB", "Branco", "Pedra");
        this.mrBetTeste.adicionaCampeonato("Campeonato Paraibano", 2);
        this.mrBetTeste.incluiTimeCampeonato("250_PB", "Campeonato Paraibano");
        assertEquals(this.mrBetTeste.verificaTimeCampeonato("250_PB", "Campeonato Paraibano"), 
                        "O TIME ESTÁ NO CAMPEONATO!");
    }

    @Test
    void testVerificaTimeCampeonatoTimeInvalido() {
        this.mrBetTeste.adicionaCampeonato("Campeonato Paraibano", 2);
        this.mrBetTeste.incluiTimeCampeonato("250_PB", "Campeonato Paraibano");
        assertEquals(this.mrBetTeste.verificaTimeCampeonato("250_PB", "Campeonato Paraibano"), 
                        "O TIME NÃO EXISTE!");
    }

    @Test
    void testVerificaTimeCampeonatoInvalido() {
        this.mrBetTeste.incluiTimes("250_PB", "Branco", "Pedra");
        this.mrBetTeste.incluiTimeCampeonato("250_PB", "Campeonato Paraibano");
        assertEquals(this.mrBetTeste.verificaTimeCampeonato("250_PB", "Campeonato Paraibano"), 
                        "O CAMPEONATO NÃO EXISTE!");
    }

    @Test
    void testVerificaTimeCampeonatoTimeNaoCadastrado() {
        this.mrBetTeste.incluiTimes("250_PB", "Branco", "Pedra");
        this.mrBetTeste.adicionaCampeonato("Campeonato Paraibano", 2);
        assertEquals(this.mrBetTeste.verificaTimeCampeonato("250_PB", "Campeonato Paraibano"), 
                        "O TIME NÃO ESTÁ NO CAMPEONATO!");
    }

    @Test
    void testExibeTimeCampeonatoParticipante() {
        this.mrBetTeste.incluiTimes("250_PB", "Branco", "Pedra");
        this.mrBetTeste.adicionaCampeonato("Campeonato Paraibano", 2);
        this.mrBetTeste.incluiTimeCampeonato("250_PB", "Campeonato Paraibano");
        assertEquals(this.mrBetTeste.exibeTimeCampeonatoParticipante("250_PB"), 
                        "Campeonatos do Branco:\n* Campeonato Paraibano - 1/2");
    }

    @Test
    void testExibeTimeCampeonatoParticipanteTimeInvalido() {
        this.mrBetTeste.adicionaCampeonato("Campeonato Paraibano", 2);
        this.mrBetTeste.incluiTimeCampeonato("250_PB", "Campeonato Paraibano");
        assertEquals(this.mrBetTeste.exibeTimeCampeonatoParticipante("250_PB"), 
                        "TIME NÃO CADASTRADO NO SISTEMA!");
    }

    @Test
    void testTentaSorteAposta() {
        this.mrBetTeste.incluiTimes("250_PB", "Branco", "Pedra");
        this.mrBetTeste.adicionaCampeonato("Campeonato Paraibano", 2);
        this.mrBetTeste.incluiTimeCampeonato("250_PB", "Campeonato Paraibano");
        assertEquals(this.mrBetTeste.tentaSorteAposta("250_PB", "Campeonato Paraibano", 
                                1, 250.50), "APOSTA REGISTRADA!");
    }

    @Test
    void testTentaSorteApostaTimeInvalido() {
        this.mrBetTeste.adicionaCampeonato("Campeonato Paraibano", 2);
        this.mrBetTeste.incluiTimeCampeonato("250_PB", "Campeonato Paraibano");
        assertEquals(this.mrBetTeste.tentaSorteAposta("250_PB", "Campeonato Paraibano", 
                                1, 250.50), "O TIME NÃO EXISTE!");
    }

    @Test
    void testTentaSorteApostaCampeonatoInvalido() {
        this.mrBetTeste.incluiTimes("250_PB", "Branco", "Pedra");
        this.mrBetTeste.incluiTimeCampeonato("250_PB", "Campeonato Paraibano");
        assertEquals(this.mrBetTeste.tentaSorteAposta("250_PB", "Campeonato Paraibano", 
                                1, 250.50), "O CAMPEONATO NÃO EXISTE!");
    }

    @Test
    void testTentaSorteApostaColocacaoInvalida() {
        this.mrBetTeste.incluiTimes("250_PB", "Branco", "Pedra");
        this.mrBetTeste.adicionaCampeonato("Campeonato Paraibano", 2);
        this.mrBetTeste.incluiTimeCampeonato("250_PB", "Campeonato Paraibano");
        assertEquals(this.mrBetTeste.tentaSorteAposta("250_PB", "Campeonato Paraibano", 
                                5, 250.50), "APOSTA NÃO REGISTRADA!");
    }

    @Test
    void testStatusAposta() {
        this.mrBetTeste.incluiTimes("250_PB", "Branco", "Pedra");
        this.mrBetTeste.adicionaCampeonato("Campeonato Paraibano", 2);
        this.mrBetTeste.incluiTimeCampeonato("250_PB", "Campeonato Paraibano");
        this.mrBetTeste.tentaSorteAposta("250_PB", "Campeonato Paraibano", 
                                1, 250);
        assertEquals(this.mrBetTeste.statusApostas(), "Apostas:\n1. [250_PB] \nCampeonato Paraibano\nR$ 250.0");
    }

    @Test
    void testStatusApostaInvalido() {
        try {
            this.mrBetTeste.incluiTimes("250_PB", "Branco", "Pedra");
            this.mrBetTeste.adicionaCampeonato("Campeonato Paraibano", 2);
            this.mrBetTeste.incluiTimeCampeonato("250_PB", "Campeonato Paraibano");
            this.mrBetTeste.statusApostas();
        } catch (RuntimeException e) {
            /**
             * Nenhuma aposta registrada no sistema.
             */
        }
    }
    
}
