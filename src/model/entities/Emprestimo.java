package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Emprestimo extends Cliente{
    List<Emprestimo> emprestimos = new ArrayList<>();
    private Double valor;
    private LocalDate dataInicio;
    private LocalDate dataFinal;

    public Emprestimo(String nome, String cpf, Double valor, LocalDate dataInicio , LocalDate dataFinal) {
        super(nome, cpf);
        this.valor = valor;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public void adicionarEmprestimo(Cliente clientes){
        emprestimos.add(clientes);
    }
}
