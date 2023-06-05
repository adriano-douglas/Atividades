package Trabalho_Etapa2_POO_AdrianoRosa.models;

import java.time.LocalDate;
import java.util.ArrayList;;

public class Cliente extends Pessoa {
	
	private LocalDate aniversario;
	
	public Cliente() {
		super();
	}

	public Cliente(Integer id, String nome, String cpf, String endereço, LocalDate aniversario) {
		super(id, nome, cpf, endereço);
		this.aniversario = aniversario;
	}

	public LocalDate getAniversario() {
		return aniversario;
	}

	public void setAniversario(LocalDate aniversario) {
		this.aniversario = aniversario;
	}

}
