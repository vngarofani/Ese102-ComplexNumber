
package Ese102;


public class ComplexNumber {
    
   private double re,im;
   
   double getRe() {
       return re;
   }
   
   double getIm() {
       return im;
    }
   
   double getMod() {
       return Math.sqrt((this.re * this.re) + (this.im * this.im));
   }
   
   double getArg() {
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
       
       
           
       
 
   
   
           
   public String ComplexNumbCartesiano() {
       String n  = this.getRe() + "+(" + this.getIm() + ")i";
       return n;
   }
   
   public String ComplexNumbPolare() {
       String n = "Modulo " + this.getMod() + " Argomento " + this.getArg();
       
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
    
}   