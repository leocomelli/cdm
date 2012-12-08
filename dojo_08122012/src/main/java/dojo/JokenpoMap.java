package dojo;

import java.util.HashMap;
import java.util.Map;


// Diogo, Leo, Gabriel, Ronaldo, Matheus, Odair e Henrique
/**
 * Jokenpo, sendo:
 * 
 *  1 - Pedra;
 *  2 - Papel;
 *  3 - Tesoura.
 *
 */
public class JokenpoMap {

	private final Map<String, Integer> possibilidades = new HashMap<String, Integer>();
	
	public JokenpoMap() {
		possibilidades.put("11", 0);
		possibilidades.put("22", 0);
		possibilidades.put("33", 0);
		possibilidades.put("13", 1);
		possibilidades.put("31", 1);
		possibilidades.put("32", 3);
		possibilidades.put("23", 3);
		possibilidades.put("12", 2);
		possibilidades.put("21", 2);
	}
	
	protected boolean validar(final Integer entrada) {
		return entrada!= null && entrada > 0 && entrada <= 3;
	}

	public int jogar(final Integer entrada1, final Integer entrada2){
		if(validar(entrada1) && validar(entrada2)){
			return possibilidades.get(String.valueOf(entrada1).concat(String.valueOf(entrada2)));
		}

		throw new IllegalArgumentException("As entradas devem ser entre 1 e 3.");
	}
}