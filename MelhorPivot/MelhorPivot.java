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

		int indexMedia = getIndexMedia(array);
		int distI = Math.abs(i - indexMedia);
		int distJ = Math.abs(j - indexMedia);

		if (distI <= distJ) {
			result = i;
		} else {
			result = j;
		}

		return result;

	}

	private static int getIndexMedia(int[] array) {
		int media = (min(array) + max(array)) / 2;
		int i = 0;
		while (i < array.length && array[i] < media) {
			i++;		
		}
		return i;
	}

	private static int[] getArrayInteiros(Scanner scan) {
		String[] entrada = scan.nextLine().split(" ");
		int[] array = new int[entrada.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(entrada[i]);
		}
		return array;
	}

	private static int max(int[] array) {
		int result = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] > result) {
				result = array[i];
			}
		}
		return result;
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

}
