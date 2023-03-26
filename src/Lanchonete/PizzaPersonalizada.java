package Lanchonete;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PizzaPersonalizada extends Prato {
	
	private Molho molho;
	private List<Recheio> recheios;
	private Borda borda;
	
	public PizzaPersonalizada(String nome, Date dataValidade, Double peso) {
		super(nome, dataValidade, peso);
	}
	
	public PizzaPersonalizada(String nome, Date dataValidade, Double peso, Molho molho, ArrayList<Recheio> recheios,
			Borda borda) {
		super(nome, dataValidade, peso);
		this.molho = molho;
		this.recheios = recheios;
		this.borda = borda;
	}

	public Molho getMolho() {
		return molho;
	}

	public void setMolho(Molho molho) {
		this.molho = molho;
	}

	public List<Recheio> getRecheios() {
		return recheios;
	}

	public void setRecheios(List<Recheio> recheiosPizzaPersonalizada) {
		this.recheios = recheiosPizzaPersonalizada;
	}

	public Borda getBorda() {
		return borda;
	}

	public void setBorda(Borda borda) {
		this.borda = borda;
	}
	
	public void calcularPreco() {
		double total = 0.0;
		for(Recheio r : this.getRecheios()) {
			total += r.getValor();
		}
		this.setPrecoVenda(10.0 + total + this.getMolho().getValor() + this.getBorda().getValor());
	}

}
