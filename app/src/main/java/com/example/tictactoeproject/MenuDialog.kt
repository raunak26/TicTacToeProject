package com.example.tictactoeproject

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.dialog_menu.*


class MenuDialog : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        resume_btn.setOnClickListener {
            dismiss() // dismisses the dialogue and keeps the game state
        }
        restart_btn.setOnClickListener {
            activity?.finish()
            startActivity(Intent(context, MainActivity::class.java))
        }
        quit_btn.setOnClickListener {
            startActivity(Intent(context, HomepageActivity::class.java))
        }
    }
}
