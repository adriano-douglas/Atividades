package Trabalho_Etapa3_POO_AdrianoRosa.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import Trabalho_Etapa3_POO_AdrianoRosa.dao.FuncionarioDao;
import Trabalho_Etapa3_POO_AdrianoRosa.db.DB;
import Trabalho_Etapa3_POO_AdrianoRosa.models.Funcionario;
import Trabalho_Etapa3_POO_AdrianoRosa.views.CadastroFuncionarioPanel;

public class FuncionarioController {

	private CadastroFuncionarioPanel caFuncionarioPanel;

	public FuncionarioController(CadastroFuncionarioPanel _caFuncionarioPanel) {

		caFuncionarioPanel = _caFuncionarioPanel;
		
		caFuncionarioPanel.setComboCargos(List.of("Atendente", "Balconista", "Gerente", "Faxineiro"));
		caFuncionarioPanel.setEventoBtnSalvarFuncionario(salvarFuncionario);
	}

	ActionListener salvarFuncionario = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			String nome = caFuncionarioPanel.getTextNome().strip();
			String cpf = caFuncionarioPanel.getTextCpf().strip();
			String endereco = caFuncionarioPanel.getTextEndereco().strip();
			String telefone1 = caFuncionarioPanel.getTextTelefone1().strip();
			String telefone2 = caFuncionarioPanel.getTextTelefone2().strip();
			String salario = caFuncionarioPanel.getTextSalario().strip();
			String cargo = caFuncionarioPanel.getTextCargo().strip();

			boolean erroNome = false;
			String msgErroNome = "";

			if (nome.isBlank()) {
				msgErroNome = "O nome é obrigatório.";
				erroNome = true;
			} else if (nome.length() > 50) {
				msgErroNome = "O nome não deve contem mais que 50 caracteres.";
				erroNome = true;
			}

			boolean erroCpf = false;
			String msgErroCpf = "";

			if (cpf.replaceAll("[_.-]", "").length() != 11) {
				msgErroCpf = "O CPF é obrigatório.";
				erroCpf = true;
			}

			boolean erroEndereco = false;
			String msgErroEndereco = "";

			if (endereco.isBlank()) {
				msgErroEndereco = "O endereço é obrigatório.";
				erroEndereco = true;
			} else if (endereco.length() > 100) {
				msgErroEndereco = "O endereco não deve contem mais que 100 caracteres.";
				erroEndereco = true;
			}

			boolean erroTelefones = false;
			String msgErroTelefones = "";

			if (telefone1.replaceAll("[()_-]", "").length() != 11
					&& telefone2.replaceAll("[()_-]", "").length() != 11) {
				msgErroTelefones = "Informe pelo memos um número de telefone.";
				erroTelefones = true;
			}
			
			boolean erroSalario = false;
			String msgErroSalario = "";
			
			salario = salario.replaceAll("[R$.]", "").substring(1).replace(",", ".");
			Double salarioD = Double.parseDouble(salario);
			
			System.out.println(salarioD);

			if (salarioD < 100.0 || salarioD > 10000.0) {
				erroSalario = true;
				msgErroSalario = "Faixa de valor inválida. (100 ~ 10000)";
			}

			caFuncionarioPanel.exibirErroNome(msgErroNome, erroNome);
			caFuncionarioPanel.exibirErroCpf(msgErroCpf, erroCpf);
			caFuncionarioPanel.exibirErroEndereco(msgErroEndereco, erroEndereco);
			caFuncionarioPanel.exibirErroTelefones(msgErroTelefones, erroTelefones);
			caFuncionarioPanel.exibirErroSalario(msgErroSalario, erroSalario);

			if (!erroNome && !erroCpf && !erroEndereco && !erroTelefones && !erroSalario) {
				
				if(DB.existeFuncionarioPorCpf(cpf)) {
					caFuncionarioPanel.exibirErroCpf("O CPF informado já existe.", !erroCpf);
					return;
				}
				
				Funcionario funcionario = new Funcionario(0, nome, cpf, endereco, Double.parseDouble(salario), cargo);
				if(telefone1.replaceAll("[()_-]", "").length() == 11) funcionario.adicionarTelefone(telefone1);
				if(telefone2.replaceAll("[()_-]", "").length() == 11) funcionario.adicionarTelefone(telefone2);
				
				int idFuncionario = FuncionarioDao.cadastrarFuncionario(funcionario);
				if(idFuncionario == 0) {
					caFuncionarioPanel.exibirMensagem("Erro ao cadastrar o funcionário no banco!");
					return;
				}
				funcionario.setId(idFuncionario);
				DB.funcionarios.add(funcionario);
				
				caFuncionarioPanel.exibirMensagem("Funcionário cadastrado com sucesso!");
				caFuncionarioPanel.resetarCampos();
				
				for(Funcionario f : DB.funcionarios) {
					System.out.println(f.getId() + " - " +  f.getNome() + "\n");
				}
			}

		}
	};

}
