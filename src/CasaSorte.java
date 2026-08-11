public class CasaSorte extends Casa {


    @Override
    public void mensagemCasa(Jogador player){
        System.out.println("Jogador " + player.getCor() + ", você entrou em uma casa da Sorte!\nAnde 3 casas de não for um Azarado.");
    }

    @Override
    public void houseEffect(Jogador player, Jogo jogo){
        if (player.getTipo().getNome().equals("Azarado")){
            System.out.println("Como você é um jogador azarado, não andará as 3 casas.");
            return; 
        }
        else {
            int novaPos = player.getPosicao() + 3;
            player.setPosicao(Math.min(novaPos, jogo.getTabuleiro().getTamanho()));
            return;
        }


    }
    
}