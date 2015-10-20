import javax.swing.JOptionPane;


public class Nutricionista implements Logavel {

    private String nome;
    private String login;
    private String senha;
    private Paciente[] pacientes;

    public Nutricionista(){}

    public Nutricionista(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
		/*this.pacientes = pacientes;*/
    }

    public static void criarLucia() {
		/*Paciente[] pacientes = new Paciente[3];
		Paciente lucas = pacientes[0].criarLucas();
		pacientes[0] = lucas;
		pacientes[1] = pacientes[1].criarJoao();
		pacientes[2] = pacientes[2].criarFausto();*/
        Nutricionista lucia = new Nutricionista("lucia", "luluzinha", "123"/*, pacientes*/);

    }

    public boolean logar(String login, String senha) {
        // TODO Auto-generated method stub
        if((login.equals(this.login)) && senha.equals(this.senha)){
            JOptionPane.showMessageDialog(null, "Nutricionista logado com sucesso!");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Login e/ou senha incorretos!");
            return false;
        }
    }
}
