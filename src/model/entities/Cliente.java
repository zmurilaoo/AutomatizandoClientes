package model.entities;

public class Cliente {
    private String nome;
    protected   String cpf;
    private String prioridade;

    public Cliente() {

    }
    public  Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Cliente(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", CPF: "+ cpf + ", PRIORIDADE: " + prioridade;
    }
}
