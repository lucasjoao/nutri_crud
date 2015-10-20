import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WindowLogin extends JFrame implements ActionListener {
    private JLabel lblTitulo, lblLogin,	lblSenha;

    private Nutricionista nutricionista;

    private JTextField	txtLogin, txtSenha;

    private JButton btnLogin, btnCancel;

    public void WindowLogin(){
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setTitle("Tela de Login");
        setResizable(false);
        initComponent();
    }

    private void initComponent(){
        lblTitulo = new JLabel("Tela de Login");
        lblTitulo.setSize(260, 32);
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(24f));
        lblTitulo.setLocation((getWidth() / 4) + 10, 16);
        getContentPane().add(lblTitulo);

        int y = 64;
        int spacing =24;
        int size = 18;

        lblLogin = new JLabel("Login:");
        lblLogin.setSize((getWidth()- size), size);
        lblLogin.setLocation(80,120);
        getContentPane().add(lblLogin);

        txtLogin = new JTextField();
        txtLogin.setSize(((getWidth() / 2) - size ), size);
        txtLogin.setLocation(145, 120);
        getContentPane().add(txtLogin);

        y += spacing;

        lblSenha = new JLabel("Senha:");
        lblSenha.setSize((getWidth()- size), size);
        lblSenha.setLocation(78,140);
        getContentPane().add(lblSenha);

        txtSenha = new JTextField();
        txtSenha.setSize(((getWidth() / 2) - size ), size);
        txtSenha.setLocation(145,140);
        getContentPane().add(txtSenha);

        y += spacing;



        btnLogin = new JButton("Logar");
        btnLogin.setSize(96, 24);
        btnLogin.setLocation(getWidth() /2 - btnLogin.getWidth(), 300);
        btnLogin.addActionListener(this);
        getContentPane().add(btnLogin);

        btnCancel = new JButton("Cancelar");
        btnCancel.setSize(96, 24);
        btnCancel.setLocation(getWidth() /2 , 300);
        btnCancel.addActionListener(this);
        getContentPane().add(btnCancel);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btnCancel){
            dispose();
        } else if (event.getSource() == btnLogin){
            String login = txtLogin.getText();
            String senha = txtSenha.getText();
            if(nutricionista.logar(login, senha)==true){
                this.dispose();
                WindowPosLogin telaPosLogin = new WindowPosLogin();
                telaPosLogin.setVisible(true);
            }
        }
    }
}

