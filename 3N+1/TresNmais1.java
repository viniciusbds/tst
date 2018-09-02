import java.util.ArrayList;
import java.util.Scanner;

class TresNmais1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n1 = Integer.parseInt(scan.nextLine());
		int n2 = Integer.parseInt(scan.nextLine());

		ArrayList<Integer> sequencia;
		int result = 0;
		for (int i = n1; i <= n2; i++) {
			sequencia = geraSequencia(i);
			if (sequencia.size() > result) {
				result = sequencia.size();
			}
		}

		System.out.println(result);
		scan.close();
	}

	private static ArrayList<Integer> geraSequencia(int numero) {
		ArrayList<Integer> lista = new ArrayList<>();
		while (numero != 1 && numero != 0) {
			lista.add(numero);
			if (ehPar(numero)) {
				numero = numero / 2;
			} else {
				numero = 3 * numero + 1;
			}
		}
		lista.add(numero);
		return lista;
	}

	private static boolean ehPar(int numero) {
		return numero % 2 == 0;
	}
}
