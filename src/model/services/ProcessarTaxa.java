package model.services;

public class ProcessarTaxa implements  PagamentoJuros{


    @Override
    public double taxaPagamento(Double valor) {
        double resultado = valor * 0.2;
        return  resultado;
    }

    @Override
    public double juros(Double valor, Integer meses) {
        double resultado = valor * 0.1 * meses;
        return resultado;
    }
}
