import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args)
    {
        EventQueue.invokeLater(()->{

            Toolkit kit = Toolkit.getDefaultToolkit();
            Dimension frameSize = kit.getScreenSize();
            int side = frameSize.width;
            JFrame frame = new MyFrame();
            frame.setTitle("Tic Tac Toe Game");
            frame.setLocationByPlatform(true);
            frame.setSize(side/3,side/3);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}
