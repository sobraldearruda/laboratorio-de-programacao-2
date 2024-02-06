/**
 * Laboratório de Programação 2 - Lab05
 * @author Rafael de Arruda Sobral
 */

package documin;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import documin.controllers.DocumentoController;
import java.util.*;

public class DocumentoControllerTeste {

    private DocumentoController controllerTeste;

    @BeforeEach
    void preparaController() {
        this.controllerTeste = new DocumentoController();
    }

    @Test
    void testValidaTituloNulo() {
        try {
            this.controllerTeste.criaDocumento(null);
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    void testValidaTituloInvalido() {
        try {
            this.controllerTeste.criaDocumento(" ");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    void testValidaTituloNaoCadastrado() {
        try {
            this.controllerTeste.exibeDocumento("Redação");
        } catch (NoSuchElementException e) {
        }
    }

    @Test
    void testCriaDocumento() {
        assertTrue(this.controllerTeste.criaDocumento("Redação"));
    }

    @Test
    void testCriaDocumentoRepetido() {
        assertTrue(this.controllerTeste.criaDocumento("Redação"));
        assertFalse(this.controllerTeste.criaDocumento("Redação"));
    }

    @Test
    void testCriaDocumentoComTamanho() {
        assertTrue(this.controllerTeste.criaDocumento("Redação", 5));
    }

    @Test
    void testCriaDocumentoRepetidoComTamanho() {
        assertTrue(this.controllerTeste.criaDocumento("Redação", 5));
        assertFalse(this.controllerTeste.criaDocumento("Redação", 5));
    }

    @Test
    void testCriaDocumentoTamanhoInvalido() {
        try {
            this.controllerTeste.criaDocumento("Redação", 0);
        } catch (IndexOutOfBoundsException e) {
        }
    }

    @Test
    void testRemoveDocumento() {
        try {
            this.controllerTeste.criaDocumento("Redação", 5);
            this.controllerTeste.removeDocumento("Redação");
            this.controllerTeste.exibeDocumento("Redação");
        } catch (NoSuchElementException e) {
        }
    }

    @Test
    void testContaElementos() {
        this.controllerTeste.criaDocumento("Redação", 5);
        assertEquals(this.controllerTeste.contaElementos("Redação"), 0);
    }

    @Test
    void testExibeDocumentoTexto() {
        this.controllerTeste.criaDocumento("Redação", 5);
        this.controllerTeste.criaTexto("Redação", "Exemplo de texto", 5);
        assertEquals(Arrays.toString(this.controllerTeste.exibeDocumento("Redação")), 
                        "[Exemplo de texto]");
    }

    @Test
    void testExibeDocumentoTitulo() {
        this.controllerTeste.criaDocumento("Redação", 5);
        this.controllerTeste.criaTitulo("Redação", "Exemplo de título", 5, 
                                1, true);
        assertEquals(Arrays.toString(this.controllerTeste.exibeDocumento("Redação")), 
                        "[1. Exemplo de título--\n1-EXEMPLODETÍTULO]");
    }

    @Test
    void testExibeDocumentoLista() {
        this.controllerTeste.criaDocumento("Redação", 5);
        this.controllerTeste.criaLista("Redação", "Exemplo | de | lista", 1, 
                                "|", "-");
        assertEquals(Arrays.toString(this.controllerTeste.exibeDocumento("Redação")), 
                        "[- Exemplo\n- de\n- lista]");
    }

    @Test
    void testExibeDocumentoTermosOrdemAlfabetica() {
        this.controllerTeste.criaDocumento("Redação", 5);
        this.controllerTeste.criaTermos("Redação", "Exemplo / termos / aleatórios", 
                                1, "/", "alfabética");
        assertEquals(Arrays.toString(this.controllerTeste.exibeDocumento("Redação")), 
                        "[Total termos: 3\n- aleatórios, Exemplo, termos]");
    }

    @Test
    void testExibeDocumentoTermosSemOrdem() {
        this.controllerTeste.criaDocumento("Redação", 5);
        this.controllerTeste.criaTermos("Redação", "Exemplo / termos / aleatórios", 
                                1, "/", "nenhum");
        assertEquals(Arrays.toString(this.controllerTeste.exibeDocumento("Redação")), 
                        "[Total termos: 3\n- Exemplo, termos, aleatórios]");
    }

    @Test
    void testExibeDocumentoTermosOrdemTamanho() {
        this.controllerTeste.criaDocumento("Redação", 5);
        this.controllerTeste.criaTermos("Redação", "Exemplo / termos / aleatórios", 
                                1, "/", "tamanho");
        assertEquals(Arrays.toString(this.controllerTeste.exibeDocumento("Redação")), 
                        "[Total termos: 3\n- aleatórios, Exemplo, termos]");
    }

    @Test
    void testExibeDocumentoSemElementos() {
        this.controllerTeste.criaDocumento("Redação", 5);
        assertEquals(Arrays.toString(this.controllerTeste.exibeDocumento("Redação")), 
                        "[]");
    }

    @Test
    void testCriaTexto() {
        this.controllerTeste.criaDocumento("Redação", 5);
        this.controllerTeste.criaTexto("Redação", "Exemplo de texto", 1);
        assertEquals(this.controllerTeste.pegaRepresentacaoCompleta("Redação", 0), 
                        "Exemplo de texto");
    }

    @Test
    void testCriaTextoPosicaoInvalida() {
        try {
            this.controllerTeste.criaDocumento("Redação", 5);
            this.controllerTeste.criaTexto("Redação", "Exemplo de texto", 1);
            this.controllerTeste.pegaRepresentacaoCompleta("Redação", 7);
        } catch (IndexOutOfBoundsException e) {
        }
    }

    @Test
    void testCriaTitulo() {
        this.controllerTeste.criaDocumento("Redação", 5);
        this.controllerTeste.criaTitulo("Redação", "Exemplo de título", 5, 
                                1, true);
        assertEquals(this.controllerTeste.pegaRepresentacaoCompleta("Redação", 0), 
                        "1. Exemplo de título--\n1-EXEMPLODETÍTULO");
    }

    @Test
    void testCriaTituloPosicaoInvalida() {
        try {
            this.controllerTeste.criaDocumento("Redação", 5);
            this.controllerTeste.criaTitulo("Redação", "Exemplo de título", 5, 
                                1, true);
            this.controllerTeste.pegaRepresentacaoCompleta("Redação", 7);
        } catch (IndexOutOfBoundsException e) {
        }
    }

    @Test
    void testCriaLista() {
        this.controllerTeste.criaDocumento("Redação", 5);
        this.controllerTeste.criaLista("Redação", "Exemplo | de | lista", 1, 
                                "|", "-");
        assertEquals(this.controllerTeste.pegaRepresentacaoCompleta("Redação", 0), 
                        "- Exemplo\n- de\n- lista");
    }

    @Test
    void testCriaListaPosicaoInvalida() {
        try {
            this.controllerTeste.criaDocumento("Redação", 5);
            this.controllerTeste.criaLista("Redação", "Exemplo | de | lista", 1, 
                                "|", "-");
            this.controllerTeste.pegaRepresentacaoCompleta("Redação", 7);
        } catch (IndexOutOfBoundsException e) {
        }
    }

    @Test
    void testCriaTermos() {
        this.controllerTeste.criaDocumento("Redação", 5);
        this.controllerTeste.criaTermos("Redação", "Exemplo / termos / aleatórios", 
                                1, "/", "alfabética");
        assertEquals(this.controllerTeste.pegaRepresentacaoCompleta("Redação", 0), 
                        "Total termos: 3\n- aleatórios, Exemplo, termos");
    }

    @Test
    void testCriaTermosPosicaoInvalida() {
        try {
            this.controllerTeste.criaDocumento("Redação", 5);
            this.controllerTeste.criaTermos("Redação", "Exemplo / termos / aleatórios", 
                                1, "/", "nenhum");
            this.controllerTeste.pegaRepresentacaoCompleta("Redação", 7);
        } catch (IndexOutOfBoundsException e) {
        }
    }

    @Test
    void testPegaRepresentacaoCompleta() {
        this.controllerTeste.criaDocumento("Redação", 5);
        this.controllerTeste.criaTexto("Redação", "Exemplo de texto", 1);
        assertEquals(this.controllerTeste.pegaRepresentacaoCompleta("Redação", 0), 
                        "Exemplo de texto");
    }

    @Test
    void testPegaRepresentacaoCompletaInvalido() {
        try {
            this.controllerTeste.criaDocumento("Redação", 5);
            this.controllerTeste.criaTexto("Redação", "Exemplo de texto", 1);
            this.controllerTeste.pegaRepresentacaoCompleta("Redação", 7);
        } catch (IndexOutOfBoundsException e) {
        }
    }

    @Test
    void testPegaRepresentacaoResumidaTexto() {
        this.controllerTeste.criaDocumento("Redação", 5);
        this.controllerTeste.criaTexto("Redação", "Exemplo de texto", 1);
        assertEquals(this.controllerTeste.pegaRepresentacaoResumida("Redação", 0), 
                        "Exemplo de texto");
    }

    @Test
    void testPegaRepresentacaoResumidaTextoInvalido() {
        try {
            this.controllerTeste.criaDocumento("Redação", 5);
            this.controllerTeste.criaTexto("Redação", "Exemplo de texto", 1);
            this.controllerTeste.pegaRepresentacaoResumida("Redação", 7);
        } catch (IndexOutOfBoundsException e) {
        }
    }

    @Test
    void testPegaRepresentacaoResumidaTitulo() {
        this.controllerTeste.criaDocumento("Redação", 5);
        this.controllerTeste.criaTitulo("Redação", "Exemplo de título", 5, 
                                1, true);
        assertEquals(this.controllerTeste.pegaRepresentacaoResumida("Redação", 0), 
                        "1. Exemplo");
    }

    @Test
    void testPegaRepresentacaoResumidaTituloInvalido() {
        try {
            this.controllerTeste.criaDocumento("Redação", 5);
            this.controllerTeste.criaTitulo("Redação", "Exemplo de título", 5, 
                                1, true);
            this.controllerTeste.pegaRepresentacaoResumida("Redação", 7);
        } catch (IndexOutOfBoundsException e) {
        }
    }

    @Test
    void testPegaRepresentacaoResumidaLista() {
        this.controllerTeste.criaDocumento("Redação", 5);
        this.controllerTeste.criaLista("Redação", "Exemplo | de | lista", 1, 
                                "|", "-");
        assertEquals(this.controllerTeste.pegaRepresentacaoResumida("Redação", 0), 
                        "Exemplo, de, lista");
    }

    @Test
    void testPegaRepresentacaoResumidaListaInvalido() {
        try {
            this.controllerTeste.criaDocumento("Redação", 5);
            this.controllerTeste.criaLista("Redação", "Exemplo | de | lista", 1, 
                                "|", "-");
            this.controllerTeste.pegaRepresentacaoResumida("Redação", 7);
        } catch (IndexOutOfBoundsException e) {
        }
    }

    @Test
    void testPegaRepresentacaoResumidaTermosOrdemAlfabetica() {
        this.controllerTeste.criaDocumento("Redação", 5);
        this.controllerTeste.criaTermos("Redação", "Exemplo / termos / aleatórios", 
                                1, "/", "alfabética");
        assertEquals(this.controllerTeste.pegaRepresentacaoResumida("Redação", 0), 
                        "aleatórios / Exemplo / termos");
    }

    @Test
    void testPegaRepresentacaoResumidaTermosSemOrdem() {
        this.controllerTeste.criaDocumento("Redação", 5);
        this.controllerTeste.criaTermos("Redação", "Exemplo / termos / aleatórios", 
                                1, "/", "nenhum");
        assertEquals(this.controllerTeste.pegaRepresentacaoResumida("Redação", 0), 
                        "Exemplo / termos / aleatórios");
    }

    @Test
    void testPegaRepresentacaoResumidaTermosOrdemTamanho() {
        this.controllerTeste.criaDocumento("Redação", 5);
        this.controllerTeste.criaTermos("Redação", "Exemplo / termos / aleatórios", 
                                1, "/", "tamanho");
        assertEquals(this.controllerTeste.pegaRepresentacaoResumida("Redação", 0), 
                        "aleatórios / Exemplo / termos");
    }

    @Test
    void testPegaRepresentacaoResumidaTermosInvalido() {
        try {
            this.controllerTeste.criaDocumento("Redação", 5);
            this.controllerTeste.criaTermos("Redação", "Exemplo / termos / aleatórios", 
                                1, "/", "alfabética");
            this.controllerTeste.pegaRepresentacaoResumida("Redação", 7);
        } catch (IndexOutOfBoundsException e) {
        }
    }

    @Test
    void testApagaElemento() {
        this.controllerTeste.criaDocumento("Redação", 5);
        this.controllerTeste.criaTexto("Redação", "Exemplo de texto", 1);
        assertTrue(this.controllerTeste.apagaElemento("Redação", 0));
    }

    @Test
    void testApagaElementoInvalido() {
        try {
            this.controllerTeste.criaTexto("Redação", "Exemplo de texto", 1);
            this.controllerTeste.apagaElemento("Redação", 0);
        } catch (NoSuchElementException e) {
        }
    }

    @Test
    void testMoveParaCima() {
        this.controllerTeste.criaDocumento("Redação", 5);
        this.controllerTeste.criaTexto("Redação", "Exemplo de texto", 1);
        this.controllerTeste.criaTexto("Redação", "Outro exemplo de texto", 3);
        this.controllerTeste.moveParaCima("Redação", 1);
        assertEquals(this.controllerTeste.pegaRepresentacaoCompleta("Redação", 0), 
                        "Outro exemplo de texto");
    }

    @Test
    void testMoveParaCimaInvalido() {
        try {
            this.controllerTeste.criaDocumento("Redação", 5);
            this.controllerTeste.criaTexto("Redação", "Exemplo de texto", 1);
            this.controllerTeste.criaTexto("Redação", "Outro exemplo de texto", 3);
            this.controllerTeste.moveParaCima("Redação", 10);
        } catch (IndexOutOfBoundsException e) {
        }
    }

    @Test
    void testMoveParaBaixo() {
        this.controllerTeste.criaDocumento("Redação", 5);
        this.controllerTeste.criaTexto("Redação", "Exemplo de texto", 1);
        this.controllerTeste.criaTexto("Redação", "Outro exemplo de texto", 3);
        this.controllerTeste.moveParaBaixo("Redação", 0);
        assertEquals(this.controllerTeste.pegaRepresentacaoCompleta("Redação", 1), 
                        "Exemplo de texto");
    }

    @Test
    void testMoveParaBaixoInvalido() {
        try {
            this.controllerTeste.criaDocumento("Redação", 5);
            this.controllerTeste.criaTexto("Redação", "Exemplo de texto", 1);
            this.controllerTeste.criaTexto("Redação", "Outro exemplo de texto", 3);
            this.controllerTeste.moveParaCima("Redação", 10);
        } catch (IndexOutOfBoundsException e) {
        }
    }

    @Test
    void testCriaAtalho() {
        this.controllerTeste.criaDocumento("Redação", 5);
        assertEquals(this.controllerTeste.criaAtalho("Redação", "Redação"), 0);
    }

    @Test
    void testCriaAtalhoInvalido() {
        try {
            this.controllerTeste.criaDocumento("Redação", 5);
            this.controllerTeste.criaAtalho("Redação", "Redação");
            this.controllerTeste.criaAtalho("Redação", "Redação");
        } catch (IllegalStateException e) {
        }
    }

    @Test
    void testCriaVisaoCompleta() {
        this.controllerTeste.criaDocumento("Redação", 5);
        this.controllerTeste.criaTexto("Redação", "Exemplo de texto", 1);
        assertEquals(this.controllerTeste.criaVisaoCompleta("Redação"), 0);
    }

    @Test
    void testCriaVisaoCompletaInvalido() {
        try {
            this.controllerTeste.criaDocumento("Redação", 5);
            this.controllerTeste.criaTexto("Redação", "Exemplo de texto", 1);
            this.controllerTeste.criaVisaoCompleta("Resumo");
        } catch (NoSuchElementException e) {
        }
    }

    @Test
    void testCriaVisaoResumida() {
        this.controllerTeste.criaDocumento("Redação", 5);
        this.controllerTeste.criaTexto("Redação", "Exemplo de texto", 1);
        assertEquals(this.controllerTeste.criaVisaoResumida("Redação"), 0);
    }

    @Test
    void testCriaVisaoResumidaInvalido() {
        try {
            this.controllerTeste.criaDocumento("Redação", 5);
            this.controllerTeste.criaTexto("Redação", "Exemplo de texto", 1);
            this.controllerTeste.criaVisaoResumida("Resumo");
        } catch (NoSuchElementException e) {
        }
    }

    @Test
    void testCriaVisaoPrioritaria() {
        this.controllerTeste.criaDocumento("Redação", 5);
        this.controllerTeste.criaTexto("Redação", "Exemplo de texto", 1);
        assertEquals(this.controllerTeste.criaVisaoPrioritaria("Redação", 1), 0);
    }

    @Test
    void testCriaVisaoPrioritariaTiuloInvalido() {
        try {
            this.controllerTeste.criaDocumento("Redação", 5);
            this.controllerTeste.criaTexto("Redação", "Exemplo de texto", 1);
            this.controllerTeste.criaVisaoPrioritaria("Resumo", 1);
        } catch (NoSuchElementException e) {
        }
    }

    @Test
    void testCriaVisaoPrioritariaPrioridadeInvalida() {
        try {
            this.controllerTeste.criaDocumento("Redação", 5);
            this.controllerTeste.criaTexto("Redação", "Exemplo de texto", 1);
            this.controllerTeste.criaVisaoPrioritaria("Redação", 2);
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    void testCriaVisaoTitulo() {
        this.controllerTeste.criaDocumento("Redação", 5);
        this.controllerTeste.criaTitulo("Redação", "Exemplo de titulo", 1, 
                                1, true);
        assertEquals(this.controllerTeste.criaVisaoTitulo("Redação"), 0);
    }

    @Test
    void testCriaVisaoTituloInvalido() {
        try {
            this.controllerTeste.criaDocumento("Redação", 5);
            this.controllerTeste.criaTitulo("Redação", "Exemplo de titulo", 1, 
                                1, true);
            this.controllerTeste.criaVisaoTitulo("Resumo");
        } catch (NoSuchElementException e) {
        }
    }

    @Test
    void testExibeVisaoCompleta() {
        this.controllerTeste.criaDocumento("Redação", 5);
        this.controllerTeste.criaTexto("Redação", "Exemplo de texto", 1);
        this.controllerTeste.criaVisaoCompleta("Redação");
        assertEquals(Arrays.toString(this.controllerTeste.exibeVisao(0)), 
                        "[Exemplo de texto]");
    }

    @Test
    void testExibeVisaoResumida() {
        this.controllerTeste.criaDocumento("Redação", 5);
        this.controllerTeste.criaTexto("Redação", "Exemplo de texto", 1);
        this.controllerTeste.criaVisaoResumida("Redação");
        assertEquals(Arrays.toString(this.controllerTeste.exibeVisao(0)), 
                        "[Exemplo de texto]");
    }

    @Test
    void testExibeVisaoPrioritaria() {
        this.controllerTeste.criaDocumento("Redação", 5);
        this.controllerTeste.criaTexto("Redação", "Exemplo de texto", 1);
        this.controllerTeste.criaVisaoCompleta("Redação");
        assertEquals(Arrays.toString(this.controllerTeste.exibeVisao(0)), 
                        "[Exemplo de texto]");
    }

    @Test
    void testExibeVisaoTitulo() {
        this.controllerTeste.criaDocumento("Redação", 5);
        this.controllerTeste.criaTitulo("Redação", "Exemplo de titulo", 1, 
                                1, true);
        this.controllerTeste.criaVisaoTitulo("Redação");
        assertEquals(Arrays.toString(this.controllerTeste.exibeVisao(0)), 
                        "[1. Exemplo]");
    }
    
}
