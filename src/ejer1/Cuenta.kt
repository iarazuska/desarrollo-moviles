package ejer1

class Cuenta {
    var titular: String
    var cantidad: Double = 0.0

    constructor(titular: String, cantidad: Double = 0.0) {
        this.titular = titular
        this.cantidad = cantidad
    }


    constructor(titular: String) : this(titular, 0.0)


    fun ingresar(dinero: Double) {
        if (dinero > 0) {
            cantidad += dinero
        }
    }

    fun retirar(dinero: Double) {
        cantidad = if (cantidad - dinero < 0) 0.0 else cantidad - dinero
    }
}
