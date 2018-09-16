# Particiona respeitando a ordem original

Implemente um programa que leia da entrada padrão uma sequência de inteiros e particiona essa sequência utilizando o primeiro elemento como pivot. O particionamento deve ser feito seguindo duas restrições:

	- Todos os elementos à esquerda do pivot são menores ou iguais ao pivot e todos os elementos à direita
	são maiores que ele;
	- O particionamento deve manter a ordem original dos elementos (exceto, naturalmente, o pivot).
	Isto é, os menores devem vir na mesma sequência em que estavam no array original. Da mesma maneira
	os maiores devem vir na mesma sequência em que estavam no array original.

## Entrada

Seu programa deve receber uma linha contendo uma sequência de inteiros separados por espaço.

## Saída

Seu programa deve imprimir a sequência particionada pelo primeiro elemento do array e repeitando a ordem original dos elementos.

Dica: Use Arrays.toString() para formatar a saída.

## Restrições

A sequência não pode ser ordenada em momento algum. Não é permitido utilizar qualquer coleção do Collections Framework. Você deve utilizar arrays.

## Exemplos de execução

	javac MinhaSolucao.java; java MinhaSolucao
	7 1 3 8 19 18 2
	[1, 3, 2, 7, 8, 19, 18]
	
Note que 1,3 e 2 respeitam a ordem da sequência original. O mesmo acontece com 8, 19 e 18.