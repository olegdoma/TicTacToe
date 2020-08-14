import javax.swing.*;
import java.awt.*;

public class SettingWindow extends JFrame {
    private GameWindow gameWindow;

    private  final int WINDOW_POS_X = GameWindow.WINDOW_POS_X + 50;
    private final int WINDOW_POS_Y = GameWindow.WINDOW_POS_Y + 50;
    private final int WINDOW_HEIGHT = GameWindow.WINDOW_HEIGHT - 100;
    private final int WINDOW_WIDTH = GameWindow.WINDOW_WIDTH - 100;

    static final int GAME_MODE_H_VS_A = 0;
    static final int GAME_MODE_H_VS_H = 1;

    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;

    private JRadioButton jRbHumanvsAi;
    private JRadioButton jRbHumanvsHuman;
    private ButtonGroup bgGameMode;

    private JSlider jsFieldSize;
    private JSlider jsWinningLenght;


    public SettingWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Крестики Нолики Настройки");

        setLayout(new GridLayout(8, 1));
        add(new JLabel("     Выберите режим игры"));

        jRbHumanvsAi = new JRadioButton("Человек против Компьютера", true);
        jRbHumanvsHuman = new JRadioButton("Человек против Человека");
        add(jRbHumanvsAi);
        add(jRbHumanvsHuman);

        bgGameMode = new ButtonGroup();
        bgGameMode.add(jRbHumanvsAi);
        bgGameMode.add(jRbHumanvsHuman);

        add(new JLabel("     Выберите размер поля"));
        jsFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        add(jsFieldSize);
        jsFieldSize.setMajorTickSpacing(1);
        jsFieldSize.setPaintTicks(true);
        jsFieldSize.setPaintLabels(true);

        add(new JLabel("     Выберите выигрышную длину линии"));
        jsWinningLenght = new JSlider(MIN_FIELD_SIZE, MIN_FIELD_SIZE, MIN_FIELD_SIZE);
        add(jsWinningLenght);
        jsWinningLenght.setMajorTickSpacing(1);
        jsWinningLenght.setPaintTicks(true);
        jsWinningLenght.setPaintLabels(true);

        jsFieldSize.addChangeListener(e -> {
            jsWinningLenght.setMaximum(jsFieldSize.getValue());
        });

        JButton buttonStartGame = new JButton("Начать новую игру");
        add(buttonStartGame);
        buttonStartGame.addActionListener(e -> {
            int mode;
            if (jRbHumanvsAi.isSelected()){
                mode = GAME_MODE_H_VS_A;
            } else {
                mode = GAME_MODE_H_VS_H;
            }
            int fieldSize = jsFieldSize.getValue();
            int winningLenght = jsWinningLenght.getValue();

            gameWindow.startNewGame(mode, fieldSize, winningLenght);

            setVisible(false);
        });



        setVisible(false);
    }
}
