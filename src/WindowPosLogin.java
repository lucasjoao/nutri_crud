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

        JScrollPane scrollPane = new JScrollPane();

        //tentativa de list box
        DefaultListModel lista = new DefaultListModel();
        int qtdPacientes = nutricionista.retornaQuantPacientes(nutricionista);
        for(int posicao = 0 ; posicao <= qtdPacientes; posicao++){
            lista.addElement(nutricionista.retornaPaciente(posicao, nutricionista));
        }
        JList list = new JList();

        list.setModel(lista);
        scrollPane.setViewportView(list);
        scrollPane.setVisible(true);
        scrollPane.setBounds(22, 50, 350, 250);
        jframe.add(scrollPane);

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
