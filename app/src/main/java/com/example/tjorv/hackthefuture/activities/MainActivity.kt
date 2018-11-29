package com.example.tjorv.hackthefuture.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.tjorv.hackthefuture.fragments.LoginFragment
import com.example.tjorv.hackthefuture.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Start de fragmentmanager die ervoor gaat zorgen dat de juiste fragment getoont wordt
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        //eerste fragment is momenteel homepage (zal login worden)
        val fragment = LoginFragment()

        fragmentTransaction.add(R.id.fragment_holder, fragment)
        fragmentTransaction.commit()


    }
}




