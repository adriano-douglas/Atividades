package Atividade2;

public class Categoria {

	private Integer idCategoria;
	private String nome;
	
	public Categoria() {
		super();
	}
	
	public Categoria(Integer idCategoria, String nome) {
		super();
		this.idCategoria = idCategoria;
		this.nome = nome;
	}
	
	public Integer getIdCategoria() {
		return idCategoria;
	}
	
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
