package snake;

import java.awt.*;
import java.awt.event.*;

public class Listener implements KeyListener {

    private Canon canon;
    private Game game;

    public Listener(Canon canon, Game game){
        this.canon = canon;
        this.game = game;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {

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

    @Override
    public void keyReleased(KeyEvent e) {
        canon.setDx(0);
    }
}
