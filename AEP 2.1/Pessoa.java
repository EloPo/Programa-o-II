package pessoa;

import java.util.UUID;

public abstract class Pessoa {
	private UUID id;
	private String nome;

	Pessoa(String nome) {
		this.nome = nome;
	}

	Pessoa(UUID id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public UUID getId() {
		return id;
	}
}
