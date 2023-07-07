package Trabalho_Etapa3_POO_AdrianoRosa.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pizza extends Prato {

	private Molho molho;
	private ArrayList<Recheio> recheios;
	private Borda borda;

	public Pizza() {
		super();
		this.recheios = new ArrayList<>();
	}

	public Pizza(Integer id, String nome, Double precoVenda, LocalDate dataValidade, Double peso, Molho molho,
			Borda borda) {
		super(id, nome, precoVenda, dataValidade, peso);
		this.molho = molho;
		this.borda = borda;
		this.recheios = new ArrayList<>();
	}

	public Pizza(Integer id, String nome, Double precoVenda, LocalDate dataValidade, Double peso, Molho molho,
			ArrayList<Recheio> recheios, Borda borda) {
		super(id, nome, precoVenda, dataValidade, peso);
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

	public ArrayList<Recheio> getRecheios() {
		return recheios;
	}

	public void setRecheios(ArrayList<Recheio> recheios) {
		this.recheios = recheios;
	}

	public Borda getBorda() {
		return borda;
	}

	public void setBorda(Borda borda) {
		this.borda = borda;
	}

	public void adicionarRecheio(Recheio recheio) {
		this.getRecheios().add(recheio);
	}

	public void calcularPreco() {
		Double preco = 10.0;
		for (Recheio r : this.getRecheios()) {
			preco += r.getValor();
		}
		preco += this.getMolho().getValor();
		preco += this.getBorda().getValor();
		if (this.getBorda().getRecheio() != null)
			preco += this.getBorda().getRecheio().getValor();
		this.setPrecoVenda(preco);
	}

}
