package model.entities;

import model.services.ProcessarTaxa;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Emprestimo extends ProcessarTaxa {
    private Cliente cliente;
    List<Emprestimo> emprestimos = new ArrayList<>();
    private Double valor;
    private LocalDate dataInicio;
    private LocalDate dataFinal;

    public Emprestimo(Cliente cliente, Double valor, LocalDate dataInicio, LocalDate dataFinal) {
        this.cliente = cliente;
        this.valor = valor;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
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

    public void adicionarEmprestimo(Emprestimo emprestimo, Cliente cliente, List<Cliente> clientes) {
        String escolha = JOptionPane.showInputDialog("Você está cadastrado? (Sim/Não)");

        while (escolha.equalsIgnoreCase("Sim")) {
            String nome = JOptionPane.showInputDialog("Digite seu nome:");

            for (int i = 0; i < clientes.size(); i++) {
                if (nome.equalsIgnoreCase(clientes.get(i).getNome())) {
                    double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do empréstimo:"));
                    emprestimo.setValor(valor);
                    JOptionPane.showMessageDialog(null, "Empréstimo cadastrado com sucesso para " + nome + " no valor de R$ " + valor);
                    return;
                }
            }

            JOptionPane.showMessageDialog(null, "Infelizmente, Sr(a) " + nome + " não está cadastrado.");
            return;
        }

        JOptionPane.showMessageDialog(null, "Você precisa se cadastrar antes de solicitar um empréstimo.");
    }
    

    public void buscarEmprestimo(Cliente cliente) {



    }

    public double calcularEmprestimo(Emprestimo emprestimo, int meses) {
        if (meses <= 0) {
            throw new IllegalArgumentException("O número de meses deve ser maior que zero.");
        }

        ProcessarTaxa py = new ProcessarTaxa();
        double contaBasica = emprestimo.getValor() / meses;
        double total = 0.0;

        for (int i = 0; i < meses; i++) {
            double juros = py.juros(contaBasica, i);
            double taxa = py.taxaPagamento(contaBasica);
            total += contaBasica + juros + taxa;
        }

        return total;
    }


}
