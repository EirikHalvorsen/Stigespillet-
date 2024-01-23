
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * Brukermeny for spillerobjekter og oppsett av stigespillet.
 * 
 * 
 * @author Eirik Vedå Halvorsen
 * 
 */

public class Meny {

	private static final int MIN_SPILLERE = 2;
	private static final int MAX_SPILLERE = 4;
	
	static ArrayList<Spiller> spillerList = new ArrayList<Spiller>();
	static ArrayList<String> fargeList = new ArrayList<>(Arrays.asList("Blå", "Rød", "Gul", "Rosa", "Grønn"));	
	
	
	
	public static void main(String[] args) {
		
		boolean gyldig = true;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Velkommen til Stigespillet");
		
		for (int i = 1; i <= MAX_SPILLERE && gyldig; i++) {
			
			String navn;
			// Brukeren kan avslutte etter hver opprettet spiller, så sant 2 spillere er opprettet.
			if (i > MIN_SPILLERE && i < MAX_SPILLERE) {
				System.out.println("Tast 'z' for å avslutte, eller tast inn navn på ny spiller");
				navn = scanner.nextLine();
				if (navn.toLowerCase().equals("z")) {
					gyldig = false;
				}
			} else {
				System.out.println("Skriv inn navn på spiller " + i);
				navn = scanner.nextLine();
			}
			
			if (gyldig) {
				// Spillerene velger farge en etter en
				System.out.println("Velg farge på brikken:");
				String farge = velgFarge(scanner);
				
				Spiller spiller = new Spiller(navn, farge);
				spillerList.add(spiller);
				System.out.println("Spiller " + i + ": " + spiller.getNavn() + ", opprettet med "
						                        + spiller.getFarge()+ " brikke.");
				
			}
		}
		scanner.close();
		Stigespill stigespill = new Stigespill();
		
	}
	

	 private static String velgFarge(Scanner scanner) {

	        boolean gyldig = false;
	        int i = 1;
	        String farge = "";

	        //Viser tilgjengelige farger og input for å velge gitt farge.
	        for (String f : fargeList) {
	            System.out.println("Tast " + i + " for " + f);
	            i++;
	        }

	        while (!gyldig) {
	            try {
	                int f = Integer.parseInt(scanner.nextLine());

	                if (f > 0 && f < i) {   //Gyldig input.
	                    farge = fargeList.remove(f - 1);
	                    gyldig = true;
	                } else {                //Ugyldig input, tall samsvarer ikke med farge.
	                    System.out.println(f + " hører ikke til noe farge, prøv igjen.");
	                }
	            } catch (Exception e) {     //Ugyldig input
	                System.out.println("Tast inn et tall mellom 1 og " + (i - 1));
	            }
	        }
	        // hvis gyldig er true, returner farge
	        return farge;
	   
	 }
}
	
