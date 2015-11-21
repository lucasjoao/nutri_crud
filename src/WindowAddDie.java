import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowAddDie implements ActionListener {
    private JLabel lblTitulo;
    private JFrame jframe;
    private JPanel jpanel;
    private Nutricionista nutricionista;
    private int width, height;
    private JButton btnLogout, btnVoltar, btnSalvar;

    WindowAddDie(){}

    WindowAddDie(JFrame jframe, JPanel jpanel, int width, int height, Nutricionista nutricionista){
        this.jframe = jframe;
        jframe.setTitle("Add paciente (2/2)");
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
        this.lblTitulo = new JLabel("infos dieta");
        lblTitulo.setSize(width/3, height/10);
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(24f));
        lblTitulo.setLocation(((width - lblTitulo.getWidth())/2), height/20);
        jpanel.add(lblTitulo);

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

    public void remComponent(){
        jpanel.remove(lblTitulo);
        jpanel.remove(btnLogout);
        jpanel.remove(btnVoltar);
        jpanel.remove(btnSalvar);
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
            WindowAddPac telaAddPac = new WindowAddPac(
                    this.jframe, this.jpanel, this.width, this.height, this.nutricionista);
            this.remComponent();
            jpanel.repaint();
            telaAddPac.initComponent();
        }
        else if(event.getSource() == btnSalvar){
        }
    }
}
