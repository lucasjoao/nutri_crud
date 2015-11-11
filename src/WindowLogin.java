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

    WindowLogin(){}

    WindowLogin(JFrame jframe, JPanel jpanel, int width, int height, Nutricionista nutricionista){
        this.jframe = jframe;
        jframe.setTitle("Login");
        jframe.setSize(width, height);
        jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);

        this.jpanel = jpanel;

        jframe.setContentPane(jpanel);

        this.jpanel.setSize(width,height);
        this.jpanel.setLayout(null);

        this.nutricionista = nutricionista;
    }

    public void initComponent(){
        //make title lbl
        this.lblTitulo = new JLabel("Login");
        lblTitulo.setSize(80, 32);
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(24f));
        lblTitulo.setLocation((jpanel.getWidth()-lblTitulo.getWidth())/2, 16);
        jpanel.add(lblTitulo);

        //make login lbl
        int size = 18;
        this.lblLogin = new JLabel("Login:");
        lblLogin.setSize((jpanel.getWidth()- size), size);
        lblLogin.setLocation(80,120);
        jpanel.add(lblLogin);

        //make login field
        this.txtLogin = new JTextField();
        txtLogin.setSize(((jpanel.getWidth() / 2) - size ), size);
        txtLogin.setLocation(145, 120);
        jpanel.add(txtLogin);

        //make password lbl
        this.lblSenha = new JLabel("Senha:");
        lblSenha.setSize((jpanel.getWidth()- size), size);
        lblSenha.setLocation(78,140);
        jpanel.add(lblSenha);

        //make password field
        this.txtSenha = new JPasswordField(10);
        txtSenha.setSize(((jpanel.getWidth() / 2) - size ), size);
        txtSenha.setLocation(145,140);
        jpanel.add(txtSenha);

        //make login btn
        this.btnLogin = new JButton("Logar");
        btnLogin.setSize(96, 24);
        btnLogin.setLocation(jpanel.getWidth() /2 - btnLogin.getWidth(), 300);
        btnLogin.addActionListener(this);
        jpanel.add(btnLogin);

        //make cancel btn
        this.btnCancel = new JButton("Cancelar");
        btnCancel.setSize(96, 24);
        btnCancel.setLocation(jpanel.getWidth() /2 , 300);
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
                WindowPosLogin telaPosLogin = new WindowPosLogin(this.jframe, this.jpanel, this.nutricionista);
                this.remComponent();
                jpanel.repaint();
                telaPosLogin.initList();
                telaPosLogin.initComponent();
            }
        }
    }
}

