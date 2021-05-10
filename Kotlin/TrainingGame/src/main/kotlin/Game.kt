fun main(args: Array<String>) {
    val name = "Maklowicz"
    var healthPoints = 80
    val isBlessed = true
    val isImmortal = false

    val auraStatus = checkPlayerStatus(isBlessed, healthPoints, isImmortal)

    /*val healthStatus =  if (healthPoints == 100)
                            "cieszy sie swietnym zdrowiem!"
                        else if (healthPoints in 90..99)
                            "ma kilka drascniec."
                        else if (healthPoints in 75..89)
                            if (isBlessed)
                                "odniosl kilka pomniejszych ran, ale szybko dochodzi do zdrowia!"
                            else
                                "odniosl kilka pomniejszych ran."
                        else if (healthPoints in 15..74)
                            "jest powaznie ranny."
                        else "jest w opłakanym stanie!"*/

    val healthStatus = checkHealthStatus(healthPoints, isBlessed)

    println("(Aura: $auraStatus) " +
            "(Poblogoslawiony: ${if(isBlessed) "TAK" else "NIE"})")
    println("$name $healthStatus")
    castFireball(5)
}

private fun checkPlayerStatus(
    isBlessed: Boolean,
    healthPoints: Int,
    isImmortal: Boolean
): String {
    val auraStatus = if (isBlessed && healthPoints > 50 || isImmortal) "Zielonkawa" else "Brak"
    return auraStatus
}

private fun checkHealthStatus(healthPoints: Int, isBlessed: Boolean) =
    when (healthPoints) {
        100 -> "cieszy sie swietnym zdrowiem!"
        in 90..99 -> "ma kilka drascniec."
        in 75..89 -> if (isBlessed) "odniosl kilka pomniejszych ran, ale szybko dochodzi do zdrowia!" else "odniosl kilka pomniejszych ran."
        in 15..74 -> "jest powaznie ranny."
        else -> "jest w opłakanym stanie!"
    }

private fun castFireball(numberFireBalls:Int = 2) =
    println("Nagle pojawila sie kula ognia! (x$numberFireBalls)")
