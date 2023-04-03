package Grafica;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {
	
	private String ID;
	private Cliente cliente;
	private Date dataHoraEmissao;
	private Date dataHoraFinalizacao;
	private Double preco;
	private EmpregadoVenda empregadoVenda;
	private EmpregadoProducao empregadoProducao;
	private ArrayList<Produto> produtos;
	private ArrayList<Integer> quantidades;
	
	public Pedido() {
		super();
		this.produtos = new ArrayList<Produto>();
		this.quantidades = new ArrayList<Integer>();
	}

	public Pedido(String ID, Cliente cliente, Date dataHoraEmissao, Date dataHoraFinalizacao, Double preco,
			EmpregadoVenda empregadoVenda) {
		super();
		this.ID = ID;
		this.cliente = cliente;
		this.dataHoraEmissao = dataHoraEmissao;
		this.dataHoraFinalizacao = dataHoraFinalizacao;
		this.preco = preco;
		this.empregadoVenda = empregadoVenda;
		this.produtos = new ArrayList<Produto>();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getDataHoraEmissao() {
		return dataHoraEmissao;
	}

	public void setDataHoraEmissao(Date dataHoraEmissao) {
		this.dataHoraEmissao = dataHoraEmissao;
	}

	public Date getDataHoraFinalizacao() {
		return dataHoraFinalizacao;
	}

	public void setDataHoraFinalizacao(Date dataHoraFinalizacao) {
		this.dataHoraFinalizacao = dataHoraFinalizacao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public EmpregadoVenda getEmpregadoVenda() {
		return empregadoVenda;
	}

	public void setEmpregadoVenda(EmpregadoVenda empregadoVenda) {
		this.empregadoVenda = empregadoVenda;
	}

	public ArrayList<Produto> getProdutos() {
		return this.produtos;
	}
	
	public void adicionarProduto(Produto produto) {
		this.getProdutos().add(produto);
	}
	
	public void calcularPreco() {
		double soma = 0;
		int i = 0;
		for(Produto p : this.getProdutos()) {
			soma += (p.getPreco() * this.getQuantidades().get(i));
			i++;
		}
		this.setPreco(soma);
	}

	public EmpregadoProducao getEmpregadoProducao() {
		return empregadoProducao;
	}

	public void setEmpregadoProducao(EmpregadoProducao empregadoProducao) {
		this.empregadoProducao = empregadoProducao;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public ArrayList<Integer> getQuantidades() {
		return quantidades;
	}
	
	public void adicionarQuantidade(Integer quantidade) {
		this.getQuantidades().add(quantidade);
	}

}
