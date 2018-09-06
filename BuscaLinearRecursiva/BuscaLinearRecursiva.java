import java.util.Scanner;

class BuscaLinearRecursiva {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] array = getArrayInteiros(scan);
		int elemento = Integer.parseInt(scan.nextLine());
		System.out.println(buscaLinearRecursiva(elemento, array));
	}

	public static int buscaLinearRecursiva(int elemento, int[] array) {
		return buscaLinearRecursiva(elemento, array, 0);
	}

	private static int buscaLinearRecursiva(int elemento, int[] array, int indice) {
		int result = -1;
		if (indice < array.length && array[indice] == elemento) {
			result = indice;
		} else if (indice < array.length) {
			result = buscaLinearRecursiva(elemento, array, indice + 1);
		}
		return result;
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
