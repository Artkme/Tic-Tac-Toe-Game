package com.example.tic_tac_toegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.tic_tac_toegame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var player = "p1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun operationFunction(view: android.view.View) {

        when(view.id){
            R.id.b1 -> {
                buttonClicked(binding.b1)
            }
            R.id.b2 -> {
                buttonClicked(binding.b2)
            }
            R.id.b3 -> {
                buttonClicked(binding.b3)
            }
            R.id.b4 -> {
                buttonClicked(binding.b4)
            }
            R.id.b5 -> {
                buttonClicked(binding.b5)
            }
            R.id.b6 -> {
                buttonClicked(binding.b6)
            }
            R.id.b7 -> {
                buttonClicked(binding.b7)
            }
            R.id.b8 -> {
                buttonClicked(binding.b8)
            }
            R.id.b9 -> {
                buttonClicked(binding.b9)
            }
            R.id.resetButton -> {
                reset()
            }
        }
    }

    fun buttonClicked(btn: Button){
        if (btn.text == "") {
            if (player == "p1") {
                player = "p2"
                btn.text = "X"
            } else {
                player = "p1"
                btn.text = "O"
            }
        }
        win()
    }

    fun win(){
        val winnerTxt = findViewById<TextView>(R.id.winner_txtView)

        if((binding.b1.text == "X" && binding.b2.text == "X" && binding.b3.text == "X")
            || (binding.b4.text == "X" && binding.b5.text == "X" && binding.b6.text == "X")
            || (binding.b7.text == "X" && binding.b8.text == "X" && binding.b9.text == "X")
            || (binding.b1.text == "X" && binding.b4.text == "X" && binding.b7.text == "X")
            || (binding.b2.text == "X" && binding.b5.text == "X" && binding.b8.text == "X")
            || (binding.b3.text == "X" && binding.b6.text == "X" && binding.b9.text == "X")
            || (binding.b1.text == "X" && binding.b5.text == "X" && binding.b9.text == "X")
            || (binding.b3.text == "X" && binding.b5.text == "X" && binding.b7.text == "X")
        ){
            winnerToast("X won the game")
            disableButtons()
            winnerTxt.text = "X won the Game"
        }
        if((binding.b1.text == "O" && binding.b2.text == "O" && binding.b3.text == "O")
            || (binding.b4.text == "O" && binding.b5.text == "O" && binding.b6.text == "O")
            || (binding.b7.text == "O" && binding.b8.text == "O" && binding.b9.text == "O")
            || (binding.b1.text == "O" && binding.b4.text == "O" && binding.b7.text == "O")
            || (binding.b2.text == "O" && binding.b5.text == "O" && binding.b8.text == "O")
            || (binding.b3.text == "O" && binding.b6.text == "O" && binding.b9.text == "O")
            || (binding.b1.text == "O" && binding.b5.text == "O" && binding.b9.text == "O")
            || (binding.b3.text == "O" && binding.b5.text == "O" && binding.b7.text == "O")
        ){
            winnerToast("O won the game")
            disableButtons()
            winnerTxt.text = "O won the Game"
        }
        if (binding.b1.length() != 0 && binding.b2.length() != 0 && binding.b3.length() != 0
            && binding.b4.length() != 0 && binding.b5.length() != 0 && binding.b6.length() != 0
            && binding.b7.length() != 0 && binding.b8.length() != 0 && binding.b9.length() != 0){
            disableButtons()
            winnerTxt.text = "Draw"
            winnerToast("Draw")
        }
    }

    fun winnerToast(msg:String) {
        Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
    }

    fun reset(){
        binding.b1.text = ""
        binding.b2.text = ""
        binding.b3.text = ""
        binding.b4.text = ""
        binding.b5.text = ""
        binding.b6.text = ""
        binding.b7.text = ""
        binding.b8.text = ""
        binding.b9.text = ""
        player = "p1"
        enableButtons()
        val winnerTxt = findViewById<TextView>(R.id.winner_txtView)
        winnerTxt.text = ""

    }

    fun disableButtons() {
        binding.b1.isEnabled = false
        binding.b2.isEnabled = false
        binding.b3.isEnabled = false
        binding.b4.isEnabled = false
        binding.b5.isEnabled = false
        binding.b6.isEnabled = false
        binding.b7.isEnabled = false
        binding.b8.isEnabled = false
        binding.b9.isEnabled = false
    }

    fun enableButtons() {
        binding.b1.isEnabled = true
        binding.b2.isEnabled = true
        binding.b3.isEnabled = true
        binding.b4.isEnabled = true
        binding.b5.isEnabled = true
        binding.b6.isEnabled = true
        binding.b7.isEnabled = true
        binding.b8.isEnabled = true
        binding.b9.isEnabled = true
    }
}