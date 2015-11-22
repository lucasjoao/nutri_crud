import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //things necessary to start
        int width = 470;
        int height = 470;
        JFrame jframe = new JFrame();
        JPanel jpanel = new JPanel();
        Nutricionista lucia = new Nutricionista("luluzinha", "123");

        //first window
        WindowLogin window = new WindowLogin(jframe, jpanel, width, height, lucia);
        window.initComponent();

        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
