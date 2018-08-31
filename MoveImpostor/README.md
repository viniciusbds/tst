# Move impostor

Escreva um programa que encontra e move o impostor de uma lista de inteiros. O impostor é o primeiro número que quebra uma sequencia em ordem crescente. Por exemplo, na sequência:

	1 2 4 3 7 90
	
O impostor é o elemento 3.

Além de encontrar o impostor, você deve posiciona-lo em seu devido lugar. Para o exemplo acima, sua função deve alterar a lista para a seguinte: 1 2 3 4 7 90.

Importante! Só há um impostor. Como dito anteriormente, é o primeiro elemento que quebra uma sequência ordenada.

Veja outro exemplo:

	5 7 8 19 -4 4 1 6 8 12 81 3
	
	Nessa sequência, o impostor é o elemento -4. Após a execução do seu algoritmo, a lista deve
	ficar neste estado:
	
	-4 5 7 8 19 4 1 6 8 12 81 3

## Entrada

Seu programa deve ler uma sequência de inteiros separados por espaço.

## Saída

Deve imprimir a sequência depois de identificar o impostar e posiciona-lo corretamente.

## Exemplo

	javac Solution.java; java Solution
	5 7 8 19 -4 4 1 6 8 12 81 3
	[-4, 5, 7, 8, 19, 4, 1, 6, 8, 12, 81, 3]

## Dica

Utilize Arrays.toString()

## Funções que NÃO são permitidas

Seu programa deve apenas manipular o array de inteiros.

	- insert
	- remove
	- pop
	- qualquer função de ordenação