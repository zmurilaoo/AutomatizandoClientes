package application;

import model.entities.Cliente;
import model.entities.GerenciamentoCliente;

import javax.swing.*;
import java.util.PriorityQueue;

public class ChamadaCliente {
    public static void main(String[] args) {
        PriorityQueue<Cliente> clientes = new PriorityQueue<>();
        GerenciamentoCliente gerenciamentoCliente = new GerenciamentoCliente();

        while (true) {
            try {
                int opcao = Integer.parseInt(JOptionPane.showInputDialog(
                        """
                        ===== DC CREAD =====
                        1 - Adicionar Cliente
                        2 - Buscar Cliente
                        3 - Exibir Fila
                        4 - Sair
                        Escolha uma opção:
                        """));

                switch (opcao) {
                    case 1 -> adicionarCliente(clientes);
                    case 2 -> gerenciamentoCliente.buscarCliente(clientes);
                    case 3 -> JOptionPane.showMessageDialog(null, clientes.toString());
                    case 4 -> {
                        JOptionPane.showMessageDialog(null, "Encerrando o sistema...");
                        return;
                    }
                    default -> JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida! Digite um número.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }
    }

    public static void adicionarCliente(PriorityQueue<Cliente> clientes) {
        try {
            String nome = JOptionPane.showInputDialog("Informe seu nome:");
            if (nome == null || nome.matches(".*\\d.*") || nome.trim().isEmpty()) {
                throw new IllegalArgumentException("Nome inválido! Não pode conter números ou estar vazio.");
            }

            String cpf = JOptionPane.showInputDialog("Informe seu CPF (apenas números):");
            if (!cpf.matches("\\d{11}")) {
                throw new IllegalArgumentException("CPF inválido! Deve conter 11 dígitos numéricos.");
            }

            String prioridade = JOptionPane.showInputDialog("Digite seu nível de prioridade (Aposentado, INSS, Funcionário Público):");

            if (!clientes.isEmpty() && clientes.peek().getPrioridade().equalsIgnoreCase("Aposentado")) {
                clientes.poll();
            }

            clientes.add(new Cliente(nome, cpf, prioridade));
            JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso!");

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }
}
