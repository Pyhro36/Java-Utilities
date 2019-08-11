
public class TPManopChaines {
	
	/**
	 * Affiche la chaine de caracteres s verticalement (un caractere par ligne)
	 * @param str la chaine à afficher
	 */
	
	public static void parcourir(String str){
		
		for(int i=0;i<str.length();i++){
			System.out.println(str.charAt(i));
		}
	}
	
	/**
	 * Compte le nbre de fois qu'un caractere c apparait dans une chaine str
	 * @param str la chaine ou chercher c
	 * @param c le caractère recherche
	 * @return Le nombre de fois ou c apparait dans str
	 */
	public static int lettercount(String str, char c){
		
		int count=0;
		for (int i=0;i<str.length();i++){
			if(str.charAt(i)==c) count++;
		}
		
		return count;
	}

	/**
	 * Suppprime toutes les occurences du caractère c fourni en parametre
	 * @param str la chaine ou supprimer les occurences
	 * @param c le caractère a supprimer
	 * @return la nouvelle chaine ne contenant plus le caractere
	 */
	public static String supprChar(String str, char c){
		
		String suppr="";
		for (int i=0;i<str.length();i++){
			suppr+=((str.charAt(i)!=c)? str.charAt(i):"");
		}
		return suppr;
	}
	
	/**
	 * Retire tous les caractères non alpha-numériques d'une String
	 * @param str la String dont on retire tous les non alpha-numériques
	 * @return suppr la String contenant seulement les alpha-numériques
	 */
	
	public static String removeNonAlphaNum(String str){
		
		String suppr="";
		for (int i=0;i<str.length();i++){
			suppr+=((((int)str.charAt(i)>=(int)'0'&&(int)str.charAt(i)<=(int)'9')||((int)str.charAt(i)>=(int)'A'&&(int)str.charAt(i)<=(int)'Z')||((int)str.charAt(i)>=(int)'a'&&(int)str.charAt(i)<=(int)'z')) ? str.charAt(i):"");
		}
		return suppr;
		
	}
	
	/**
	 * Supprime les doublons d'un char passé en paramètre d'une String
	 * @param str la String dont on supprime les doublons
	 * @param c le char dont les doublons sont à supprimer
	 * @return suppr la String sans les doublons
	 */
	
	public static String supprDoublons(String str, char c){
		
		String suppr=""+str.charAt(0);
		for (int i=1;i<str.length();i++){
			suppr+=((str.charAt(i)!=str.charAt(i-1)||str.charAt(i)!=c) ? str.charAt(i):"");
		}
		return suppr;
	}
	
	/**
	 * Compte le nombre de mots dans une String ne contenant que des Alphanum et des espaces
	 * @param str la String dont on compte le nombre gde mots
	 * @return ctn l'int nombre de mot dans la String
	 */
	
	public static int wordCount(String str){
		
		int ctn=(str.length()>0) ? 1:0;
		String sup=supprDoublons(str,' ');
		for (int i=1;i<sup.length()-1;i++){
			ctn+=((sup.charAt(i)==' ')? 1:0);
		}
		
		return ctn;
	}
	
	/**
	 * Retourne une String dans le sens inverse de la String passée en paramètres
	 * @param str la String à inverser
	 * @return sup la String inversée
	 */
	
	public static String invertStr(String str){
		
		String sup="";
		for(int i=1;i<=str.length();i++){
			sup+=str.charAt(str.length()-i);
		}
		
		return sup;
		
	}
	
	/**
	 * Vérifie si une String est un palindrome, retourne un boolean
	 * @param str la String à vérifier
	 * @return true si c'est vrai et false si c'est faux
	 */
	
	public static boolean palindrome(String str){
		
		String sup=removeNonAlphaNum(str);
		for(int i=0;i<sup.length()/2;i++){
			if(sup.charAt(i)!=sup.charAt(sup.length()-i-1)) return false;
		}
		
		return true;
	}
	
	/**
	 * Retourne un anagramme d'une String
	 * @param str la String
	 * @return ana l'anagramme retourné en String
	 */
	
	public static String anagramm(String str){
		
		String ana="";
		char c;
		char[] trans = str.toCharArray();
		for(int i=0;i<trans.length;i++){
			int rdm=(int)(Math.random()*(trans.length-1));
			c=trans[rdm];
			trans[rdm]=trans[i];
			trans[i]=c;
		}
		for(int i=0;i<trans.length;i++){
			ana+=trans[i];
		}
	
		return ana; 
		
	}
	
	public static String binToDec(String bin){
		
		int dec=0;
		
		for(int i=0;i<bin.length();i++){
			
			switch (bin.charAt(i)){
				
			case '1':
				dec+= Math.pow(2,bin.length()-1-i);
				break;
			case '0':
				break;
			default : 
				System.out.println("Error-NoBinaryException");
				return null;
			}
		}
		
		System.out.println(bin+"="+dec);
		return String.valueOf(bin);
	}

	public static void main(String[] args) {
		
		String str="azerty";
		char c='e';
		System.out.println(supprChar(str,c));
		System.out.println(removeNonAlphaNum(str));
		System.out.println(supprDoublons(str,'e'));
		System.out.println(wordCount(str));
		System.out.println(invertStr(str));
		System.out.println(palindrome(str));
		System.out.println(anagramm(str));
		binToDec("110110001");

	}

}
