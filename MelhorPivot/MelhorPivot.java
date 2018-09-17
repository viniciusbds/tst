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
		int result = i;
		int media = (min(array) + max(array)) / 2;
		
		
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
