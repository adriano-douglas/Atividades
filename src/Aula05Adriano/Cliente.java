package Aula05Adriano;

import java.util.Date;
import java.util.List;

				// Herança da classe ClienteFuncionario

public class Cliente extends ClienteFuncionario {
	
	// Sobrecarga nos construtores
	
	public Cliente() {
		super();
	}
	
	public Cliente(String nome, String email, String endereco, List<String> telefones, String cpf,
			Date dataNascimento) {
		super(nome, email, endereco, telefones, cpf, dataNascimento);
	}
	
	private boolean primeiraCompra(List<Venda> vendas) {
		for(Venda v : vendas) {
			if(v.getCliente().getCpf().equals(this.getCpf())) {
				return false;
			}
		}
		return true;
	}
	
	public double calcularDesconto(List<Venda> vendas) {
		return this.primeiraCompra(vendas) ? (1 - 0.05) : (1 - 0.1);
	}

}
