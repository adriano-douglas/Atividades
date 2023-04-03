package Lanchonete;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
	
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	static List<Pessoa> clientes = new ArrayList<Pessoa>();
	static List<Pessoa> atendentes = new ArrayList<Pessoa>();
	static List<Molho> molhosPizza = new ArrayList<Molho>();
	static List<Recheio> recheiosPizza = new ArrayList<Recheio>();
	static List<Recheio> recheiosBordaPizza = new ArrayList<Recheio>();
	static List<Pizza> pizzas = new ArrayList<Pizza>();
	static List<Lanche> lanches = new ArrayList<Lanche>();
	static List<Salgadinho> salgadinhos = new ArrayList<Salgadinho>();
	static List<Prato> pratos = new ArrayList<Prato>();
	
	public static void carregarDados() throws ParseException {
		ArrayList<String> telefones = new ArrayList<String>(); telefones.add("11-91111-1111");
		clientes.add(new Cliente("1", "Adriano", "111.111.111-11", "Rua A, 11", telefones));
		telefones = new ArrayList<String>(); telefones.add("22-92222-2222");
		clientes.add(new Cliente("2", "Igor", "222.222.222-22", "Rua B, 22", telefones));
		
		telefones = new ArrayList<String>(); telefones.add("33-93333-3333");
		atendentes.add(new Funcionario("3", "Pedro", "333.333.333-33", "Rua C, 33", telefones, 1500.0));
		telefones = new ArrayList<String>(); telefones.add("44-94444-4444");
		atendentes.add(new Funcionario("4", "Lucas", "444.444.444-44", "Rua D, 44", telefones, 1500.0));
		
		molhosPizza.add(new Molho("1", "Molho de tomate tradicional", 7.0));
		molhosPizza.add(new Molho("2", "Molho gorgonzola", 12.0));
		molhosPizza.add(new Molho("3", "Molho parisiense", 10.0));
		molhosPizza.add(new Molho("4", "Molho picante", 8.5));
		molhosPizza.add(new Molho("5", "Molho de strogonoff", 9.0));
		
		recheiosPizza.add(new Recheio("1", "tomate", 4.0));
		recheiosPizza.add(new Recheio("2", "folhas de manjericão", 3.0));
		recheiosPizza.add(new Recheio("3", "mozzarella de búfala", 14.0));
		recheiosPizza.add(new Recheio("4", "queijo muçarela", 6.0));
		recheiosPizza.add(new Recheio("5", "calabresa", 8.0));
		recheiosPizza.add(new Recheio("6", "cebola roxa", 4.0));
		recheiosPizza.add(new Recheio("7", "pepperoni", 10.0));
		recheiosPizza.add(new Recheio("8", "ovo cozido", 5.0));
		recheiosPizza.add(new Recheio("9", "presunto", 6.0));
		recheiosPizza.add(new Recheio("10", "milho", 4.0));
		recheiosPizza.add(new Recheio("11", "pimentão", 3.0));
		recheiosPizza.add(new Recheio("12", "azeitonas pretas", 5.0));
		recheiosPizza.add(new Recheio("13", "orégano", 2.0));
		recheiosPizza.add(new Recheio("14", "frango desfiado", 10.0));
		recheiosPizza.add(new Recheio("15", "queijo de búfala", 13.0));
		recheiosPizza.add(new Recheio("16", "parmesão", 12.0));
		
		recheiosBordaPizza.add(new Recheio("1", "Calabresa", 7.0));
		recheiosBordaPizza.add(new Recheio("2", "Calabresa com Catupiry", 12.0));
		recheiosBordaPizza.add(new Recheio("3", "Cream Cheese Philadelphia", 10.0));
		recheiosBordaPizza.add(new Recheio("4", "Requeijão", 5.0));
		recheiosBordaPizza.add(new Recheio("5", "Cheddar", 9.0));
		
		pizzas.add(new Pizza("P1", "Pizza marguerita", 40.0, sdf.parse("12/04/2023"), 1300.0, "Molho de tomate", "mozzarella de búfala, tomate, manjericão, orégano", "tradicional"));
		pizzas.add(new Pizza("P2", "Pizza calabresa", 50.0, sdf.parse("12/04/2023"), 1500.0, "Molho de tomate", "queijo muçarela, calabresa, cebola roxa, orégano", "tradicional"));
		pizzas.add(new Pizza("P3", "Pizza de pepperoni", 45.0, sdf.parse("12/04/2023"), 1400.0, "Molho de tomate", "muçarela, pepperoni, orégano", "tradicional"));
		pizzas.add(new Pizza("P4", "Pizza portuguesa", 65.0, sdf.parse("12/04/2023"), 1500.0, "Molho de tomate", "muçarela, calabresa, cebola roxa, presunto, ovo cozido, tomate, pimentão, azeitona preta, orégano", "tradicional"));
		pizzas.add(new Pizza("P5", "Pizza de frango", 57.0, sdf.parse("12/04/2023"), 1500.0, "Molho de tomate", "frango desfiado, requeijão, tomate, muçarela, milho", "tradicional"));
		
		lanches.add(new Lanche("L1", "Pão com mortadela", 5.0, sdf.parse("12/04/2023"), 100.0, "Pão francês", "mortadela", "sem molho"));
		lanches.add(new Lanche("L2", "Misto quente", 7.0, sdf.parse("12/04/2023"), 100.0, "Pão de forma", "presunto, muçarela", "sem molho"));
		lanches.add(new Lanche("L3", "Baguete recheada", 15.0, sdf.parse("12/04/2023"), 200.0, "Baguete", "carne ensopada e desfiada", "molho de tomate"));
		
		salgadinhos.add(new Salgadinho("S1", "Coxinha", 5.0, sdf.parse("12/04/2023"), 90.0, "frango, catupiry", "massa cozida", "frito"));
		salgadinhos.add(new Salgadinho("S2", "Empadinha", 7.0, sdf.parse("12/04/2023"), 90.0, "frango", "massa crua", "assado"));
		salgadinhos.add(new Salgadinho("S3", "Enroladinho de salsicha", 4.0, sdf.parse("12/04/2023"), 70.0, "salsicha", "massa cozida", "frito"));
		
		pratos.addAll(pizzas);
		pratos.addAll(lanches);
		pratos.addAll(salgadinhos);
	}
	
	public static Pessoa buscarPessoa(String codigo, List<Pessoa> pessoas) {
		for(Pessoa p : pessoas) {
			if(codigo.equals(p.getCodigo())) return p;
		}
		return null;
	}
	
	public static Recheio buscarRecheio(String ID, List<Recheio> recheios) {
		for(Recheio r : recheios) {
			if(ID.equals(r.getID())) return r;
		}
		return null;
	}
	
	public static Molho buscarMolho(String ID, List<Molho> molhos) {
		for(Molho m : molhos) {
			if(ID.equals(m.getID())) return m;
		}
		return null;
	}
	
	public static void listarPessoas(List<Pessoa> pessoas) {
		System.out.println();
		for(Pessoa p : pessoas) {
			System.out.println(p.getCodigo() + " - " + p.getNome());
		}
	}
	
	public static void listarRecheios(List<Recheio> recheios) {
		System.out.println();
		for(Recheio r : recheios) {
			System.out.println(r.getID() + " - " + r.getNome() + " --- R$" + r.getValor());
		}
	}
	
	public static void listarMolhos(List<Molho> molhos) {
		System.out.println();
		for(Molho m : molhos) {
			System.out.println(m.getID() + " - " + m.getNome() + " --- R$" + m.getValor());
		}
	}
	
	public static Prato buscarPrato(String ID, List<Prato> pratos) {
		for(Prato p : pratos) {
			if(p.getID().equalsIgnoreCase(ID)) return p;
		}
		return null;
	}
	
	public static void mostrarPedidos(ArrayList<Pedido> pedidos) {
		if(pedidos.size() <= 0) {
			System.out.println("\nNenhum pedido foi realizado!\n"); return;
		}
		int i = 0;
		System.out.print("\n---------------------------------------------\n");
		System.out.print("               LISTA DE PEDIDOS              \n");
		System.out.print("---------------------------------------------\n\n");
		for(Pedido p : pedidos) {
			System.out.print("\n               * PEDIDO " + ++i + " *\n");
			System.out.print("---------------------------------------------\n");
			System.out.print("Nome do cliente: " + p.getNomeCliente() + "\n");
			System.out.print("Nome do atendente: " + p.getNomeFuncionario() + "\n");
			System.out.print("Taxa de serviço: R$" + p.getTaxaServico() + "\n");
			System.out.print("---------------------------------------------\n");
			System.out.print("             ITENS CONSUMIDOS                \n");
			System.out.print("---------------------------------------------\n");
			int j = 0;
			for(Prato prato : p.getItensConsumidos()) {
				System.out.print("Nome do prato: " + prato.getNome() + "\n");
				System.out.print("Preço: R$" + prato.getPrecoVenda() + "\n");
				System.out.print("Quantidade: " + p.getQuantidades().get(j) + "\n");
				System.out.println();
				j++;
			}
			System.out.print("---------------------------------------------\n");
			System.out.print("Valor total: R$" + p.getValorTotal());
			System.out.print("\n---------------------------------------------\n\n");
		}
	}
	
	public static void mostrarControle() {
		if(Controle.getTotalPratos() > 0) {
			System.out.println("\n----------------------------------------------\n");
			System.out.println("CONTROLE DE VENDAS:\n");
			System.out.println("Total de pratos: " + Controle.getTotalPratos());
			System.out.println("Total de Pizzas: " + Controle.getTotalPizzas());
			System.out.println("\t Pizza marguerita: " + Controle.getTotalP1());
			System.out.println("\t Pizza calabresa: " + Controle.getTotalP2());
			System.out.println("\t Pizza de pepperoni: " + Controle.getTotalP3());
			System.out.println("\t Pizza portuguesa: " + Controle.getTotalP4());
			System.out.println("\t Pizza de frango: " + Controle.getTotalP5());
			System.out.println("\t Pizza personalizada: " + Controle.getTotalPP());
			System.out.println("Total de Lanches: " + Controle.getTotalLanches());
			System.out.println("\t Pão com mortadela: " + Controle.getTotalL1());
			System.out.println("\t Misto quente: " + Controle.getTotalL2());
			System.out.println("\t Baguete recheada: " + Controle.getTotalL3());
			System.out.println("Total de Salgadinhos: " + Controle.getTotalSalgadinhos());
			System.out.println("\t Coxinha: " + Controle.getTotalS1());
			System.out.println("\t Empadinha: " + Controle.getTotalS2());
			System.out.println("\t Enroladinho de salsicha: " + Controle.getTotalS3());
			System.out.println("\n----------------------------------------------\n");
		} else {
			System.out.println("\nNenhum pedido foi realizado!\n");
		}
	}
	
	public static void mostrarCardapio(List<Pizza> p, List<Lanche> l, List<Salgadinho> s) {
		System.out.println("\n---------------------------------------");
		System.out.println("                CARDÁPIO               ");
		System.out.println("---------------------------------------");
		System.out.println("\nPIZZAS:\n");
		for(Pizza pizza : p) {
			System.out.println(pizza.getID() + " - " + pizza.getNome() + " --- R$" + pizza.getPrecoVenda());
		}
		System.out.println("P  - PIZZA PERSONALIZADA");
		System.out.println("\nLANCHES:\n");
		for(Lanche lanche : l) {
			System.out.println(lanche.getID() + " - " + lanche.getNome() + " --- R$" + lanche.getPrecoVenda());
		}
		System.out.println("\nSALGADINHOS:\n");
		for(Salgadinho salgadinho : s) {
			System.out.println(salgadinho.getID() + " - " + salgadinho.getNome() + " --- R$" + salgadinho.getPrecoVenda());
		}
		System.out.print("\n---------------------------------------");
	}
	
	public static void mostrarMenu() {
		System.out.println("=======================================");
		System.out.println("--- Lanchonete “Quase Três Lanches” ---".toUpperCase());	
		System.out.println("=======================================");
		System.out.println("1 - Criar pedido");
		System.out.println("2 - Listar pedidos");
		System.out.println("3 - Visualizar controle de vendas");
		System.out.println("4 - Sair");
		System.out.println("=======================================");
	}

	public static void main(String[] args) throws ParseException {
		
		Scanner entrada = new Scanner(System.in);
		Principal.carregarDados();
		
		List<Pedido> pedidos = new ArrayList<Pedido>();
		
		boolean sair = false;
		while(!sair) {
		
			mostrarMenu();
			
			boolean opcaoMenuInvalida = true;
			while(opcaoMenuInvalida) {
				System.out.print(">>> ");
				String opcaoMenu = entrada.nextLine();
				switch(opcaoMenu) {
				case "1":
					
					Pedido pedido = new Pedido();
					List<Prato> itensConsumidos = new ArrayList<Prato>();
					List<Integer> quantidades = new ArrayList<Integer>();
					
					boolean codigoClienteInvalido = true;
					listarPessoas(clientes);
					while(codigoClienteInvalido) {
						System.out.print("\nInforme o código do cliente: ");
						String codigoCliente = entrada.nextLine();
						Cliente cliente = (Cliente) buscarPessoa(codigoCliente, clientes);
						if(cliente == null) {
							System.out.println("\nO cliente com o código '" + codigoCliente + "' não foi encontrado no sistema. Tente novamente.");
						} else {
							codigoClienteInvalido = false;
							pedido.setNomeCliente(cliente.getNome());
						}
					}
					
					boolean codigoAtendenteInvalido = true;
					listarPessoas(atendentes);
					while(codigoAtendenteInvalido) {
						System.out.print("\nInforme o código do atendente: ");
						String codigoAtendente = entrada.nextLine();
						Funcionario atendente = (Funcionario) buscarPessoa(codigoAtendente, atendentes);
						if(atendente == null) {
							System.out.println("\nO atendente com o código '" + codigoAtendente + "' não foi encontrado no sistema. Tente novamente.");
						} else {
							codigoAtendenteInvalido = false;
							pedido.setNomeFuncionario(atendente.getNome());
						}
					}
					
					mostrarCardapio(pizzas, lanches, salgadinhos);
					System.out.println();
					
					boolean adicionar = true;
					while(adicionar) {
						Integer quantidade = 0;
						System.out.print("\nDigite o código do prato: ");
						String IdPrato = entrada.nextLine();
						if(IdPrato.equalsIgnoreCase("P")) {
							System.out.println("\n--- AGORA VOCÊ PODE MONTAR A SUA PIZZA ---");
							PizzaPersonalizada pizzaPersonalizada = new PizzaPersonalizada("Pizza Personalizada", sdf.parse("12/04/2023"), 1500.0);
							boolean molhoInvalido = true;
							listarMolhos(molhosPizza);
							while(molhoInvalido) {
								System.out.print("\nDigite o código do molho: ");
								String IdMolho = entrada.nextLine();
								Molho molho = buscarMolho(IdMolho, molhosPizza);
								if(molho == null) {
									System.out.println("\nO molho com ID '" + IdMolho + "' não foi encontrado no sistema. Tente novamente.");
								} else {
									pizzaPersonalizada.setMolho(molho);
									molhoInvalido = false;
								}
							}
							
							boolean continuarRecheio = true;
							List<Recheio> recheiosPizzaPersonalizada = new ArrayList<Recheio>();
							while(continuarRecheio) {
								boolean recheioInvalido = true;
								listarRecheios(recheiosPizza);
								while(recheioInvalido) {
									System.out.print("\nDigite o código do recheio: ");
									String IdRecheioPizza = entrada.nextLine();
									Recheio recheioPizza = buscarRecheio(IdRecheioPizza, recheiosPizza);
									if(recheioPizza == null) {
										System.out.println("\nO recheio com ID '" + IdRecheioPizza + "' não foi encontrado no sistema. Tente novamente.");
									} else {
										recheiosPizzaPersonalizada.add(recheioPizza);
										recheioInvalido = false;
									}
								}
								System.out.print("\nDeseja adicionar outro recheio S/N? ");
								String respRecheio = entrada.nextLine();
								if(respRecheio.equalsIgnoreCase("N")) continuarRecheio = false;
								System.out.println();
							}
							pizzaPersonalizada.setRecheios(recheiosPizzaPersonalizada);
							
							System.out.println("Você deseja a pizza com borda recheada?");
							System.out.println("1 - Sim");
							System.out.println("2 - Não");
							System.out.print(">>> ");
							boolean continuarOpcaoBorda = true;
							while(continuarOpcaoBorda) {
								String bordaRecheada = entrada.nextLine();
								switch(bordaRecheada) {
								case "1":
									boolean RecheioBordaInvalido = true;
									listarRecheios(recheiosBordaPizza);
									while(RecheioBordaInvalido) {
										System.out.print("\nDigite o código do recheio da borda: ");
										String IdRecheioBorda = entrada.nextLine();
										Recheio recheioBorda = buscarRecheio(IdRecheioBorda, recheiosBordaPizza);
										if(recheioBorda == null) {
											System.out.println("\nO recheio com ID '" + IdRecheioBorda + "' não foi encontrado no sistema. Tente novamente.");
										} else {
											pizzaPersonalizada.setBorda(new Borda("Recheada", recheioBorda));
											RecheioBordaInvalido = false;
										}
									}
									continuarOpcaoBorda = false;
									break;
								case "2":
									pizzaPersonalizada.setBorda(new Borda("Tradicional"));
									continuarOpcaoBorda = false;
									break;
								default:
									System.out.println("Opação Inválida! Digite 1 ou 2");
									System.out.print(">>> ");
									break;
								}
							}
							pizzaPersonalizada.calcularPreco();
							itensConsumidos.add(pizzaPersonalizada);
							System.out.println("\n--- PIZZA MONTADA COM SUCESSO! ---");
							System.out.print("\nInforme a quantidade: ");
							quantidade = entrada.nextInt();
							quantidades.add(quantidade);
							entrada.nextLine();
							Controle.adicionarPrato(IdPrato, quantidade);
							System.out.print("\nDeseja adicionar outro prato S/N? ");
							String resp = entrada.nextLine();
							if(resp.equalsIgnoreCase("N")) {
								adicionar = false;
							}
						} else {
							Prato prato = buscarPrato(IdPrato, pratos);
							if(prato == null) {
								System.out.println("\nO prato com ID '" + IdPrato + "' não foi encontrado no sistema. Tente novamente.");
							} else {
								System.out.print("Informe a quantidade: ");
								quantidade = entrada.nextInt();
								quantidades.add(quantidade);
								entrada.nextLine();
								itensConsumidos.add(prato);
								Controle.adicionarPrato(prato.getID(), quantidade);
								System.out.print("\nDeseja adicionar outro prato S/N? ");
								String resp = entrada.nextLine();
								if(resp.equalsIgnoreCase("N")) {
									adicionar = false;
								}
							}
						}
					}
					
					pedido.setItensConsumidos((ArrayList<Prato>) itensConsumidos);
					pedido.setTaxaServico(10.0);
					pedido.setQuantidades((ArrayList<Integer>) quantidades);
					pedido.calcularTotal();
					pedido.mostrarFatura();
					pedidos.add(pedido);
					
					// Parte responsável pelo pagamento do pedido
					
					Pagamento pagamento = new Pagamento();
					pagamento.setPedido(pedido);
					
					System.out.println("\nSelecione a forma de pagamento:");
					System.out.println("1 - Débito");
					System.out.println("2 - Crédito");
					System.out.println("3 - Dinheiro");
					System.out.print(">>> ");
					boolean pagamentoInvalido = true;
					while(pagamentoInvalido) {
						String opcaoPagamento = entrada.nextLine();
						switch(opcaoPagamento) {
						case "1":
							pagamento.setTipo("Debito");
							pagamentoInvalido = false;
							break;
						case "2":
							pagamento.setTipo("Credito");
							pagamentoInvalido = false;
							break;
						case "3":
							pagamento.setTipo("Dinheiro");
							pagamentoInvalido = false;
							break;
						default:
							System.out.println("Opação Inválida! Digite 1, 2 ou 3");
							System.out.print(">>> ");
							break;
						}
					}
					
					if(pagamento.getTipo().equals("Dinheiro")) {
						boolean valorPagoInvalido = true;
						while(valorPagoInvalido) {
							System.out.print("\nInforme o total entregue em dinheiro: ");
							Double valorPago = Double.parseDouble(entrada.nextLine());
							if(valorPago < pagamento.getPedido().getValorTotal()) {
								System.out.println("\nO valor entregue não é suficiente! Falta R$" + (pagamento.getPedido().getValorTotal() - valorPago));
							} else {
								pagamento.setValorPagoDinheiro(valorPago);
								pagamento.mostrarTroco();
								valorPagoInvalido = false;
							}
						}
					} else {
						System.out.println("\nInsira o cartão");
						System.out.println("Lendo o cartão...");
						System.out.println("Insira a senha");
						System.out.println("Pagamento aprovado!\n");
					}
					
					pagamento.gerarNotaFiscal();
					
					opcaoMenuInvalida = false;
					break;
				case "2":
					mostrarPedidos((ArrayList<Pedido>) pedidos);
					opcaoMenuInvalida = false;
					break;
				case "3":
					mostrarControle();
					opcaoMenuInvalida = false;
					break;
				case "4":
					System.out.println("\nSAINDO...\n");
					opcaoMenuInvalida = false;
					sair = true;
					break;
				default:
					System.out.println("Opção Inválida!");
					break;
				}
			}
		
		}
	
		entrada.close();
	}

}
