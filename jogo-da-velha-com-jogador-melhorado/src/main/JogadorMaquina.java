import java.util.Random;

public class JogadorMaquina extends Jogador {
    private Random random;

    public JogadorMaquina(String nome, char simbolo) {
        super(nome, simbolo);
        this.random = new Random();
    }

    @Override
    public void jogar(Tabuleiro tabuleiro) {
        boolean jogadaValida = false;
        while (!jogadaValida) {
            int linha = random.nextInt(3);
            int coluna = random.nextInt(3);
            if (tabuleiro.fazerJogada(linha, coluna, getSimbolo())) {
                jogadaValida = true;
            }
        }
    }
}