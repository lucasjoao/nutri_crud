import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class WindowListCard extends MouseAdapter implements ActionListener {

    private List<Paciente> pacsDaNut;
    private JLabel lblTitulo;
    private JFrame jframe;
    private JPanel jpanel;
    private Nutricionista nutricionista;
    private JScrollPane scrollPane;
    private JList list;
    private JButton btnLogout, btnAdd, btnVoltar;
    private int width, height;
    private JLabel lblImg;

    WindowListCard(){}

    WindowListCard(JFrame jframe, JPanel jpanel, int width, int height, Nutricionista nutricionista){
        this.jframe = jframe;
        jframe.setTitle("Nutri+ Cardápios");
        jframe.setSize(width, height);
        jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);

        this.jpanel = jpanel;
        jpanel.setSize(width, height);
        jpanel.setLayout(null);

        this.nutricionista = nutricionista;
        this.pacsDaNut = nutricionista.getPacsDaNut();
        this.width = width;
        this.height = height;
    }

    public void initList(){
        DefaultListModel dadosLista = new DefaultListModel();
        int totalCard = nutricionista.retornaTotalCards();
        for(int posicao = 0 ; posicao < totalCard; posicao++)
            dadosLista.addElement(nutricionista.retornaNomeCard(posicao));

        this.list = new JList(dadosLista);
        //one list index can be selected:
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        if(totalCard != 0)
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
        this.lblTitulo = new JLabel("Cardápios");
        lblTitulo.setSize(width/4, height/4);
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
        this.btnAdd = new JButton("+ cardápio");
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

        //make lbl imagem
        this.lblImg = new JLabel(new ImageIcon("frutinhas.jpg"));
        lblImg.setBounds(0,0,470,470);
        lblImg.setLayout(null);
        jpanel.add(lblImg);
    }

    public void remComponent(){
        jpanel.remove(lblImg);
        jpanel.remove(lblTitulo);
        jpanel.remove(scrollPane);
        jpanel.remove(btnLogout);
        jpanel.remove(btnAdd);
        jpanel.remove(btnVoltar);
    }

    @Override
    public void mouseClicked(MouseEvent e){
        boolean checkVazio = nutricionista.retornaNomeCard(
                list.locationToIndex(e.getPoint())).equals("");
        if(e.getClickCount() == 2 && !checkVazio){
            WindowDadosCard telaDadosCard = new WindowDadosCard(
                    this.jframe, this.jpanel, this.width, this.height, this.nutricionista,
                    list.locationToIndex(e.getPoint()));
            this.remComponent();
            jpanel.repaint();
            telaDadosCard.initTable();
            telaDadosCard.initComponent();
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
            WindowAddCard telaAddCard= new WindowAddCard(
                    this.jframe, this.jpanel, this.width, this.height, this.nutricionista);
            this.remComponent();
            jpanel.repaint();
            telaAddCard.initTable(telaAddCard.initTableModel());
            telaAddCard.initComponent();
            telaAddCard.initCombos();
        }
        else if(event.getSource() == btnVoltar){
            WindowPosLogin telaPosLogin = new WindowPosLogin(
                    this.jframe, this.jpanel, this.width, this.height, this.nutricionista);
            this.remComponent();
            jpanel.repaint();
            telaPosLogin.initComponent();
        }
    }
}
