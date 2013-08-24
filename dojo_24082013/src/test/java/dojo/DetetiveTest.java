package dojo;

import junit.framework.Assert;

import org.junit.Test;


public class DetetiveTest {

//	@Test
//	public void testarChuteCorreto() {
//		Detetive detetive = new Detetive();
//		Assert.assertTrue(detetive.isChuteCorreto(3, 3));
//	}
//	
//	@Test
//	public void testarChuteIncorreto() {
//		Detetive detetive = new Detetive();
//		Assert.assertFalse(detetive.isChuteCorreto(2, 4));
//	}
	
	@Test
	public void testarRespostaInformada() {
		// este teste verifica se o Detetive
		// armazenou a resposta "informada fixamente"
		Detetive detetive = new Detetive();
		detetive.armazenaResposta(1, 3, 5);
		Assert.assertEquals(1, detetive.getSuspeitoCorreto());
		Assert.assertEquals(3, detetive.getLocalCorreto());
		Assert.assertEquals(5, detetive.getArmaCorreta());
	}
	
	@Test
	public void testarRespostaGerada() {
		// este teste irá verificar se o Detetive
		// gerou uma resposta válida
		Detetive detetive = new Detetive();
		detetive.geraResposta();
		Assert.assertNotNull(detetive.getSuspeitoCorreto());
		Assert.assertNotNull(detetive.getLocalCorreto());
		Assert.assertNotNull(detetive.getArmaCorreta());
		// averiguar se as opções geradas estão 
		// dentro da gama de opções válidas
	}
	
	@Test
	public void verificarSeARespostaDoSuspeitoNaoEhNula(){
		Detetive detetive = new Detetive();		
		Assert.assertFalse(detetive.perguntarSuspeito(1));
	}
	
	@Test
	public void verificarSeOSuspeitoEstaCorreto(){
		Detetive detetive = new Detetive();
		detetive.armazenaResposta(1, 2, 3);
		Assert.assertTrue(detetive.perguntarSuspeito(1));
	}
	
	@Test
	public void verificarSeOSuspeitoEstaIncorreto(){
		Detetive detetive = new Detetive();
		detetive.armazenaResposta(1, 2, 3);
		Assert.assertFalse(detetive.perguntarSuspeito(2));
	}
	
	@Test
	public void verificarSeARespostaDoLocalNaoEhNula() {
		Detetive detetive = new Detetive();
		Assert.assertFalse(detetive.perguntarLocal(3));
	}
	
	@Test
	public void verificarSeoLocalEstaCorreto(){
		Detetive detetive = new Detetive();
		detetive.armazenaResposta(1, 3, 2);
		Assert.assertTrue(detetive.perguntarLocal(3));
	}
	
	@Test
	public void verificarSeoLocalEstaIncorreto(){
		Detetive detetive = new Detetive();
		detetive.armazenaResposta(1, 3, 2);
		Assert.assertFalse(detetive.perguntarLocal(5));
	}
	
	@Test
	public void verificarSeAArmaNaoEhNula(){
		Detetive detetive = new Detetive();
		Assert.assertFalse(detetive.perguntarArma(5));
	}

	@Test
	public void verificarSeAArmaEstaCorreta(){
		Detetive detetive = new Detetive();
		detetive.armazenaResposta(1, 3, 2);
		Assert.assertTrue(detetive.perguntarArma(2));
	}
	
	@Test
	public void verificarSeAArmaEstaIncorreta(){
		Detetive detetive = new Detetive();
		detetive.armazenaResposta(1, 3, 2);
		Assert.assertFalse(detetive.perguntarArma(5));
	}
	
	@Test
	public void verificarSeATeoriaInformadaEstaCorreta(){
		Detetive detetive = new Detetive();
		detetive.armazenaResposta(1, 2, 3);
		int resultadoTeoria = detetive.informarTeoria(1,2,3);
		Assert.assertEquals(0,resultadoTeoria);
	}
	
	@Test
	public void verificarSeATeoriaInformadaEstaParcialmenteCorretaComUmErro(){
		Detetive detetive = new Detetive();
		detetive.armazenaResposta(1, 2, 3);
		int resultadoTeoria = detetive.informarTeoria(1, 5, 3);
		Assert.assertEquals(2, resultadoTeoria);
	}
	
	@Test
	public void verificarSeATeoriaInformadaEstaParcialmenteCorretaComDoisErros(){
		
		Detetive detetive = new Detetive();
		
		GeradorAleatorioPrevisivel geradorAleatorio = new GeradorAleatorioPrevisivel();
		geradorAleatorio.adicionaProximo(1);
		detetive.setGeradorAleatorio(geradorAleatorio);
		
		detetive.armazenaResposta(1, 2, 3);
		int resultadoTeoria = detetive.informarTeoria(1, 5, 2);
		Assert.assertEquals(3, resultadoTeoria);
	}
	
	@Test
	public void verificarSeATeoriaInformadaEstaParcialmenteCorretaComTresErros(){
		Detetive detetive = new Detetive();
		detetive.armazenaResposta(1, 2, 3);
		int resultadoTeoria = detetive.informarTeoria(4, 5, 2);
		Assert.assertFalse(resultadoTeoria == 0);
	}
	
	@Test(expected = IllegalStateException.class)
	public void verificarSeFoiInformadaRespostaAntesDeInvestigar(){
		Detetive detetive = new Detetive();
		detetive.investiga();
	}
	
	@Test
	public void verificarRespostaDaInvestigacao(){
		Detetive detetive = new Detetive();
		detetive.armazenaResposta(2, 4, 3);
		int[] respostaDoDetetive = detetive.investiga();
		Assert.assertEquals(respostaDoDetetive[0], 2);
		Assert.assertEquals(respostaDoDetetive[1], 4);
		Assert.assertEquals(respostaDoDetetive[2], 3);
	}
	
	@Test
	public void verificarRespostaDaInvestigacaoErrada(){
		Detetive detetive = new Detetive();
		detetive.armazenaResposta(2, 4, 4);
		int[] respostaDoDetetive = detetive.investiga();
		Assert.assertEquals(respostaDoDetetive[0], 2);
		Assert.assertEquals(respostaDoDetetive[1], 4);
		Assert.assertFalse(respostaDoDetetive[2] == 3);
	}
	
	@Test
	public void testarFormatacaoResposta( ) {
		Detetive detetive = new Detetive();
		detetive.armazenaResposta(3, 2, 1);
		int[] respostaDoDetetive = detetive.investiga();
		
		String respostaFormatada = detetive.formataResposta(respostaDoDetetive);
		String respostaEsperada = String.format(
				Detetive.MODELO_RESPOSTA_FORMATADA, 
				"Ada L. Ovelace", "Palo Alto", "Peixeira");
		Assert.assertEquals(respostaFormatada, respostaEsperada);	
	}
	
	@Test
	public void testarFormatacaoIncorreta( ) {
		Detetive detetive = new Detetive();
		detetive.armazenaResposta(5, 4, 1);
		int[] respostaDoDetetive = detetive.investiga();
		
		String respostaFormatada = detetive.formataResposta(respostaDoDetetive);
		String respostaEsperada = String.format(
				Detetive.MODELO_RESPOSTA_FORMATADA, 
				"Ada L. Ovelace", "Palo Alto", "Peixeira");
		Assert.assertFalse(respostaFormatada.equals(respostaEsperada));
	}

}
