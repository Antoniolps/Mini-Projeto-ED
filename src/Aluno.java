
public class Aluno {
	String nome;
	String rgm;
	ListaDisciplina materias = new ListaDisciplina();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRgm() {
		return rgm;
	}
	public void setRgm(String rgm) {
		this.rgm = rgm;
	}
	public ListaDisciplina getMaterias() {
		return materias;
	}
	public void setMaterias(String disciplina, String nota) {
		this.materias.adicionar(disciplina, nota);
	}
	
	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", rgm=" + rgm + ", materias=" + materias + "]";
	}
	
	
}
