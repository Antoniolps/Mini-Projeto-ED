import java.util.Scanner;

public class Menus {
	Lista lista = new Lista();
	int count = 0;
	
	public void cadastrarAluno() {
		Aluno aluno = new Aluno();
		Scanner entrada = new Scanner(System.in);
		String resposta;
		
		System.out.print("Digite o nome do Aluno: ");
		String nome = entrada.nextLine();
		
		System.out.print("Digite o rgm do Aluno: ");
		String rgm = entrada.next();
		entrada.nextLine();
		
		do {
			
			System.out.print("Digite a disciplina do Aluno: ");
			String disciplina = entrada.nextLine();
			
			System.out.print("Digite a primeira nota do aluno: ");
			double n1 = entrada.nextDouble();
			
			System.out.print("Digite a segunda nota do aluno: ");
			double n2 = entrada.nextDouble();
			
			String media = String.valueOf((n1 + n2) / 2);
			aluno.setNome(nome);
			aluno.setRgm(rgm);
			aluno.setMaterias(disciplina, media);
			
			System.out.println("Deseja cadastrar outra disciplina? (sim/não)");
			resposta = entrada.next();
			entrada.nextLine();
			
		}while(resposta.equalsIgnoreCase("sim"));
			
		boolean resultado = lista.inserir(count, aluno);
		
		if(resultado) {
			System.out.println("Aluno inserido com sucesso deseja inserir outro aluno? ");
			String resposta1 = entrada.next();
			count++;
			if(resposta1.equalsIgnoreCase("sim"))
				cadastrarAluno();
			else
				menuPrincipal();
		}
		else
			System.out.println("O aluno não foi inserido pois a lista está cheia.");
		entrada.close();
	}
	
	public void pesquisarAluno() {
		Aluno aluno = new Aluno();
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("\nDigite o RGM que deseja pesquisar: ");
		String rgm = entrada.next();
		
		aluno = lista.buscar(rgm);
		
		if(aluno == null)
			System.out.println("RGM não cadastrado!");
		else
			lista.exibirPosicao(lista.retornaPosicao(aluno));
		
		System.out.println("Deseja pesquisar outro RGM?");
		String resposta = entrada.next();
		
		if(resposta.equalsIgnoreCase("sim")) {
			pesquisarAluno();
		}
		else
			menuPrincipal();
		
		entrada.close();
	}
	
	public void removerAluno() {
		Scanner entrada = new Scanner(System.in);
		
		
		lista.exibirLista();
		
		System.out.println("Digite o RGM de quem voce deseja remover.");
		String rgm = entrada.next();
		
		int pos = lista.retornaPosicao(lista.buscar(rgm));
		
		boolean resultado = lista.remover(pos);
		
		if(resultado) {
			lista.exibirLista();
			if(!lista.isVazia()) {
				System.out.println("\nAluno removido com sucesso, deseja remover outro Aluno?");
				String resposta = entrada.next();
				
				if(resposta.equalsIgnoreCase("sim"))
					removerAluno();
				else
					menuPrincipal();
			}
			else {
				System.out.println("\nAluno removido com sucesso.");
				menuPrincipal();
			}
		}
		else {
			System.out.println("A o rgm digitado não está na lista!!!");
			removerAluno();
		}
		entrada.close();
	}
	
	public void exibir() {
		Scanner entrada = new Scanner(System.in);
		
		if(lista.isVazia())
			System.out.println("\nA lista está vazia");
		else
			lista.exibirLista();
		
		System.out.println("Deseja voltar ao menu principal? ");
		String resposta = entrada.next();
		
		if(resposta.equalsIgnoreCase("sim"))
			menuPrincipal();
		else
			System.exit(0);
		
		entrada.close();
	}
	
	
	
	public void menuPrincipal() {
		Scanner entrada = new Scanner(System.in);
		
		int opcao;
		
		do {
			
		System.out.println("——————————————«•»——————————————");
		System.out.println("          Menu Principal       ");
		System.out.println("——————————————«•»——————————————");
		System.out.println(" 1- Cadastrar Novo Aluno       ");
		System.out.println(" 2- Pesquisar Aluno            ");
		System.out.println(" 3- Remover Aluno              ");
		System.out.println(" 4- Exibir Alunos Cadastrados  ");
		System.out.println(" 5- Sair  ");
		System.out.println("——————————————«•»——————————————");
		System.out.print("\nEscolha uma Opção: ");
		
	
			opcao = entrada.nextInt();
			entrada.nextLine();
			
			switch (opcao) {
				case 1:
					cadastrarAluno();
					break;
				case 2:
					pesquisarAluno();
					break;
				case 3:
					removerAluno();
					break;
				case 4:
					exibir();
					break;
				case 5: 
					System.out.println("Fim da aplicação!");
					break;
				default:
					System.out.println("\nOpção inválida, tente novamente.");		
			}
		}while(opcao < 1 || opcao > 5);
		entrada.close();
	}
}
