import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    static final int WINDOW_POS_X = 500;
    static final int WINDOW_POS_Y = 200;
    static final int WINDOW_HEIGHT = 555;
    static final int WINDOW_WIDTH = 505;
    public GameWindow(){
    setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setTitle("Крестики Нолики");

    JPanel panel = new JPanel(new GridLayout(1,2));
    JButton buttonOk = new JButton("Начать новую игру");
    panel.add(buttonOk);
    JButton buttonExit = new JButton("Выход");
    panel.add(buttonExit);
    add(panel, BorderLayout.SOUTH);
    buttonExit.addActionListener(e -> {
        System.exit(0);
    });

        setVisible(true);
    }
}
