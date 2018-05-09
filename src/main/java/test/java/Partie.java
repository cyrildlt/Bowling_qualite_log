package test.java;

import java.util.Scanner;

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
		String joueur_name="";
		sc = new Scanner(System.in);
		System.out.println("Comment se nomment les joueurs");
		System.out.println("Joueur1:");
		//joueur_name=sc.nextLine();

		joueur1.setName("ajd");
		System.out.println("Joueur2:");
		//joueur_name=sc.nextLine();
		joueur2.setName("piere");
		while ((!joueur1.isFini()) || (!joueur2.isFini())){
			System.out.println("Resultat du lancer "+i+" :");
			if (!joueur1.isFini()){
				System.out.println(joueur1.getName()+" (lancer 1,lancer 2) :");
				lancer_1=sc.nextInt();
				lancer_2=sc.nextInt();
				while(!joueur1.ajout(lancer_1, lancer_2)){
					nb_fautes+=1;
					System.out.println("Valeur Impossible");
					System.out.println(joueur1.getName()+" (lancer 1,lancer 2) :");
					lancer_1=sc.nextInt();
					lancer_2=sc.nextInt();	
					
					if (nb_fautes>=2)
						return false;
				}
				nb_fautes=0;
			}
			if (!joueur2.isFini()){
				
				System.out.print(joueur2.getName()+" (lancer 1,lancer 2) :");
				lancer_1=sc.nextInt();
				lancer_2=sc.nextInt();
				while(!joueur2.ajout(lancer_1, lancer_2)){
					nb_fautes+=1;
					System.out.println("Valeur Impossible");
					System.out.println(joueur2.getName()+" (lancer 1,lancer 2) :");
					lancer_1=sc.nextInt();
					lancer_2=sc.nextInt();
					
					if (nb_fautes>=2)
						return false;
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
			System.out.println(joueur1.getName()+" a gagné" );
		else if (score1<score2)
			System.out.println(joueur2.getName()+" a gagné" );
		else
			System.out.println("Pas de gagnant" );
		return true;
	}
}
