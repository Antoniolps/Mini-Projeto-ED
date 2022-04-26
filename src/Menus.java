import java.util.Scanner;

public class Menus {
	Lista lista = new Lista();
//	int count = 0;
	
	public void cadastrarAluno() {
		Aluno aluno = new Aluno();
		Scanner entrada = new Scanner(System.in);
		String resposta;
		
		if(!lista.isCheia()) {
			System.out.print("\nInforme o Nome do Aluno: "); 
			String nome = entrada.nextLine();
			
			System.out.print("Informe o RGM do Aluno: ");
			String rgm = entrada.next();
			entrada.nextLine();
			
			do {
				
				System.out.print("Informe a Disciplina do Aluno: ");
				String disciplina = entrada.nextLine();
				
				System.out.print("Informe a Primeira Nota do Aluno: ");
				double n1 = entrada.nextDouble();
				
				System.out.print("Informe a Segunda Nota do Aluno: ");
				double n2 = entrada.nextDouble();
				
				String media = String.valueOf((n1 + n2) / 2);
				aluno.setNome(nome);
				aluno.setRgm(rgm);
				aluno.setMaterias(disciplina, media);
				
				System.out.println("\nDeseja Cadastrar Nova Disciplina? (sim/não)");
				resposta = entrada.next();
				entrada.nextLine();
				
			}while(resposta.equalsIgnoreCase("sim"));
				
			boolean resultado = lista.inserir(lista.organizaLista(aluno.getRgm()), aluno);
			
			if(resultado) {
				System.out.println("\nAluno Cadastrado Com Sucesso! Deseja Cadastrar Novo Aluno?(sim/não)");
				String resposta1 = entrada.next();
//				count++;
				if(resposta1.equalsIgnoreCase("sim"))
					cadastrarAluno();
				else
					menuPrincipal();
			}
			else
				System.out.println("\nAluno Não Foi Cadastrado.");
		}
		else {
			System.out.println("A lista está cheia!");
			menuPrincipal();
		}
		entrada.close();
	}
	
	public void pesquisarAluno() {
		Aluno aluno = new Aluno();
		Scanner entrada = new Scanner(System.in);
		
		if(!lista.isVazia()) {
			System.out.print("\nInforme o RGM Para Ser Pesquisado: ");
			String rgm = entrada.next();
			
			aluno = lista.buscar(rgm);
			
			if(aluno == null)
				System.out.println("\nRGM Informado Não Está Cadastrado!");
			else
				lista.exibirPosicao(lista.retornaPosicao(aluno));
			
			System.out.println("\nDeseja Pesquisar Outro RGM?");
			String resposta = entrada.next();
			
			if(resposta.equalsIgnoreCase("sim")) {
				pesquisarAluno();
			}
			else
				menuPrincipal();
		}
		else {
			System.out.println("\nA lista está vazia, adicione alguem primeiro para poder pesquisar!");
			menuPrincipal();
		}
		entrada.close();
	}
	
	public void removerAluno() {
		Scanner entrada = new Scanner(System.in);
		
		
		lista.exibirLista();
		
		if(!lista.isVazia()) {
			System.out.print("\nInforme o RGM Para Ser Removido: ");
			String rgm = entrada.next();
		
		
			int pos = lista.retornaPosicao(lista.buscar(rgm));
			
			boolean resultado = lista.remover(pos);
			
			if(resultado) {
//				count--;
				lista.exibirLista();
				if(!lista.isVazia()) {
					System.out.println("\nAluno Removido Com Sucesso, Deseja Remover Outro Aluno?");
					String resposta = entrada.next();
					
					if(resposta.equalsIgnoreCase("sim"))
						removerAluno();
					else
						menuPrincipal();
				}
				else {
					System.out.println("\nAluno Foi Removido Com Sucesso!");
					menuPrincipal();
				}
			}
			else {
				System.out.println("\nO RGM Informado Não Está na Lista!");
				removerAluno();
			}
		}
		else {
			System.out.println("Não é possivel remover pois a lista está vazia!");
			menuPrincipal();
		}
		entrada.close();
	}
	
	public void exibir() {
		Scanner entrada = new Scanner(System.in);
		
		if(lista.isVazia())
			System.out.println("\nNão Há Cadastrados na Lista.");
		else
			lista.exibirLista();
		
		System.out.println("\nDeseja Voltar ao Menu Principal?");
		String resposta = entrada.next();
		
		if(resposta.equalsIgnoreCase("sim"))
			menuPrincipal();
		else
			System.exit(0);
		
		entrada.close();
	}
	
	public void menuPrincipal() {
		Scanner entrada = new Scanner(System.in);
		
		String opcao;
		
		do {
		System.out.println("——————————————————————————————");
		System.out.println("        Menu Principal        ");
		System.out.println("——————————————————————————————");
		System.out.println(" 1- Cadastrar Novo Aluno      ");
		System.out.println(" 2- Pesquisar Aluno           ");
		System.out.println(" 3- Remover Aluno             ");
		System.out.println(" 4- Exibir Alunos Cadastrados ");
		System.out.println(" 5- Sair                      ");
		System.out.println("——————————————————————————————");
		System.out.print("\nEscolha uma Opção: ");
		
	
			opcao = entrada.next();
			entrada.nextLine();
			
			switch (opcao) {
				case "1":
					cadastrarAluno();
					break;
				case "2":
					pesquisarAluno();
					break;
				case "3":
					removerAluno();
					break;
				case "4":
					exibir();
					break;
				case "5": 
					System.out.println("\nFim da Aplicação!");
					break;
				default:
					System.out.println("\nOpção Inválida, Tente Novamente.");		
			}
		}while(Integer.parseInt(opcao) < 1 || Integer.parseInt(opcao) > 5);
		entrada.close();
	}
}
