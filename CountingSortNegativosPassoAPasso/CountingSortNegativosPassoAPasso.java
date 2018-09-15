import java.util.Arrays;
import java.util.Scanner;

class CountingSortNegativosPassoAPasso {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] array = getArrayInteiros(scan);
		int max = Integer.parseInt(scan.nextLine());
		int min = Integer.parseInt(scan.nextLine());
		countingSort(array, max, min);
		scan.close();
	}

	private static void countingSort(int[] A, int max, int min) {

		int aux = -min;
		int k = max - min;

		int[] C = new int[k + 1];
		Arrays.fill(C, 0);
		int[] B = new int[A.length];
		Arrays.fill(B, 0);

		for (int i = 0; i < A.length; i++) {
			C[A[i] + aux]++;
			imprimeArray(C);
		}

		for (int i = 1; i < C.length; i++) {
			C[i] += C[i - 1];
		}
		imprimeCumulativa(C);

		int a;
		int posicao;
		for (int i = A.length - 1; i >= 0; i--) {
			a = A[i];
			posicao = --C[a + aux];
			B[posicao] = a;
		}

		for (int i = 0; i < B.length; i++) {
			A[i] = B[i];
		}

		imprimeArray(C);
		imprimeArray(A);

	}

	private static int[] getArrayInteiros(Scanner scan) {
		String[] entrada = scan.nextLine().split(" ");
		int[] array = new int[entrada.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(entrada[i]);
		}
		return array;
	}

	private static void imprimeArray(int[] array) {
		System.out.println(Arrays.toString(array));
	}

	private static void imprimeCumulativa(int[] array) {
		String result = "Cumulativa do vetor de contagem - " + Arrays.toString(array);
		System.out.println(result);
	}

}
