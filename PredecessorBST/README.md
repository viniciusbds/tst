# Predecessor BST

O predecessor de um valor em uma BST é, dentre os valores menores do que ele presentes na árvores, o maior. Implemente um programa que imprima o caminho percorrido até encontrar o predecessor de um valor lido da entrada padrão.

## Entrada

Seu programa deve ler duas linhas da entrada padrão. A primeira linha irá conter (em ordem) os elementos que devem ser adicionados à árvore. A segunda linha contém o valor cujo predecessor deverá ser impresso.

Você pode assumir que não haverá elementos repetidos na árvore. Você pode assumir que o valor existe na árvore, mas não pode assumir que existe um predecessor para ele.

## Saída

Seu programa deve imprimir o caminho percorrido até encontrar o predecessor. Se não houver sucessor, imprima o caminho até o último nó visitado.

## Exemplo de execução

	$ javac Solution.java; java Solution
	10 8 1 9 20 18 25
	10
	[10, 8, 9]
	
	$ javac Solution.java; java Solution
	10 8 1 9 20 18 25
	25
	[25, 20]