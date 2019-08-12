/**
 * Classe de construction d'une fraction, representee par son numerateur et son denominateur 
 * @author Pierre-Louis
 * @version 1.0
 */

public class Fraction {
	
	private int numerateur ;
	private int denominateur ;
	
	/**
	 * constructeur par defaut de fraction : la fraction vaut 0 (0/1)
	 */
	
	public Fraction(){
		
		this.numerateur = 0;
		this.denominateur = 1;
		
	}
	
	/**
	 * constructeur parametre de fraction
	 * @param numerateur le numerateur de la fraction
	 * @param denominateur le denominateur de la fraction
	 */
	
	public Fraction(int numerateur, int denominateur){
		
		this.numerateur = numerateur;
		this.denominateur = denominateur;
		this.simplifier();
	}
	
	/**
	 * affichage de la fraction : retourne la fraction sous la forme numerateur/denominateur
	 */
	
	public String toString(){
		
		String fraction = "";
		
		if(this.numerateur != 0 && this.denominateur != 0 && this.denominateur != 1){
			
			fraction = String.valueOf(this.numerateur) + "/" + String.valueOf(this.denominateur);  
		
		} else if(this.numerateur == 0){
			
			if(this.denominateur == 0){
				
				fraction = "indefini";
				
			} else {
				
				fraction = "0" ;
						
			}
			
		} else if(this.denominateur == 1){
			
			fraction = String.valueOf(this.numerateur);
		} else if(this.denominateur == 0) {
			
			fraction = "infini";
			
		}
		
		return fraction;
	}
	
	public int getNumerateur(){
		
		return this.numerateur;
	}
	
	public int getDenominateur(){
		
		return this.denominateur;
	}
	
	/**
	 * evaluation de la valeur approchee de la fraction
	 * @return la valeur approchee de la fraction
	 */
	
	public double evalF(){
		
		double eval = 0.0;
		
		if(this.denominateur != 0){
			
			eval = (double)this.numerateur / (double)this.denominateur ;
			
		}
		
		return eval;
	}
	
	/**
	 * calcul du pgcd du numerateur de du denominateur
	 * @return le pgcd
	 */
	
	private int pgcd(){
		
		int a, b, reste;
		a = this.numerateur;
		b = this.denominateur;
		
		while (b != 0){
			
			reste = a % b;
			a = b;
			b = reste;
			
		}
		
		return a;
	}
	
	/**
	 * simplifie la fraction a l'aide du pgcd
	 */
	
	public void simplifier(){
		
		if(this.denominateur == 0 || this.numerateur == 0)
		 
			return;
		
		int pgcd = pgcd();
		this.numerateur = (this.numerateur / pgcd);
		this.denominateur = (this.denominateur / pgcd);
		
		if (this.denominateur < 0){
			
			this.numerateur = - this.numerateur;
			this.denominateur = - this.denominateur;
		}
		
	}
	
	/**
	 * multiplication de la fraction avec une autre
	 * @param fr2 l'autre fraction
	 * @return le produit sous forme d'une nouvelle instanciation de fraction
	 */
	
	public Fraction multiplier(Fraction fr2){
		
		Fraction produit = new Fraction((this.numerateur * fr2.getNumerateur()), (this.denominateur * fr2.getDenominateur()));	
		produit.simplifier();
		
		return produit;
	}
	
	/**
	 * addition de la fraction avec une autre
	 * @param fr2 l'autre fraction
	 * @return la somme sous forme d'une nouvelle instanciation de fraction
	 */
	
	public Fraction ajouter(Fraction fr2){
		
		Fraction somme = new Fraction((this.numerateur * fr2.getDenominateur()) + (this.denominateur * fr2.getNumerateur()), (this.denominateur * fr2.getDenominateur()));
		somme.simplifier();
		
		return somme;
	}
	
	/**
	 * soustraction de la fraction par une autre
	 * @param fr2 l'autre fraction
	 * @return la difference sous forme d'une nouvelle instanciation de fraction
	 */
	
	public Fraction soustraire(Fraction fr2){
		
		Fraction difference = new Fraction((this.numerateur * fr2.getDenominateur()) - (this.denominateur * fr2.getNumerateur()), (this.denominateur * fr2.getDenominateur()));
		difference.simplifier();
		
		return difference;
	}
	
	/**
	 * division de la fraction par une autre
	 * @param fr2 l'autre fraction
	 * @return le quotient sous forme d'une nouvelle instanciation de fraction
	 */
	
	public Fraction diviser(Fraction fr2){
		
		Fraction quotient = new Fraction((this.numerateur * fr2.getDenominateur()), (this.denominateur * fr2.getNumerateur()));
		quotient.simplifier();
		
		return quotient;
	}
	
}
