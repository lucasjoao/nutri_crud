import javax.swing.JOptionPane;

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

    public void criarPac(String nome, int cpf, int rg, String email, String profissao, String login, String senha){
        this.pacsDaNut[slot] = new Paciente(nome, cpf, rg, email, profissao, login, senha);
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
