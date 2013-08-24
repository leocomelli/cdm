package dojo;

import java.util.ArrayList;
import java.util.List;

public class Detetive {
	
	private GeradorAleatorio geradorAleatorio;
	
	// variáveis que armazenam a resposta correta
	private Integer suspeitoCorreto;
	private Integer localCorreto;
	private Integer armaCorreta;
	
	public static final String MODELO_RESPOSTA_FORMATADA = "Suspeito: %s / Local: %s / Arma: %s";
	
	private static final String[] SUSPEITOS = new String[]{"Charles B. Abbage",
			  "Donald Duck Knuth",
			  "Ada L. Ovelace",
			  "Alan T. Uring",
			  "Ivar J. Acobson",
			  "Ras Mus Ler Dorf"};
	
	private static final String[] LOCAIS = new String[]{"Redmond",
			"Palo Alto",
			"San Francisco",
			"Tokio",
			"Restaurante no Fim do Universo",
			"S�o Paulo",
			"Cupertino",
			"Helsinki",
			"Maida Vale",
			"Toronto"};
	
	private static final String[] ARMAS = new String[]{"Peixeira",
			  "DynaTAC 8000X (o primeiro aparelho celular do mundo)",
			  "Trezoit�o",
			  "Trebuchet",
			  "Ma�a",
			  "Gl�dio"};

	public Detetive() {
		this.geradorAleatorio = new GeradorAleatorioJavaRandom();
	}
	
	public boolean perguntarSuspeito(int suspeito){
		return isChuteCorreto(suspeito, suspeitoCorreto);
	}

	public boolean perguntarLocal(int local) {
		return isChuteCorreto(local, localCorreto);
	}
	
	public boolean perguntarArma(int arma) {
		return isChuteCorreto(arma, armaCorreta);
	}
	
	private boolean isChuteCorreto(int chute, Integer correto) {
		return correto != null && correto.equals(chute);
	}

	public void armazenaResposta(int suspeito, int local, int arma) {
		this.suspeitoCorreto = suspeito;
		this.localCorreto = local;
		this.armaCorreta = arma;
	}

	public void geraResposta() {
		this.suspeitoCorreto = geradorAleatorio.proximoInteiro(SUSPEITOS.length) + 1;
		this.localCorreto = geradorAleatorio.proximoInteiro(LOCAIS.length) + 1;
		this.armaCorreta = geradorAleatorio.proximoInteiro(ARMAS.length) + 1;
	}

	public int getSuspeitoCorreto() {
		return suspeitoCorreto;
	}

	public int getLocalCorreto() {
		return localCorreto;
	}

	public int getArmaCorreta() {
		return armaCorreta;
	}

	public int informarTeoria(int suspeito, int local, int arma) {
		
		if (!existeRespostaArmazenada()){
			throw new IllegalStateException("Nenhuma resposta foi informada/gerada");
		}
		
		boolean suspeitoCorreto = perguntarSuspeito(suspeito);
		boolean localCorreto = perguntarLocal(local);
		boolean armaCorreta = perguntarArma(arma);
		
		List<Integer> respostasErradas = new ArrayList<>();
		
		if(!suspeitoCorreto){
			respostasErradas.add(1);
		}
		if(!localCorreto){
			respostasErradas.add(2);
		}
		if(!armaCorreta){
			respostasErradas.add(3);
		}
		
		if (respostasErradas.isEmpty())
		{	
		    return 0;
		}
		int posicaoEscolhida = geradorAleatorio.proximoInteiro(respostasErradas.size());
		return respostasErradas.get(posicaoEscolhida);
	}

	private boolean existeRespostaArmazenada() {
		return !(
			suspeitoCorreto == null
			|| localCorreto == null
			|| armaCorreta == null
		);
	}

	public int[] investiga() {
		
		
		int[] teoriaCandidata = new int[] { 1, 1, 1 };
		
		int resposta;
		
		int iteracoes = 0;
		
		do{
			resposta = informarTeoria(teoriaCandidata[0], 
					                  teoriaCandidata[1], 
					                  teoriaCandidata[2]);
			
			switch(resposta){
			case 1:
				teoriaCandidata[0]++;
				break;
			case 2:
				teoriaCandidata[1]++;
				break;
			case 3:
				teoriaCandidata[2]++;
				break;
			}
			
			iteracoes++;
			
		}while(resposta != 0);
		
//		opção menor, mas mais difícil para ler:
//		
//		while ((resposta = informarTeoria(teoriaCandidata[0], 
//                teoriaCandidata[1], 
//                teoriaCandidata[2])) != 0) {
//			teoriaCandidata[resposta-1]++;
//			iteracoes++;
//		}
		
		System.out.println(" >>>> Iterações para investigar: " + iteracoes);
		
		return teoriaCandidata;
	}

	public String formataResposta(int[] respostaInvestigacao) {

		String nomeDoSuspeito = SUSPEITOS[respostaInvestigacao[0]-1];
		String nomeDoLocal	  = LOCAIS[respostaInvestigacao[1]-1];
		String nomeDaArma	  = ARMAS[respostaInvestigacao[2]-1];
		
		return String.format(MODELO_RESPOSTA_FORMATADA, 
				nomeDoSuspeito, nomeDoLocal, nomeDaArma);
	}
	
	public void setGeradorAleatorio(GeradorAleatorio geradorAleatorio) {
		this.geradorAleatorio = geradorAleatorio;
	}

}
