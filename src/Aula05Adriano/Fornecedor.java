package Aula05Adriano;

import java.util.Date;
import java.util.List;

public class Fornecedor extends Pessoa {
	
	private String cnpf;
	private Date dataAbertura;
	
	public Fornecedor() {
		super();
	}

	public Fornecedor(String nome, String email, String endereco, List<String> telefones, String cnpf,
			Date dataAbertura) {
		super(nome, email, endereco, telefones);
		this.cnpf = cnpf;
		this.dataAbertura = dataAbertura;
	}

	public String getCnpf() {
		return cnpf;
	}

	public void setCnpf(String cnpf) {
		this.cnpf = cnpf;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	
}
