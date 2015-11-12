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

    Paciente(String nome, int cpf, int rg, String email, String profissao, String login, String senha){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.cpf = cpf;
        this.rg = rg;
        this.email = email;
        this.profissao = profissao;
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
        Alimento[] alimentosPossiveis = new Alimento[1];
        alimentosPossiveis[0] = pera;
        Dieta dietaDoLucas = new Dieta(alimentosPossiveis);
        return new Paciente(dietaDoLucas,"lucas", "lulu", "123", 44444402, 5094137, "lucas@lucas.br", 1.85, 75.0, 19, "Alergia a Camarao e cenoura", "Vendedor", 0.94);
    }



    public Paciente criarFausto() {
        Alimento calzone = new Alimento("Calzone", 999);
        Alimento[] alimentosPossiveis = new Alimento[1];
        alimentosPossiveis[0] = calzone;
        Dieta dietaDoFausto = new Dieta(alimentosPossiveis);
        return new Paciente(dietaDoFausto,"fausto", "fafa", "123", 44444402, 5094137, "fausto@fausto.br", 1.85, 75.0, 19, "Alergia a Refrigerante e Comida", "Comprador", 0.94 );
    }



    public Paciente criarJoao() {
        Alimento alface = new Alimento("Alface", 999);
        Alimento[] alimentosPossiveis = new Alimento[1];
        alimentosPossiveis[0] = alface;
        Dieta dietaDoJoao = new Dieta(alimentosPossiveis);
        return new Paciente(dietaDoJoao,"joao", "jojo", "123", 44444402, 5094137, "joao@joao.br", 1.85, 75.0, 19, "Alergia a lactose", "Padeiro", 0.94 );
    }

    public String getNome() {
        return this.nome;
    }
}
