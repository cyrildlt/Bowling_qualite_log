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
		
		sc = new Scanner(System.in);
		System.out.println("Comment se nomment les joueurs");
		System.out.print("Joueur1:");
		//String joueur_name=sc.nextLine();
		joueur1.setName("marie");
		System.out.print("Joueur2:");
		//joueur_name=sc.nextLine();
		joueur2.setName("pierre");
		while ((!joueur1.isFini()) || (!joueur2.isFini())){
			System.out.println("Resultat du lancer"+i);
			if (!joueur1.isFini()){
				System.out.print(joueur1.getName()+" (lancer 1,lancer 2) :");
				//lancer_1=sc.nextInt();
				//lancer_2=sc.nextInt();
				while(!joueur1.ajout(4, 10)){
					nb_fautes+=1;
					System.out.print("Valeur Impossible");
					System.out.print(joueur1.getName()+" (lancer 1,lancer 2) :");
					//lancer_1=sc.nextInt();
					//lancer_2=sc.nextInt();	
					
					if (nb_fautes>=2)
						return false;
				}
				nb_fautes=0;
			}
			if (!joueur2.isFini()){
				nb_fautes+=1;
				System.out.print(joueur2.getName()+" (lancer 1,lancer 2) :");
				//lancer_1=sc.nextInt();
				//lancer_2=sc.nextInt();
				while(!joueur2.ajout(4, 10)){
					System.out.print("Valeur Impossible");
					System.out.print(joueur2.getName()+" (lancer 1,lancer 2) :");
					//lancer_1=sc.nextInt();
					//lancer_2=sc.nextInt();
					
					if (nb_fautes>=2)
						return false;
					}
				nb_fautes=0;
			}

			i+=1;
		}
		return true;
	}
}
