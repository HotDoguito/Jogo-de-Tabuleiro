import java.util.ArrayList;
import java.util.Random;

public class CasaSurpresa extends Casa {
    private Random rand = new Random();

    public void mensagemCasa(Jogador player){
        System.out.println("Jogador " + player.nome + ", você entrou em uma casa Surpresa!\nAgora você vai trocar o seu tipo para outro de acordo com sua escolha.");
    }
    public void houseEffect(Jogador player, ArrayList<Jogador> jogadores){
        int SavePosJog = 0;
        for(int i = 0; i < jogadores.size(); i++){
            if(player == jogadores.get(i)){
                SavePosJog = i;
                break;
            }
        }
        int aleatorio = rand.nextInt(2);
        if(aleatorio == 1){
            if(player instanceof JogadorNormal){
                Jogador antigo = jogadores.get(SavePosJog);
                Jogador novo = new JogadorAzarado(antigo.nome, antigo.cor);
                novo.posicao = antigo.posicao;
                novo.jogadas = antigo.jogadas;
                novo.pularVez = antigo.pularVez;
                jogadores.set(SavePosJog,novo);
            }
            else if(player instanceof JogadorAzarado){
                Jogador antigo = jogadores.get(SavePosJog);
                Jogador novo = new JogadorSortudo(antigo.nome, antigo.cor);
                novo.posicao = antigo.posicao;
                novo.jogadas = antigo.jogadas;
                novo.pularVez = antigo.pularVez;
                jogadores.set(SavePosJog,novo);
            }
            else if(player instanceof JogadorSortudo){
                Jogador antigo = jogadores.get(SavePosJog);
                Jogador novo = new JogadorNormal(antigo.nome, antigo.cor);
                novo.posicao = antigo.posicao;
                novo.jogadas = antigo.jogadas;
                novo.pularVez = antigo.pularVez;
                jogadores.set(SavePosJog,novo);
            }

        }
        else{
             if(player instanceof JogadorNormal){
                Jogador antigo = jogadores.get(SavePosJog);
                Jogador novo = new JogadorSortudo(antigo.nome, antigo.cor);
                novo.posicao = antigo.posicao;
                novo.jogadas = antigo.jogadas;
                novo.pularVez = antigo.pularVez;
                jogadores.set(SavePosJog,novo);
            }
            else if(player instanceof JogadorAzarado){
                Jogador antigo = jogadores.get(SavePosJog);
                Jogador novo = new JogadorNormal(antigo.nome, antigo.cor);
                novo.posicao = antigo.posicao;
                novo.jogadas = antigo.jogadas;
                novo.pularVez = antigo.pularVez;
                jogadores.set(SavePosJog,novo);
            }
            else if(player instanceof JogadorSortudo){
                Jogador antigo = jogadores.get(SavePosJog);
                Jogador novo = new JogadorAzarado(antigo.nome, antigo.cor);
                novo.posicao = antigo.posicao;
                novo.jogadas = antigo.jogadas;
                novo.pularVez = antigo.pularVez;
                jogadores.set(SavePosJog,novo);
            }

        }
        System.out.println("Você trocou de tipo para " + jogadores.get(SavePosJog).getClass());
        return;

    }
    
}
