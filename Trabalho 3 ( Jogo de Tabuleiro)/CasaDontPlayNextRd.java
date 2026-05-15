public class CasaDontPlayNextRd extends Casa {

    public void mensagemCasa(Jogador player){
        System.out.println("Jogador " + player.nome + ", você entrou em uma casa Especial!\nVocê não jogará a próxiuma rodada.");
    }
    public void houseEffect(Jogador player){
        player.pularVez = true;
    }
    
}
