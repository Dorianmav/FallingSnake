package snake;

public class Myrtille {

    private Coordinate position;

    private boolean alive;

    public Myrtille(Coordinate position){

        this.position = position;
        this.alive = true;
    }

    public void step(ISnake snake) {
        if (alive) {
            if(snake.getHead().equals(position)) {
                alive = false;
                snake.setInvinsible(true);

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
