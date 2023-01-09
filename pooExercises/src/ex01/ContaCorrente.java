package ex01;

import java.util.Scanner;

public class ContaCorrente {

	/*
	 * Crie uma classe para representar uma conta corrente que possui um número, um
	 * saldo, um status que informa se ela é especial ou não, um limite. Desenvolva
	 * métodos para realizar saque (verificando se o cliente pode realizar saques),
	 * depositar dinheiro, consultar saldo e verificar se o cliente está usando
	 * cheque especial ou não. Desenvolva um programa para testar essa classe.
	 */

	int numeroConta;
	float saldoConta;
	boolean contaEspecial;
	float limiteConta;

	Scanner scan = new Scanner(System.in);

	void apresentarOpcaoes() {

		System.out.println("Digite o número da sua conta");
		numeroConta = scan.nextInt();
		System.out.println();
		saldoConta = 0;
		limiteConta = 1500;
		contaEspecial = true;
		boolean flag = true;
		do {

			System.out.println("Digite as operaçõs que você gostaria de fazer");
			System.out.println();
			System.out.println("Depositar dinheiro: digite 1");
			System.out.println("Realizar Saques: digite 2");
			System.out.println("Consultar saldo: digite 3");
			System.out.println("Consultar status do cheque especial: digite 4");
			System.out.println("Deslogar da conta: digite 5");

			int opcao = scan.nextInt();

			if (opcao == 1) {
				System.out.println("Digite o valor para depósito");
				System.out.println();
				depositarDinheiro(scan.nextFloat());
			} else if (opcao == 2) {
				System.out.println("Digite o valor do saque");
				System.out.println();
				realizarSaques(scan.nextFloat());
			} else if (opcao == 3) {
				consultarSaldo();

			} else if (opcao == 4) {
				System.out.println(consultarCheque());
			} else {
				System.out.println();
				System.out.println("A conta " + numeroConta + " foi deslogada");
				flag = false;
			}

		} while (flag);

	}

	void depositarDinheiro(float dinheiro) {
		saldoConta = saldoConta + dinheiro;

	}

	void realizarSaques(float dinheiro) {
		if (dinheiro < saldoConta || dinheiro == saldoConta) {
			saldoConta = saldoConta - dinheiro;
		} else {
			System.out.println();
			System.out.println("Você não possui saldo sulficiente");
			System.out.println();
		}

	}

	void consultarSaldo() {
		System.out.println("O saldo da sua conta é: " + saldoConta);
		System.out.println();

	}

	String consultarCheque() {
		String mensagem = "";

		if (contaEspecial) {
			mensagem = "A sua conta é especial";
			System.out.println();
			return mensagem;
		} else {
			mensagem = "A sua conta não é especial";
			System.out.println();
			return mensagem;
		}

	}

}
