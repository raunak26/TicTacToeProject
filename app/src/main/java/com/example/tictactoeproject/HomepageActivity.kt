package com.example.tictactoeproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_homepage.*

class HomepageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        MainController.restart()

        onePlayer.setOnClickListener {  }

        twoPlayers.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

//        MenuDialog().show(supportFragmentManager, "")
    }
}
