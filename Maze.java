import javax.swing.*;
import java.awt.*;

public class Maze extends JPanel {
    private int level;
    private Player player;

    public Maze(int level, Player player) {
        this.level = level;
        this.player = player;
        setPreferredSize(new Dimension(600, 600));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
