import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelManager {
    private String playerName;
    private int currentLevel = 1;
    private Player player;
    private Maze maze;
    private JFrame frame;

    public LevelManager(String playerName) {
        this.playerName = playerName;
        createLevel();
    }

    private void createLevel() {
        frame = new JFrame("Maze Game - Level " + currentLevel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(new BorderLayout());

        player = new Player();
        maze = new Maze(currentLevel, player);

        JPanel controlPanel = new JPanel();
        JButton nextLevelButton = new JButton("Next Level");
        JButton retryButton = new JButton("Retry Current Level");
        JButton quitButton = new JButton("Quit Game");

        controlPanel.add(nextLevelButton);
        controlPanel.add(retryButton);
        controlPanel.add(quitButton);

        frame.add(controlPanel, BorderLayout.SOUTH);
        frame.add(maze, BorderLayout.CENTER);

        nextLevelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentLevel++;
                if (currentLevel > 5) {
                    JOptionPane.showMessageDialog(frame, "Congratulations, %s! You have completed the game!".formatted(playerName));
                    System.exit(0);
                } else {
                    createLevel();
                }
            }
        });

        retryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.resetLive();
                maze = new Maze(currentLevel, player);
                frame.revalidate();
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }
}
