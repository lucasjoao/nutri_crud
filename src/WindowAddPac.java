import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class WindowAddPac implements ActionListener, FocusListener {

    private JLabel lblTitulo, lblNome, lblCpf, lblRg, lblEmail, lblProf, lblLogin,
            lblSenha, lblAlt, lblPeso, lblIdade, lblIMC;
    private JTextField txtNome, txtCpf, txtRg, txtEmail, txtProf, txtLogin,
            txtSenha, txtAlt, txtPeso, txtIdade, txtIMC;
    private JFrame jframe;
    private JPanel jpanel;
    private Nutricionista nutricionista;
    private int width, height;
    private JButton btnLogout, btnVoltar, btnSalvar;

    WindowAddPac(){}

    WindowAddPac(JFrame jframe, JPanel jpanel, int width, int height, Nutricionista nutricionista){
        this.jframe = jframe;
        jframe.setTitle("Tela add paciente (1/2)");
        jframe.setSize(width, height);
        jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);

        this.jpanel = jpanel;
        jpanel.setSize(width, height);
        jpanel.setLayout(null);

        jframe.setContentPane(jpanel);

        this.nutricionista = nutricionista;
        this.width = width;
        this.height = height;
    }

    public void initComponent() {
        //make title lbl
        this.lblTitulo = new JLabel("infos paciente");
        lblTitulo.setSize(200, 32);
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(24f));
        lblTitulo.setLocation(((jpanel.getWidth() - lblTitulo.getWidth()) / 2), 16);
        jpanel.add(lblTitulo);

        //make logout btn
        this.btnLogout = new JButton("sair");
        btnLogout.setSize(72, 24);
        btnLogout.setLocation(jpanel.getWidth() / 4 * 3, 325);
        btnLogout.addActionListener(this);
        jpanel.add(btnLogout);

        //make voltar btn
        this.btnVoltar = new JButton("<---");
        btnVoltar.setSize(72, 24);
        btnVoltar.setLocation(jpanel.getWidth() / 12, 325);
        btnVoltar.addActionListener(this);
        jpanel.add(btnVoltar);

        //make salvar btn
        this.btnSalvar = new JButton("Salvar (1/2)");
        btnSalvar.setSize(144, 24);
        btnSalvar.setLocation(((jpanel.getWidth() - btnSalvar.getWidth())/2), 325);
        btnSalvar.addActionListener(this);
        jpanel.add(btnSalvar);

        //make lbl name
        int size = 18;
        this.lblNome = new JLabel("Nome:");
        lblNome.setSize((jpanel.getWidth() - size), size);
        lblNome.setLocation(60, 50);
        jpanel.add(lblNome);

        //make txt name
        this.txtNome = new JTextField();
        txtNome.setSize(((jpanel.getWidth() / 2) - size ), size);
        txtNome.setLocation(145, 50);
        jpanel.add(txtNome);

        //make lbl cpf
        this.lblCpf = new JLabel("CPF: (int)");
        lblCpf.setSize((jpanel.getWidth() - size), size);
        lblCpf.setLocation(60, 70);
        jpanel.add(lblCpf);

        //make txt cpf
        this.txtCpf = new JTextField();
        txtCpf.setSize(((jpanel.getWidth() / 2) - size ), size);
        txtCpf.setLocation(145, 70);
        jpanel.add(txtCpf);

        //make lbl rg
        this.lblRg = new JLabel("RG: (int)");
        lblRg.setSize((jpanel.getWidth() - size), size);
        lblRg.setLocation(60, 90);
        jpanel.add(lblRg);

        //make txt rg
        this.txtRg = new JTextField();
        txtRg.setSize(((jpanel.getWidth() / 2) - size ), size);
        txtRg.setLocation(145, 90);
        jpanel.add(txtRg);

        //make lbl email
        this.lblEmail = new JLabel("E-mail:");
        lblEmail.setSize((jpanel.getWidth() - size), size);
        lblEmail.setLocation(60, 110);
        jpanel.add(lblEmail);

        //make txt email
        this.txtEmail = new JTextField();
        txtEmail.setSize(((jpanel.getWidth() / 2) - size ), size);
        txtEmail.setLocation(145, 110);
        jpanel.add(txtEmail);

        //make lbl job
        this.lblProf = new JLabel("Profissão:");
        lblProf.setSize((jpanel.getWidth() - size), size);
        lblProf.setLocation(60, 130);
        jpanel.add(lblProf);

        //make txt job
        this.txtProf = new JTextField();
        txtProf.setSize(((jpanel.getWidth() / 2) - size ), size);
        txtProf.setLocation(145, 130);
        jpanel.add(txtProf);

        //make lbl login
        this.lblLogin = new JLabel("Login:");
        lblLogin.setSize((jpanel.getWidth() - size), size);
        lblLogin.setLocation(60, 150);
        jpanel.add(lblLogin);

        //make txt login
        this.txtLogin = new JTextField();
        txtLogin.setSize(((jpanel.getWidth() / 2) - size ), size);
        txtLogin.setLocation(145, 150);
        jpanel.add(txtLogin);

        //make lbl password
        this.lblSenha = new JLabel("Senha:");
        lblSenha.setSize((jpanel.getWidth() - size), size);
        lblSenha.setLocation(60, 170);
        jpanel.add(lblSenha);

        //make txt password
        this.txtSenha = new JTextField();
        txtSenha.setSize(((jpanel.getWidth() / 2) - size ), size);
        txtSenha.setLocation(145, 170);
        jpanel.add(txtSenha);

        //make lbl height
        this.lblAlt = new JLabel("Alt, m: (doub)");
        lblAlt.setSize((jpanel.getWidth() - size), size);
        lblAlt.setLocation(60, 190);
        jpanel.add(lblAlt);

        //make txt height
        this.txtAlt = new JTextField();
        txtAlt.setSize(((jpanel.getWidth() / 2) - size ), size);
        txtAlt.setLocation(145, 190);
        txtAlt.addFocusListener(this);
        jpanel.add(txtAlt);

        //make lbl size
        this.lblPeso = new JLabel("Peso, kg: (doub)");
        lblPeso.setSize((jpanel.getWidth() - size), size);
        lblPeso.setLocation(60, 210);
        jpanel.add(lblPeso);

        //make txt size
        this.txtPeso = new JTextField();
        txtPeso.setSize(((jpanel.getWidth() / 2) - size), size);
        txtPeso.setLocation(145, 210);
        txtPeso.addFocusListener(this);
        jpanel.add(txtPeso);

        //make lbl imc
        this.lblIMC = new JLabel("IMC: (doub)");
        lblIMC.setSize((jpanel.getWidth() - size), size);
        lblIMC.setLocation(60, 230);
        jpanel.add(lblIMC);

        //make txt imc
        this.txtIMC = new JTextField();
        txtIMC.setSize(((jpanel.getWidth() / 2) - size ), size);
        txtIMC.setLocation(145, 230);
        jpanel.add(txtIMC);

        //make lbl age
        this.lblIdade = new JLabel("Idade: (int)");
        lblIdade.setSize((jpanel.getWidth() - size), size);
        lblIdade.setLocation(60, 250);
        jpanel.add(lblIdade);

        //make txt age
        this.txtIdade = new JTextField();
        txtIdade.setSize(((jpanel.getWidth() / 2) - size ), size);
        txtIdade.setLocation(145, 250);
        jpanel.add(txtIdade);
    }

    public void remComponent(){
        jpanel.remove(lblTitulo);
        jpanel.remove(btnLogout);
        jpanel.remove(btnVoltar);
        jpanel.remove(btnSalvar);
        jpanel.remove(lblNome);
        jpanel.remove(txtNome);
        jpanel.remove(lblCpf);
        jpanel.remove(txtCpf);
        jpanel.remove(lblRg);
        jpanel.remove(txtRg);
        jpanel.remove(lblEmail);
        jpanel.remove(txtEmail);
        jpanel.remove(lblProf);
        jpanel.remove(txtProf);
        jpanel.remove(lblLogin);
        jpanel.remove(txtLogin);
        jpanel.remove(lblSenha);
        jpanel.remove(txtSenha);
        jpanel.remove(lblAlt);
        jpanel.remove(txtAlt);
        jpanel.remove(lblIMC);
        jpanel.remove(txtIMC);
        jpanel.remove(lblPeso);
        jpanel.remove(txtPeso);
        jpanel.remove(lblIdade);
        jpanel.remove(txtIdade);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == btnLogout){
            WindowLogin telaLogin = new WindowLogin(
                    this.jframe, this.jpanel, this.width, this.height, this.nutricionista);
            this.remComponent();
            jpanel.repaint();
            telaLogin.initComponent();
        }
        else if(event.getSource() == btnVoltar){
            WindowPosLogin telaPosLogin = new WindowPosLogin(
                    this.jframe, this.jpanel, this.width, this.height, this.nutricionista);
            this.remComponent();
            jpanel.repaint();
            telaPosLogin.initList();
            telaPosLogin.initComponent();
        }
        else if(event.getSource() == btnSalvar){
            String nome = txtNome.getText();
            int cpf = Integer.parseInt(txtCpf.getText());
            int rg = Integer.parseInt(txtRg.getText());
            String email = txtEmail.getText();
            String profissao = txtProf.getText();
            String login = txtLogin.getText();
            String senha = txtSenha.getText();
            double altura = Double.parseDouble(txtAlt.getText());
            double peso = Double.parseDouble(txtPeso.getText());
            double imc = Double.parseDouble(txtIMC.getText());
            int idade = Integer.parseInt(txtIdade.getText());

            nutricionista.criarPac(nome,cpf,rg,email,profissao,login,senha,altura,peso,imc,idade);

            WindowAddDie telaAddDie = new WindowAddDie(
                    this.jframe, this.jpanel, this.width, this.height, this.nutricionista);
            this.remComponent();
            jpanel.repaint();
            telaAddDie.initComponent();
        }
    }

    @Override
    public void focusGained(FocusEvent focusEvent){}

    @Override
    public void focusLost(FocusEvent focusEvent) {
        double altura = Double.parseDouble(txtAlt.getText());
        double peso = Double.parseDouble(txtPeso.getText());
        txtIMC.setText(String.valueOf(peso / ((altura)*(altura))));

    }
}
