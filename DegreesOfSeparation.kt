import java.io.File
import java.io.BufferedReader

fun cargarDatos(file: File): Grafo<String>{
    val bufferedReader: BufferedReader = file.bufferedReader() 
    var linea: String? = bufferedReader.readLine()
    var Datos : Grafo<String> = ListaAdyacenciaGrafo()
    if(linea == null) return Datos
    var elementos: List<String> = linea.split("\\s+".toRegex())

    while (linea != null) {
        var elem1: String = elementos.get(0)
        var elem2: String = elementos.get(1)
        Datos.agregarVertice(elem1)
        Datos.agregarVertice(elem2)
        Datos.conectar(elem1, elem2)
	linea = bufferedReader.readLine()
	if(linea == null){
	    return Datos
	}
	elementos = linea.split("\\s+".toRegex()) 
	
    }
    return Datos
}
fun main(args: Array<String>){
    val file1: File = File(args[0]) 
    val entrada1: String = (args[1])
    val entrada2: String = (args[2])
    val grafoEntrada: Grafo<String> = cargarDatos(file1)
    if(!(grafoEntrada.contiene(entrada1)) || !(grafoEntrada.contiene(entrada2))){
        println("alguno de los nombres de la entrada, no está en el 'input.txt', intente de nuevo.")
    }
    else{
        val gradoDeSeparacion: Int = grafoEntrada.GradoDeSeparacion(entrada1, entrada2)
        println("${gradoDeSeparacion}")
    }
}
