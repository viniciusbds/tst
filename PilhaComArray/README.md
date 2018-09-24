# Pilha com Array

Implemente uma pilha com capacidade limitada utilizando array.

## Entrada

Seu programa deve ler da entrada o tamanho da pilha e uma série de operações (pop, push, peek e print). A leitura de operações deve ser encerrada com a palavra "end".

## Saída

Seu programa deve imprimir o conteúdo da pilha sempre que uma operação print for lida. Se a pilha estiver vazia, imprima "empty".

Seu programa deve imprimir o elemento no topo da pilha quando ler a operação peek.

Se a pilha estiver vazia e for lida a operação pop, imprima "empty".

Se a pilha estiver cheia e for lida a operação push, imprima "full".

## Exemplo de execução

	$ javac Solution.java; java Solution
	3
	print
	empty
	push 2
	peek
	2
	push 5
	peek
	5
	print
	2 5 
	pop
	print
	2 
	push 11
	push 18
	push 20
	full
	print
	2 11 18
	pop
	pop
	pop
	pop
	empty
	end

## Restrições e Observações

Você não pode usar coleção ou método algum do Collections framework. Sua implementação deve ser baseada em arrays.

Dica: Crie a classe Pilha para organizar o seu código. Contudo, lembre-se que não pode haver outra classe no seu arquivo. Por isso, o seu main deve estar nessa classe.

Lembre-se: tst vai testar apenas a entrada e saída do seu programa. Isso significa que você deve construir o main que leia os dados da entrada padrão manipula a sua pilha e imprime o que se espera na saída.