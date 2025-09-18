package org.example.processador_pedidos;

import java.math.BigDecimal;

public class ResultadoPedido {

    private final boolean sucesso;
    private final String codigRastreamento;
    private final BigDecimal valorTotal;

    public ResultadoPedido(boolean sucesso, String codigRastreamento, BigDecimal valorTotal) {
        this.sucesso = sucesso;
        this.codigRastreamento = codigRastreamento;
        this.valorTotal = valorTotal;
    }
    public boolean teveSucesso () {
        return this.sucesso;
    }

    public String getCodigRastreamento(){
        return  this.codigRastreamento;
    }

    public BigDecimal getValorTotal(){
        return this.valorTotal;
    }

}
