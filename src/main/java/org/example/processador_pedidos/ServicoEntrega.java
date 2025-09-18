package org.example.processador_pedidos;

import java.math.BigDecimal;

public interface ServicoEntrega {

    String agendarEntrega(Pedido pedido, BigDecimal valorTotal);

}
