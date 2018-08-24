# Dois somam

Escreva um programa que leia uma sequência não-ordenada de inteiros e um número inteiro, e retorne se há dois números presentes no array que somem ao número dado.

## Entrada

Seu programa irá ler duas linhas da entrada: a primeira linha que consiste em uma lista de inteiros separados por espaço e a segunda linha consiste na soma a ser considerada.

## Saída

Na saída, seu programa deve imprimir os dois números da sequência cuja soma é igual a soma lida da entrada padrão ou -1 caso contrário. Considere que, se houver um par de elementos cuja soma é a esperada, esse par é único.

## Exemplo de execução

	javac Solucao.java; java Solucao
	1 3 2 5
	6
	1 5
	
	javac Solucao.java; java Solucao
	2 3 5 0 1
	4
	3 1
	
	javac Solucao.java; java Solucao
	1 5 2 3 5
	11
	-1