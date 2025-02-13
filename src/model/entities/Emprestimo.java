package model.entities;



import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Emprestimo  {
    private Cliente cliente;
    List<Emprestimo> emprestimos = new ArrayList<>();
    private Double valor;
    private LocalDate dataInicio;
    private LocalDate dataFinal;

    public Emprestimo() {

    }

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

    public void adicionarEmprestimo(List<Emprestimo>emprestimo, List<Cliente> clientes) {
        String escolha = JOptionPane.showInputDialog("Você está cadastrado? (Sim/Não)");

        while (escolha.equalsIgnoreCase("Sim")) {
            String nome = JOptionPane.showInputDialog("Digite seu nome:");

            for (int i = 0; i < clientes.size(); i++) {
                if (nome.equalsIgnoreCase(clientes.get(i).getNome())) {
                    double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do empréstimo:"));
                    JOptionPane.showMessageDialog(null,"Empréstimo cadastrado com sucesso!!");
                    JOptionPane.showMessageDialog(null, "Foi feito um emprestimo para Sr(a) " + nome + " no valor de R$" + String.format("%.3f", valor));
                    return;
                }
            }

            JOptionPane.showMessageDialog(null, "Infelizmente, Sr(a) " + nome + " não está cadastrado.");
            return;
        }

        JOptionPane.showMessageDialog(null, "Você precisa se cadastrar antes de solicitar um empréstimo.");
    }

}
