package Lanchonete;

import java.util.ArrayList;

public class Pedido {
	
	private String nomeCliente;
	private String nomeFuncionario;
	private Double taxaServico;
	private ArrayList<Prato> itensConsumidos;
	private ArrayList<Integer> quantidades;
	private Double valorTotal;
	
	public Pedido() {
		super();
	}
	
	public Pedido(String nomeCliente, String nomeFuncionario, Double taxaServico, ArrayList<Prato> itensConsumidos) {
		super();
		this.nomeCliente = nomeCliente;
		this.nomeFuncionario = nomeFuncionario;
		this.taxaServico = taxaServico;
		this.itensConsumidos = itensConsumidos;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public Double getTaxaServico() {
		return taxaServico;
	}

	public void setTaxaServico(Double taxaServico) {
		this.taxaServico = taxaServico;
	}

	public ArrayList<Prato> getItensConsumidos() {
		return itensConsumidos;
	}

	public void setItensConsumidos(ArrayList<Prato> itensConsumidos) {
		this.itensConsumidos = itensConsumidos;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public ArrayList<Integer> getQuantidades() {
		return quantidades;
	}

	public void setQuantidades(ArrayList<Integer> quantidades) {
		this.quantidades = quantidades;
	}
	
	public void calcularTotal() {
		double total = 0;
		int i = 0;
		for(Prato p : this.getItensConsumidos()) {
			total += (p.getPrecoVenda() * this.getQuantidades().get(i));
			i++;
		}
		this.setValorTotal(total + this.getTaxaServico());
	}
	
	public void mostrarFatura() {
		System.out.println("\nValor total da fatura: R$" + this.getValorTotal());
		System.out.println("\t\t     -----------");
	}
	
}
