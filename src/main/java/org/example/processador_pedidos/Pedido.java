package org.example.processador_pedidos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private final int codigo;
    private final String destino;
    private final BigDecimal valor;
    private final List<String> itens;

    public Pedido(int codigo, String destino, BigDecimal valor, List<String> itens) {
        this.codigo = codigo;
        this.destino = destino;
        this.valor = valor;
        this.itens = itens;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDestino() {
        return destino;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public List<String> getItens() {
        return itens;
    }
}
