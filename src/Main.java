import java.util.Scanner;
import java.util.Set;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashSet;
public class Main {
    public static Scanner teclado = new Scanner(System.in);
    public static final String RESET = "\u001B[0m";
    public static final String AZUL = "\u001B[34m";
    public static final String VERMELHO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARELO = "\u001B[33m";         
    public static final String CIANO = "\u001B[36m";
    public static final String BRANCO = "\u001B[37m";

    public static String[] cores = {"AZUL", "VERMELHO", "VERDE", "AMARELO", "CIANO", "BRANCO"};
    public static void main(String[] args) {
        System.out.println();
        System.out.println("  ╔══════════════════════════════════════════╗");
        System.out.println("  ║     🎲  BEM-VINDO AO JOGO DE TABULEIRO   ║");
        System.out.println("  ╚══════════════════════════════════════════╝");
        System.out.println();

        System.out.print("  Ativar MODO DEBUG? (s/n): ");
        boolean modoDebug = teclado.nextLine().trim().equalsIgnoreCase("s");
        

        Random random = new Random();

        Tabuleiro tabuleiro = new Tabuleiro(40);
        ArrayList<Jogador> jogadores = new ArrayList<>();
        ArrayList<String> coresDisponiveis = new ArrayList<>();

        for (String c : cores){
            coresDisponiveis.add(c);
        }
        int quantidadesJogadores = -1;

        while (quantidadesJogadores < 2 || quantidadesJogadores > 6){
            System.out.print("  Quantidade de jogadores (2 a 6): ");
            try {
                quantidadesJogadores = teclado.nextInt();
                if (quantidadesJogadores < 2 || quantidadesJogadores >= 6) System.out.println(" X deve ser tal que 2 < X < 6");
            } catch (Exception e){
                System.out.println("    Entrada inválida");
                teclado.nextLine();
            }
        }
        
        teclado.nextLine();
        for (int i = 1; i <= quantidadesJogadores; i ++){
            System.out.println();
            System.out.println("  ╔══════════════════════════════╗");
            System.out.println("  ║     👤  CRIAÇÃO DE JOGADOR   ║");
            System.out.println("  ╚══════════════════════════════╝");
            System.out.println();
            System.out.println("    Selecione a cor para o jogador " + i);
            System.out.println("    Cores disponíveis: ");
                for (String s : coresDisponiveis){
                    System.out.println("*: " + s);
                }
            
            
            
            // --- Seleção de cor ---
            boolean valida = false;
            String cor;
            do {
                
            System.out.print("  Selecione a cor: ");
            cor = teclado.nextLine().toUpperCase();
            if (coresDisponiveis.contains(cor)){
                coresDisponiveis.remove(cor);
                valida = true;
            } else {
                System.out.println("    x: Selecione uma cor dispoível!");
                System.out.println();
            }
            } while (!valida);
            
            // --- Seleção de tipo ---
            TipoJogador tipoJog = null;
            switch (random.nextInt(3)) {
                case 0 -> tipoJog = new JogadorNormal();
                case 1 -> tipoJog = new JogadorSortudo();
                case 2 -> tipoJog = new JogadorAzarado();
            }
            jogadores.add(new Jogador(cor, tipoJog));
            System.out.println("\n  *: Inicializando o jogador " + cor + " como um jogador " + tipoJog.getNome()+ "...");
            

            System.out.println("  ┌───────────────────────────────────────────────┐");
            System.out.println("  │              JOGADORES REGISTRADOS            │");
            System.out.println("  ├───────────────────────────────────────────────┤");
            for (Jogador j : jogadores) {
                System.out.printf("    %-10s [%-8s]\n",                              
                        j.getCor(), j.getTipo().getNome());
            }
        }

        Set<String> tipos = new HashSet<>();
        for (Jogador j : jogadores) tipos.add(j.getTipo().getNome());
        if (tipos.size() < 2) {
            System.out.println();
            System.out.println("x: É necessário pelo menos dois tipos de jogadores diferentes!");
            if (!jogadores.get(1).getTipo().getNome().equals("Azarado")){
                System.out.println("x: O segundo jogador será definido automaticamente como Azarado.");
                jogadores.get(1).setTipo(new JogadorSortudo());
            } else {
                System.out.println("x: O segundo jogador será definido automaticamente como Normal.");
                jogadores.get(1).setTipo(new JogadorNormal());
            }
            
            
        }
        System.out.println("Tudo pronta para jogar");
        Jogo jogo = new Jogo(jogadores, tabuleiro, modoDebug);
        jogo.jogar();

    }
}