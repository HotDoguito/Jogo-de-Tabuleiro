import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
public class Jogo {
    public static Scanner teclado = new Scanner(System.in);
    public static final String RESET = "\u001B[0m";
    public static final String BLUE = "\u001B[34m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";         
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static String[] cores = {"AZUL", "VERMELHO", "VERDE", "AMARELO", "CIANO", "BRANCO"};
    public static void main(String[] args) {
        

        Random random = new Random();

        Tabuleiro tabuleiro = new Tabuleiro(41);
        ArrayList<Jogador> jogadores = new ArrayList<>();
        ArrayList<String> coresDisponiveis = new ArrayList<>();

        for (String c : cores){
            coresDisponiveis.add(c);
        }
        int quantidadesJogadores = -1;

        while (quantidadesJogadores < 2 || quantidadesJogadores > 6){
            System.out.print("Quantidade de jogadores (2 a 6): ");
            try {
                quantidadesJogadores = teclado.nextInt();
                if (quantidadesJogadores <= 2 || quantidadesJogadores >= 6) System.out.println("X deve ser tal que 2 < X < 6");
            } catch (Exception e){
                System.out.println("Entrada inválida");
                teclado.nextLine();
            }
        }
        
        teclado.nextLine();
        for (int i = 1; i <= quantidadesJogadores; i ++){
            
            // --- Seleção de nome ---
            System.out.printf("Nome(padrão: Jogador %d): ", i);
            String nome = teclado.nextLine();
            if (nome.isEmpty()) nome = "Jogador " + i;


            // --- Seleção de cor ---
            boolean valida = false;
            String cor;
            do {
                System.out.println("Cores disponíveis: ");
                for (String s : coresDisponiveis){
                    System.out.println("*: " + s);
                }
            System.out.println("Selecione a cor");
            cor = teclado.nextLine().toUpperCase();
            if (coresDisponiveis.contains(cor)){
                coresDisponiveis.remove(cor);
                valida = true;
            } else {
                System.out.println("Selecione uma cor dispoível");
            }
            } while (!valida);
            
            // --- Seleção de tipo ---
            switch (random.nextInt(3)) {
                case 0 -> jogadores.add(new JogadorNormal(nome, cor));
                case 1 -> jogadores.add(new JogadorSortudo(nome, cor));
                case 2 -> jogadores.add(new JogadorAzarado(nome, cor));
            }
            

        }


        



        


    }



}