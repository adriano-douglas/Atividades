package Trabalho_Etapa2_POO_AdrianoRosa.db;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import Trabalho_Etapa2_POO_AdrianoRosa.models.Borda;
import Trabalho_Etapa2_POO_AdrianoRosa.models.Cliente;
import Trabalho_Etapa2_POO_AdrianoRosa.models.Funcionario;
import Trabalho_Etapa2_POO_AdrianoRosa.models.Lanche;
import Trabalho_Etapa2_POO_AdrianoRosa.models.Molho;
import Trabalho_Etapa2_POO_AdrianoRosa.models.Pagamento;
import Trabalho_Etapa2_POO_AdrianoRosa.models.Pedido;
import Trabalho_Etapa2_POO_AdrianoRosa.models.Pizza;
import Trabalho_Etapa2_POO_AdrianoRosa.models.Recheio;
import Trabalho_Etapa2_POO_AdrianoRosa.models.Salgadinho;

public abstract class DB {

	static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static Integer ID_CLIENTE = 3;
	public static Integer ID_FUNCIONARIO = 5;
	public static Integer ID_SALGADINHOS = 4;
	public static Integer ID_LANCHES = 4;
	public static Integer ID_MOLHOSP = 6;
	public static Integer ID_RECHEIOSP = 18;
	public static Integer ID_RECHEIOSBP = 6;
	public static Integer ID_PIZZA = 6;
	public static Integer ID_BORDAP = 2;
	public static Integer ID_PEDIDOS = 1;
	public static Integer ID_PAGAMENTOS = 1;

	public static ArrayList<Funcionario> funcionarios = new ArrayList<>();
	public static ArrayList<Cliente> clientes = new ArrayList<>();

	public static ArrayList<Molho> molhosPizza = new ArrayList<>();
	public static ArrayList<Recheio> recheiosPizza = new ArrayList<>();
	public static ArrayList<Recheio> recheiosBordaPizza = new ArrayList<>();
	public static ArrayList<Borda> bordasPizza = new ArrayList<>();
	public static ArrayList<Pizza> pizzas = new ArrayList<>();
	public static ArrayList<Lanche> lanches = new ArrayList<>();
	public static ArrayList<Salgadinho> salgadinhos = new ArrayList<>();
	public static ArrayList<Pedido> pedidos = new ArrayList<>();
	public static ArrayList<Pagamento> pagamentos = new ArrayList<>();

