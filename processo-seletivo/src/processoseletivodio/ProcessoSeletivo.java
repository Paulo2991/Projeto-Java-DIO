package processoseletivodio;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] candidatos = { "FELIPE", "MÁRCIA", "JULIA", "PAULO", "AUGUSTO" };
		for (String cadidato : candidatos) {
			entrandoEmContato(cadidato);
		}
	}

	static void entrandoEmContato(String candidato) {
		int tentativasRealizadas = 1;
		boolean continuarTentando = true;
		boolean atendeu = false;
		do {
			atendeu = atender();
			continuarTentando = !atendeu;
			if (continuarTentando) {
				tentativasRealizadas++;
			} else {
				System.out.println("Contato Realizado Com Sucesso:");
			}
		} while (continuarTentando && tentativasRealizadas < 3);
		if (atendeu) {
			System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + " TENTATIVA");
		} else {
			System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + ", NÚMERO MAXIMO TENTATIVAS "
					+ tentativasRealizadas + " REALIZADA");
		}
	}

	static boolean atender() {
		return new Random().nextInt(3) == 1;
	}

	static void imprimirSelecionados() {
		String[] candidatos = { "FELIPE", "MÁRCIA", "JULIA", "PAULO", "AUGUSTO" };
		System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");
		for (int indice = 0; indice < candidatos.length; indice++) {
			System.out.println("O candidato de n: " + (indice + 1) + " é " + candidatos[indice]);
		}

		System.out.println("Forma abreviada de interação for each");
		for (String candidato : candidatos) {
			System.out.println("O candidato selecionado foi: " + candidato);
		}
	}

	static void selecaoCanditados() {
		String[] candidatos = { "FELIPE", "MÁRCIA", "JULIA", "PAULO", "AUGUSTO", "MÔNICA", "FABRÍCIO", "MIRELA",
				"DANIELA", "JORGE" };
		int canditatosSelecionados = 0;
		int canditatoAtual = 0;
		double salarioBase = 2000.0;
		while (canditatosSelecionados < 5 && canditatoAtual < candidatos.length) {
			String canditato = candidatos[canditatoAtual];
			double salarioPretendido = valorPretendido();
			System.out.println("O canditato " + canditato + " Solicitou esse valor de salário " + salarioPretendido);
			if (salarioBase >= salarioPretendido) {
				System.out.println("O canditato " + canditato + " foi selecionado para a vaga");
				canditatosSelecionados++;
			}
			canditatoAtual++;
		}
	}

	static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800, 2200);
	}

	static void analisarCanditato(double salarioPretendido) {
		double salarioBase = 2000.0;
		if (salarioBase > salarioPretendido) {
			System.out.println("Ligar para o canditato:");
		} else if (salarioBase == salarioPretendido) {
			System.out.println("Ligar para o canditato com a contra proposta");
		} else {
			System.out.println("Aguardando o resultado dos demais cantidatos");
		}
	}
}
