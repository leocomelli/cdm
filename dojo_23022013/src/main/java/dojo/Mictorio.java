package dojo;

public class Mictorio {
	
	int mictorioOcupada = 2;
	int[] mictorios; 
	
	public Mictorio(int quantidadeMictorios){
		mictorios = new int[quantidadeMictorios];
		preencherMictorios(mictorios);
	}
	
	private void preencherMictorios(int[] mictorios){
		for (int i = 0; i < mictorios.length; i++) {
			mictorios[i] = i +1;
		}
	}

	public int quantidadeDePessoasQuePodemUsar() {
		int[] livres = acharMictoriosLivres();
		
		return (int)Math.ceil((double)livres.length / 2);
	} 

	public int[] acharMictoriosLivres() {
		int idxMictorios = mictorioOcupada -1;
		int proximaMictorioLivre = idxMictorios + 2;
		
		int totalMictorioLivres = mictorios.length - proximaMictorioLivre;
		int[] livres = new int[totalMictorioLivres];
		
		System.arraycopy(mictorios, proximaMictorioLivre, livres, 0, totalMictorioLivres);
		
		return livres;
	}
	
	public int[] acharMictoriosDisponiveis(){
		int[] mictoriosLivres = acharMictoriosLivres();
		return mictoriosLivres.length == 2 ? mictoriosLivres : filtrarMictoriosDisponiveis(mictoriosLivres);
	}
	
	public int[] filtrarMictoriosDisponiveis(int[] mictoriosLivres)
	{
		
		int quantidadeMictoriosDisponiveis = (int) Math.ceil((double)mictoriosLivres.length/2);
		int[] mictoriosDisponiveis = new int[quantidadeMictoriosDisponiveis];
		
		int contadorMictoriosLivres = 0;
		int contadorMictoriosDisponiveis = 0;
		
		while(contadorMictoriosLivres <= mictoriosLivres.length)
		{
			mictoriosDisponiveis[contadorMictoriosDisponiveis] = mictoriosLivres[contadorMictoriosLivres];
			contadorMictoriosDisponiveis++;
			contadorMictoriosLivres += 2;
		}
		
		return mictoriosDisponiveis;
	}

}
