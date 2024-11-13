package ejer2

class Almacen {
    private val estanteria = Array(5) { Array<Bebidas?>(5) { null } }
    private val bebidas = mutableListOf<Bebidas>()

    fun agregarBebida(bebida: Bebidas) {
        if (bebidas.any { it.id == bebida.id }) {
            println("ese id ya exixte ")
        } else {
            //busca sitio vacio
            for (i in 0..<5) {
                for (j in 0..<5) {
                    //si encuenta sitio vacio lo coloca ahi
                    if (estanteria[i][j] == null) {
                        estanteria[i][j] = bebida
                        bebidas.add(bebida)
                        println("la bebida esta ahi[$i][$j].")
                        return
                    }
                }
            }
            println("no hay espacio")
        }
    }

    fun eliminarBebida(id: Int) {
        val bebida = bebidas.find { it.id == id }
        if (bebida != null) {
            bebidas.remove(bebida)
            for (i in 0..<5) {
                //busca donde estaba la bebida y la quita de la estanteria
                for (j in 0..<5) {
                    if (estanteria[i][j]?.id == id) {
                        estanteria[i][j] = null
                        println("bebida quitada")
                        return
                    }
                }
            }
        } else {
            println("no exixte")
        }
    }


    fun verBebidas() {
        println("lista")
        for (bebida in bebidas) {
            //mira que bebida es y te pone los datos
            when (bebida) {
                is AguaMineral -> println("agua mineral - ID: ${bebida.id}, Marca: ${bebida.marca}, Litros: ${bebida.litros}, Precio: \$${bebida.precio}, Origen: ${bebida.origen}")
                is BebidasAzucaradas -> println("bebida azucarada - ID: ${bebida.id}, Marca: ${bebida.marca}, Litros: ${bebida.litros}, Precio: \$${bebida.precio}, Azúcar: ${bebida.azucar}g, Promoción: ${bebida.promocion}")
            }
        }
    }

    fun precioTotal(): Double {
        return bebidas.sumOf {
            //te hace descuento si esta en descuento
            if (it is BebidasAzucaradas && it.promocion) {
                it.precio * 0.9
            } else {
                it.precio
            }
        }
    }

    fun precioMarca(marca: String): Double {
        // te suma el precio de solo las bebidas de la maraca que mandes
        return bebidas.filter { it.marca == marca }.sumOf {
            if (it is BebidasAzucaradas && it.promocion) {
                it.precio * 0.9
            } else {
                it.precio
            }
        }
    }

    fun precioColumna(columna: Int): Double {
        return estanteria.sumOf {
            it[columna]?.let {
                if (it is BebidasAzucaradas && it.promocion) {
                    it.precio * 0.1
                } else {
                    it.precio
                }
            } ?: 0.0
        }
    }
}