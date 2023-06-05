package Trabalho_Etapa2_POO_AdrianoRosa.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Trabalho_Etapa2_POO_AdrianoRosa.db.DB;
import Trabalho_Etapa2_POO_AdrianoRosa.models.Funcionario;
import Trabalho_Etapa2_POO_AdrianoRosa.models.Pagamento;
import Trabalho_Etapa2_POO_AdrianoRosa.models.Pedido;
import Trabalho_Etapa2_POO_AdrianoRosa.models.Prato;
import Trabalho_Etapa2_POO_AdrianoRosa.models.TipoPagamento;
import Trabalho_Etapa2_POO_AdrianoRosa.views.CriarPedido1;
import Trabalho_Etapa2_POO_AdrianoRosa.views.CriarPedido2;
import Trabalho_Etapa2_POO_AdrianoRosa.views.ListaPedidosPanel;

public class Pedido2Controller {

	public Pedido pedido;

	private static CriarPedido1 criarPedido1;
	private static CriarPedido2 criarPedido2;
	private static ListaPedidosPanel listaPedidosPanel;

	private static ArrayList<Funcionario> atendentes;

	public Pedido2Controller(CriarPedido1 _criarPedido1, CriarPedido2 _criarPedido2,
			ListaPedidosPanel _listaPedidosPanel) {

		criarPedido1 = _criarPedido1;
		criarPedido2 = _criarPedido2;
		listaPedidosPanel = _listaPedidosPanel;
		pedido = PedidoController.getPedido();

		atendentes = new ArrayList<>();
		for (Funcionario f : DB.funcionarios) {
			if (f.getCargo().equals("Atendente"))
				atendentes.add(f);
		}

		criarPedido2.adicionarEventoConfirmarPedido(confirmarPedido);
		criarPedido2.setComboClientes(DB.clientes);
		criarPedido2.setComboFuncionarios(atendentes);
	}

	ActionListener confirmarPedido = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			pedido = PedidoController.getPedido();

			String nomeCliente = criarPedido2.getClienteSelecionado().getNome();
			String nomeAtendente = criarPedido2.getAtendenteSelecionado().getNome();
			String valorPago = criarPedido2.getTextValorPago().strip();
			TipoPagamento tipoPagamento = criarPedido2.getFormaPagamento();

			Double valorP = Double.parseDouble(valorPago.replaceAll("[R$.]", "").substring(1).replace(",", "."));

			if (valorP < pedido.getValorTotal() && tipoPagamento.equals(TipoPagamento.DINHEIRO)) {
				criarPedido2.exibirMensagem("O valor pago informado não é suficiente!");
				return;
			}

			if (valorP > pedido.getValorTotal() && tipoPagamento.equals(TipoPagamento.DINHEIRO)) {
				criarPedido2.exibirMensagem("Troco: R$" + (valorP - pedido.getValorTotal()));
			}

			Pedido novoPedido = new Pedido();
			novoPedido.setId(DB.ID_PEDIDOS++);
			novoPedido.setItensConsumidos(pedido.getItensConsumidos());
			novoPedido.setQuantidades(pedido.getQuantidades());
			novoPedido.setTaxaServico(pedido.getTaxaServico());
			novoPedido.setValorTotal(pedido.getValorTotal());
			novoPedido.setNomeCliente(nomeCliente);
			novoPedido.setNomeFuncionario(nomeAtendente);

			DB.pedidos.add(novoPedido);

			valorP = tipoPagamento.equals(TipoPagamento.DINHEIRO) ? valorP : null;
			Pagamento pagamento = new Pagamento(DB.ID_PAGAMENTOS++, novoPedido, tipoPagamento, valorP);

			DB.pagamentos.add(pagamento);

			criarPedido2.exibirMensagem("Pagamento aprovado!\nPedido realizado com sucesso!");

			String pedidosText = "\n";
			for (Pagamento p : DB.pagamentos) {
				pedidosText += "  PEDIDO " + p.getPedido().getId() + "\n\n";
				pedidosText += "  CLIENTE:  " + p.getPedido().getNomeCliente() + "\n";
				pedidosText += "  ATENDENTE:  " + p.getPedido().getNomeFuncionario() + "\n\n";
				pedidosText += "  PRATOS CONSUMIDOS:\n\n";
				int i = 0;
				for (Prato pt : p.getPedido().getItensConsumidos()) {
					pedidosText += "  Nome do prato:  " + pt.getNome() + "\n";
					pedidosText += "  Valor:  R$" + pt.getPrecoVenda() + "\n";
					pedidosText += "  Quantidade:  " + p.getPedido().getQuantidades().get(i) + "\n\n";
					i++;
				}
				pedidosText += "  TAXA DE SERVIÇO:  R$" + p.getPedido().getTaxaServico() + "\n";
				pedidosText += "  VALOR TOTAL:  R$" + p.getPedido().getValorTotal() + "\n";
				pedidosText += "  FORMA DE PAGAMENTO:  " + p.getTipo() + "\n";
				if (p.getTipo().equals(TipoPagamento.DINHEIRO)) {
					pedidosText += "  VALOR ENTREGUE:  " + p.getValorPagoDinheiro() + "\n";
					pedidosText += "  TROCO:  " + (p.getValorPagoDinheiro() - p.getPedido().getValorTotal()) + "\n";
				}
				pedidosText += "\n" + "=".repeat(60) + "\n\n";
			}

			listaPedidosPanel.setTextPedidos(pedidosText);

			criarPedido2.resetarCampos();
			criarPedido2.setComboClientes(DB.clientes);
			criarPedido2.setComboFuncionarios(atendentes);
			criarPedido2.tornarInvisivel();
			PedidoController.carregarElementosPedido();
			PizzaPersonalizadaController.pizzasPersonalizadas.clear();
			PedidoController.itensConsumidos.clear();
			PedidoController.quantidades.clear();
			criarPedido1.tornarVisivel();

		}
	};

}
