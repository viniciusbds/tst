import java.util.Scanner;

public class MarianaEOsLivros {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] livros = scan.nextLine().split(",");
		insertionSort(livros);
		scan.close();
	}

	private static void insertionSort(String[] array) {

		for (int i = 0; i < array.length; i++) {
			String pivot = array[i];
			int k = i - 1;
			while (k >= 0 && array[k].compareTo(pivot) > 0) {
				array[k + 1] = array[k];
				k--;
			}
			array[k + 1] = pivot;
			System.out.println(imprimeArray(array));
		}

	}

	private static String imprimeArray(String[] array) {
		String result = "";
		for (int i = 0; i < array.length - 1; i++) {
			result += array[i] + ", ";
		}
		result += array[array.length - 1];
		return result;
	}
}
