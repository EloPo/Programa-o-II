public class Avaliacao {
	private float nota;
	private Disciplina disciplina;
	private Aluno aluno;

	public Avaliacao(float nota, Disciplina disciplina, Aluno aluno) {
		if (0 <= nota || nota <= 10) {
			this.nota = nota;
			this.disciplina = disciplina;
			this.aluno = aluno;
		}
		throw new RuntimeException("Nota invalida");
	}
	public float getNota() {
		return nota;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public Aluno getAluno() {
		return aluno;
	}
}