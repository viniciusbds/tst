# Estatística de ordem

A i-ésima estatística de ordem de uma sequência de inteiros é o i-ésimo menor elemento dessa sequência. Por exemplo, na sequência [4,5,9,1,2,6,8], o número 4 é a terceira estatística de ordem, pois 4 é o terceiro menor número.

Escreva um programa que imprime qual a estatística de ordem do primeiro elemento de uma sequência. Embora os testes apenas verifiquem se o seu programa imprime a estatística de ordem do primeiro elemento, ao final da execução do seu algoritmo, o primeiro elemento deve dividir a sequência tal que os elementos menores que ele estão à sua esquerda e os elementos maiores que ele estão à sua direita.

Assuma que a sequência não possui elementos repetidos.

## Exemplos de execução

	javac Solution.java ; java Solution
	4 5 9 1 2 6 8
	3
	
	javac Solution.java ; java Solution
	6 2 1 9 3
	4
	
## Restrições

Não é permitido ordenar o array. Não é permitido usar coleções auxiliares.