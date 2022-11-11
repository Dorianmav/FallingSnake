package snake;

public class Fraise {

	private Coordinate position;
	private boolean alive;
	
	public Fraise(Coordinate position) {

		this.position = position;
		this.alive = true;
	}
		
	public void step(ISnake snake) {
		if (alive) {
			if(snake.getHead().equals(position)) {
				alive = false;
				snake.addQueue();
			}
		}
	}

	public boolean isAlive() {		
		return alive;
	}

	public Coordinate getPosition() {
		return position;
	}

}
