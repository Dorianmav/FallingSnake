package snake;

import javax.swing.*;
import java.awt.*;

public class Tir extends Entite {
	
	private boolean vaisseauTire = false;
	public Coordinate position;

	public Tir() {
		super.posX = 30000000;
		super.posY = Constantes.POS_Y_INIT_VAISSEAU - Constantes.HAUTEUR_TIR;
		super.largeur = Constantes.LARGEUR_TIR;
		super.hauteur = Constantes.HAUTEUR_TIR;
		super.dx = 0;
		super.dy = Constantes.DY_TIR;

		
		position = new Coordinate(posX , posY);
	}
	
	/*****************
	 *** METHODES ***
	 *****************/
	public boolean isVaisseauTire() {
		return vaisseauTire;
	}
	
	public void setVaisseauTire(boolean vaisseauTire) {
		this.vaisseauTire = vaisseauTire;
	}
	
	//deplacement du tir en Y
	public int deplacementTir(){
		if(this.vaisseauTire == true) {
			if(this.posY > 0) {
				this.posY = this.posY - Constantes.DY_TIR;
			}
			else{
				this.vaisseauTire = false;
				}
			}
		return posY;
	}
	
	//permet de dessiner le tir du canon dans le paint
	public void dessinTirVaisseau(Graphics g) {
		if(this.vaisseauTire == true) {
			g.drawImage(this.img, this.posX, this.deplacementTir(),null);
		}
		
	}
	
	public boolean detruitSerp(Snake Serp) {
		boolean reponse = false;
		if(!Serp.isInvinsible()) {
			if(Serp.getBody().size() == 1
				&& ((this.posY/10 == Serp.getHead().getY() 
				||this.posY/10 == Serp.getHead().getY() - 1
				||this.posY/10 == Serp.getHead().getY() + 1) 
				&& (this.posX /10 == Serp.getHead().getX() 
				||this.posX /10 == Serp.getHead().getX() - 1 
				||this.posX /10 == Serp.getHead().getX() + 1))) {
					reponse = true;
			}
		else {reponse = false;}
		}
		for(int i = 0; i<Serp.getBody().size(); i++) {
			if(!Serp.isInvinsible()) {
				if((this.posY/10 == Serp.getBody().get(i).getY() 
						||this.posY/10 == Serp.getBody().get(i).getY() - 1
						||this.posY/10 == Serp.getBody().get(i).getY() + 1) 
						&& (this.posX /10 == Serp.getBody().get(i).getX() 
						||this.posX /10 == Serp.getBody().get(i).getX() - 1 
						||this.posX /10 == Serp.getBody().get(i).getX() + 1)) {
					reponse = true;
					break;
				
			}
				else {reponse = false;}
		
				if((this.posY/10 == Serp.getHead().getY() 
						||this.posY/10 == Serp.getHead().getY() - 1
						||this.posY/10 == Serp.getHead().getY() + 1) 
						&& (this.posX /10 == Serp.getHead().getX() 
						||this.posX /10 == Serp.getHead().getX() - 1 
						||this.posX /10 == Serp.getHead().getX() + 1)) {
					reponse = true;
					break;
					}
				else {reponse = false;}
		
		
		}
	}
	return reponse;
}
	
	public boolean step(ISnake snake) {
		if(snake.getBody().equals(position)) {
				System.out.println("touché");
				return true;
			}
		return false;
		}
}
