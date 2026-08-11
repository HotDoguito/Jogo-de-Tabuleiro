import java.util.ArrayList;
import java.util.Scanner;
public class CasaChoosePlayer extends Casa {
    Scanner input = new Scanner(System.in);

    @Override
    public void mensagemCasa(Jogador player){
        System.out.println("Jogador " + player.getCor() + ", você entrou em uma casa Especial!\nEscolha um jogador para voltar ao início do tabuleiro.");
    }

    @Override
    public void houseEffect(Jogador player,  Jogo jogo){
        ArrayList<Jogador> jogadores = jogo.getJogadores();
        

        
        boolean inválida = true;
       while(inválida){
        System.out.println("Digite o nome ou a cor do jogador que voltará para o início do tabuleiro: ");
        String resp = input.nextLine();
        for (Jogador j : jogadores){
            if (resp.toUpperCase().equals(j.getCor())){
                System.out.println("Mandando o jogador " + j.getCor() + " para o inicio do tabuleiro");
                j.setPosicao(0);
                inválida = false;
                return;
            }
        }
        System.out.println("Resposta inválida!");
       }
    }

   }


    