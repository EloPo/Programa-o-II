package pessoa;

import java.util.UUID;

public class Física extends Pessoa {
	private String cpf;
	private String rg;

	Física(String nome, String rg, String cpf) {
		super(nome);
		this.rg = rg;
		if (cpf != null && !cpf.isEmpty()) {
			this.cpf = cpf;
		}
	}

	Física(UUID id, String cpf, String nome, String rg) {
		super(id, nome);
		this.rg = rg;
		if ((cpf != null && !cpf.isEmpty())) {
			this.cpf = cpf;
		}
	}

	public String getCpf() {
		return cpf;
	}

	public String getRg() {
		return rg;
	}

}
