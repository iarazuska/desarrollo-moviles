package ejer2

class BebidasAzucaradas(
    id: Int,
    litros: Double,
    precio: Double,
    marca: String,
    val azucar: Double,
    val promocion: Boolean
) : Bebidas(id, litros, precio, marca)