package com.lucas.lancamento.credito.iteration;

import com.lucas.lancamento.credito.modelos.Compra;
import com.lucas.lancamento.credito.modelos.Conta;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Iteration {

    public void finalPrint(List<Compra> compras, double saldo){
        Collections.sort(compras);
        StringBuilder sb = new StringBuilder();
        sb.append("*************************\n");
        sb.append("\nCOMPRAS REALIZADAS: \n");

        for (Compra c : compras){
                sb.append(c.getNome())
                    .append(" - R$ ")
                    .append(c.getValor())
                    .append("\n");
        }
        sb.append("\n*************************\n");
        System.out.println(sb.toString());
        System.out.println("Saldo do cartão: " + saldo);
    }

    public void iterationScanner (Scanner scanner, Conta minhaConta){

        System.out.println("Seja bem-vindo ao sistema de lançamento de crédito do seu banco!");
        System.out.println("Primeiro, digite o limite da sua conta: ");
        double valorLimite = scanner.nextDouble();
        scanner.nextLine();
        minhaConta.setLimite(valorLimite);
        int opcao = 1;
        while (opcao == 1){
            System.out.println("Digite o nome da compra");
            String nome = scanner.nextLine();
            System.out.println("Digite o valor da compra");
            double valor = scanner.nextDouble();
            scanner.nextLine();
            var compra = new Compra(nome, valor);

            var adicionou = minhaConta.adicionarCompra(compra);
            var saldo = minhaConta.getSaldolista(minhaConta.getCompras());
            if (!adicionou){
                var minhasCompras = minhaConta.getCompras();
                finalPrint(minhasCompras, saldo);
                break;
            }
            System.out.println("Digite 1 para adicionar uma compra ou 0 para sair");
            opcao = scanner.nextInt();
            scanner.nextLine();
            if (opcao == 0){
                var minhasCompras = minhaConta.getCompras();
                finalPrint(minhasCompras, saldo);
                break;
            }
        }
        System.out.println("programa finalizado!");
    }
}
