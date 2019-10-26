# Encaminhamento em Largura da direita para a esquerda (BFS)

Há diversas formas de se percorrer uma árvore binária de pesquisa. Breadth-first search (BFS) ou Encaminhamento em Largura é uma forma de visitar um grafo em largura. Para árvores binárias de pesquisa isso significa que os nós serão visitados por níveis (da esquerda para a direita em cada nível).

Escreva um programa que leia os números a serem adicionados em uma BST e imprima o resultado do encaminhamento por largura nessa árvore. Contudo, os nós nos níveis devem ser impressos da direita para a esquerda.

## Entrada

Seu programa deve ler apenas uma linha da entrada. Essa linha irá conter (em ordem) os elementos que devem ser adicionados à árvore.

Você pode assumir que não haverá elementos repetidos na árvore.

## Saída

Seu programa deve imprimir o resultado do encaminhamento em largura da direita para a esquerda na árvore lida.

## Exemplo de execução

    $ javac Solution.java; java Solution
    10 8 1 9 20 18 25
    10 20 8 25 18 9 1
