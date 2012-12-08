package dojo;

/**
 * Jokenpo, sendo:
 * 
 *  1 - Pedra;
 *  2 - Papel;
 *  3 - Tesoura.
 *
 */
public class Jokenpo {

	protected boolean validar(final Integer entrada) {
		return entrada!= null && entrada > 0 && entrada <= 3;
	}

	public int jogar(final Integer entrada1, final Integer entrada2){
		// Valida‹o
		if(validar(entrada1) && validar(entrada2)){
			// empate
			if(entrada1 == entrada2){
				return  0;
			}

			//Pedra e Tesoura / Tesoura e Papel
			if((entrada1 == 1 && entrada2 == 3) || (entrada1 == 3 && entrada2 == 1)){
				return 1;
			}
			//Tesoura e Papel / Papel e Tesoura --- Papel e Pedra / Pedra e Papel
			else if(entrada1 > entrada2){
					return entrada1;
			}
			
			return entrada2;
		}

		throw new IllegalArgumentException("As entradas devem ser entre 1 e 3.");
	}
}