

import java.util.Random;

public class CasaSurpresa extends Casa {
    private Random rand = new Random();


    @Override
    public void mensagemCasa(Jogador player){
        System.out.println("Jogador " + player.getCor() + ", você entrou em uma casa Surpresa!\nAgora você vai trocar o seu tipo aleatoriamente.");
    }
    @Override
    public void houseEffect(Jogador player, Jogo jogo){

        int carta = rand.nextInt(3);
        
        switch (carta) {
            case 0 -> player.setTipo(new JogadorSortudo());
            case 1 -> player.setTipo(new JogadorAzarado());
            default -> player.setTipo(new JogadorNormal());
        }

        System.out.println("Jogador " +player.getCor() + " agora é um jogador " + player.getTipo().getNome());
        return;

    }
    
}