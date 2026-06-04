import java.util.Scanner;

public class JogadorHumano extends Jogador {
    private Scanner sc;

    public JogadorHumano(String nome, char simbolo, Scanner sc) {
        super(nome, simbolo);
        this.sc = sc;
    }

    @Override
    public void jogar(Tabuleiro tabuleiro) {
        boolean jogadaValida = false;
        while (!jogadaValida) {
            System.out.print("Digite a linha (0-2): ");
            int linha = sc.nextInt();
            System.out.print("Digite a coluna (0-2): ");
            int coluna = sc.nextInt();
            if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3) {
                if (tabuleiro.fazerJogada(linha, coluna, getSimbolo())) {
                    jogadaValida = true;
                } else {
                    System.out.println("Posição ocupada! Tente novamente.");
                }
            } else {
                System.out.println("Coordenadas fora do limite (0-2)! Tente novamente.");
            }
        }
    }
}