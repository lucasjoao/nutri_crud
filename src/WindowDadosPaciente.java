import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowDadosPaciente implements ActionListener{

    private JFrame jframe;
    private JPanel jpanel;
    private Nutricionista nutricionista;
    private JLabel lblTitulo, lblNomePaciente, lblCpf, lblRg, lblEmail, lblAltura, lblPeso, lblIdade, lblAlergDoencs,
            lblProfissao, lblImc;
    private JLabel lblTtlNomePaciente, lblTtlCpf, lblTtlRg, lblTtlEmail, lblTtlAltura, lblTtlPeso, lblTtlIdade,
            lblTtlAlgDoenca, lblTtlProfissao, lblTtlImc;
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
        this.lblTtlNomePaciente = new JLabel("Nome: ");
        lblTtlNomePaciente.setSize((jpanel.getWidth() - size), size);
        lblTtlNomePaciente.setLocation(40, 56);
        jpanel.add(lblTtlNomePaciente);

        //make lblCpf
        this.lblCpf = new JLabel(Integer.toString(nutricionista.retornaCPFPaciente(nroPac)));
        lblCpf.setSize((jpanel.getWidth() - size), size);
        lblCpf.setForeground(Color.BLUE);
        lblCpf.setLocation(250, 56);
        jpanel.add(lblCpf);

        //make lblCpf rótulo
        this.lblTtlCpf = new JLabel("CPF: ");
        lblTtlCpf.setSize((jpanel.getWidth() - size), size);
        lblTtlCpf.setLocation(210, 56);
        jpanel.add(lblTtlCpf);

        //make lblRg
        this.lblRg = new JLabel(Integer.toString(nutricionista.retornaRGPaciente(nroPac)));
        lblRg.setSize((jpanel.getWidth() - size), size);
        lblRg.setForeground(Color.blue);
        lblRg.setLocation(80,86);
        jpanel.add(lblRg);

        //make lblRg rótulo
        this.lblTtlRg = new JLabel("RG: ");
        lblTtlRg.setSize((jpanel.getWidth() - size), size);
        lblTtlRg.setLocation(40,86);
        jpanel.add(lblTtlRg);

        //make lblEmail
        this.lblEmail = new JLabel(nutricionista.retornaEmailPaciente(nroPac));
        lblEmail.setSize((jpanel.getWidth() - size), size);
        lblEmail.setLocation(250, 86);
        lblEmail.setForeground(Color.blue);
        jpanel.add(lblEmail);

        //make lblEmail rótulo
        this.lblTtlEmail = new JLabel("Email: ");
        lblTtlEmail.setSize((jpanel.getWidth() - size), size);
        lblTtlEmail.setLocation(210, 86);
        jpanel.add(lblTtlEmail);

        //make lblAltura
        this.lblAltura = new JLabel(String.valueOf(nutricionista.retornaAlturaPaciente(nroPac)));
        lblAltura.setSize((jpanel.getWidth() - size), size);
        lblAltura.setLocation(80, 116);
        lblAltura.setForeground(Color.blue);
        jpanel.add(lblAltura);

        //make lblAltura rótulo
        this.lblTtlAltura = new JLabel("Altura: ");
        lblTtlAltura.setSize((jpanel.getWidth() - size), size);
        lblTtlAltura.setLocation(40, 116);
        jpanel.add(lblTtlAltura);

        //make lblPeso
        this.lblPeso = new JLabel(String.valueOf(nutricionista.retornaPesoPaciente(nroPac)));
        lblPeso.setSize((jpanel.getWidth() - size), size);
        lblPeso.setLocation(250, 116);
        lblPeso.setForeground(Color.blue);
        jpanel.add(lblPeso);

        //make lblPeso rótulo
        this.lblTtlPeso = new JLabel("Peso: ");
        lblTtlPeso.setSize((jpanel.getWidth() - size), size);
        lblTtlPeso.setLocation(210, 116);
        jpanel.add(lblTtlPeso);

        //make lblIdade
        this.lblIdade = new JLabel(Integer.toString(nutricionista.retornaIdadePaciente(nroPac)));
        lblIdade.setSize((jpanel.getWidth() - size), size);
        lblIdade.setLocation(80, 146);
        lblIdade.setForeground(Color.blue);
        jpanel.add(lblIdade);

        //make lblIdade rótulo
        this.lblTtlIdade = new JLabel("Idade: ");
        lblTtlIdade.setSize((jpanel.getWidth() - size), size);
        lblTtlIdade.setLocation(40, 146);
        jpanel.add(lblTtlIdade);

        //make lblAlergsDoencs
        this.lblAlergDoencs = new JLabel(nutricionista.retornaDietsAlergsPaciente(nroPac));
        lblAlergDoencs.setSize((jpanel.getWidth() - size), size);
        lblAlergDoencs.setLocation(160, 176);
        lblAlergDoencs.setForeground(Color.blue);
        jpanel.add(lblAlergDoencs);

        //make lblAlergsDoencs rótulo
        this.lblTtlAlgDoenca = new JLabel("Alergias/doenças:");
        lblTtlAlgDoenca.setSize((jpanel.getWidth() - size), size);
        lblTtlAlgDoenca.setLocation(40, 176);
        jpanel.add(lblTtlAlgDoenca);

        //make lblProfissao
        this.lblProfissao = new JLabel(nutricionista.retornaProfissaoPaciente(nroPac));
        lblProfissao.setSize((jpanel.getWidth() - size), size);
        lblProfissao.setLocation(270, 146);
        lblProfissao.setForeground(Color.blue);
        jpanel.add(lblProfissao);

        //make lblProfissao rótulo
        this.lblTtlProfissao = new JLabel("Profissão: ");
        lblTtlProfissao.setSize((jpanel.getWidth() - size), size);
        lblTtlProfissao.setLocation(210, 146);
        jpanel.add(lblTtlProfissao);

        //make lbImc
        this.lblImc = new JLabel(nutricionista.calculaImc(
                nutricionista.retornaAlturaPaciente(nroPac), nutricionista.retornaPesoPaciente(nroPac)));
        lblImc.setSize((jpanel.getWidth() - size), size);
        lblImc.setFont(lblImc.getFont().deriveFont(20f));
        lblImc.setLocation(70,206);
        lblImc.setForeground(Color.RED);
        jpanel.add(lblImc);

        //make lbImc rótulo
        this.lblTtlImc = new JLabel("IMC: ");
        lblTtlImc.setSize((jpanel.getWidth() - size), size);
        lblTtlImc.setLocation(40,206);
        jpanel.add(lblTtlImc);

        //make logout btn
        this.btnLogout = new JButton("sair");
        btnLogout.setSize(72, 24);
        btnLogout.setLocation(jpanel.getWidth() / 4 * 3, 325);
        btnLogout.addActionListener(this);
        jpanel.add(btnLogout);

        //make editar btn
        this.btnEditar = new JButton("Editar");
        btnEditar.setSize(144, 24);
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
        jpanel.remove(lblTtlNomePaciente);
        jpanel.remove(lblTtlRg);
        jpanel.remove(lblTtlCpf);
        jpanel.remove(lblTtlEmail);
        jpanel.remove(lblTtlAltura);
        jpanel.remove(lblTtlPeso);
        jpanel.remove(lblTtlIdade);
        jpanel.remove(lblTtlAlgDoenca);
        jpanel.remove(lblTtlProfissao);
        jpanel.remove(lblTtlImc);
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
        else if(event.getSource() == btnEditar){
            WindowAddPac telaEditarPaciente = new WindowAddPac(
                    this.jframe, this.jpanel, this.width, this.height, this.nutricionista, this.nroPac);
            this.remComponent();
            jpanel.repaint();
            telaEditarPaciente.initComponent();
            telaEditarPaciente.preencherCampos(nutricionista, nroPac);
        }
    }
}

