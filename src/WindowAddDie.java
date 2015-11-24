import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

public class WindowAddDie extends MouseAdapter implements ActionListener {
    private JLabel lblTitulo, lblNomeCard, lblClrsTotal, lblClrs, lblInstr, lblInstrDel;
    private JFrame jframe;
    private JPanel jpanel;
    private Nutricionista nutricionista;
    private int width, height;
    private JButton btnLogout, btnVoltar, btnSalvar;
    private DefaultTableModel dadosTable;
    private JScrollPane scrollPane;
    private JTable table;
    private JComboBox add;
    private JTextField txtNomeCard;
    private int nroDie;
    private int nroLinha = 0;
    private Object itemSelecionado;

    WindowAddDie(){}

    WindowAddDie(JFrame jframe, JPanel jpanel, int width, int height, Nutricionista nutricionista){
        this.jframe = jframe;
        jframe.setTitle("Add dieta");
        jframe.setSize(width, height);
        jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);

        this.jpanel = jpanel;
        jpanel.setSize(width, height);
        jpanel.setLayout(null);

        jframe.setContentPane(jpanel);

        this.nutricionista = nutricionista;
        this.width = width;
        this.height = height;
    }

    public DefaultTableModel initTableModel(){
        this.dadosTable = new DefaultTableModel();

        dadosTable.addColumn("Domingo");
        dadosTable.addColumn("Segunda");
        dadosTable.addColumn("Terça");
        dadosTable.addColumn("Quarta");
        dadosTable.addColumn("Quinta");
        dadosTable.addColumn("Sexta");
        dadosTable.addColumn("Sábado");

        return dadosTable;
    }

    public void initTable(DefaultTableModel dadosTable){
        //mk alignment
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        //mk table
        this.table = new JTable(dadosTable) {
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };

        table.setShowGrid(false);
        table.setShowHorizontalLines(false);
        table.setShowVerticalLines(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        table.addMouseListener(this);

        for(int i = 0; i < table.getColumnCount(); i++)
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);

        //mk scrollpane
        this.scrollPane = new JScrollPane(table);
        scrollPane.setBounds(width/20, height/6, 9*width/10, height/3);
        //enable scroll with mouse wheel:
        scrollPane.setWheelScrollingEnabled(true);
        scrollPane.getViewport().setBackground(Color.WHITE);
        jpanel.add(scrollPane);
    }

    public void initComboCard(){
        //mk cb add
        DefaultComboBoxModel dadosAddCard = new DefaultComboBoxModel();

        for(Cardapio cardapio : nutricionista.getCardsDaNut())
            dadosAddCard.addElement(cardapio.getNome());

        dadosAddCard.setSelectedItem("Cardápios");

        this.add = new JComboBox(dadosAddCard);
        add.setSize(width/3, height/20);
        add.setLocation(width/10, 6 * height/10);
        add.setBackground(Color.WHITE);
        add.addActionListener(this);
        jpanel.add(add);

        //mk lbl
        this.lblInstr = new JLabel("Add o cardápio:");
        lblInstr.setSize(width/3, height/20);
        lblInstr.setLocation(width/10, 11*height/20);
        jpanel.add(lblInstr);
    }

    public void initComboDia(){
        //mk cb add
        DefaultComboBoxModel dadosAddDia = new DefaultComboBoxModel();

        dadosAddDia.addElement("Domingo");
        dadosAddDia.addElement("Segunda");
        dadosAddDia.addElement("Terça");
        dadosAddDia.addElement("Quarta");
        dadosAddDia.addElement("Quinta");
        dadosAddDia.addElement("Sexta");
        dadosAddDia.addElement("Sábado");

        dadosAddDia.setSelectedItem("Dias");

        this.add = new JComboBox(dadosAddDia);
        add.setSize(width/3, height/20);
        add.setLocation(2*width/4, 6 * height/10);
        add.setBackground(Color.WHITE);
        add.addActionListener(this);
        jpanel.add(add);

        //mk lbl
        this.lblInstr = new JLabel("Add o dia:");
        lblInstr.setSize(width/3, height/20);
        lblInstr.setLocation(2*width/4, 11*height/20);
        jpanel.add(lblInstr);
    }

    public void initComponent() {
        //make title lbl
        this.lblTitulo = new JLabel("infos dieta");
        lblTitulo.setSize(width/3, height/10);
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(24f));
        lblTitulo.setLocation(((width - lblTitulo.getWidth())/2), height/20);
        jpanel.add(lblTitulo);

        //mk inst1 lbl
        this.lblInstrDel = new JLabel("para excluir um item, clique duas vezes nele!");
        lblInstrDel.setSize(75*width/100, height/22);
        lblInstrDel.setLocation(((width-lblInstrDel.getWidth())/2), 10*height/20);
        jpanel.add(lblInstrDel);

        //make txt Nome
        this.txtNomeCard = new JTextField();
        txtNomeCard.setSize(((width / 2) - height/22), height/22);
        txtNomeCard.setLocation(width/3, 7 * height/10);
        jpanel.add(txtNomeCard);

        //make lbl Nome
        this.lblNomeCard = new JLabel("Nome: ");
        lblNomeCard.setSize((width - height / 22), height / 22);
        lblNomeCard.setLocation(width / 8, 7 * height/10);
        jpanel.add(lblNomeCard);

        //make lbl total calories
        this.lblClrsTotal = new JLabel();
        lblClrsTotal.setSize(((width / 2) - height / 22), height / 22);
        lblClrsTotal.setLocation(width / 2, 7 * height/9);
        lblClrsTotal.setForeground(Color.blue);
        jpanel.add(lblClrsTotal);

        //make lbl calories
        this.lblClrs = new JLabel("Todal de calorias: ");
        lblClrs.setSize((width - height / 22), height / 22);
        lblClrs.setLocation(width / 8, 7 * height/9);
        jpanel.add(lblClrs);

        //make logout btn
        this.btnLogout = new JButton("sair");
        btnLogout.setSize(width/6, height/20);
        btnLogout.setLocation(3*width / 4, 6*height/7);
        btnLogout.addActionListener(this);
        jpanel.add(btnLogout);

        //make voltar btn
        this.btnVoltar = new JButton("<---");
        btnVoltar.setSize(width/6, height/20);
        btnVoltar.setLocation(width / 10, 6*height/7);
        btnVoltar.addActionListener(this);
        jpanel.add(btnVoltar);

        //make salvar btn
        this.btnSalvar = new JButton("Salvar");
        btnSalvar.setSize(width/3, height/20);
        btnSalvar.setLocation(((width - btnSalvar.getWidth())/2), 6*height/7);
        btnSalvar.addActionListener(this);
        jpanel.add(btnSalvar);
    }

    public void remComponent(){
        jpanel.remove(lblTitulo);
        jpanel.remove(btnLogout);
        jpanel.remove(btnVoltar);
        jpanel.remove(btnSalvar);
        jpanel.remove(txtNomeCard);
        jpanel.remove(lblNomeCard);
        jpanel.remove(lblClrs);
        jpanel.remove(lblClrsTotal);
        jpanel.remove(add);
        jpanel.remove(scrollPane);
        jpanel.remove(lblInstr);
        jpanel.remove(lblInstrDel);
    }

    public DefaultTableModel copiarTableModel(DefaultTableModel dadosTable){
        this.dadosTable = dadosTable;
        return dadosTable;
    }

    public DefaultTableModel colocaCardapio(Object nome, int dia){
        if(this.dadosTable.getRowCount() == nroLinha)
            dadosTable.setRowCount(nroLinha+1);

        for(int i = 0; i < dadosTable.getRowCount(); i++){
            if(dadosTable.getValueAt(i, dia) == null) {
                this.dadosTable.setValueAt(nome, i, dia);
                break;
            }
        }

        nroLinha++;

        return dadosTable;
    }

    public DefaultTableModel retiraInfoTabela(int linha, int coluna){
        dadosTable.setValueAt(null, linha, coluna);
        return dadosTable;
    }

    public double calculaClrsTotal(){
        double totalClrs = 0;
        for(int i = 0; i < this.dadosTable.getRowCount(); i++) {
            for(int j = 0; j < this.dadosTable.getColumnCount(); j++)
                if(dadosTable.getValueAt(i, j) != null)
                    totalClrs += nutricionista.calculaClrsCard(dadosTable.getValueAt(i, j));
        }

        return totalClrs;
    }

    @Override
    public void mouseClicked(MouseEvent e){
        this.table = (JTable)e.getSource();
        boolean checkVazio = (dadosTable.getValueAt(table.getSelectedRow(), table.getSelectedColumn()) == null);
        if(e.getClickCount() == 2 && !checkVazio){
            String mensagem = "Você deseja mesmo excluir o cardápio da dieta?";
            int decisao = JOptionPane.showConfirmDialog(null, mensagem, mensagem, JOptionPane.YES_NO_OPTION);

            if(decisao == 0){
                this.remComponent();
                jpanel.repaint();
                this.initTable(this.retiraInfoTabela(table.getSelectedRow(), table.getSelectedColumn()));


                if(this.lblInstr.getText().equals("Add o cardápio:"))
                    this.initComboCard();
                else
                    this.initComboDia();

                this.initComponent();
                lblClrsTotal.setText(String.valueOf(this.calculaClrsTotal()));
            }
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
        else if(event.getSource() == btnVoltar && jframe.getTitle().equals("Add dieta")){
            WindowListDie telaListDie = new WindowListDie(
                    this.jframe, this.jpanel, this.width, this.height, this.nutricionista);
            this.remComponent();
            jpanel.repaint();
            telaListDie.initList();
            telaListDie.initComponent();
        }
        else if(event.getSource() == btnVoltar && jframe.getTitle().equals("Editar dieta")){
            WindowDadosDie telaDadosDie = new WindowDadosDie(
                    this.jframe, this.jpanel, this.width, this.height, this.nutricionista, nroDie);
            this.remComponent();
            jpanel.repaint();
            telaDadosDie.initTable();
            telaDadosDie.initComponent();
        }
        else if(event.getSource() == btnSalvar){
            String nome = txtNomeCard.getText();
            List<Cardapio> dmg = new ArrayList<>();
            List<Cardapio> seg = new ArrayList<>();
            List<Cardapio> ter = new ArrayList<>();
            List<Cardapio> qua = new ArrayList<>();
            List<Cardapio> qui = new ArrayList<>();
            List<Cardapio> sex = new ArrayList<>();
            List<Cardapio> sab = new ArrayList<>();

            for(int i = 0; i < this.dadosTable.getRowCount(); i++) {
                for (int j = 0; j < this.dadosTable.getColumnCount(); j++){
                    if (dadosTable.getValueAt(i, j) != null){
                        for (Cardapio cardapio : nutricionista.getCardsDaNut()) {
                            if (dadosTable.getValueAt(i, j).equals(cardapio.getNome())) {
                                if (j == 0)
                                    dmg.add(cardapio);
                                else if (j == 1)
                                    seg.add(cardapio);
                                else if (j == 2)
                                    ter.add(cardapio);
                                else if (j == 3)
                                    qua.add(cardapio);
                                else if (j == 4)
                                    qui.add(cardapio);
                                else if (j == 5)
                                    sex.add(cardapio);
                                else if (j == 6)
                                    sab.add(cardapio);
                            }
                        }
                    }
                }
            }

            if(jframe.getTitle().equals("Add dieta")) {
                nutricionista.criarDie(nome, dmg, seg, ter, qua, qui, sex, sab);

                WindowListDie telaListDie = new WindowListDie(
                        this.jframe, this.jpanel, this.width, this.height, this.nutricionista);
                this.remComponent();
                jpanel.repaint();
                telaListDie.initList();
                telaListDie.initComponent();
            }
        }
        else if(event.getSource() == add && lblInstr.getText().equals("Add o cardápio:")){
            this.itemSelecionado = add.getSelectedItem();
            this.remComponent();
            jpanel.repaint();
            this.initTable(this.copiarTableModel(this.dadosTable));
            this.initComponent();
            lblClrsTotal.setText(String.valueOf(this.calculaClrsTotal()));
            this.initComboDia();
        }
        else if(event.getSource() == add && lblInstr.getText().equals("Add o dia:")){
            this.remComponent();
            jpanel.repaint();
            this.initTable(this.colocaCardapio(itemSelecionado, add.getSelectedIndex()));
            this.initComponent();
            lblClrsTotal.setText(String.valueOf(this.calculaClrsTotal()));
            this.initComboCard();
        }
    }
}
