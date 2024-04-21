package Secao10.ComportamentoDeMemoria.Aula.Listas.ListaEncadeada;

import java.util.Scanner;

public class LerPrograma {
    public static void programa(Scanner sc, ListaEncadeada<Integer> lista){
        int opcao;
        int ler;
        do{
            System.out.println("TAMANHO DA LISTA: " + lista.getTamanho());
            System.out.println("\n1 - Adicionar em qualquer lugar\n2 - Remover elemento\n3 - Imprimir lista\n4 - Imprimir lista ao contrario\n0 - Sair\n");
            opcao = sc.nextInt();
            switch(opcao){
                case 0:
                    System.out.println("Saindo do programa");
                    break;

                case 1:
                    System.out.println("Digite o numero a ser inserido: ");
                    ler = sc.nextInt();

                    System.out.println("Digite em qual posicao sera inserido");
                    int posicao;
                    do {
                        posicao = sc.nextInt();
                        if(posicao < 0 || posicao > lista.getTamanho()){
                            System.out.println("Digite uma posicao valida!");
                        }
                    }while(posicao < 0 || posicao > lista.getTamanho());

                    lista.insereEmQualquerLugar(ler, posicao);
                    break;

                case 2:
                    System.out.println("Digite o numero a ser removido: ");
                    ler = sc.nextInt();
                    lista.removerElemento(ler);
                    break;

                case 3:
                    lista.imprimeLista();
                    break;

                case 4:
                    lista.imprimeAoContrario();
                    break;

                default:
                    System.out.println("Valor invalido!");
                    break;
            }
        }while(opcao != 0);
    }
}
