package InterfaceBancosAdriano;

import java.util.ArrayList;

public class BancoA implements Banco {
	
	private static final Double TAXA = 30.0;
	private static ArrayList<Conta> contas = new ArrayList<>();
	
	public BancoA() {
		
	}

	@Override
	public void manutencaoConta(Conta conta) {
		if(!contas.contains(conta)) {
			System.out.println("A conta informada não pertence ao Banco A");
			return;
		}
		conta.setSaldo(conta.getSaldo() - TAXA);
		System.out.println("Taxa debitada no Banco A para a conta de número: " + conta.getNumero());
	}

	@Override
	public boolean saque(Conta conta, Double valor) {
		if(!contas.contains(conta)) {
			System.out.println("A conta informada não pertence ao Banco A");
			return false;
		}
		if(valor > conta.getSaldo()) {
			System.out.println("O Saldo atual da conta " + conta.getNumero() + " não é suficiente para realizar um saque de R$: " + valor);
			return false;
		}
		conta.setSaldo(conta.getSaldo() - valor);
		System.out.println("Saque de R$" + valor + " realizado com sucesso na conta " + conta.getNumero());
		return true;
	}

	@Override
	public boolean deposito(Conta conta, Double valor) {
		if(!contas.contains(conta)) {
			System.out.println("A conta informada não pertence ao Banco A");
			return false;
		}
		if(valor <= 0) {
			System.out.println("Valor de deposito nao pode ser negativo!");
			return false;
		}
		conta.setSaldo(conta.getSaldo() + valor);
		System.out.println("Deposito de R$ " + valor + " realizado com sucesso na conta " + conta.getNumero());
		return true;
	}

	@Override
	public void extrato(Conta conta) {
		if(!contas.contains(conta)) {
			System.out.println("A conta informada não pertence ao Banco A");
			return;
		}
		System.out.println("Saldo atual da conta " + conta.getNumero() + ": R$" + conta.getSaldo());
	}
	
	public boolean transferencia(Conta contaSaida, Conta contaEntrada, Double valor) {
		if(contaSaida.equals(contaEntrada)) {
			System.out.println("As contas não podem ser iguais para realizar a transferência!");
			return false;
		}
		if(!contas.contains(contaSaida)) {
			System.out.println("A conta que vai realizar a transferência não pertence ao Banco A!");
			return false;
		}
		if(!contas.contains(contaEntrada) && !BancoB.getContas().contains(contaEntrada)) {
			System.out.println("A conta que vai receber a transferência não pertence a nenhum dos Bancos conhecidos!");
			return false;
		}
		if(contaSaida.getSaldo() < valor) {
			System.out.println("A conta " + contaSaida.getNumero() + " não tem saldo suficiente para realiar a transferencia!");
			return false;
		}
		contaSaida.setSaldo(contaSaida.getSaldo() - valor);
		contaEntrada.setSaldo(contaEntrada.getSaldo() + valor);
		System.out.println("Transferencia de " + valor + " realizada com sucesso da conta " + contaSaida.getNumero() + " para a conta " + contaEntrada.getNumero());
		return true;
	}
	
	public void adicionarConta(Conta conta) {
		if(conta == null) {
			System.out.println("Conta inválida!");
			return;
		}
		contas.add(conta);
	}

}
