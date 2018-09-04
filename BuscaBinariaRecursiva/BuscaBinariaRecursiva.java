import java.util.Scanner;

class BuscaBinariaRecursiva {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] array = getArrayInteiros(scan);
		int numero = Integer.parseInt(scan.nextLine());
		if (buscaBinariaRecursiva(numero, array) == -1) {
			System.out.println(-1);
		}

	}

	private static int buscaBinariaRecursiva(int elemento, int[] array) {
		return search(elemento, array, 0, array.length - 1);
	}

	private static int search(int elemento, int array[], int esquerda, int direita) {
		
		int meio = (esquerda + direita) / 2;
		System.out.println(meio);
		if (esquerda < direita) {
			if (elemento == array[meio]) {
				return meio;
			}
			else if (elemento < array[meio]) {
				return search(elemento, array, esquerda, meio - 1);
			} else {
				return search(elemento, array, meio + 1, direita);
			}
			
		}
		return -1;
	}

	private static int[] getArrayInteiros(Scanner scan) {
		String[] entrada = scan.nextLine().split(" ");
		int[] array = new int[entrada.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(entrada[i]);
		}
		return array;
	}

}
