import java.util.*

fun main(){
    var a: Double = 5.55
    val b: Float = 25f
    val c: Long = 20L
    val d: Int = 21
    var e: Short = 12
    var f: Byte = 2
    var g: Char = 't'
    var h: Boolean = true

    var i: Double = 5.toDouble()
    var j: Long = 5.toLong()
    var k: Char = 5.toChar()

    val FORBIDDEN = 0
    val EXECUTE = 1
    val WRITE = 2
    val READ = 4

    fun checkPermissions(perms: Int) = perms and (READ or EXECUTE) == (READ or EXECUTE)

    println(checkPermissions(READ or EXECUTE or WRITE))
    println(checkPermissions(READ or WRITE))
    println(checkPermissions(READ))
    println(checkPermissions(FORBIDDEN))


    val original = "kot"
    var refs = original

    println(original)
    println(refs)
    println(original == refs)
    println(original === refs)

    refs = Scanner(System.`in`).use { it.next() }
    println(original == refs)
    println(original === refs)


    val months = """Styczeń, Luty, Marzec, Kwiecień, Maj, Czerwiec, 
                   |Lipiec, Sierpień, Wrzesień, Październik, Listopad, 
                   |Grudzień""".trimMargin()
    val monthsList = months.replace("\\s+".toRegex(), "").split(",").toList()
    for (month in 0 until monthsList.size) {
        print("${monthsList[month]} ")
    }
    println()
    for (month in monthsList) {
        if (month.startsWith("L")) print("$month ")
    }
    println()
    monthsList.forEachIndexed { i, month -> if (i % 2 == 0) print("$i.$month ") }
    println()
    val monthIterator = monthsList.iterator()
    while (monthIterator.hasNext()) {
        print("${monthIterator.next()} ")
    }
    println()
    fun rec(month: List<String>) {
        tailrec fun _rec(i: Int) {
            print("${month[i]} ")
            val nextI = i + 1
            if (nextI < month.size) _rec(nextI)
        }
        _rec(0)
    }
    rec(monthsList)
    println()

    println(monthsList.joinToString(separator = " "))
    val monthsString = monthsList
        .filter { !it.startsWith("P") }
        .map { it.replace('e', '_') }
        .map { "$it " }
        .forEach(::print)
    println(monthsString)

    val priceList = mapOf(
        "Banan" to 1.20,
        "Masło" to 4.99,
        "Chleb" to 4.50,
        "Herbata" to 6.00
    )
    val salesPriceList = priceList.mapValues { it.value * 0.80 }
    priceList.forEach { (product, price) ->
        println("%s - %.2f".format(product, price))
    }
    println()
    salesPriceList.forEach { (product, price) ->
        println("%s - %.2f".format(product, price))
    }

    fun printPrice(product: String) {
        val price: Double? = priceList[product]
        println("Cena produktu $product: ${price?.let { "%.2f zł".format(it) } ?: "Brak na stanie"}")
    }
    printPrice("Drożdże")
    printPrice("Masło")
}
