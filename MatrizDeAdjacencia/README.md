# Matriz de adjacência

Matriz de adjacência é uma forma matemática de representar grafos. Para um grafo qualquer com N vértices, constrói-se uma matriz NXN onde o valor de M[i][j] representa o peso da aresta entre os vértices representados pela linha i e coluna j. Por exemplo, para um grafo não dirigido representando pela figura abaixo temos a seguinte matriz de adjacência:

![Grafo](https://github.com/Viniciuswps/tst-eda/edit/master/MatrizDeAdjacencia/grafo_nao_dirigido.png)

      a b c d e f g
    a 0 8 0 8 0 0 0
    b 8 0 5 8 0 3 0
    c 0 5 0 0 0 4 2
    d 8 8 0 0 3 3 0
    e 0 0 0 3 0 1 0
    f 0 3 4 3 1 0 5
    g 0 0 2 0 0 5 0

Como podemos perceber, o uso de memória de uma matriz de adjacência não é otimizado principalmente por dois motivos:
	
	- 1) Há repetição de informação. Por exemplo, as arestas entre cada
	par de nó estão duplicadas sem necessidade, pois o grafo não é dirigido.
	Por exemplo, a aresta entre `a` e `b` está representada na matriz na primeira
	linha e segunda coluna e na segunda linha e primeira coluna.
	
	- 2) Pelo fato da matriz ser quadrada, é preciso reservar espaço
	para todas as possíveis arestas entre nós, mesmo que elas não existam.
	Por exemplo, a aresta entre `b` e `g` não existe, mas ainda sim é preciso
	reservar esse espaço na matriz. Para um grafo com muitos nós e pouco
	conectado, o desperdício de memória é considerável.
	
Uma maneira de melhorar o uso de memória é utilizar uma tabela hash para armazenar a representação do grafo. Nessa tabela, as chaves são as arestas existentes (e. g. ab) e os valores são os pesos dessas respectivas arestas (e. g. 8, para ab). Assim, você só precisa armazenar as arestas existentes. Além disso, se você armazenou a aresta ab, isso significa que não precisa armazenar a aresta ba, embora ela exista, uma vez que o grafo não é dirigido.

Implemente um programa que leia os nós de um grafo e sua respectiva matriz de adjacência e represente esse grafo em uma tabela hash. Seu programa de ser capaz de receber pesquisa sobre uma determinada aresta e imprimir seu peso ou sua inexistência.

## Entrada

Seu programa deve ler da entrada padrão uma linha contendo os N nós presentes no grafo e depois uma sequência de N linhas representando a matriz de adjacência.

Depois disso, seu programa deve ler uma sequência de pesquisas por arestas. A leitura deve terminar quando a palavra fim for lida.

## Saída

Seu programa deve imprimir o peso de cada aresta procurada ou aresta inexistente. caso a aresta não esteja presente no grafo.

## Exemplo de execução

	$ javac Solution.java; java Solution
	a b c d e f g
	0 8 0 8 0 0 0
	8 0 5 8 0 3 0
	0 5 0 0 0 4 2
	8 8 0 0 3 3 0
	0 0 0 3 0 1 0
	0 3 4 3 1 0 5
	0 0 2 0 0 5 0
	ab
	8
	ba
	8
	ac
	aresta inexistente.
	df
	3
	op
	aresta inexistente.
	fim