# Tabelas Hash (resolução de conflitos com endereçamento aberto)

Devido à natureza das funções de hash que utilizamos na construção de Tabelas Hash, colisões são inevitáveis. Isto é, para algum par de objetos com chaves diferentes, existe a possibilidade de seus hashes serem iguais e, por consequência, esses objetos serão mapeados para a mesma posição da tabela.

Uma das maneiras de se resolver colisões é, caso o hash da chave seja mapeado para uma posição já ocupada, o algoritmo de inserção procura por uma outra posição livre para inserir o par . A essa estratégia, dá-se o nome de resolução de colisões por endereçamento aberto. Em particular, quando a tentativa é sempre verificar a próxima posição da tabela, diz-se que a estratégia utiliza um probing linear.

Implemente um programa que leia da entrada padrão operações em uma tabela hash e imprima o seu estado sempre que as operações put e remove forem efetuadas.

A tabela hash deve armazenar chaves inteiras e valores do tipo String e deve resolver colisões por endereçamento aberto e probing linear.

Sua tabela deve ter as seguintes funções:

	- put <chave> <valor>
	- remove <chave>
	- keys
	- values	
	
Importante! Para facilitar os testes, sua tabela sempre terá a seguinte função base de hash:

	hash(key) = key % M, onde M é o tamanho da tabela
	
Importante! Caso a tabela já esteja completamente cheia durante uma inserção, basta não adicionar o novo par. Contudo, mesmo que a operação não seja realizada, imprima o conteúdo da tabela.

Rehash será assunto para outra questão :)

## Entrada

Seu programa deve ler da entrada o tamanho da tabela e uma série de operações (put, remove, keys, e values).

- put: adiciona o par chave,valor na tabela
- remove: remove o par cuja chave é igual a chave passada como parâmetro
- keys: imprime em ordem as chaves da tabela. Você pode usar Arrays.sort para isso.
- values: imprime em ordem os valores da tabela. Você pode usar Arrays.sort para isso.
A leitura de operações deve ser encerrada com a palavra "end".

## Saída

Seu programa deve imprimir o conteúdo da tabela sempre após as operações put e remove forem efetuadas. Quando a operação keys ou values for lida, deve imprimir as chaves ou valores em ordem crescente.

## Restrições

	- Sua tabela deve ser baseada em arrays. 
	- A função de hash deve ser sempre a mesma (exceto pelo probing): key % M, 
	onde M é o tamanho da tabela.
	- Crie a classe TabelaHash para organizar o seu código. 
	- Crie uma classe Pair como abstração para chave e valor.
	Lembre-se: tst vai testar apenas a entrada e saída do seu programa. Isso significa que você deve construir o main que leia os dados da entrada padrão manipula a sua Fila e imprime o que se espera na saída.

## Exemplo de execução

	$ javac Solution.java; java Solution
	5
	put 0 joao
	[<0, joao>, null, null, null, null]
	put 4 leticia
	[<0, joao>, null, null, null, <4, leticia>]
	put 20 carlos
	[<0, joao>, <20, carlos>, null, null, <4, leticia>]
	put 0 pedro
	[<0, pedro>, <20, carlos>, null, null, <4, leticia>]
	remove 20
	[<0, pedro>, null, null, null, <4, leticia>]
	keys
	[0, 4]
	values
	[leticia, pedro]
	end