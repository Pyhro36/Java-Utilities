import java.util.Scanner;

public class Binaire {
	
	/**
	 * Transcrit une cha�ne de 0 et 1 repr�sentant un nombre binaire en un tableau de 8 bool�ens �quivalent, le bit de poids fort est le premier bool�en du tableau, si la cha�ne a plus de 8 caract�res, elle est tronqu�e par le d�but
	 * @param str la cha�ne de caract�re de 0 et 1
	 * @return le tableau de 8 bool�ens �quivalent, le bit de poids fort est le premier bool�en du tableau
	 */
	
	public static boolean[] stringToTab(String str){
		
		boolean[] tab=new boolean[8];
		int start=(8-str.length());
		for (int i=start;i<8;i++)
			tab[i]=(str.charAt(i-start)=='1');
		return tab;
	}
	
	/**
	 * Transcrit un tableau de bool�ens repr�sentant un binaire en une cha�ne de 8 0 et 1 �quivalents
	 * @param tab le tableau de bool�ens, le bit de poids fort est le premier bool�en du tableau
	 * @return la ch�ne de caract�res �quivalente
	 */

	public static String tabToString(boolean[] tab){
		
		String str="";
		for (int i=0;i<8;i++)
			str+=tab[i]?'1':'0';
		return str;
	}
	
	/**
	 * Donne la valeur en base 10 de l'entier NON sign� d'un binaire cod� dans une tableau de bool�ens 
	 * @param tab le tableau de bool�ens repr�sentant l'octet, le bit de poids fort est le premier bool�en du tableau
	 * @return int l'entier non sign� en base 10
	 */
	
	public static int getTenNS(boolean[] tab){
		
		int val=0;
		for(int i=0;i<8;i++){
			val+=tab[i]? Math.pow(2,7-i):0;
		}
		return val;
	}
	

	/**
	 * Donne la valeur en base 10 de l'entier SIGNE d'un binaire cod� dans une tableau de bool�ens 
	 * @param tab le tableau de bool�ens repr�sentant le binaire, le bit de poids fort est le premier bool�en du tableau
	 * @return int l'entier sign� en base 10
	 */
	
	public static int getTenS(boolean[] tab){
		
		int val=0;
		if (!tab[0]){
			for(int i=0;i<8;i++){
				val+=tab[i]? Math.pow(2,7-i):0;
			}
			return val;
		}else{
			for(int i=0;i<8;i++){
				val+=ca2(tab)[i]? Math.pow(2,7-i):0;
			}
			return -val;
		}
	}
	
	/**
	 * Effectue la somme de deux binaires, repr�sent�s dans deux tableaux de 8 bool�ens, le bit de poids fort est le premier bool�en du tableau
	 * @param tab1 le tableau de bool�ens repr�sentant le premier terme de la somme, le bit de poids fort est le premier bool�en du tableau
	 * @param tab2 le tableau de bool�ens repr�sentant le deuxi�me terme de la somme, le bit de poids fort est le premier bool�en du tableau
	 * @return le tableau de 8 bool�ens repr�sentant la somme, le bit de poids fort est le premier bool�en du tableau 
	 */
	
	public static boolean[] sum(boolean[] tab1,boolean[] tab2){
		
		boolean[] sum= new boolean[8];
		boolean add=false;
		
		for(int i=7;i>=0;i--){
			sum[i]=(tab1[i]^tab2[i]^add)||(tab1[i]&&tab2[i]&&add);
			add=(tab1[i]&&tab2[i])||(tab1[i]&&add)||(tab2[i]&&add);
		}
		
		return sum;
	}
	
	/**
	 * Retourne le compl�ment � 2 d'un binaire  
	 * @param tab le tableau de bool�ens repr�sentant le binaire, le bit de poids fort est le premier bool�en du tableau
	 * @return le tableau de 8 bool�ens repr�sentant le compl�ment � deux, le bit de poids fort est le premier bool�en du tableau
	 */
	
