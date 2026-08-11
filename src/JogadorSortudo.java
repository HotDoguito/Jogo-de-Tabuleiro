import java.util.Random;
public class JogadorSortudo implements TipoJogador {
 
    private final Random random = new Random();
 
    @Override
    public int[] jogarDados() {
        int d1, d2;
        do {
            d1 = random.nextInt(6) + 1;
            d2 = random.nextInt(6) + 1;
        } while (d1 + d2 < 7);
        return new int[]{d1, d2};
    }
 
    @Override
    public String getNome() { return "Sortudo"; }
}