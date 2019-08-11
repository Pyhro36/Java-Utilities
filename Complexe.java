
/**
 * Classe de construction d'un complexe, represente pas sa partie reelle et sa partie imaginaire, ou son module et son argument
 * @author Pierre-Louis
 * @version 1.0
 */

public class Complexe {

	final private static Complexe I = new Complexe(0,1);
	
	private double fRe;
	private double fIm;
	private double fRho;
	private double fTheta;
	
	/**
	 *  constructeur par defaut du complexe (0;0)
	 */
	
	public Complexe(){
		this.fIm = 0.0;
		this.fRe = 0.0;
		this.setPolaire();
	}
	
	/**
	 * constructeur du complexe à partir des donnees algebriques
	 * @param fRe partie reelle du complexe
	 * @param fIm partie imaginaire du complexe
	 */
	
	public Complexe(double fRe, double fIm){
		this.fRe = fRe;
		this.fIm = fIm;
		this.setPolaire();
	}
	
	/**
	 * constructeur d'un complexe soit a partir des donnees algebriques, soit exponentielles (trigonometriques)
	 * @param f1 partie reelle ou module du complexe
	 * @param f2 partie imaginaire ou argument du complexe
	 * @param cartesien si les données son cartésiennes ou polaires
	 */
	
	public Complexe(double f1, double f2, boolean cartesien){
		
		if (cartesien){
			
			this.fRe = f1;
			this.fIm = f2;
		
		}else{
			
			this.fRho = f1;
			this.fTheta = f2;
		}
		
		this.setPolaire();
	}
	
	public String toString(){
		
		return String.valueOf(this.fRe) + "+ i*" + String.valueOf(this.fIm);
	}
	
	/**
	 * Accesseur de la partie reelle du complexe
	 * @return la partie reelle du complexe
	 */
	
	public double GetfRe(){
	
		return this.fRe;
	}
	
	/**
	 * Accesseur de la partie imaginaire du complexe
	 * @return la partie imaginaire du complexe
	 */
	
	public double GetfIm(){
		
		return this.fIm;
	}
	
	/**
	 * Accesseur du module du complexe
	 * @return le module du complexe
	 */
	
	
	public double GetfRho(){
		
		return this.fRho;
	}
	
	/**
	 * Accesseur de l'argument du complexe
	 * @return l'argument du complexe
	 */
	
	public double GetfTheta(){
		
		return this.fTheta;
	}
	
	/**
	 * methode de mise a jour des valeurs polaires du complexe a partir des valeurs cartesiennes
	 */
	
	public void setPolaire(){
		
		this.fRho = Math.sqrt(this.fRe*this.fRe + this.fIm*this.fIm);
		
		if (this.fRe != 0){
			
			this.fTheta = Math.atan(this.fIm / this.fRe);
			
		} else if(this.fIm > 0){
			
			this.fTheta = Math.PI/2.0;
			
		} else {
			
			this.fTheta = - Math.PI/2.0;
		}
	
	}
	
	/**
	 * methode de mise a jour des valeurs cartesiennes du complexe a partir des valeurs polaires
	 */
	
	public void setCartesien(){
	
		this.fRe = this.fRho*Math.cos(this.fTheta);
		this.fIm = this.fRho*Math.sin(this.fTheta);
	}
	
	/**
	 * somme le complexe a un autre complexe en parametre
	 * @param c2 l'autre complexe 
	 */
	
	public void ajoute(Complexe c2){
		
		this.fRe += c2.GetfRe();
		this.fIm += c2.GetfIm();
		this.setPolaire();
	}
	
	/**
	 * soustrait le complexe par un autre complexe en parametre
	 * @param c2 l'autre complexe 
	 */
	
	public void soustrait(Complexe c2){
		
		this.fRe -= c2.GetfRe();
		this.fIm -= c2.GetfIm();
		this.setPolaire();
	}
	
	/**
	 * multiplie le complexe a un autre complexe en parametre
	 * @param c2 l'autre complexe 
	 */
	
	public void produit(Complexe c2){
		
		this.fRho *= c2.GetfRho();
		this.fTheta += c2.GetfTheta();
		this.setCartesien();
	}
	
}
