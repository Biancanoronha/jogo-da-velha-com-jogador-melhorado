import java.util.Scanner;

public class JogoDaVelha {
    private Jogador jogador1;
    private Jogador jogador2;
    private Tabuleiro tabuleiro;

    public JogoDaVelha(Jogador jogador1, Jogador jogador2, Tabuleiro tabuleiro) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.tabuleiro = tabuleiro;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char simboloHumano;
        char simboloMaquina;

        while (true) {
            System.out.print("Escolha seu símbolo (X ou O): ");
            String input = sc.next().toUpperCase();
            if (input.length() == 1 && (input.charAt(0) == 'X' || input.charAt(0) == 'O')) {
                simboloHumano = input.charAt(0);
                simboloMaquina = (simboloHumano == 'X') ? 'O' : 'X';
                break;
            } else {
                System.out.println("Símbolo inválido. Por favor, escolha 'X' ou 'O'.");
            }
        }

        Jogador jogador1 = new JogadorHumano("Jogador 1", simboloHumano, sc);
        Jogador jogador2 = new JogadorMaquina("Jogador 2", simboloMaquina);
        Tabuleiro tabuleiro = new Tabuleiro();

        JogoDaVelha jogo = new JogoDaVelha(jogador1, jogador2, tabuleiro);
        jogo.iniciar();
        sc.close();
    }

    public void iniciar() {
        Jogador atual = jogador1;
        boolean jogoAcabou = false;

        while (!jogoAcabou) {
            System.out.println("\nTurno de " + atual.getNome() + " (" + atual.getSimbolo() + ")");
            tabuleiro.exibir();
            atual.jogar(tabuleiro);

            if (tabuleiro.verificarVitoria(atual.getSimbolo())) {
                tabuleiro.exibir();
                System.out.println(atual.getNome() + " ganhou!");
                jogoAcabou = true;
            } else if (tabuleiro.cheio()) {
                tabuleiro.exibir();
                System.out.println("O jogo terminou empatado.");
                jogoAcabou = true;
            } else {
                atual = (atual == jogador1) ? jogador2 : jogador1;
            }
        }

        System.out.println("Criado por Bianca Teixeira");
    }
}