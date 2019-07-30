package com.example.tictactoeproject

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.dialog_endgame.*

class EndgameDialog: DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_endgame, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        yes_btn.setOnClickListener{
            activity?.finish()
            startActivity(Intent(context, MainActivity::class.java))
        }
        no_btn.setOnClickListener{
            activity?.finish()
            startActivity(Intent(context, HomepageActivity::class.java))
        }

        playAgain.text = arguments?.getString("msg")
    }
}
