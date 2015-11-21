import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WindowPosLogin extends MouseAdapter implements ActionListener {

    private JLabel lblTitulo;
    private JFrame jframe;
    private JPanel jpanel;
    private Nutricionista nutricionista;
    private JScrollPane scrollPane;
    private JList list;
    private JButton btnLogout, btnAdd;
    private int width, height;

    WindowPosLogin(){}

    WindowPosLogin(JFrame jframe, JPanel jpanel, int width, int height, Nutricionista nutricionista){
        this.jframe = jframe;
        jframe.setTitle("Tela pós-login");
        jframe.setSize(width, height);
        jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);

        this.jpanel = jpanel;
        jpanel.setSize(width, height);
        jpanel.setLayout(null);

        this.nutricionista = nutricionista;
        this.width = width;
        this.height = height;
    }

    public void initList(){
        DefaultListModel dadosLista = new DefaultListModel();
        int totalPacientes = nutricionista.retornaTotalPacientes();
        for(int posicao = 0 ; posicao <= totalPacientes; posicao++)
            dadosLista.addElement(nutricionista.retornaNomePaciente(posicao));

        this.list = new JList(dadosLista);
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
        this.lblTitulo = new JLabel("Pacientes");
        lblTitulo.setSize(200, 32);
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(24f));
        lblTitulo.setLocation(((jpanel.getWidth()- lblTitulo.getWidth())/2), 16);
        jpanel.add(lblTitulo);

        //make logout btn
        this.btnLogout = new JButton("sair");
        btnLogout.setSize(72, 24);
        btnLogout.setLocation(jpanel.getWidth() / 4 * 3, 325);
        btnLogout.addActionListener(this);
        jpanel.add(btnLogout);

        //make add btn
        this.btnAdd = new JButton("+ paciente");
        btnAdd.setSize(144, 24);
        btnAdd.setLocation(((jpanel.getWidth() - btnAdd.getWidth())/2), 325);
        btnAdd.addActionListener(this);
        jpanel.add(btnAdd);
    }

    public void remComponent(){
        jpanel.remove(lblTitulo);
        jpanel.remove(scrollPane);
        jpanel.remove(btnLogout);
        jpanel.remove(btnAdd);
    }

    @Override
    public void mouseClicked(MouseEvent e){
        boolean checkVazio = nutricionista.retornaNomePaciente(
                list.locationToIndex(e.getPoint())).equals("");
        if(e.getClickCount() == 2 && !checkVazio){
            WindowDadosPaciente telaDadosPaciente = new WindowDadosPaciente(
                    this.jframe, this.jpanel, this.width, this.height, this.nutricionista,
                    list.locationToIndex(e.getPoint()));
            this.remComponent();
            jpanel.repaint();
            telaDadosPaciente.initComponent();
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == btnLogout){
            WindowLogin telaLogin = new WindowLogin(
                    this.jframe, this.jpanel, this.width, this.height, this.nutricionista);
            this.remComponent();
            jpanel.repaint();
            telaLogin.initComponent();
        }
        else if(event.getSource() == btnAdd){
            WindowAddPac telaAddPac= new WindowAddPac(
                    this.jframe, this.jpanel, this.width, this.height, this.nutricionista);
            this.remComponent();
            jpanel.repaint();
            telaAddPac.initComponent();
        }
    }
}
