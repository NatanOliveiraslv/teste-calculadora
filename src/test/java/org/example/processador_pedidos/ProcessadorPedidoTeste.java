package org.example.processador_pedidos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProcessadorPedidoTeste {

    @Mock
    private ValidadorPedido validadorPedido;

    @Mock
    private CalculadoraFrete calculadoraFrete;

    @Mock
    private ServicoEntrega servicoEntrega;

    @InjectMocks
    private ProcessadorPedidos processadorPedidos;

    @Test
    public void deveProcessarPedidoComSucesso(){
        // Arrange

        Pedido pedido = new Pedido(1, "Porto Alegre", new BigDecimal(100), Arrays.asList("Item1", "Item2"));

        when(validadorPedido.validar(pedido)).thenReturn(true);
        when(calculadoraFrete.calcularFrete("Porto Alegre", 2)).thenReturn(new BigDecimal(15));
        when(servicoEntrega.agendarEntrega(pedido, new BigDecimal(115))).thenReturn("TRACK123");

        // Action

        ResultadoPedido resultadoPedido = processadorPedidos.processarPedido(pedido);

        // Assert

        assertTrue(resultadoPedido.teveSucesso());
        assertEquals("TRACK123", resultadoPedido.getCodigRastreamento());
        assertEquals(new BigDecimal(115), resultadoPedido.getValorTotal());

        InOrder inOrder = inOrder(validadorPedido, calculadoraFrete, servicoEntrega);

        inOrder.verify(validadorPedido).validar(pedido);
        inOrder.verify(calculadoraFrete).calcularFrete("Porto Alegre", 2);
        inOrder.verify(servicoEntrega).agendarEntrega(pedido, new BigDecimal(115));


    }

    @Test
    public void deveRejeitarPedidoInvalido(){

        // Arrange

        Pedido pedido = new Pedido(2, "", new BigDecimal(-10), Arrays.asList());

        when(validadorPedido.validar(pedido)).thenReturn(false);

        // Action

        ResultadoPedido resultadoPedido = processadorPedidos.processarPedido(pedido);

        // Assert

        assertFalse(resultadoPedido.teveSucesso());
        assertNull(resultadoPedido.getCodigRastreamento());
        assertNull(resultadoPedido.getValorTotal());

        verify(validadorPedido).validar(pedido);
        verify(calculadoraFrete, never()).calcularFrete(anyString(), anyDouble());
        verify(servicoEntrega, never()).agendarEntrega(any(Pedido.class), any(BigDecimal.class));

    }

}
