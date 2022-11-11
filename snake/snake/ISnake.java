package snake;

import java.util.List;

public interface ISnake {

	Direction getDirection();

	void setDirection(Direction direction);

	List<Coordinate> getBody();

	boolean isAlive();
	
	void move() throws InterruptedException;

	void addQueue();

	void downLeft();

	void downRight();

	boolean isInvinsible();

	void setInvinsible(boolean invinsible);
	
	default public Coordinate getHead() {
		var body = getBody();
		return body.get(body.size()-1);
	}

}