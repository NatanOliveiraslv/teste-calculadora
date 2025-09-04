package org.example.calculadora;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculadoraTest {

    private Calculadora calculadora;

    @Before
    public void setUp() {
        // Arrange - preparação
        calculadora = new Calculadora();
    }

    @Test
    public void deveSomar() {
        // Action - ação
        int resultado = calculadora.somar(15, 3);

        // Assert - verficação
        assertEquals(18, resultado);

    }

    @Test
    public void deveSubtrair() {
        // Action - ação
        int resultado = calculadora.subtrair(15, 3);

        // Assert - verficação
        assertEquals(12, resultado);

    }

    @Test
    public void deveMultiplicar() {
        // Action - ação
        int resultado = calculadora.multiplicar(15, 3);

        // Assert - verficação
        assertEquals(45, resultado);

    }

    @Test
    public void deveDividir() {
        // Action - ação
        int resultado = calculadora.dividir(15, 3);

        // Assert - verficação
        assertEquals(5, resultado);

    }

    @Test
    public void deveFatorar() {
        // Action - ação
        int resultado = calculadora.fatorial(5);

        // Assert - verficação
        assertEquals(120, resultado);

    }

}
