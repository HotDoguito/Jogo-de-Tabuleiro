import java.util.ArrayList;
import java.util.Scanner;
public class CasaChoosePlayer extends Casa {
    Scanner input = new Scanner(System.in);

    public void mensagemCasa(Jogador player){
        System.out.println("Jogador " + player.nome + ", você entrou em uma casa Especial!\nEscolha um jogador para voltar ao início do tabuleiro.");
    }
    public void houseEffect(Jogador player,  ArrayList<Jogador> jogadores){
        System.out.println("Digite o nome ou a cor do jogador que voltará para o início do tabuleiro: ");
        String resp = input.nextLine();
       while(true){
        System.out.println("Digite o nome ou a cor do jogador que voltará para o início do tabuleiro: ");
        resp = input.nextLine();
        for(int i = 0; i < jogadores.size(); i++){
            if((jogadores.get(i).nome) == resp || jogadores.get(i).cor == resp){
                System.out.println("Jogador escolhido com sucesso!");
            jogadores.get(i).posicao = 0;
            return;
        }
        System.out.println("Resposta inválida!");
       }
    }

   }
}

    
