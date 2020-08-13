import javax.swing.*;
import java.awt.*;

public class BattleField extends JPanel {
    private GameWindow gameWindow;

    public BattleField(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBackground(Color.ORANGE);
    }
}
