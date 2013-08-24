package dojo;

import java.util.Random;

public class GeradorAleatorioJavaRandom implements GeradorAleatorio {

	@Override
	public int proximoInteiro(int limite) {
		return new Random().nextInt(limite);
	}

}
