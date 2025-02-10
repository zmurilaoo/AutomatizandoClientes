package model.entities;

import javax.swing.*;
import java.util.PriorityQueue;

public class GerenciamentoCliente {
    private PriorityQueue<Cliente> adicionarClientes=  new PriorityQueue<>();

    public GerenciamentoCliente() {

    }

    public PriorityQueue<Cliente> getAdicionarClientes() {
        return adicionarClientes;
    }

    public void setAdicionarClientes(PriorityQueue<Cliente> adicionarClientes) {
        this.adicionarClientes = adicionarClientes;
    }

    public void chamarFila(PriorityQueue<Cliente> clientes){
        System.out.println("Voce é o primeiro da fila Sr(a)" + clientes.peek());

        if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Opps, parece que não temos usários cadastrado.");
        }else {
            clientes.poll();
            JOptionPane.showMessageDialog(null, "Cliente foi chamado...");
        }

    }

    public void listarFila(PriorityQueue<Cliente> clientes) {
        for (Cliente cliente : adicionarClientes) {
            System.out.println(cliente);
        }
    }


    public void buscarCliente( PriorityQueue<Cliente> clientes )  {
        String nome = JOptionPane.showInputDialog("Digite O CPF do Usário:");





    }

}
