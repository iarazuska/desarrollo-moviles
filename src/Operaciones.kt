import com.sun.tools.javac.jvm.PoolConstant.LoadableConstant.Int
import java.nio.file.attribute.DosFileAttributes
import java.util.*

fun main() {
    array()
}

fun operaciones(){
    val a: Float=5f
    val b:Int=10

    println("suma es:" + (a+b))
    println("resta es:" + (a-b))
    println("multi es:" + (a*b))
    var resultado: Int =(a+b).toInt()
    println("division es:" + (a/b))
    println("resto es:" + (a%b))
    println(resultado)
}


fun prueba1(){

    val saludo ="hola me llamo"
    val nombre ="iara"

    println("$saludo $nombre")
}

fun prueba2(){
    val a1:String ="el resultado de"
    val b:Int=2
    val a2:String ="mas"
    val c:Int=5
    val a3:String="es:"
    var suma:Int=(b+c)

    println("$a1 $b $a2 $c $a3 $suma")

}

fun nombre(){
    val nombre:String="iara"
    val datos:String="me llamo"

    println("$datos $nombre")

}


fun apellido(){
    val apellido:String="zas"
    val datos:String="mi apellido es"

    println("$datos $apellido")

}

fun años(){
    val año:Int=21
    val datos:String="tengo"
    val datos2:String="años"

    println("$datos $año $datos2")

}

fun getMes(mes:Int){
    when(mes){
        1,2,3,4->{
            println("primer cuatri")
        }
        5,6,7,8->{
            println("segundo cuatri")
        }
        9,10,11,12->{
            println("tercer cuatri")
        }
    }
}

fun notificaciones(){
    val noti=-2

    if(noti>99){
        println("tienes "+ noti + "mensajes")
    } else{
        println("tienes " + noti + " tu telefono va a explotar")
    }
}

fun cine(edad:Int, lunes:Boolean){
    val niño:Double =5.4
    val adulto:Double=8.5
    val anciano:Double=5.0


    when(edad){
        in 0..12-> {
            println("esta entrada cuesta $niño " )
        }
        in 13..60-> {
            if(lunes) {
                println("esta entrada cuesta $adulto")
            }else{
                println("esta entrada cuesta 6.4")
            }
        }
        in 61..100-> {
            println("esta entrada cuesta $anciano" )
        }
    }
}

fun array(){
    val semana= arrayListOf<String>()
    semana.add("lunes")
    semana.add("martes")
    println(semana)
    println(semana[0])
    print(semana.get(1))

}







