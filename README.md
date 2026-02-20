>Manuel González_21-10250

## Para ejecutar:

Primero debe existir un archivo .txt que contenga los nombres en pares de personas que son amigas entre si 
>**ej:**
    >Carlos Juan
    >Juan Ana
    >Pedro Ana 
Luego se tiene que hacer uso del makefile proporcionado, para hacerlo se utiliza CMD y se dirige a la carpeta en la que está descargado el archivo. Una vez se hace basta introduciendo "make" como comando en CMD. Una vez se compile el programa usando make, se debe usar el comando **"./runDegreesOfSeparation.sh.entrada.txt Nombre1 Nombre2"** donde **entrada.txt** es el .txt con los nombres, **Nombre1** es un nombre a buscar y **Nombre2** es el otro nombre a buscar
## Orden de las funciones nuevas:

| Función| Complejidad |Justificación  |  
|-------|--|----------------|
| agregarAlFinal | **O(1)** | Funcion de la clase camino, es orden lineal por el uso de tail  |
| obtenerFinal | **O(1)** | Funcion de la clase camino, es orden lineal por el uso de tail  |
| copiar | **O(n)** | Funcion de la clase camino, es orden n por que en un camino pueden estar todos los elementos, y se tienen que copiar todos |
| conectar | **O(n)** | Se modifica conectar de la implementación pasada de grafo, dado que solo ve los elementos correspondientes a los lados, no se tienen bucles anidados, por lo que, como todos los while a lo sumo son de n elementos, es O(n) |
| insertarLado | **O(n)** | Funcion auxiliar para conectar, como se tiene que solo hay un while, es O(n) |
| buscarNodoVer | **O(n)** | Funcion auxiliar para extraer el nodo, similar a contiene en esquema, por lo que es O(n)|
| GradoDeSeparacion | **O(n⁴)** | Función principal del programa, debido al uso de sets (que van por default a hash set) en uso debería estar cerca de O(n³), pero para el peor caso es O(n⁴) puesto que va por un while que ve todos los abiertos (solo puede haber n abiertos a lo sumo), un for que va por los sucesores O(n) y ver si efectivamente el sucesor pertenece a la lista de cerrados (solo puede haber hasta n cerrados) y un "Copiar" de la clase Camino que es O(n), realisticamente O(n⁴) no va a pasar, puesto que un arco no puede estar abierto y cerrado, y por que buscar para los hashset se O(1) promedio, por lo que en uso sería O(n³) o O(n²)|
| cargarDatos | **O(n x k)** | función para cargar los datos en el main, es O(n x k), puesto que se debe usar conectar (que es O(n)) k veces (siendo k la cantidad de líneas y n el número de personas únicas)  |
| main | **O(n⁴)** | Puesto que se hace uso de la función "GradoDeSeparacion" y dicha función es la de mayor orden, main queda con **O(n⁴)**|

## Para el diseño de la funciones:

Camino: Clase creada para seguir lo visto en las clases de teoría de algoritmos III. Se creo para que el programa sea más flexible pensando en que existe la probabilidad de que próximamente tengamos que implementar algo silimar. Para la implementación se usó el diseño de una lista doblemente enlazada circular con centinela, por lo que también se implementó el NodoCamino, para que se pueda realizar la implementación.

agregarAlFinal: Se replicó la implementación usada para el laboratorio de algoritmos II, usa centinelas para que la lista sea circular.

obtenerFinal: Se extrae el valor del tail, que es el último valor. similarmente se usó en el laboratorio de algoritmos II

copiar: Función creada por problemas causados por la asignación en iteraciones o recursiones. similarmente se usó en el laboratorio de algoritmos II
 
conectar: Se modificó conectar puesto que era lo único que evitaba que el grafo fuese no dirigido (la versión creada para el proyecto era dirigido), se recreó desde 0 puesto que en un intento de modificar la función fallido, arreglar errores era imposible por que se repetía el código varias veces, por lo que para evitar eso, se crearon funciones auxiliares que hagan más legible y fácil de editar en caso de error.

insertarLado: Se creo para facilitar el debuging de la función conectar, el diseño sigue la línea general del conectar anterior, pero retornando true o false dependiendo si se inserta o no, para saber luego si se creo una conexión o el termino a conectar ya existía.

buscarNodoVer: Para facilitar la lectura de conectar se crea esta función aparte. Si se debe seguir trabajando con grafos posiblemente será útil más adelante. Su diseño es idéntico a "contiene()" pero retorna el nodoVer asociado, en lugar de true o false.

GradoDeSeparación: Se siguió el esquema visto en las clases de teoría de Algoritmos III, en lugar de usar un esquema más optimo como el visto en el laboratorio. Se usó la clase Camino para saber que camino es el más óptimo. Esta implementación fue usada para ser fiel a la clase de teoría y para facilitar trabajo en caso de que se pida algo similar en próximos laboratorios / proyectos. Adicionalmente se usó "sets" para cerrados puesto que el orden de búsqueda para hash sets en kotlin es de O(1). Finalmente para el retorno no se añade el último término para que solo se tenga que regresar el tamaño usando ".size" se los caminos, de lo contrario se tendría que hacer ".size -1". Adicionalmente retorna -1 si el programa falla por algún motivo

cargarDatos: Se usó el esquema visto en el laboratorio de algoritmos II, por lo que se importan java.io.File y java.io.BufferedReader para poder tener archivos y leer líneas. Al cargar los datos se añaden los nombres a pares y se conectan entre sí, si ya estaba el nombre antes, ya agregarVertice se encargaría de no añadirlo.

main: El main depende del formato de entrada, por eso se solicita que la entrada sea "entrada.txt Nombre1 Nombre2" sin comas y con espacios separando. Solo se usa la función cargar datos en el txt proporcionado para crear el grafo y se usa la función de gradosDeSeparaciñon en el grafo creado para tener el int que imprimir. Adicionalmente se añade un if para ver si los nombres proporcionados existen en la lista del .txt, de no ser así imprime un mensaje de error.
