package model;

public class Conta {

    private int agencia;
    private int numero;
    private double saldo;
    private String nome;

    public Conta(int agencia, int numero, String nome) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = 0.0;
        this.nome = nome;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
