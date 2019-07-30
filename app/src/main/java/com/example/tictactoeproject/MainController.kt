package com.example.tictactoeproject

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentManager

object MainController {


    var player1move = ArrayList<Int>()
    var player2move = ArrayList<Int>()

    fun restart() {
        player1move = arrayListOf()
        player2move = arrayListOf()
    }

    fun checkWinner(context: Context, fragmentManager: FragmentManager) {
        var winner = -1

        //row1
        if (player1move.contains(1) && player1move.contains(2) && player1move.contains(3)) {
            winner = 1
        }
        if (player2move.contains(1) && player2move.contains(2) && player2move.contains(3)) {
            winner = 2
        }

        // row2
        if (player1move.contains(4) && player1move.contains(5) && player1move.contains(6)) {
            winner = 1
        }
        if (player2move.contains(4) && player2move.contains(5) && player2move.contains(6)) {
            winner = 2
        }

        //row 3
        if (player1move.contains(7) && player1move.contains(8) && player1move.contains(9)) {
            winner = 1
        }
        if (player2move.contains(7) && player2move.contains(8) && player2move.contains(9)) {
            winner = 2
        }

        //column1
        if (player1move.contains(1) && player1move.contains(4) && player1move.contains(7)) {
            winner = 1
        }
        if (player2move.contains(1) && player2move.contains(4) && player2move.contains(7)) {
            winner = 2
        }

        //column2
        if (player1move.contains(2) && player1move.contains(5) && player1move.contains(8)) {
            winner = 1
        }
        if (player2move.contains(2) && player2move.contains(5) && player2move.contains(8)) {
            winner = 2
        }

        //column3
        if (player1move.contains(3) && player1move.contains(6) && player1move.contains(9)) {
            winner = 1
        }
        if (player2move.contains(3) && player2move.contains(6) && player2move.contains(9)) {
            winner = 2
        }

        // right to left diagonal
        if (player1move.contains(1) && player1move.contains(5) && player1move.contains(9)) {
            winner = 1
        }
        if (player2move.contains(1) && player2move.contains(5) && player2move.contains(9)) {
            winner = 2
        }

        // left to right diagonal
        if (player1move.contains(3) && player1move.contains(5) && player1move.contains(7)) {
            winner = 1
        }
        if (player2move.contains(3) && player2move.contains(5) && player2move.contains(7)) {
            winner = 2
        }


        val endgameDialog = EndgameDialog()

        if ((player1move.contains(1) || player2move.contains(1)) && (player1move.contains(2) || player2move.contains(2))
            && (player1move.contains(3) || player2move.contains(3)) && (player1move.contains(4) || player2move.contains(4))
            && (player1move.contains(5) || player2move.contains(5)) && (player1move.contains(6) || player2move.contains(6))
            && (player1move.contains(7) || player2move.contains(7)) && (player1move.contains(8) || player2move.contains(8))
            && (player1move.contains(9) || player2move.contains(9)) && (winner == -1)) {

            Toast.makeText(context, "It's a tie!", Toast.LENGTH_LONG).show()
            endgameDialog.arguments = Bundle().apply{
                putString("msg", "It's a tie! Would you like to play again?")
            }
            endgameDialog.show(fragmentManager, "")
        }

        if (winner != -1) {
            if (winner == 1) {
                Toast.makeText(context, "Player 1 has won the game!", Toast.LENGTH_LONG).show()
                endgameDialog.arguments = Bundle().apply {
                    putString("msg", "Player 1 has won the game! Would you like to play again?")
                }
                endgameDialog.show(fragmentManager, "")
            }
            if (winner == 2) {
                Toast.makeText(context, "Player 2 has won the game!", Toast.LENGTH_LONG).show()
                endgameDialog.arguments = Bundle().apply{
                    putString("msg", "Player 2 has won the game! Would you like to play again?")
                }
                endgameDialog.show(fragmentManager, "")
            }
        }
    }
}
