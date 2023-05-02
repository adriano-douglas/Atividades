package InterfaceBancosAdriano;

import java.util.ArrayList;

public class BancoB implements Banco {

	private static final Double TAXA = 35.0;
	private static final Double LIMITE = 500.0;
	private static ArrayList<Conta> contas = new ArrayList<>();
	
	public BancoB() {
		
	}

	@Override
	public void manutencaoConta(Conta conta) {
		if(!contas.contains(conta)) {
			System.out.println("A conta informada não pertence ao Banco B");
			return;
		}
		conta.setSaldo(conta.getSaldo() - TAXA);
		System.out.println("Taxa debitada no Banco B para a conta de número: " + conta.getNumero());
	}

	@Override
	public boolean saque(Conta conta, Double valor) {
		if(!contas.contains(conta)) {
			System.out.println("A conta informada não pertence ao Banco B");
			return false;
		}
		if(valor > conta.getSaldo() + LIMITE) {
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
			System.out.println("A conta informada não pertence ao Banco B");
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
			System.out.println("A conta informada não pertence ao Banco B");
			return;
		}
		System.out.println("Saldo atual da conta " + conta.getNumero() + ": R$" + conta.getSaldo());
	}
	
	public void adicionarConta(Conta conta) {
		if(conta == null) {
			System.out.println("Conta inválida!");
			return;
		}
		contas.add(conta);
	}
	
	public static ArrayList<Conta> getContas() {
		return contas;
	}

}
