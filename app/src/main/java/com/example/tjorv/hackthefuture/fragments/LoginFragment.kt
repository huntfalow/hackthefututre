package com.example.groep13ideaalduaal.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tjorv.hackthefuture.R
import com.example.tjorv.hackthefuture.activities.MainActivity
import kotlinx.android.synthetic.main.fragment_login.view.*


class LoginFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view: View = inflater.inflate(R.layout.fragment_login, container, false)

        val email = view.emailEditText
        val password = view.passwordEditText

        email.setText("pietlaureyns@hotmail.com") //TODO Hardcoded
        password.setText("password") //TODO Hardcoded

        val tilEmail = view.tilEmail
        val tilPassword = view.tilPassword



        return view
    }


}




