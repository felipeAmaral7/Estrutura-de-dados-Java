package Secao10.ComportamentoDeMemoria.Aula.Listas.ListaEncadeada;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        LerPrograma.programa(sc, lista);

    }
}
