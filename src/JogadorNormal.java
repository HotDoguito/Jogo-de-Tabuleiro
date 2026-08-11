import java.util.Random;
public class JogadorNormal implements TipoJogador {
 
    private final Random random = new Random();
 
    @Override
    public int[] jogarDados() {
        int d1 = random.nextInt(6) + 1;
        int d2 = random.nextInt(6) + 1;
        return new int[]{d1, d2};
    }
 
    @Override
    public String getNome() { return "Normal"; }
}