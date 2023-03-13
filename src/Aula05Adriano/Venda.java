package Aula05Adriano;

import java.util.List;

public class Venda {

	private ClienteFuncionario cliente;
	private List<ItemVenda> itens;
	private ClienteFuncionario vendedor;
	private Double valorTotal;
	private Double valorTotalDesconto;
	
	public Venda(ClienteFuncionario cliente, List<ItemVenda> itens, ClienteFuncionario vendedor) {
		super();
		this.cliente = cliente;
		this.itens = itens;
		this.vendedor = vendedor;
		this.calcularValorTotal();
	}
	
	// Encapsulamento nos GETs e SETs

	public ClienteFuncionario getCliente() {
		return cliente;
	}
	public void setCliente(ClienteFuncionario cliente) {
		this.cliente = cliente;
	}
	public List<ItemVenda> getItens() {
		return itens;
	}
	public void setItens(List<ItemVenda> itens) {
		this.itens = itens;
	}
	public ClienteFuncionario getVendedor() {
		return vendedor;
	}
	public void setVendedor(ClienteFuncionario vendedor) {
		this.vendedor = vendedor;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Double getValorTotalDesconto() {
		return valorTotalDesconto;
	}
	public void setValorTotalDesconto(Double valorTotalDesconto) {
		this.valorTotalDesconto = valorTotalDesconto;
	}
	
	private void calcularValorTotal() {
		double total = 0;
		for(ItemVenda i : this.getItens()) {
			total += (i.getProduto().getPrecoUnitario() * i.getQuantidade());
		}
		this.setValorTotal(total);
	}
	
	public void calcularValorTotalDesconto(List<Venda> vendas) {
		if(cliente.getClass().getSimpleName().equals("Cliente")) {
			this.setValorTotalDesconto(((Cliente) this.getCliente()).calcularDesconto(vendas) * this.getValorTotal());
		}else {
			this.setValorTotalDesconto(this.getCliente().calcularDesconto() * this.getValorTotal());
		}
	}

}
