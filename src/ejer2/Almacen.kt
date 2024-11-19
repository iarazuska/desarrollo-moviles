package ejer2

class Almacen {
    private val estanteria = Array(5) { Array<Bebidas?>(5) { null } }
    private val bebidas = mutableListOf<Bebidas>()

    //agregamos bebidas
    fun agregarBebida(bebida: Bebidas) {
        //ver si existe este id
        var yaExiste=false
        for(b in bebidas){
            if(b.id==bebida.id){
                yaExiste=true
                break
            }
        }
        if (yaExiste){
            print("ya exixte")
        }else{
            //ver si hay sitio
            var sitio=false
            for(i in 0 until 5){
                for(j in 0 until 5){
                    if (estanteria[i][j]==null){
                        //si hay sitio lo colocamos
                        estanteria[i][j]=bebida
                        bebidas.add(bebida)
                        println("bebida colocada en [$i][$j]")
                        sitio=true
                        break
                    }
                }
                if (sitio)break
            }
            if (!sitio){
                println("todo ocupado")
            }
        }
    }

    //eliminar bebida por id
    fun eliminarBebida(id: Int) {
        var tenemosBebida: Bebidas? = null
        // buscamos la bebida
        for (bebida in bebidas) {
            if (bebida.id == id) {
                tenemosBebida = bebida
                break
            }
        }

        if (tenemosBebida != null) {
            //si hay la quitamos
            bebidas.remove(tenemosBebida)
            // y tambien la quitamos de la estanteria
            for (i in 0 until 5) {
                for (j in 0 until 5) {
                    if (estanteria[i][j]?.id == id) {
                        estanteria[i][j] = null
                        println("bebida quitada de la estantería")
                        return
                    }
                }
            }
        } else {
            println("no hayuna bebida con ese ID")
        }
    }

    //ver que bebidas hay
    fun verBebidas() {
        println("lista")
        for (bebida in bebidas) {
            //mira que bebida es y te pone los datos
            if (bebida is AguaMineral) {
                println("Agua Mineral - ID: ${bebida.id}, Marca: ${bebida.marca}, Litros: ${bebida.litros}, Precio: $${bebida.precio}, Origen: ${bebida.origen}")
            } else if (bebida is BebidasAzucaradas) {
                println("Bebida Azucarada - ID: ${bebida.id}, Marca: ${bebida.marca}, Litros: ${bebida.litros}, Precio: $${bebida.precio}, Azúcar: ${bebida.azucar}g, Promoción: ${bebida.promocion}")
            }
        }
    }

    //precio de total
    fun precioTotal(): Double {
        var total = 0.0
        for (bebida in bebidas) {
            if (bebida is BebidasAzucaradas && bebida.promocion) {
                // si esta en promocion restamos el descuento
                total += bebida.precio * 0.9
            } else {
                total += bebida.precio
            }
        }
        return total
    }

    //precio por marca
    fun precioMarca(marca: String): Double {
        var total = 0.0
        for (bebida in bebidas) {
            if (bebida.marca == marca) {
                if (bebida is BebidasAzucaradas && bebida.promocion) {
                    // si esta en promocion restamos el descuento
                    total += bebida.precio * 0.9
                } else {
                    total += bebida.precio
                }
            }
        }
        return total
    }

    //precio por columna
    fun precioColumna(columna: Int): Double {
        var total = 0.0
        for (i in 0 until 5) {
            val bebida = estanteria[i][columna]
            if (bebida != null) {
                if (bebida is BebidasAzucaradas && bebida.promocion) {
                    // si esta en promocion restamos el descuento
                    total += bebida.precio * 0.9
                } else {
                    total += bebida.precio
                }
            }
        }
        return total
    }
}