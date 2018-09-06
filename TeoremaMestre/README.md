# Teorema mestre

Escreva um programa que, dada uma relação de recorrência, aplica o teorema mestre para determinar a sua classe assintótica.

O teorema mestre pode ser aplicado em funções no seguinte formato:

T(n) = a '*' T(n/b) + theta(n'**'ord)
, onde a é a quantidade de chamadas recursivas, b é o tamanho de cada subproblema e ord é a ordem da função somada a cada passo recursivo.

## Entrada

Seu programa recebe 3 valores inteiros constítuidos por a, b e ord.

## Saída

Seu programa deve aplicar as regras do teorema mestre e imprimir o theta da relação de recorrência.

## Exemplos de execução

	javac Solucao.java; java Solucao
	4 2 3
	T(n) = theta(n**3)
	
	javac Solucao.java; java Solucao
	9 3 2
	T(n) = theta(n**2 * log n)
	
	javac Solucao.java; java Solucao
	3 3 1
	T(n) = theta(n**1 * log n)