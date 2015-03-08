
package Ese102;

import java.io.*;

public class Ese102 {

   
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);
        String linea = "";
        ComplexNumber numeroComplesso = new ComplexNumber();
        int scelta = 0;
        boolean valoreValido = false; 
	        
	double parteReale = 0;
	double parteImmaginaria = 0;
	        
	double argomento=0; 
	double modulo=0;
        
                while (scelta!=1 && scelta!=2) {
	            System.out.println("tipo di coordinate:");
	            System.out.println("1 Rettangolari ; 2 Polari");
	            linea = tastiera.readLine();
	            try {
	                scelta = Integer.valueOf(linea).intValue();
	            } catch (NumberFormatException e) {
	                System.out.println("Scelta non valida, inserisci un numero");
	            }
	        }
	        
	        if(scelta==1){
	            
	            while (valoreValido == false) {
	                System.out.print("parte REALE ");
	                linea = tastiera.readLine();
	                try {
	                    parteReale = Double.valueOf(linea).doubleValue();
	                    valoreValido = true;
	                } catch (NumberFormatException e) {
	                    System.out.println("Numero non valido.");
	                }
	            }
	            valoreValido = false;
	            while (valoreValido == false) {

	                System.out.print("parte IMMAGINARIA ");
	                linea = tastiera.readLine();
	                try {
	                    parteImmaginaria = Double.valueOf(linea).doubleValue();
	                    valoreValido = true;
	                } catch (NumberFormatException e) {

	                    System.out.println("Numero non valido.");
	                }
	            }
	           numeroComplesso.setRectangular(parteReale, parteImmaginaria);
	            System.out.println("Hai inserito il numero " + numeroComplesso.ComplexNumbCartesiano());
	            System.out.println("Rappresenta un vettore di modulo " + numeroComplesso.getMod());
	            System.out.println("Disegna un angolo Theta di " + numeroComplesso.getArg()+"�");
	            
	        }
	            
	        

	        else if(scelta==2){
	            while (valoreValido == false) {
	                System.out.print("Inserisci il MODULO ");
	                linea = tastiera.readLine();
	                try {
	                    modulo = Double.valueOf(linea).doubleValue();
	                    valoreValido = true;
	                } catch (NumberFormatException e) {
	                    System.out.println("Numero non valido.");
	                }
	            }
	            valoreValido = false;
	            while (valoreValido == false) {

	                System.out.print("Inserisci THETA ");
	                linea = tastiera.readLine();
	                try {
	                    argomento = Double.valueOf(linea).doubleValue();
	                    valoreValido = true;
	                } catch (NumberFormatException e) {

	                    System.out.println("Numero non valido.");
	                }
	            }
	            numeroComplesso.setPolar(modulo, argomento);
	            System.out.println("Hai inserito "+ numeroComplesso.ComplexNumbPolare());
	            System.out.println("La sua componente REALE e' "+ numeroComplesso.getRe());
	            System.out.println("La sua componente IMMAGINARIA e' "+ numeroComplesso.getIm());
	        }
    
        }
    
}
