package Atividade1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Aluno {

	// Definição de variáveis
	
	private String nome;
	private Integer cpf;
	private Date dataNascimento;
	private String email;
	
	// Construtor vazio
	public Aluno() {
		super();
	}
	
	// Construtor com parâmetros
	public Aluno(String nome, Integer cpf, Date dataNascimento, String email) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.email = email;
	}
	
	// Métodos get e set
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Integer getCpf() {
		return cpf;
	}
	
	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer idade(Aluno aluno) {
		Integer idade = 0;
		idade = new Date().getYear() - aluno.getDataNascimento().getYear();
		
		if(aluno.getDataNascimento().getMonth() > new Date().getMonth()) {
			return idade - 1;
		}else if(aluno.getDataNascimento().getMonth() == new Date().getMonth() &&
				 aluno.getDataNascimento().getDate() > new Date().getDate()) {
			return idade  - 1;
		}
		return idade;
	}
	
	public void imprimirDados() {
		SimpleDateFormat formato = new SimpleDateFormat();
		
		System.out.println("Nome: " + this.getNome());
		System.out.println("CPF: " + this.getCpf());
		System.out.println("Data de Nascimento: " + formato.format(this.getDataNascimento()));
		System.out.println("E-mail: " + this.getEmail() + "\n");
	}
	
}
