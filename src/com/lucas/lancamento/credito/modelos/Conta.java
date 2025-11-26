package com.lucas.lancamento.credito.modelos;

import java.util.ArrayList;
import java.util.List;

public class Conta {

    private List<Compra> compras = new ArrayList<Compra>();
    private double limite;

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public double getSaldolista (List<Compra> listaCompra){
        double somaValores = 0;
        for (Compra compra: listaCompra){
            somaValores += compra.getValor();
        }
        return somaValores;
    }

    public boolean adicionarCompra(Compra novaCompra){
        List<Compra> listaComparacao = new ArrayList<>(compras);
        listaComparacao.add(novaCompra);
        if (estourouLimite(listaComparacao)){
            System.out.println("\nSaldo insuficiente!");
            return false;
        }
        compras.add(novaCompra);
        return true;
    }

    public boolean estourouLimite(List<Compra> novaListaDeCompras){
       var saldo = getSaldolista(novaListaDeCompras);
        return saldo > this.getLimite();
    }


}
