import java.util.ArrayList;
import java.util.List;

public class Dieta {

    private String nome;
    private List<Cardapio> cardapiosDieta;
    private double totalCalorias;

    Dieta(){}

    Dieta(String nome, List<Cardapio> cardapiosDieta) {
        this.nome = nome;
        this.cardapiosDieta = cardapiosDieta;
    }

    public List<Dieta> criarDefaults(){
        List<Dieta> diesDefaults = new ArrayList<>();
        Cardapio cardAux = new Cardapio();
        List<Cardapio> listCardAux = new ArrayList<>(cardAux.criarDefaults());
        listCardAux.remove(0);

        diesDefaults.add(new Dieta("dieta fausto 2016", cardAux.criarDefaults()));
        diesDefaults.add(new Dieta("faustinho", listCardAux));

        return diesDefaults;
    }

    public String getNome() {
        return nome;
    }
}
