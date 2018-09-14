import java.util.Scanner;

class CountingSortPassoAPasso {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] array = getArrayInteiros(scan);
		int k = Integer.parseInt(scan.nextLine());
		countingSort(array, k);
		scan.close();
	}

	private static void countingSort(int[] A, int k) {

		int min = min(A);
		int aux = -min + 1;

		int[] C = new int[k + 1];
		preencheArrayNulo(C);
		int[] B = new int[A.length];
		preencheArrayNulo(B);

		for (int i = 0; i < A.length; i++) {
			C[A[i] + aux]++;
			imprimeArray(C);
		}

		for (int i = 1; i < C.length; i++) {
			C[i] += C[i - 1];
		}
		imprimeCumulativa(C);

		for (int i = A.length - 1; i >= 0; i--) {
			int a = A[i];
			int posicao = --C[a + aux];
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

	private static int min(int[] array) {
		int result = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] < result) {
				result = array[i];
			}
		}
		return result;
	}

	private static void preencheArrayNulo(int[] c) {
		for (int i = 0; i < c.length; i++) {
			c[i] = 0;
		}
	}

	private static String strArray(int[] array) {
		String result = "";
		for (int i = 0; i < array.length - 1; i++) {
			result += array[i] + " ";
		}
		result += array[array.length - 1] + "";
		return result;
	}

	private static void imprimeArray(int[] array) {
		System.out.println(strArray(array));
	}

	private static void imprimeCumulativa(int[] array) {
		String result = "Cumulativa do vetor de contagem - " + strArray(array);
		System.out.println(result);
	}

}
