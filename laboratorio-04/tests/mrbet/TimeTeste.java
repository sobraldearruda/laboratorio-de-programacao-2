/**
 * Laboratório de Programação 2 - Lab04
 * @author Rafael de Arruda Sobral
 */

package mrbet;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TimeTeste {
    
    private Time timeTeste;

    @BeforeEach
    void preparaTime() {
        this.timeTeste = new Time("250_PB", "Branco", "Pedra");
    }

    @Test
    void testCodigoTime() {
        assertEquals(this.timeTeste.getCodigo(), "250_PB");
    }

    @Test
    void testCodigoTimeInvalido() {
        assertFalse(this.timeTeste.getCodigo().equals("150_PB"));
    }

    @Test
    void testNomeTime() {
        assertEquals(this.timeTeste.getNome(), "Branco");
    }

    @Test
    void testNomeTimeInvalido() {
        assertFalse(this.timeTeste.getNome().equals("Preto"));
    }

    @Test
    void testToString() {
        assertEquals(this.timeTeste.toString(), "[250_PB] Branco / Pedra");
    }

    @Test
    void testToStringInvalido() {
        assertFalse(this.timeTeste.toString().equals("[250_PB] Preto / Pedra"));
    }

}
