package dojo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EscolhePizza {

	
	private List<SaborPreferencia> preferencias;

	public EscolhePizza(List<SaborPreferencia> preferencias){
		this.preferencias = preferencias;
	}
	
	public Map<String, List<String>> escolhe(SaborPreferencia sp){
		if(sp == null || !sp.valida()){
			throw new IllegalArgumentException();
		}
		
		HashMap<String, List<String>> hashMap = comprarPreferencias(sp);
		
		return hashMap;
	}

	private HashMap<String, List<String>> comprarPreferencias(SaborPreferencia sp) {
		HashMap<String, List<String>> recomendacoes = new HashMap<String, List<String>>();
		
		for(int i=0; i< preferencias.size(); i++){
			Map<String, Integer> preferenciaAmigo = preferencias.get(i).getPreferencias();
			Map<String, Integer> preferenciaMinha = sp.getPreferencias();

			if(preferenciaMinha.get("MARGUERITA").equals(preferenciaAmigo.get("MARGUERITA"))){
				ClassificaSaborDePizza(recomendacoes, i, "MARGUERITA");
			}
			
			if(preferenciaMinha.get("NAPOLITANA").equals(preferenciaAmigo.get("NAPOLITANA"))){
				ClassificaSaborDePizza(recomendacoes, i, "NAPOLITANA");
			}
			
			if(preferenciaMinha.get("QUATROQUEIJO").equals(preferenciaAmigo.get("QUATROQUEIJO"))){
				ClassificaSaborDePizza(recomendacoes, i, "QUATROQUEIJO");
			}
			
			if(preferenciaMinha.get("ESCAROLA").equals(preferenciaAmigo.get("ESCAROLA"))){
				ClassificaSaborDePizza(recomendacoes, i, "ESCAROLA");
			}
			
			if(preferenciaMinha.get("PORTUGUESA").equals(preferenciaAmigo.get("PORTUGUESA"))){
				ClassificaSaborDePizza(recomendacoes, i, "PORTUGUESA");
			}
			
			if(preferenciaMinha.get("FRANGOCATUPIRY").equals(preferenciaAmigo.get("FRANGOCATUPIRY"))){
				ClassificaSaborDePizza(recomendacoes, i, "FRANGOCATUPIRY");
			}
			
		}
			
		
		return recomendacoes;
	}

	private void ClassificaSaborDePizza(HashMap<String, List<String>> recomendacoes, int i, String saborPizza) {
		if(recomendacoes.containsKey(saborPizza)){
			List<String> quemGostaMarguarita = new ArrayList<String>(recomendacoes.get(saborPizza));
			quemGostaMarguarita.add(preferencias.get(i).getPessoa());
			recomendacoes.put(saborPizza, quemGostaMarguarita);
		}else{
			recomendacoes.put(saborPizza, Arrays.asList(preferencias.get(i).getPessoa()));
		}
	}
	
	
}
