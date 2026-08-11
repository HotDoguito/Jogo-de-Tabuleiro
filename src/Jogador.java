import java.util.Random;

public class Jogador {
    Random aleatorio = new Random();
    
    private String cor;
    private int posicao;
    private int jogadas;
    private TipoJogador tipo;
    private boolean pularVez;

    public Jogador(String cor, TipoJogador tipo){
        this.cor = cor;
        
        this.tipo = tipo;
        this.posicao = 0;
        this.jogadas = 0;
        this.pularVez = false;
       
    }


    public void incrementarJogada(){
        this.jogadas++;
    }
    public int[] jogarDados(){
        this.jogadas++;
        return tipo.jogarDados();
    }

    public String toString(){
        return cor + " (" + posicao + ")";
    }

    public boolean isPularVez() {
        return pularVez;
    }

    public void setPularVez(boolean pularVez) {
        this.pularVez = pularVez;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }


    public String getCor() {
        return cor;
    }



    public int getJogadas() {
        return jogadas;
    }


    public TipoJogador getTipo() {
        return tipo;
    }


    public void setTipo(TipoJogador tipo) {
        this.tipo = tipo;
    }

    

    
    
}