package org.example.processador_pedidos;

import java.math.BigDecimal;

public class ProcessadorPedidos {

    private ValidadorPedido validadorPedido;
    private CalculadoraFrete calculadoraFrete;
    private ServicoEntrega servicoEntrega;

    public ProcessadorPedidos(
      ValidadorPedido validadorPedido,
      CalculadoraFrete calculadoraFrete,
      ServicoEntrega servicoEntrega
    ){
        this.validadorPedido = validadorPedido;
        this.calculadoraFrete = calculadoraFrete;
        this.servicoEntrega = servicoEntrega;
    }

    public ResultadoPedido processarPedido(Pedido pedido){

        if(!validadorPedido.validar(pedido)){
            return new ResultadoPedido(false, null, null);
        }

        BigDecimal valorFrete = calculadoraFrete.calcularFrete(pedido.getDestino(), pedido.getItens().size());
        BigDecimal valorTotal = pedido.getValor().add(valorFrete);

        String codigoRastreamento = servicoEntrega.agendarEntrega(pedido, valorTotal);

        return new ResultadoPedido(true, codigoRastreamento, valorTotal);
    }

}
