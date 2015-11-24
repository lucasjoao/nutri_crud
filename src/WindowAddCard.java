import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class WindowAddCard extends MouseAdapter implements ActionListener {

    private JLabel lblTitulo, lblNomeCard, lblClrs, lblInstr, lblClrsTotal;
    private JTextField txtNomeCard;
    private JComboBox addCard;
    private JFrame jframe;
    private JPanel jpanel;
    private JTable table;
    private DefaultTableModel dadosTable;

    private JScrollPane scrollPane;
    private Nutricionista nutricionista;
    private int width, height;
    private JButton btnLogout, btnVoltar, btnSalvar;
    private int nroCard;
    // primeira execucao na edicao pega clrs do que está salvo no cardápio, depois vai calculando a cada +/- cardapio:
    private int gambiarra = 0;

    WindowAddCard(){}

    WindowAddCard(JFrame jframe, JPanel jpanel, int width, int height, Nutricionista nutricionista){
        this.jframe = jframe;
        jframe.setTitle("Add cardápio");
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

    WindowAddCard(JFrame jframe, JPanel jpanel, int width, int height, Nutricionista nutricionista, int nroCard){
        this.jframe = jframe;
        jframe.setTitle("Editar cardápio");
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
        this.nroCard = nroCard;
    }

    public DefaultTableModel initTableModel(){
        this.dadosTable = new DefaultTableModel();

        dadosTable.addColumn("Nome");
        dadosTable.addColumn("Quantidade");
        dadosTable.addColumn("Peso (g/ml)");
        dadosTable.addColumn("Calorias");
        dadosTable.addColumn("Função");

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

    public void initCombos(){
        //mk cb addCard
        DefaultComboBoxModel dadosAddCard = new DefaultComboBoxModel();

        for(Alimento alimento : nutricionista.getAlisDaNut())
            dadosAddCard.addElement(alimento.getNome());

        dadosAddCard.setSelectedItem("Alimentos");

        this.addCard = new JComboBox(dadosAddCard);
        addCard.setSize(width/3, height/20);
        addCard.setLocation(((width - addCard.getWidth())/2), 6 * height/10);
        addCard.setBackground(Color.WHITE);
        addCard.addActionListener(this);
        jpanel.add(addCard);
    }

    public void initComponent(){
        //only here because of conflict with scrollpane
        jframe.setContentPane(jpanel);

        //make  lblTitulo
        this.lblTitulo = new JLabel("infos cardápio");
        lblTitulo.setSize(width/3, height/10);
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(24f));
        lblTitulo.setLocation(((width - lblTitulo.getWidth())/2), height/20);
        jpanel.add(lblTitulo);

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

        //mk lbl
        this.lblInstr = new JLabel("Add os alimentos:");
        lblInstr.setSize(width/3, height/20);
        lblInstr.setLocation(((width - lblInstr.getWidth())/2), 11*height/20);
        jpanel.add(lblInstr);

        //make logout btn
        this.btnLogout = new JButton("sair");
        btnLogout.setSize(width/6, height/20);
        btnLogout.setLocation(3*width / 4, 6*height/7);
        btnLogout.addActionListener(this);
        jpanel.add(btnLogout);

        //make salvar btn
        this.btnSalvar = new JButton("Salvar");
        btnSalvar.setSize(width/3, height/20);
        btnSalvar.setLocation(((width - btnSalvar.getWidth())/2), 6*height/7);
        btnSalvar.addActionListener(this);
        jpanel.add(btnSalvar);

        //make voltar btn
        this.btnVoltar = new JButton("<---");
        btnVoltar.setSize(width/6, height/20);
        btnVoltar.setLocation(width / 10, 6*height/7);
        btnVoltar.addActionListener(this);
        jpanel.add(btnVoltar);
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
        jpanel.remove(addCard);
        jpanel.remove(scrollPane);
        jpanel.remove(lblInstr);
    }

    public void preencherCampos(Nutricionista nutricionista, int nroCard){
        txtNomeCard.setText(nutricionista.retornaNomeCard(nroCard));
        if(gambiarra == 0)
            lblClrsTotal.setText(String.valueOf(nutricionista.calculaTotalClrsCard(nroCard)));
    }

    public DefaultTableModel pegaInfosAlimento(Object nome){
        for(Alimento alimento : nutricionista.getAlisDaNut()){
            if(nome.equals(alimento.getNome())) {
                String quant = alimento.getQuantidade();
                double peso = alimento.getPeso();
                double clrs = alimento.getCalorias();

                Object[] dadosProv = {nome, quant, peso, clrs, "EXCLUIR!"};

                this.dadosTable.insertRow(0, dadosProv);
            }
        }
        return dadosTable;
    }

    public DefaultTableModel retiraInfosTabela(int linha){
        dadosTable.removeRow(linha);
        return dadosTable;
    }

    public double calculaClrsTotal(){
        double totalClrs = 0;
        for(int i = 0; i < this.dadosTable.getRowCount(); i++) {
            double valor = (Double)dadosTable.getValueAt(i, 3);
            totalClrs += valor;
        }

        return totalClrs;
    }

    public DefaultTableModel copiarTableModel(DefaultTableModel dadosTable){
        this.dadosTable = dadosTable;

        dadosTable.addColumn("Função");

        for (int i = 0; i < dadosTable.getRowCount(); i++)
            dadosTable.setValueAt("EXCLUIR", i, 4);

        return dadosTable;
    }

    @Override
    public void mouseClicked(MouseEvent e){
        this.table = (JTable)e.getSource();
        if(e.getClickCount() == 2 && table.getSelectedColumn() == 4){
            String mensagem = "Você deseja mesmo excluir o alimento do cardápio?";
            int decisao = JOptionPane.showConfirmDialog(null, mensagem, mensagem, JOptionPane.YES_NO_OPTION);

            if(decisao == 0) {
                gambiarra++;
                this.remComponent();
                jpanel.repaint();
                this.initTable(this.retiraInfosTabela(table.getSelectedRow()));
                this.initComponent();
                lblClrsTotal.setText(String.valueOf(this.calculaClrsTotal()));
                this.initCombos();
                if(jframe.getTitle().equals("Editar cardápio"))
                    this.preencherCampos(nutricionista, nroCard);
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
        else if(event.getSource() == btnVoltar && jframe.getTitle().equals("Add cardápio")){
            WindowListCard telaListCard = new WindowListCard(
                    this.jframe, this.jpanel, this.width, this.height, this.nutricionista);
            this.remComponent();
            jpanel.repaint();
            telaListCard.initList();
            telaListCard.initComponent();
        }
        else if(event.getSource() == btnVoltar && jframe.getTitle().equals("Editar cardápio")){
            WindowDadosCard telaDadosCard = new WindowDadosCard(
                    this.jframe, this.jpanel, this.width, this.height, this.nutricionista, nroCard);
            this.remComponent();
            jpanel.repaint();
            telaDadosCard.initTable();
            telaDadosCard.initComponent();
        }
        else if(event.getSource() == btnSalvar){
            String nome = txtNomeCard.getText();
            List<Alimento> alimentos = new ArrayList<>();

            for(Alimento alimento : nutricionista.getAlisDaNut()){
                for(int i = 0; i < dadosTable.getRowCount(); i++){
                    if(dadosTable.getValueAt(i,0).equals(alimento.getNome()))
                        alimentos.add(alimento);
                }
            }

            if(jframe.getTitle().equals("Add cardápio")){
                nutricionista.criarCard(nome, alimentos);

                WindowListCard telaListCard = new WindowListCard(
                        this.jframe, this.jpanel, this.width, this.height, this.nutricionista);
                this.remComponent();
                jpanel.repaint();
                telaListCard.initList();
                telaListCard.initComponent();
            } else {
                nutricionista.editarCard(nome,alimentos, nroCard);

                WindowDadosCard telaDadosCard = new WindowDadosCard(
                        this.jframe, this.jpanel, this.width, this.height, this.nutricionista, nroCard);
                this.remComponent();
                jpanel.repaint();
                telaDadosCard.initTable();
                telaDadosCard.initComponent();
            }
        } else if(event.getSource() == addCard){
            gambiarra++;
            this.remComponent();
            jpanel.repaint();
            this.initTable(this.pegaInfosAlimento(addCard.getSelectedItem()));
            this.initComponent();
            lblClrsTotal.setText(String.valueOf(this.calculaClrsTotal()));
            this.initCombos();
            if(jframe.getTitle().equals("Editar cardápio"))
                this.preencherCampos(nutricionista, nroCard);
        }
    }
}
