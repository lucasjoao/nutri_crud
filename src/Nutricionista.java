import javax.swing.JOptionPane;

public class Nutricionista implements Logavel {

    private String nome;
    private String login;
    private String senha;
    private Paciente[] pacsDaNut;

    Nutricionista(){}

    Nutricionista(String nome, String login, String senha, Paciente[] pacsDaNut) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.pacsDaNut = pacsDaNut;
    }

    public Nutricionista criarLucia() {
        Paciente pacAux = new Paciente();
        Paciente[] pacsDaNut = new Paciente[3];
        pacsDaNut[0] = pacAux.criarLucas();
        pacsDaNut[1] = pacAux.criarJoao();
        pacsDaNut[2] = pacAux.criarFausto();
        return new Nutricionista("lucia", "luluzinha", "123", pacsDaNut);
    }

    public int retornaQuantPacientes(Nutricionista nutricionista ){
        int numDePacs = 0;
        for(int i =0; i < nutricionista.pacsDaNut.length; i++ ){
            numDePacs = i;
        }
        return numDePacs;
    }

    public String retornaPaciente(int posicao, Nutricionista nutricionista){
        String nome = nutricionista.pacsDaNut[posicao].pegarLogin();
        return nome;
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
