package Model;

import java.util.Scanner;

public class Jogador {

    Scanner sc = new Scanner(System.in);

    private int numjogador;
    private String nome;
    protected int[] tentativa = new int[2];

    public Jogador(int jogador, String nome) {
        this.numjogador = jogador;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void jogar(Tabuleiro tabuleiro, int jogador) {
        tabuleiro.setPosicao(tentativa, numjogador);
    }

    public void Tentativa(Tabuleiro tabuleiro) {
        do {
            do {
                System.out.print("Linha: ");
                tentativa[0] = sc.nextInt();

                if (tentativa[0] > 3 || tentativa[0] < 1) {
                    System.out.println("Linha inválida. É 1, 2 ou 3");
                }

            } while (tentativa[0] > 3 || tentativa[0] < 1);

            do {
                System.out.print("Coluna: ");
                tentativa[1] = sc.nextInt();

                if (tentativa[1] > 3 || tentativa[1] < 1) {
                    System.out.println("Coluna inválida. É 1, 2 ou 3");
                }

            } while (tentativa[1] > 3 || tentativa[1] < 1);

            tentativa[0]--;
            tentativa[1]--;

            if (!checaTentativa(tentativa, tabuleiro)) {
                System.out.println("Esse local já foi marcado. Tente outro.");
            }
        } while (!checaTentativa(tentativa, tabuleiro));
    }

    public boolean checaTentativa(int[] tentativa, Tabuleiro tabuleiro) {
        if (tabuleiro.getPosicao(tentativa) == 0) {
            return true;
        } else {
            return false;
        }
    }
}
