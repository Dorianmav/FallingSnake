package snake;

import javax.swing.*;
import java.awt.*;



public class Display extends JComponent {
    static final int SCALE = 10;
    private Game game;
    private JFrame frame;
    private static Font afficheTexte = new Font("Arial", Font.PLAIN, 50);

    public Display(Game game,JFrame frame){
        this.game = game;
        this.frame = frame;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        SnakeObservable snake = game.getSnake();
        if (snake.isInvinsible()){
            g.setColor(Color.BLACK);
            for (Coordinate c : snake.getBody())
                g.fillOval(c.getX() * SCALE, c.getY() * SCALE , SCALE, SCALE);
        }
        else {
            g.setColor(Color.GREEN);

            for (Coordinate c : snake.getBody())
                g.fillOval(c.getX() * SCALE, c.getY() * SCALE, SCALE,SCALE);
        }
        g.setColor(Color.RED);
        game.getFraise().forEach(fruit -> {
            var c = fruit.getPosition();
            g.fillOval(c.getX() * SCALE, c.getY() * SCALE, SCALE, SCALE);
        });
        g.setColor(new Color(150, 75, 0));
        game.getBois().forEach(bois -> {
            var c = bois.getPosition();
            g.fillOval(c.getX() * SCALE, c.getY() * SCALE, SCALE, SCALE);
        });
        g.setColor(Color.YELLOW);
        game.getPiece().forEach(piece -> {
            var c = piece.getPosition();
            g.fillOval(c.getX() * SCALE, c.getY() * SCALE, SCALE, SCALE);
        });
        g.setColor(new Color(160, 32, 240));
        game.getMyrtille().forEach(myrtille -> {
            var c = myrtille.getPosition();
            g.fillOval(c.getX() * SCALE, c.getY() * SCALE, SCALE, SCALE);
        });

        g.setColor(Color.BLUE);
        g.fillRect(game.canon.deplacementVaisseau(), game.canon.getPosY(), SCALE, SCALE);
        g.fillRect(game.tir.getPosX(), game.tir.deplacementTir(), SCALE, SCALE);

        //detection du tir sur le serpent
        snake.tirtoucheSerpent(game.tir);

        //detection du tir sur le bois

        //détéction défaite

        if(snake.getHead().getY() >= (game.canon.getPosY()/10)) {
            g.setFont(afficheTexte);
            g.drawString("GAME OVER!", 60, 50);
            frame.removeAll();
        }
    }
}
