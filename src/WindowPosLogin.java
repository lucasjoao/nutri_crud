import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WindowPosLogin extends MouseAdapter {

    private JLabel lblTitulo;
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
        //one list index can be selected:
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addMouseListener(this);

        this.scrollPane = new JScrollPane(list);
        scrollPane.setBounds(22, 50, 350, 250);
        //enable scroll with mouse wheel:
        scrollPane.setWheelScrollingEnabled(true);
        jpanel.add(scrollPane);
    }

    public void initComponent(){
        //only here because of conflict with scrollpane
        jframe.setContentPane(jpanel);

        //make title lbl
        this.lblTitulo = new JLabel("nome_software");
        lblTitulo.setSize(200, 32);
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(24f));
        lblTitulo.setLocation(((jpanel.getWidth()- lblTitulo.getWidth())/2), 16);
        jpanel.add(lblTitulo);
    }

    public void remComponent(){
        jpanel.remove(lblTitulo);
        jpanel.remove(scrollPane);
    }

    @Override
    public void mouseClicked(MouseEvent e){
        if(e.getClickCount() == 2){
            WindowDadosPaciente telaDadosPaciente = new WindowDadosPaciente(
                    this.jframe, this.jpanel, this.nutricionista);
            this.remComponent();
            jpanel.repaint();
            telaDadosPaciente.initComponent();
        }
    }
}