	public static void carregarDados() {

		clientes.add(new Cliente(1, "Adriano", "111.111.111-11", "Rua A, 11", data("20/03/2000")));
		clientes.add(new Cliente(2, "Igor", "222.222.222-22", "Rua B, 22", data("18/06/2005")));

		funcionarios.add(new Funcionario(3, "Pedro", "333.333.333-33", "Rua C, 33", 1500.0, "Atendente"));
		funcionarios.add(new Funcionario(4, "Lucas", "444.444.444-44", "Rua D, 44", 1500.0, "Atendente"));

		molhosPizza.add(new Molho(1, "Tomate tradicional", 7.0));
		molhosPizza.add(new Molho(2, "Gorgonzola", 12.0));
		molhosPizza.add(new Molho(3, "Parisiense", 10.0));
		molhosPizza.add(new Molho(4, "Picante", 8.5));
		molhosPizza.add(new Molho(5, "Strogonoff", 9.0));

		recheiosPizza.add(new Recheio(1, "Tomate", 4.0));
		recheiosPizza.add(new Recheio(2, "Folhas de manjericão", 3.0));
		recheiosPizza.add(new Recheio(3, "Mozzarella de búfala", 14.0));
		recheiosPizza.add(new Recheio(4, "Queijo muçarela", 6.0));
		recheiosPizza.add(new Recheio(5, "Calabresa", 8.0));
		recheiosPizza.add(new Recheio(6, "Cebola roxa", 4.0));
		recheiosPizza.add(new Recheio(7, "Pepperoni", 10.0));
		recheiosPizza.add(new Recheio(8, "Ovo cozido", 5.0));
		recheiosPizza.add(new Recheio(9, "Presunto", 6.0));
		recheiosPizza.add(new Recheio(10, "Milho", 4.0));
		recheiosPizza.add(new Recheio(11, "Pimentão", 3.0));
		recheiosPizza.add(new Recheio(12, "Azeitonas pretas", 5.0));
		recheiosPizza.add(new Recheio(13, "Orégano", 2.0));
		recheiosPizza.add(new Recheio(14, "Frango desfiado", 10.0));
		recheiosPizza.add(new Recheio(15, "Queijo de búfala", 13.0));
		recheiosPizza.add(new Recheio(16, "Parmesão", 12.0));
		recheiosPizza.add(new Recheio(17, "Requeijão", 7.0));

		recheiosBordaPizza.add(new Recheio(1, "Calabresa", 7.0));
		recheiosBordaPizza.add(new Recheio(2, "Calabresa com Catupiry", 12.0));
		recheiosBordaPizza.add(new Recheio(3, "Cream Cheese Philadelphia", 10.0));
		recheiosBordaPizza.add(new Recheio(4, "Requeijão", 5.0));
		recheiosBordaPizza.add(new Recheio(5, "Cheddar", 9.0));

		bordasPizza.add(new Borda(1, "Tradicional", 0.0, null));

		// "mozzarella de búfala, tomate, manjericão, orégano", "tradicional"
		pizzas.add(new Pizza(1, "Pizza marguerita", 20.0, data("12/04/2023"), 1300.0, molhosPizza.get(0),
				bordasPizza.get(0)));
		pizzas.get(0).adicionarRecheio(recheiosPizza.get(2));
		pizzas.get(0).adicionarRecheio(recheiosPizza.get(0));
		pizzas.get(0).adicionarRecheio(recheiosPizza.get(1));
		pizzas.get(0).adicionarRecheio(recheiosPizza.get(12));
		// "queijo muçarela, calabresa, cebola roxa, orégano", "tradicional"
		pizzas.add(new Pizza(2, "Pizza calabresa", 30.0, data("12/04/2023"), 1500.0, molhosPizza.get(0),
				bordasPizza.get(0)));
		pizzas.get(1).adicionarRecheio(recheiosPizza.get(3));
		pizzas.get(1).adicionarRecheio(recheiosPizza.get(4));
		pizzas.get(1).adicionarRecheio(recheiosPizza.get(5));
		pizzas.get(1).adicionarRecheio(recheiosPizza.get(12));
		// "muçarela, pepperoni, orégano", "tradicional"
		pizzas.add(new Pizza(3, "Pizza de pepperoni", 40.0, data("12/04/2023"), 1400.0, molhosPizza.get(0),
				bordasPizza.get(0)));
		pizzas.get(2).adicionarRecheio(recheiosPizza.get(3));
		pizzas.get(2).adicionarRecheio(recheiosPizza.get(6));
		pizzas.get(2).adicionarRecheio(recheiosPizza.get(12));
		// "muçarela, calabresa, cebola roxa, presunto, ovo cozido, tomate, pimentão,
		// azeitona preta, orégano", "tradicional"
		pizzas.add(new Pizza(4, "Pizza portuguesa", 50.0, data("12/04/2023"), 1600.0, molhosPizza.get(0),
				bordasPizza.get(0)));
		pizzas.get(3).adicionarRecheio(recheiosPizza.get(3));
		pizzas.get(3).adicionarRecheio(recheiosPizza.get(4));
		pizzas.get(3).adicionarRecheio(recheiosPizza.get(5));
		pizzas.get(3).adicionarRecheio(recheiosPizza.get(8));
		pizzas.get(3).adicionarRecheio(recheiosPizza.get(7));
		pizzas.get(3).adicionarRecheio(recheiosPizza.get(0));
		pizzas.get(3).adicionarRecheio(recheiosPizza.get(10));
		pizzas.get(3).adicionarRecheio(recheiosPizza.get(12));
		pizzas.get(3).adicionarRecheio(recheiosPizza.get(12));
		// "frango desfiado, requeijão, tomate, muçarela, milho", "tradicional"
		pizzas.add(new Pizza(5, "Pizza de frango", 60.0, data("12/04/2023"), 1700.0, molhosPizza.get(0),
				bordasPizza.get(0)));
		pizzas.get(4).adicionarRecheio(recheiosPizza.get(13));
		pizzas.get(4).adicionarRecheio(recheiosPizza.get(16));
		pizzas.get(4).adicionarRecheio(recheiosPizza.get(0));
		pizzas.get(4).adicionarRecheio(recheiosPizza.get(3));
		pizzas.get(4).adicionarRecheio(recheiosPizza.get(9));

		lanches.add(new Lanche(1, "Pão com mortadela", 5.0, data("12/04/2023"), 100.0, "Pão francês", "Mortadela",
				"Sem molho"));
		lanches.add(new Lanche(2, "Misto quente", 7.0, data("12/04/2023"), 100.0, "Pão de forma", "Presunto, muçarela",
				"Sem molho"));
		lanches.add(new Lanche(3, "Baguete recheada", 15.0, data("12/04/2023"), 200.0, "Baguete",
				"Carne ensopada e desfiada", "Molho de tomate"));

		salgadinhos.add(
				new Salgadinho(1, "Coxinha", 5.0, data("12/04/2023"), 90.0, "Frango, Catupiry", "Cozida", "Frito"));
		salgadinhos.add(new Salgadinho(2, "Empadinha", 7.0, data("12/04/2023"), 90.0, "Frango", "Crua", "Assado"));
		salgadinhos.add(new Salgadinho(3, "Enroladinho de salsicha", 4.0, data("12/04/2023"), 70.0, "Salsicha",
				"Cozida", "Frito"));

	}

	public static LocalDate data(String data) {
		return LocalDate.parse(data, formato);
	}

	public static boolean existeClientePorCpf(String cpf) {
		for (Cliente c : clientes) {
			if (c.getCpf().equals(cpf))
				return true;
		}
		return false;
	}

	public static boolean existeFuncionarioPorCpf(String cpf) {
		for (Funcionario f : funcionarios) {
			if (f.getCpf().equals(cpf))
				return true;
		}
		return false;
	}

	public static boolean existeSalgadinhoPorNome(String nome) {
		for (Salgadinho s : salgadinhos) {
			if (s.getNome().equals(nome))
				return true;
		}
		return false;
	}

	public static boolean existeLanchePorNome(String nome) {
		for (Lanche l : lanches) {
			if (l.getNome().equals(nome))
				return true;
		}
		return false;
	}

	public static boolean existeMolhoPorNome(String nome) {
		for (Molho m : molhosPizza) {
			if (m.getNome().equals(nome))
				return true;
		}
		return false;
	}

	public static boolean existeRecheioPPorNome(String nome) {
		for (Recheio r : recheiosPizza) {
			if (r.getNome().equals(nome))
				return true;
		}
		return false;
	}

	public static boolean existeRecheioBPPorNome(String nome) {
		for (Recheio r : recheiosBordaPizza) {
			if (r.getNome().equals(nome))
				return true;
		}
		return false;
	}

	public static boolean existePizzaPorNome(String nome) {
		for (Pizza p : pizzas) {
			if (p.getNome().equals(nome))
				return true;
		}
		return false;
	}

}
