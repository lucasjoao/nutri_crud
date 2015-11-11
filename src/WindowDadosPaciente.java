import javax.swing.*;
public class WindowDadosPaciente{

    private JFrame jframe;
    private JPanel jpanel;
    private Nutricionista nutricionista;
    private JLabel lblProv;

    WindowDadosPaciente(){}

    WindowDadosPaciente(JFrame jframe, JPanel jpanel, Nutricionista nutricionista){
        this.jframe = jframe;
        jframe.setTitle("Tela de dados do paciente");
        jframe.setSize(400, 400);
        jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);

        this.jpanel = jpanel;
        this.jpanel.setSize(400,400);
        this.jpanel.setLayout(null);

        jframe.setContentPane(jpanel);

        this.nutricionista = nutricionista;
    }

    public void initComponent() {
        lblProv = new JLabel("Em construção");
        lblProv.setSize(200, 32);
        lblProv.setFont(lblProv.getFont().deriveFont(24f));
        lblProv.setLocation(((jpanel.getWidth()- lblProv.getWidth())/2), 16);
        jpanel.add(lblProv);
    }
}

