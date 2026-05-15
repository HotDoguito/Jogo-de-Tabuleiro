import java.util.ArrayList;

public class CasaMagica extends Casa {
    public void mensagemCasa(Jogador player){
        System.out.println("Jogador " + player.nome + ", você entrou em uma casa Mágica!\nVocê trocará de lugar com o jogador que está na última posição.");
    }
    public void houseEffect(Jogador player,ArrayList<Jogador> jogadores){
        int menorPos = 0;
        int SavePosJog = 0;
        for(int i = 0; i < jogadores.size(); i++){
            for(int j = 0; j < (jogadores.size() - 1); j++){
                if(jogadores.get(i).posicao < jogadores.get(j).posicao){
                    menorPos = jogadores.get(i).posicao;
                    SavePosJog = i;
                }  
            }
        }

                if(player.nome.equals(jogadores.get(SavePosJog).nome)){
                    System.out.println("Você já é o último jogador!");
                    return;
                }
                else{player.posicao = menorPos; System.out.println("Tu trocastes de lugar com o jogador " + jogadores.get(SavePosJog).nome);}
    }
}




    

