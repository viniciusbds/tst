# Troca Vizinhos

Escreva um programa que leia uma sequência de números inteiros e troca os elementos vizinhos. Se o tamanho da sequência for impar, troque os vizinhos e mantenha o último elemento em sua posição.

## Entrada

Seu programa irá ler uma sequência e armazená-la em um array de inteiros.

## Saída

Na saída, seu programa deve imprimir o array resultante da troca dos elementos vizinhos. Dica: use Arrays.toString() para formatar a saída.

## Exemplo de execução

	javac Solucao.java; java Solucao
	1 13 3 4 5
	[13, 1, 4, 3, 5]
	
	javac Solucao.java; java Solucao
	1 7
	[7, 1]

## Restrições

O algoritmo deve ser in-place. Ou seja, não é permitido utilizar qualquer outro array auxiliar para trocar os elementos.