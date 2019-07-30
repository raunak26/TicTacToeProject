package com.example.tictactoeproject

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MainController.restart()

        findViewById<Button>(R.id.btnMenu).setOnClickListener {
//            startActivity(Intent(this, MenuDialog::class.java))
            MenuDialog().show(supportFragmentManager, "")
        }
    }

    fun buClick(view: View) {
        val buSelected = view as Button
        var cellID = 0
        when (buSelected.id) {
            R.id.bu1 -> cellID = 1
            R.id.bu2 -> cellID = 2
            R.id.bu3 -> cellID = 3
            R.id.bu4 -> cellID = 4
            R.id.bu5 -> cellID = 5
            R.id.bu6 -> cellID = 6
            R.id.bu7 -> cellID = 7
            R.id.bu8 -> cellID = 8
            R.id.bu9 -> cellID = 9
        }

        playGame(cellID, buSelected)

    }

    var activePlayer = 1

    private fun playGame(cellID: Int, buSelected: Button) {

        if (activePlayer == 1) {
            buSelected.text = "X"
            buSelected.setBackgroundColor(Color.MAGENTA)
            MainController.player1move.add(cellID)
            activePlayer = 2
        } else {
            buSelected.text = "O"
            buSelected.setBackgroundColor(Color.GREEN)
            MainController.player2move.add(cellID)
            activePlayer = 1
        }

        buSelected.isEnabled = false

        MainController.checkWinner(this, supportFragmentManager)
    }
}
