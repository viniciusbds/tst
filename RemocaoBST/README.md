# Remoção em Árvores Binárias de Pesquisa

Escreva um programa que leia os números a serem adicionados em uma BST e os números a serem removidos (em sequência) dessa árvore. Seu programa deve imprimir o estado da árvore (pré-ordem) a cada remoção.

Importante! A remoção de um nó com dois filhos deve sempre ser realizada utilizando o sucessor do nó a ser removido.

## Entrada

Seu programa deve ler duas linhas da entrada. A primeira linha irá conter (em ordem) os elementos que devem ser adicionados à árvore. A segunda irá conter os elementos a serem removidos da árvore. É importante destacar que os elementos devem ser removidos em sequencia, isto é, remove-se o primeiro elemento da árvore original e, da árvore resultante, remove-se o segundo e assim por diante.

Você pode assumir que não haverá elementos repetidos na árvore.

Você não pode assumir que os elementos a serem removidos estarão na árvore. A cada tentativa de remoção de um elemento que não estiver na árvore, apenas imprima em pré-ordem o conteúdo da árvore.

## Saída

Seu programa deve imprimir o encaminhamento em pré-ordem a cada remoção (ou tentativa de remoção). Se a árvore ficar vazia após a remoção, imprima null.

## Exemplos de execução
	
	$ javac Solution.java; java Solution
	10 8 1 9 20 18 25
	18 20 10
	[10, 8, 1, 9, 20, 25]
	[10, 8, 1, 9, 25]
	[25, 8, 1, 9]
	
	$ javac Solution.java; java Solution
	1 2 3 4 5
	5 4 3 2 1
	[1, 2, 3, 4]
	[1, 2, 3]
	[1, 2]
	[1]
	null