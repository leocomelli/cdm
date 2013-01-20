package dojo;
import java.util.HashMap;
import java.util.Map;

public class SaborPreferencia {

	private String pessoa;

	private Map<String, Integer> preferencias = new HashMap<String, Integer>();
	
	

	public SaborPreferencia(String pessoa, int marguerita, int quatroqueijo,
			int escarola, int portuguesa, int frangocatupiry, int napolitana) {
		super();
		
		this.setPessoa(pessoa);
		
		getPreferencias().put("MARGUERITA", marguerita);
		getPreferencias().put("QUATROQUEIJO", quatroqueijo);
		getPreferencias().put("ESCAROLA", escarola);
		getPreferencias().put("PORTUGUESA", portuguesa);
		getPreferencias().put("FRANGOCATUPIRY", frangocatupiry);
		getPreferencias().put("NAPOLITANA", napolitana);
	}

	public Map<String, Integer> getPreferencias() {
		return preferencias;
	}

	public void setPreferencias(Map<String, Integer> preferencias) {
		this.preferencias = preferencias;
	}

	public String getPessoa() {
		return pessoa;
	}

	public void setPessoa(String pessoa) {
		this.pessoa = pessoa;
	}

	public boolean valida() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
