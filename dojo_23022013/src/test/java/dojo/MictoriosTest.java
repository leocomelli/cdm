package dojo;

import junit.framework.Assert;
import org.junit.Test;

public class MictoriosTest {
	
	
	@Test
	public void testarQtdPessoasPodemUsarCom_5_MictoriosE_1_Ocupado () {		
		Mictorio mictorio = new Mictorio(5);		
		int totalLivres = mictorio.quantidadeDePessoasQuePodemUsar();
		Assert.assertEquals(1, totalLivres);
	}
	
	@Test
	public void testarQtdPessoasPodemUsarCom_6_MictoriosE_1_Ocupado () {		
		Mictorio mictorio = new Mictorio(6);		
		int totalLivres = mictorio.quantidadeDePessoasQuePodemUsar();
		Assert.assertEquals(2, totalLivres);
	}
	
	@Test
	public void testarQtdPessoasPodemUsarCom_7_MictoriosE_1_Ocupado () {		
		Mictorio mictorio = new Mictorio(7);		
		int totalLivres = mictorio.quantidadeDePessoasQuePodemUsar();
		Assert.assertEquals(2, totalLivres);
	}
	
	@Test
	public void testarMictoriosDispoiveisCom_5_MictoriosE_1_Ocupado()
	{
		Mictorio mictorio = new Mictorio(5);
		int[] mictoriosDisponiveis = mictorio.acharMictoriosDisponiveis();
		 Assert.assertEquals(4, mictoriosDisponiveis[0]);
		 Assert.assertEquals(5, mictoriosDisponiveis[1]);
		 Assert.assertEquals(2, mictoriosDisponiveis.length);
	}
	
	@Test
	public void testarMictoriosDispoiveisCom_6_MictoriosE_1_Ocupado()
	{
		Mictorio mictorio = new Mictorio(6);
		int[] mictoriosDisponiveis = mictorio.acharMictoriosDisponiveis();
		 Assert.assertEquals(4, mictoriosDisponiveis[0]);
		 Assert.assertEquals(6, mictoriosDisponiveis[1]);
		 Assert.assertEquals(2, mictoriosDisponiveis.length);
	}
	
	@Test
	public void testarMictoriosDispoiveisCom_4_MictoriosE_1_Ocupado()
	{
		Mictorio mictorio = new Mictorio(4);
		int[] mictoriosDisponiveis = mictorio.acharMictoriosDisponiveis();
		 Assert.assertEquals(4, mictoriosDisponiveis[0]);
		 Assert.assertEquals(1, mictoriosDisponiveis.length);
	}
	
	@Test
	public void testarMictoriosDispoiveisCom_7_MictoriosE_1_Ocupado()
	{
		Mictorio mictorio = new Mictorio(6);
		int[] mictoriosDisponiveis = mictorio.acharMictoriosDisponiveis();
		 Assert.assertEquals(4, mictoriosDisponiveis[0]);
		 Assert.assertEquals(6, mictoriosDisponiveis[1]);
		 Assert.assertEquals(2, mictoriosDisponiveis.length);
	}
}
