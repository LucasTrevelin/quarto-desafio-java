package com.lucas.lancamento.credito.principal;

import com.lucas.lancamento.credito.iteration.Iteration;
import com.lucas.lancamento.credito.modelos.Conta;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        var minhaConta = new Conta();
        var scanner = new Scanner(System.in);

        Iteration iteration = new Iteration();
        iteration.iterationScanner(scanner, minhaConta);
        scanner.close();
    }
}
