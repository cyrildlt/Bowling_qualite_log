package test.java;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Partie {
	Jeu joueur1,joueur2;
	private   Scanner sc;
	public Partie(Jeu j1,Jeu j2){
		joueur1=j1;
		joueur2=j2;
	}
	
	boolean lancer(){
		int lancer_1,lancer_2,nb_fautes=0,i=1;
		int score1, score2;
		sc = new Scanner(System.in);
		nom_joueur(joueur1,1);
		nom_joueur(joueur2,2);
		while ((!joueur1.isFini()) || (!joueur2.isFini())){
			System.out.println("Resultat du lancer "+i+" :");
			if (!joueur1.isFini()){
				System.out.println(joueur1.getName()+" [lancer 1]: ");
				lancer_1=sc.nextInt();
				System.out.println(joueur1.getName()+" [lancer 2]: ");
				lancer_2=sc.nextInt();
				while(!joueur1.ajout(lancer_1, lancer_2)){
					nb_fautes+=1;
					if (nb_fautes>=3)
						return false;
					System.out.println("Valeur Impossible");
					System.out.println(joueur1.getName()+" [lancer 1]: ");
					lancer_1=sc.nextInt();
					System.out.println(joueur1.getName()+" [lancer 2]: ");
					lancer_2=sc.nextInt();	

				}
				nb_fautes=0;
			}
			if (!joueur2.isFini()){
				
				System.out.println(joueur2.getName()+" [lancer 1]: ");
				lancer_1=sc.nextInt();
				System.out.println(joueur2.getName()+" [lancer 2]: ");
				lancer_2=sc.nextInt();
				while(!joueur2.ajout(lancer_1, lancer_2)){
					nb_fautes+=1;
					if (nb_fautes>=3)
						return false;
					System.out.println("Valeur Impossible");
					System.out.println(joueur2.getName()+" [lancer 1]: ");
					lancer_1=sc.nextInt();
					System.out.println(joueur2.getName()+" [lancer 2]: ");
					lancer_2=sc.nextInt();
				}
				nb_fautes=0;
			}

			i+=1;
		}
		score1=joueur1.sommetotal(joueur1.getLancer1(), joueur1.getLancer2());
		score2=joueur2.sommetotal(joueur2.getLancer1(), joueur2.getLancer2());
		System.out.println("Score de "+joueur1.getName()+" :"+ score1 );
		System.out.println("Score de "+joueur2.getName()+" :"+ score2 );
		if (score1>score2)
			System.out.println(joueur1.getName()+" a gagne" );
		else if (score1<score2)
			System.out.println(joueur2.getName()+" a gagne" );
		else
			System.out.println("Pas de gagnant" );
		return true;
	}
	
	public String nom_joueur(Jeu j,int i){
		sc = new Scanner(System.in);
		while (j.getName().equals("")){
			System.out.println("Nom Joueur"+i+":");
			String joueur_name=sc.nextLine();
			while(!Pattern.matches("[a-zA-Z]*", joueur_name)){
				System.out.println("Valeur non autorisee");
				System.out.println("Nom Joueur"+i+":");
				joueur_name=sc.nextLine();
			}
			j.setName(joueur_name);
		}	
		return j.getName();
	
	}
}
