
/**
 * Classe de test de la classe Fraction
 * @author Pierre-Louis
 * @version 1.0
 */

public class TPFraction {

	public static void main(String[] args) {
		
		Fraction fr1 = new Fraction(1,3);
		Fraction fr2 = new Fraction(40,1);
		System.out.println(fr1 +" "+ fr2 +" "+fr2.multiplier(fr1)+" "+fr1.ajouter(fr2)+" "+fr1.soustraire(fr2)+" "+fr1.diviser(fr2)+" "+fr1.evalF());
	}

}
