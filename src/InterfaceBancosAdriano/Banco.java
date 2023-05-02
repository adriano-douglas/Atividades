package InterfaceBancosAdriano;

public interface Banco {
	
	public void manutencaoConta(Conta conta);
	public boolean saque(Conta conta, Double valor);
	public boolean deposito(Conta conta, Double valor);
	public void extrato(Conta conta);

}
