package Main;

import Main.Components.Game;
import Main.Components.GameState;
import Main.Components.Location;
import Main.Components.Piece;
import Main.Components.Pieces.Pawn;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends JPanel {
    public static Main panel = new Main();
    private static JFrame frame = new JFrame("Chess Master");
    public static String desktopPath = System.getProperty("user.home") + "//" + "Desktop//";

    public static Game game = new Game();

    public static void main(String[] args) throws IOException {
        frame.setContentPane(panel);
        frame.setSize(335, 360);
        frame.setLocationRelativeTo(null);
        Image icon = ImageIO.read(new File(Main.desktopPath + "ChessPieces//ChessMaster.png"));
        frame.setIconImage(icon);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        game.gameState = GameState.WHITE;
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {

            }
        }));
        panel.update();
        panel.playGame();
    }

    public void update(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep((long) 1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    panel.removeAll();
                    panel.repaint();
                }
            }
        }).start();
    }

    public void playGame(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                game.play();
            }
        }).start();
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(-1000,-1000,10000,10000);
        if(game.gameState.equals(GameState.WHITE) || game.gameState.equals(GameState.BLACK)) {
            for (float x = 1; x < 9; x++) {
                for (float y = 1; y < 9; y++) {
                    int x1 = (int) x * 40 - 40;
                    int y1 = (int) y * 40 - 40;
                    if ((x + y) / 2 == Math.round((x + y) / 2)) {
                        g.setColor(new Color(255, 250, 240, 255));
                    } else {
                        g.setColor(new Color(138, 154, 91, 255));
                    }
                    g.fillRect(x1, y1, 40, 40);
                    g.setColor(Color.BLACK);
                    g.drawRect(0, 0, 320, 320);
                }
            }
            game.drawBlackPieces(g);
            game.drawWhitePieces(g);
            for (Location l : game.markers) {
                g.setColor( new Color(255, 0, 0, 100));
                int x1 = (int) l.getX() * 40 - 40;
                int y1 = (int) l.getY() * 40 - 40;
                g.fillRect(x1, y1, 40, 40);
            }
        }
    }
}
