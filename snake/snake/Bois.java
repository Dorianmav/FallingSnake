package snake;

public class Bois {

    private Coordinate position;

    private boolean alive;

    public Bois(Coordinate position){

        this.position = position;
        this.alive = true;
    }

    public void step(ISnake snake) {
        if (alive) {
            if(snake.getHead().equals(position)) {
                alive = false;
                if (snake.getDirection() == Direction.Left){
                    snake.downRight();
                }
                else if (snake.getDirection() == Direction.Right){
                    snake.downLeft();
                }
            }
        }
    }

    public Coordinate getPosition() {
        return position;
    }

    public boolean isAlive() {
        return alive;
    }

}
