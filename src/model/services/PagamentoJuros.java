package model.services;

public interface PagamentoJuros {
    double taxaPagamento(Double valor);

    double juros(Double valor, Integer meses);

}
