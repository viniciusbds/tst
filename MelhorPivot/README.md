# Melhor Pivot

Depois de assistir as aulas sobre o QuickSort, você entendeu bem o conceito de "bom pivot" de uma sequência de inteiros, certo?

Baseado no que vimos em sala de aula, implemente um programa que, dado uma sequência de inteiros e as posições (i e j) de dois candidatos a particionar essa sequencia, determina qual é a melhor escolha de pivot (i ou j). Isto é, se seq[i] for uma melhor escolha de pivot, seu programa deve imprimir i. Caso contrário, deve imprimir j.

## Entrada

Seu programa deve ler 2 linhas. A primeira contém uma sequência de inteiros separados por espaço. A segunda contém i e j separados por espaço.

## Saída

Seu programa deve imprimir i se a melhor escolha de pivot para o quicksort for o elemento na posição i da sequência. Caso a melhor escolha seja j, seu programa deve imprimir j. Caso haja empate, imprima i.

## Restrições

A sequência não pode ser ordenada em momento algum. A solução deve ser O(n). Não é permitido utilizar qualquer coleção do Collections Framework. Você deve utilizar arrays.

## Exemplos de execução

	javac MinhaSolucao.java; java MinhaSolucao
	0 1 2 3 4 5 6 7 8 9 10
	4 10
	4


	javac MinhaSolucao.java; java MinhaSolucao
	5 1 7 3 9 10 2 4 3
	0 3
	0