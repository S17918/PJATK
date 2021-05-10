import kotlin.math.pow

fun main(args: Array<String>) {
    val name = " Moczymorda"
    var healthPoints = 50
    val isBlessed = false
    val isImmortal = true
    val auraVisible = isBlessed && healthPoints >= 50 || isImmortal
    val karma = (Math.random().pow((110 - healthPoints) / 100.0) * 20).toInt()
    val colorVisible = if(karma in 16..20) "Zielonkawy" else if(karma in 11..15) "Purpurowy" else if(karma in 5..10) "Pomaranczowy" else "Czerwonawy"

    val healthStatus = healthStatus(healthPoints)

    if(auraVisible){
        println(colorVisible)
    }else{
        println("Brak")
    }

    println("$name $healthStatus")

}

private fun healthStatus(healthPoints: Int): String {
    val healthStatus = if (healthPoints == 100) {
        "cieszy sie swietnym zdrowiem"
    } else if (healthPoints >= 90) {
        "ma kilka drasniec"
    } else if (healthPoints >= 75) {
        "odniosl kilka pomniejszych ran"
    } else if (healthPoints >= 15) {
        "jest powaznie ranny"
    } else {
        "jest w oplakanym stanie!"
    }
    return healthStatus
}