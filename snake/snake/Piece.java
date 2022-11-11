package snake;

public class Piece {

    private Coordinate position;
    private boolean alive;

    public Piece(Coordinate position){

        this.position = position;
        this.alive = true;
    }

    public void step(Game game, ISnake snake) {
        if (alive) {
            if(snake.getHead().equals(position)) {
                alive = false;
                System.out.println("touché");
                game.clean();
                game.addBois();
                game.addFraise();
                game.addMyrtille();
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
