# Counting sort passo a passo

Ordene um array de inteiros cujos valores estão no intervalo [0..k] utilizando o Counting Sort.

## Entrada

Seu programa deve ler da entrada duas linhas: uma contendo uma sequência de inteiros separados por espaço e outra contendo k (o maior elemento do array).

## Saída

Seu programa deve imprimir o status do vetor de contagem em diversos momentos: - i) imprimir o conteúdo do array de contagem a cada modificação feita nele durante o cálculo da frequência; - ii) imprimir uma frase 'Cumulativa do vetor de contagem - ' seguida do vetor de contagem já tendo armazenado a cumulativa. - iii) imprimir o vetor de contagem ao fim da execução do algoritmo; - iv) imprimir a sequência ordenada.

## Observações e Restrições

Bem-vindo ao mundo real. Aqui os arrays começam na posição 0. Isso significa que o seu vetor de contagem deve ter k + 1 elementos. Você não pode usar coleção (ArrayList, LinkedList etc) ou método algum do Collections framework (Arrays.sort, por exemplo). Sua implementação deve ser baseada em arrays.

## Exemplos de execução

	$ javac Solution.java; java Solution
	3 1 1 6 4 7
	7
	0 0 0 1 0 0 0 0
	0 1 0 1 0 0 0 0
	0 2 0 1 0 0 0 0
	0 2 0 1 0 0 1 0
	0 2 0 1 1 0 1 0
	0 2 0 1 1 0 1 1
	Cumulativa do vetor de contagem - 0 2 2 3 4 4 5 6
	0 0 2 2 3 4 4 5
	1 1 3 4 6 7
	$
	
	$ javac Solution.java; java Solution
	2 2 4 3 2 1 5
	5
	0 0 1 0 0 0
	0 0 2 0 0 0
	0 0 2 0 1 0
	0 0 2 1 1 0
	0 0 3 1 1 0
	0 1 3 1 1 0
	0 1 3 1 1 1
	Cumulativa do vetor de contagem - 0 0 1 4 5 6
	0 0 1 4 5 6
	1 2 2 2 3 4 5
	$