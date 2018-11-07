import java.util.Scanner;

class EhHeap {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] elements = getArrayInteiros(scan);
		System.out.println(ehHeap(elements));
		scan.close();
	}

	public static boolean ehHeap(int[] elements) {
		boolean result = true;
		
		int i = 0;
		while (result && left(i) < elements.length && right(i) < elements.length) {
			if (elements[left(i)] > elements[parent(i)] || elements[right(i)] > elements[parent(i)]) {
				result = false;
			}
			i++;
		}

		return result;
	}

	private static int parent(int i) {
		return (i - 1) / 2;
	}

	private static int left(int i) {
		return (2 * i + 1);
	}

	private static int right(int i) {
		return (2 * i + 1) + 1;
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
