
package Ese102;


public class ComplexNumber {
   
   static private double initRe;
   static private double initIm; 
    private static StringFormat initFormat;

   private double re,im;
   
    static public enum StringFormat {
		RECTANGULAR,
		POLAR, RETTANGOLARI, POLARI
	}
   
   private StringFormat format;
   
   public ComplexNumber(){
		this.re=ComplexNumber.initRe;
		this.im=ComplexNumber.initIm;
		this.format=ComplexNumber.initFormat; 
	}
   
   private static double normalize(double a) {
		a += (a<0)?2*Math.PI:0;
		a = a % (2*Math.PI);
		return a;
	}
   
   static public void setInitRectangular(double re, double im) {
		
		initRe = re;
		initIm = im;
		initFormat= StringFormat.RETTANGOLARI; //setto il formato delle successive visualizzazioni a RETTANGOLARE
	}		
		
   static public void setInitPolar(double modulus, double argument) {
	
                
		argument = normalize(argument);
		initRe = modulus * (Math.cos(argument * Math.PI / 180));
		initIm = modulus * (Math.sin(argument * Math.PI / 180));
		
		
		initFormat = StringFormat.POLARI; 
	}
   
   
   
   
    
   double getRe() {
       return re;
    }
   
   double getIm() {
       return im;
    }
   
   double getModulus() {
       return Math.sqrt((this.re * this.re) + (this.im * this.im));
   }
   
   double getArgument() {
       double r = 0 ;
       
       if (re==0 && im==0) {
           r =0;
       }
       else 
                if ((re < 0 && im > 0) || (re < 0 && im <= 0))
                    r = Math.toDegrees((Math.atan(im / re))) + 180;
           
       else 
                if (re >= 0 && im < 0)
                    r = Math.toDegrees((Math.atan(im / re))) + 360;
               
       else     
                if(re >=0 && im >=0)
                    r = Math.toDegrees((Math.atan(im / re)));
       
       return r;
   }
              
   public String formatComplexNumbRettangular() {
       String n  = this.getRe() + "+(" + this.getIm() + ")i";
       return n;
   }
   
   public String formatComplexNumbPolar() {
       String n = "Modulo " + this.getModulus() + " Argomento " + this.getArgument();
       
       return n;
   }

   void setRectangular(double re, double im) {
		this.re = re;
		this.im = im;
	}
    
   void setPolar(double Modulus, double Argument) {

		if (Argument == 90 || Argument == 270)
			this.re = 0;
		else
			this.re = Modulus * (Math.cos((Argument) * Math.PI / 180));
		if (Argument == 180 || Argument == 360)
			this.im = 0;
		else
			this.im = Modulus * (Math.sin((Argument) * Math.PI / 180));

        }
    
   public ComplexNumber add(ComplexNumber operand) {
		
		ComplexNumber somma = new ComplexNumber();
		double re = this.re + operand.getRe();
		double im = this.im + operand.getIm();
		somma.setRectangular(re, im);
		return somma;
	}
        
   public ComplexNumber sub(ComplexNumber operand) {
		
		ComplexNumber differenza = new ComplexNumber();
		double re = this.re - operand.getRe();
		double im = this.im - operand.getIm();
		differenza.setRectangular(re, im);
		return differenza;
	}
    
   public ComplexNumber multiply(ComplexNumber operand) {
		
		ComplexNumber prodotto = new ComplexNumber();
		double modulo = this.getModulus() * operand.getModulus();
		double argomento = this.getArgument() + operand.getArgument();
		prodotto.setPolar(modulo, argomento);
		return prodotto;
        }  
    
   public ComplexNumber divide(ComplexNumber operand) {
		
		ComplexNumber risultato = new ComplexNumber();
		if (operand.getModulus() != 0) {
			double modulo = this.getModulus() / operand.getModulus();
			double argomento = this.getArgument() - operand.getArgument();
			risultato.setPolar(modulo, argomento);
		} else
			throw new IllegalArgumentException("Il modulo del divisore deve essere diverso da 0");
		return risultato;
	}
    
   public void setStringFormat(StringFormat format) {
		this.format = format;
	}
   
   public ComplexNumber getConjugate() {
		ComplexNumber r = new ComplexNumber();
		r.setRectangular(this.re, -this.im);
		return r;
	}
   
   @Override
    public String toString() {
		
		return toString(this.format);
	}
        
    public String toString(StringFormat format) {
		
		String r = new String();
		switch(format) {
		case RECTANGULAR:
			r = this.re + "+(" + this.im + ")i";
			break;
		case POLAR:
			r = this.getModulus() + "*exp(i*" + this.getArgument() +")";
			break;
		default:
			throw new UnsupportedOperationException();
		}
		return r;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean r = false;
		if(o instanceof ComplexNumber) {
			ComplexNumber p = (ComplexNumber)o;
			if(this.re == p.getRe() && this.im == p.getIm()) {
				r = true;
			}
		}
		return r;
	}
	
	@Override
	public int hashCode() {
		return (int)this.re * 1000 + (int)this.im * 1000;
	}   
}   