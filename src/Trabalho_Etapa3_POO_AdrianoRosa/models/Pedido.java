package Trabalho_Etapa3_POO_AdrianoRosa.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido {
	
	private Integer id;
	private Cliente cliente;
	private Funcionario funcionario;
	private Double taxaServico;
	private ArrayList<Prato> itensConsumidos;
	private ArrayList<Integer> quantidades;
	private Double valorTotal;
	private LocalDate data;
	
	public Pedido() {
		super();
		this.itensConsumidos = new ArrayList<>();
		this.quantidades = new ArrayList<>();
	}

	public Pedido(Integer id, Cliente cliente, Funcionario funcionario, Double taxaServico, Double valorTotal,
			LocalDate data) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.taxaServico = taxaServico;
		this.valorTotal = valorTotal;
		this.data = data;
	}

	public Pedido(Integer id, Cliente cliente, Funcionario funcionario) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.funcionario = funcionario;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
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

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

}

