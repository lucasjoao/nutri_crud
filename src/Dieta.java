import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dieta {

    private String nome;
    private List<Cardapio> dmg, seg, ter, qua, qui, sex, sab;
    private double totalCalorias;

    Dieta(){}

    Dieta(String nome, List<Cardapio> cardsDmg, List<Cardapio> cardsSeg, List<Cardapio> cardsTer,
          List<Cardapio> cardsQua, List<Cardapio> cardsQui, List<Cardapio> cardsSex, List<Cardapio> cardsSab){
        this.nome = nome;
        this.dmg = cardsDmg;
        this.seg = cardsSeg;
        this.ter = cardsTer;
        this.qua = cardsQua;
        this.qui = cardsQui;
        this.sex = cardsSex;
        this.sab = cardsSab;
        this.totalCalorias = this.totalClrs();
    }

    public List<Dieta> criarDefaults(){
        List<Dieta> diesDefaults = new ArrayList<>();
        Cardapio cardAux = new Cardapio();
        List<Cardapio> listCardAux = new ArrayList<>(cardAux.criarDefaults());
        listCardAux.remove(0);
        List<Cardapio> listCardVazio = new ArrayList<>();

        diesDefaults.add(new Dieta("dieta fausto 2016", listCardVazio, listCardVazio, listCardAux,
                listCardVazio, cardAux.criarDefaults(), listCardVazio, listCardAux));
        diesDefaults.add(new Dieta("faustinho", listCardAux, listCardVazio, listCardVazio, cardAux.criarDefaults(),
                listCardVazio, listCardAux, listCardVazio));

        return diesDefaults;
    }

    public int tamMaiorLista(){
        List<Integer> todosTams = new ArrayList<>();
        todosTams.add(dmg.size());
        todosTams.add(seg.size());
        todosTams.add(ter.size());
        todosTams.add(qua.size());
        todosTams.add(qui.size());
        todosTams.add(sex.size());
        todosTams.add(sab.size());
        return Collections.max(todosTams);
    }

    public double totalClrs(){
        double totalClrs = 0;

        for(Cardapio cardapio : this.dmg)
            totalClrs += cardapio.getClrs();

        for(Cardapio cardapio : this.seg)
            totalClrs += cardapio.getClrs();

        for(Cardapio cardapio : this.ter)
            totalClrs += cardapio.getClrs();

        for(Cardapio cardapio : this.qua)
            totalClrs += cardapio.getClrs();

        for(Cardapio cardapio : this.qui)
            totalClrs += cardapio.getClrs();

        for(Cardapio cardapio : this.sex)
            totalClrs += cardapio.getClrs();

        for(Cardapio cardapio : this.sab)
            totalClrs += cardapio.getClrs();

        return totalClrs;
    }

    public void colocaDmg(Cardapio card){
        this.dmg.add(card);
    }

    public void colocaSeg(Cardapio card){
        this.seg.add(card);
    }

    public void colocaTer(Cardapio card){
        this.ter.add(card);
    }

    public void colocaQua(Cardapio card){
        this.qua.add(card);
    }

    public void colocaQui(Cardapio card){
        this.qui.add(card);
    }

    public void colocaSex(Cardapio card){
        this.sex.add(card);
    }

    public void colocaSab(Cardapio card){
        this.sab.add(card);
    }

    public String getNome() {
        return nome;
    }

    public List<Cardapio> getDmg() {
        return dmg;
    }

    public List<Cardapio> getSeg() {
        return seg;
    }

    public List<Cardapio> getTer() {
        return ter;
    }

    public List<Cardapio> getQua() {
        return qua;
    }

    public List<Cardapio> getQui() {
        return qui;
    }

    public List<Cardapio> getSex() {
        return sex;
    }

    public List<Cardapio> getSab() {
        return sab;
    }
}
