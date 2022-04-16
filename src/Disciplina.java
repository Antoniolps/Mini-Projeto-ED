
public class Disciplina {
	String disciplina;
	String nota;
	Disciplina proximo;
	
	public Disciplina(String novaDisciplina, String novaNota) {
		this.disciplina = novaDisciplina;
		this.nota = novaNota;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public Disciplina getProximo() {
		return proximo;
	}

	public void setProximo(Disciplina proximo) {
		this.proximo = proximo;
	}
}
