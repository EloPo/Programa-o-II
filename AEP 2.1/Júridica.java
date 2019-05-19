package pessoa;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Júridica extends Pessoa {
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

	public void adicionarSócio(Pessoa sócio, double percentualParticipacão) {
		CotaSociedade cota = new CotaSociedade();
		for (CotaSociedade cotas : cotasSociedade) {
			if (cotas.equals(sócio) && percentualParticipacão > 0 && percentualParticipacão <= 100) {
				cota.sócio = sócio;
				cota.percentualDeParticipação = percentualParticipacão;
				cotasSociedade.add(cota);
			} else {
				throw new RuntimeException("Proibido ser sócio de sí mesmo");
			}
		}
	}

	public void removerSócio(Pessoa sócio) {
		for (CotaSociedade cotas : cotasSociedade) {
			if (cotas.sócio == sócio) {
				cotasSociedade.remove(cotas);
			}
		}
	}

	private class CotaSociedade {
		private Pessoa sócio;
		private double percentualDeParticipação;

		@Override
		public boolean equals(Object obj) {
			if(((Pessoa) obj).getNome().equals(this.sócio.getNome())) {
				return false;
			}
			return true;
		}
	}

	public void listarSocios() {
		for (CotaSociedade auxiliar : cotasSociedade) {
			System.out.println("Nome: " + auxiliar.sócio.getNome());
			System.out.println("Percentual: " + auxiliar.percentualDeParticipação);
		}
	}

}
