public class JogadorNormal extends Jogador {

    public JogadorNormal(String nome, String cor){
        super(nome, cor);
    }
    
    public int[] jogarDados(){
       if (pularVez){
        pularVez = false;
        return null;}

        int d1 = aleatorio.nextInt(6) + 1;
        int d2 = aleatorio.nextInt(6) + 1;
    
        this.jogadas++;
        return new int[] {d1, d2};

    }
    
}
