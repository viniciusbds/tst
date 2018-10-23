import java.util.Scanner;

class TorreDeHanoi {

	/**
	 * Para resolver um jogo onde precisamos mover n discos, considerando n > 1,
	 * podemos executar os seguintes passos:
	 * 
	 * · Mover n-1 discos para o “pino de trabalho”.
	 * 
	 * · Mover o n-ésimo pino (o maior de todos) do “pino origem” para o “pino
	 * destino”.
	 * 
	 * · Após isto, devemos resolver o problema da “Torre de Hanói” para os n-1
	 * discos dispostos no “pino de trabalho”, movendo-os para o “pino destino”
	 * utilizando o mesmo princípio.
	 * 
	 * creditos : devmedia
	 * 
	 **/

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int quantidadeDeDiscos = scan.nextInt();
		solveHanoi(quantidadeDeDiscos, "A", "B", "C");
		scan.close();
	}

	private static void solveHanoi(int n, String origem, String trabalho, String destino) {
		if (n > 0) {
			solveHanoi(n - 1, origem, destino, trabalho);
			moverDisco(n, origem, destino);
			solveHanoi(n - 1, trabalho, origem, destino);
		}
	}

	private static void moverDisco(int numeroDisco, String origem, String destino) {
		System.out.println("Move o disco " + numeroDisco + " da haste " + origem + " para a haste " + destino);
	}

}
