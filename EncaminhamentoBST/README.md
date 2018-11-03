# Encaminhamento em Árvores Binárias de Pesquisa

Há diversas formas de se percorrer uma árvore binária de pesquisa. Dentre elas, algumas ganham destaque: pré-ordem, em-ordem e pós-ordem.

Escreva um programa que leia os números a serem adicionados e imprima na saída o resultado de cada um desses algoritmos de encaminhamento.

Para isso, naturalmente, você terá que implementar o algoritmo de inserção em árvores binárias de pesquisa.

*Dica: * sugiro que você guarde a sua implementação do método de inserção para futuras questões relacionadas à árvores binárias de pesquisa.

## Entrada

Seu programa deve ler apenas uma linha da entrada. Essa linha irá conter (em ordem) os elementos que devem ser adicionados à árvore.

Você pode assumir que não haverá elementos repetidos na árvore.

## Saída

Seu programa deve imprimir 3 linhas na saída. Cada linha é o resultado do encaminhamento em pré-ordem, em-ordem e pós-ordem, respectivamente.

## Exemplo de execução

	$ javac Solution.java; java Solution
	10 8 1 9 20 18 25
	[10, 8, 1, 9, 20, 18, 25]
	[1, 8, 9, 10, 18, 20, 25]
	[1, 9, 8, 18, 25, 20, 10]