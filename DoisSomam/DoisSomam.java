import java.util.Scanner;

class DoisSomam {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String[] entrada = scan.nextLine().split(" ");
		int[] array = toArray(entrada);
		int somaConsiderada = scan.nextInt();
		
		System.out.println(doisSomam(array, somaConsiderada));
		scan.close();
	}
	
	private static int[] toArray(String[] sequencia) {
		int[] array = new int[sequencia.length];
		for (int i = 0; i < sequencia.length; i++) {
			array[i] = Integer.parseInt(sequencia[i]);
		}
		return array;
	}
	
	private static String doisSomam(int[] array, int somaConsiderada) {
		String result = "-1";
		
		int i = 0;
		boolean achou = false;
		while(i < array.length && !achou) {
			int j = i + 1;
			while(j < array.length && !achou) {
				if (array[i] + array[j] == somaConsiderada) {
					achou = true;
					result = array[i] + " " + array[j];
				}
				j++;
			}
			i++;
		}
		
		return result;
	}
}
