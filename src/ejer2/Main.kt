package ejer2

import java.util.Scanner

fun main() {
    val almacen = Almacen()
    val scanner = Scanner(System.`in`)


    fun agregarAguaMineral() {
        println("Ingrese los datos para Agua Mineral:")
        print("ID: ")
        val id = scanner.nextInt()
        print("Litros: ")
        val litros = scanner.nextDouble()
        print("Precio: ")
        val precio = scanner.nextDouble()
        print("Marca: ")
        val marca = scanner.next()
        print("Origen: ")
        val origen = scanner.next()

        val agua = AguaMineral(id = id, litros = litros, precio = precio, marca = marca, origen = origen)
        almacen.agregarBebida(agua)
    }

    // Función para crear y agregar una bebida de tipo BebidasAzucaradas
    fun agregarBebidaAzucarada() {
        println("Ingrese los datos para Bebida Azucarada:")
        print("ID: ")
        val id = scanner.nextInt()
        print("Litros: ")
        val litros = scanner.nextDouble()
        print("Precio: ")
        val precio = scanner.nextDouble()
        print("Marca: ")
        val marca = scanner.next()
        print("Azúcar (g): ")
        val azucar = scanner.nextDouble()
        print("¿Tiene promoción? (true/false): ")
        val promocion = scanner.nextBoolean()

        val refresco = BebidasAzucaradas(id = id, litros = litros, precio = precio, marca = marca, azucar = azucar, promocion = promocion)
        almacen.agregarBebida(refresco)
    }

    // Menú para seleccionar opciones
    while (true) {
        println("\nSeleccione una opción:")
        println("1. Agregar Agua Mineral")
        println("2. Agregar Bebida Azucarada")
        println("3. Mostrar bebidas en el almacén")
        println("4. Calcular precio total de todas las bebidas")
        println("5. Calcular precio total de una marca")
        println("6. Calcular precio total de una columna")
        println("7. Eliminar una bebida")
        println("8. Salir")

        print("Opción: ")
        when (scanner.nextInt()) {
            1 -> agregarAguaMineral()
            2 -> agregarBebidaAzucarada()
            3 -> almacen.verBebidas()
            4 -> println("Precio total de todas las bebidas: \$${almacen.precioTotal()}")
            5 -> {
                print("Ingrese la marca: ")
                val marca = scanner.next()
                println("Precio total de $marca: \$${almacen.precioMarca(marca)}")
            }
            6 -> {
                print("Ingrese el número de la columna: ")
                val columna = scanner.nextInt()
                println("Precio total de la columna $columna: \$${almacen.precioColumna(columna)}")
            }
            7 -> {
                print("Ingrese el ID de la bebida a eliminar: ")
                val id = scanner.nextInt()
                almacen.eliminarBebida(id)
            }
            8 -> {
                println("Saliendo del programa.")
                break
            }
            else -> println("Opción no válida, por favor intente de nuevo.")
        }
    }
}
