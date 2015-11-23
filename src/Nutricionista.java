import javax.swing.JOptionPane;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Nutricionista implements Logavel {

    private String login;
    private String senha;
    private List<Paciente> pacsDaNut;
    private List<Alimento> alisDaNut;
    private List<Cardapio> cardsDaNut;

    Nutricionista(){}

    Nutricionista(String login, String senha){
        this.login = login;
        this.senha = senha;

        Paciente pacAux = new Paciente();
        Alimento aliAux = new Alimento();
        Cardapio cardAux = new Cardapio();

        this.pacsDaNut = new ArrayList<>(pacAux.criarDefaults());
        this.alisDaNut = new ArrayList<>(aliAux.criarDefaults());
        this.cardsDaNut = new ArrayList<>(cardAux.criarDefaults());
    }

    public void criarPac(String nome, int cpf, int rg, String email, String profissao, String login, String senha,
                         double altura, double peso, int idade){
        this.pacsDaNut.add(new Paciente(nome, cpf, rg, email, profissao, login, senha, altura, peso, idade));
    }

    public void criarAli(String nome, String quantidade, double peso, double calrs){
        this.alisDaNut.add(new Alimento(nome, quantidade, peso, calrs));
    }

    public void criarCard(String nome, List<Alimento> alimentos){
        this.cardsDaNut.add(new Cardapio(nome, alimentos));
    }

    public void editarAli(String nome, String quantidade, double peso, double calrs, int nroPac){
        this.alisDaNut.set(nroPac, new Alimento(nome, quantidade, peso, calrs));
    }

    public void editarPac(String nome, int cpf, int rg, String email, String profissao, String login, String senha,
                          double altura, double peso, int idade, int nroPac){
        this.pacsDaNut.set(nroPac, new Paciente(nome, cpf, rg, email, profissao, login, senha, altura, peso, idade));
    }

    public void editarCard(String nome, List<Alimento> alimentos, int nroCard){
        this.cardsDaNut.set(nroCard, new Cardapio(nome, alimentos));
    }

    public void excluirPac(int nroPac){
        this.pacsDaNut.remove(nroPac);
    }

    public void excluirAli(int nroPac){
        this.alisDaNut.remove(nroPac);
    }

    public void excluirCard(int nroPac){
        this.cardsDaNut.remove(nroPac);
    }

    public int retornaTotalPacientes(){
        return this.pacsDaNut.size();
    }

    public int retornaTotalAlis(){
        return this.alisDaNut.size();
    }

    public int retornaTotalCards(){
        return this.cardsDaNut.size();
    }

    public String retornaNomePaciente(int posicao){
        if(pacsDaNut.get(posicao) != null)
            return pacsDaNut.get(posicao).getNome();
        else
            return "";
    }

    public String retornaNomeAli(int posicao){
        if(alisDaNut.get(posicao) != null)
            return alisDaNut.get(posicao).getNome();
        else
            return "";
    }

    public String retornaNomeCard(int posicao){
        if(cardsDaNut.get(posicao) != null)
            return cardsDaNut.get(posicao).getNome();
        else
            return "";
    }

    public String retornaQuantAli(int posicao) {
        if(alisDaNut.get(posicao) != null)
            return alisDaNut.get(posicao).getQuantidade();
        else
            return "";
    }

    public double retornaClrsAli(int posicao){
        if(alisDaNut.get(posicao) != null)
            return alisDaNut.get(posicao).getCalorias();
        else
            return 0.0;
    }

    public double retornaPesoAli(int posicao){
        if(alisDaNut.get(posicao) != null)
            return alisDaNut.get(posicao).getPeso();
        else
            return 0.0;
    }

    public int retornaCPFPaciente(int posicao){
        if(pacsDaNut.get(posicao) != null)
            return pacsDaNut.get(posicao).getCpf();
        else
            return 0 ;
    }

    public int retornaRGPaciente(int posicao){
        if(pacsDaNut.get(posicao) != null)
            return pacsDaNut.get(posicao).getRg();
        else
            return 0 ;
    }

    public String retornaEmailPaciente(int posicao){
        if(pacsDaNut.get(posicao) != null)
            return pacsDaNut.get(posicao).getEmail();
        else
            return "" ;
    }

    public double retornaAlturaPaciente(int posicao){
        if(pacsDaNut.get(posicao) != null)
            return pacsDaNut.get(posicao).getAltura();
        else
            return 0 ;
    }

    public double retornaPesoPaciente(int posicao){
        if(pacsDaNut.get(posicao) != null)
            return pacsDaNut.get(posicao).getPeso();
        else
            return 0 ;
    }

    public int retornaIdadePaciente(int posicao){
        if(pacsDaNut.get(posicao) != null)
            return pacsDaNut.get(posicao).getIdade();
        else
            return 0 ;
    }

    public String retornaLoginPaciente(int posicao){
        if(pacsDaNut.get(posicao) != null)
            return pacsDaNut.get(posicao).getLogin();
        else
            return "";
    }

    public String retornaSenhaPaciente(int posicao){
        if(pacsDaNut.get(posicao) != null)
            return pacsDaNut.get(posicao).getSenha();
        else
            return "";
    }

    public String retornaProfissaoPaciente(int posicao){
        if(pacsDaNut.get(posicao) != null)
            return pacsDaNut.get(posicao).getProfissao();
        else
            return "";
    }

    public String calculaImc(double altura, double peso){
        DecimalFormat df = new DecimalFormat("##.##");
        df.setRoundingMode(RoundingMode.DOWN);

        return df.format(peso / (altura * altura));
    }

    public List<Alimento> retornaAlisCard(int posicao) {
        if(cardsDaNut.get(posicao) != null)
            return cardsDaNut.get(posicao).getAlimentos();
        else
            return null;
    }

    public double calculaTotalClrs(int posicao){
        if(cardsDaNut.get(posicao) != null)
            return cardsDaNut.get(posicao).totalClrs();
        else
            return 0.0;
    }

    public List<Alimento> getAlisDaNut() {
        return alisDaNut;
    }

    public boolean logar(String login, String senha) {
        if((login.equals(this.login)) && senha.equals(this.senha)){
            JOptionPane.showMessageDialog(null, "Nutricionista logado com sucesso!");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Login e/ou senha incorretos!");
            return false;
        }
    }
}
