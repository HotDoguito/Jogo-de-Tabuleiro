public class CasaSorte extends Casa {

    public void mensagemCasa(Jogador player){
        System.out.println("Jogador " + player.nome + ", você entrou em uma casa da Sorte!\nAnde 3 casas de não for um Azarado.");
    }
    public void houseEffect(Jogador player){
        if (player instanceof JogadorAzarado){
            System.out.println("Como você é um jogador azarado, não andará as 3 casas.");
            return; 
        }
        else {
            player.posicao += 3;
            return;
        }


    }
    
}
