class Camino<T>{
    var centinela: NodoCamino<T> = NodoCamino(valor = null, siguiente = null, anterior= null)
    init{
        centinela.anterior = centinela
        centinela.siguiente = centinela
    }
    var head: NodoCamino<T> = centinela 
    var tail: NodoCamino<T> = centinela  
    var size: Int = 0

    fun agregarAlFinal(x: T){
        var Nanterior = centinela.anterior
        val nuevo = NodoCamino(valor = x, siguiente = centinela, anterior = Nanterior)
        centinela.anterior = nuevo
        Nanterior?.siguiente = nuevo
        size = size + 1 
        tail = nuevo
        if(centinela.siguiente == tail){
            head = nuevo
        }
    }
    fun obtenerFinal():T?{
        return tail.valor
    }
    
    fun copiar(): Camino<T> {
        val nuevoCamino = Camino<T>()
        var nodoActual = centinela.siguiente
        while (nodoActual != centinela && nodoActual != null) {
            nuevoCamino.agregarAlFinal(nodoActual.valor!!)
            nodoActual = nodoActual.siguiente
        }
    
        return nuevoCamino
    }

}
