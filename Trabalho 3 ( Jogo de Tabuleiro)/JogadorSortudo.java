public class JogadorSortudo extends Jogador {

    public JogadorSortudo(String nome, String cor){
        super(nome, cor);
    }
    
    public int[] jogarDados(){
       if (pularVez){
        pularVez = false;
        return null;}

        int d1;
        int d2;
        do {
            d1 = aleatorio.nextInt(6) + 1;
            d2 = aleatorio.nextInt(6) + 1;
        } while (d1 + d2 < 7);

        this.jogadas++;
        return new int[] {d1, d2};

    }
}
