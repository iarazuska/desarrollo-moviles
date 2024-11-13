package ejer2

class AguaMineral(
    id: Int,
    litros: Double,
    precio: Double,
    marca: String,
    val origen: String
): Bebidas(id, litros, precio,marca)