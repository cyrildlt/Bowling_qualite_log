package test.java;


import java.util.ArrayList;

public class Jeu {
	ArrayList<Integer> lancer1;
	ArrayList<Integer> lancer2;
	ArrayList<Integer> result;
	boolean spare,strike;
	int nb_coup;
	
	

	public Jeu(){
		lancer1=new ArrayList<Integer>();
		lancer2=new ArrayList<Integer>();
		result=new ArrayList<Integer>();
		spare=false;
		strike=false;
		nb_coup=10;
	}
	
	public boolean isSpare() {
		return spare;
	}

	public void setSpare(boolean spare) {
		this.spare = spare;
	}

	public boolean isStrike() {
		return strike;
	}

	public void setStrike(boolean strike) {
		this.strike = strike;
	}

	public int getNb_coup() {
		return nb_coup;
	}

	public void setNb_coup(int nb_coup) {
		this.nb_coup = nb_coup;
	}

	public int somme(int i){
		int som=0;
		if (spare==true){
			result.add(10+lancer1.get(i));
			spare=false;
		}
		if (i>=lancer1.size())
			return som;
		som=lancer1.get(i)+lancer2.get(i);

		if (strike==true){
			result.add(10+som);
			strike=false;
		}
		
		if (lancer1.get(i)==10){
			strike=true;
			if(result.size()==nb_coup-1 && nb_coup<11){
				nb_coup+=1;
			}
		}
		else if (som==10){
			spare=true;
				if(result.size()==nb_coup-1 && nb_coup<11){
					nb_coup+=1;
				}
		}
		else{
			if (nb_coup!=11)
				result.add(som);
		}
		return som;
	}
	
	public int sommetotal(ArrayList<Integer> a,ArrayList<Integer> b){
		int som=0;
		for(int i =0;i<a.size();i++){
			som+=a.get(i)+b.get(i);
		}
		return som;
	}
	
	public ArrayList<Integer> getLancer1() {
		return lancer1;
	}

	public void setLancer1(ArrayList<Integer> lancer1) {
		this.lancer1 = lancer1;
	}

	public ArrayList<Integer> getLancer2() {
		return lancer2;
	}

	public void setLancer2(ArrayList<Integer> lancer2) {
		this.lancer2 = lancer2;
	}

	public ArrayList<Integer> getResult() {
		return result;
	}

	public void setResult(ArrayList<Integer> result) {
		this.result = result;
	}

	public boolean ajout(int j1,int j2){
	   if ((j1+j2)>10 || j1<0 || j2<0 || lancer1.size()>(nb_coup-1)  || lancer2.size()>(nb_coup-1) )  
		   return false;
	   if (nb_coup==11 && spare==true && j2!=0)  
		   return false;
	   lancer1.add(j1);
	   lancer2.add(j2);
	   somme(lancer1.size()-1);
	   return true;
	}
}
