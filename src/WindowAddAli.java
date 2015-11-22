import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class WindowAddAli implements ActionListener {

    private JLabel lblTitulo, lblNomeAli, lblQuant, lblClrs, lblPeso;
    private JTextField txtNomeAli, txtQuant, txtClrs, txtPeso;
    private JFrame jframe;
    private JPanel jpanel;
    private Nutricionista nutricionista;
    private int width, height;
    private JButton btnLogout, btnVoltar, btnSalvar;
    private int nroPac;

    WindowAddAli(){}

    WindowAddAli(JFrame jframe, JPanel jpanel, int width, int height, Nutricionista nutricionista){
        this.jframe = jframe;
        jframe.setTitle("Add alimento");
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

    WindowAddAli(JFrame jframe, JPanel jpanel, int width, int height, Nutricionista nutricionista, int nroPac){
        this.jframe = jframe;
        jframe.setTitle("Editar alimento");
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
        //make title lbl
        this.lblTitulo = new JLabel("infos alimento");
        lblTitulo.setSize(width/3, height/10);
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(24f));
        lblTitulo.setLocation(((width - lblTitulo.getWidth())/2), height/20);
        jpanel.add(lblTitulo);

        //make lbl name
        this.lblNomeAli = new JLabel("Nome:");
        lblNomeAli.setSize((width - height/22), height/22);
        lblNomeAli.setLocation(width/8, height/6);
        jpanel.add(lblNomeAli);

        //make txt name
        this.txtNomeAli = new JTextField();
        txtNomeAli.setSize(((width / 2) - height/22), height/22);
        txtNomeAli.setLocation(width/3, height/6);
        jpanel.add(txtNomeAli);

        //make lbl count
        this.lblQuant = new JLabel("Quantidade: (string)");
        lblQuant.setSize((width - height/22), height/22);
        lblQuant.setLocation(width/8, (height/6 + height/22));
        jpanel.add(lblQuant);

        //make txt count
        this.txtQuant = new JTextField();
        txtQuant.setSize(((width / 2) - height/22 ), height/22);
        txtQuant.setLocation(width/3, (height/6 + height/22));
        jpanel.add(txtQuant);

        //make lbl size
        this.lblPeso = new JLabel("Peso: (double)");
        lblPeso.setSize((width - height/22), height/22);
        lblPeso.setLocation(width/8, (height/6 + 2*height/22));
        jpanel.add(lblPeso);

        //make txt size
        this.txtPeso = new JTextField();
        txtPeso.setSize(((width / 2) - height / 22), height / 22);
        txtPeso.setLocation(width / 3, (height / 6 + 2 * height / 22));
        jpanel.add(txtPeso);

        //make lbl calories
        this.lblClrs = new JLabel("Calorias: (double)");
        lblClrs.setSize((width - height/22), height/22);
        lblClrs.setLocation(width/8, (height/6 + 3*height/22));
        jpanel.add(lblClrs);

        //make txt calories
        this.txtClrs = new JTextField();
        txtClrs.setSize(((width / 2) - height / 22), height / 22);
        txtClrs.setLocation(width / 3, (height / 6 + 3 * height / 22));
        jpanel.add(txtClrs);

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

    public void preencherCampos(Nutricionista nutricionista, int nroPac){
        txtNomeAli.setText(nutricionista.retornaNomeAli(nroPac));
        txtQuant.setText(nutricionista.retornaQuantAli(nroPac));
        txtClrs.setText(String.valueOf(nutricionista.retornaClrsAli(nroPac)));
        txtPeso.setText(String.valueOf(nutricionista.retornaPesoAli(nroPac)));
    }

    public void remComponent(){
        jpanel.remove(lblTitulo);
        jpanel.remove(btnLogout);
        jpanel.remove(btnVoltar);
        jpanel.remove(btnSalvar);
        jpanel.remove(lblNomeAli);
        jpanel.remove(txtNomeAli);
        jpanel.remove(lblQuant);
        jpanel.remove(txtQuant);
        jpanel.remove(lblPeso);
        jpanel.remove(txtPeso);
        jpanel.remove(txtClrs);
        jpanel.remove(lblClrs);
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
        else if(event.getSource() == btnVoltar && jframe.getTitle().equals("Add alimento")){
            WindowListAli telaListAli = new WindowListAli(
                    this.jframe, this.jpanel, this.width, this.height, this.nutricionista);
            this.remComponent();
            jpanel.repaint();
            telaListAli.initList();
            telaListAli.initComponent();
        }
        else if(event.getSource() == btnVoltar && jframe.getTitle().equals("Editar alimento")){
            WindowDadosAli telaDadosAli = new WindowDadosAli(
                    this.jframe, this.jpanel, this.width, this.height, this.nutricionista, nroPac);
            this.remComponent();
            jpanel.repaint();
            telaDadosAli.initComponent();
        }
        else if(event.getSource() == btnSalvar){
            String nome = txtNomeAli.getText();
            String quant = txtQuant.getText();
            double calrs = Double.parseDouble(txtClrs.getText());
            double peso = Double.parseDouble(txtPeso.getText());

            if (jframe.getTitle().equals("Add alimento")){
                nutricionista.criarAli(nome, quant, peso, calrs);

                WindowListAli telaListAli = new WindowListAli(
                        this.jframe, this.jpanel, this.width, this.height, this.nutricionista);
                this.remComponent();
                jpanel.repaint();
                telaListAli.initList();
                telaListAli.initComponent();
            } else {
                nutricionista.editarAli(nome, quant, peso, calrs, nroPac);

                WindowDadosAli telaDadosAli = new WindowDadosAli(
                        this.jframe, this.jpanel, this.width, this.height, this.nutricionista, nroPac);
                this.remComponent();
                jpanel.repaint();
                telaDadosAli.initComponent();
            }
        }
    }
}
