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

    public List<Paciente> criarDefaults(){
        List<Paciente> pacsDefault = new ArrayList<>();

        Alimento pera = new Alimento("Pera", "1 unidade", 30, 200.0);
        List<Alimento> alimentosPossiveisLucas = new ArrayList<>();
        alimentosPossiveisLucas.add(pera);
        Dieta dietaDoLucas = new Dieta(alimentosPossiveisLucas);

        Alimento calzone = new Alimento("Calzone", "1 unidade", 30, 200.0);
        List<Alimento> alimentosPossiveisFausto = new ArrayList<>();
        alimentosPossiveisFausto.add(calzone);
        Dieta dietaDoFausto = new Dieta(alimentosPossiveisFausto);

        Alimento alface = new Alimento("Alface", "1 unidade", 30, 200.0);
        List<Alimento> alimentosPossiveisJoao = new ArrayList<>();
        alimentosPossiveisJoao.add(alface);
        Dieta dietaDoJoao = new Dieta(alimentosPossiveisJoao);

        pacsDefault.add(new Paciente(dietaDoLucas,"lucas", "lulu", "123",
                44444402, 5094137, "lucas@lucas.br", 1.85, 75.0, 19, "Alergia a Camarao e cenoura", "Vendedor", 0.94));
        pacsDefault.add(new Paciente(dietaDoFausto,"fausto", "fafa", "123",
                44444402, 5094137, "fausto@fausto.br", 1.85, 75.0, 19, "Alergia a Refrigerante e Comida", "Comprador", 0.94 ));
        pacsDefault.add(new Paciente(dietaDoJoao,"joao", "jojo", "123",
                44444402, 5094137, "joao@joao.br", 1.85, 75.0, 19, "Alergia a lactose", "Padeiro", 0.94 ));
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

    public String getAlergiasDoencas() {
        return alergiasDoencas;
    }

    public String getProfissao() {
        return profissao;
    }
}

