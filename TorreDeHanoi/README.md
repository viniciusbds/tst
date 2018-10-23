# Torre de Hanoi

Torre de Hanoi é um jogo estratégico que possui 3 hastes/pinos verticais (A, B e C) que funcionam como pilhas.

No primeiro pino (A) temos discos ordenados de forma crescente de diâmetro (o menor no topo). O objetivo do jogo é passar esses discos para o último pino (C) com o auxílio do pino central (B).

Contudo o jogo apresenta algumas restrições quanto aos movimentos:

	- apenas um disco pode ser movido por vez;
	- apenas o disco do topo de cada pino pode ser escolhido para ser movido (i. e, pilha);
	- um disco de diâmetro maior nunca pode ficar acima de um disco de diâmetro menor.

## Entrada

Seu programa deve ler apenas a quantidade de discos no primeiro pino.

## Saída

Seu programa deve exibir cada movimento dos discos, incluindo origem e destino do disco.

## Exemplo de execução

    $ javac Solution.java; java Solution
    2
    Move o disco 1 da haste A para a haste B
    Move o disco 2 da haste A para a haste C
    Move o disco 1 da haste B para a haste C