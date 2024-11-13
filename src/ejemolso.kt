fun main(){
}

fun arrays(){
    val numeros= arrayOf(1,2,3,4,5)
    for(numeros in numeros){
        println(numeros)
    }
}

fun arrays2(){
    val numeros= arrayOf(1,2,3,4,5)
    for(i in numeros.indices){
        println("el elemento es indice de $i es ${numeros[i]}")
    }
}

