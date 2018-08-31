import java.util.Arrays;
import java.util.Scanner;

class MoveImpostor {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] entrada = scan.nextLine().split(" ");
		int[] array = new int[entrada.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(entrada[i]);
		}
		moveImpostor(array);
		System.out.println(Arrays.toString(array));
		scan.close();
	}
	
	private static void moveImpostor(int[] array) {
		int indexImpostor = getIndiceImpostor(array);
		boolean impostorNaEstaNaPosicaoCorreta = false;
		int i = indexImpostor;
		while (i > 0 && !impostorNaEstaNaPosicaoCorreta) {
			if (array[i] < array[i-1]) {
				swap(array, i, i-1);
			}
			i--;
		}
	}
	
	private static int getIndiceImpostor(int[] array) {
		int indexImpostor = -1;
		int i = 0;
		while (indexImpostor < 0 && i < array.length - 1) {
			if (array[i] > array[i + 1]) {
				indexImpostor = i + 1;
			}
			i++;
		}
		return indexImpostor;
	}
		
	private static void swap(int[] array, int i, int j) {
		int aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}
	
}
