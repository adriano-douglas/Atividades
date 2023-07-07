package Trabalho_Etapa3_POO_AdrianoRosa.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import Trabalho_Etapa3_POO_AdrianoRosa.dao.PagamentoDao;
import Trabalho_Etapa3_POO_AdrianoRosa.dao.PedidoDao;
import Trabalho_Etapa3_POO_AdrianoRosa.db.DB;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Cliente;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Funcionario;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Pagamento;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Pedido;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Prato;
import Trabalho_Etapa3_POO_AdrianoRosa.models.TipoPagamento;
import Trabalho_Etapa3_POO_AdrianoRosa.views.CriarPedido1;
import Trabalho_Etapa3_POO_AdrianoRosa.views.CriarPedido2;
import Trabalho_Etapa3_POO_AdrianoRosa.views.ListaPedidosPanel;

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
		setarListaPedidosPagamentos();
	}

	ActionListener confirmarPedido = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			pedido = PedidoController.getPedido();

			Cliente cliente = criarPedido2.getClienteSelecionado();
			Funcionario atendente = criarPedido2.getAtendenteSelecionado();
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
			novoPedido.setItensConsumidos(pedido.getItensConsumidos());
			novoPedido.setQuantidades(pedido.getQuantidades());
			novoPedido.setTaxaServico(pedido.getTaxaServico());
			novoPedido.setValorTotal(pedido.getValorTotal());
			novoPedido.setCliente(cliente);
			novoPedido.setFuncionario(atendente);
			novoPedido.setData(LocalDate.now());
			
			int idPedido = PedidoDao.cadastrarPedido(novoPedido);
			if(idPedido == 0) {
				criarPedido2.exibirMensagem("Erro ao cadastrar o pedido no banco!");
				return;
			}
			novoPedido.setId(idPedido);
			DB.pedidos.add(novoPedido);

			valorP = tipoPagamento.equals(TipoPagamento.DINHEIRO) ? valorP : null;
			Pagamento pagamento = new Pagamento(0, novoPedido, tipoPagamento, valorP);
			pagamento.setDataHora(LocalDateTime.now());

			int idPagamento = PagamentoDao.cadastrarPagamento(pagamento);
			if(idPagamento == 0) {
				criarPedido2.exibirMensagem("Erro ao cadastrar o pagamento no banco!");
				return;
			}
			pagamento.setId(idPagamento);
			DB.pagamentos.add(pagamento);

			criarPedido2.exibirMensagem("Pagamento aprovado!\nPedido realizado com sucesso!");

			setarListaPedidosPagamentos();

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
	
	public static void setarListaPedidosPagamentos() {
		String pedidosText = "\n";
		for (Pagamento p : DB.pagamentos) {
			pedidosText += "  PEDIDO " + p.getPedido().getId() + "\n\n";
			pedidosText += "  CLIENTE:  " + p.getPedido().getCliente().getNome() + "\n";
			pedidosText += "  ATENDENTE:  " + p.getPedido().getFuncionario().getNome() + "\n\n";
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
	}

}
