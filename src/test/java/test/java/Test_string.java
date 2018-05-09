package test.java;


import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.Test;

public class Test_string {
	

	
	@Test
	public void test_function(){
		Premier_prog prem=new Premier_prog();
		String verif="This is a string";
		String fonc;
		fonc=prem.init();
		
		if (fonc==null || verif.equals(fonc)==false)
			fail("Ce n'est pas la chaine recherche");
	}
	
	@Test
	public void test_inf_zero_prem_val(){
		Jeu prems=new Jeu();
		int a=-1;
		int b=2;
		if (prems.ajout(a,b)!=false)
			fail("Premire valeur inferieure a 0");		
	}
	

	
	@Test
	public void test_inf_zero_deu_val(){
		Jeu prems=new Jeu();
		int a=1;
		int b=-2;
		if (prems.ajout(a,b)!=false)
			fail("Deuxime valeur inferieure a 0");		
	}
	
	
	@Test
	public void sommelancer_joueur1(){
		Jeu prems=new Jeu();
		int a=1;
		int b=10;
		if (prems.ajout(a,b)!=false)
			fail("Somme superieur a 10");		
	}
	
	@Test
	public void test_sup_10(){
		Jeu prems=new Jeu();
		int a=1;
		int b=2;
		prems.ajout(a, b);
		prems.ajout(a, b);
		prems.ajout(a, b);
		prems.ajout(a, b);
		prems.ajout(a, b);
		prems.ajout(a, b);
		prems.ajout(a, b);
		prems.ajout(a, b);
		prems.ajout(a, b);
		prems.ajout(a,b);
		if (prems.ajout(a,b)!=false)
			fail("Tableau trop grand");		
	}
	
	@Test
	public void sommetotal_joueur1(){
		Jeu prems=new Jeu();
		int res=0;
		int a=1;
		int b=2;
		prems.ajout(a+1, b);
		res+=a+1+b;
		prems.ajout(a, b);
		res+=a+b;
		prems.ajout(a, b);
		res+=a+b;
		prems.ajout(a+4, b);
		res+=a+4+b;
		prems.ajout(a, b);
		res+=a+b;
		prems.ajout(a+7, b);
		res+=a+7+b;
		prems.ajout(a, b);
		res+=a+b;
		prems.ajout(a, b);
		res+=a+b;
		prems.ajout(a, b);
		res+=a+b;
		prems.ajout(a, b);
		res+=a+b;
		if (prems.sommetotal(prems.getLancer1(),prems.getLancer2())!=res){
			fail("Resultat non valide");
		}
	}
	
	
	@Test
	public void tuple_egal_10(){
		Jeu prems=new Jeu();
		int a=8;
		int b=2;
		int res=0;
		prems.ajout(a, b);
		res+=a+b;
		a=2;
		res+=a;
		prems.ajout(a, b);
		assertTrue("Valeur non ajoute pour le spare precedent",(prems.getResult().get(prems.getResult().size()-2))==res);
		
	}
	
	public void premiere_valeur_egal_10(){
		Jeu prems=new Jeu();
		int a=10;
		int b=0;
		int res=0;
		prems.ajout(a, b);
		res+=a+b;
		a=2;b=4;
		res+=a+b;
		prems.ajout(a, b);
		assertTrue("Valeur non ajoute pour le strike precedent",(prems.getResult().get(prems.getResult().size()-2))==res);
		
	}
	
	@Test
	public void spare_de_fin_joueur1(){
		Jeu prems=new Jeu();
		int a=1;
		int b=2;
		prems.ajout(a+1, b);
		prems.ajout(a, b);
		prems.ajout(a, b);
		prems.ajout(a+4, b);
		prems.ajout(a, b);
		prems.ajout(a+7, b);
		prems.ajout(a, b);
		prems.ajout(a, b);
		prems.ajout(a, b);
		a=2;b=8;
		prems.ajout(a, b);
		b=0;
		assertTrue("On aurait du pouvoir ajouter aprs le spare",prems.ajout(a, b));
	}
	
	
	@Test
	public void strike_de_fin_joueur1(){
		Jeu prems=new Jeu();
		int a=1;
		int b=2;
		prems.ajout(a+1, b);
		prems.ajout(a, b);
		prems.ajout(a, b);
		prems.ajout(a+4, b);
		prems.ajout(a, b);
		prems.ajout(a+7, b);
		prems.ajout(a, b);
		prems.ajout(a, b);
		prems.ajout(a, b);
		a=10;b=0;
		prems.ajout(a, b);
		b=1;a=0;
		assertTrue("On aurait du pouvoir ajouter apres le strike",prems.ajout(a, b));
	}
	
	@Test
	public void cas_variable_fini_a_vrai(){
		Jeu j1=new Jeu();
		Jeu j2=new Jeu();
		j1.setName("a");
		j2.setName("b");
		j1.setFini(true);
		j2.setFini(true);
		Partie nouv=new Partie(j1,j2);
		assertTrue("Fin de partie immediate",nouv.lancer());
	}
	
	@Test
	public void cas_nom_deja_entre(){
		Jeu j1=new Jeu();
		Jeu j2=new Jeu();
		j1.setName("a");
		Partie nouv=new Partie(j1,j2);
		assertEquals("a",nouv.nom_joueur(j1,1));
	}
	
	@Test
	public void cas_nom_pas_entre(){
		Jeu j1=new Jeu();
		Jeu j2=new Jeu();
		Partie nouv=new Partie(j1,j2);
		ByteArrayInputStream in = new ByteArrayInputStream("Pierre".getBytes());
		System.setIn(in);
		assertEquals("Pierre",nouv.nom_joueur(j1,1));
	}
	
	@Test
	public void cas_3_erreurs_consecutives(){
		Jeu j1=new Jeu();
		Jeu j2=new Jeu();
		j1.setName("a");
		j2.setName("b");
		Partie nouv=new Partie(j1,j2);
		String input="9 9 9 9 9 9";
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		assertFalse("Trois erreurs consecutives: abandon de la partie",nouv.lancer());
	}
}
