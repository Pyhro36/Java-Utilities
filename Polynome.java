import java.util.Scanner;

public class Polynome {
	
	public static String polyToString(int[] poly){
		
		String str="";
		
		for(int i=99;i>=1;i--){
			
			if(poly[i]!=0){
				
				str+='('+String.valueOf(poly[i])+')'+"x^"+String.valueOf(i);
				str+=(str!="")?" +":"";
			}
			
		}
		
		str+=(poly[0]!=0)?"("+String.valueOf(poly[0])+')':"";
		return str;
	}
	
	public static int degre(int[] poly){ //la méthode retourne un degré de -1 au lieu de -infini s'il sagit du polynôme nul
		
		int deg=99;
		while((poly[deg]==0)&&(deg>0))
			deg--;
		
		if (deg==0){
			deg=(poly[0]==0)? -1:0; 
		}
		return deg;
	}
	
	public static int[] derivee(int[] poly){
		
		int[] der=new int[100];
		
		for(int i=0;i<99;i++){
			
			der[i]=poly[i+1]*(i+1);
		}
		
		return der;
	}
	
	public static String[] deriveMulti(int[] poly){
		
		String[] derivees=new String[degre(poly)+1];
		int[] der=poly.clone();
		for(int i=0;i<=degre(poly);i++){
			
			for(int n=0;n<100;n++)
				der[n]=derivee(der)[n];
			
			derivees[i]=polyToString(der);	
		
		}
		
		return derivees;
	}
	
	public static double eval(int[] poly, double z){
		
		double pz=0;
		
		for(int i=0;i<100;i++){
			
			pz+=(double)poly[i]*Math.pow(z,i);
		}
		
		return pz;
	}
	
	public static double[] evalMulti(int[] poly, double[] z){
		
		double[] p=new double[z.length];
		
		for(int i=0;i<z.length;i++){
			
			p[i]=eval(poly,z[i]);
			
		}
		
		return p;
	}
	
	public static int[] plus(int[] p1, int[] p2){
		
		int[] sum=new int[100];
		
		for(int i=0;i<100;i++){
			
			sum[i]=p1[i]+p2[i];
			
		}
		
		return sum;
	}
	
	public static int[] foisEntier(int[] poly, int n){
		
		int[] prod=new int[100];
		
		for(int i=0;i<100;i++){
			
			prod[i]=poly[i]*n;
			
		}
		
		return prod;
	}
	
	public static int[] fois(int[] p1, int[] p2){
		
		int[] prod=new int[100];
		
		return prod;
	}

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int[] p1=new int[100];
		int[] p2=new int[100];
		
		System.out.println("Premier polynôme : \nChoisir le degré du polynôme (entre 0 et 99, -1 si le polynôme est nul):");
		int deg=sc.nextInt();
		switch (deg){
		
		case -1 :
				
			System.out.println("polynôme nul,");
			
			break;
			
		case 0 : 
			
			System.out.println("polynôme du type a0, rentrez le seul coefficient a0=");
			p1[0]=sc.nextInt();
			
			break;
			
		case 1 : 
			
			System.out.println("polynôme du type a1*x+a0, rentrez les coefficients\na0=");
			p1[0]=sc.nextInt();
			System.out.println("a1=");
			p1[1]=sc.nextInt();
			
			break;
			
		case 2 : 
			
			System.out.println("polynôme du type a2*x²+a1*x+a0, rentrez les coefficients\na0=");
			p1[0]=sc.nextInt();
			System.out.println("a1=");
			p1[1]=sc.nextInt();
			System.out.println("a2=");
			p1[2]=sc.nextInt();
			
			break;
			
		default :
			
			System.out.println("polynôme du type a"+deg+"*x^"+deg+"+...+a2*x²+a1*x+a0, rentrez les coefficients");
			for(int i=0;i<=deg;i++){
				System.out.println("a"+i+"=");
				p1[i]=sc.nextInt();
				
			}
			
			break;
		}
		
		System.out.println("Que souhaitez-vous faire à partir de ce polynôme : \n" +
				"(0) afficher son degré \n" +
				"(1) le dériver\n" +
				"(2) le dériver de facon multiple\n" +
				"(3) l'évaluer en un point\n" +
				"(4) l'évaluer en un ensemble de points\n"+
				"(5) l'additionner à un autre polynôme\n"+
				"(6) le multiplier par un réel\n"+
				"ou (7) le multiplier à un autre polynôme ?\n"+
				"Entrer le chiffre correspondant au traitement");
	}

}
