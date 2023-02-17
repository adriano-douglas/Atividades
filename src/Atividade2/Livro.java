package Atividade2;

public class Livro {
	
	private String nome;
	private String autor;
	private Integer idLivro;
	private Integer anoPublicacao;
	
	public Livro() {
		super();
	}
	
	public Livro(String nome, String autor, Integer idLivro, Integer anoPublicacao) {
		super();
		this.nome = nome;
		this.autor = autor;
		this.idLivro = idLivro;
		this.anoPublicacao = anoPublicacao;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public Integer getIdLivro() {
		return idLivro;
	}
	
	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
	}
	
	public Integer getAnoPublicacao() {
		return anoPublicacao;
	}
	
	public void setAnoPublicacao(Integer anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

}
