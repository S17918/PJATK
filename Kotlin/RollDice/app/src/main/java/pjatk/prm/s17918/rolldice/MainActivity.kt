package pjatk.prm.s17918.rolldice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener{
            rollDice()
        }

    }

    private fun rollDice(){
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val text: TextView = findViewById(R.id.text)
        text.text = diceRoll.toString()
    }
}

class Dice(private val sides: Int){
    fun roll(): Int{return (1..sides).random()}
}
