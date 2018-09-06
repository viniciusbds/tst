# Busca Linear Recursiva

Implemente um programa que leia uma sequência de inteiros e um número N e verifica se N está na sequência lida. Seu programa deve fazer uma busca linear recursiva para resolver o problema.

## Entrada

Seu programa deve ler da entrada duas linhas: a primeira é linha contendo uma sequência de inteiros separados por espaço, enquanto a segunda é um número N a ser pesquisado na sequência.

## Saída

Seu programa deve imprimir o primeiro índice em que N aparece.

Caso não encontre N, deve imprimir -1.

## Exemplo de execução

	$ javac Solution.java; java Solution
	3 5 8 10 12 18 20
	99
	-1
	$
	
	
	$ javac Solution.java; java Solution
	3 5 8 10 12 18
	3
	0

## Restrições

Você não pode usar coleção ou método algum do Collections framework. Sua implementação deve ser baseada em arrays. Você deve usar recursão.