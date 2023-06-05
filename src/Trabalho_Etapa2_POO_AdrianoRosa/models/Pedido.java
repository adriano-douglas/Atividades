package Trabalho_Etapa2_POO_AdrianoRosa.models;

import java.util.ArrayList;

public class Pedido {
	
	private Integer id;
	private String nomeCliente;
	private String nomeFuncionario;
	private Double taxaServico;
	private ArrayList<Prato> itensConsumidos;
	private ArrayList<Integer> quantidades;
	private Double valorTotal;
	
	public Pedido() {
		super();
		this.itensConsumidos = new ArrayList<>();
		this.quantidades = new ArrayList<>();
	}

	public Pedido(Integer id, String nomeCliente, String nomeFuncionario) {
		super();
		this.id = id;
		this.nomeCliente = nomeCliente;
		this.nomeFuncionario = nomeFuncionario;
		this.taxaServico = 10.0;
		this.itensConsumidos = new ArrayList<>();
		this.quantidades = new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public ArrayList<Integer> getQuantidades() {
		return quantidades;
	}

	public void setQuantidades(ArrayList<Integer> quantidades) {
		this.quantidades = quantidades;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public Double divideValor(Integer totalPessoas) {
		return this.getValorTotal() / totalPessoas;
	}

	public void calcularTotal() {
		Double total = this.getTaxaServico();
		int i = 0;
		for(Prato p : this.getItensConsumidos()) {
			total += (p.getPrecoVenda() * this.getQuantidades().get(i));
			i++;
		}
		this.setValorTotal(total);
	}

}

