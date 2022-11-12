package snake;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Snake implements ISnake {

	private final int INITSIZE = 3;

	/**
	 * Body représente le corps du serpent
	 * La tête du serpent se trouve en fin de liste 
	 * La queue du serpent se trouve en début de liste
	 */
	private List<Coordinate> body;
	private Game game;
	private Direction direction;
	private boolean alive;



	private boolean invinsible;

	public Snake(Game game, Coordinate start) {
		alive = true;
		invinsible = false;
		this.game = game;
		direction = Direction.Right;
		body = new ArrayList<>();
		for (int i = 0; i < INITSIZE; i++) {
			body.add(new Coordinate(start.getX() + i, start.getY()));
		}
	}

	/* (non-Javadoc)
	 * @see snake.ISnake#getDirection()
	 */
	@Override
	public Direction getDirection() {
		return direction;
	}

	/* (non-Javadoc)
	 * @see snake.ISnake#setDirection(snake.Direction)
	 */
	@Override
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	/* (non-Javadoc)
	 * @see snake.ISnake#getBody()
	 */
	@Override
	public List<Coordinate> getBody() {
		return new ArrayList<>(body);
	}

	public void addQueue(){
		body.add(new Coordinate(body.get(body.size() - 1).getX() + 1, body.get(body.size() - 1).getY()));
	}

	public void downLeft(){
		setDirection(Direction.Down);
		move();
		setDirection(Direction.Left);
	}

	public void downRight(){
		setDirection(Direction.Down);
		move();
		setDirection(Direction.Right);
	}

	public boolean isInvinsible() {
		return invinsible;
	}

	public void setInvinsible(boolean invinsible) {
		this.invinsible = invinsible;
	}

	@Override
	public void move() {
		if (body.size() >= 1) {
			Coordinate current = body.get(body.size() - 1);
			Coordinate next = new Coordinate(current.getX() + direction.getX(), current.getY() + direction.getY());
			body.add(next);
			body.remove(0);
		}
	}

	public void tirtoucheSerpent(Tir tir) {
		if(tir.detruitSerp(this) == true) {
			tir.posY = -1; // on tue le tir
			body.remove(0);
		}
	}

	/* (non-Javadoc)
	 * @see snake.ISnake#isAlive()
	 */
	@Override
	public boolean isAlive() {
		return alive;
	}

}
