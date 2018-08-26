import java.util.Scanner;

class VerificacaoDeElementosDuplicados {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] sequencia = scan.nextLine().split(" ");
		int[] array = new int[sequencia.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(sequencia[i]);
		}

		if (contemRepetidos(array)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		scan.close();
	}

	private static boolean contemRepetidos(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] == array[j]) {
					return true;
				}
			}
		}
		return false;
	}

}
