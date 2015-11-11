import javax.swing.*;

public class WindowPosLogin extends JFrame {

    private JLabel lblProv;
    private JFrame jframe;
    private JPanel jpanel;
    private Nutricionista nutricionista;
    private JScrollPane scrollPane;

    WindowPosLogin(){}

    WindowPosLogin(JFrame jframe, JPanel jpanel, Nutricionista nutricionista){
        this.jframe = jframe;
        jframe.setTitle("Tela pós-login");
        jframe.setSize(400, 400);
        jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);

        this.jpanel = jpanel;
        this.jpanel.setSize(400,400);
        this.jpanel.setLayout(null);

        this.nutricionista = nutricionista;
    }

    public void initList(){
        DefaultListModel dadosLista = new DefaultListModel();
        int qtdPacientes = nutricionista.retornaQuantPacientes(nutricionista);
        for(int posicao = 0 ; posicao <= qtdPacientes; posicao++)
            dadosLista.addElement(nutricionista.retornaPaciente(posicao, nutricionista));

        JList list = new JList(dadosLista);

        this.scrollPane = new JScrollPane(list);
        scrollPane.setBounds(22, 50, 350, 250);
        jpanel.add(scrollPane);
    }

    public void initComponent(){
        //only here because of conflict with scrollpane
        jframe.setContentPane(jpanel);

        this.lblProv = new JLabel("Em construção");
        lblProv.setSize(200, 32);
        lblProv.setFont(lblProv.getFont().deriveFont(24f));
        lblProv.setLocation(((jpanel.getWidth()- lblProv.getWidth())/2), 16);
        jpanel.add(lblProv);
    }

}
