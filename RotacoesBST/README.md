# Rotações em Árvores Binárias de Pesquisa

Escreva um programa que leia três números a serem adicionados em uma BST e aplique a(s) rotação(ões) necessária(s) para balancear a árvore.

## Entrada

Seu programa deve ler uma linha contendo os três números a serem adicionados (em sequência) na árvore.

Você pode assumir que não haverá elementos repetidos na árvore.

## Saída

Seu programa deve imprimir a(s) rotação(ões) realizada(s) na árvore e o encaminhamento em pré-ordem a cada rotação. Se nenhuma rotação for necessária, apenas imprima balanceada

## Exemplos de execução

	$ javac Solution.java; java Solution
	10 8 1
	rot_dir(10)
	[8, 1, 10]
	
	$ javac Solution.java; java Solution
	10 8 9
	rot_esq(8)
	[10, 9, 8]
	rot_dir(10)
	[9, 8, 10]
	
	$ javac Solution.java; java Solution
	10 8 12
	balanceada