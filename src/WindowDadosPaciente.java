import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowDadosPaciente implements ActionListener{

    private JFrame jframe;
    private JPanel jpanel;
    private Nutricionista nutricionista;
    private JLabel lblTitulo;
    private JButton btnLogout;

    WindowDadosPaciente(){}

    WindowDadosPaciente(JFrame jframe, JPanel jpanel, Nutricionista nutricionista){
        this.jframe = jframe;
        jframe.setTitle("Tela de dados do paciente");
        jframe.setSize(400, 400);
        jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);

        this.jpanel = jpanel;
        this.jpanel.setSize(400, 400);
        this.jpanel.setLayout(null);

        jframe.setContentPane(jpanel);

        this.nutricionista = nutricionista;
    }

    public void initComponent() {
        //make title lbl
        this.lblTitulo = new JLabel("nome_paciente");
        lblTitulo.setSize(200, 32);
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(24f));
        lblTitulo.setLocation(((jpanel.getWidth()- lblTitulo.getWidth())/2), 16);
        jpanel.add(lblTitulo);

        //make logout btn
        this.btnLogout = new JButton("Exit");
        btnLogout.setSize(72, 24);
        btnLogout.setLocation(jpanel.getWidth() / 4 * 3, 325);
        btnLogout.addActionListener(this);
        jpanel.add(btnLogout);
    }

    public void remComponent(){
        jpanel.remove(lblTitulo);
        jpanel.remove(btnLogout);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btnLogout){
            WindowLogin telaLogin = new WindowLogin(this.jframe, this.jpanel, this.nutricionista);
            this.remComponent();
            jpanel.repaint();
            telaLogin.initComponent();
        }
    }
}
