
public class Integrale {

	public static void main(String[] args) {
		
		double[] poly = {5, 16, -9, 1};
		double a = 0, b = 7;
		int n = 400;
		
		double integraleReelle = valPoly(primitivePoly(poly), b) - valPoly(primitivePoly(poly), a);
		double integraleGauche = integraleRectangle(poly, a, b, n, 0);
		double integraleDroite = integraleRectangle(poly, a, b, n, 1);
		double integraleMilieu = integraleRectangle(poly, a, b, n, 2);
		double integraleTrapeze = integraleTrapeze(poly, a, b, n);
		double integraleSimpson = integraleSimpson(poly, a, b, n);
		double integraleFonction = integraleRectangleFonction(0, 2, 10, 2);
		
		System.out.println("Valeur exacte de l'integrale : "+integraleReelle);
		System.out.println("Rectangles droits, valeur : "+integraleDroite+" / Erreur : "+Math.abs(integraleDroite-integraleReelle)
		+"Rectangles gauches, valeur : "+integraleGauche+" / Erreur : "+Math.abs(integraleGauche-integraleReelle)
		+"Rectangles milieux, valeur : "+integraleMilieu+" / Erreur : "+Math.abs(integraleMilieu-integraleReelle)
		+"Rectangles trapezes, valeur : "+integraleTrapeze+" / Erreur : "+Math.abs(integraleTrapeze-integraleReelle)
		+"Rectangles simpson, valeur : "+integraleSimpson+" / Erreur : "+Math.abs(integraleSimpson-integraleReelle)
		+"Rectangles focntion, valeur : "+integraleFonction);
	}
	
	/**
	 * 
	 * @param poly
	 * @param z
	 * @return valpoly
	 */
	
	public static double valPoly(double[] poly, double z){
		
		double valeur=0;
		
		for(int i=0; i<poly.length; i++){
			
			valeur += poly[i]*Math.pow(z,i);
		}
		
		return valeur;
	}
	
	public static double valFonction(double x) {
		
		return Math.cos(Math.PI*x)*Math.sqrt(x*x + 1);
	}
	
	/**
	 * 
	 * @param poly
	 * @param a
	 * @param b
	 * @param n
	 * @param mode
	 * @return integrale
	 */
	
	public static double integraleRectangle( double[] poly, double a, double b, int n, int mode){
		
		double delta = (b-a)/n ;
		double x = 0;
		
		switch (mode) {
		
			case 0 :
				
				x = a;
				
				break;
			
			case 1 :
				
				x = a+delta;
				
				break;
				
			case 2 :
				
				x = a+(delta/2);
				
				break;
				
			default :
				
				break;
					
				
		}
		
		double integrale = 0;
	
		for(int k = 0; k<n; k++){
	
			integrale += delta*valPoly(poly, x);
			x = x + delta;
		}
		
		return integrale;
	}
	
	public static double integraleRectangleFonction(double a, double b, int n, int mode){
		
		double delta = (b-a)/n ;
		double x = 0;
		
		switch (mode) {
		
			case 0 :
				
				x = a;
				
				break;
			
			case 1 :
				
				x = a+delta;
				
				break;
				
			case 2 :
				
				x = a+(delta/2);
				
				break;
				
			default :
				
				break;
					
				
		}
		
		double integrale = 0;
	
		for(int k = 0; k<n; k++){
	
			integrale += delta*valFonction(x);
			x = x + delta;
		}
		
		return integrale;
	}
	/**
	 * 
	 * @param poly
	 * @return
	 */
		
	public static double[] primitivePoly(double[] poly){
		
		double[] primitive = new double[poly.length + 1];
		primitive[0] = 0;
		
		for(int i = 0; i<poly.length; i++){
			
			primitive[i+1] = poly[i]*(1.0/(double)(i+1)); 
		}
		
		return primitive;
	}
	
	/**
	 * 
	 * @param poly
	 * @param a
	 * @param b
	 * @param n
	 * @return
	 */
	
	public static double integraleTrapeze(double[] poly, double a, double b, int n){
		
		double delta = (b-a)/n ;
		double x = a;
		double integrale = 0;
		
		for(int k = 0; k<n; k++){
	
			integrale += delta*(valPoly(poly, x)+valPoly(poly, x+delta))/2;
			x = x + delta;
		}
		
		return integrale;
	}
	
	/**
	 * 
	 * @param poly
	 * @param a
	 * @param b
	 * @param n
	 * @return
	 */
	
	public static double integraleSimpson(double[] poly, double a, double b, int n){
		
		double delta = (b-a)/n ;
		double x = a;
		double integrale = 0;
		
		for(int k = 0; k<n; k++){
	
			integrale += (delta/6) * (valPoly(poly, x) + 4*valPoly(poly, x+(delta/2)) + valPoly(poly, x+delta));
			x = x + delta;
		}
		
		return integrale;
	}
	
	
}
