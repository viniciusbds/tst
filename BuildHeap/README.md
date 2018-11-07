
# Build Heap

Escreva um programa que leia uma sequencia da entrada padrão e transforma essa sequência em um heap.

**Importante!** Como vimos em sala de aula, um heap pode ser representado em um array que é preenchido ao caminhar por nível (da esquerda para a direita) em um Heap. Por exemplo, o array [30, 10, 9, 7] representa um heap com raíz 30, cujos filhos da esquerda e direita são 10 e 9 respectivamente. Por último, 7 é o filho à esquerda de 10.

Assuma que ele já é completo ou quase-completo da esquerda para a direita.

## Entrada

Seu programa deve ler uma linha contém uma sequência de inteiros separados por espaço.

## Saída

Seu programa deve imprimir a sequência re-ordenada depois da aplicação do algoritmo build heap que vimos em sala de aula.

## Exemplos de execução

	javac MinhaSolucao.java; java MinhaSolucao
	23 27 45 2 49 26
	[49, 27, 45, 2, 23, 26]
	
	javac MinhaSolucao.java; java MinhaSolucao
	11 8 1 4 3
	[11, 8, 1, 4, 3]

## Dica

Use Arrays.toString() para facilitar a impressão do heap na saída.
