package org.example.processador_pedidos;

import java.math.BigDecimal;

public interface CalculadoraFrete {

    BigDecimal calcularFrete(String destino, double volume);

}
