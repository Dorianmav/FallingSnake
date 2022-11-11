package snake;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class  App {
	static final int FRAMES_PER_SECOND = 5;	
	static final int SCALE = 10;

	public static void main(String[] args) {
		Game game = new Game(50, 50, new Coordinate(0, 0));
		test(game);
	}

	public static void test(Game game){

		display(game);
		while (game.getSnake().isAlive()) {
			game.step();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		
	public static void display(Game game) {		
		JFrame frame = new JFrame("Snake");
		JComponent component = new Display(game,frame);

		game.getSnake().register(new Register(component));


		frame.setContentPane(component);
		frame.setSize(game.getWidth() * SCALE, game.getHeight() * SCALE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		Canon canon = game.canon;
		frame.addKeyListener(new Listener(canon,game));
	}	
	

}
