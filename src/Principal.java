
public class Principal {

	public static void main(String[] args) {
		Lista listaSequencial = new Lista();
		
		Aluno a1 = new Aluno();
		Aluno a2 = new Aluno();
		
		a1.setNome("Antonio");
		a1.setRgm("28001371");
		a1.setMaterias("POO", "10.0");
		a1.setMaterias("ED", "9.5");
		a1.setMaterias("Matemática Discreta", "8.5");
		
		a2.setNome("José");
		a2.setRgm("29001222");
		a2.setMaterias("Cálculo 1", "10.0");
		
		listaSequencial.inserir(0, a1);
		listaSequencial.inserir(1, a2);
		
		listaSequencial.exibirLista();
		

	}

}
