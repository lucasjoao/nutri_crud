import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

public class WindowAddPac implements ActionListener, FocusListener {

    private List<Paciente> pacsDaNut;
    private JLabel lblTitulo, lblNome, lblCpf, lblRg, lblEmail, lblProf, lblLogin,
            lblSenha, lblAlt, lblPeso, lblIdade, lblTtlImc, lblImc, lblDie;
    private JTextField txtNome, txtCpf, txtRg, txtEmail, txtProf, txtLogin,
            txtSenha, txtAlt, txtPeso, txtIdade;
    private JFrame jframe;
    private JPanel jpanel;
    private Nutricionista nutricionista;
    private int width, height;
    private JButton btnLogout, btnVoltar, btnSalvar;
    private int nroPac;
    private JComboBox addDie;

    WindowAddPac(){}

    WindowAddPac(JFrame jframe, JPanel jpanel, int width, int height, Nutricionista nutricionista){
        this.jframe = jframe;
        jframe.setTitle("Add paciente");
        jframe.setSize(width, height);
        jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);

        this.jpanel = jpanel;
        jpanel.setSize(width, height);
        jpanel.setLayout(null);

        jframe.setContentPane(jpanel);

        this.nutricionista = nutricionista;
        this.pacsDaNut = nutricionista.getPacsDaNut();
        this.width = width;
        this.height = height;
    }

    WindowAddPac(JFrame jframe, JPanel jpanel, int width, int height, Nutricionista nutricionista, int nroPac){
        this.jframe = jframe;
        jframe.setTitle("Editar paciente");
        jframe.setSize(width, height);
        jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);

        this.jpanel = jpanel;
        jpanel.setSize(width, height);
        jpanel.setLayout(null);

        jframe.setContentPane(jpanel);

        this.nutricionista = nutricionista;
        this.pacsDaNut = nutricionista.getPacsDaNut();
        this.width = width;
        this.height = height;
        this.nroPac = nroPac;
    }

    public void initComponent() {
        //make title lbl
        this.lblTitulo = new JLabel("infos paciente");
        lblTitulo.setSize(width/3, height/10);
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(24f));
        lblTitulo.setLocation(((width - lblTitulo.getWidth())/2), height/20);
        jpanel.add(lblTitulo);

        //make lbl name
        this.lblNome = new JLabel("Nome:");
        lblNome.setSize((width - height/22), height/22);
        lblNome.setLocation(width/8, height/6);
        jpanel.add(lblNome);

        //make txt name
        this.txtNome = new JTextField();
        txtNome.setSize(((width / 2) - height/22), height/22);
        txtNome.setLocation(width/3, height/6);
        jpanel.add(txtNome);

        //make lbl cpf
        this.lblCpf = new JLabel("CPF: (int)");
        lblCpf.setSize((width - height/22), height/22);
        lblCpf.setLocation(width/8, (height/6 + height/22));
        jpanel.add(lblCpf);

        //make txt cpf
        this.txtCpf = new JTextField();
        txtCpf.setSize(((width / 2) - height/22 ), height/22);
        txtCpf.setLocation(width/3, (height/6 + height/22));
        jpanel.add(txtCpf);

        //make lbl rg
        this.lblRg = new JLabel("RG: (int)");
        lblRg.setSize((width - height/22), height/22);
        lblRg.setLocation(width/8, (height/6 + 2*height/22));
        jpanel.add(lblRg);

        //make txt rg
        this.txtRg = new JTextField();
        txtRg.setSize(((width / 2) - height/22 ), height/22);
        txtRg.setLocation(width/3, (height/6 + 2*height/22));
        jpanel.add(txtRg);

        //make lbl email
        this.lblEmail = new JLabel("E-mail:");
        lblEmail.setSize((width - height/22), height/22);
        lblEmail.setLocation(width/8, (height/6 + 3*height/22));
        jpanel.add(lblEmail);

        //make txt email
        this.txtEmail = new JTextField();
        txtEmail.setSize(((width / 2) - height/22 ), height/22);
        txtEmail.setLocation(width/3, (height/6 + 3*height/22));
        jpanel.add(txtEmail);

        //make lbl job
        this.lblProf = new JLabel("Profissão:");
        lblProf.setSize((width - height/22), height/22);
        lblProf.setLocation(width/8, (height/6 + 4*height/22));
        jpanel.add(lblProf);

        //make txt job
        this.txtProf = new JTextField();
        txtProf.setSize(((width / 2) - height/22 ), height/22);
        txtProf.setLocation(width/3, (height/6 + 4*height/22));
        jpanel.add(txtProf);

        //make lbl login
        this.lblLogin = new JLabel("Login:");
        lblLogin.setSize((width - height/22), height/22);
        lblLogin.setLocation(width/8, (height/6 + 5*height/22));
        jpanel.add(lblLogin);

        //make txt login
        this.txtLogin = new JTextField();
        txtLogin.setSize(((width / 2) - height/22 ), height/22);
        txtLogin.setLocation(width/3, (height/6 + 5*height/22));
        jpanel.add(txtLogin);

        //make lbl password
        this.lblSenha = new JLabel("Senha:");
        lblSenha.setSize((width - height/22), height/22);
        lblSenha.setLocation(width/8, (height/6 + 6*height/22));
        jpanel.add(lblSenha);

        //make txt password
        this.txtSenha = new JTextField();
        txtSenha.setSize(((width / 2) - height/22 ), height/22);
        txtSenha.setLocation(width/3, (height/6 + 6*height/22));
        jpanel.add(txtSenha);

        //make lbl height
        this.lblAlt = new JLabel("Alt, m: (doub)");
        lblAlt.setSize((width - height/22), height/22);
        lblAlt.setLocation(width/8, (height/6 + 7*height/22));
        jpanel.add(lblAlt);

        //make txt height
        this.txtAlt = new JTextField();
        txtAlt.setSize(((width / 2) - height/22 ), height/22);
        txtAlt.setLocation(width/3, (height/6 + 7*height/22));
        txtAlt.addFocusListener(this);
        jpanel.add(txtAlt);

        //make lbl size
        this.lblPeso = new JLabel("Peso, kg: (doub)");
        lblPeso.setSize((width - height/22), height/22);
        lblPeso.setLocation(width/8, (height/6 + 8*height/22));
        jpanel.add(lblPeso);

        //make txt size
        this.txtPeso = new JTextField();
        txtPeso.setSize(((width / 2) - height/22), height/22);
        txtPeso.setLocation(width/3, (height/6 + 8*height/22));
        txtPeso.addFocusListener(this);
        jpanel.add(txtPeso);

        //make lbl imc
        this.lblTtlImc = new JLabel("IMC: (doub)");
        lblTtlImc.setSize((width - height/22), height/22);
        lblTtlImc.setLocation(width/8, (height/6 + 9*height/22));
        jpanel.add(lblTtlImc);

        //make lbl imc
        this.lblImc = new JLabel();
        lblImc.setSize(((width / 2) - height/22 ), height/22);
        lblImc.setLocation(width/3, (height/6 + 9*height/22));
        jpanel.add(lblImc);

        //make lbl age
        this.lblIdade = new JLabel("Idade: (int)");
        lblIdade.setSize((width - height/22), height/22);
        lblIdade.setLocation(width/8, (height/6 + 10*height/22));
        jpanel.add(lblIdade);

        //make txt age
        this.txtIdade = new JTextField();
        txtIdade.setSize(((width / 2) - height/22 ), height/22);
        txtIdade.setLocation(width/3, (height/6 + 10*height/22));
        jpanel.add(txtIdade);

        //make logout btn
        this.btnLogout = new JButton("sair");
        btnLogout.setSize(width/6, height/20);
        btnLogout.setLocation(3*width / 4, 6*height/7);
        btnLogout.addActionListener(this);
        jpanel.add(btnLogout);

        //make voltar btn
        this.btnVoltar = new JButton("<---");
        btnVoltar.setSize(width/6, height/20);
        btnVoltar.setLocation(width / 10, 6*height/7);
        btnVoltar.addActionListener(this);
        jpanel.add(btnVoltar);

        //make salvar btn
        this.btnSalvar = new JButton("Salvar");
        btnSalvar.setSize(width/3, height/20);
        btnSalvar.setLocation(((width - btnSalvar.getWidth())/2), 6*height/7);
        btnSalvar.addActionListener(this);
        jpanel.add(btnSalvar);
    }

    public void initCombos(){
        //mk lbl addDie
        this.lblDie = new JLabel("Dieta:");
        lblDie.setSize((width - height/22), height/22);
        lblDie.setLocation(width/8, (height/6 + 11*height/22));
        jpanel.add(lblDie);


        //mk cb addDie
        DefaultComboBoxModel dadosAddDie = new DefaultComboBoxModel();

        for(Dieta dieta : nutricionista.getDiesDaNut())
            dadosAddDie.addElement(dieta.getNome());

        dadosAddDie.setSelectedItem("Dietas");

        this.addDie = new JComboBox(dadosAddDie);
        addDie.setSize(width/3, height/20);
        addDie.setLocation(width/3, (height/6 + 11*height/22));
        addDie.setBackground(Color.WHITE);
        addDie.addActionListener(this);
        jpanel.add(addDie);
    }

    public void preencherCampos(Nutricionista nutricionista, int nroPac){
        txtNome.setText(nutricionista.retornaNomePaciente(nroPac));
        txtCpf.setText(Integer.toString(nutricionista.retornaCPFPaciente(nroPac)));
        txtRg.setText(Integer.toString(nutricionista.retornaRGPaciente(nroPac)));
        txtEmail.setText(nutricionista.retornaEmailPaciente(nroPac));
        txtProf.setText(nutricionista.retornaProfissaoPaciente(nroPac));
        txtLogin.setText(nutricionista.retornaLoginPaciente(nroPac));
        txtSenha.setText(String.valueOf(nutricionista.retornaSenhaPaciente(nroPac)));
        txtAlt.setText(String.valueOf(nutricionista.retornaAlturaPaciente(nroPac)));
        txtPeso.setText(String.valueOf(nutricionista.retornaPesoPaciente(nroPac)));
        txtIdade.setText(Integer.toString(nutricionista.retornaIdadePaciente(nroPac)));
        lblImc.setText(nutricionista.calculaImc(
                nutricionista.retornaAlturaPaciente(nroPac), nutricionista.retornaPesoPaciente(nroPac)));
        addDie.setSelectedItem(nutricionista.retornaDiePaciente(nroPac));
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
        jpanel.remove(lblTtlImc);
        jpanel.remove(lblImc);
        jpanel.remove(lblPeso);
        jpanel.remove(txtPeso);
        jpanel.remove(lblIdade);
        jpanel.remove(txtIdade);
        jpanel.remove(addDie);
        jpanel.remove(lblDie);
    }

    public Dieta dietaDoNome(Object nome){
        Dieta dietaProv = null;
        for(Dieta dieta : nutricionista.getDiesDaNut()) {
            if(nome.equals(dieta.getNome())){
                dietaProv = dieta;
            }
        }
        return dietaProv;
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
        else if(event.getSource() == btnVoltar && jframe.getTitle().equals("Add paciente")){
            WindowListPac telaListPac = new WindowListPac(
                    this.jframe, this.jpanel, this.width, this.height, this.nutricionista);
            this.remComponent();
            jpanel.repaint();
            telaListPac.initList();
            telaListPac.initComponent();
        }
        else if(event.getSource() == btnVoltar && jframe.getTitle().equals("Editar paciente")){
            WindowDadosPaciente telaDadosPaciente = new WindowDadosPaciente(
                    this.jframe, this.jpanel, this.width, this.height, this.nutricionista, nroPac, true);
            this.remComponent();
            jpanel.repaint();
            telaDadosPaciente.initComponent();
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
            int idade = Integer.parseInt(txtIdade.getText());
            Dieta dieta = this.dietaDoNome(addDie.getSelectedItem());


            if (jframe.getTitle().equals("Add paciente")){
                nutricionista.criarPac(nome, cpf, rg, email, profissao, login, senha, altura, peso, idade, dieta);

                WindowListPac telaListPac = new WindowListPac(
                        this.jframe, this.jpanel, this.width, this.height, this.nutricionista);
                this.remComponent();
                jpanel.repaint();
                telaListPac.initList();
                telaListPac.initComponent();

            } else {
                nutricionista.editarPac(nome, cpf, rg, email, profissao, login, senha, altura, peso, idade, dieta, nroPac);

                WindowDadosPaciente telaDadosPaciente = new WindowDadosPaciente(
                        this.jframe, this.jpanel, this.width, this.height, this.nutricionista, nroPac, true);
                this.remComponent();
                jpanel.repaint();
                telaDadosPaciente.initComponent();
            }
        }
    }

    @Override
    public void focusGained(FocusEvent focusEvent){}

    @Override
    public void focusLost(FocusEvent focusEvent) {
        double altura = Double.parseDouble(txtAlt.getText());
        double peso = Double.parseDouble(txtPeso.getText());
        lblImc.setText(nutricionista.calculaImc(altura, peso));

    }
}
