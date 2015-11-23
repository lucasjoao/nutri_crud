import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WindowPosLogin implements ActionListener {

    private JLabel lblTitulo;
    private JFrame jframe;
    private JPanel jpanel;
    private Nutricionista nutricionista;
    private JButton btnLogout, btnPac, btnAlim, btnCard, btnDie;
    private int width, height;

    WindowPosLogin(){}

    WindowPosLogin(JFrame jframe, JPanel jpanel, int width, int height, Nutricionista nutricionista){
        this.jframe = jframe;
        jframe.setTitle("Pós-login");
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

    public void initComponent(){
        //make title lbl
        this.lblTitulo = new JLabel("Inicio");
        lblTitulo.setSize(width/3, height/10);
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(24f));
        lblTitulo.setLocation(((width - lblTitulo.getWidth())/2), height/20);
        jpanel.add(lblTitulo);

        //make paciente btn
        this.btnPac = new JButton("Pacientes");
        btnPac.setSize(width/3, height/20);
        btnPac.setLocation(((width - btnPac.getWidth())/2), height/4);
        btnPac.addActionListener(this);
        jpanel.add(btnPac);

        //make alimento btn
        this.btnAlim = new JButton("Alimentos");
        btnAlim.setSize(width/3, height/20);
        btnAlim.setLocation(((width - btnAlim.getWidth())/2), (height/4 + height/20));
        btnAlim.addActionListener(this);
        jpanel.add(btnAlim);

        //make cardapio btn
        this.btnCard = new JButton("Cardápios");
        btnCard.setSize(width/3, height/20);
        btnCard.setLocation(((width - btnCard.getWidth())/2), (height/4 + 2*height/20));
        btnCard.addActionListener(this);
        jpanel.add(btnCard);

        //make dieta btn
        this.btnDie = new JButton("Dietas");
        btnDie.setSize(width/3, height/20);
        btnDie.setLocation(((width - btnDie.getWidth())/2), (height/4 + 3*height/20));
        btnDie.addActionListener(this);
        jpanel.add(btnDie);

        //make logout btn
        this.btnLogout = new JButton("sair");
        btnLogout.setSize(width/6, height/20);
        btnLogout.setLocation(3*width / 4, 6*height/7);
        btnLogout.addActionListener(this);
        jpanel.add(btnLogout);
    }

    public void remComponent(){
        jpanel.remove(lblTitulo);
        jpanel.remove(btnLogout);
        jpanel.remove(btnPac);
        jpanel.remove(btnAlim);
        jpanel.remove(btnCard);
        jpanel.remove(btnDie);
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
        else if(event.getSource() == btnPac){
            WindowListPac telaListPac = new WindowListPac(
                    this.jframe, this.jpanel, this.width, this.height, this.nutricionista);
            this.remComponent();
            jpanel.repaint();
            telaListPac.initList();
            telaListPac .initComponent();
        }
        else if(event.getSource() == btnAlim){
            WindowListAli telaListAli = new WindowListAli(
                    this.jframe, this.jpanel, this.width, this.height, this.nutricionista);
            this.remComponent();
            jpanel.repaint();
            telaListAli.initList();
            telaListAli .initComponent();
        }
        else if(event.getSource() == btnCard){
            WindowListCard telaListCard = new WindowListCard(
                    this.jframe, this.jpanel, this.width, this.height, this.nutricionista);
            this.remComponent();
            jpanel.repaint();
            telaListCard.initList();
            telaListCard .initComponent();
        }
    }
}
