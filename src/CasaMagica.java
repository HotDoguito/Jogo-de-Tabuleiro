import java.util.ArrayList;

public class CasaMagica extends Casa {

    @Override
    public void mensagemCasa(Jogador player){
        System.out.println("Jogador " + player.getCor() + ", você entrou em uma casa Mágica!\nVocê trocará de lugar com o jogador que está na última posição.");
    }

    @Override
    public void houseEffect(Jogador player,Jogo jogo){
        ArrayList<Jogador> jogadores = jogo.getJogadores();
        int menorPos = 40;
        int SavePosJog = player.getPosicao();
        Jogador ultimo = player;
        for (Jogador j : jogadores){
            if (j.getPosicao() < menorPos){
                menorPos = j.getPosicao();
                ultimo = j;
            }
        }
        if (player.equals(ultimo)){
            System.out.println("Você já é o último jogador!");
        } else {
            player.setPosicao(menorPos);
            ultimo.setPosicao(SavePosJog);
            System.out.println("Trocou de lugar com o jogador " + ultimo.getCor());
        }
    }
}




    
