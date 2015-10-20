import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WindowPosLogin extends JFrame {

    private JLabel lblQualquerCoisa;

    public WindowPosLogin(){
        setSize(800, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setTitle("Tela Pos Login");
        setResizable(false);
        initComponent();
    }

    private void initComponent(){

        lblQualquerCoisa = new JLabel("asjdhajhasjdhasjhdkajshdkajshdka");
        lblQualquerCoisa.setSize(260, 32);
        lblQualquerCoisa.setFont(lblQualquerCoisa.getFont().deriveFont(24f));
        lblQualquerCoisa.setLocation(((getWidth()- lblQualquerCoisa.getWidth()) / 2), 16);
        getContentPane().add(lblQualquerCoisa);

    }

}
