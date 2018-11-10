# Balance em Árvores Binárias de Pesquisa

Balance de um nó em uma BST é a diferença entre a altura da sub-árvore à esquerda e a altura da sub-árvore à direita. Escreva um programa que leia números inteiros a serem adicionados em uma BST e imprima o encaminhamento em pré-ordem dos nós juntamente com os seus respectivos balances.

## Entrada

Seu programa deve ler uma linha contendo os números a serem adicionados (em sequência) na árvore.

Você pode assumir que não haverá elementos repetidos na árvore.

## Saída

Seu programa deve imprimir o encaminhamento em pré-ordem e os respectivos balances dos nós.

## Exemplos de execução

	$ javac Solution.java; java Solution
	100 200 210 90 95 70 1
	100,1 90,1 70,1 1,0 95,0 200,-1 210,0