	public static boolean[] ca2(boolean[] tab){
		
		boolean[] comp=new boolean[8];
		for(int i=0;i<8;i++)
			comp[i]=!tab[i];
		boolean[] ca2={false,false,false,false,false,false,false,true};
		return sum(comp,ca2);
			
	}
	
	/**
	 * Retourne l'octet diff�rence entre deux binaires pass�s en param�tres sous forme de tableau de bool�ens
	 * @param tab1 le tableau repr�sentant le premier terme de la diff�rence, le bit de poids fort est le premier bool�en du tableau 
	 * @param tab2 le tableau repr�sentant le deuxieme terme de la diff�rence, le bit de poids fort est le premier bool�en du tableau
	 * @return le tableau de 8 bool�ens repr�sentant la diff�rence, le bit de poids fort est le premier bool�en du tableau
	 */
	
	public static boolean[] diff(boolean[] tab1, boolean[] tab2){
		
		return sum(tab1,ca2(tab2));
	}
	
	/**
	 * Transcrit un entier sign� en base 10 en un nombre binaire repr�sent� par un tableau de 8 bool�ens
	 * @param n l'entier sign�
	 * @return le tableau de 8 bool�ens repr�sentant le nombre binaire, le bit de poids fort est le premier bool�en du tableau
	 */
	
	public static boolean[] tenTo2(int n){
		
		boolean[] tab=new boolean[8];
		for(int i=7;i>=0;i--){
		
			tab[i]=(n%2==1);
			n=n/2;
		}
		return tab;
		
	}
	
	/**
	 * Retourne l'octet produit entre deux binaires pass�s en param�tres sous forme de tableau de bool�ens
	 * @param tab1 le tableau repr�sentant le premier binaire facteur du produit, le bit de poids fort est le premier bool�en du tableau 
	 * @param tab2 le tableau repr�sentant le deuxieme binaire facteur du produit, le bit de poids fort est le premier bool�en du tableau
	 * @return le tableau de 8 bool�ens repr�sentant le produit, le bit de poids fort est le premier bool�en du tableau
	 */
	
	public static boolean[] prod(boolean[] tab1, boolean[] tab2){
		
		boolean[] prod=new boolean[8];
		boolean[][] sum=new boolean[8][8];
		
		for(int i=7;i>=0;i--){
			
			if(tab2[i]){
				for(int n=i;n>=0;n--)
					sum[i][n]=tab1[n+7-i];
			}
		}
		for(int i=0;i<8;i++)
			prod=sum(prod,sum[i]);
		
		return prod;
	}
	
	/**
	 * Retourne l'octet quotient d'un binaire SIGNE sous forme de tableau de bool�ens par une puissance de 2
	 * @param tab1 le tableau repr�sentant le l'octet dividende du quotient, le bit de poids fort est le premier bool�en du tableau 
	 * @param pow la puissance telle qu'on est dividende = quotient*2^pow + reste
	 * @return le tableau de 8 bool�ens repr�sentant le quotient, le bit de poids fort est le premier bool�en du tableau
	 */
	
	
	public static boolean[] divBy2(boolean[] tab1, byte pow){
		
		boolean[] div=new boolean[8];
		
		for(int n=7-pow;n>=0;n--)
			div[n+pow]=!tab1[0]? tab1[n]: ca2(tab1)[n];
	
		return !tab1[0]? div: ca2(div);
	}
	
	/** M�thode imcompl�te, solution de r�alisation encore non trouv�e
	 * Retourne l'octet quotient entre deux binaires pass�s en param�tres sous forme de tableau de bool�ens
	 * @param tab1 le tableau repr�sentant le dividende du quotient, le bit de poids fort est le premier bool�en du tableau 
	 * @param tab2 le tableau repr�sentant le diviseur du produit, le bit de poids fort est le premier bool�en du tableau
	 * @return le tableau de 8 bool�ens repr�sentant le quotient, le bit de poids fort est le premier bool�en du tableau
	 */
	
