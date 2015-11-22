import java.util.ArrayList;
import java.util.List;

public class Alimento {
    private String nome, quantidade;
    private double calorias, peso;

    Alimento(){}

    Alimento(String nome, String quantidade, double peso, double calorias) {
        this.nome = nome;
        this.calorias = calorias;
        this.quantidade = quantidade;
        this.peso = peso;
    }

    public List<Alimento> criarDefaults(){
        List<Alimento> alisDefaults  = new ArrayList<>();

        alisDefaults.add(new Alimento("alcatra frita", "2 fatias", 100, 147.0));
        alisDefaults.add(new Alimento("bacon frito", "2 cubos", 30, 198.0));
        alisDefaults.add(new Alimento("abacaxi", "1 fatia", 80, 50.0));
        alisDefaults.add(new Alimento("lasanha", "1 porção", 100, 139.0));
        alisDefaults.add(new Alimento("coca-cola", "1 lata", 350, 137.0));
        alisDefaults.add(new Alimento("cebola", "1 unidade", 70, 32.0));

        return alisDefaults;
    }

    public String getNome() {
        return nome;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public double getCalorias() {
        return calorias;
    }

    public double getPeso() {
        return peso;
    }
}
