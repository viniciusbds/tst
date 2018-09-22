# Particionamento utilizando a estratégia de Hoare

A estratégia que Hoare (descrita no Cormen) sugere para o particionamento de um array é um pouco diferente e certamente mais eficiente que a de Lomuto, pois efetua menos trocas.

Implemente essa estratégia de particionamento como descrita no Cormen.

Dica: Consulte o Cormen ou a wikipedia para uma referência de como implementar esse tipo de particionamento.

## Entrada

Seu programa deve uma linha contendo uma sequência de inteiros separados por espaço.

## Saída

Seu programa deve imprimir o estado do array ao executar uma vez o particionamento de Hoare.

Dica: Use Arrays.toString() para formatar a saída.

## Exemplos de execução

	javac MinhaSolucao.java; java MinhaSolucao
	4 11 -2 3 9 19 2
	[2, 3, -2, 11, 9, 19, 4]
	
	javac MinhaSolucao.java ; java MinhaSolucao
	9 1 2 3 7 11 -3
	[-3, 1, 2, 3, 7, 11, 9]