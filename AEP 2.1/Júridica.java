package pessoa;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Juridica extends Pessoa {
	private String cnpj;
	private double capitalSocial;
	private HashSet<CotaSociedade> cotasSociedade;

	public Set<CotaSociedade> getCotasSociedade() {
		return cotasSociedade;
	}

	Júridica(String nome, String cnpj, double capitalSocial) {
		super(nome);
		if (cnpj != null && !cnpj.isEmpty()) {
			this.cnpj = cnpj;
		}
		this.capitalSocial = capitalSocial;
		cotasSociedade = new HashSet<>();
	}

	Júridica(UUID id, String nome, String cnpj, double capitalSocial) {
		super(id, nome);
		this.cnpj = cnpj;
		this.capitalSocial = capitalSocial;
		cotasSociedade = new HashSet<>();
	}

	public String getCnpj() {
		return cnpj;
	}

	public double getCapitalSocial() {
		return capitalSocial;
	}

	public void adicionarSocio(Pessoa socio, double percentualParticipacao) {
		CotaSociedade cota = new CotaSociedade();
		for (CotaSociedade cotas : cotasSociedade) {
			if (cotas.equals(socio) && percentualParticipacao > 0 && percentualParticipacao <= 100) {
				cota.socio = socio;
				cota.percentualDeParticipacao = percentualParticipacao;
				cotasSociedade.add(cota);
			} else {
				throw new RuntimeException("Proibido ser sócio de sí mesmo");
			}
		}
	}

	public void removerSocio(Pessoa socio) {
		for (CotaSociedade cotas : cotasSociedade) {
			if (cotas.socio == socio) {
				cotasSociedade.remove(cotas);
			}
		}
	}

	private class CotaSociedade {
		private Pessoa socio;
		private double percentualDeParticipacao;

		@Override
		public boolean equals(Object obj) {
			if(((Pessoa) obj).getNome().equals(this.socio.getNome())) {
				return false;
			}
			return true;
		}
	}

	public void listarSocios() {
		for (CotaSociedade auxiliar : cotasSociedade) {
			System.out.println("Nome: " + auxiliar.socio.getNome());
			System.out.println("Percentual: " + auxiliar.percentualDeParticipacao);
		}
	}

}
