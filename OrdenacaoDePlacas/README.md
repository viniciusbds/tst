# Ordenação de Placas

O DETRAN (Departamento de Trânsito) precisa manter registro das multas aplicadas a carros que passam por sinais vermelhos, fazendo a identificação através de sua placa única. Um dos funcionários do DETRAN sugeriu que fosse implementado um programa para se ordenar as placas dos carros apenas pelos números, pois ele estava realizando um estudo para identificar a relação entre a posição de um número na placa e a ocorrência de multas.

Você deve escrever um programa que recebe de entrada as placas de carros, no formato AAA-9999, e que dá como saída um array com as placas ordenadas apenas por seus números, em ordem crescente e estável. Como estamos falando de um grande número de placas, sua solução precisa ser linear no que diz respeito ao tempo de execução.

## Entrada

Serão dadas n placas separadas por vírgula, no formato AAA-9999.

## Saída

Seu programa deve imprimir as placas ordenadas por sua numeração de forma crescente, estável e separadas por vírgula e espaço.

## Exemplo de execução

	$ javac Solution.java; java Solution 		
	
	JCB-8599,NEH-6731,IKZ-8333,MVW-9463,MWW-3683,MWD-3386,MUB-3143,LWJ-5599,HQZ-7220 

	MUB-3143, MWD-3386, MWW-3683, LWJ-5599, NEH-6731, HQZ-7220, IKZ-8333, JCB-8599, MVW-9463
	
	$ javac Solution.java; java Solution 
	
	NEH-6731,IKZ-8333,HQZ-7220,JCB-8333 
	
	NEH-6731, HQZ-7220, IKZ-8333, JCB-8333

## Restrições

Você deve utilizar o algoritmo de radix sort.