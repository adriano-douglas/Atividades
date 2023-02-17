package Atividade2;

public class LivroCategoria {
	
	private Integer idLivro;
	private Integer idCategoria;
	
	public LivroCategoria() {
		super();
	}
	
	public LivroCategoria(Integer idLivro, Integer idCategoria) {
		super();
		this.idLivro = idLivro;
		this.idCategoria = idCategoria;
	}
	
	public Integer getIdLivro() {
		return idLivro;
	}
	
	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
	}
	
	public Integer getIdCategoria() {
		return idCategoria;
	}
	
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
}
