import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowDadosCard implements ActionListener {

    private JFrame jframe;
    private JPanel jpanel;
    private Nutricionista nutricionista;
    private JScrollPane scrollPane;
    private JLabel lblTitulo, lblNomeCard, lblClrs;
    private JLabel lblTtlNomeCard, lblTtlClrs;
    private JButton btnLogout, btnVoltar, btnEditar, btnExcluir;
    private int width, height, nroCard;
    private DefaultTableModel dadosTable;

    WindowDadosCard(JFrame jframe, JPanel jpanel, int width, int height, Nutricionista nutricionista, int nroCard){
        this.jframe = jframe;
        jframe.setTitle("Dados do cardápio");
        jframe.setSize(width, height);
        jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);

        this.jpanel = jpanel;
        jpanel.setSize(width, height);
        jpanel.setLayout(null);

        this.nutricionista = nutricionista;
        this.width = width;
        this.height = height;
        this.nroCard = nroCard;
    }

    public void initTable(){
        this.dadosTable = new DefaultTableModel();

        //mk columns
        dadosTable.addColumn("Nome");
        dadosTable.addColumn("Quantidade");
        dadosTable.addColumn("Peso (g ou ml)");
        dadosTable.addColumn("Calorias");

        //mk rows
        for(Alimento alimento : nutricionista.retornaAlisCard(nroCard)){
            String nome = alimento.getNome();
            String quant = alimento.getQuantidade();
            double peso = alimento.getPeso();
            double clrs = alimento.getCalorias();

            Object[] dadosProv = {nome, quant, peso, clrs};

            dadosTable.addRow(dadosProv);
        }

        //mk alignment
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        //mk table
        JTable table = new JTable(dadosTable) {
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
        this.lblTitulo = new JLabel(nutricionista.retornaNomeCard(nroCard));
        lblTitulo.setSize(width/3, height/10);
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(24f));
        lblTitulo.setLocation(((width - lblTitulo.getWidth())/2), height/20);
        jpanel.add(lblTitulo);

        //make lblNome
        this.lblNomeCard = new JLabel(nutricionista.retornaNomeCard(nroCard));
        lblNomeCard.setSize(((width / 2) - height/22), height/22);
        lblNomeCard.setForeground(Color.blue);
        lblNomeCard.setLocation(width/3, height/6);
        jpanel.add(lblNomeCard);

        //make lblNome rotulo
        this.lblTtlNomeCard = new JLabel("Nome: ");
        lblTtlNomeCard.setSize((width - height/22), height/22);
        lblTtlNomeCard.setLocation(width/8, height/6);
        jpanel.add(lblTtlNomeCard);

        //make lbl calories
        this.lblClrs = new JLabel(String.valueOf(nutricionista.calculaTotalClrsCard(nroCard)));
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
        jpanel.remove(lblTtlNomeCard);
        jpanel.remove(lblNomeCard);
        jpanel.remove(scrollPane);
        jpanel.remove(lblClrs);
        jpanel.remove(lblTtlClrs);
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
        else if(event.getSource() == btnVoltar) {
            WindowListCard telaListCard = new WindowListCard(
                    this.jframe, this.jpanel, this.width, this.height, this.nutricionista);
            this.remComponent();
            jpanel.repaint();
            telaListCard.initList();
            telaListCard.initComponent();
        }
        else if(event.getSource() == btnEditar){
            WindowAddCard telaEditarCard = new WindowAddCard(
                    this.jframe, this.jpanel, this.width, this.height, this.nutricionista, this.nroCard);
            this.remComponent();
            jpanel.repaint();
            telaEditarCard.initTable(telaEditarCard.copiarTableModel(dadosTable));
            telaEditarCard.initComponent();
            telaEditarCard.initCombos();
            telaEditarCard.preencherCampos(nutricionista, nroCard);
        }
        else if(event.getSource() == btnExcluir){
            String mensagem = "Você deseja mesmo excluir o cardápio \n" + nutricionista.retornaNomeCard(nroCard) + "?";
            int decisao = JOptionPane.showConfirmDialog(null, mensagem, mensagem, JOptionPane.YES_NO_OPTION);

            if(decisao == 0) {
                nutricionista.excluirCard(nroCard);

                WindowListCard telaListCard = new WindowListCard(
                        this.jframe, this.jpanel, this.width, this.height, this.nutricionista);
                this.remComponent();
                jpanel.repaint();
                telaListCard.initList();
                telaListCard.initComponent();
            }
        }
    }
}