package ex02;
import java.util.Scanner;

public class Aluno {
	/*Escreva uma classe para representar um Aluno. Adicione atributos
	 * relacionados às características de um Aluno, como nome, matrícula, cursos que está matriculado
	 * nome de 3 diciplinas que está cursando e as notas dessas 3 diciplinas. Desenvolva um método para verificar se o aluno está aprovado 
	 * ( nota maior ou igual a 7) em uma determinada disciplina.
	 * Escreva um programa para testar essa classe, que pede as informações do aluno
	 * ao usuário e ao final informar o nome das disciplinas, mostra as notas e mostra se o aluno foi 
	 * aprovado ou não.*/

	String nomeAluno;
	int matriculaAluno;
	String cursoMatriculado;
	String[] disciplinas = new String[3];
	double[][] notasAluno  = new double[3][3];
	double[] mediaNotas = new double[3];
	
	Scanner scan = new Scanner(System.in);
	
	
	void obterInformacoes() {
		
		System.out.println("Para começar, digite o seu nome: ");
		System.out.println();
		nomeAluno = scan.nextLine();
		System.out.println();
		System.out.println("Agora digite o seu número de matrícula: ");
		System.out.println();
		matriculaAluno = scan.nextInt();
		scan.nextLine();
		System.out.println();
		System.out.println("Digite o seu curso: ");
		System.out.println();
		cursoMatriculado = scan.next();
		System.out.println();
		obterDiciplinas();
		obterNotas();
	}
	
	void obterDiciplinas() {
		
		for(int i = 0; i < disciplinas.length; i++) {
			scan.nextLine();
			System.out.println("Digite o nome da " + (i+1)+" º disciplina: ");
			disciplinas[i] = scan.next();
			
		}
		
	}
	
	void obterNotas() {
		
		for(int i = 0; i < notasAluno.length; i++) {
			for(int k = 0; k < notasAluno[i].length; k++) {
				scan.nextLine();
				System.out.println();
				System.out.print("Digite a " + (k+1) + "º nota da disciplina " + disciplinas[i]+": ");
				notasAluno[i][k] = scan.nextDouble();
			}
		}
	}
	
	String calcularNota() {
		
		for(int i = 0; i < notasAluno.length; i++) {
			double somaNotas = 0;
			for(int k = 0; k < notasAluno[i].length;k++) {
				somaNotas = somaNotas+notasAluno[i][k];
			}
			mediaNotas[i] = somaNotas/3;
		}
		
		
		
		double somaMedias = 0;
		for(int i = 0; i < mediaNotas.length; i++) {
			somaMedias =  somaMedias+mediaNotas[i];
		}
		somaMedias = somaMedias/3;
		
		String mensagem;
		if(somaMedias>7 || somaMedias == 7) {
			mensagem = "Aprovado";
			 ;
		}else {
			mensagem = "Reprovado";
		}
		
		return mensagem;
		
	}
	
	
	void printarInformacoes() {
		System.out.println("-----------------------------------------------------------------");
		System.out.println();
		System.out.println("Olá, " + nomeAluno + " segue abaixo as suas informações ");
		System.out.println();
		System.out.println("Natrícula: " + matriculaAluno);
		System.out.println("Curso matriculado: " + cursoMatriculado);
		for(int i = 0; i< disciplinas.length;i++) {
			System.out.println("Disciplina: " + (i+1) +" " + disciplinas[i] );
		}
		
		System.out.println("Situação do aluno: " + calcularNota());
		
	}
	
}
