import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleField extends JPanel {
    private GameWindow gameWindow;
    private int mode;
    private int fieldSize;
    private int winningLenght;

    private boolean isInit;

    int cellWidth;
    int cellHeight;



    public BattleField(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBackground(Color.ORANGE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                clickBattleField(e);
            }
        });
    }

    private void clickBattleField(MouseEvent e) {
        int cellX = e.getX()/cellWidth;
        int cellY = e.getY()/cellHeight;
        System.out.printf("cellX %d , cellY %d \n", cellX, cellY);
    }

    public void startNewGame(int mode, int fieldSize, int winningLenght){
        this.mode = mode;
        this.fieldSize = fieldSize;
        this.winningLenght = winningLenght;

        isInit = true;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!isInit){
            return;
        }
        int panelWidth = getWidth();
        int panelHeigth = getHeight();
        cellHeight = panelHeigth / fieldSize;
        cellWidth = panelWidth / fieldSize;

        for (int i = 0; i < fieldSize; i++) {
        int y = i * cellHeight;
            g.drawLine(0,y, panelWidth, y);

        }
        for (int i = 0; i < fieldSize; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeigth);

        }
    }
}
