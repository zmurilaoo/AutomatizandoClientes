package model.entities;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class GerenciamentoCliente {
    List<Cliente> clientes = new ArrayList<>();
    public GerenciamentoCliente() {

    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void  adicionarCliente(List<Cliente> clientes){
        try {
            String nome = JOptionPane.showInputDialog("Informe seu nome:");
            if (nome == null || nome.matches(".*\\d.*") || nome.trim().isEmpty()) {
                throw new IllegalArgumentException("Nome inválido! Não pode conter números ou estar vazio.");
            }

            String cpf = JOptionPane.showInputDialog("Informe seu CPF (apenas números):");
            if (!cpf.matches("\\d{11}")) {
                throw new IllegalArgumentException("CPF inválido! Deve conter 11 dígitos numéricos.");
            }

            clientes.add(new Cliente(nome, cpf));
            JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso!");

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null,   e.getMessage());
        }
    }


    public void buscarCliente( List<Cliente>clientes )  {
        try {
            Cliente cliente = new Cliente();

            cliente.cpf = JOptionPane.showInputDialog("Informe seu CPF (apenas números):");
            if (!cliente.cpf.matches("\\d{11}")) {
                throw new IllegalArgumentException("CPF inválido! Deve conter 11 dígitos numéricos.");
            }

            for (int i = 0; i < clientes.size(); i++) {
                if (clientes.get(i).getCpf().equals(cliente.cpf)){
                    JOptionPane.showMessageDialog(null,"Usuário encontrado.");
                    JOptionPane.showMessageDialog(null, "Nome:  "+  clientes.get(i).getNome() + "/ CPF:" + clientes.get(i).getCpf());
                    return;
                }else {
                    JOptionPane.showMessageDialog(null, "Usuário não encontrado...");
                }

            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro" + e.getMessage());
        }
    }
}
