import java.util.Scanner;

class BuscaBinaria {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int[] listaDeNumeros = preencheArray();
		int numero = scan.nextInt();
		
		System.out.println(buscaBinaria(numero,listaDeNumeros));

	}

	public static int[] preencheArray() {
		String[] linha = scan.nextLine().split(" ");
		int[] numeros = new int[linha.length];
		for (int i = 0; i < linha.length; i++) {
			numeros[i] = Integer.parseInt(linha[i]);
		}
		return numeros;
	}

	public static int buscaBinaria(int elemento, int[] array) {
		
		int max = array.length - 1;
		int min = 0;
		int palpite = (int) Math.floor((max + min) / 2);
		
		while(max >= min) {
			
			if (array[palpite] == elemento) {
				return palpite;
			}
			else if (array[palpite] < elemento) {
				min = palpite + 1;
			} 
			else if (array[palpite] > elemento) {
				max = palpite - 1;	
			}
			
			System.out.println(palpite);
			
			palpite = (max + min) / 2;
		}
		
		return -1;
	}

}
