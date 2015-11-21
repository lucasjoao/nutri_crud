import javax.swing.JOptionPane;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Nutricionista implements Logavel {

    private String nome;
    private String login;
    private String senha;
    private Paciente[] pacsDaNut;
    // if delete criarNome, then slot = 0
    private int slot = 3;

    Nutricionista(){}

    Nutricionista(String nome, String login, String senha, Paciente[] pacsDaNut) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.pacsDaNut = pacsDaNut;
    }

    public Nutricionista criarLucia() {
        Paciente pacAux = new Paciente();
        Paciente[] pacsDaNut = new Paciente[20];
        pacsDaNut[0] = pacAux.criarLucas();
        pacsDaNut[1] = pacAux.criarJoao();
        pacsDaNut[2] = pacAux.criarFausto();
        return new Nutricionista("lucia", "luluzinha", "123", pacsDaNut);
    }

    public void criarPac(String nome, int cpf, int rg, String email, String profissao, String login, String senha,
                         double altura, double peso, int idade){
        this.pacsDaNut[slot] = new Paciente(nome, cpf, rg, email, profissao, login, senha, altura, peso, idade);
        slot++;
    }

    public int retornaTotalPacientes(){
        int numDePacs = 0;
        for(int i = 0; i < pacsDaNut.length; i++)
            numDePacs = i;
        return numDePacs;
    }

    public String retornaNomePaciente(int posicao){
        if(pacsDaNut[posicao] != null)
            return pacsDaNut[posicao].getNome();
        else
            return "";
    }

    public int retornaCPFPaciente(int posicao){
        if(pacsDaNut[posicao] != null)
            return pacsDaNut[posicao].getCpf();
        else
            return 0 ;
    }

    public int retornaRGPaciente(int posicao){
        if(pacsDaNut[posicao] != null)
            return pacsDaNut[posicao].getRg();
        else
            return 0 ;
    }

    public String retornaEmailPaciente(int posicao){
        if(pacsDaNut[posicao] != null)
            return pacsDaNut[posicao].getEmail();
        else
            return "" ;
    }

    public double retornaAlturaPaciente(int posicao){
        if(pacsDaNut[posicao] != null)
            return pacsDaNut[posicao].getAltura();
        else
            return 0 ;
    }

    public double retornaPesoPaciente(int posicao){
        if(pacsDaNut[posicao] != null)
            return pacsDaNut[posicao].getPeso();
        else
            return 0 ;
    }

    public int retornaIdadePaciente(int posicao){
        if(pacsDaNut[posicao] != null)
            return pacsDaNut[posicao].getIdade();
        else
            return 0 ;
    }

    public String retornaDietsAlergsPaciente(int posicao){
        if(pacsDaNut[posicao] != null)
            return pacsDaNut[posicao].getAlergiasDoencas();
        else
            return "";
    }

    public String retornaLoginPaciente(int posicao){
        if(pacsDaNut[posicao] != null)
            return pacsDaNut[posicao].getLogin();
        else
            return "";
    }

    public String retornaSenhaPaciente(int posicao){
        if(pacsDaNut[posicao] != null)
            return pacsDaNut[posicao].getSenha();
        else
            return "";
    }

    public String retornaProfissaoPaciente(int posicao){
        if(pacsDaNut[posicao] != null)
            return pacsDaNut[posicao].getProfissao();
        else
            return "";
    }

    public String calculaImc(int posicao)
    {
        if (pacsDaNut[posicao] != null){
            DecimalFormat df = new DecimalFormat("##.##");
            df.setRoundingMode(RoundingMode.DOWN);

            double altura = pacsDaNut[posicao].getAltura();
            double peso = pacsDaNut[posicao].getPeso();
            double imc = peso/(altura*altura);
            return df.format(imc);
        }else
            return "";
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
