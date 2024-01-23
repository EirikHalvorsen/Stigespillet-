
import java.util.HashMap;

/**
 * 
 * Klasse som etterlikner et brett i stigespillet
 * 
 * @author Eirik Vedå Halvorsen
 *
 */

public class Brett {

	HashMap<Integer, Integer> brett = new HashMap<Integer, Integer>();

	/**
	 * Konstruktør for brett, metoden genererRute() som oppretter et map av
	 * stiger/slanger
	 */

	public Brett() {
		genererRuter();
	}

	/**
	 * Generer rutene til brettet. der key er rutenummer og verdi er hvor rutene
	 * leder til.
	 * 
	 */
	private void genererRuter() {

		brett.put(2, 38);
		brett.put(4, 14);
		brett.put(8, 31);
		brett.put(9, 5);
		brett.put(16, 6);
		brett.put(28, 84);
		brett.put(21, 42);
		brett.put(36, 44);
		brett.put(47, 26);
		brett.put(48, 11);
		brett.put(52, 67);
		brett.put(55, 53);
		brett.put(62, 18);
		brett.put(64, 60);
		brett.put(60, 27);
		brett.put(71, 90);
		brett.put(92, 73);
		brett.put(80, 100);
		brett.put(95, 75);
		brett.put(98, 78);
	}

	/**
	 * Sjekker om spilleren er på en stige/slange rute
	 * 
	 * @param pos er posisjonen til spilleren
	 * @return posisjonen stigen/slangen leder til. -1 hvis spilleren ikke står på
	 *         noe stige/slange
	 * 
	 */

	public int sjekkStigeSlange(int pos) {
		if (brett.containsKey(pos)) {
			return brett.get(pos);
		}
		return -1;
	}

}
