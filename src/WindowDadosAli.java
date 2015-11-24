import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class WindowDadosAli implements ActionListener{

    private List<Paciente> pacsDaNut;
    private JFrame jframe;
    private JPanel jpanel;
    private Nutricionista nutricionista;
    private JLabel lblTitulo, lblNomeAli, lblQuant, lblClrs, lblPeso;
    private JLabel lblTtlNomeAli, lblTtlQuant, lblTtlClrs, lblTtlPeso;
    private JButton btnLogout, btnVoltar, btnEditar, btnExcluir;
    private int width, height, nroAli;

    WindowDadosAli(){}

    WindowDadosAli(JFrame jframe, JPanel jpanel, int width, int height, Nutricionista nutricionista, List<Paciente> pacsDaNut, int nroAli){
        this.jframe = jframe;
        jframe.setTitle("Dados do alimento");
        jframe.setSize(width, height);
        jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);

        this.jpanel = jpanel;
        jpanel.setSize(width, height);
        jpanel.setLayout(null);

        jframe.setContentPane(jpanel);

        this.nutricionista = nutricionista;
        this.pacsDaNut = pacsDaNut;
        this.width = width;
        this.height = height;
        this.nroAli = nroAli;
    }

    public void initComponent() {
        //make  lblTitulo
        this.lblTitulo = new JLabel(nutricionista.retornaNomeAli(nroAli));
        lblTitulo.setSize(width/3, height/10);
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(24f));
        lblTitulo.setLocation(((width - lblTitulo.getWidth())/2), height/20);
        jpanel.add(lblTitulo);

        //make lblNome
        this.lblNomeAli = new JLabel(nutricionista.retornaNomeAli(nroAli));
        lblNomeAli.setSize(((width / 2) - height/22), height/22);
        lblNomeAli.setForeground(Color.blue);
        lblNomeAli.setLocation(width/3, height/6);
        jpanel.add(lblNomeAli);

        //make lblNome rotulo
        this.lblTtlNomeAli = new JLabel("Nome: ");
        lblTtlNomeAli.setSize((width - height/22), height/22);
        lblTtlNomeAli.setLocation(width/8, height/6);
        jpanel.add(lblTtlNomeAli);

        //make lblQuant
        this.lblQuant = new JLabel(nutricionista.retornaQuantAli(nroAli));
        lblQuant.setSize(((width / 2) - height / 22), height/22);
        lblQuant.setForeground(Color.BLUE);
        lblQuant.setLocation(width/3, (height/6 + height/22));
        jpanel.add(lblQuant);

        //make lblQuant rotulo
        this.lblTtlQuant = new JLabel("Quantidade: ");
        lblTtlQuant.setSize((width - height/22), height/22);
        lblTtlQuant.setLocation(width/8, (height/6 + height/22));
        jpanel.add(lblTtlQuant);

        //make lbl Peso
        this.lblPeso = new JLabel(String.valueOf(nutricionista.retornaPesoAli(nroAli)));
        lblPeso.setSize(((width / 2) - height / 22), height / 22);
        lblPeso.setForeground(Color.blue);
        lblPeso.setLocation(width / 3, (height / 6 + 2 * height / 22));
        jpanel.add(lblPeso);

        //make lbl Peso rotulo
        this.lblTtlPeso = new JLabel("Peso: ");
        lblTtlPeso.setSize((width - height/22), height/22);
        lblTtlPeso.setLocation(width/8, (height/6 + 2*height/22));
        jpanel.add(lblTtlPeso);

        //make lbl calories
        this.lblClrs = new JLabel(String.valueOf(nutricionista.retornaClrsAli(nroAli)));
        lblClrs.setSize(((width / 2) - height / 22), height / 22);
        lblClrs.setLocation(width / 3, (height / 6 + 3 * height / 22));
        lblClrs.setForeground(Color.blue);
        jpanel.add(lblClrs);

        //make lbl calories rotulo
        this.lblTtlClrs = new JLabel("Calorias: ");
        lblTtlClrs.setSize((width - height/22), height/22);
        lblTtlClrs.setLocation(width/8, (height/6 + 3*height/22));
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
        jpanel.remove(lblPeso);
        jpanel.remove(btnEditar);
        jpanel.remove(lblTtlPeso);
        jpanel.remove(btnExcluir);
        jpanel.remove(lblClrs);
        jpanel.remove(lblTtlClrs);
        jpanel.remove(lblTtlNomeAli);
        jpanel.remove(lblNomeAli);
        jpanel.remove(lblQuant);
        jpanel.remove(lblTtlQuant);
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
        else if(event.getSource() == btnVoltar){
            WindowListAli telaListAli = new WindowListAli(
                    this.jframe, this.jpanel, this.width, this.height, this.nutricionista, this.pacsDaNut);
            this.remComponent();
            jpanel.repaint();
            telaListAli.initList();
            telaListAli.initComponent();
        }
        else if(event.getSource() == btnEditar){
            WindowAddAli telaEditarAli = new WindowAddAli(
                    this.jframe, this.jpanel, this.width, this.height, this.nutricionista, this.pacsDaNut, this.nroAli);
            this.remComponent();
            jpanel.repaint();
            telaEditarAli.initComponent();
            telaEditarAli.preencherCampos(nutricionista, nroAli);
        }
        else if(event.getSource() == btnExcluir){
            String mensagem = "Você deseja mesmo excluir o alimento \n" + nutricionista.retornaNomeAli(nroAli) + "?";
            int decisao = JOptionPane.showConfirmDialog(null, mensagem, mensagem, JOptionPane.YES_NO_OPTION);

            if(decisao == 0) {
                nutricionista.excluirAli(nroAli);

                WindowListAli telaListAli = new WindowListAli(
                        this.jframe, this.jpanel, this.width, this.height, this.nutricionista, this.pacsDaNut);
                this.remComponent();
                jpanel.repaint();
                telaListAli.initList();
                telaListAli.initComponent();
            }
        }
    }
}

