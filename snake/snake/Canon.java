package snake;


import javax.swing.*;


public class Canon extends Entite{
	
	private Game game;
	private boolean alive;
	
	/****************
	 **Constructeur**
	 ****************/
	
	public Canon() {
		//Initialisation des variables de la super classe
		super.posX = Constantes.POS_X_INIT_VAISSEAU;
		super.posY = Constantes.POS_Y_INIT_VAISSEAU;
		super.largeur = Constantes.LARGEUR_VAISSEAU;
		super.hauteur = Constantes.HAUTEUR_VAISSEAU;
		super.dx = 0;
		super.dy = 0;
		
	}
	
	/****************
	 ****Méthodes****
	 ****************/
	public int deplacementVaisseau() {
		// Renvoie la nouvelle position du vaisseau après déplacement éventuel
		if(this.dx < 0){
			if(this.posX > Constantes.LIMITE_GAUCHE_VAISSEAU) {
				this.posX = this.posX + this.dx;
				}
			}
		else if(dx > 0) {
			if(this.posX + this.dx < Constantes.LIMITE_DROITE_VAISSEAU) {
				this.posX = this.posX + this.dx;
				}
			}
		return this.posX;
	}

	
}
