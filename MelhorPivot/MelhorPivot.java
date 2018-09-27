import java.util.Scanner;

class MelhorPivot {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int[] array = getArrayInteiros(scan);
		int i = scan.nextInt();
		int j = scan.nextInt();
		int melhorPivot = melhorPivot(array, i, j);
		System.out.println(melhorPivot);
		scan.close();

	}

	private static int melhorPivot(int[] array, int i, int j) {
		int result = 0;

		int countI = 0;
		int countJ = 0;
		for (int k = 0; k < array.length; k++) {
			if (array[k] < array[i]) {
				countI++;
			} else if (array[i] < array[k]) {
				countI--;
			}
			if (array[k] < array[j]) {
				countJ++;
			} else if (array[j] < array[k]) {
				countJ--;
			}
		}

		if (Math.abs(countI) <= Math.abs(countJ)) {
			result = i;
		} else {
			result = j;
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
