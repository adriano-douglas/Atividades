package Lanchonete;

import java.util.Date;

public class Salgadinho extends Prato {
	
	private String recheio;
	private String massa;
	private String tipo;

	public Salgadinho(String ID, String nome, Double precoVenda, Date dataValidade, Double peso, String recheio,
			String massa, String tipo) {
		super(ID, nome, precoVenda, dataValidade, peso);
		this.recheio = recheio;
		this.massa = massa;
		this.tipo = tipo;
	}

	public String getRecheio() {
		return recheio;
	}

	public void setRecheio(String recheio) {
		this.recheio = recheio;
	}

	public String getMassa() {
		return massa;
	}

	public void setMassa(String massa) {
		this.massa = massa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
