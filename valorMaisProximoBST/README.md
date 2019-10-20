# Valor mais próximo de N em uma árvore binária de pesquisa

Escreva um programa que leia os números a serem adicionados em uma BST e um número N sobre o qual se deseja encontrar o valor mais próximo a ele presente na árvore.

## Restrições
- Não é permitido procurar por sucessor ou predecessor. Ainda que fosse, N 
não precisa ser um valor presente na árvore.
- A implementação deve ser O(h). Isto é, você não pode percorrer
toda a árvore para encontrar o elemento.
Entrada
Seu programa deve ler duas linhas da entrada. A primeira linha irá conter (em ordem) os elementos que devem ser adicionados à árvore. A segunda irá conter um valor N (não necessariamente presente na árvore).

Seu programa deve encontrar na árvore o valor mais próximo de N.

Você pode assumir que não haverá elementos repetidos na árvore. Você pode assumir que não haverá empate dois valores.

## Saída
Inicialmente, seu programa deve imprimir o encaminhamento em pré-ordem da árvore lida. Depois, deve imprimir o valor mais próximo a N presente na árvore. Veja os exemplos de execução abaixo.

## Exemplos de execução

      $ javac Solution.java; java Solution
      10 8 1 9 20 18 25
      23
      [10, 8, 1, 9, 20, 18, 25]
      25

      $ javac Solution.java; java Solution
      10 8 1 9 20 18 25
      17
      [10, 8, 1, 9, 20, 18, 25]
      18
