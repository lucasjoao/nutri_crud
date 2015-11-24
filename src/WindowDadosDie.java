import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class WindowDadosDie implements ActionListener {

    private JFrame jframe;
    private JPanel jpanel;
    private Nutricionista nutricionista;
    private JScrollPane scrollPane;
    private JTable table;
    private JLabel lblTitulo, lblNomeDie, lblClrs;
    private JLabel lblTtlNomeDie, lblTtlClrs;
    private JButton btnLogout, btnVoltar, btnEditar, btnExcluir;
    private int width, height, nroDie;
    private DefaultTableModel dadosTable;
    private List<Paciente> pacsDaNut;

    WindowDadosDie(){}

    WindowDadosDie(JFrame jframe, JPanel jpanel, int width, int height, Nutricionista nutricionista, List<Paciente> pacsDaNut, int nroDie){
        this.jframe = jframe;
        jframe.setTitle("Dados da dieta");
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
        this.nroDie = nroDie;
    }

    public void initTable(){
        this.dadosTable = new DefaultTableModel();

        dadosTable.addColumn("Domingo");
        dadosTable.addColumn("Segunda");
        dadosTable.addColumn("Terça");
        dadosTable.addColumn("Quarta");
        dadosTable.addColumn("Quinta");
        dadosTable.addColumn("Sexta");
        dadosTable.addColumn("Sábado");

        dadosTable.setRowCount(nutricionista.calculaMaiorList(nroDie));
        this.fazCelulas();

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

        for(int i = 0; i < table.getColumnCount(); i++)
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);

        //mk scrollpane
        this.scrollPane = new JScrollPane(table);
        scrollPane.setBounds(width/20, height/4, 9*width/10, height/3);
        //enable scroll with mouse wheel:
        scrollPane.setWheelScrollingEnabled(true);
        scrollPane.getViewport().setBackground(Color.WHITE);
        jpanel.add(scrollPane);
    }

    public void initComponent(){
        //only here because of conflict with scrollpane
        jframe.setContentPane(jpanel);

        //make  lblTitulo
        this.lblTitulo = new JLabel(nutricionista.retornaNomeDie(nroDie));
        lblTitulo.setSize(width/3, height/10);
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(24f));
        lblTitulo.setLocation(((width - lblTitulo.getWidth())/2), height/20);
        jpanel.add(lblTitulo);

        //make lblNome
        this.lblNomeDie = new JLabel(nutricionista.retornaNomeDie(nroDie));
        lblNomeDie.setSize(((width / 2) - height/22), height/22);
        lblNomeDie.setForeground(Color.blue);
        lblNomeDie.setLocation(width/3, height/6);
        jpanel.add(lblNomeDie);

        //make lblNome rotulo
        this.lblTtlNomeDie = new JLabel("Nome: ");
        lblTtlNomeDie.setSize((width - height/22), height/22);
        lblTtlNomeDie.setLocation(width/8, height/6);
        jpanel.add(lblTtlNomeDie);

        //make lbl calories
        this.lblClrs = new JLabel(String.valueOf(nutricionista.calculaTotalClrsDie(nroDie)));
        lblClrs.setSize(((width / 2) - height / 22), height / 22);
        lblClrs.setLocation(width / 2, 5 * height/7);
        lblClrs.setForeground(Color.blue);
        jpanel.add(lblClrs);

        //make lbl calories rotulo
        this.lblTtlClrs = new JLabel("Todal de calorias: ");
        lblTtlClrs.setSize((width - height/22), height/22);
        lblTtlClrs.setLocation(width/8, 5 * height/7);
        jpanel.add(lblTtlClrs);

        //make logout btn
        this.btnLogout = new JButton("sair");
        btnLogout.setSize(width/6, height/20);
        btnLogout.setLocation(3*width / 4, 6*height/7);
        btnLogout.addActionListener(this);
        jpanel.add(btnLogout);

        //make editar btn
        this.btnEditar = new JButton("Editar");
        btnEditar.setSize(width/5, height/20);
        btnEditar.setLocation(2*width / 7, 6*height/7);
        btnEditar.addActionListener(this);
        jpanel.add(btnEditar);

        //make voltar btn
        this.btnVoltar = new JButton("<---");
        btnVoltar.setSize(width/6, height/20);
        btnVoltar.setLocation(width / 10, 6*height/7);
        btnVoltar.addActionListener(this);
        jpanel.add(btnVoltar);

        //make excluir btn
        this.btnExcluir = new JButton("Excluir");
        btnExcluir.setSize(width/5, height/20);
        btnExcluir.setLocation(width / 2, 6*height/7);
        btnExcluir.addActionListener(this);
        jpanel.add(btnExcluir);
    }

    public void remComponent(){
        jpanel.remove(lblTitulo);
        jpanel.remove(btnLogout);
        jpanel.remove(btnVoltar);
        jpanel.remove(btnEditar);
        jpanel.remove(btnExcluir);
        jpanel.remove(lblTtlNomeDie);
        jpanel.remove(lblNomeDie);
        jpanel.remove(scrollPane);
        jpanel.remove(lblClrs);
        jpanel.remove(lblTtlClrs);
    }

    public void fazCelulas(){
        int a = 0;
        for(Cardapio cardapio : nutricionista.retornaCardsDmg(nroDie)){
            String nome = cardapio.getNome();
            dadosTable.setValueAt(nome, a, 0);
            a++;
        }

        int b = 0;
        for(Cardapio cardapio : nutricionista.retornaCardsSeg(nroDie)){
            String nome = cardapio.getNome();
            dadosTable.setValueAt(nome, b, 1);
            b++;
        }

        int c = 0;
        for(Cardapio cardapio : nutricionista.retornaCardsTer(nroDie)){
            String nome = cardapio.getNome();
            dadosTable.setValueAt(nome, c, 2);
            c++;
        }

        int d = 0;
        for(Cardapio cardapio : nutricionista.retornaCardsQua(nroDie)){
            String nome = cardapio.getNome();
            dadosTable.setValueAt(nome, d, 3);
            d++;
        }

        int e = 0;
        for(Cardapio cardapio : nutricionista.retornaCardsQui(nroDie)){
            String nome = cardapio.getNome();
            dadosTable.setValueAt(nome, e, 4);
            e++;
        }

        int f = 0;
        for(Cardapio cardapio : nutricionista.retornaCardsSex(nroDie)){
            String nome = cardapio.getNome();
            dadosTable.setValueAt(nome, f, 5);
            f++;
        }

        int g = 0;
        for(Cardapio cardapio : nutricionista.retornaCardsSab(nroDie)){
            String nome = cardapio.getNome();
            dadosTable.setValueAt(nome, g, 6);
            g++;
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
        else if(event.getSource() == btnVoltar) {
            WindowListDie telaListDie = new WindowListDie(
                    this.jframe, this.jpanel, this.width, this.height, this.nutricionista, this.pacsDaNut);
            this.remComponent();
            jpanel.repaint();
            telaListDie.initList();
            telaListDie.initComponent();
        }
        else if(event.getSource() == btnEditar){
            WindowAddDie telaEditarDie = new WindowAddDie(
                    this.jframe, this.jpanel, this.width, this.height, this.nutricionista, this.pacsDaNut, this.nroDie);
            this.remComponent();
            jpanel.repaint();
            telaEditarDie.initTable(telaEditarDie.copiarTableModel(dadosTable));
            telaEditarDie.initComponent();
            telaEditarDie.initComboCard();
            telaEditarDie.preencherCampos(nutricionista, nroDie);
        }
        else if(event.getSource() == btnExcluir){
            String mensagem = "Você deseja mesmo excluir a dieta \n" + nutricionista.retornaNomeDie(nroDie) + "?";
            int decisao = JOptionPane.showConfirmDialog(null, mensagem, mensagem, JOptionPane.YES_NO_OPTION);

            if(decisao == 0) {
                nutricionista.excluirDie(nroDie);

                WindowListDie telaListDie = new WindowListDie(
                        this.jframe, this.jpanel, this.width, this.height, this.nutricionista, this.pacsDaNut);
                this.remComponent();
                jpanel.repaint();
                telaListDie.initList();
                telaListDie.initComponent();
            }
        }
    }
}