import java.util.ArrayList;
import java.util.List;

public class Paciente {

    private Dieta dietaPaciente;
    private String nome;
    private String login;
    private String senha;
    private int cpf;
    private int rg;
    private String email;
    private double altura;
    private double peso;
    private int idade;
    private String alergiasDoencas;
    private String profissao;
    private double imc;

    Paciente(){}

    Paciente(String nome, int cpf, int rg, String email, String profissao, String login, String senha, double altura,
             double peso, int idade){
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
    }

    Paciente(Dieta dietaPaciente, String nome, String login, String senha,
             int cpf, int rg, String email, double altura, double peso,
             int idade, String alergiasDoencas, String profissao, double imc) {
        this.dietaPaciente = dietaPaciente;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.cpf = cpf;
        this.rg = rg;
        this.email = email;
        this.altura = altura;
        this.peso = peso;
        this.idade = idade;
        this.alergiasDoencas = alergiasDoencas;
        this.profissao = profissao;
        this.imc = imc;
    }

    public Paciente criarLucas() {
        Alimento pera = new Alimento("Pera", 999);
        List<Alimento> alimentosPossiveis = new ArrayList<>();
        alimentosPossiveis.add(pera);
        Dieta dietaDoLucas = new Dieta(alimentosPossiveis);
        return new Paciente(dietaDoLucas,"lucas", "lulu", "123", 44444402, 5094137, "lucas@lucas.br", 1.85, 75.0, 19, "Alergia a Camarao e cenoura", "Vendedor", 0.94);
    }



    public Paciente criarFausto() {
        Alimento calzone = new Alimento("Calzone", 999);
        List<Alimento> alimentosPossiveis = new ArrayList<>();
        alimentosPossiveis.add(calzone);
        Dieta dietaDoFausto = new Dieta(alimentosPossiveis);
        return new Paciente(dietaDoFausto,"fausto", "fafa", "123", 44444402, 5094137, "fausto@fausto.br", 1.85, 75.0, 19, "Alergia a Refrigerante e Comida", "Comprador", 0.94 );
    }



    public Paciente criarJoao() {
        Alimento alface = new Alimento("Alface", 999);
        List<Alimento> alimentosPossiveis = new ArrayList<>();
        alimentosPossiveis.add(alface);
        Dieta dietaDoJoao = new Dieta(alimentosPossiveis);
        return new Paciente(dietaDoJoao,"joao", "jojo", "123", 44444402, 5094137, "joao@joao.br", 1.85, 75.0, 19, "Alergia a lactose", "Padeiro", 0.94 );
    }

    public String getNome() {
        return this.nome;
    }

    public Dieta getDietaPaciente() {
        return dietaPaciente;
    }

    public void setDietaPaciente(Dieta dietaPaciente) {
        this.dietaPaciente = dietaPaciente;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getAlergiasDoencas() {
        return alergiasDoencas;
    }

    public void setAlergiasDoencas(String alergiasDoencas) {
        this.alergiasDoencas = alergiasDoencas;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

