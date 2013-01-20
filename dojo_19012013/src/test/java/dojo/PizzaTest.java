package dojo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import junit.framework.Assert;

import org.junit.Test;

public class PizzaTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void lancarExcecaoSeParametroForNulo() {
		new EscolhePizza(null).escolhe(null);
	}
	
//	@Test(expected = IllegalArgumentException.class)
//	public void lancarExcecaoSeParametroNaoForValido() {
//		new EscolhePizza(null).escolhe(new SaborPreferencia(null, 0, 0, 0, 0, 0, 0));
//	}
//	
//	@Test
//	public void retornoDeEscolhePizzaNaoNull() {
//		Map<String, List<String>> retornoLista = new EscolhePizza(null).escolhe(new SaborPreferencia("Nome", 1, 2, 3, 4, 5, 1));
//		Assert.assertNotNull(retornoLista);
//	}
	
//	@Test
//	public void retornaUnico() {
//		Map<String, List<String>> retornoLista = new EscolhePizza(null).escolhe(new SaborPreferencia("Nome", 1, 2, 3, 4, 5, 1));
//		Assert.assertFalse(retornoLista.keySet().isEmpty());
//		Assert.assertNotNull(retornoLista.get("MARGUERITA"));
//		Assert.assertFalse(retornoLista.get("MARGUERITA").isEmpty());
//	}	
	
	@Test
	public void validaPreferenciaApenasComUmSaborDePizza() {
		List<SaborPreferencia> lista = new ArrayList<SaborPreferencia>();
		SaborPreferencia preferencia = new SaborPreferencia("Renato", 1, 2, 3, 4, 5, 1);
		lista.add(preferencia);
		
		Map<String, List<String>> retornoLista = new EscolhePizza(lista).escolhe(preferencia);
		
		Assert.assertTrue(retornoLista.get("MARGUERITA").contains("Renato"));
	}
	
	@Test
	public void validaPreferenciaApenasComUmSaborDePizzaComDoisAmigos() {
		SaborPreferencia minhaPreferencia = new SaborPreferencia("Eu", 1, 2, 3, 4, 5, 1);
		
		Map<String, List<String>> retornoLista = new EscolhePizza(listarPreferencias())
			.escolhe(minhaPreferencia);
		
		Assert.assertTrue(retornoLista.get("MARGUERITA").contains("Renato"));
		Assert.assertTrue(retornoLista.get("MARGUERITA").contains("Jo‹o"));
		Assert.assertTrue(retornoLista.get("NAPOLITANA").contains("Renato"));
		Assert.assertTrue(retornoLista.get("NAPOLITANA").contains("Jo‹o"));
		Assert.assertTrue(retornoLista.get("QUATROQUEIJO").contains("Renato"));
		Assert.assertTrue(retornoLista.get("QUATROQUEIJO").contains("Jo‹o"));
		Assert.assertTrue(retornoLista.get("ESCAROLA").contains("Renato"));
		Assert.assertTrue(retornoLista.get("ESCAROLA").contains("Jo‹o"));
		Assert.assertTrue(retornoLista.get("PORTUGUESA").contains("Renato"));
		Assert.assertTrue(retornoLista.get("PORTUGUESA").contains("Jo‹o"));
		Assert.assertTrue(retornoLista.get("FRANGOCATUPIRY").contains("Renato"));
		Assert.assertTrue(retornoLista.get("FRANGOCATUPIRY").contains("Jo‹o"));

	}
	
	@Test
	public void validaPreferenciaComVariosSaboresDePizza() {
		SaborPreferencia minhaPreferencia = new SaborPreferencia("Eu", 1, 2, 3, 4, 5, 1);
		
		Map<String, List<String>> retornoLista = new EscolhePizza(listarPreferencias())
		.escolhe(minhaPreferencia);
		
		Assert.assertTrue(retornoLista.get("MARGUERITA").contains("Renato"));
		Assert.assertTrue(retornoLista.get("MARGUERITA").contains("Jo‹o"));
		Assert.assertFalse(retornoLista.get("MARGUERITA").contains("Willian"));
	}
	
	@Test
	public void imprimirRecomendacoesParaDividirPizza(){
		SaborPreferencia preferenciaRenato = new SaborPreferencia("Renato", 1, 2, 3, 4, 5, 1);
		SaborPreferencia preferenciaJoao = new SaborPreferencia("Jo‹o", 1, 2, 3, 4, 5, 1);
		SaborPreferencia preferenciaWillian = new SaborPreferencia("Willian", 2, 2, 3, 4, 5, 1);
		
		SaborPreferencia minhaPreferencia = new SaborPreferencia("Eu", 1, 2, 3, 4, 5, 1);
		
		Map<String, List<String>> retornoLista = new EscolhePizza(Arrays.asList(preferenciaRenato, preferenciaJoao,preferenciaWillian))
		.escolhe(minhaPreferencia);
		
		StringBuilder sb = new StringBuilder();
		for (Entry<String, List<String>> retorno : retornoLista.entrySet()) {
			sb.append(retorno.getKey() + ":\n");
			for (String string : retorno.getValue()) {
				sb.append("\t\t" + string + "\n");
				
			}			
		}
		System.out.println(sb.toString());
	}
	
	private List<SaborPreferencia> listarPreferencias(){
		SaborPreferencia preferenciaRenato = new SaborPreferencia("Renato", 1, 2, 3, 4, 5, 1);
		SaborPreferencia preferenciaJoao = new SaborPreferencia("Jo‹o", 1, 2, 3, 4, 5, 1);
		SaborPreferencia preferenciaWillian = new SaborPreferencia("Willian", 2, 2, 3, 4, 5, 1);
		
		return Arrays.asList(preferenciaRenato, preferenciaJoao,preferenciaWillian);
	}

}
