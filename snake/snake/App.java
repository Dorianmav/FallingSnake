package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class App {	
	static final int FRAMES_PER_SECOND = 5;	
	static final int SCALE = 10;
	
	public static void main(String[] args) throws InterruptedException {
		Game game = new Game(50, 50, new Coordinate(0, 0));
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
		JComponent component = new JComponent() {
			private static final long serialVersionUID = 1L;
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				SnakeObservable snake = game.getSnake();
				if (snake.isInvinsible()){
					g.setColor(Color.BLACK);
					for (Coordinate c : snake.getBody())
						g.fillOval(c.getX() * SCALE, c.getY() * SCALE, SCALE, SCALE);
				}
				else {
					g.setColor(Color.BLUE);

				for (Coordinate c : snake.getBody()) 								
					g.fillOval(c.getX() * SCALE, c.getY() * SCALE, SCALE, SCALE);
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
				g.setColor(new Color(160, 32, 240));
				game.getMyrtille().forEach(myrtille -> {
					var c = myrtille.getPosition();
					g.fillOval(c.getX() * SCALE, c.getY() * SCALE, SCALE, SCALE);
				});
			}				
		};
		game.getSnake().register(new SnakeObserver() {			
			@Override
			public void update() {
				component.repaint();			
			}
		});
		frame.setContentPane(component);
		frame.setSize(game.getWidth() * SCALE, game.getHeight() * SCALE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.addKeyListener(new KeyAdapter() {
			SnakeObservable snake = game.getSnake();
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					snake.setDirection(Direction.Left);
					break;
				case KeyEvent.VK_RIGHT:
					snake.setDirection(Direction.Right);
					break;
				case KeyEvent.VK_UP:
					snake.setDirection(Direction.Up);
					break;
				case KeyEvent.VK_DOWN:
					snake.setDirection(Direction.Down);
					break;
				default:
					break;
				}
			}
		});
	}	
	

}
