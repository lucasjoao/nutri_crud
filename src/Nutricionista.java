import javax.swing.JOptionPane;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Nutricionista implements Logavel {

    private String nome;
    private String login;
    private String senha;
    private List<Paciente> pacsDaNut;

    Nutricionista(){}

    Nutricionista(String nome, String login, String senha, List<Paciente> pacsDaNut) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.pacsDaNut = pacsDaNut;
    }

    public Nutricionista criarLucia() {
        Paciente pacAux = new Paciente();
        List<Paciente> pacsDaNut = new ArrayList<>();
        pacsDaNut.add(pacAux.criarLucas());
        pacsDaNut.add(pacAux.criarFausto());
        pacsDaNut.add(pacAux.criarJoao());
        return new Nutricionista("lucia", "luluzinha", "123", pacsDaNut);
    }

    public void criarPac(String nome, int cpf, int rg, String email, String profissao, String login, String senha,
                         double altura, double peso, int idade){
        this.pacsDaNut.add(new Paciente(nome, cpf, rg, email, profissao, login, senha, altura, peso, idade));
    }

    public void editarPac(String nome, int cpf, int rg, String email, String profissao, String login, String senha,
                          double altura, double peso, int idade, int nroPac){
        this.pacsDaNut.set(nroPac, new Paciente(nome, cpf, rg, email, profissao, login, senha, altura, peso, idade));
    }

    public int retornaTotalPacientes(){
        return this.pacsDaNut.size();
    }

    public String retornaNomePaciente(int posicao){
        if(pacsDaNut.get(posicao) != null)
            return pacsDaNut.get(posicao).getNome();
        else
            return "";
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

    public String retornaDietsAlergsPaciente(int posicao){
        if(pacsDaNut.get(posicao) != null)
            return pacsDaNut.get(posicao).getAlergiasDoencas();
        else
            return "";
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
