package application;

import model.entities.Cliente;
import model.entities.GerenciamentoCliente;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ChamadaCliente {
    public static void main(String[] args) {
        List<Cliente> clientes =  new ArrayList<>();
        GerenciamentoCliente gerenciamentoCliente = new GerenciamentoCliente();

        while (true) {
            try {
                int opcao = Integer.parseInt(JOptionPane.showInputDialog(
                        """
                        ===== DC CREAD =====
                        1 - Adicionar Cliente
                        2 - Buscar Cliente
                        3 - Exibir Clientes
                        4 - Sair
                        Escolha uma opção:
                        """));

                switch (opcao) {
                    case 1 -> gerenciamentoCliente.adicionarCliente(clientes);
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

}
