import java.util.ArrayList;
import java.util.List;

public class Cardapio {
    private double clrs;
    private String nome;
    private List<Alimento> alimentos;

    Cardapio(){}

    Cardapio(String nome, List<Alimento> alimentos){
        this.nome = nome;
        this.alimentos = alimentos;
        this.clrs = totalClrs();
    }

    public List<Cardapio> criarDefaults(){
        List<Cardapio> cardsDefaults = new ArrayList<>();
        Alimento aliAux = new Alimento();
        List<Alimento> listAliAux = new ArrayList<>(aliAux.criarDefaults());
        listAliAux.remove(0);

        cardsDefaults.add(new Cardapio("saudavel", aliAux.criarDefaults()));
        cardsDefaults.add(new Cardapio("projeto verão", listAliAux));

        return cardsDefaults;
    }

    public String getNome() {
        return nome;
    }

    public double totalClrs() {
        double totalClrs = 0;

        for(Alimento alimento : this.alimentos)
            totalClrs += alimento.getCalorias();

        return totalClrs;
    }

    public List<Alimento> getAlimentos() {
        return alimentos;
    }

    public double getClrs() {
        return clrs;
    }
}
