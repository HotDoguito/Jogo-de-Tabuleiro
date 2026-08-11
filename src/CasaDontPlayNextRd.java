public class CasaDontPlayNextRd extends Casa {

    @Override
    public void mensagemCasa(Jogador player){
        System.out.println("Jogador " + player.getCor() + ", você entrou em uma casa Especial!\nVocê não jogará a próxiuma rodada.");
    }
    
    @Override
    public void houseEffect(Jogador player, Jogo jogo){
        player.setPularVez(true);
    }
    
}