import java.util.ArrayList;


public class Tabuleiro {

    private int tamanho;
    public ArrayList<Casa> casas;

    public Tabuleiro(int tamanho){
       casas  = new ArrayList<>();
       this.tamanho = tamanho;
       this.inicializarCasas();
    }
    
    public void inicializarCasas(){
        for (int i = 0; i < tamanho; i++){
            if (i == 10 || i == 25 || i == 38) casas.add(new CasaDontPlayNextRd());
            else if (i == 13) casas.add(new CasaSurpresa());
            else if (i == 5 || i == 15 || i == 30) casas.add(new CasaSorte());
            else if (i == 17 || i == 27) casas.add(new CasaChoosePlayer());
            else if (i == 20 || i == 35) casas.add(new CasaMagica());
            else casas.add(new Casa());
        }
    }
   
}
