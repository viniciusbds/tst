import java.util.Scanner;

class EstatisticaDeOrdem {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] array = getArrayInteiros(scan);
		System.out.println(estatisticaDeOrdem(array));
		scan.close();
	}

	private static int estatisticaDeOrdem(int[] array) {
		int primeiro = array[0];
		boolean achou = false;
		int i = 0;
		while (i < array.length && !achou) {

			int indexMin = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[indexMin]) {
					indexMin = j;
				}
			}
			swap(array, i, indexMin);

			if (primeiro == array[i]) {
				achou = true;
			}
			i++;
		}
		return i;
	}

	private static void swap(int[] array, int i, int j) {
		int aux = array[j];
		array[j] = array[i];
		array[i] = aux;
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
