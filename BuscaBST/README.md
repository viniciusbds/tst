# Busca em Árvores Binárias de Pesquisa

Escreva um programa que leia os números a serem adicionados em uma BST e um número a ser procurado nessa árvore. Seu programa deve imprimir o caminho realizado até encontrar o elemento.

## Entrada

Seu programa deve ler duas linhas da entrada. A primeira linha irá conter (em ordem) os elementos que devem ser adicionados à árvore. A segunda irá conter o elemento a ser procurado.

Você pode assumir que não haverá elementos repetidos na árvore.

## Saída

Seu programa deve imprimir o caminho realizado até encontrar o elemento. Caso não encontre, deve imprimir o caminho até a última folha visitada.

## Exemplos de execução

	$ javac Solution.java; java Solution
	10 8 1 9 20 18 25
	1
	[10, 8, 1]
	
	$ javac Solution.java; java Solution
	10 8 1 9 20 18 25
	16
	[10, 20, 18]