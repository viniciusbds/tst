import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
		Set<Integer> conjunto = new HashSet<Integer>();
		for (int i = 0; i < array.length; i++) {
			if (conjunto.contains(array[i])) {
				return true;
			} else {
				conjunto.add(array[i]);
			}
		}
		return false;
	}

}
