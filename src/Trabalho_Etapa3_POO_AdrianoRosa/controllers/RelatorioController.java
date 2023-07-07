package Trabalho_Etapa3_POO_AdrianoRosa.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import Trabalho_Etapa3_POO_AdrianoRosa.dao.RelatorioDao;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Pagamento;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Prato;
import Trabalho_Etapa3_POO_AdrianoRosa.pdf.HtmlPdf;
import Trabalho_Etapa3_POO_AdrianoRosa.views.ListaPedidosPanel;

public class RelatorioController {

	private ListaPedidosPanel listaPedidosPanel;

	public RelatorioController(ListaPedidosPanel _listaPedidosPanel) {
		listaPedidosPanel = _listaPedidosPanel;
		listaPedidosPanel.setEventoBtnGerarPdf(gerarPdf);
	}

	ActionListener gerarPdf = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			String data1 = listaPedidosPanel.getTextData1().strip();
			String data2 = listaPedidosPanel.getTextData2().strip();

			boolean erro1 = false;
			boolean erro2 = false;
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String mensagemErro = "";

			if (data1.replaceAll("[_/]", "").length() != 8 || data2.replaceAll("[_/]", "").length() != 8) {
				listaPedidosPanel.exibirMensagem("As duas datas são obrigatórias");
				return;
			}
			
			LocalDate dataAtual = LocalDate.now();
			LocalDate data1Formatada = null;
			LocalDate data2Formatada = null;
			
			try {
				data1Formatada = LocalDate.parse(data1, formato);
			} catch (DateTimeParseException e1) {
				mensagemErro = "A primeira data informada é inválida";
				erro1 = true;
			}
			
			try {
				data2Formatada = LocalDate.parse(data2, formato);
			} catch (DateTimeParseException e1) {
				mensagemErro = "A segunda data informada é inválida";
				erro2 = true;
			}
			
			if(erro1 && erro2) {
				listaPedidosPanel.exibirMensagem("As duas datas informadas são inválidas");
				return;
			}
			
			if(erro1 || erro2) {
				listaPedidosPanel.exibirMensagem(mensagemErro);
				return;
			}
			
			if(data1Formatada.isAfter(dataAtual) || data2Formatada.isAfter(dataAtual)) {
				listaPedidosPanel.exibirMensagem("Nenhuma das datas informadas pode\nser posterior a data atual");
				return;
			}
			
			if(data2Formatada.isBefore(data1Formatada)) {
				listaPedidosPanel.exibirMensagem("A segunda data informada não pode\nser anterior a primeira data");
				return;
			}
			
			ArrayList<Pagamento> pagamentos = RelatorioDao.buscarPagamentosPorIntervaloData(data1Formatada, data2Formatada);
			
			HtmlPdf.gerarPdf(montarHtml(pagamentos, data1Formatada, data2Formatada), "fechamento_caixa");
			
			listaPedidosPanel.exibirMensagem("PDF com o relatório gerado com sucesso!");
			
		}
	};
	
	public static String montarHtml(ArrayList<Pagamento> pagamentos, LocalDate data1, LocalDate data2) {
		String htmlConteudo = "<h3>Intervalo de datas: {{data1}} a {{data2}}</h3>";
		htmlConteudo = htmlConteudo.replace("{{data1}}", data1.toString());
		htmlConteudo = htmlConteudo.replace("{{data2}}", data2.toString());
		Double total = 0.0;
		for(Pagamento pa : pagamentos) {
			
			htmlConteudo += "<h3>Pedido {{id_pedido}}</h3>\r\n"
					+ "  <table>\r\n"
					+ "    <tr>\r\n"
					+ "      <th>Cliente</th>\r\n"
					+ "      <th>Atendente</th>\r\n"
					+ "      <th>Itens</th>\r\n"
					+ "      <th>Valor</th>\r\n"
					+ "      <th>Quantidade</th>\r\n"
					+ "      <th>Taxa Serviço</th>\r\n"
					+ "      <th>Total</th>\r\n"
					+ "      <th>Forma Pagamento</th>\r\n"
					+ "    </tr>";
			htmlConteudo = htmlConteudo.replace("{{id_pedido}}", pa.getPedido().getId().toString());
			htmlConteudo += "<tr>\r\n"
					+ "      <td>{{nome_cliente}}</td>\r\n"
					+ "      <td>{{nome_atendente}}</td>\r\n"
					+ "      <td>\r\n"
					+ "        <ul>\r\n"
					
					+ "          {{lista_pratos}}"
					
					+ "        </ul>\r\n"
					+ "      </td>\r\n"
					+ "      <td>\r\n"
					+ "        <ul>\r\n"
					
					+ "          {{lista_valor_unitario}}"
					
					+ "        </ul>\r\n"
					+ "      </td>\r\n"
					+ "      <td>\r\n"
					+ "        <ul>\r\n"
					
					+ "          {{lista_quantidades}}"
					
					+ "        </ul>\r\n"
					+ "      </td>\r\n"
					+ "      <td>R$ {{taxa_servico}}</td>\r\n"
					+ "      <td>R$ {{total_pedido}}</td>\r\n"
					+ "      <td>{{forma_pagamento}}</td>\r\n"
					+ "    </tr>"
					+ "	 </table>"
					+ "	 </br>";
			int i = 0;
			String listaPratos = "";
			String listaValorUnitario = "";
			String listaQuantidades = "";
			for(Prato pr : pa.getPedido().getItensConsumidos()) {
				listaPratos += "<li>" + pr.getNome() + "</li>\n";
				listaValorUnitario += "<li>R$ " + pr.getPrecoVenda() + "</li>\n";
				listaQuantidades += "<li>" + pa.getPedido().getQuantidades().get(i) + " unidades</li>\n";
				i++;
			}
			total += pa.getPedido().getValorTotal();
			htmlConteudo = htmlConteudo.replace("{{nome_cliente}}", pa.getPedido().getCliente().getNome());
			htmlConteudo = htmlConteudo.replace("{{nome_atendente}}", pa.getPedido().getFuncionario().getNome());
			htmlConteudo = htmlConteudo.replace("{{lista_pratos}}", listaPratos);
			htmlConteudo = htmlConteudo.replace("{{lista_valor_unitario}}", listaValorUnitario);
			htmlConteudo = htmlConteudo.replace("{{lista_quantidades}}", listaQuantidades);
			htmlConteudo = htmlConteudo.replace("{{taxa_servico}}", pa.getPedido().getTaxaServico().toString());
			htmlConteudo = htmlConteudo.replace("{{total_pedido}}", pa.getPedido().getValorTotal().toString());
			htmlConteudo = htmlConteudo.replace("{{forma_pagamento}}", pa.getTipo().toString());
		}
		htmlConteudo += "<h3>Valor Total de Todos os Pedidos: R$ " + total.toString() + "</h3>";
		System.out.println(htmlConteudo);
		return htmlConteudo;
	}

}
