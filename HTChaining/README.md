# Tabelas Hash (resolução de conflitos com chaining)

Devido à natureza das funções de hash que utilizamos na construção de Tabelas Hash, colisões são inevitáveis. Isto é, para algum par de objetos com chaves diferentes, existe a possibilidade de seus hashes serem iguais e, por consequência, esses objetos serão mapeados para a mesma posição da tabela.

Uma das maneiras de se resolver colisões é, ao invés de armazenar o par em uma posição da tabela, armazenar uma fila contendo todos os pares que forem mapeados para aquela posição.

Implemente um programa que leia da entrada padrão operações em uma tabela hash e imprima o seu estado sempre que as operações put e remove forem efetuadas.

A tabela hash deve armazenar chaves inteiras e valores do tipo String e deve resolver colisões por chaining.

Sua tabela deve ter as seguintes funções:

	- put <chave> <valor>
	- remove <chave>
	- keys
	- values
	
Importante! Para facilitar os testes, sua tabela sempre terá a seguinte função de hash:

	hash(key) = key % M, onde M é o tamanho da tabela

## Entrada

Seu programa deve ler da entrada o tamanho da tabela e uma série de operações (put, remove, keys, e values).

	- put: adiciona o par chave,valor na tabela
	- remove: remove o par cuja chave é igual a chave passada como parâmetro
	- keys: imprime em ordem as chaves da tabela. Você pode usar Arrays.sort para isso.
	- values: imprime em ordem os valores da tabela. Você pode usar Arrays.sort para isso.
	
A leitura de operações deve ser encerrada com a palavra "end".

## Saída

Quando a operação keys ou values for lida, deve imprimir as chaves ou valores em ordem crescente.

Sempre que seu programa ler as operações put e remove, ele deve imprimir o estado da tabela após a execução dessas operações.

## Restrições

	- Sua tabela deve ser baseada em arrays. Contudo, as listas dentro da tabela devem ser do tipo ArrayList.
	- A função de hash deve ser sempre a mesma: key % M, onde M é o tamanho da tabela.
	- Crie a classe TabelaHash para organizar o seu código. 
	- Crie uma classe Pair como abstração para chave e valor.

## Exemplo de execução

	$ javac Solution.java; java Solution
	5
	keys
	[]
	values
	[]
	put 10 joao
	[[<10, joao>], [], [], [], []]
	keys
	[10]
	values
	[joao]
	put 1 carlos
	[[<10, joao>], [<1, carlos>], [], [], []]
	put 11 pedro
	[[<10, joao>], [<1, carlos>, <11, pedro>], [], [], []]
	put 14 liu
	[[<10, joao>], [<1, carlos>, <11, pedro>], [], [], [<14, liu>]]
	remove 10
	[[], [<1, carlos>, <11, pedro>], [], [], [<14, liu>]]
	put 1 leticia
	[[], [<1, leticia>, <11, pedro>], [], [], [<14, liu>]]
	keys
	[1, 11, 14]
	values
	[leticia, liu, pedro]
	end