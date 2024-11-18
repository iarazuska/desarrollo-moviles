package ejer2

import java.util.Scanner

fun main() {
    val almacen = Almacen()
    val scanner = Scanner(System.`in`)

    //crea el agua
    fun agregarAguaMineral() {
        println("pon los datos para Agua Mineral:")
        print("ID: ")
        val id = scanner.nextInt()
        print("litros: ")
        val litros = scanner.nextDouble()
        print("precio: ")
        val precio = scanner.nextDouble()
        print("marca: ")
        val marca = scanner.next()
        print("origen: ")
        val origen = scanner.next()

        val agua = AguaMineral(id = id, litros = litros, precio = precio, marca = marca, origen = origen)
        almacen.agregarBebida(agua)
    }

    //esto crea las bebidas
    fun agregarBebidaAzucarada() {
        println("pon los datos para Bebida Azucarada:")
        print("ID: ")
        val id = scanner.nextInt()
        print("litros: ")
        val litros = scanner.nextDouble()
        print("precio: ")
        val precio = scanner.nextDouble()
        print("marca: ")
        val marca = scanner.next()
        print("azúcar (g): ")
        val azucar = scanner.nextDouble()
        print("promoción? (true/false): ")
        val promocion = scanner.nextBoolean()

        val refresco = BebidasAzucaradas(id = id, litros = litros, precio = precio, marca = marca, azucar = azucar, promocion = promocion)
        almacen.agregarBebida(refresco)
    }

    //menu de opciones
    while (true) {
        println("\nSeleccione una opción:")
        println("1. añadir Agua Mineral")
        println("2. añadir Bebida Azucarada")
        println("3. ver bebidas en el almacén")
        println("4. calcular precio total de todas las bebidas")
        println("5. calcular precio total de una marca")
        println("6. calcular precio total de una columna")
        println("7. eliminar una bebida")
        println("8. salir")

        print("opción: ")
        when (scanner.nextInt()) {
            1 -> agregarAguaMineral()
            2 -> agregarBebidaAzucarada()
            3 -> almacen.verBebidas()
            4 -> println("precio total de todas las bebidas: \$${almacen.precioTotal()}")
            5 -> {
                print("pon la marca: ")
                val marca = scanner.next()
                println("precio total de $marca: \$${almacen.precioMarca(marca)}")
            }
            6 -> {
                print("pon el número de la columna: ")
                val columna = scanner.nextInt()
                println("precio total de la columna $columna: \$${almacen.precioColumna(columna)}")
            }
            7 -> {
                print("pon el ID de la bebida a eliminar: ")
                val id = scanner.nextInt()
                almacen.eliminarBebida(id)
            }
            8 -> {
                println("cerrando")
                break
            }
            else -> println("no existe esta opcion ")
        }
    }
}
