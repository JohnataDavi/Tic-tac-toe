package Model;

public class Tabuleiro {

    private int[][] tabuleiro = new int[3][3];

    public Tabuleiro() {
        zerarTabuleiro();
    }

    public void zerarTabuleiro() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                tabuleiro[x][y] = 0;
            }
        }
    }

    public void exibeTabuleiro() {
        System.out.println();
        for (int x = 0; x < 3; x++) {

            for (int y = 0; y < 3; y++) {

                if (tabuleiro[x][y] == 1) {
                    System.out.print(" X ");
                }
                if (tabuleiro[x][y] == -1) {
                    System.out.print(" O ");
                }
                if (tabuleiro[x][y] == 0) {
                    System.out.print("   ");
                }

                if (y == 0 || y == 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }

    public int getPosicao(int[] tentativa) {
        return tabuleiro[tentativa[0]][tentativa[1]];
    }

    public void setPosicao(int[] tentativa, int jogador) {
        if (jogador == 1) {
            tabuleiro[tentativa[0]][tentativa[1]] = 1;
        } else {
            tabuleiro[tentativa[0]][tentativa[1]] = -1;
        }
    }

    public boolean checaLinhas() {
        for (int x = 0; x < 3; x++) {

            if ((tabuleiro[x][0] + tabuleiro[x][1] + tabuleiro[x][2]) == 3) {
                return true;
            }
            if ((tabuleiro[x][0] + tabuleiro[x][1] + tabuleiro[x][2]) == -3) {
                return true;
            }
        }
        return false;
    }

    public boolean checaColunas() {
        for (int y = 0; y < 3; y++) {

            if ((tabuleiro[0][y] + tabuleiro[1][y] + tabuleiro[2][y]) == 3) {
                return true;
            }
            if ((tabuleiro[0][y] + tabuleiro[1][y] + tabuleiro[2][y]) == -3) {
                return true;
            }
        }

        return false;

    }

    public boolean checaDiagonais() {
        if ((tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2]) == 3) {
            return true;
        }
        if ((tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2]) == -3) {
            return true;
        }
        if ((tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0]) == 3) {
            return true;
        }
        if ((tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0]) == -3) {
            return true;
        }

        return false;
    }

    public boolean tabuleiroCompleto() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (tabuleiro[x][y] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
