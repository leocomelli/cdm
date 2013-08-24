package dojo;

import java.util.LinkedList;
import java.util.Queue;

import dojo.GeradorAleatorio;


public class GeradorAleatorioPrevisivel implements GeradorAleatorio {

	private Queue<Integer> proximos = new LinkedList<>();
	
	public void adicionaProximo(int n) {
		proximos.add(n);
	}
	
	@Override
	public int proximoInteiro(int limite) {
		return proximos.poll();
	}

}
