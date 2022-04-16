
public class ListaDisciplina {
	private Disciplina primeiro;
	private Disciplina ultimo;
	private int tamanho;
	
	public ListaDisciplina() {
		this.tamanho = 0;
	}

	public Disciplina getPrimeiro() {
		return primeiro;
	}

	public void setPrimeiro(Disciplina primeiro) {
		this.primeiro = primeiro;
	}

	public Disciplina getUltimo() {
		return ultimo;
	}

	public void setUltimo(Disciplina ultimo) {
		this.ultimo = ultimo;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	
	public void adicionar(String nomeDisciplina, String nota) {
		Disciplina novaDisciplina = new Disciplina(nomeDisciplina, nota);
		
		if(this.primeiro == null && this.ultimo == null){
			this.primeiro = novaDisciplina;
			this.ultimo = novaDisciplina;
		}else {
			this.ultimo.setProximo(novaDisciplina);
			this.ultimo = novaDisciplina;
		}
		this.tamanho++;
	}
	
	public Disciplina remover(String removido) {
		Disciplina anterior = null;
		Disciplina atual = this.primeiro;
		
		for(int i=0; i < this.getTamanho(); i++) {
			if(atual.getDisciplina().equalsIgnoreCase(removido)) {
				if(this.tamanho == 1) {
					this.primeiro = null;
					this.ultimo = null;
				}else if(atual == primeiro) {
					this.primeiro = atual.getProximo();
					atual.setProximo(null);
				}else {
					anterior.setProximo(atual.getProximo());
					atual = null;
				}
				this.tamanho--;
				return null;
			}
			anterior = atual;
			atual = atual.getProximo();
		}
		return null;
	}
	
	public void exibirDisciplinas() {
		Disciplina atual = this.primeiro;
		
		if(tamanho == 0)
			System.out.println("A lista de disciplinas do aluno está vazia!");
		
		if(tamanho > 0)
			for(int i = 0; i < tamanho; i++) {
				System.out.println("Disciplina: " + atual.getDisciplina() + "| Média na disciplina: " + atual.getNota());
				atual = atual.getProximo();
		}
	}
}
