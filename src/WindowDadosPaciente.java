import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class WindowDadosPaciente implements ActionListener{

    private List<Paciente> pacsDaNut;
    private JFrame jframe;
    private JPanel jpanel;
    private Nutricionista nutricionista;
    private JLabel lblTitulo, lblNomePaciente, lblCpf, lblRg, lblEmail, lblAltura, lblPeso, lblIdade,
            lblProfissao, lblImc;
    private JLabel lblTtlNomePaciente, lblTtlCpf, lblTtlRg, lblTtlEmail, lblTtlAltura, lblTtlPeso, lblTtlIdade,
            lblTtlProfissao, lblTtlImc, lblTtlDie;
    private JButton btnLogout, btnVoltar, btnEditar, btnExcluir, btnDie;
    private int width, height, nroPac;
    private boolean root;

    WindowDadosPaciente(){}

    WindowDadosPaciente(JFrame jframe, JPanel jpanel, int width, int height, Nutricionista nutricionista,
                        int nroPac, boolean root){
        this.jframe = jframe;
        jframe.setTitle("Dados do paciente");
        jframe.setSize(width, height);
        jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);

        this.jpanel = jpanel;
        jpanel.setSize(width, height);
        jpanel.setLayout(null);

        jframe.setContentPane(jpanel);

        this.nutricionista = nutricionista;
        this.pacsDaNut = nutricionista.getPacsDaNut();
        this.root = root;
        this.width = width;
        this.height = height;
        this.nroPac = nroPac;
    }

    public void initComponent() {
        //make  lblTitulo
        this.lblTitulo = new JLabel("Paciente");
        lblTitulo.setSize(width/3, height/8);
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(24f));
        lblTitulo.setLocation(((width - lblTitulo.getWidth())/2), height/20);
        jpanel.add(lblTitulo);

        //make lblNome
        int size = 18;
        this.lblNomePaciente = new JLabel(nutricionista.retornaNomePaciente(nroPac));
        lblNomePaciente.setSize((jpanel.getWidth() - size), size);
        lblNomePaciente.setForeground(Color.blue);
        lblNomePaciente.setLocation(100, 136);
        jpanel.add(lblNomePaciente);

        //make lblNome rotulo
        this.lblTtlNomePaciente = new JLabel("Nome: ");
        lblTtlNomePaciente.setSize((jpanel.getWidth() - size), size);
        lblTtlNomePaciente.setLocation(width/8, 136);
        jpanel.add(lblTtlNomePaciente);

        //make lblCpf
        this.lblCpf = new JLabel(Integer.toString(nutricionista.retornaCPFPaciente(nroPac)));
        lblCpf.setSize((jpanel.getWidth() - size), size);
        lblCpf.setForeground(Color.BLUE);
        lblCpf.setLocation(250, 136);
        jpanel.add(lblCpf);

        //make lblCpf rotulo
        this.lblTtlCpf = new JLabel("CPF: ");
        lblTtlCpf.setSize((jpanel.getWidth() - size), size);
        lblTtlCpf.setLocation(210, 136);
        jpanel.add(lblTtlCpf);

        //make lblRg
        this.lblRg = new JLabel(Integer.toString(nutricionista.retornaRGPaciente(nroPac)));
        lblRg.setSize((jpanel.getWidth() - size), size);
        lblRg.setForeground(Color.blue);
        lblRg.setLocation(100,166);
        jpanel.add(lblRg);

        //make lblRg rotulo
        this.lblTtlRg = new JLabel("RG: ");
        lblTtlRg.setSize((jpanel.getWidth() - size), size);
        lblTtlRg.setLocation(width/8,166);
        jpanel.add(lblTtlRg);

        //make lblEmail
        this.lblEmail = new JLabel(nutricionista.retornaEmailPaciente(nroPac));
        lblEmail.setSize((jpanel.getWidth() - size), size);
        lblEmail.setLocation(250, 166);
        lblEmail.setForeground(Color.blue);
        jpanel.add(lblEmail);

        //make lblEmail rotulo
        this.lblTtlEmail = new JLabel("Email: ");
        lblTtlEmail.setSize((jpanel.getWidth() - size), size);
        lblTtlEmail.setLocation(210, 166);
        jpanel.add(lblTtlEmail);

        //make lblAltura
        this.lblAltura = new JLabel(String.valueOf(nutricionista.retornaAlturaPaciente(nroPac)));
        lblAltura.setSize((jpanel.getWidth() - size), size);
        lblAltura.setLocation(100, 196);
        lblAltura.setForeground(Color.blue);
        jpanel.add(lblAltura);

        //make lblAltura rotulo
        this.lblTtlAltura = new JLabel("Altura: ");
        lblTtlAltura.setSize((jpanel.getWidth() - size), size);
        lblTtlAltura.setLocation(width/8, 196);
        jpanel.add(lblTtlAltura);

        //make lblPeso
        this.lblPeso = new JLabel(String.valueOf(nutricionista.retornaPesoPaciente(nroPac)));
        lblPeso.setSize((jpanel.getWidth() - size), size);
        lblPeso.setLocation(250, 196);
        lblPeso.setForeground(Color.blue);
        jpanel.add(lblPeso);

        //make lblPeso rotulo
        this.lblTtlPeso = new JLabel("Peso: ");
        lblTtlPeso.setSize((jpanel.getWidth() - size), size);
        lblTtlPeso.setLocation(210, 196);
        jpanel.add(lblTtlPeso);

        //make lblIdade
        this.lblIdade = new JLabel(Integer.toString(nutricionista.retornaIdadePaciente(nroPac)));
        lblIdade.setSize((jpanel.getWidth() - size), size);
        lblIdade.setLocation(100, 226);
        lblIdade.setForeground(Color.blue);
        jpanel.add(lblIdade);

        //make lblIdade rotulo
        this.lblTtlIdade = new JLabel("Idade: ");
        lblTtlIdade.setSize((jpanel.getWidth() - size), size);
        lblTtlIdade.setLocation(width/8, 226);
        jpanel.add(lblTtlIdade);

        //make lblProfissao
        this.lblProfissao = new JLabel(nutricionista.retornaProfissaoPaciente(nroPac));
        lblProfissao.setSize((jpanel.getWidth() - size), size);
        lblProfissao.setLocation(270, 226);
        lblProfissao.setForeground(Color.blue);
        jpanel.add(lblProfissao);

        //make lblProfissao rotulo
        this.lblTtlProfissao = new JLabel("Profissão: ");
        lblTtlProfissao.setSize((jpanel.getWidth() - size), size);
        lblTtlProfissao.setLocation(210, 226);
        jpanel.add(lblTtlProfissao);

        //make lbImc
        this.lblImc = new JLabel(nutricionista.calculaImc(
                nutricionista.retornaAlturaPaciente(nroPac), nutricionista.retornaPesoPaciente(nroPac)));
        lblImc.setSize((jpanel.getWidth() - size), size);
        lblImc.setFont(lblImc.getFont().deriveFont(20f));
        lblImc.setLocation(100,276);
        lblImc.setForeground(Color.RED);
        jpanel.add(lblImc);

        //make lbImc rotulo
        this.lblTtlImc = new JLabel("IMC: ");
        lblTtlImc.setSize((jpanel.getWidth() - size), size);
        lblTtlImc.setLocation(width/8,276);
        jpanel.add(lblTtlImc);

        //mk lblDie rótulo
        this.lblTtlDie = new JLabel("Dieta:");
        lblTtlDie.setSize((width - height/22), height/22);
        lblTtlDie.setLocation(width/8, (height/6 + 11*height/22));
        jpanel.add(lblTtlDie);

        //mk btnDie
        this.btnDie = new JButton(nutricionista.retornaDiePaciente(nroPac));
        btnDie.setSize(width/3, height/20);
        btnDie.setLocation(width / 3, (height / 6 + 11 * height / 22));
        btnDie.addActionListener(this);
        jpanel.add(btnDie);

        //make logout btn
        this.btnLogout = new JButton("sair");
        btnLogout.setSize(width/6, height/20);
        btnLogout.setLocation(3*width / 4, 6*height/7);
        btnLogout.addActionListener(this);
        jpanel.add(btnLogout);

        if(this.root) {
            //make editar btn
            this.btnEditar = new JButton("Editar");
            btnEditar.setSize(width / 5, height / 20);
            btnEditar.setLocation(2 * width / 7, 6 * height / 7);
            btnEditar.addActionListener(this);
            jpanel.add(btnEditar);

            //make voltar btn
            this.btnVoltar = new JButton("<---");
            btnVoltar.setSize(width / 6, height / 20);
            btnVoltar.setLocation(width / 10, 6 * height / 7);
            btnVoltar.addActionListener(this);
            jpanel.add(btnVoltar);

            //make excluir btn
            this.btnExcluir = new JButton("Excluir");
            btnExcluir.setSize(width / 5, height / 20);
            btnExcluir.setLocation(width / 2, 6 * height / 7);
            btnExcluir.addActionListener(this);
            jpanel.add(btnExcluir);
        }
    }

    public void remComponent(){
        jpanel.remove(lblTitulo);
        jpanel.remove(lblNomePaciente);
        jpanel.remove(lblRg);
        jpanel.remove(lblCpf);
        jpanel.remove(lblEmail);
        jpanel.remove(lblAltura);
        jpanel.remove(lblPeso);
        jpanel.remove(lblIdade);
        jpanel.remove(lblProfissao);
        jpanel.remove(lblImc);
        jpanel.remove(lblTtlNomePaciente);
        jpanel.remove(lblTtlRg);
        jpanel.remove(lblTtlCpf);
        jpanel.remove(lblTtlEmail);
        jpanel.remove(lblTtlAltura);
        jpanel.remove(lblTtlPeso);
        jpanel.remove(lblTtlIdade);
        jpanel.remove(lblTtlProfissao);
        jpanel.remove(lblTtlImc);
        jpanel.remove(btnLogout);
        jpanel.remove(lblTtlDie);
        jpanel.remove(btnDie);
        if(this.root) {
            jpanel.remove(btnExcluir);
            jpanel.remove(btnEditar);
            jpanel.remove(btnVoltar);
        }
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
            WindowListPac telaListPac = new WindowListPac(
                    this.jframe, this.jpanel, this.width, this.height, this.nutricionista);
            this.remComponent();
            jpanel.repaint();
            telaListPac.initList();
            telaListPac.initComponent();
        }
        else if(event.getSource() == btnEditar){
            WindowAddPac telaEditarPaciente = new WindowAddPac(
                    this.jframe, this.jpanel, this.width, this.height, this.nutricionista, this.nroPac);
            this.remComponent();
            jpanel.repaint();
            telaEditarPaciente.initComponent();
            telaEditarPaciente.initCombos();
            telaEditarPaciente.preencherCampos(nutricionista, nroPac);
        }
        else if(event.getSource() == btnExcluir){
            String mensagem = "Você deseja mesmo excluir o paciente \n" + nutricionista.retornaNomePaciente(nroPac) + "?";
            int decisao = JOptionPane.showConfirmDialog(null, mensagem, mensagem, JOptionPane.YES_NO_OPTION);

            if(decisao == 0) {
                nutricionista.excluirPac(nroPac);

                WindowListPac telaListPac = new WindowListPac(
                        this.jframe, this.jpanel, this.width, this.height, this.nutricionista);
                this.remComponent();
                jpanel.repaint();
                telaListPac.initList();
                telaListPac.initComponent();
            }
        }
        else if(event.getSource() == btnDie){
            int nroDieta = 0;

            for(Dieta dieta : nutricionista.getDiesDaNut()) {
                if (dieta.getNome().equals(nutricionista.retornaDiePaciente(nroPac))) {
                    nroDieta = nutricionista.getDiesDaNut().indexOf(dieta);
                }
            }

            if(this.root){
                WindowDadosDie telaDadosDie = new WindowDadosDie(
                        this.jframe, this.jpanel, this.width, this.height, this.nutricionista,
                        nroDieta, true);
                this.remComponent();
                jpanel.repaint();
                telaDadosDie.initTable();
                telaDadosDie.initComponent();
            }
            else {
                WindowDadosDie telaDadosDie = new WindowDadosDie(
                        this.jframe, this.jpanel, this.width, this.height, this.nutricionista,
                        nroDieta, false);
                this.remComponent();
                jpanel.repaint();
                telaDadosDie.initTable();
                telaDadosDie.initComponent();
            }
        }
    }
}

