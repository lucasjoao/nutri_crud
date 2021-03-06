import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Paciente implements Logavel {

    private String nome;
    private String login;
    private String senha;
    private int cpf;
    private int rg;
    private String email;
    private double altura;
    private double peso;
    private int idade;
    private String profissao;
    private Dieta dieta;

    Paciente(){}

    Paciente(String nome, int cpf, int rg, String email, String profissao, String login, String senha, double altura,
             double peso, int idade, Dieta dieta){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.cpf = cpf;
        this.rg = rg;
        this.email = email;
        this.profissao = profissao;
        this.altura = altura;
        this.peso = peso;
        this.idade = idade;
        this.dieta = dieta;
    }

    public List<Paciente> criarDefaults(){
        List<Paciente> pacsDefault = new ArrayList<>();
        Dieta dietaAux = new Dieta();
        List<Dieta> dietasAux = dietaAux.criarDefaults();

        pacsDefault.add(new Paciente("Lucas João", 44444402, 5094137,
                "lucas@lucas.br", "Vendedor", "lulu", "123", 1.85, 75.0, 19, dietasAux.get(0)));
        pacsDefault.add(new Paciente("Fausto Silva", 44444402, 5094137,
                "fausto@fausto.br", "Comprador", "fafa", "123", 1.85, 75.0, 19, dietasAux.get(1)));
        pacsDefault.add(new Paciente("José", 44444402, 5094137,
                "joao@joao.br", "Padeiro", "jojo", "123", 1.85, 75.0, 19, dietasAux.get(0)));
        return pacsDefault;
    }

    public String getNome() {
        return this.nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public int getCpf() {
        return cpf;
    }

    public int getRg() {
        return rg;
    }

    public String getEmail() {
        return email;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }

    public int getIdade() {
        return idade;
    }

    public String getProfissao() {
        return profissao;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public boolean logar(String login, String senha) {
        if((login.equals(this.login)) && senha.equals(this.senha)){
            JOptionPane.showMessageDialog(null, "Paciente logado com sucesso!");
            return true;
        } else {
            return false;
        }
    }
}

