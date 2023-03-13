package Aula05Adriano;

public class ItemVenda {
	
	private Produto produto;
	private Integer quantidade;
	
	// Sobrecarga nos construtores
	
	public ItemVenda() {
		super();
	}
	
	public ItemVenda(Produto produto, Integer quantidade) {
		super();
		this.produto = produto;
		this.quantidade = quantidade;
	}
	
	// Encapsulamento nos GETs e SETs

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
}
