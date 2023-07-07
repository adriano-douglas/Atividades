package Trabalho_Etapa3_POO_AdrianoRosa.models;

import java.time.LocalDateTime;

public class Pagamento {
	
	private Integer id;
	private Pedido pedido;
	private TipoPagamento tipo;
	private Double valorPagoDinheiro;
	private LocalDateTime dataHora;

	public Pagamento() {
		super();
	}

	public Pagamento(Integer id, Pedido pedido, TipoPagamento tipo, Double valorPagoDinheiro) {
		super();
		this.id = id;
		this.pedido = pedido;
		this.tipo = tipo;
		this.valorPagoDinheiro = valorPagoDinheiro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public TipoPagamento getTipo() {
		return tipo;
	}

	public void setTipo(TipoPagamento tipo) {
		this.tipo = tipo;
	}

	public Double getValorPagoDinheiro() {
		return valorPagoDinheiro;
	}

	public void setValorPagoDinheiro(Double valorPagoDinheiro) {
		this.valorPagoDinheiro = valorPagoDinheiro;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

}

