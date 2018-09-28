# Mariana e os livros

Mariana gosta muito de livros, tanto que tem uma larga coleção em suas estantes e sempre está adicionando novos livros nela. Depois de certo tempo ela percebeu que suas estantes estavam começando a ficar bagunçadas, com os livros fora de ordem, o que tornava a tarefa de achar um determinado livro muito complicada, pois ela não podia usar uma busca binária, mas isto é assunto de outro problema.

Pensando em facilitar sua vida na busca por livros, Mariana decidiu criar um robô que organizasse a sua estante, por ela ser uma menina muito ocupada e não ter tempo para fazer esta tarefa sempre. Na criação do robô ela decidiu usar o insertion sort como algoritmo de execução, mas não tem certeza se ele está funcionando como deveria.

Para verificar se o robô está de acordo com o algoritmo do insertion sort, ela anotou os estados parciais da estante em organização para verificar a execução do algoritmo, e agora precisa de um programa que dê os estados parciais de ordenação de uma determinada estante para que ela possa realizar essa verificação.

Você deve implementar um programa que dada uma entrada com os nomes dos livros que estão naquela estante, retorna os estados parciais (estado atual do array após a ordenação de cada elemento) de ordenação seguindo o algoritmo do insertion sort.

## Entrada

A primeira linha tem o nome de todos os n livros da estante separados por virgula. 0 < n < 20.

## Saída

Seu programa deve imprimir uma linha para cada estado parcial da aplicação do algoritmo sobre a estante, incluindo o estado inicial e final (estante devidamente organizada). A impressão de cada linha deve ser formatada separando os nomes dos livros por virgula e espaço ", ".

## Exemplo de execução

	$ javac Solution.java; java Solution
	Deuses Americanos,Lugar Nenhum,Sandman,Crimes ABC,Carrie,O Pequeno Principe,Sherlock,Neuromancer
	Deuses Americanos, Lugar Nenhum, Sandman, Crimes ABC, Carrie, O Pequeno Principe, Sherlock, Neuromancer
	Deuses Americanos, Lugar Nenhum, Sandman, Crimes ABC, Carrie, O Pequeno Principe, Sherlock, Neuromancer
	Deuses Americanos, Lugar Nenhum, Sandman, Crimes ABC, Carrie, O Pequeno Principe, Sherlock, Neuromancer
	Crimes ABC, Deuses Americanos, Lugar Nenhum, Sandman, Carrie, O Pequeno Principe, Sherlock, Neuromancer
	Carrie, Crimes ABC, Deuses Americanos, Lugar Nenhum, Sandman, O Pequeno Principe, Sherlock, Neuromancer
	Carrie, Crimes ABC, Deuses Americanos, Lugar Nenhum, O Pequeno Principe, Sandman, Sherlock, Neuromancer
	Carrie, Crimes ABC, Deuses Americanos, Lugar Nenhum, O Pequeno Principe, Sandman, Sherlock, Neuromancer
	Carrie, Crimes ABC, Deuses Americanos, Lugar Nenhum, Neuromancer, O Pequeno Principe, Sandman, Sherlock

## Restrições
Para comparação de Strings deve ser utilizado o método String#compareTo.