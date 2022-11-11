package snake;

import java.util.ArrayList;
import java.util.List;

public class SnakeObservable implements ISnake{
	
	private Snake snake;
	private List<SnakeObserver> observers;	

	public SnakeObservable(Game game, Coordinate c) {
		snake = new Snake(game, c);
		observers = new ArrayList<>();
	}

	@Override
	public Direction getDirection() {
		return snake.getDirection();
	}

	@Override
	public void setDirection(Direction direction) {
		snake.setDirection(direction);		
	}

	@Override
	public List<Coordinate> getBody() {		
		return snake.getBody();
	}

	@Override
	public boolean isAlive() {		
		return snake.isAlive();
	}
	
	public void register(SnakeObserver o) {
		observers.add(o);
	}

	public void unregister(SnakeObserver o) {
		observers.remove(o);
	}

	void notifyObservers() {
		for (SnakeObserver snakeObserver : observers) {
			snakeObserver.update();
		}
	}

	@Override
	public void move()  {
		snake.move();
		notifyObservers();		
	}

	@Override
	public void addQueue(){snake.addQueue();};

	@Override
	public void downRight(){snake.downRight();}

	@Override
	public void downLeft(){snake.downLeft();}

	@Override
	public boolean isInvinsible() {return snake.isInvinsible();}

	@Override
	public void setInvinsible(boolean invinsible) {snake.setInvinsible(invinsible);}

	public void tirtoucheSerpent(Tir tir) {snake.tirtoucheSerpent(tir);}


}
