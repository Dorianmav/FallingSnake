package snake;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Game {
	
	private static final int INV_PERIOD = 60;
	private static final Random RANDOM_SEED = new Random();	
	private int height;
	private int width;

	public Canon canon;
	public Tir tir;
	private SnakeObservable snake;
	private List<Fraise> fraises;

	private List<Bois> bois;
	private List<Myrtille> myrtilles;

	private List<Piece> pieces;

	private Piece piece;
	private int timer;
	private final int temp = 35;
		
	public Game(int width, int height, Coordinate c) {
		this.height = height;
		this.width = width;
		snake = new SnakeObservable(this, c);
		bois = new ArrayList<>();
		addBois();
		fraises = new ArrayList<>();
		addFraise();
		myrtilles = new ArrayList<>();
		addMyrtille();
		int x = RANDOM_SEED.nextInt(((getHeight()-5) - 1) + 1);
		int y = RANDOM_SEED.nextInt(((getWidth()-10) - 1) + 1);
		Coordinate position = new Coordinate(x, y);
		piece = new Piece(position);
		pieces = new ArrayList<>();
		pieces.add(piece);
		canon = new Canon();
		tir = new Tir();
		timer = 0;		
	}

	public SnakeObservable getSnake() {
		return snake;
	}
	
	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
	
	 boolean isOut(Coordinate c) {
		if (c.getX() < 0 || c.getY() < 0)
			return true;
		if (c.getX() >= width || c.getY() >= height)
			return true;
		return false;
	}

	boolean isDroite(Coordinate c){
		if (c.getX() >= width)	{
			return true;
		}
		return false;
	}

	boolean isGauche(Coordinate c){
		if (c.getX() <= 0)	{
			return true;
		}
		return false;
	}

	public void step() {
		snake.move();
		if (isDroite(snake.getHead())) {
			snake.setDirection(Direction.Down);
			snake.move();
			snake.setDirection(Direction.Left);
		}
		if (isGauche(snake.getHead())) {
			snake.setDirection(Direction.Down);
			snake.move();
			snake.setDirection(Direction.Right);
		}
		timer++;
		for (Fraise fraise : fraises) {
			fraise.step(snake);
		}
		fraises.removeIf(fraise -> !fraise.isAlive());
		for (Fraise fraise : fraises) {
			fraise.step(snake);
			if (!fraise.isAlive()){

			}
		}
		bois.removeIf(bois -> !bois.isAlive());
		for (Bois bois1 : bois) {
			bois1.step(snake);
		}
		myrtilles.removeIf(myrtille -> !myrtille.isAlive());
		for (Myrtille myrtille : myrtilles) {
			myrtille.step(snake);
		}
		myrtilles.removeIf(myrtille -> !myrtille.isAlive());

		if(timer >= INV_PERIOD) {
			snake.setInvinsible(false);
			timer = 0;
		}
		piece.step(this, snake);
		pieces.removeIf(piece1 -> !piece1.isAlive());

	}

	public void addFraise(){
		for (int i = 0; i < 8; i++) {
			int x = RANDOM_SEED.nextInt(((getHeight()-5) - 1) + 1);
			int y = RANDOM_SEED.nextInt(((getWidth()-10) - 1) + 1);
			Coordinate position = new Coordinate(x, y);
			fraises.add(new Fraise(position));
		}
	}

	public void addBois(){
		for (int i = 0; i < 8; i++) {
			int x = RANDOM_SEED.nextInt(((getHeight()-5) - 1) + 1);
			int y = RANDOM_SEED.nextInt(((getWidth()-10) - 1) + 1);
			Coordinate position = new Coordinate(x, y);
			bois.add(new Bois(position));
		}
	}

	public void addMyrtille() {
		for (int i = 0; i < 4; i++) {
			int x = RANDOM_SEED.nextInt(((getHeight()-5) - 1) + 1);
			int y = RANDOM_SEED.nextInt(((getWidth()-10) - 1) + 1);
			Coordinate position = new Coordinate(x, y);
			myrtilles.add(new Myrtille(position));
		}
	}

	public Stream<Fraise> getFraise() {
		return fraises.stream();
	}

	public Stream<Piece> getPiece() {
		return pieces.stream();
	}

	public void clean(){
		fraises = new ArrayList<>();
		bois = new ArrayList<>();
		myrtilles = new ArrayList<>();
		int x = RANDOM_SEED.nextInt(((getHeight()-5) - 1) + 1);
		int y = RANDOM_SEED.nextInt(((getWidth()-10) - 1) + 1);
		Coordinate position = new Coordinate(x, y);
		bois.add(new Bois(position));
	}

	public Stream<Bois> getBois(){
		return bois.stream();
	}

	public Stream<Myrtille> getMyrtille(){
		return myrtilles.stream();
	}


	public int getTimer() {
		return timer;
	}
}
