import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowDadosPaciente implements ActionListener{

    private JFrame jframe;
    private JPanel jpanel;
    private Nutricionista nutricionista;
    private JLabel lblTitulo,lblNomePaciente, lblCpf, lblRg, lblEmail, lblAltura, lblPeso, lblIdade, lblAlergDoencs, lblProfissao, lblImc;
    private JLabel lblNomePaciente1, lblCpf1, lblRg1, lblEmail1, lblAltura1, lblPeso1, lblIdade1, lblAlergDoencs1, lblProfissao1, lblImc1;
    private JButton btnLogout, btnVoltar, btnEditar;
    private int width, height, nroPac;

    WindowDadosPaciente(){}

    WindowDadosPaciente(JFrame jframe, JPanel jpanel, int width, int height, Nutricionista nutricionista, int nroPac){
        this.jframe = jframe;
        jframe.setTitle("Tela de dados do paciente");
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
        this.nroPac = nroPac;
    }

    public void initComponent() {

        //make  lblTitulo
        this.lblTitulo = new JLabel("Dados do paciente");
        lblTitulo.setSize(230, 48);
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(24f));
        lblTitulo.setLocation(((jpanel.getWidth()- lblTitulo.getWidth())/2),5 );
        jpanel.add(lblTitulo);


        //make lblNome
        int size = 18;
        this.lblNomePaciente = new JLabel(nutricionista.retornaNomePaciente(nroPac));
        lblNomePaciente.setSize((jpanel.getWidth() - size), size);
        lblNomePaciente.setForeground(Color.blue);
        lblNomePaciente.setLocation(80, 56);
        jpanel.add(lblNomePaciente);

        //make lblNome rótulo
        this.lblNomePaciente1 = new JLabel("Nome: ");
        lblNomePaciente1.setSize((jpanel.getWidth() - size), size);
        lblNomePaciente1.setLocation(40, 56);
        jpanel.add(lblNomePaciente1);

        //make lblCpf
        this.lblCpf = new JLabel(Integer.toString(nutricionista.retornaCPFPaciente(nroPac)));
        lblCpf.setSize((jpanel.getWidth() - size), size);
        lblCpf.setForeground(Color.BLUE);
        lblCpf.setLocation(250, 56);
        jpanel.add(lblCpf);

        //make lblCpf rótulo
        this.lblCpf1 = new JLabel("CPF: ");
        lblCpf1.setSize((jpanel.getWidth() - size), size);
        lblCpf1.setLocation(210, 56);
        jpanel.add(lblCpf1);

        //make lblRg
        this.lblRg = new JLabel(Integer.toString(nutricionista.retornaRGPaciente(nroPac)));
        lblRg.setSize((jpanel.getWidth() - size), size);
        lblRg.setForeground(Color.blue);
        lblRg.setLocation(80,86);
        jpanel.add(lblRg);

        //make lblRg rótulo
        this.lblRg1 = new JLabel("RG: ");
        lblRg1.setSize((jpanel.getWidth() - size), size);
        lblRg1.setLocation(40,86);
        jpanel.add(lblRg1);

        //make lblEmail
        this.lblEmail = new JLabel(nutricionista.retornaEmailPaciente(nroPac));
        lblEmail.setSize((jpanel.getWidth() - size), size);
        lblEmail.setLocation(250, 86);
        lblEmail.setForeground(Color.blue);
        jpanel.add(lblEmail);

        //make lblEmail rótulo
        this.lblEmail1 = new JLabel("Email: ");
        lblEmail1.setSize((jpanel.getWidth() - size), size);
        lblEmail1.setLocation(210, 86);
        jpanel.add(lblEmail1);

        //make lblAltura
        this.lblAltura = new JLabel(String.valueOf(nutricionista.retornaAlturaPaciente(nroPac)));
        lblAltura.setSize((jpanel.getWidth() - size), size);
        lblAltura.setLocation(80, 116);
        lblAltura.setForeground(Color.blue);
        jpanel.add(lblAltura);

        //make lblAltura rótulo
        this.lblAltura1 = new JLabel("Altura: ");
        lblAltura1.setSize((jpanel.getWidth() - size), size);
        lblAltura1.setLocation(40, 116);
        jpanel.add(lblAltura1);

        //make lblPeso
        this.lblPeso = new JLabel(String.valueOf(nutricionista.retornaPesoPaciente(nroPac)));
        lblPeso.setSize((jpanel.getWidth() - size), size);
        lblPeso.setLocation(250, 116);
        lblPeso.setForeground(Color.blue);
        jpanel.add(lblPeso);

        //make lblPeso rótulo
        this.lblPeso1 = new JLabel("Peso: ");
        lblPeso1.setSize((jpanel.getWidth() - size), size);
        lblPeso1.setLocation(210, 116);
        jpanel.add(lblPeso1);

        //make lblIdade
        this.lblIdade = new JLabel(Integer.toString(nutricionista.retornaIdadePaciente(nroPac)));
        lblIdade.setSize((jpanel.getWidth() - size), size);
        lblIdade.setLocation(80, 146);
        lblIdade.setForeground(Color.blue);
        jpanel.add(lblIdade);

        //make lblIdade rótulo
        this.lblIdade1 = new JLabel("Idade: ");
        lblIdade1.setSize((jpanel.getWidth() - size), size);
        lblIdade1.setLocation(40, 146);
        jpanel.add(lblIdade1);

        //make lblAlergsDoencs
        this.lblAlergDoencs = new JLabel(nutricionista.retornaDietsAlergsPaciente(nroPac));
        lblAlergDoencs.setSize((jpanel.getWidth() - size), size);
        lblAlergDoencs.setLocation(160, 176);
        lblAlergDoencs.setForeground(Color.blue);
        jpanel.add(lblAlergDoencs);

        //make lblAlergsDoencs rótulo
        this.lblAlergDoencs1 = new JLabel("Alergias/doenças:");
        lblAlergDoencs1.setSize((jpanel.getWidth() - size), size);
        lblAlergDoencs1.setLocation(40, 176);
        jpanel.add(lblAlergDoencs1);

        //make lblProfissao
        this.lblProfissao = new JLabel(nutricionista.retornaProfissaoPaciente(nroPac));
        lblProfissao.setSize((jpanel.getWidth() - size), size);
        lblProfissao.setLocation(270, 146);
        lblProfissao.setForeground(Color.blue);
        jpanel.add(lblProfissao);

        //make lblProfissao rótulo
        this.lblProfissao1 = new JLabel("Profissão: ");
        lblProfissao1.setSize((jpanel.getWidth() - size), size);
        lblProfissao1.setLocation(210, 146);
        jpanel.add(lblProfissao1);

        //make lbImc
        this.lblImc = new JLabel((nutricionista.calculaImc(nroPac)));
        lblImc.setSize((jpanel.getWidth() - size), size);
        lblImc.setFont(lblImc.getFont().deriveFont(20f));
        lblImc.setLocation(70,206);
        lblImc.setForeground(Color.RED);
        jpanel.add(lblImc);

        //make lbImc rótulo
        this.lblImc1 = new JLabel("IMC: ");
        lblImc1.setSize((jpanel.getWidth() - size), size);
        lblImc1.setLocation(40,206);
        jpanel.add(lblImc1);

        //make logout btn
        this.btnLogout = new JButton("sair");
        btnLogout.setSize(72, 24);
        btnLogout.setLocation(jpanel.getWidth() / 4 * 3, 325);
        btnLogout.addActionListener(this);
        jpanel.add(btnLogout);

        //make editar btn
        this.btnEditar = new JButton("Editar");
        btnEditar.setSize(72, 24);
        btnEditar.setLocation(((jpanel.getWidth() - btnEditar.getWidth())/2), 325);
        btnEditar.addActionListener(this);
        jpanel.add(btnEditar);


        //make voltar btn
        this.btnVoltar = new JButton("<---");
        btnVoltar.setSize(72, 24);
        btnVoltar.setLocation(jpanel.getWidth() / 12, 325);
        btnVoltar.addActionListener(this);
        jpanel.add(btnVoltar);
    }

    public void remComponent(){
        jpanel.remove(lblTitulo);
        jpanel.remove(lblNomePaciente);
        jpanel.remove(lblRg);
        jpanel.remove(lblCpf);
        jpanel.remove(lblEmail);
        jpanel.remove(btnLogout);
        jpanel.remove(btnVoltar);
        jpanel.remove(lblAltura);
        jpanel.remove(lblPeso);
        jpanel.remove(lblIdade);
        jpanel.remove(lblAlergDoencs);
        jpanel.remove(lblProfissao);
        jpanel.remove(lblImc);
        jpanel.remove(btnEditar);
        jpanel.remove(lblNomePaciente1);
        jpanel.remove(lblRg1);
        jpanel.remove(lblCpf1);
        jpanel.remove(lblEmail1);
        jpanel.remove(lblAltura1);
        jpanel.remove(lblPeso1);
        jpanel.remove(lblIdade1);
        jpanel.remove(lblAlergDoencs1);
        jpanel.remove(lblProfissao1);
        jpanel.remove(lblImc1);
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
        } else if(event.getSource() == btnEditar){
            WindowAddPac telaEditarPaciente = new WindowAddPac(this.jframe, this.jpanel, this.width, this.height, this.nutricionista, this.nroPac);
            this.remComponent();
            jpanel.repaint();
            telaEditarPaciente.initComponent();
            telaEditarPaciente.preencherCampos(nutricionista, nroPac);
        }
    }
}

