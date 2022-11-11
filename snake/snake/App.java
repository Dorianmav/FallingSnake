package snake;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class App {	
	static final int FRAMES_PER_SECOND = 5;	
	static final int SCALE = 10;

	private static Font afficheTexte = new Font("Arial", Font.PLAIN, 50);

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
		}};
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
			Canon canon = game.canon;
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					canon.setDx(Constantes.DX_VAISSEAU);
				}

				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					canon.setDx(-Constantes.DX_VAISSEAU);
				}

				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(game.tir.isVaisseauTire() == false) {
						game.tir.setPosY(Constantes.POS_Y_INIT_VAISSEAU - Constantes.HAUTEUR_TIR);
						game.tir.setPosX(canon.getPosX());
						game.tir.setVaisseauTire(true);
					}

				}
			}
			public void keyReleased(KeyEvent e) {
				canon.setDx(0);
			}
		});
	}	
	

}
