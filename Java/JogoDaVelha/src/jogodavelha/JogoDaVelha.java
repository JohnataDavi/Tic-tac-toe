package jogodavelha;

import Model.Tabuleiro;
import Model.Jogador;
import java.util.Scanner;

public class JogoDaVelha {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Tabuleiro tab;

        System.out.println("Quem vai ser o Jogador 1? ");
        System.out.print("Nome: ");
        String j1 = sc.next();
        System.out.println("Jogador 'Humano' " + j1);

        System.out.println("------------------------------");

        System.out.println("Quem vai ser o Jogador 2? ");
        System.out.print("Nome: ");
        String j2 = sc.next();
        System.out.println("Jogador 'Humano' " + j2);

        Jogador jogador1 = new Jogador(1, j1);
        Jogador jogador2 = new Jogador(2, j2);

        int cont = 1;

        tab = new Tabuleiro();

        while (!(tab.tabuleiroCompleto())) {
            if (cont % 2 != 0) {
                System.out.println("------------------------------");
                System.out.println("Rodada: " + cont);
                System.out.println("È a vez do Jogador " + jogador1.getNome());

                jogador1.Tentativa(tab);
                jogador1.jogar(tab, 1);

                tab.exibeTabuleiro();

                if (cont > 4) {
                    if (tab.checaColunas() == true || tab.checaLinhas() == true || tab.checaDiagonais() == true) {
                        System.out.println("------------------------------");
                        System.out.println("\nPARABÉNS, " + jogador1.getNome() + " você GANHOU!!!");
                        break;
                    }
                }

                cont++;
            } else {
                System.out.println("------------------------------");
                System.out.println("Rodada: " + cont);
                System.out.println("È a vez do Jogador " + jogador2.getNome());

                jogador2.Tentativa(tab);
                jogador2.jogar(tab, 2);

                tab.exibeTabuleiro();

                if (cont > 5) {
                    if (tab.checaColunas() == true || tab.checaLinhas() == true || tab.checaDiagonais() == true) {
                        System.out.println("------------------------------");
                        System.out.println("\nPARABÉNS, " + jogador2.getNome() + " você GANHOU!!!");
                        break;
                    }
                }

                cont++;
            }
        }
        if (tab.tabuleiroCompleto() == true) {
            System.out.println("------------------------------");
            System.out.println("EMPATE!");
        }
    }
}
