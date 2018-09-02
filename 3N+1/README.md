# 3N + 1

Considere a seguinte estratégia para gerar uma sequência de números a partir de um número inteiro N:

	- Se N for par, divida por 2.
	- Caso N seja ímpar, multiplique por 3 e some 1.
	- Substitua N pelo número gerado e repita esse processo até que o número gerado seja 1.

Por exemplo, para N = 22, temos a seguinte sequência gerada: - 22 11 34 17 52 26 13 40 20 10 5 16 8 4 2 1

Obs.: Esse é um problema clássico de programação. É material de vários livros que abordam o assunto. Portanto, não é de autoria dos professores responsáveis pelo tst.

Conjectura-se (não há prova ainda) que para qualquer inteiro, a sequência sempre acabe em 1. Contudo, sabe-se que para qualquer inteiro entre 1 e 1.000.000 isso seja verdadeiro.

## Entrada

Seu programa deve ler da entrada dois inteiros (um por linha) i e j, ambos menores que 1.000.000.

## Saída

Na saída, você deve imprimir apenas o tamanho da maior sequência gerada pelos números entre i e j (incluindo ambos).

## Exemplo de execução

	$ javac Solution.java; java Solution
	2
	6
	9