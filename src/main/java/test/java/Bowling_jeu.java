package test.java;

public class Bowling_jeu {

	
	
	public static void main(String[] args) {
		boolean result;
		System.out.println("Jeu de Bowling : deux joueurs");
		Jeu joueur1=new Jeu();
		Jeu joueur2=new Jeu();
		Partie bowl=new Partie(joueur1,joueur2);
		result=bowl.lancer();
		if (result)
			System.out.print("Partie terminee");
		else
			System.out.print("Trop d erreur de l'utilisateur: abandon de la partie");
	}

}
