package Lanchonete;

public class Pagamento {
	
	private String tipo;
	private Pedido pedido;
	private Double valorPagoDinheiro;
	
	public Pagamento() {
		super();
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public void gerarNotaFiscal() {
		System.out.print("\n---------------------------------------------\n");
		System.out.print("                 NOTA FISCAL                 \n");
		System.out.print("---------------------------------------------\n");
		System.out.print("Nome do cliente: " + pedido.getNomeCliente() + "\n");
		System.out.print("Nome do atendente: " + pedido.getNomeFuncionario() + "\n");
		System.out.print("Taxa de serviço: R$" + pedido.getTaxaServico() + "\n");
		System.out.print("---------------------------------------------\n");
		System.out.print("             ITENS CONSUMIDOS                \n");
		System.out.print("---------------------------------------------\n");
		int i = 0;
		for(Prato p : pedido.getItensConsumidos()) {
			System.out.print("Nome do prato: " + p.getNome() + "\n");
			System.out.print("Preço: R$" + p.getPrecoVenda() + "\n");
			System.out.print("Quantidade: " + getPedido().getQuantidades().get(i) + "\n");
			System.out.print("Peso unitário: " + p.getPeso() + "g\n");
			System.out.println();
			i++;
		}
		System.out.print("---------------------------------------------\n");
		System.out.print("Forma de pagamento: " + this.getTipo() + "\n");
		System.out.print("Valor total: R$" + pedido.getValorTotal());
		if(this.getTipo().equals("Dinheiro")) {
			this.mostrarTroco();
		} else {
			System.out.println();
		}
		System.out.print("---------------------------------------------\n\n");
	}
	
	public void mostrarTroco() {
		System.out.println("\nValor pago:  R$" + this.getValorPagoDinheiro());
		System.out.print("Troco:       R$" + (this.getValorPagoDinheiro() - this.getPedido().getValorTotal()) + "\n");
	}

	public Double getValorPagoDinheiro() {
		return valorPagoDinheiro;
	}

	public void setValorPagoDinheiro(Double valorPagoDinheiro) {
		this.valorPagoDinheiro = valorPagoDinheiro;
	}

}
