/**
 * Laboratório de Programação 2 - Lab04
 * @author Rafael de Arruda Sobral
 */

package mrbet;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ApostaTeste {

    private Aposta apostaTeste;

    @BeforeEach
    void preparaAposta() {
        this.apostaTeste = new Aposta("250_PB", "Campeonato Paraibano", 
                                1, 250.50);
    }

    @Test
    void testCodigoAposta() {
        assertEquals(this.apostaTeste.getCodigoAposta(), "250_PB");
    }

    @Test
    void testCodigoApostaInvalido() {
        assertFalse(this.apostaTeste.getCodigoAposta().equals("150_PB"));
    }

    @Test
    void testNomeCampeonatoAposta() {
        assertEquals(this.apostaTeste.getNomeCampeonatoAposta(), "Campeonato Paraibano");
    }

    @Test
    void testNomeCampeonatoApostaInvalido() {
        assertFalse(this.apostaTeste.getNomeCampeonatoAposta().equals("Campeonato Paulistano"));
    }

    @Test
    void testColocacaoAposta() {
        assertEquals(this.apostaTeste.getColocacaoAposta(), 1);
    }

    @Test
    void testColocacaoApostaInvalido() {
        assertNotEquals(this.apostaTeste.getColocacaoAposta(), 5);
    }

    @Test
    void testValorAposta() {
        assertEquals(this.apostaTeste.getValorAposta(), 250.50);
    }

    @Test
    void testValorApostaInvalido() {
        assertNotEquals(this.apostaTeste.getValorAposta(), 200);
    }

    @Test
    void testToString() {
        assertEquals(this.apostaTeste.toString(), "Campeonato Paraibano\n" + 1 + "/" + "\nR$ " + 250.50);
    }

    @Test
    void testToStringInvalido() {
        assertFalse(this.apostaTeste.toString().equals("Campeonato Paulistano\n" + 1 + "/" + "\nR$ " + 250.50));
    }
    
}
