# Sucessor BST

O sucessor de um valor em uma BST é, dentre os valores maiores do que ele presentes na árvores, o menor. Implemente um programa que imprima o caminho percorrido até encontrar o sucessor de um valor lido da entrada padrão.

## Entrada

Seu programa deve ler duas linhas da entrada padrão. A primeira linha irá conter (em ordem) os elementos que devem ser adicionados à árvore. A segunda linha contém o valor cujo sucessor deverá ser impresso.

Você pode assumir que não haverá elementos repetidos na árvore. Você pode assumir que o valor existe na árvore, mas não pode assumir que existe um sucessor para ele.

## Saída

Seu programa deve imprimir o caminho percorrido até encontrar o sucessor. Se não houver sucessor, imprima o caminho até o último nó visitado.

## Exemplo de execução

	$ javac Solution.java; java Solution
	10 8 1 9 20 18 25
	10
	[10, 20, 18]
	
	$ javac Solution.java; java Solution
	10 8 1 9 20 18 25
	25
	[25, 20, 10]