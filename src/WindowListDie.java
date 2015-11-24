import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class WindowListDie extends MouseAdapter implements ActionListener{

    private List<Paciente> pacsDaNut;
    private JLabel lblTitulo;
    private JFrame jframe;
    private JPanel jpanel;
    private Nutricionista nutricionista;
    private JScrollPane scrollPane;
    private JList list;
    private JButton btnLogout, btnAdd, btnVoltar;
    private int width, height;

    WindowListDie(){}

    WindowListDie(JFrame jframe, JPanel jpanel, int width, int height, Nutricionista nutricionista, List<Paciente> pacsDaNut){
        this.jframe = jframe;
        jframe.setTitle("Dietas");
        jframe.setSize(width, height);
        jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);

        this.jpanel = jpanel;
        jpanel.setSize(width, height);
        jpanel.setLayout(null);

        this.nutricionista = nutricionista;
        this.pacsDaNut = pacsDaNut;
        this.width = width;
        this.height = height;
    }

    public void initList(){
        DefaultListModel dadosLista = new DefaultListModel();
        int totalDie = nutricionista.retornaTotalDies();
        for(int posicao = 0 ; posicao < totalDie; posicao++)
            dadosLista.addElement(nutricionista.retornaNomeDie(posicao));

        this.list = new JList(dadosLista);
        //one list index can be selected:
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        if(totalDie != 0)
            list.addMouseListener(this);

        this.scrollPane = new JScrollPane(list);
        scrollPane.setBounds(width/20, height/5, 9*width/10, 3*height/5);
        //enable scroll with mouse wheel:
        scrollPane.setWheelScrollingEnabled(true);
        jpanel.add(scrollPane);
    }

    public void initComponent(){
        //only here because of conflict with scrollpane
        jframe.setContentPane(jpanel);

        //make title lbl
        this.lblTitulo = new JLabel("Dietas");
        lblTitulo.setSize(width/3, height/10);
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(24f));
        lblTitulo.setLocation(((width - lblTitulo.getWidth())/2), height/20);
        jpanel.add(lblTitulo);

        //make logout btn
        this.btnLogout = new JButton("sair");
        btnLogout.setSize(width/6, height/20);
        btnLogout.setLocation(3*width / 4, 6*height/7);
        btnLogout.addActionListener(this);
        jpanel.add(btnLogout);

        //make add btn
        this.btnAdd = new JButton("+ dieta");
        btnAdd.setSize(width/3, height/20);
        btnAdd.setLocation(((width - btnAdd.getWidth())/2), 6*height/7);
        btnAdd.addActionListener(this);
        jpanel.add(btnAdd);

        //make voltar btn
        this.btnVoltar = new JButton("<---");
        btnVoltar.setSize(width/6, height/20);
        btnVoltar.setLocation(width / 10, 6*height/7);
        btnVoltar.addActionListener(this);
        jpanel.add(btnVoltar);
    }

    public void remComponent(){
        jpanel.remove(lblTitulo);
        jpanel.remove(scrollPane);
        jpanel.remove(btnLogout);
        jpanel.remove(btnAdd);
        jpanel.remove(btnVoltar);
    }

    @Override
    public void mouseClicked(MouseEvent e){
        boolean checkVazio = nutricionista.retornaNomeDie(
                list.locationToIndex(e.getPoint())).equals("");
        if(e.getClickCount() == 2 && !checkVazio){
            WindowDadosDie telaDadosDie = new WindowDadosDie(
                    this.jframe, this.jpanel, this.width, this.height, this.nutricionista, this.pacsDaNut,
                    list.locationToIndex(e.getPoint()));
            this.remComponent();
            jpanel.repaint();
            telaDadosDie.initTable();
            telaDadosDie.initComponent();
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == btnLogout){
            WindowLogin telaLogin = new WindowLogin(
                    this.jframe, this.jpanel, this.width, this.height, this.nutricionista, this.pacsDaNut);
            this.remComponent();
            jpanel.repaint();
            telaLogin.initComponent();
        }
        else if(event.getSource() == btnAdd){
            WindowAddDie telaAddDie= new WindowAddDie(
                    this.jframe, this.jpanel, this.width, this.height, this.nutricionista, this.pacsDaNut);
            this.remComponent();
            jpanel.repaint();
            telaAddDie.initTable(telaAddDie.initTableModel());
            telaAddDie.initComponent();
            telaAddDie.initComboCard();
        }
        else if(event.getSource() == btnVoltar){
            WindowPosLogin telaPosLogin = new WindowPosLogin(
                    this.jframe, this.jpanel, this.width, this.height, this.nutricionista, this.pacsDaNut);
            this.remComponent();
            jpanel.repaint();
            telaPosLogin.initComponent();
        }
    }
}