	/**
	public static boolean[] Div(boolean[] tab1, boolean[] tab){
		
		boolean[] div=new boolean[8];
		
		for(int i=0;i<8;i--){
			
			if(tab2[i]){
				for(int n=i;n>=0;n--)
					div[n+7-i]=rest[n];
				for(int n=0;n<8;n++)
					rest[n]=
			}
		}
		for(int i=0;i<8;i++)
			div=Diff(div,sum[i]);
		
		return div;
	}
	*/
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		String num1,num2,ans="";
		boolean[] tans=new boolean[8];
		int n=0, p=0;
		System.out.println("Calculatrice binaire, commandes \n + : somme, r�sultat binaire \n - : diffr�rence, r�sultat binaire \n * : produit, r�sultat binaire \n / : division par 2^n (puissance � rentrer lorsque demand�), r�sultat binaire \n convert2 : convertir en base 2 \n convert10NS :convertir en base 10 non sign� \n convert10S :convertir en base 10 sign� \n ans : reprendre dernier r�sultat (attention ne fonctionne pas pour les conversions vers la base 2) \n quit : quitter");
		while(n!=-1){
			
			System.out.println("entrer d'abord la commande pour commencer :");
			String cmd=sc.nextLine();
			switch (cmd){
				
			case "+" :
				
				System.out.println("premier binaire :");
				num1=sc.nextLine();
				System.out.println("deuxi�me binaire :");
				num2=sc.nextLine();
				if (num1=="ans")
					num1=ans;
				if (num2=="ans")
					num2=ans;
				
				tans=sum(stringToTab(num1),stringToTab(num2));
				ans=tabToString(tans);
				System.out.println("="+ans);
				
				break;
				
			case "-" :
				
				System.out.println("premier binaire :");
				num1=sc.nextLine();
				System.out.println("deuxi�me binaire :");
				num2=sc.nextLine();
				if (num1=="ans")
					num1=ans;
				if (num2=="ans")
					num2=ans;
				
				tans=diff(stringToTab(num1),stringToTab(num2));
				ans=tabToString(tans);
				System.out.println("="+ans);
				
				break;
			
			case "*" :
				
				System.out.println("premier binaire :");
				num1=sc.nextLine();
				System.out.println("deuxi�me binaire :");
				num2=sc.nextLine();
				if (num1=="ans")
					num1=ans;
				if (num2=="ans")
					num2=ans;
				
				tans=prod(stringToTab(num1),stringToTab(num2));
				ans=tabToString(tans);
				System.out.println("="+ans);
				
				break;
				
			case "/" :
				
				System.out.println("diviseur :");
				num1=sc.nextLine();
				System.out.println("divis� par 2^n (n>=0) tel que n=");
				n=sc.nextInt();
				if (num1=="ans")
					num1=ans;
				
				tans=divBy2(stringToTab(num1),(byte)n);
				ans=tabToString(tans);
				System.out.println("="+ans);
				
				break;
				
			case "convert2" :
				
				System.out.println("Entrer le d�cimal");
				p=sc.nextInt();
				ans=tabToString(tenTo2(p));
				System.out.println("="+ans);
				
				break;
				
			case "convert10NS" :
				
				System.out.println("Entrer le binaire");
				num1=sc.nextLine();
				p=getTenNS(stringToTab((num1=="ans")? ans : num1));
				System.out.println("="+p);
				
				break;
				
			case "convert10S" :
				
				System.out.println("Entrer le binaire :");
				num1=sc.nextLine();
				p=getTenNS((num1=="ans")? tans : stringToTab(num1));
				System.out.println("="+p);
				
				break;
				
			case "quit" :
				
				n=-1;
				break;
				
			case "ans" :
				
				System.out.println("="+ans);
				
				break;
				
			default :
				
				break;
								
			}
			
		}

		sc.close();
	}

}
