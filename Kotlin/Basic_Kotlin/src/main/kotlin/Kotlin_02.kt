fun main(args: Array<String>) {
    val variable:Int = 45
    println(variable)

    val czyPada = true
    val result = if (czyPada) "TAK" else "NIE"
    println(result)

    val wrt = -15
    val result2 = if(wrt in -15..-10 || wrt in -5..0 || wrt in 5..10) "Belongs" else "Does not belong"
    println(result2)

}