# Selection Sort recursivo

Escreva um programa recursivo que ordena um array de inteiros utilizando o selection sort.

Seu programa deve imprimir o status do array a cada modificação nele. Lembre-se que no Selection Sort, alteramos o array quando encontramos o menor elemento e o colocamos na sua posição.

## Entrada

Seu programa irá ler apenas um linha de entrada, que consiste em uma lista de inteiros separados por espaço.

## Saída

Na saída, imprima o array a cada alteração. Seu programa deve parar assim que imprimir a sequência ordenada.

## Restrições

Seu programa deve, obrigatoriamente, utilizar recursão.

## Dica

Imprima o array com Arrays.toString(array).

## Exemplos de execução

	javac Solucao.java; java Solucao
	1 2 3 4 6 5 
	[1, 2, 3, 4, 6, 5]
	[1, 2, 3, 4, 6, 5]
	[1, 2, 3, 4, 6, 5]
	[1, 2, 3, 4, 6, 5]
	[1, 2, 3, 4, 5, 6]
	
	javac Solucao.java; java Solucao
	7 2 3 1 5
	[1, 2, 3, 7, 5]
	[1, 2, 3, 7, 5]
	[1, 2, 3, 7, 5]
	[1, 2, 3, 5, 7]