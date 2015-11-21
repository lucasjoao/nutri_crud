import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class WindowLogin implements ActionListener {
    private JFrame jframe;
    private JPanel jpanel;
    private Nutricionista nutricionista;
    private JLabel lblTitulo, lblLogin, lblSenha;
    private JButton btnCancel, btnLogin;
    private JTextField txtLogin;
    private JPasswordField txtSenha;
    private int width, height;

    WindowLogin(){}

    WindowLogin(JFrame jframe, JPanel jpanel, int width, int height, Nutricionista nutricionista){
        this.jframe = jframe;
        jframe.setTitle("Login");
        jframe.setSize(width, height);
        jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);

        this.jpanel = jpanel;
        jpanel.setSize(width,height);
        jpanel.setLayout(null);

        jframe.setContentPane(jpanel);

        this.nutricionista = nutricionista;
        this.width = width;
        this.height = height;
    }

    public void initComponent(){
        //make title lbl
        this.lblTitulo = new JLabel("Login");
        lblTitulo.setSize(width/5, height/10);
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(24f));
        lblTitulo.setLocation(((width - lblTitulo.getWidth())/2), height/20);
        jpanel.add(lblTitulo);

        //make login lbl
        this.lblLogin = new JLabel("Login:");
        lblLogin.setSize(width/5, height/20);
        lblLogin.setLocation(width/5,height/4);
        jpanel.add(lblLogin);

        //make login field
        this.txtLogin = new JTextField();
        txtLogin.setSize(width/3,height/25);
        txtLogin.setLocation((width/3 + width/20),height/4);
        jpanel.add(txtLogin);

        //make password lbl
        this.lblSenha = new JLabel("Senha:");
        lblSenha.setSize(width/5, height/20);
        lblSenha.setLocation(width/5,(height/4 + height/20));
        jpanel.add(lblSenha);

        //make password field
        this.txtSenha = new JPasswordField(10);
        txtSenha.setSize(width/3,height/25);
        txtSenha.setLocation((width/3 + width/20),(height/4 + height/20));
        jpanel.add(txtSenha);

        //make login btn
        this.btnLogin = new JButton("Logar");
        btnLogin.setSize(width/4, height/20);
        btnLogin.setLocation(width /2 - btnLogin.getWidth(), 4 * height/5);
        btnLogin.addActionListener(this);
        jpanel.add(btnLogin);

        //make cancel btn
        this.btnCancel = new JButton("Cancelar");
        btnCancel.setSize(width/4, height/20);
        btnCancel.setLocation(width /2 , 4 * height/5);
        btnCancel.addActionListener(this);
        jpanel.add(btnCancel);
    }

    public void remComponent(){
        jpanel.remove(lblTitulo);
        jpanel.remove(lblLogin);
        jpanel.remove(lblSenha);
        jpanel.remove(txtLogin);
        jpanel.remove(txtSenha);
        jpanel.remove(btnCancel);
        jpanel.remove(btnLogin);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btnCancel)
            System.exit(1);
        else if (event.getSource() == btnLogin){
            String login = txtLogin.getText();
            char[] senhaMask = txtSenha.getPassword();
            String senha = new String(senhaMask);
            if(nutricionista.logar(login, senha)){
                WindowPosLogin telaPosLogin = new WindowPosLogin(
                        this.jframe, this.jpanel, this.width, this.height, this.nutricionista);
                this.remComponent();
                jpanel.repaint();
                telaPosLogin.initList();
                telaPosLogin.initComponent();
            }
        }
    }
}

