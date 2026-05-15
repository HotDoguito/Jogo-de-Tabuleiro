import java.util.Random;

public abstract class Jogador {
    Random aleatorio = new Random();
    
    protected String cor;
    protected String nome;
    protected int posicao;
    protected int jogadas;
    
    protected boolean pularVez;

    public Jogador(String nome, String cor){
        this.cor = cor;
        this.nome = nome;
        this.posicao = 0;
        this.jogadas = 0;
        this.pularVez = false;
       
    }

    public abstract int[] jogarDados();
    
}
