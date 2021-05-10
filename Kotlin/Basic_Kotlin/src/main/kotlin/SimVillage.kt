fun main(args: Array<String>) {
    val greetingFunction: (String) -> String = {
        val currentYear = 2021
        "Witamy w Wirtualnej Wiosce, $it! (copyright $currentYear)"
    }

    println(greetingFunction("Piotrek"))
}