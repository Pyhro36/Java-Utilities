import java.util.Scanner;

public class HistoJumeaux {

	public static void afficheProp(double p, int n){
		System.out.print("[1;10^"+n+"]");
		for(int i=1;i<=(int)p;i++){
			System.out.print("*");
		}
		System.out.println();
	}
	
	public static void afficheHisto(int n){
		for (int i=1;i<=n;i++){
			afficheProp(PremierJumeaux.propJumeaux(i),i);
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Diagramme de la proportion de nombres jumeaux dans les intervalles [1;10] à [1;10^n] ou n=");
		int n=sc.nextInt();
		sc.close();
		afficheHisto(n);
	}

}
