
public class Lista {
	Aluno[] alunos = new Aluno[60];
	int tamanho =0;
	
	
	public boolean isVazia() {
		if(tamanho == 0)
			return true;
		
		return false;
	}
	
	public boolean isCheia() {
		return (tamanho == alunos.length);
	}
	
	public int tamanhoLista() {
		return tamanho;
	}
	
	public boolean compara(Aluno a1, Aluno a2) {
		return(a1.nome.equals(a2.nome) && a1.rgm.equals(a2.rgm));
	}
	
	public Aluno buscar(String matricula) {
		for(int i=0; i < tamanho; i++)
			if(alunos[i].rgm.equalsIgnoreCase(matricula))
				return alunos[i];
		
		return null;
	}
	
	public int retornaPosicao(Aluno aluno) {
		for(int i=0; i < tamanho; i++)
			if(compara(alunos[i], aluno))
				return i;
		return -1;
	}
	
	public void deslocarParaDireita(int pos) {
		for(int i = pos; i < (tamanho - 1); i++)
			alunos[i] = alunos[i+1];
	}
	
	public boolean inserir(int pos, Aluno a1) {
		if(isCheia() || (pos > tamanho) || (pos < 0))
			return false;
		
		deslocarParaDireita(pos);
		alunos[pos] = a1;
		tamanho++;
		return true;
	}
	
	public void deslocarParaEsquerda(int pos) {
		for(int i = tamanho; i > pos; i--)
			alunos[i] = alunos[i-1];
	}
	
	public boolean remover(int pos) {
		if((pos >= tamanho) || (pos < 0))
			return false;
		
		deslocarParaEsquerda(pos);
		tamanho --;
		return true;
	}
	
	public void exibirPosicao(int i) {
			System.out.println(	"\nAluno " + (i+1) + 
								"\nNome: " + alunos[i].getNome() +
								"\nRGM: "  + alunos[i].getRgm()  +
								"\nDisciplinas: ");
			alunos[i].getMaterias().exibirDisciplinas();
	}
	
	public void exibirLista() {
		if(isVazia())
			System.out.println("A lista está vazia");
		
		for(int i = 0; i < tamanho; ++i) {
			System.out.println(	"\nAluno " + (i+1) + 
								"\nNome: " + alunos[i].getNome() +
								"\nRGM: "  + alunos[i].getRgm()  +
								"\nDisciplinas: ");
			alunos[i].getMaterias().exibirDisciplinas();
		}
	}
}
