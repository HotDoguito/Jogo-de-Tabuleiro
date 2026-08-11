import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {
    private ArrayList<Jogador> jogadores;
    private Tabuleiro tabuleiro;
    private boolean modoDebug;
    private Scanner teclado;

    
    public Jogo(ArrayList<Jogador> jogadores, Tabuleiro tabuleiro, boolean modoDebug) {
        this.jogadores = jogadores;
        this.tabuleiro = tabuleiro;
        this.modoDebug = modoDebug;
        this.teclado = new Scanner(System.in);
    }


    void jogar(){
        Jogador vencedor = null;

            do {
                for (Jogador player : jogadores){

                    exibirPosicoes();
                    System.err.println("Turno do jogador " + player);
                    teclado.nextLine();
                    vencedor = this.turno(player);
                    if (vencedor != null) break;
                }
            } while (vencedor == null) ;

            exibirPosicoes();
            System.out.println("    *: VENCEDOR: JOGADOR " + vencedor.getCor());
    }

    private Jogador turno(Jogador player){
        if (player.isPularVez()){
            player.setPularVez(false);
            System.out.println("Pulando turno do jogador " + player.getCor());
            return null;
        }

        boolean jogada = true;
        while (jogada) {
            jogada = false;
            int novaPos;
            boolean dupla = false;
            if (modoDebug){
                System.out.println("    Selecione a casa que o jogador deve ir");
                int casa = -1;
                while (casa < 0 || casa > 40) {
                    try{
                        casa = teclado.nextInt();
                        if (casa < 0 || casa > 40) System.out.println(" x: Casa deve estar dentro do tabuleiro");
                    } catch (Exception e){
                        System.out.println("    x Escolha inválida!");
                        teclado.nextLine();
                    }
                }
                novaPos = Math.min(casa, this.tabuleiro.getTamanho());
                player.incrementarJogada();
            } else {
                int dados[] = player.jogarDados();
                int soma = dados[0] + dados[1];
                System.out.println("    Casas a serem andadas: " + soma + " (" + dados[0] + ", " + dados[1] + ")");

                dupla = (dados[0] == dados[1]);

                novaPos = Math.min(soma + player.getPosicao(), this.tabuleiro.getTamanho());
               

            }
            player.setPosicao(novaPos);
            if (novaPos == this.tabuleiro.getTamanho()) return player;

            
            tabuleiro.casas.get(player.getPosicao()).mensagemCasa(player);
            tabuleiro.casas.get(player.getPosicao()).houseEffect(player, this);

            if (player.getPosicao() >= this.tabuleiro.getTamanho()) return player;

            if (dupla && !player.isPularVez()){
                System.out.println("Jogador " + player.getCor() + " tirou dupla nos dados e pode jogar novamente");
                jogada = true;
            }

        }

        return null;
    }


     private void exibirPosicoes() {
        System.out.println();
        System.out.println("  ┌──────────────────────────────────────────────────┐");
        System.out.println("  │               🎲  POSIÇÕES ATUAIS                │");
        System.out.println("  ├──────────────────────────────────────────────────┤");
        for (Jogador j : jogadores) {
            System.out.printf("  │  %-10s [%-8s] ► Casa %-3d ► Jogadas %d %s │%n",
                    j.getCor(), j.getTipo().getNome(), j.getPosicao(), j.getJogadas(),
                    j.isPularVez() ? "⏸" : "  ");
        }
        System.out.println("  └──────────────────────────────────────────────────┘");
    }
    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }


    

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    
}