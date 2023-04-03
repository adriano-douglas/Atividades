package Grafica;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Principal {
	
	static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public static Integer buscarIndicePedido(String ID, ArrayList<Pedido> pedidos) {
		Integer i = 0;
		for(Pedido p : pedidos) {
			if(ID.equalsIgnoreCase(p.getID())) return i;
			i++;
		}
		return null;
	}
	
	public static Setor buscarSetor(String ID, ArrayList<Setor> setores) {
		for(Setor s : setores) {
			if(ID.equals(s.getID())) return s;
		}
		return null;
	}
	
	public static Produto buscarProduto(String ID, ArrayList<Produto> produtos) {
		for(Produto p : produtos) {
			if(ID.equals(p.getID())) return p;
		}
		return null;
	}
	
	public static Empregado buscarEmpregado(String ID, ArrayList<Empregado> empregados, String setor) {
		for(Empregado e : empregados) {
			if(ID.equals(e.getID()) && setor.equals(e.getSetor().getNome())) return e;
		}
		return null;
	}
	
	public static Pessoa buscarPessoa(String ID, ArrayList<Pessoa> pessoas) {
		for(Pessoa p : pessoas) {
			if(ID.equals(p.getID())) return p;
		}
		return null;
	}
	
	public static void mostrarSetores(ArrayList<Setor> setores) {
		System.out.println("\nLISTA DE SETORES");
		for(Setor s : setores) {
			System.out.println(s.getID() + " - " + s.getNome());
		}
	}
	
	public static void mostrarPedidos(ArrayList<Pedido> pedidos, boolean completo, String texto) {
		if(pedidos.size() > 0) {
			System.out.println("\n\n========================================");
			System.out.println("\n\t   " + texto.toUpperCase() + "\n");
			System.out.println("========================================\n");
			for(Pedido p : pedidos) {
				int i = 0;
				System.out.println("--------------- PEDIDO " + p.getID() + " ---------------\n");
				System.out.println("Cliente:              " + p.getCliente().getNome());
				System.out.println("Funcionário venda:    " + p.getEmpregadoVenda().getNome());
				System.out.println("Funcionário produção: " + p.getEmpregadoProducao().getNome());
				System.out.println("Data de Emissão:      " + sdf.format(p.getDataHoraEmissao()));
				if(p.getDataHoraFinalizacao() != null) {
					System.out.println("Data de Finalização:  " + sdf.format(p.getDataHoraFinalizacao()));
				}
				System.out.println("Valor total:          R$" + p.getPreco());
				if(completo) {
					System.out.println("\n----------- LISTA DE PRODUTOS ----------\n");
					for(Produto produto : p.getProdutos()) {
						System.out.println(produto.getTipo() + " -- R$" + produto.getPreco() + " - " + p.getQuantidades().get(i) + " un");
						i++;
					}
				}
				System.out.println("\n");
			}
		} else {
			System.out.println("\nNENHUM PEDIDO ENCONTRADO!\n");
		}
	}
	
	public static void mostrarProdutos(ArrayList<Produto> produtos) {
		System.out.println("\nLISTA DE PRODUTOS");
		for(Produto p : produtos) {
			System.out.println(p.getID() + " - " + p.getTipo() + " --- R$" + p.getPreco());
		}
	}
	
	public static void mostrarEmpregados(ArrayList<Empregado> empregados, String setor) {
		System.out.println("\nLISTA DE FUNCIONÁRIOS DO SETOR DE " + setor.toUpperCase());
		for(Empregado e : empregados) {
			if(setor.equals(e.getSetor().getNome())) {
				System.out.println(e.getID() + " - " + e.getNome());
			}
		}
	}
	
	public static void mostrarClientes(ArrayList<Pessoa> clientes) {
		System.out.println("\nLISTA DE CLIENTES");
		for(Pessoa p : clientes) {
			System.out.println(p.getID() + " - " + p.getNome());
		}
	}
	
	public static void menu(String funcao) {
		System.out.println("\n==============================");
		System.out.println("|            GRÁFICA         |");
		System.out.println("==============================");
		System.out.println("1 - Criar pedido");
		System.out.println("2 - Listar pedidos em produção");
		if(funcao.equals("Gerente"))
			System.out.println("3 - Cadastrar funcionário");
		System.out.println("4 - Trocar usuário");
		System.out.println("5 - Finalizar pedido");
		System.out.println("6 - Listar pedidos finalizados");
		System.out.println("7 - Sair");
		System.out.println("==============================");
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		ArrayList<Pessoa> clientes = new ArrayList<Pessoa>();
		clientes.add(new Cliente("1", "111.111.111-11", "Adriano", "M", "adriano@email.com"));
		clientes.get(0).adicionarTelefone("11-91111-1111");
		clientes.add(new Cliente("2", "222.222.222-22", "Igor", "M", "igor@email.com"));
		clientes.get(1).adicionarTelefone("22-92222-2222");
		
		ArrayList<Setor> setores = new ArrayList<Setor>();
		setores.add(new SetorVenda("1", "Venda"));
		setores.add(new SetorProducao("2", "Producao"));
		setores.add(new SetorFinanceiro("3", "Financeiro"));
		
		ArrayList<Gerente> gerentes = new ArrayList<Gerente>();
		gerentes.add(new Gerente("3", "333.333.333-33", "João", "M", "joao@email.com", 4000.0, setores.get(0)));
		gerentes.get(0).adicionarTelefone("33-93333-3333");
		gerentes.add(new Gerente("4", "444.444.444-44", "Ana", "F", "ana@email.com", 4000.0, setores.get(1)));
		gerentes.get(0).adicionarTelefone("44-94444-4444");
		gerentes.add(new Gerente("5", "555.555.555-55", "Fernanda", "F", "fernanda@email.com", 4000.0, setores.get(2)));
		gerentes.get(0).adicionarTelefone("55-95555-5555");
		
		setores.get(0).setGerente(gerentes.get(0));
		setores.get(1).setGerente(gerentes.get(1));
		setores.get(2).setGerente(gerentes.get(2));
		
		ArrayList<Empregado> empregados = new ArrayList<Empregado>();
		empregados.add(new EmpregadoVenda("6", "666.666.666-66", "Lucas", "M", "lucas@email.com", 2000.0, "Vendedor", setores.get(0)));
		empregados.get(0).adicionarTelefone("66-96666-6666");
		empregados.add(new EmpregadoVenda("7", "777.777.777-77", "Julia", "F", "julia@email.com", 2000.0, "Vendedor", setores.get(0)));
		empregados.get(0).adicionarTelefone("77-97777-7777");
		empregados.add(new EmpregadoProducao("8", "888.888.888-88", "José", "M", "jose@email.com", 2000.0, "Operador", setores.get(1)));
		empregados.get(0).adicionarTelefone("88-98888-8888");
		empregados.add(new EmpregadoProducao("9", "999.999.999-99", "Maria", "F", "maria@email.com", 2000.0, "Operador", setores.get(1)));
		empregados.get(0).adicionarTelefone("99-99999-9999");
		
		setores.get(0).adicionarEmpregado(empregados.get(0));
		setores.get(0).adicionarEmpregado(empregados.get(1));
		setores.get(1).adicionarEmpregado(empregados.get(2));
		setores.get(1).adicionarEmpregado(empregados.get(3));
		
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		produtos.add(new Produto("1", "Banner", 20.0));
		produtos.add(new Produto("2", "Livro", 30.0));
		produtos.add(new Produto("3", "Panfleto", 10.0));
		produtos.add(new Produto("4", "Revista", 25.0));
		
		Integer idPessoa = 9;
		Integer idPedido = 1;
		
		ArrayList<Pedido> pedidosProducao = new ArrayList<Pedido>();
		ArrayList<Pedido> pedidosFinalizados = new ArrayList<Pedido>();
		
		String funcao = "";
		boolean trocar = true;
		
		boolean sair = false;
		while(!sair) {
			
			if(trocar) {
				System.out.println("Qual a sua função?");
				System.out.println("====================");
				System.out.println("1 - Gerente");
				System.out.println("2 - Funcionário");
				System.out.println("====================");
				
				boolean usuarioInvalido = true;
				
				while(usuarioInvalido) {
					System.out.print(">>> ");
					funcao = scan.nextLine().strip();
					
					usuarioInvalido = false;
					trocar = false;
					
					if(funcao.equals("1")) {
						funcao = "Gerente";
					} else if(funcao.equals("2")) {
						funcao = "Funcionario";
					} else {
						System.out.println("Opção Inválida!");
						usuarioInvalido = true;
						trocar = true;
					}
				}
			}
	
			menu(funcao);
			String opcao;
			boolean opcaoInvalida = true;
			
			while(opcaoInvalida) {
				System.out.print(">>> ");
				opcao = scan.nextLine().strip();
				
				switch(opcao.strip()) {
				case "1":
					
					Pedido pedido = new Pedido();
					pedido.setID((idPedido++).toString());
					
					boolean clienteInvalido = true;
					mostrarClientes(clientes);
					while(clienteInvalido) {
						System.out.print("\nInforme o código do cliente: ");
						String ID = scan.nextLine().strip();
						Cliente cliente = (Cliente) buscarPessoa(ID, clientes);
						if(cliente == null) {
							System.out.println("\nCliente com ID '" + ID + "' não encontrado no sistema. Tente novamente!");
						} else {
							pedido.setCliente(cliente);
							clienteInvalido = false;
						}
					}
					mostrarEmpregados(empregados, "Venda");
					boolean empregadoInvalido = true;
					while(empregadoInvalido) {
						System.out.print("\nInforme o código do funcionário responsável pela venda: ");
						String ID = scan.nextLine().strip();
						Empregado empregado = buscarEmpregado(ID, empregados, "Venda");
						if(empregado == null) {
							System.out.println("\nFuncionário de vendas com ID '" + ID + "' não encontrado no sistema. Tente novamente!");
						} else {
							pedido.setEmpregadoVenda((EmpregadoVenda) empregado);
							empregadoInvalido = false;
						}
					}
					mostrarProdutos(produtos);
					boolean adicionarProduto = true;
					while(adicionarProduto) {
						boolean produtoInvalido = true;
						while(produtoInvalido) {
							System.out.print("\nInforme o código do produto: ");
							String ID = scan.nextLine().strip();
							Produto produto = buscarProduto(ID, produtos);
							if(produto == null) {
								System.out.println("\nProduto com ID '" + ID + "' não encontrado no sistema. Tente novamente!");
							} else {
								System.out.print("Informe a quantidade: ");
								pedido.adicionarQuantidade(Integer.parseInt(scan.nextLine()));
								pedido.adicionarProduto(produto);
								produtoInvalido = false;
							}
						}
						System.out.print("\nDeseja adicionar outro produto no pedido? S/N: ");
						String opcaoAdicionarProduto = scan.nextLine().strip();
						if(opcaoAdicionarProduto.equalsIgnoreCase("N")) {
							adicionarProduto = false;
						}
					}
					
					pedido.setDataHoraEmissao(new Date());
					pedido.calcularPreco();
					
					System.out.print("\n*****************************************************************************************");
					System.out.println("\nPedido realizado com sucesso! Status: pendente.");
					System.out.println("\nValor total do pedido: R$" + pedido.getPreco());
					System.out.println("\nPara repassar o pedido para a produção, informe o funcionário responsável pela produção.");
					System.out.println("\n*****************************************************************************************");
					
					mostrarEmpregados(empregados, "Producao");
					boolean empregadoProducaoInvalido = true;
					while(empregadoProducaoInvalido) {
						System.out.print("\nInforme o ID do funcionário responsável pela produção dos produtos: ");
						String ID = scan.nextLine().strip();
						Empregado empregado = buscarEmpregado(ID, empregados, "Producao");
						if(empregado == null) {
							System.out.println("\nFuncionário de produção com ID '" + ID + "' não encontrado no sistema. Tente novamente!");
						} else {
							pedido.setEmpregadoProducao((EmpregadoProducao) empregado);
							empregadoProducaoInvalido = false;
						}
					}
					
					pedidosProducao.add(pedido);
					System.out.println("\nPedido enviado para produção!\n");
					
					opcaoInvalida = false;
					break;
				case "2":
					mostrarPedidos(pedidosProducao, true, "pedidos produção");
					opcaoInvalida = false;
					break;
				case "3":
					if(funcao.equals("Gerente")) {
					System.out.print("\nInforme o cpf: ");
					String cpf = scan.nextLine();
					System.out.print("Informe o nome: ");
					String nome = scan.nextLine();
					System.out.print("Informe o sexo: ");
					String sexo = scan.nextLine();
					System.out.print("Informe o email: ");
					String email = scan.nextLine();
					System.out.print("Informe o salário: ");
					double salario = Double.parseDouble(scan.nextLine());
					System.out.print("Informe a ocupação: ");
					String ocupacao = scan.nextLine();
					
					mostrarSetores(setores);
					boolean setorInvalido = true;
					while(setorInvalido) {
						System.out.print("\nInforme o código do setor: ");
						String ID = scan.nextLine().strip();
						Setor setor = buscarSetor(ID, setores);
						if(setor == null) {
							System.out.println("\nSetor com ID '" + ID + "' não encontrado no sistema. Tente novamente!");
						} else {
							Empregado empregado = new Empregado((idPessoa++).toString(), cpf, nome, sexo, email, salario, ocupacao, setor);;
							if(setor.getNome().equals("Venda")) {
								empregado = new EmpregadoVenda((idPessoa++).toString(), cpf, nome, sexo, email, salario, ocupacao, setor);
							} else if(setor.getNome().equals("Producao")) {
								empregado = new EmpregadoProducao((idPessoa++).toString(), cpf, nome, sexo, email, salario, ocupacao, setor);
							}
							empregados.add(empregado);
							setor.adicionarEmpregado(empregado);
							setorInvalido = false;
							System.out.println("\nFunciónario " + empregado.getNome() + " adicionado com sucesso no setor " + empregado.getSetor().getNome() + "!\n");
						}
					}
					
					opcaoInvalida = false;
					} else {
						System.out.println("Opção inválida!");
					}
					break;
				case "4":
					trocar = true;
					opcaoInvalida = false;
					break;
				case "5":
					mostrarPedidos(pedidosProducao, false, "\tpedidos");
					if(pedidosProducao.size() > 0) {
						boolean pedidoInvalido = true;
						while(pedidoInvalido) {
							System.out.print("\nInforme o número do pedido a ser finalizado: ");
							String ID = scan.nextLine().strip();
							Integer indicePedido = buscarIndicePedido(ID, pedidosProducao);
							if(indicePedido == null) {
								System.out.println("\nPedido com ID '" + ID + "' não encontrado no sistema. Tente novamente!");
							} else {
								Pedido pedidoFinalizado = pedidosProducao.remove(indicePedido.intValue());
								pedidoFinalizado.setDataHoraFinalizacao(new Date());
								pedidosFinalizados.add(pedidoFinalizado);
								pedidoInvalido = false;
								System.out.println("\nPedido " + ID + " finalizado com sucesso!\n");
							}
						}
					}
					opcaoInvalida = false;
					break;
				case "6":
					mostrarPedidos(pedidosFinalizados, true, "pedidos finalizados");
					opcaoInvalida = false;
					break;
				case "7":
					System.out.println("\nSAINDO...\n");
					opcaoInvalida = false;
					sair = true;
					break;
				default:
					System.out.println("Opção inválida!");
					break;
				}
			}
		
		}
		
		scan.close();
	}

}
