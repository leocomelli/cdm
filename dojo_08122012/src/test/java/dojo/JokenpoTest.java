package dojo;

import static org.junit.Assert.*;
import org.junit.Test;


public class JokenpoTest {
	
	private final Jokenpo jokenpo = new Jokenpo();

	/* Validar Entradas */
	@Test
    public void deve_aceitar_entrada_igual_a_1(){
		assertTrue(jokenpo.validar(1));
	}
	
	@Test
	public void deve_rejeitar_entrada_igual_a_4(){
		assertFalse(jokenpo.validar(4));
	}
	
	@Test
	public void deve_rejeitar_entrada_igual_a_0(){
		assertFalse(jokenpo.validar(0));
	}
	
	@Test
	public void deve_rejeitar_entrada_igual_a_nulo(){
		assertFalse(jokenpo.validar(null));
	}

	@Test
	public void deve_aceitar_entradas_iguais_a_2_e_3(){
		assertTrue(jokenpo.jogar(2, 3) != 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deve_rejeitar_entradas_iguais_a_4_e_5(){
		jokenpo.jogar(4, 5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deve_rejeitar_entradas_iguais_a_2_e_4(){
		jokenpo.jogar(2, 4);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deve_rejeitar_entradas_nulas(){
		jokenpo.jogar(null, null);
	}
	
	/* Empate (Entradas Iguais) */ 
	
	@Test
	public void deve_rejeitar_entradas_iguais(){
		assertEquals(0, jokenpo.jogar(1, 1));
	}

	
	/* Pedra <> Tesoura */
	
	@Test
	public void deve_retornar_1_quando_as_entradas_forem_1_e_3(){
		assertEquals(1, jokenpo.jogar(1, 3));
	}
	
	@Test
	public void deve_retornar_1_quando_as_entradas_forem_3_e_1(){
		assertEquals(1, jokenpo.jogar(3, 1));
	}
	
	/* Pedra <> Papel */
	
	@Test
	public void deve_retornar_2_quando_as_entradas_forem_1_e_2(){
		assertEquals(2, jokenpo.jogar(1, 2));
	}
	
	@Test
	public void deve_retornar_2_quando_as_entradas_forem_2_e_1(){
		assertEquals(2, jokenpo.jogar(2, 1));
	}

	/* Papel <> Tesoura */

	@Test
	public void deve_retornar_3_quando_as_entradas_forem_2_e_3(){
		assertEquals(3, jokenpo.jogar(2, 3));
	}
	
	@Test
	public void deve_retornar_3_quando_as_entradas_forem_3_e_2(){
		assertEquals(3, jokenpo.jogar(3, 2));
	}
	
}
