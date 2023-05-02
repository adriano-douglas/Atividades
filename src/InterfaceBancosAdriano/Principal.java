package InterfaceBancosAdriano;


public class Principal {

	public static void main(String[] args) {
		
		BancoA bancoA = new BancoA();
		BancoB bancoB = new BancoB();
		
		Conta conta1 = new Conta("1111-1", 0.0);
		Conta conta2 = new Conta("2222-2", 0.0);
		Conta conta3 = new Conta("3333-3", 0.0);
		Conta conta4 = new Conta("4444-4", 0.0);
		
		bancoA.adicionarConta(conta1);
		bancoA.adicionarConta(conta2);
		
		bancoB.adicionarConta(conta3);
		bancoB.adicionarConta(conta4);
		
		// Banco A
		System.out.println("Banco A\n");
		
		bancoA.manutencaoConta(conta1);
		bancoA.manutencaoConta(conta2);
		
		bancoA.extrato(conta1);
		bancoA.extrato(conta2);
		
		bancoA.deposito(conta1, 100.0);
		bancoA.deposito(conta2, 500.0);
		
		bancoA.extrato(conta1);
		bancoA.extrato(conta2);
		
		bancoA.saque(conta1, 200.0);
		bancoA.saque(conta2, 350.0);
		
		bancoA.extrato(conta1);
		bancoA.extrato(conta2);
		
		bancoA.transferencia(conta2, conta1, 80.0);
		
		bancoA.extrato(conta1);
		bancoA.extrato(conta2);
		
		// Banco B
		System.out.println("\nBanco B\n");
		
		bancoB.manutencaoConta(conta3);
		bancoB.manutencaoConta(conta4);
		
		bancoB.extrato(conta3);
		bancoB.extrato(conta4);
		
		bancoB.deposito(conta3, 100.0);
		bancoB.deposito(conta4, 500.0);
		
		bancoB.extrato(conta3);
		bancoB.extrato(conta4);
		
		bancoB.saque(conta3, 600.0);
		bancoB.saque(conta3, 200.0);
		bancoB.saque(conta4, 350.0);
		
		bancoB.extrato(conta3);
		bancoB.extrato(conta4);
	}
	
}
