# algoritmos-de-planificacion

Algoritmos a utilizar

-	Mecanismos con múltiples colas

		Hasta ahora, se evalúa cómo ordenar los procesos en la
		cola única de procesos listos
		Dar trato diferenciado a procesos con perfiles distintos es
		complicado
		. . . ¿Y si montamos distintas colas de procesos listos?
		Asignando determinado patrón de comportamiento a la
		migración de una cola a otra
		Dando un trato diferenciado a los procesos de distintas
		colas

		- Multilevel Feedback
		- Multitarea preventiva
		- Se crea no una, sino varias colas de procesos listos
		- Cada cola con un distinto nivel de prioridad, CP
		- El despachador toma el proceso al frente de la cola de
		más prioridad
		- Tras n ejecuciones, el proceso es degradado a CP+1
		- Favorece a los procesos cortos
		- Terminan su trabajo sin ser marcados como de prioridad
		inferior
		- El algoritmo es barato
		- Sólo hay que actualizar a un proceso a cada ejecución, y
		evaluar un número limitado de colas

-	Ronda (Round Robin)

		Busca dar buena respuesta tanto a procesos cortos como
		largos
		Requiere multitarea preventiva
		Ejecutamos cada proceso por un quantum
		Si no terminó su ejecución, se interrumpe y coloca de
		vuelta al final de la cola
		Los procesos nuevos se forman también al final de esta
		misma cola

		- Alta frecuencia de cambios de contexto
		- A pesar de que el algoritmo es simple, la sobrecarga
		administrativa (burocracia) es alta
		- Puede modificarse incrementando el quantum
		- Reduce la frecuencia de cambios de contexto
		- Para valores grandes de q, tiende a convertirse en FCFS

-	 ProcesacientoPorLotes
		- simulación de una unidad central de procesamiento y la ejecución de procesos por lotes

Bibliografia: http://sistop.gwolf.org/laminas/08_algoritmos_planif_proc.pdf

