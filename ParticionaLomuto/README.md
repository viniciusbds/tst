# Particionamento utilizando a estratégia de Lomuto

A estratégia de Lomuto para o particionamento é simples. Escolhe-se como o pivot o primeiro elemento e utiliza-se duas variáveis de controle: i, que representa a posição final do pivot e j que varre o array da posição 1 até o seu final. Sempre que o valor na posição j for menor que o valor do pivot, atualiza-se i e troca-se os valores das posições i e j. No fim, troca-se a posição do pivot com o valor na posição i.

Implemente um programa que leia da entrada padrão uma sequência de inteiros e particiona essa sequência utilizando a estratégia de Lomuto.

O particionamento deve ser feito seguindo duas restrições:

	- Todos os elementos à esquerda do pivot são menores ou iguais ao pivot.
	- Todos os elementos à direita são maiores que ele;

## Entrada

Seu programa deve uma linha contendo uma sequência de inteiros separados por espaço.

## Saída

Seu programa deve imprimir o estado do array a cada troca efetuada (mesmo quando se troca um elemento por ele mesmo). Além disso, deve imprimir o estado do array ao fim da execução.

Dica: Use Arrays.toString() para formatar a saída.

## Exemplos de execução

	javac MinhaSolucao.java; java MinhaSolucao
	4 11 -2 3 9 19 2
	[4, -2, 11, 3, 9, 19, 2]
	[4, -2, 3, 11, 9, 19, 2]
	[4, -2, 3, 2, 9, 19, 11]
	[2, -2, 3, 4, 9, 19, 11]
	[2, -2, 3, 4, 9, 19, 11]
	
	javac MinhaSolucao.java ; java MinhaSolucao
	9 1 2 3 7 11 -3
	[9, 1, 2, 3, 7, 11, -3]
	[9, 1, 2, 3, 7, 11, -3]
	[9, 1, 2, 3, 7, 11, -3]
	[9, 1, 2, 3, 7, 11, -3]
	[9, 1, 2, 3, 7, -3, 11]
	[-3, 1, 2, 3, 7, 9, 11]
	[-3, 1, 2, 3, 7, 9, 11]