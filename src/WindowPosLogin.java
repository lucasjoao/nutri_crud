import javax.swing.*;


public class WindowPosLogin extends JFrame {

    private JLabel lblProv;
    private JFrame jframe;
    private JPanel jpanel;
    private Nutricionista nutricionista;

    WindowPosLogin(){}

    WindowPosLogin(JFrame jframe, JPanel jpanel, Nutricionista nutricionista){
        this.jframe = jframe;
        jframe.setTitle("Tela pós-login");
        jframe.setSize(400, 400);
        jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);

        this.jpanel = jpanel;

        jframe.setContentPane(jpanel);

        this.jpanel.setSize(400,400);
        this.jpanel.setLayout(null);

        this.nutricionista = nutricionista;

    }

    public void initComponent(){
        this.lblProv = new JLabel("Em construção");
        lblProv.setSize(200, 32);
        lblProv.setFont(lblProv.getFont().deriveFont(24f));
        lblProv.setLocation(((jpanel.getWidth()- lblProv.getWidth())/2), 16);
        jpanel.add(lblProv);
    }

}
