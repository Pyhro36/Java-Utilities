
public class Tri {
	
	/**
	 * Echange les positions de deux �l�ments d'un tableau d'entiers d'indices pass�es en param�tres
	 * @param tab le tableau d'entiers
	 * @param ind1 le premier indice
	 * @param ind2 le second indice
	 */
	
	public static void echangePositions(int[] tab, int ind1, int ind2){
		
		int buff=tab[ind1];
		tab[ind1]=tab[ind2];
		tab[ind2]=buff;
	}
	
	/**
	 * M�thode pour l'indice d'un tableau correspondant � la valeur la plus haute � partir de l'indice p
	 * @param tab le tableau de probabilit�s
	 * @param p l'indice � partir duquel on recherche la valeur la plus haute
	 * @return indMax l'indice ayant la valeur la plus haute
	 * pour obtenir cette probabilit�, il suffit de demander tab[indMax]
	 */
	
	public static int positionPlusPetit(int[] tab, int p){
		
		int indMin=p;
		int valMin=tab[p];
		
		for (int i=p+1;i<tab.length;i++){
			
			if(tab[i]<valMin){
				valMin=tab[i];
				indMin=i;
			}
		
		}
		return indMin;
	}
	
	/**
	 * Tri un tableau par la m�thode de s�lection
	 * @param tab le tableau d'entiers � trier
	 */
	
	public static void selectSort(int[] tab){
		
		for(int p=0;p<tab.length;p++){
			int h=positionPlusPetit(tab,p);
			if(h!=p) echangePositions(tab,p,h);
		}
	}
	
	/** 
	 * M�thode d'affichage d'un tableau d'entiers 
	 * @param tab Tableau d'entiers � afficher 
	 */
	
	public static void disp(int[] tab){
		
		for (int i=0; i<tab.length;i++){
			System.out.println(tab[i]);
		}
	}
	
	/**
	 * Trie un tableau d'entiers par la m�thode du tri � bulle simple
	 * @param tab le tableau d'entiers � trier
	 */
	
	public static void bubbleSortV1(int[] tab){
		
		for (int i=0;i<tab.length;i++){
			for (int d=0;d<tab.length-1;d++){
				if(tab[d]>tab[d+1])
					echangePositions(tab,d,d+1);
			}
		}
	}
	
	/**
	 * Trie un tableau d'entiers par la m�thode du tri � bulle am�lior�e
	 * @param tab le tableau d'entiers � trier
	 */
	
	public static void bubbleSortV2(int[] tab){
		
		for (int i=0;i<tab.length;i++){
			for (int d=0;d<tab.length-1-i;d++){
				if(tab[d]>tab[d+1])
					echangePositions(tab,d,d+1);
			}
		}
	}
	
	/**
	 * Methode de triage rapide d'un tableau d'entiers
	 * @param tab le tableau d'entiers 
	 * @param first=0
	 * @param last=(la taille du tableau)-1
	 */
	
	public static void quickSort(int[] tab, int first, int last){
		
		if (first<last){
			
			int pivot=partition(tab,first,last);

			if (first<pivot-1)
				quickSort(tab,first,pivot-1);
			if(pivot<last)
				quickSort(tab,pivot,last);
			
		}
		
	}
	
	/**
	 * M�thode annexe � la m�thode de triage rapide
	 * @param tab
	 * @param first
	 * @param last
	 * @return new_pivot
	 */

	private static int partition(int[] tab, int first, int last) {
		
		int pivot=tab[(last+first)/2];
		
		while (first<=last){
			
			while(tab[first]<pivot){
				first++;
			}
			while(tab[last]>pivot){
				last--;
			}
			if(first<=last){
				
				echangePositions(tab,first,last);
				first++;
				last--;
			}
		}
		return first;
	}

	public static void main(String[] args) {
		
		int[] tab={1,12,2,2,5,26,7,134,14,3,7,2,2,2};
		quickSort(tab,0,tab.length-1);
		disp(tab);

	}

}
