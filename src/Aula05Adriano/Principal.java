package Aula05Adriano;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Principal {
	
	public static void mostrarVendas(List<Venda> vendas) {
		System.out.println("-------------- TODAS AS VENDAS ---------------\n");
		Integer venda = 0;
		for(Venda v : vendas) {
			System.out.println("\n\t\t   VENDA " + ++venda);
			System.out.println("\n------------- Dados do Cliente ---------------\n");
			System.out.println("CPF DO CLIENTE: " + v.getCliente().getCpf());
			System.out.println("NOME DO CLIENTE: " + v.getCliente().getNome());
			System.out.println("\n------------- Lista de Produtos --------------\n");
			for(ItemVenda iv : v.getItens()) {
				System.out.println("CÓDIGO: " + iv.getProduto().getId());
				System.out.println("NOME: " + iv.getProduto().getNome());
				System.out.println("FORNECEDOR: " + iv.getProduto().getFornecedor().getNome());
				System.out.println("PREÇO UNITÁRIO: R$" + iv.getProduto().getPrecoUnitario());
				System.out.println("QUANTIDADE: " + iv.getQuantidade() + "\n");
			}
			System.out.println("------------- Dados do Vendedor ---------------\n");
			System.out.println("CPF DO VENDEDOR: " + v.getVendedor().getCpf());
			System.out.println("NOME DO VENDEDOR: " + v.getVendedor().getNome());
			System.out.println("\n------------- Valor da Venda ------------------\n");
			System.out.println("VALOR TOTAL: R$" + v.getValorTotal());
			System.out.println("VALOR TOTAL COM DESCONTO: R$" + v.getValorTotalDesconto() + "\n\n\n");
		}
	}

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		List<Produto> produtos = new ArrayList<Produto>();
		List<ClienteFuncionario> funcionarios = new ArrayList<ClienteFuncionario>();
		List<ClienteFuncionario> clientes = new ArrayList<ClienteFuncionario>();
		List<Venda> vendas = new ArrayList<Venda>();
		
		// Cadastros de fornecedores
		List<String> t = new ArrayList<String>(); t.add("11-1111-1111"); t.add("11-1111-2222");
		fornecedores.add(new Fornecedor("Fornecedor 1", "fornecedor1@email.com", "Rua f1, 11", t, "85.561.655/0001-91", formato.parse("21/02/1989")));
		
		t = new ArrayList<String>(); t.add("22-2222-2222"); t.add("22-2222-3333");
		fornecedores.add(new Fornecedor("Fornecedor 2", "fornecedor2@email.com", "Rua f2, 22", t, "49.287.556/0001-08", formato.parse("17/10/1997")));
		
		t = new ArrayList<String>(); t.add("33-3333-3333"); t.add("33-3333-4444");
		fornecedores.add(new Fornecedor("Fornecedor 3", "fornecedor3@email.com", "Rua f3, 33", t, "13.828.278/0001-01", formato.parse("09/11/2006")));
		
		// Cadastros de produtos
		produtos.add(new Produto(1, "Produto 1", 102.5, fornecedores.get(1)));
		produtos.add(new Produto(2, "Produto 2", 10.0, fornecedores.get(2)));
		produtos.add(new Produto(3, "Produto 3", 1002.75, fornecedores.get(0)));
		produtos.add(new Produto(4, "Produto 4", 58.99, fornecedores.get(2)));
		
		// Cadastro de funcionarios
		t = new ArrayList<String>(); t.add("(61) 3826-3326"); t.add("(91) 3778-6147");
		funcionarios.add(new Funcionario("Antônio", "antonio@email.com", "Rua A, 123", t, "046.371.740-66", formato.parse("01/05/2000"), formato.parse("23/01/2022"), "Vendedor"));
		
		t = new ArrayList<String>(); t.add("(74) 3644-3597"); t.add("(68) 3318-6027");
		funcionarios.add(new Funcionario("Carlos", "carlos@email.com", "Rua B, 456", t, "437.545.000-23", formato.parse("13/03/1995"), formato.parse("15/07/2019"), "Vendedor"));
		
		// Cadastro de clientes
		t = new ArrayList<String>(); t.add("(67) 2657-5101");
		clientes.add(new Cliente("Adriano", "adriano@email.com", "Rua C, 111", t, "082.317.340-23", formato.parse("14/08/1998")));
		
		t = new ArrayList<String>(); t.add("(66) 2140-0863");
		clientes.add(new Cliente("Igor", "igor@email.com", "Rua D, 222", t, "236.293.870-04", formato.parse("02/07/2001")));
		
		t = new ArrayList<String>(); t.add("(83) 2284-1743");
		clientes.add(new Cliente("Fernanda", "fernanda@email.com", "Rua E, 333", t, "247.848.100-64", formato.parse("20/12/1999")));
		
		// Vendas
		List<ItemVenda> itemVenda = new ArrayList<ItemVenda>(); 
		itemVenda.add(new ItemVenda(produtos.get(0), 2));
		itemVenda.add(new ItemVenda(produtos.get(3), 3));
		Venda venda = new Venda(clientes.get(0), itemVenda, funcionarios.get(1));
		venda.calcularValorTotalDesconto(vendas);
		vendas.add(venda);
		
		itemVenda = new ArrayList<ItemVenda>();
		itemVenda.add(new ItemVenda(produtos.get(1), 5));
		itemVenda.add(new ItemVenda(produtos.get(2), 1));
		itemVenda.add(new ItemVenda(produtos.get(3), 1));
		venda = new Venda(clientes.get(0), itemVenda, funcionarios.get(0));
		venda.calcularValorTotalDesconto(vendas);
		vendas.add(venda);
		
		itemVenda = new ArrayList<ItemVenda>();
		itemVenda.add(new ItemVenda(produtos.get(2), 1));
		itemVenda.add(new ItemVenda(produtos.get(3), 4));
		venda = new Venda(funcionarios.get(1), itemVenda, funcionarios.get(0));
		venda.calcularValorTotalDesconto(vendas);
		vendas.add(venda);
		
		itemVenda = new ArrayList<ItemVenda>();
		itemVenda.add(new ItemVenda(produtos.get(3), 6));
		venda = new Venda(funcionarios.get(1), itemVenda, funcionarios.get(0));
		venda.calcularValorTotalDesconto(vendas);
		vendas.add(venda);
		
		itemVenda = new ArrayList<ItemVenda>();
		itemVenda.add(new ItemVenda(produtos.get(0), 3));
		itemVenda.add(new ItemVenda(produtos.get(2), 1));
		venda = new Venda(clientes.get(1), itemVenda, funcionarios.get(0));
		venda.calcularValorTotalDesconto(vendas);
		vendas.add(venda);
		
		mostrarVendas(vendas);
	}

}
