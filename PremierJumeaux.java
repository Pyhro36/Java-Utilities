import java.util.Scanner;

public class PremierJumeaux {

	public static boolean premier(int p){
		for (int i=2;i<=(int)(Math.sqrt(p)+1);i++){
			if (p%i==0)
				return false;
		}
		return true;
	}
	
	public static boolean sontJumeaux(int p,int q){
		if (premier(p)&&premier(q)&&(q==p+2))
			return true;
		
		else
			return false;
	}
	
	public static double propJumeaux(int n){
		double up=Math.pow(10,n);
		int count=0;
		for (int i=2;i<=up;i++){
		/*on doit exclure 1 du test car il vérifie la condition donnée 
		dans la méthode premier mais n'est pas un nombre premier */
			if (sontJumeaux(i,i+2)){
				/* en fait avec cette condition on se rend compte qu'on peut fusionner 
				 * cette méthode avec sontJumeaux pour alléger la classe
				 * [ if ((premier(i)==true)&&(premier(i+2)==true)){ ] fonctionne et
				 * permet de se passer de la classe sontJumeaux
				 */
				count=count+2;
			}
		}	
		count=count-1;//ceci permet de ne pas compter deux fois 5 qui est le seul nombre "triplé"
		return count/up*100; // on donne la proportion en pourcentage
	}
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("on teste la proportion de ombres premiers jumeaux sur intervalles [1,10^n] tel que n=");
		int n=sc.nextInt();
		sc.close();
		for(int i=1;i<=n;i++){
			System.out.println("Dans l'intervale [1;10^"+i+"] il y a "+propJumeaux(i)+"% de nombres jumeaux ");
		}

	}

}
