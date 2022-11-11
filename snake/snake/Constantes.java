package snake;

public class Constantes {
	
	/***********
	 **fenêtre** 
	 ***********/
	
	public static final int LARGEUR_FENETRE = 500;
	public static final int HAUTEUR_FENETRE = 500;
	public static final int MARGE_FENETRE = 50;
	
	/***********
	 ** Canon **
	 **********/
	//dimensions canon
	public static final int LARGEUR_VAISSEAU = 100;
	public static final int HAUTEUR_VAISSEAU = 100;
	
	//pos initial canon
	public static final int POS_X_INIT_VAISSEAU = (LARGEUR_FENETRE - LARGEUR_VAISSEAU) / 2;
	public static final int POS_Y_INIT_VAISSEAU = 420;
	
	//unité de déplacement du canon
	public final static int DX_VAISSEAU = 10;
	
	//limites de déplacement du canon
	public final static int LIMITE_GAUCHE_VAISSEAU = 10;
	public final static int LIMITE_DROITE_VAISSEAU = 480;
	 
	
	/**********
	 ** BOIS **
	 **********/
	//dimensions Bois
	public static final int LARGEUR_BOIS = 33;
	public static final int HAUTEUR_BOIS = 25;
		
	//pos initial Bois
	public static final int ALT_INIT_BOIS = 120;
	public static final int POS_X_INIT_BOIS = 29 + MARGE_FENETRE;
	
	/************
	 ** Serpent**
	 ************/
	
	//dimensions serpent
	public static final int LARGEUR_SERP = 33;
	public static final int HAUTEUR_SERP = 25;
	
	//Parametre de position du serpent
	public static final int ALT_INIT_SERP = 40;
	public static final int POS_X_INIT_SERP = 10 + MARGE_FENETRE;
	public static final int ECART_LIGNES_SERP = 1;
	public final static int ECART_COLONNES_SERP = 0; 
	
	// Unité de déplacement du serpent
	public static final int DX_SERP = 1;
	public static final int DY_SERP = 25;
		
	/*********
	 ** TIR **
	 *********/
	//dimensions Tir
	public static final int LARGEUR_TIR = 3;
	public static final int HAUTEUR_TIR = 13;
	//unité de déplacement du canon
	public final static int DY_TIR = 15;
			
}
