package com.lucas.lancamento.credito.modelos;

public class Compra implements Comparable<Compra>{
    private String nome;
    private double valor;

    public Compra(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public int compareTo(Compra novaCompra) {
        return this.getNome().compareTo(novaCompra.getNome());
    }

    @Override
    public String toString() {
        return this.getNome() + " - " + this.getValor();
    }
}
